fun main() {
    var name: String? = null

    // Safe call
    println(name?.length)
    // Output: null

    // Elvis operator
    val length = name?.length ?: 0
    println(length)
    // Output: 0

    // Assign a value
    name = "Ibnu"

    // Safe call
    println(name?.length)
    // Output: 4

    // Elvis operator
    val displayName = name ?: "Guest"
    println(displayName)
    // Output: Ibnu

    // Non-null assertion
    val username: String? = "Ibnu"
    println(username!!.length)
    // Output: 4
}
