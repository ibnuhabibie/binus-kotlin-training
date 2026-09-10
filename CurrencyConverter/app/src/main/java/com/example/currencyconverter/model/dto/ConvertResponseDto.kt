package com.example.currencyconverter.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConvertResponseDto(
    @SerialName("success")
    val success: Boolean,

    @SerialName("query")
    val query: ConvertQueryDto? = null,

    @SerialName("info")
    val info: ConvertInfoDto? = null,

    @SerialName("date")
    val date: String? = null,

    @SerialName("result")
    val result: Double? = null,

    @SerialName("error")
    val error: ApiErrorDto? = null
)

@Serializable
data class ConvertQueryDto(
    @SerialName("from")
    val from: String,

    @SerialName("to")
    val to: String,

    @SerialName("amount")
    val amount: Double
)

@Serializable
data class ConvertInfoDto(
    @SerialName("timestamp")
    val timestamp: Long? = null,

    @SerialName("rate")
    val rate: Double? = null
)

@Serializable
data class ApiErrorDto(
    @SerialName("code")
    val code: Int? = null,

    @SerialName("info")
    val info: String? = null
)