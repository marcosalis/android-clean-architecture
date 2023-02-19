# Clean Architecture on Android: a pragmatic way
The purpose of this repository is to showcase, with a very simple (but hopefully clear) sample Android
project, how I get inspiration from Uncle Bob's [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html) 
to structure the application I work on.
This is a more updated fork of the [sample project](https://github.com/Teamwork/android-clean-architecture) 
I showcased while working for Teamwork a good few years ago.

**This is not a working demo app**: the only purpose of the classes in the project is to demonstrate 
how the dependency graphs work with the configuration explained below, and to illustrate which dependencies 
are typically involved in this type of architecture. The fact that the project compiles, as simple as it sounds,
is the demo you need!

Given that broad nature of the topic and the amount of implementation details necessary to implement 
a working production project, I have simplified the example as much as possible and focused solely on
the following areas:
- **Module structure:** each architecture layer has its own module, following closely the _Clean_ principles and naming.
- **Separation of layers**: how to configure Gradle making use of `api`/`implementation` to hide unwanted dependencies
- **Dependency Injection:** how to set up *Dagger 2* for a multi-module environment, but still ensuring the above points

## Requirements
There is no such thing as *"the best architecture"* when it comes to mobile applications: the best architecture
approach for a project (or team) always depends on a series of factors and assumptions.

This specific requirements, and, although it might not be the _silver bullet_ for every scenario, it
works well on a broad variety of project sizes and types, and could help you define your own architecture
or, at least, inspire you to think about it a bit more.

This solution (always subject to refinement and improvements) is based on the following principles:
- **Software craftsmanship.** Aim for applications to be fast, as bug-free as possible and always suiting
your users' needs: the only way to achieve that is to **ensure the quality and maintainability of code 
through the use of best practices**.
- **Software changes often.** Any architecture must support and facilitate change; providing a solid and
well crafted project structure helps keeping a codebase tidy, consistent and testable, separating concerns
and layers so that a change in one of them doesn't impact all others.
- **Code reusability.** Modularising components is the only way to ensure that code is reusable across 
projects, maximising bandwidth as a team and ensure that bug fixes and improvements are promptly delivered.
- **Almost no application is trivial.** Most applications contain non-trivial logic and/or an amount of
screens and use cases that justifies all of the above: **structuring code in a formal and clear way is essential**.
- **Applications should endure time.** nobody likes technical debt, and we should aim to never have to rewrite
the same software, using the same technologies, only because that code is broken.
- **Quick team scaling and developers onboarding.** Using a shared, well-defined architecture helps new 
developers in a team; using well known practices and conventions helps them get into a codebase faster.

## Modules
Listed below, a quick description of each module and a class diagram with their relationships.

### Modules relationships
The following diagram illustrates the above mentioned modules relationships in this sample project.
In order to support feature modules and (if properly configured) _Instant Apps_, the project's view/presentation
layer is split into three modules; this is not a requirement and it can be avoided for small projects.

![](docs/clean_app_architecture_v2.1.png)

### Modules description

| Module           | Description | Module dependencies (direct or indirect) | 
| ------------------| ----------- | -------------------------- | 
|  **entity**       | Business entities (the `Entity` layer in _Clean_) | _No dependencies_|
|  **data-bridge**  | "Bridge" module only used for the initialization of the `Data` layer. Prevents implementation details in the data layer from being accessible in the app module. | `data`, `data-access`, `entity`|
|  **data-access**  | The `Data Access` layer, interfaces for the business layer to access the data layer | `entity`|
|  **data**         | The `Data ` layer, which includes networking, caching and data delivery for the business layer to manipulate. Exposes via Dagger the `DataRepo` dependencies to the business layer | `data-access`, `entity`|
|  **business**     | Business layer, contains interactors and business logic (which can then exposed to the presentation layer if necessary). | `data-access`, `entity`|
|  **app-core**     | Core, base module for the view and presentation layer. Contains themes, styles, resources, strings and components that are used across apps and feature modules. | `business`, `entity`|
|  **app-feature1** | View and presentation module for a "big" feature. This can be then extracted to use with _Instant Apps_ if desired | `app-core`, `business`, `entity`|
|  **app**          | View and presentation layers for the _application module_ | `app-core`, `app-feature1`, `business`, `entity`, `data-bridge`|

## Google Android Architecture Samples
Google has done a very good job at producing a set of code examples in their [Android Architecture Blueprints](https://github.com/android/architecture-samples) 
repository.  I took inspiration from some of the patterns implemented there, but found that the examples are just too
simple and not suited for more complex applications.
More specifically:
- It is well suited for small projects, but the _"monolith module"_ approach doesn't scale well for medium/large applications
- The package-based separation of layers cannot be enforced at compile-time and is therefore very error-prone (especially when working in a big team)
- It is only a partial implementation of *Clean*: there is no real separation between presentation, data and business layer
(*view-model/presenter*, *repositories* and *use cases/entities*)
- It does not allow sharing code across applications

## Dependency Injection
Our *Gradle* modules use _the **Dagger**_ framework (and its Android extension) for dependency injection.
As an architectural choice to ensure encapsulation and enforce layer boundaries, the modules at lower layers
do not have access at compile time to the higher layers except its closest dependency (_see graph_ - e.g., 
the _presentation layer_ can only access the _business layer_, not the _data(-access) layer_).

Any exception to this rule must be explicitly declared and made available through a provision method
in a public *component*. Dagger doesn't work well with this kind of requirement out of the box when 
using _Subcomponents_, since it needs to have access at compile time to all of the implementation classes 
to build the dependency graph (which is what we want to avoid in the first place).

The sample project doesn't cover other useful _Dagger_ features such scopes and "feature" components; 
however, both can be easily plugged into our core project structure.

### Components relationships
The following diagram illustrates the dependencies between components in the sample project.
Notice how all dependency/inheritance arrows point to the `business` layer. The `entity` layer does
not need a component as it mainly comprises pure entity objects and business logic.

![](docs/clean_app_architecture_components_v2.1.png)

### Goals
In order to allow using _Dagger_ with our encapsulation constraints, we ensure that:

#### Each layer owns its Dagger component
Each Dagger `Component` is `internal`, and it is created and initialized within the module itself, so
that each dependency graph is only fully visible inside the module. This guarantees encapsulation and 
allows us to declare both classes and the bound interfaces as `internal` if we don't want to provide 
access to them outside of the module.
Modules and dependencies are, by default, _only accessible by components in the same layer_.

#### Each layer's Dagger component inherits a public plain interface
This interface only includes the dependencies that we want to expose outside of the module, e.g.:
```
interface BusinessComponent {
    // provision methods for dependencies exposed to the presentation layer
}

@Component
internal interface InternalBusinessComponent : BusinessComponent
```

```
interface DataAccessComponent { // in the `data-access` module
    // provision methods for data layer dependencies exposed to the business layer
}

@Component // in the `data` module
internal interface DataComponent : DataAccessComponent
```

By doing so, we also encapsulate the usage of Dagger within the module itself, without forcing external
"client code" to use the framework, and simplifying injecting a mock of the whole component for testing when needed.

#### Dependencies between layers are fully managed by Dagger
Each layer which has a direct dependency to a component from another layer, will declare so in its 
Dagger component as a [component dependency](https://dagger.dev/api/2.25.2/dagger/Component.html#dependencies):
```
@Component(modules = [...], dependencies = [DataAccessComponent::class])
internal interface InternalBusinessComponent : BusinessComponent
```

#### Component Factory
Dagger has introduced [component factories](https://dagger.dev/api/2.25.2/dagger/Component.Factory.html),
which allow (sub)components to provide an interface, annotated with `@Component.Factory` (or `@Subcomponent.Factory`).
The interface provides a single function, which contains dependencies (modules, components or any other) 
that the `Component` requires at dependency graph creation.
We use component factories to pass the components which are dependencies in the layer we are initialising,
along with other classes that might be passed on from lower level layers (e.g. the application `Context`) 
with [@BindsInstance](https://dagger.dev/api/2.25.2/dagger/BindsInstance.html).
```
@Component(..., dependencies = [DataAccessComponent::class])
internal interface InternalBusinessComponent : BusinessComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context,
                   dataAccessComponent: DataAccessComponent
        ): InternalBusinessComponent
    }
}
```

#### Initialization
**Note: initialization code is ugly!** The sample provides the simplest way to kick off the dependency
graphs for each component and trigger initialization of dependencies that require it at application startup.
Each project could require a different approach, the only requirement here is to follow the same layer
initialisation order shown below.

The trigger for the initialization process is, as usual, the `Application.onCreate()` method.
In order to provide layer-specific initialization on each module, the sample provides a `SampleBusinessApplication`
abstract class in the business layer, and a `SampleApplication` class, usually in the application module.
These classes provide callbacks to initialize the layers' components (in this order):
```
initializeDataComponent()
val businessComponent: BusinessComponent = initializeBusinessComponent()
initializeAppComponent(businessComponent) // the presentation/view layers need the business layer to be initialized
```

##### The `data-bridge` module
In order to fulfill the desired level of encapsulation dictated by *Clean Architecture*, the `data` layer
is not directly accessible from other layers (and modules), and it is used by the business layer through
the `data-access` layer.
The `data-bridge` only purpose is to temporarily "break" the dependency inversion rule at initialization
time to provide a `DataBridgeInitializer`; this is accessed by the application module to call to the `data`
layer and trigger the Dagger dependency graph initialization for `DataComponent`.

##### Initialization steps
- **`data` layer** through the `data-bridge` module: `DataBridgeInitializer` calls to `DataLayerInitializer`,
which executes the component factory's `create()` method for `DataComponent` and sets the singleton instance
into `DataComponent.INSTANCE` and `DataAccessComponent.INSTANCE` (for access from the `business` layer)
- **`business` layer:** `BusinessLayerInitializer`, called by `SampleBusinessApplication`, which executes the
component factory's `create()` method for `BusinessInternalComponent` and sets the singleton instance into
`BusinessInternalComponent.INSTANCE` (`DataAccessComponent.INSTANCE` is passed to `create()`)
- **`presentation/view` layer:** `initializeAppComponent(businessComponent)` is called, and the
`ApplicationComponent.create()` factory method is executed

Once all the Dagger dependency graphs are created, the application can then move on to the rest of its initialization process.

### Dependency Injection: example
**Note:** this section is intentionally verbose and requires you to go through the code while reading.
You can probably skip it if you are already familiar with _Dagger_.

We have three separate public Dagger `Component`s in our codebase: `ApplicationComponent` (view/presentation layer),
`BusinessComponent` and `DataAccessComponent`. These are declared in the corresponding layer's module
to make sure that the Dagger annotation processor and compiler have access to all the required dependencies
from the generated provider classes.

Let's take our `Feature2DetailsPresenter` example and follow its dependencies from the bottom-up in the
architecture hierarchy:

#### Presentation layer
- When the default activity `Feature2DetailsActivity` is created, an injector method is called in the `onCreate()`
- An instance of `Feature2DetailsPresenter` must be created: the class has an `@Inject` constructor that Dagger uses to instantiate it
- `Feature2DetailsInteractor` is required by the constructor: we need to access the class provider, which is declared in `BusinessComponent`
- A named `GLOBAL_COMPUTATION_EXECUTOR` is also injected in the constructor. Note that this is provided by `BusinessComponent` but exposed all the way from `DataAccessComponent` (this kind of transitive dependency is sometimes useful)

#### Business layer
- `BusinessComponent` exposes `Feature2DetailsInteractor` via a provision method (`feature2DetailsInteractor()`)
- Interactor bindings between interface and concrete implementation are declared in `InteractorsBindingModule` (`Feature2DetailsInteractor` binds to `Feature2DetailsInteractorImpl`)
- The bound implementation `Feature2DetailsInteractorImpl` has dependencies from the data access layer: `Entity1Repo` is one of those
- `Feature2DetailsInteractorImpl` also requires `InternalInteractor`, which is bound in `InteractorsBindingModule`, but *not* exposed in `BusinessComponent` (but available in `InternalBusinessComponent`)

#### Data (Access) layers
- The Dagger component `DataComponent` extends from the `DataAccessComponent`: all the provision methods for data access layer classes which are needed in the business layer are available here
- `DataAccessComponent` exposes the needed provision method: `entity1Repo(): Entity1Repo`
- `SampleDataComponent` includes `DataRepoBindingModule`, which, finally, contains the binding method which provides an instance of `Entity1RepoImpl` for the `Entity1Repo` interface

## Other references
- Fabio Collini's excellent article [Implementing Dependency Inversion using Dagger components](https://medium.com/google-developer-experts/implementing-dependency-inversion-using-dagger-components-d6b0fb3b6b5e)
- Fabio Collini's presentation on [SOLID and Clean Architecture on Android](https://www.youtube.com/watch?v=GlDsfq3xHvo)

## License

    Copyright 2022 - Marco Salis
    Copyright 2018 - Teamwork.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
