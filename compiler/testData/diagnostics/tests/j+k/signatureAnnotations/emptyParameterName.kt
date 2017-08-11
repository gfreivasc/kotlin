// FILE: A.java
import kotlin.internal.*;

class A {
    public void emptyName(@ParameterName(name = "") String first, @ParameterName(name = "ok") int second) {
    }

    public void missingName(@ParameterName() String first) {
    }

    public void numberName(@ParameterName(name = 42) String first) {
    }
}

// FILE: test.kt
fun main() {
    val test = A()
    test.emptyName("first", 42)
    test.emptyName("first", <!NAMED_ARGUMENTS_NOT_ALLOWED!>ok<!> = 42)

    test.missingName(<!NAMED_ARGUMENTS_NOT_ALLOWED!>`first`<!> = "arg")
    test.missingName("arg")

    test.numberName("first")
}