abstract class Animal {
    abstract fun makeSound() // Must be implemented by children
}

class Dog : Animal() {
    override fun makeSound() = println("Woof!")
}
