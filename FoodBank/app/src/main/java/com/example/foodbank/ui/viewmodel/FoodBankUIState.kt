package com.example.foodbank.ui.viewmodel

import com.example.foodbank.model.Foodbank

sealed interface FoodBankUIState {
    object Idle : FoodBankUIState
    object Loading : FoodBankUIState
    data class Success(val result: List<Foodbank>) : FoodBankUIState
    data class Error(val message: String) : FoodBankUIState
}