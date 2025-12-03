package com.example.doctorappexample.navigation

sealed class Screen(val route:String){
    object Intro:Screen("intro")
    object Home:Screen("home")
    object TopDoctors:Screen("topDoctors")
    object Detail:Screen("detail")

}