package com.example.myrestaurantapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//Navigation Route
const val HOME_Route = "home"
const val LiKe_Route = "likeList"
@Composable
fun MainView() {
    val userVM = viewModel<UserViewModel>()
    if (userVM.username.value.isEmpty()){
        LoginView(userVM)

    }else{
        MainScaffoldView()
    }
}

@Composable
fun MainScaffoldView() {
    
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBarView()},
        bottomBar = {BottomBarView(navController)},
        content = { MainContentView(navController)},
    )



}

@Composable
fun MainContentView(nav: NavHostController) {
    NavHost(navController =nav, startDestination = HOME_Route ){
        composable(route = HOME_Route){
            HomepageView()
        }
        composable(route = LiKe_Route){

            RestaurantListDataView()
        }
    }
}





