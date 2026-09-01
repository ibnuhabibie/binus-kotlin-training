fun main() {
    val number: Int = 100

    // ❌ Cannot automatically convert Int to Long
    // val longNumber: Long = number

    // ✅ Explicit conversion
    val longNumber: Long = number.toLong()
    val doubleNumber: Double = number.toDouble()
    val text: String = number.toString()

    println(longNumber)   // 100
    println(doubleNumber) // 100.0
    println(text)         // "100"
}
