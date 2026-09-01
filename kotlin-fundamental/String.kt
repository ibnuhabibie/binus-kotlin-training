fun main() {
    // 1. String Concatenation
    val firstName = "Ibnu"
    val lastName = "Habibie"

    val fullName = firstName + " " + lastName
    println(fullName) // Ibnu Habibie


    // 2. Special Characters
    val message = "Hello\nKotlin\tWorld"
    println(message)

    // Output:
    // Hello
    // Kotlin    World


    // 3. Multiline String
    val text = """
        Hello Kotlin
        Welcome to the training
        Let's start coding!
    """.trimIndent()

    println(text)


    // 4. String Template
    val name = "Ibnu"
    val age = 30

    println("My name is $name and I am $age years old.")
    println("Next year I will be ${age + 1}.")


    // 5. String Formatting
    val score = 95.5

    val result = String.format(
        "Name: %s, Score: %.1f",
        name,
        score
    )

    println(result)
    // Name: Ibnu, Score: 95.5
}
