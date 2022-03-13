package com.example.myrestaurantapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginView(vm:UserViewModel) {
    var email : MutableState<String> = remember {
        mutableStateOf("")
    }
    var pw : MutableState<String> = remember {
        mutableStateOf("")
    }

    var isHide:MutableState<Boolean> = remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Login Page" , fontWeight = FontWeight.Bold, fontSize = 25.sp , color = Color(0xFF6200ee) ,modifier = Modifier.padding(10.dp))
        //Email

        OutlinedTextField(value = email.value, onValueChange ={email.value = it} , label = { Text(
            text = "Email"
        )
        },modifier = Modifier.padding(10.dp), trailingIcon = { Icon(
            painter = painterResource(id = R.drawable.ic_email_) ,
            contentDescription = "Email",
            tint = Color(0xFF6200EE)
        )})
        //Password
        OutlinedTextField(value = pw.value, onValueChange ={pw.value = it} , label = { Text(
            text = "Password"
        )
        }, visualTransformation = if (isHide.value) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.padding(10.dp),
            trailingIcon = { Icon(
                painter = painterResource( if (isHide.value) R.drawable.ic_visibility else R.drawable.ic_visibility_off ) ,
                contentDescription = "password",
                tint = Color(0xFF6200EE),
                modifier = Modifier.clickable { isHide.value =! isHide.value }
            )})
        //Login Button
        OutlinedButton(
            onClick = { if (email.value.isNotEmpty() && pw.value.isNotEmpty()){
                vm.loginUser(email.value,pw.value)
            }},
            modifier = Modifier.padding(10.dp),
            shape = RoundedCornerShape(20.dp),
            //Change button color
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFEFF2F1)
            )

        ) {
            Text(text = "Login", color = Color(0xFF6200ee))
        }
        //Error info
         if(vm.errorInfo.value.isNotEmpty()){
             Text(text = vm.errorInfo.value, fontSize = 10.sp, modifier = Modifier.padding(10.dp),color = Color.Red, fontWeight = FontWeight.Bold )
             Image(painter = painterResource(id = R.drawable.no), contentDescription = "no",Modifier.padding(10.dp))
         }



    }
}