package com.example.sampleweather.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val (button, button2, text, text2) = createRefs()

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text(text = "Button")
        }

        Text(text = "text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)

            centerAround(button.end)
            // ボタンに対して水平方向に中心となるようにする
            // centerHorizontallyTo(parent)
        })

        val barrier = createEndBarrier(button, text)
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }) {
            Text(text = "button2")
        }

        // 水平方向に0.5のガイドライン
        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text(
            text = "This is a very very very very very very very long text",
            Modifier.constrainAs(text2) {
                linkTo(start = guideline, end = parent.end)
                // 制約に従って長さを定義（改行する）
                width = Dimension.preferredWrapContent
            })
    }
}

@Composable
@Preview
fun ConstraintLayoutContentPreview() {
    SampleWeatherTheme {
        ConstraintLayoutContent()
    }
}
