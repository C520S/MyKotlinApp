package com.example.myrestaurantapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun BottomBarView(nav : NavHostController) {
    val userVM = viewModel<UserViewModel>(LocalContext.current as ComponentActivity)
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF6200ee))
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically)
    {
        Icon(painter = painterResource(R.drawable.ic_home), contentDescription ="home" , modifier = Modifier.clickable {
            nav.navigate(HOME_Route)
        })
        Icon(painter = painterResource(R.drawable.ic_dining), contentDescription ="Like list" , modifier = Modifier.clickable {
            nav.navigate(LiKe_Route)
            userVM.updateList()
        })
    }
}