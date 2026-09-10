package com.example.foodbank.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodbank.core.service.FoodBankAPI
import com.example.foodbank.model.Foodbank
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import kotlin.time.Duration

class FoodBankViewModel(
    private val api: FoodBankAPI = FoodBankAPI()
) : ViewModel() {

    private var searchJob: Job? = null

    private val _uiState = MutableStateFlow<FoodBankUIState>(FoodBankUIState.Idle)
    private val _selectedFoodBank = MutableStateFlow<Foodbank?>(null)
    private var _foodbanks = emptyList<Foodbank>()

    val uiState: StateFlow<FoodBankUIState> = _uiState.asStateFlow()
    val selectedFoodBank = _selectedFoodBank.asStateFlow()

    init {
        getAllFoodbanks()
    }

    fun onSelect(data: Foodbank) {
        _selectedFoodBank.value = data
    }


    fun onSearch(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(2000)

            val filteredList = if (query.isBlank()) {
                _foodbanks
            } else {
                _foodbanks.filter {
                    it.name.contains(query, false)
                }
            }

            Log.d("FoodBank", "Size: ${filteredList.size}")

            _uiState.value = FoodBankUIState.Success(filteredList)
        }

    }

    fun getAllFoodbanks() {
        _uiState.value = FoodBankUIState.Loading

        viewModelScope.launch {
            try {
                Log.d("FoodBank", "getAllFoodbanks")
                val response = api.getAllFoodBanks()
                Log.d("FoodBank", response.toString())

                _foodbanks = response

                _uiState.value = FoodBankUIState.Success(response)
            } catch (e: Exception) {
                _uiState.value =
                    FoodBankUIState.Error(e.localizedMessage ?: "Network error occurred")
            }
        }
    }
}