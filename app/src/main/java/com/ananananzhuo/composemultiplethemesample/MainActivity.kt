package com.ananananzhuo.composemultiplethemesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ananananzhuo.composemultiplethemesample.ui.theme.ComposeMultipleThemeSampleTheme
import com.ananananzhuo.composemultiplethemesample.ui.theme.MultipleTheme
import com.ananananzhuo.composemultiplethemesample.ui.theme.customDartColor
import com.ananananzhuo.composemultiplethemesample.ui.theme.customLightColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMultipleThemeSampleTheme {
                // A surface container using the 'background' color from the theme
                CompositionLocalProvider(MultipleTheme provides if (isSystemInDarkTheme()) customDartColor else customLightColor) {
                    Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background) {
                        Greeting("Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(Modifier
        .fillMaxSize()
        .background(MultipleTheme.current.colorBg),
        contentAlignment = Alignment.Center) {
        Text(text = "公众号：安安安安卓",
            style = TextStyle(color = MultipleTheme.current.textColor, fontSize = 40.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeMultipleThemeSampleTheme {
        Greeting("Android")
    }
}