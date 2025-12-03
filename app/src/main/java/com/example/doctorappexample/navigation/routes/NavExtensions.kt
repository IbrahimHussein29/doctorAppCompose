package com.example.doctorappexample.navigation.routes

import androidx.navigation.NavController
import com.example.doctorappexample.core.model.DoctorModel
import com.example.doctorappexample.navigation.Screen

fun NavController.navigateToDetail(doctor: DoctorModel){
    currentBackStackEntry?.savedStateHandle?.set("doctor", doctor)
    navigate(Screen.Detail.route)
}
