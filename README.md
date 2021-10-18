# Approvals-Kt
Helper functions for making ![Approvals-Java](https://github.com/approvals/ApprovalTests.Java) more Kotlin-friendly


## Usage

### Verify using Approvals-Kt
```kotlin
import com.github.greghynds.approvals.KotlinApprovals.verify

val foo: Any = Foo(123, "hello, world")

verify(foo)
```    

### Verify using Approvals-Java
```kotlin 
import org.approvaltests.Approvals.verify
import com.github.greghynds.approvals.toPrintableString

val foo: Any = Foo(123, "hello, world").toPrintableString()

verify(foo)

```



## Installing
Approvals-Kt is available on [JitPack](https://jitpack.io). To include it in your project, add the following line to your `build.gradle`:

```gradle
dependencies {
    testImplementation 'com.github.greghynds:approvals-kt:0.0.5'
    testImplementation "com.approvaltests:approvaltests:12.1.1"
}
```

## Building
The project can be built by navigating to the root directory and running:

```./gradlew clean build ```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
GNU General Public License v3.0
