
## 为什么要自定义主题

```kt
 primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    isLight: Boolean
```
上面代码中的颜色是系统默认主题中的颜色，他能满足我们大部分颜色的需求，不过对于庞大的业务来说总会有多余的颜色需要处理，并且也可能需要适配深色和亮色两种模式，在这种情况下自定义主题就很有必要了。

还有一点，系统默认主题提供的颜色字段无法与我们的业务属性关联。

## 如何定义
我们使用系统主题分类一样的方式来实现，通过两个api`CompositionLocalProvider`、`compositionLocalOf`实现。这两个api适用的场景很少，主题中的使用是最常见的。

我们可以使用`CompositionLocalProvider`包裹布局，`compositionLocalOf`变量提供值，这样当值发生定义后，整个树内部的相关属性都可以统一改变。



## 部分代码

1. 定义我们自定义的颜色类，包含两个变量，`colorBg`背景颜色，`textColor`文字颜色
```kt
class CustomColor(
    colorBg: Color,
    textColor: Color,
) {
    val colorBg by mutableStateOf(colorBg)
    val textColor by mutableStateOf(textColor)
}
```

2. 生成亮色和深色两个颜色集合


```kt
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
```
3. 生成compositionLocalOf变量MultipleTheme

```kt
val MultipleTheme = compositionLocalOf<CustomColor> {
    customLightColor
}
```

> 如上代码是自定义主题颜色集合，下面是使用方法

4. 在我们的根树部分使用CompositionLocalProvider包裹组合

```kt
 CompositionLocalProvider(MultipleTheme provides if (isSystemInDarkTheme()) customDartColor else customLightColor) {
                    Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background) {
                        Greeting("Android")
                    }
                }
```

5. 定义布局


```kt
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
```
## 效果展示

1. 深色


![](https://files.mdnice.com/user/15648/512cbba1-61c2-4f44-ab87-88a1dc7affed.png)



2. 亮色

![](https://files.mdnice.com/user/15648/84fc311e-ed15-4164-9e9e-d606f4710b4c.png)





