# `ktx`: base Kotlin extensions module

This module, despite not being part of the project architecture, is shared across all other modules.
It serves as a container for general-purpose, pure Kotlin code (not JVM-dependent) to avoid code
repetition. It will mainly contain (extension) functions and constants that don't belong to a single
architecture layer and don't depend on any framework (except Kotlin standard and coroutines) or
library.