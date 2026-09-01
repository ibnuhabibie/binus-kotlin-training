fun main() {
    val score = 85

    // Basic when
    when (score) {
        100 -> println("Perfect!")
        85 -> println("Excellent!")
        70 -> println("Good")
        else -> println("Keep learning!")
    }

    // Multiple values
    val day = 2

    when (day) {
        1, 2, 3, 4, 5 -> println("Weekday")
        6, 7 -> println("Weekend")
        else -> println("Invalid day")
    }

    // when with conditions
    val age = 20

    when {
        age < 13 -> println("Child")
        age < 18 -> println("Teenager")
        else -> println("Adult")
    }

    // when as an expression
    val status = when {
        score >= 75 -> "Pass"
        else -> "Fail"
    }

    println(status) // Pass
}
