package com.example.picturecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.picturecard.ui.theme.PictureCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .padding(top = 40.dp)
            ){
                val scrollState = rememberScrollState()
                Column(modifier = Modifier.verticalScroll(scrollState)) {
                    ImageCard(painter = painterResource(id = R.drawable.eula), contentDescription = stringResource(id = R.string.Eula_Description), title = "Eula")
                    ImageCard(painter = painterResource(id = R.drawable.furina), contentDescription = stringResource(id = R.string.Furina_Description), title = "Furina")
                    ImageCard(painter = painterResource(id = R.drawable.nahida), contentDescription = stringResource(id = R.string.Nahida_Description), title = "Nahida")
                    ImageCard(painter = painterResource(id = R.drawable.kazuha), contentDescription = stringResource(id = R.string.Kazuha_Description), title = "Kazuha")
                }
            }
        }
    }
}

@Composable
fun ImageCard(painter: Painter, contentDescription: String, title: String, modifier: Modifier = Modifier){
    Row {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(30.dp)
                .width(200.dp)
                .height(200.dp),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    //contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(7.dp), contentAlignment = Alignment.BottomStart){
                    Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
        Text(text = contentDescription, color = Color.White, modifier = Modifier.padding(top = 30.dp, bottom = 30.dp, end = 30.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageCard(painter = painterResource(id = R.drawable.eula), contentDescription = "Eula", title = "Eula")
}