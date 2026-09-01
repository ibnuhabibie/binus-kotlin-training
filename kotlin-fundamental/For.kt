fun main() {
    // Loop through a range
    for (i in 1..5) {
        println(i)
    }
    // Output: 1 2 3 4 5

    // Loop through an array
    val students = arrayOf("Ibnu", "Budi", "Andi")

    for (student in students) {
        println(student)
    }

    // Using until (end is excluded)
    for (i in 0 until 5) {
        println(i)
    }
    // Output: 0 1 2 3 4

    // Loop backwards
    for (i in 5 downTo 1) {
        println(i)
    }

    // Using step
    for (i in 0..10 step 2) {
        println(i)
    }
    // Output: 0 2 4 6 8 10
}
