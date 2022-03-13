package com.example.myrestaurantapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TopBarView() {
    val vm = viewModel<UserViewModel>()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF6200ee))
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,) {
            Icon(painter = painterResource(id =R.drawable.ic_account ), contentDescription ="", tint = Color.White )
            Text(text = vm.username.value, fontSize = 20.sp, )
        }
        OutlinedButton(onClick = { vm.logoutUser() },shape = RoundedCornerShape(60.dp)) {
            Text(text = "Logout", fontSize = 10.sp,)
        }
    }
}