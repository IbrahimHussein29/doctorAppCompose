package com.example.doctorappexample.navigation.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.doctorappexample.feature.intro.IntroScreen
import com.example.doctorappexample.navigation.Screen

fun NavGraphBuilder.introRoute(
    onStart: () -> Unit,
) {
    composable(route = Screen.Intro.route) {
        IntroScreen(onStart)
    }

}