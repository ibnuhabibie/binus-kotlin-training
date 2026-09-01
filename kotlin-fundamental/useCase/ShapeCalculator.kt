fun calculateTriangleArea(base: Double, height: Double): Double {
    return 0.5 * base * height
}

fun calculateSquareArea(side: Double): Double {
    return side * side
}

fun calculateRectangleArea(length: Double, width: Double): Double {
    return length * width
}

fun main() {
    var isRunning = true

    while (isRunning) {
        println()
        println("========================")
        println("     Shape Calculator")
        println("========================")
        println("1. Triangle")
        println("2. Square")
        println("3. Rectangle")
        println("4. Exit")
        print("Choose: ")

        val choice = readlnOrNull()?.toIntOrNull()

        when (choice) {
            1 -> {
                print("Enter base: ")
                val base = readln().toDouble()

                print("Enter height: ")
                val height = readln().toDouble()

                val area = calculateTriangleArea(base, height)

                println("Triangle Area: $area")
            }

            2 -> {
                print("Enter side: ")
                val side = readln().toDouble()

                val area = calculateSquareArea(side)

                println("Square Area: $area")
            }

            3 -> {
                print("Enter length: ")
                val length = readln().toDouble()

                print("Enter width: ")
                val width = readln().toDouble()

                val area = calculateRectangleArea(length, width)

                println("Rectangle Area: $area")
            }

            4 -> {
                println("Thank you for using Shape Calculator!")
                isRunning = false
            }

            else -> {
                println("Invalid choice. Please try again.")
            }
        }
    }
}
