package com.example.foodbank.core.service

import com.example.foodbank.core.network.KtorClient
import com.example.foodbank.model.Foodbank
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class FoodBankAPI(
    private val client: HttpClient = KtorClient.client,
    private val baseUrl: String = "https://www.givefood.org.uk",
) {

    suspend fun getAllFoodBanks(): List<Foodbank> {
        return client.get("$baseUrl/api/2/foodbanks/").body()
    }
}