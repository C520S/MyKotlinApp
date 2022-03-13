package com.example.myrestaurantapp

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.math.log

class UserViewModel:ViewModel() {
    var username = mutableStateOf("")
    var errorInfo = mutableStateOf("")
    var userEmail:String = ""
    var userPw:String = ""
    var restaurantNames = mutableListOf<String>()
    var dataList = mutableStateOf(listOf<String>())

    // Updating data from Firestore
   fun toInitRestaurantList(email: String,pw: String){
       Firebase.auth
           .signInWithEmailAndPassword(email,pw)
           .addOnSuccessListener {
               Firebase.firestore
                   .collection("restaurantData")
                   .document(it.user!!.uid)
                   .get()
                   .addOnSuccessListener { doc ->
                       val results = doc.data
                       var temp = results?.get("restaurantList")
                       var tempList = mutableListOf<String>()
                       tempList= temp as MutableList<String>
                       restaurantNames =tempList

                   }
           }
   }



    fun loginUser(email:String, pw:String){
        Firebase.auth
            .signInWithEmailAndPassword(email,pw)
            .addOnSuccessListener {
                username.value = Firebase.auth.currentUser?.email.toString()
                userEmail =email
                userPw=pw
                toInitRestaurantList(email, pw)

            }
            .addOnFailureListener {
                  errorInfo.value = "You may have entered the wrong email or password"
            }

    }

    fun  logoutUser(){
        Firebase.auth.signOut()
        username.value = ""
        errorInfo.value=""
        userEmail=""
        userPw =""
    }
    //Adding data to the Firestore
    fun addTolist(info :String){
       if(info.isNotEmpty()){
           restaurantNames.add(info)

       }
        var temp = restaurantNames.distinct()
        Firebase.auth
            .signInWithEmailAndPassword(userEmail,userPw)
            .addOnSuccessListener {
                Firebase.firestore
                    .collection("restaurantData")
                    .document(it.user!!.uid)
                    .set(Historydata(temp))
                    .addOnSuccessListener {
                        Log.d("............","Successfully sent")
                    }

            }

    }
   //Fetching data from Firestore
    fun updateList(){
        Firebase.auth
            .signInWithEmailAndPassword(userEmail,userPw)
            .addOnSuccessListener {
                Firebase.firestore
                    .collection("restaurantData")
                    .document(it.user!!.uid)
                    .get()
                    .addOnSuccessListener { doc ->
                        val results = doc.data
                        var temp = results?.get("restaurantList")
                        var tempList = mutableListOf<String>()
                        tempList= temp as MutableList<String>
                        dataList.value =tempList

                    }
            }

    }

}