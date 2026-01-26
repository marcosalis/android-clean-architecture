# `data:injection` module

This module isn't part of the project architecture nor should generally contain any code.
Its sole purpose is to "connect" the `app` module to `data` for initialization purposes.
By doing so, Dagger has access to `@Module`s declared within the data layer, and can inject the
dependencies contained within them into the `Application` class (or similar) to initialize them.
