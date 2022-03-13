package com.example.myrestaurantapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RestaurantListDataView() {
    val userVM = viewModel<UserViewModel>(LocalContext.current as ComponentActivity)
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFFFFFFF)),

    ) {
        Text(text = "Restaurants in your Favorite",fontWeight = FontWeight.Bold, color = Color(0xFF6200EE),fontSize = 25.sp)

       LazyColumn{
           items(userVM.dataList.value){
               if (it.isNotEmpty()){
                   Card(
                       modifier = Modifier
                           .width(360.dp)
                           .padding(10.dp, 10.dp)
                   ) {
                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .background(Color(0xFF69A8DA))
                               .padding(10.dp),
                           horizontalArrangement = Arrangement.Center,
                           verticalAlignment = Alignment.CenterVertically,
                       ) {
                           Text(
                               text = it,
                               fontSize = 15.sp,
                               color = Color.Black
                           )
                       }
                   }

               }
           }
       }

    }
}