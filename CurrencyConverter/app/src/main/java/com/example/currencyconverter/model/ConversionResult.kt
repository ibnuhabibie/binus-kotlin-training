package com.example.currencyconverter.model

data class ConversionResult(
    val from: String,
    val to: String,
    val amount: Double,
    val rate: Double?,
    val result: Double
)