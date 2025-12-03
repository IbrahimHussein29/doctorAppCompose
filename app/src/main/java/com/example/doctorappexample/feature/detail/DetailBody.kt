package com.example.doctorappexample.feature.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctorappexample.R
import com.example.doctorappexample.core.model.DoctorModel
import com.example.doctorappexample.feature.detail.components.ActionItem
import com.example.doctorappexample.feature.detail.components.RatingState
import com.example.doctorappexample.feature.detail.components.StateColumn
import com.example.doctorappexample.feature.detail.components.VerticalDivider

@Composable
fun DetailBody(
    item: DoctorModel,
    onOpenWebsite: (String) -> Unit,
    onSendSms: ( String, String) -> Unit,
    onDial: (String) -> Unit,
    onDirection: (String) -> Unit,
    onShare: ( String,String) -> Unit,
) {
    val darkPurple = colorResource(R.color.darkPurple)
    val lightPurple = colorResource(R.color.lightPurple)
    val gray = colorResource(R.color.gray)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)

    ){
        Spacer(Modifier.height(24.dp))
        Text(
            text = item.Name ?: "",
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Text(
            text = item.Special ?: "Special",
            color = Color.Black,
           modifier = Modifier
               .padding(horizontal = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ){

            Image(painterResource(R.drawable.location), contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(
                text = item.Address ?: "address",
                color = darkPurple,
               modifier = Modifier.weight(1f)
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            StateColumn(
                title = "Patiens",
                value = item.Patiens?: "-"
            )
            VerticalDivider(color = gray)
            StateColumn(
                title = "Experience",
                value = "${item.Expriense?: 0} Years"
            )
            VerticalDivider(color = gray)
            RatingState(
                title = "Rating",
                rating = item.Rating?: 0.0
            )

        }
        Text(
            text = "BioGraphy",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
        Text(
           text = item.Biography ?: "",
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top=8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            ActionItem(
                label = "Website",
                icon = R.drawable.website,
                lightPurple = lightPurple,
                enabled=!item.Site.isNullOrBlank()
            ){
                onOpenWebsite(item.Site?:"")

            }
            ActionItem(
                label = "Message",
                icon = R.drawable.message,
                lightPurple = lightPurple,
                enabled=!item.Mobile.isNullOrBlank()
            ){
           onSendSms(item.Mobile?:"", "Hello ${item.Name}")

            }
            ActionItem(
                label = "Call",
                icon = R.drawable.call,
                lightPurple = lightPurple,
                enabled=!item.Mobile.isNullOrBlank()
            ){
                onDial(item.Mobile?:"")

            }
            ActionItem(
                label = "Direction",
                icon = R.drawable.direction,
                lightPurple = lightPurple,
                enabled=!item.Address.isNullOrBlank()
            ){
               onDirection(item.Address?:"")

            }
            ActionItem(
                label = "Share",
                icon = R.drawable.share,
                lightPurple = lightPurple,
                enabled= true
            ){
          val subject= item.Name?: ""
                val text = " ${item.Name} ${item.Address} ${item.Mobile}"
                onShare(subject, text)
            }
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.darkPurple),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Book Appointment",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Spacer(Modifier.height(8.dp))


    }

}