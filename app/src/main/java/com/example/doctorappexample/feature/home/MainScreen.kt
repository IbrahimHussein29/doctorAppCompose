package com.example.doctorappexample.feature.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.doctorappexample.core.model.DoctorModel
import com.example.doctorappexample.core.viewModel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
    onOpenDoctorDetail: (DoctorModel) -> Unit,
    onOpenTopDoctors: () -> Unit
) {
    val categories by viewModel.category.observeAsState(emptyList())
    val doctors by viewModel.doctor.observeAsState(emptyList())


    LaunchedEffect(Unit) {
        if (categories.isEmpty()) {
            viewModel.loadCategory()
        }
        if (doctors.isEmpty()) {
            viewModel.loadDoctor()
        }
    }
    var selectedBottom by remember { mutableIntStateOf(0) }

    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            HomeBottomBar(
                selected = selectedBottom,
                onSelect = { selectedBottom = it },

                )
        }
    ) {inner ->
        LazyColumn(
            contentPadding = inner
        ) {
            item { HomeHeader() }
            item { Banner() }
            item { SectionHeader(title = "Doctor Speciality", onSeeAll = null) }
            item { CategoryRow(items = categories) }
            item { SectionHeader(title = "Top Doctors", onSeeAll = onOpenTopDoctors) }
            item { DoctorRow(items = doctors, onClick = onOpenDoctorDetail) }

        }

    }


}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFF)
@Composable
private fun MainScreenPreview() {
  val viewModel: MainViewModel = viewModel()
        MainScreen(
            viewModel = viewModel,
            onOpenDoctorDetail = {},
            onOpenTopDoctors = {}
        )

}