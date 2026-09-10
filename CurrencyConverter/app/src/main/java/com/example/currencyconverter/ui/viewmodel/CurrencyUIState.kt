package com.example.currencyconverter.ui.viewmodel

import com.example.currencyconverter.model.ConversionResult

sealed interface ConvertUiState {
    object Idle : ConvertUiState
    object Loading : ConvertUiState
    data class Success(val result: ConversionResult) : ConvertUiState
    data class Error(val message: String) : ConvertUiState
}