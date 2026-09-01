open class BaseViewModel {
    fun logError(msg: String) {
        println(msg)
    }
}

class HomeViewModel : BaseViewModel() // Inherits logError
