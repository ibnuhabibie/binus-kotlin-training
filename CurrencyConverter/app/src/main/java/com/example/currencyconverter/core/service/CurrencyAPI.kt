package com.example.currencyconverter.core.service

import com.example.currencyconverter.core.network.KtorHttpClient
import com.example.currencyconverter.model.dto.ConvertResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders

class CurrencyAPI (
    private val client: HttpClient = KtorHttpClient.client,
    private val baseUrl: String = "https://api.exchangeratesapi.com.au",
    private val apiKey: String = "doonan_59cc909b0e9f557ec569507a96e0fda7" // Tip: Replace with BuildConfig.API_KEY
) {
    suspend fun convertCurrency(
        from: String,
        to: String,
        amount: Double
    ): ConvertResponseDto {
        return client.get("$baseUrl/convert") {
            header(HttpHeaders.Authorization, "Bearer $apiKey")

            parameter("from", from)
            parameter("to", to)
            parameter("amount", amount)
        }.body()
    }
}