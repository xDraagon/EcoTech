package com.example.eco_tech

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.ShapeDrawable
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.eco_tech.ui.theme.Eco_TechTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Eco_TechTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage() {
    Column {
        Row (modifier = Modifier
            .background(Color(0xFF3dd7b7))
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            /*Image(
                painter = painterResource(id = R.drawable.logo_ecotech),
                contentDescription = "Logo_EcoTech"
            )*/

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke( 0.5.dp, Color.White),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(5.dp).width(75.dp)
            )
            {
                Column (
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.height(50.dp).padding(0.dp)
                ){
                    Row (modifier = Modifier.height(4.dp).width(40.dp).background(Color.White)){}
                    Row (modifier = Modifier.height(4.dp).width(40.dp).background(Color.White)){}
                    Row (modifier = Modifier.height(4.dp).width(40.dp).background(Color.White)){}
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Eco_TechTheme {
        MainPage()
    }
}