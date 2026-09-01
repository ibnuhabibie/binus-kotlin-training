// Lambda stored in a variable
val greet = { name: String ->
    "Hello, $name!"
}

fun main() {
    println(greet("Ibnu"))
    // Hello, Ibnu


    // Lambda as a function parameter
    val numbers = arrayOf(1, 2, 3, 4, 5)

    numbers.forEach { number ->
        println(number)
    }


    // Lambda with a return value
    val doubled = numbers.map { number ->
        number * 2
    }

    println(doubled)
    // [2, 4, 6, 8, 10]
}
