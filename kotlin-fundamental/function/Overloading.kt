fun add(a: Int, b: Int): Int {
    return a + b
}

fun add(a: Double, b: Double): Double {
    return a + b
}

fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun main() {
    println(add(10, 20))       // 30
    println(add(10.5, 20.5))   // 31.0
    println(add(10, 20, 30))   // 60
}
