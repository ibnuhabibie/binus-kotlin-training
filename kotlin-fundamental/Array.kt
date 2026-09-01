fun main() {
    val fruits = arrayOf("Apple", "Banana", "Orange")

    // Access an element
    println(fruits[0]) // Apple
    println(fruits[1]) // Banana

    // Change an element
    fruits[1] = "Mango"

    // Get array size
    println(fruits.size) // 3

    // Loop through the array
    for (fruit in fruits) {
        println(fruit)
    }

    // With Constructor
    val numbers = Array(5) { index -> index + 1 }

    println(numbers.contentToString())
    // [1, 2, 3, 4, 5]

    data class Student(
        val name: String,
        val age: Int
    )

    val students = arrayOf(
        Student("Ibnu", 30),
        Student("Budi", 25),
        Student("Andi", 22)
    )

    // Access an object
    println(students[0].name) // Ibnu
    println(students[1].age)  // 25

    // Loop through the array
    for (student in students) {
        println("${student.name} - ${student.age}")
    }
}
