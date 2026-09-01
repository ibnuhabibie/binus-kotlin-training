class Outer {
    val name = "Outer"

    inner class Inner {
        fun printName() = println(name) // Can access 'name'
    }
}
