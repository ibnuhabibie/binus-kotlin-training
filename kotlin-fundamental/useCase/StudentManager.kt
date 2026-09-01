data class Student(
    val id: Int,
    var name: String,
    var age: Int,
    var score: Double
)

val students = mutableListOf<Student>()
var nextId = 1

fun addStudent() {
    print("Enter name: ")
    val name = readln()

    print("Enter age: ")
    val age = readln().toInt()

    print("Enter score: ")
    val score = readln().toDouble()

    val student = Student(
        id = nextId,
        name = name,
        age = age,
        score = score
    )

    students.add(student)
    nextId++

    println("Student added successfully!")
}

fun showStudents() {
    if (students.isEmpty()) {
        println("No students found.")
        return
    }

    println("\n--- Student List ---")

    for (student in students) {
        println(
            "ID: ${student.id} | " +
                    "Name: ${student.name} | " +
                    "Age: ${student.age} | " +
                    "Score: ${student.score}"
        )
    }
}

fun updateStudent() {
    print("Enter student ID: ")
    val id = readln().toInt()

    val student = students.find { it.id == id }

    if (student == null) {
        println("Student not found.")
        return
    }

    print("Enter new name: ")
    student.name = readln()

    print("Enter new age: ")
    student.age = readln().toInt()

    print("Enter new score: ")
    student.score = readln().toDouble()

    println("Student updated successfully!")
}

fun deleteStudent() {
    print("Enter student ID: ")
    val id = readln().toInt()

    val student = students.find { it.id == id }

    if (student == null) {
        println("Student not found.")
        return
    }

    students.remove(student)

    println("Student deleted successfully!")
}

fun main() {
    var isRunning = true

    while (isRunning) {
        println()
        println("========================")
        println("     Student Manager")
        println("========================")
        println("1. Add Student")
        println("2. Show Students")
        println("3. Update Student")
        println("4. Delete Student")
        println("5. Exit")
        print("Choose: ")

        val choice = readlnOrNull()?.toIntOrNull()

        when (choice) {
            1 -> addStudent()
            2 -> showStudents()
            3 -> updateStudent()
            4 -> deleteStudent()

            5 -> {
                println("Goodbye!")
                isRunning = false
            }

            else -> {
                println("Invalid choice. Please try again.")
            }
        }
    }
}
