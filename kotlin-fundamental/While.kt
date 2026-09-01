fun main() {
    var count = 1

    while (count <= 5) {
        println("Count: $count")
        count++
    }

    // Output:
    // Count: 1
    // Count: 2
    // Count: 3
    // Count: 4
    // Count: 5

    var count = 1

    do {
        println("Count: $count")
        count++
    } while (count <= 5)
}
