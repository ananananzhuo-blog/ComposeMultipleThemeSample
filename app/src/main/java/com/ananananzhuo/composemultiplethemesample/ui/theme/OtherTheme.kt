package com.ananananzhuo.composemultiplethemesample.ui.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

/**
 * author  :mayong
 * function:
 * date    :2022/4/21
 **/

//    class DartColor(
////        override val colorBg: Color = Color(0xFFA243B3),
//        override val colorBg by mutableStateOf(Color(0xFFA243B3)),
//        override val textColor: Color = Color.Green,
//    ) : CustomColor()
//
//    class LightColor(
//        override val colorBg: Color = Color.White,
//        override val textColor: Color = Color.Black,
//    ) :
//        CustomColor()
class CustomColor(
    colorBg: Color,
    textColor: Color,
) {
    val colorBg by mutableStateOf(colorBg)
    val textColor by mutableStateOf(textColor)
}

fun customDarkTheme(
    colorBg: Color = Color(0xFFA243B3),
    textColor: Color = Color.Green,
): CustomColor = CustomColor(
    colorBg, textColor
)

fun customLightTheme(
    colorBg: Color = Color.White,
    textColor: Color = Color.Black,
): CustomColor = CustomColor(
    colorBg, textColor
)


val customDartColor = customDarkTheme()
val customLightColor = customLightTheme()

@SuppressLint("CompositionLocalNaming")
val MultipleTheme = compositionLocalOf<CustomColor> {
    customLightColor
}