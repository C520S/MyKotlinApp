package com.example.myrestaurantapp

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RestaurantViewModel :ViewModel() {
    var restaunrant: MutableState<RestaurantData> = mutableStateOf(RestaurantData("","","","",""
        ,"",""))

    val api by lazy{
        Retrofit
            .Builder()
            .baseUrl("https://random-data-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<RestaurantDataApi>()
    }

    fun getRestaurantData(){
        viewModelScope.launch {
            val resp = api.getRandomRestaurant().awaitResponse()
            if(resp.isSuccessful){
                val data = resp.body()
                if (data != null){
                    var temp = mutableStateOf(RestaurantData( data.get("name").asString,data.get("type").asString,data.get("description").asString,
                        data.get("review").asString,data.get("logo").asString,data.get("phone_number").asString,data.get("address").asString))
                      restaunrant.value = temp.value

                }

            }
        }

    }

}