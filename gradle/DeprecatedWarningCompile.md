### Suppress “marked for removal” warnings (Gradle)

This configuration must be added to `build.gradle`.  
It applies to all Java compile tasks and suppresses compiler warnings for APIs
that are deprecated and marked for removal, without changing the configured
Java version.

```gradle
tasks.withType(JavaCompile).configureEach {
    options.compilerArgs += ["-Xlint:-removal"]
}
```
<img width="1793" height="186" alt="image" src="https://github.com/user-attachments/assets/4f2e769d-e429-4842-a3cd-99b9b4036f23" />














