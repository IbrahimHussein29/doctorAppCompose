package com.example.doctorappexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.doctorappexample.core.viewModel.MainViewModel
import com.example.doctorappexample.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    private val vm by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                val nav = rememberNavController()
                AppNavGraph(nav,vm)
        }
    }
}

