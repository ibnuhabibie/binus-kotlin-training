sealed class NetworkResult {
    data object Loading : NetworkResult()
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String) : NetworkResult()
}
