package com.example.foodbank.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Foodbank(
    val name: String,
    @SerialName("alt_name") val altName: String? = null,
    val slug: String,
    @SerialName("phone") val phone: String? = null,
    @SerialName("email") val email: String? = null,
    @SerialName("address") val address: String? = null,
    @SerialName("postcode") val postcode: String? = null,
    @SerialName("lat_lng") val latLng: String? = null,
    @SerialName("web") val web: String? = null,
    @SerialName("charity_number") val charityNumber: String? = null,
    @SerialName("charity_register_url") val charityRegisterUrl: String? = null,
    @SerialName("shopping_list_url") val shoppingListUrl: String? = null,
    val network: String? = null,
    @SerialName("created_at") val createdAt: String? = null,
    val urls: FoodbankUrls? = null
)

@Serializable
data class FoodbankUrls(
    @SerialName("self") val self: String? = null,
    @SerialName("html") val html: String? = null
)