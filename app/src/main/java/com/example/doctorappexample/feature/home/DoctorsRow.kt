package com.example.doctorappexample.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.doctorappexample.R
import com.example.doctorappexample.core.model.DoctorModel


@Composable
fun DoctorRow(
    items: List<DoctorModel>,
    onClick: (DoctorModel) -> Unit,
) {
    Box(
        Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .heightIn(min=260.dp)

    ){
        if (items.isEmpty()){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            LazyRow(
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp)
            ) {
                items(count = items.size){
                    DoctorCard(
                        item = items[it],
                        onClick = { onClick(items[it]) }
                    )
                }
            }
        }
    }


    
}

@Composable
private fun DoctorCard(
    item: DoctorModel,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(width = 190.dp, height = 260.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(165.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(R.color.lightPurple)),
                contentAlignment = Alignment.Center

            ) {
                AsyncImage(
                    model = item.Picture,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit

                )

            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = item.Name ?: "",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = item.Special ?: "",
                color = colorResource(R.color.gray),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.weight(1f))
          Row(
              modifier = Modifier
                  .fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically

          ){
              Image(
                  painterResource(R.drawable.star),
                  contentDescription = null,
              )
              Spacer(Modifier.width(8.dp))
              Text(
                  text = (item.Rating ?: 0.0).toString(),
                  color = Color.Black,
                  fontWeight = FontWeight.Bold
              )

              Spacer(Modifier.weight(1f))

              Image(
                  painterResource(R.drawable.experience),
                  contentDescription = null,
              )
              Spacer(Modifier.width(6.dp))
              Text(
                  text = "${item.Expriense?:0} Year",
                  fontSize = 14.sp,
                  color = Color.Black,
                  fontWeight = FontWeight.Bold
              )
          }


        }

    }


}



@Preview(showBackground = true, backgroundColor = 0xFFFFFFF)
@Composable
private fun DoctorRowPreview(){
    MaterialTheme {
        val items = listOf(
            DoctorModel(Id = 1, Name = "Dr.Ibrahim Hussein", Picture = "", Special = "Cardiology"),
            DoctorModel(Id = 2, Name = "Dr.Ibrahim Hussein", Picture = "", Special = "Neurology"),
            DoctorModel(Id = 3, Name = "Dr.Ibrahim Hussein", Picture = "", Special = "Cardiology"),

        )
        DoctorRow(
            items = items,
            onClick = {}
        )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFFFFFF)
@Composable
private fun DoctorCardPreview() {
    MaterialTheme {
        val item = DoctorModel(Id = 1, Name = "Dr.Ibrahim Hussein", Picture = "", Special = "Cardiology")
        DoctorCard(
            item = item,
            onClick = {}
        )

    }
}