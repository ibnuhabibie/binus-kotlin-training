fun greet(
    name: String,
    greeting: String = "Hello",
    punctuation: String = "!"
) {
    println("$greeting, $name$punctuation")
}

fun main() {
    // Using default values
    greet("Ibnu")
    // Hello, Ibnu!

    // Override the default value
    greet("Ibnu", "Hi")
    // Hi, Ibnu!

    // Using named arguments
    greet(
        name = "Ibnu",
        punctuation = "."
    )
    // Hello, Ibnu.
}
