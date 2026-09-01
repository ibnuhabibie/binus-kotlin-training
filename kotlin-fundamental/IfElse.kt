fun main() {
    val age = 20

    // Basic if
    if (age >= 18) {
        println("Adult")
    }

    // if - else
    if (age >= 18) {
        println("Adult")
    } else {
        println("Minor")
    }

    // else if
    if (age >= 18) {
        println("Adult")
    } else if (age >= 13) {
        println("Teenager")
    } else {
        println("Child")
    }

    // Nested if
    if (age >= 18) {
        if (age >= 21) {
            println("21 or older")
        } else {
            println("18-20")
        }
    }

    // if as an expression
    val status = if (age >= 18) "Adult" else "Minor"
    println(status)
}
