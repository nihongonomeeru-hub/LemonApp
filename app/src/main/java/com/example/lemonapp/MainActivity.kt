package com.example.lemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonapp.ui.theme.LemonAppTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonAppTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.lemon_text),
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = Color(0xFFF9E44B)
                            )
                        )
                    }
                ) { innerPadding ->
                    LemonadeApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LemonadeBlock() {
    var result by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(1) }
    var imageResource = when(result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    var textResource = when(result) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.glass
        else -> R.string.empty_glass
    }
    var textResource1 = when(result) {
        1 -> R.string.lemon_tree_text
        2 -> R.string.lemon_text
        3 -> R.string.glass_text
        else -> R.string.empty_glass_text
    }
    Button(
        onClick = {
            when(result) {
                1 -> {
                    result = 2
                    squeezeCount = (5..8).random()
                }
                2 -> {
                    squeezeCount--
                    if(squeezeCount == 0) {
                        result = 3
                    }
                }
                3 -> result = 4
                else -> result = 1
            }
        },
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC3ECD2)
        ),
        contentPadding = PaddingValues(24.dp)
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = textResource1.toString()
        )
    }
    Spacer(
        modifier = Modifier.height(16.dp)
    )
    Text(
        text = stringResource(textResource),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LemonadeBlock()
    }
}

@Preview
@Composable
fun LemonadeAppView() {
    LemonadeApp()
}