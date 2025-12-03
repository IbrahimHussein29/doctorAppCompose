package com.example.doctorappexample.feature.topDoctors

import android.content.res.ColorStateList
import android.widget.RatingBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import android.R as AndroidR

@Composable
fun ComposeRatingBar(
    rating: Float,
    stars: Int = 5,

    ) {
    val startTint = Color(0xffffc160).toArgb()

    AndroidView(
        factory = { context ->
            RatingBar(context, null, AndroidR.attr.ratingBarStyleSmall).apply {
                numStars = stars
                stepSize = 0.5f
                isIndicator
                progressTintList = ColorStateList.valueOf(startTint)
            }
        },
        update = { rb ->
            rb.rating = rating
        }
    )

}