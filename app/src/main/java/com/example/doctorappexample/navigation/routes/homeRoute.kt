package com.example.doctorappexample.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.doctorappexample.core.model.DoctorModel
import com.example.doctorappexample.core.viewModel.MainViewModel
import com.example.doctorappexample.feature.home.MainScreen
import com.example.doctorappexample.navigation.Screen

fun NavGraphBuilder.homeRoute(
    vm: MainViewModel,
    onOpenDetail: (DoctorModel) -> Unit,
    onOpenTopDoctors: () -> Unit
){
    composable(Screen.Home.route){
        val categories by vm.category.observeAsState(emptyList())
        val doctors by vm.doctor.observeAsState(emptyList())

        LaunchedEffect(Unit){
            if (categories.isEmpty()) vm.loadCategory()
            if (doctors.isEmpty()) vm.loadDoctor()

        }
        MainScreen(
            viewModel=vm,
            onOpenDoctorDetail = onOpenDetail,
            onOpenTopDoctors = onOpenTopDoctors
        )

    }
}