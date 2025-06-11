package com.example.weather_app.ui.components

import android.annotation.SuppressLint
import android.graphics.BlurMaskFilter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.model.CurrentTemperatureUIModel
import com.example.weather_app.ui.model.getImageResId
import com.example.weather_app.ui.model.getShadowColor
import com.example.weather_app.ui.theme.UrbanistFont
import com.example.weather_app.ui.theme.primaryTextColor

@Composable
fun WeatherHeader(
    scrollProgress: Float,
    modifier: Modifier,
    isNightMode: Boolean,
    currentTemperatureUiModel: CurrentTemperatureUIModel
) {
    val minHeight = 160.dp
    val maxHeight = 360.dp
    var isScrolled by remember { mutableStateOf(false) }
    isScrolled = scrollProgress > 0.5f
    val animatedTopPadding =
        animateDpAsState(if (isScrolled) 100.dp else 0.dp, animationSpec = tween(500))
    val animatedHeight =
        animateDpAsState(if (isScrolled) minHeight else maxHeight, animationSpec = tween(500))
    val animatedBlurValue =
        animateFloatAsState(if (isScrolled) 150f else 250f, animationSpec = tween(500))
    val animatedShadowValue =
        animateFloatAsState(if (isScrolled) 75f else 125f, animationSpec = tween(500))
    val forecastAlignment by animateAlignmentAsState(if (isScrolled) Alignment.CenterStart else Alignment.TopCenter)
    val weatherAlignment by animateAlignmentAsState(if (isScrolled) Alignment.CenterEnd else Alignment.BottomCenter)

    Box(
        modifier = Modifier
            .padding(top = animatedTopPadding.value)
            .padding(horizontal = 12.dp)
    ) {
        Box(
            modifier = modifier
                .height(animatedHeight.value)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = (if (isScrolled) 15 else 0).dp),
                contentAlignment = forecastAlignment,
            ) {
                Box(
                    modifier = Modifier
                        .padding(
                            top = (if (isScrolled) 15 else 50).dp,
                            start = (if (isScrolled) 30 else 0).dp,
                        )
                ) {
                    BlurredEllipse(
                        figmaBlurValue = animatedBlurValue.value,
                        ellipseColor = currentTemperatureUiModel.weatherState.getShadowColor(
                            isNightMode
                        ),
                    )
                }
                Box {
                    Image(
                        painter = painterResource(
                            currentTemperatureUiModel.weatherState.getImageResId(isNightMode)
                        ),
                        contentDescription = "forecast",
                        contentScale = ContentScale.FillHeight,
                        modifier = if (isNightMode) Modifier
                            .height((if (isScrolled) 130 else 200).dp)
                            .dropShadow(
                                offsetX = -((animateFloatAsState(if (isScrolled) 10f else 25f)).value.dp),
                                offsetY = ((animateFloatAsState(if (isScrolled) 20f else 50f)).value.dp),
                                shape = CircleShape,
                                color = Color(0xFF1D2646).copy(0.2f),
                                blur = (animatedShadowValue.value / 3).dp,
                            )
                            .dropShadow(
                                offsetX = -((animateFloatAsState(if (isScrolled) 7f else 15f)).value.dp),
                                offsetY = ((animateFloatAsState(if (isScrolled) 5f else 0f)).value.dp),
                                shape = CircleShape,
                                color = Color(0xFF87CEFA).copy(0.2f),
                                blur = (animatedShadowValue.value / 3).dp,
                            )
                        else Modifier
                            .height((if (isScrolled) 130 else 200).dp)
                            .dropShadow(
                                offsetX = -((animateFloatAsState(if (isScrolled) 7f else 15f)).value.dp),
                                offsetY = ((animateFloatAsState(if (isScrolled) 5f else 0f)).value.dp),
                                shape = CircleShape,
                                color = Color(0xFFFFFFFF).copy(0.15f),
                                blur = (animatedShadowValue.value / 2).dp,
                            ),
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = weatherAlignment
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${currentTemperatureUiModel.temperature}°C",
                        fontFamily = UrbanistFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 64.sp,
                        lineHeight = 64.sp,
                        letterSpacing = 0.25.sp,
                        color = primaryTextColor(isNightMode = isNightMode)
                    )

                    Text(
                        text = currentTemperatureUiModel.weatherState.state,
                        fontFamily = UrbanistFont,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.25.sp,
                        color = primaryTextColor(isNightMode = isNightMode).copy(0.6f)
                    )

                    TemperatureRanges(
                        Modifier
                            .padding(
                                top = 12.dp
                            )
                            .background(
                                primaryTextColor(isNightMode).copy(0.08f),
                                RoundedCornerShape(100.dp),
                            )
                            .padding(
                                horizontal = 24.dp, vertical = 8.dp
                            ),
                        isNightMode,
                        currentTemperatureUiModel.maxTemp,
                        currentTemperatureUiModel.minTemp,
                        16.sp,
                        8.dp
                    )
                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun animateAlignmentAsState(
    targetAlignment: Alignment,
): State<Alignment> {
    val biased = targetAlignment as BiasAlignment
    val horizontal by animateFloatAsState(
        biased.horizontalBias,
        animationSpec = tween(durationMillis = 500)
    )
    val vertical by animateFloatAsState(
        biased.verticalBias,
        animationSpec = tween(durationMillis = 500)
    )
    return derivedStateOf { BiasAlignment(horizontal, vertical) }
}

@Composable
fun BlurredEllipse(figmaBlurValue: Float, ellipseColor: Color, modifier: Modifier = Modifier) {
    val composeBlurRadius = (figmaBlurValue).dp

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size((figmaBlurValue / 2).dp)
                .blur(
                    radius = composeBlurRadius,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
                .background(
                    color = ellipseColor,
                    shape = CircleShape
                )
        )
    }
}


fun Modifier.dropShadow(
    shape: Shape,
    color: Color = Color.Black.copy(0.25f),
    blur: Dp = 4.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 4.dp,
    spread: Dp = 0.dp,
) = this.drawBehind {
    val shadowSize = Size(size.width + spread.toPx(), size.height + spread.toPx())
    val shadowOutline = shape.createOutline(shadowSize, layoutDirection, this)
    val paint = Paint()
    paint.color = color
    if (blur.toPx() > 0) {
        paint.asFrameworkPaint().apply {
            maskFilter = BlurMaskFilter(blur.toPx(), BlurMaskFilter.Blur.NORMAL)
        }
    }
    drawIntoCanvas { canvas ->
        canvas.save()
        canvas.translate(offsetX.toPx(), offsetY.toPx())
        canvas.drawOutline(shadowOutline, paint)
        canvas.restore()
    }
}