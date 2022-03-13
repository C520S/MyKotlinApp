package com.example.myrestaurantapp

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantDataApi {
       @GET("/api/restaurant/random_restaurant")
       fun getRandomRestaurant():Call<JsonObject>
}