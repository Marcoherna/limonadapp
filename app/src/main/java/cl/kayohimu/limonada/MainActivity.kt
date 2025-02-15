package cl.kayohimu.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.kayohimu.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LimonadaTheme {
                LimonadaApp()
            }
        }
    }
}

@Composable
fun LimonadaApp(){
    LimonadaHeader()
    LimonadaImageAndText(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}

@Composable
fun LimonadaImageAndText(modifier: Modifier = Modifier) { // Función para
    var result by remember { mutableIntStateOf(1) }
    var imageResource = R.drawable.lemon_tree
    var textResource = stringResource(R.string.lemon_tree)

    when (result) {
        2 -> {
            imageResource = R.drawable.lemon_squeeze
            textResource = stringResource(R.string.lemon)
        }
        3 -> {
            imageResource = R.drawable.lemon_squeeze
            textResource = stringResource(R.string.lemon)
        }
        4 -> {
            imageResource = R.drawable.lemon_squeeze
            textResource = stringResource(R.string.lemon)
        }
        5 -> {
            imageResource = R.drawable.lemon_drink
            textResource = stringResource(R.string.glass_of_limonade)
        }
        6 -> {
            imageResource = R.drawable.lemon_restart
            textResource = stringResource(R.string.empty_glass)
        }
        7 -> {
            result = 1
            imageResource = R.drawable.lemon_tree
            textResource = stringResource(R.string.lemon_tree)
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { result++ },
            shape = RoundedCornerShape(
                topStart = 50.dp,
                topEnd = 50.dp,
                bottomEnd = 50.dp,
                bottomStart = 50.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green
            )


        ) {

            Image(
                painter = painterResource(imageResource),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = textResource,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
    }
}

@Composable
fun LimonadaHeader() {
    Text(
        text = stringResource(R.string.app_name),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(top = 50.dp, bottom = 25.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,

        )
}

@Preview(showBackground = true)
@Composable
fun LimonadaappPreview() {
    LimonadaTheme {
        LimonadaApp()
    }
}

