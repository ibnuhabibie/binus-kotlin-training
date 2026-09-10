package com.example.currencyconverter.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.currencyconverter.core.service.CurrencyAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.model.ConversionResult
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val apiService: CurrencyAPI = CurrencyAPI()
) : ViewModel() {
    var fromCurrency = MutableStateFlow("")
    var toCurrency = MutableStateFlow("")
    var amountInput = MutableStateFlow("1.0")

    private val _uiState = MutableStateFlow<ConvertUiState>(ConvertUiState.Idle)

    val uiState: StateFlow<ConvertUiState> = _uiState.asStateFlow()

    fun onFromCurrencyChanged(newVal: String) {
        fromCurrency.value = newVal
    }

    fun onToCurrencyChanged(newVal: String) {
        toCurrency.value = newVal
    }

    fun onAmountChanged(newVal: String) {
        amountInput.value = newVal
    }

    fun convertCurrency() {
        val amount = amountInput.value.replace(',', '.').toDoubleOrNull()

        if (amount == null || amount <= 0.0) {
            _uiState.value = ConvertUiState.Error("Please enter a valid amount")
            return
        }

        viewModelScope.launch {
            _uiState.value = ConvertUiState.Loading

            try {
                val response = apiService.convertCurrency(
                    from = fromCurrency.value,
                    to = toCurrency.value,
                    amount = amount
                )

                if (response.success && response.result != null && response.info?.rate != null) {
                    _uiState.value = ConvertUiState.Success(
                        ConversionResult(
                            from = fromCurrency.value,
                            to = toCurrency.value,
                            amount = amount,
                            rate = response.info.rate,
                            result = response.result
                        )
                    )
                } else {
                    val errorMsg = response.error?.info ?: "Conversion failed"
                    _uiState.value = ConvertUiState.Error(errorMsg)
                }
            } catch (e: Exception) {
                _uiState.value =
                    ConvertUiState.Error(e.localizedMessage ?: "Network error occurred")
            }
        }
    }
}