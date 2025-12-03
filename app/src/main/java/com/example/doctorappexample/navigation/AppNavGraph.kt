package com.example.doctorappexample.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.doctorappexample.core.viewModel.MainViewModel
import com.example.doctorappexample.navigation.routes.detailRoute
import com.example.doctorappexample.navigation.routes.homeRoute
import com.example.doctorappexample.navigation.routes.introRoute
import com.example.doctorappexample.navigation.routes.navigateToDetail
import com.example.doctorappexample.navigation.routes.topDoctorsRoute

@Composable
fun AppNavGraph(
    nav: NavHostController,
    vm: MainViewModel
){
    NavHost(navController = nav, startDestination = Screen.Intro.route){
        introRoute(
            onStart =
                {
                    nav.navigate(Screen.Home.route){
                        popUpTo(Screen.Intro.route){
                            inclusive=true
                        }
                    }
                }

        )
        homeRoute(
            vm,
            onOpenDetail = { nav.navigateToDetail(it) },
            onOpenTopDoctors = { nav.navigate(Screen.TopDoctors.route) }
        )

        topDoctorsRoute(
            vm = vm,
            onBack = { nav.popBackStack() },
            onOpenDetail = { nav.navigateToDetail(it) }
        )

        detailRoute(
            nav = nav,
            onBack = { nav.popBackStack() }
        )

    }


}