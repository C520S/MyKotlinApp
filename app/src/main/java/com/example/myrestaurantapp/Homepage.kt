package com.example.myrestaurantapp


import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun HomepageView() {
    val vm = viewModel<RestaurantViewModel>(LocalContext.current as ComponentActivity)
    val userVM = viewModel<UserViewModel>(LocalContext.current as ComponentActivity)
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(Color(0xFF69A8DA))) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Randomly generate your owm restaurant", fontWeight = FontWeight.Bold, color = Color(0xFF6200EE))
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedButton(onClick = { vm.getRestaurantData()},shape = RoundedCornerShape(20.dp)) {
                Text(text = "Generate restaurant")
            }
            OutlinedButton(onClick = { userVM.addTolist(vm.restaunrant.value.name) },shape = RoundedCornerShape(20.dp)) {
                Text(text = "Add to your list")
            }
        }
        Divider(color = Color.Black, thickness = 2.dp)
        Text(text = "Restaurant Name : ${vm.restaunrant.value.name }")
        Divider(color = Color.Black, thickness = 2.dp)
        Text(text = "Restaurant Type : ${vm.restaunrant.value.type}")
        Divider(color = Color.Black, thickness = 2.dp)
        Text(text = "Restaurant Address :\n${vm.restaunrant.value.address}")
        Divider(color = Color.Black, thickness = 2.dp)
        Text(text = "Restaurant Phone Number:\n${vm.restaunrant.value.phone_number}")
        Divider(color = Color.Black, thickness = 2.dp)
        Text(text = "Restaurant Description:\n${vm.restaunrant.value.description}")
        Divider(color = Color.Black, thickness = 2.dp)
        Text(text = "Restaurant Review:\n${vm.restaunrant.value.description}")
        Card(modifier = Modifier
            .size(200.dp, 200.dp)
            .padding(10.dp), elevation = 5.dp)
        {
            AsyncImage(
                model = vm.restaunrant.value.logo,
                contentDescription ="",

                contentScale = ContentScale.Crop
            )
        }


    }





}

