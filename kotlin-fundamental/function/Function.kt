fun greet(name: String): String {
    return "Hello, $name!"
}

// Only accessible within this file
private fun calculateSecret() {
    println("Secret")
}

// Accessible within the same module
internal fun calculateTotal() {
    println("Total")
}

fun main() {
    val message = greet("Ibnu")
    println(message)
}
