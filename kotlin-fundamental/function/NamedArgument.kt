fun createUser(
    name: String,
    age: Int,
    isActive: Boolean
) {
    println("$name, $age, $isActive")
}

fun main() {
    // Using positional arguments
    createUser("Ibnu", 30, true)

    // Using named arguments
    createUser(
        name = "Ibnu",
        age = 30,
        isActive = true
    )

    // Arguments can be written in a different order
    createUser(
        isActive = true,
        name = "Ibnu",
        age = 30
    )
}
