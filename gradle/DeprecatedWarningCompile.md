### Suppress “marked for removal” warnings (Gradle)

This configuration must be added to `build.gradle`.  
It applies to all Java compile tasks and suppresses compiler warnings for APIs
that are deprecated and marked for removal, without changing the configured
Java version.

```gradle
tasks.withType(JavaCompile).configureEach {
    options.compilerArgs += ["-Xlint:-removal"]
}













