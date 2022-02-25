package com.example.sampleweather.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints() {
        // minWidth, maxWidth, minHeight, maxHeight といった制約を取得できる
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp)
        } else {
            decoupledConstraints(margin = 32.dp)
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.layoutId("button")
            ) {
                Text(text = "Button")
            }

            Text(text = "Text", modifier = Modifier.layoutId("text"))
        }
    }
}

// ConstraintLayoutを外から設定する方法
private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet() {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin)
        }

        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}

@Composable
@Preview
fun DecoupledConstraintLayoutPreview() {
    SampleWeatherTheme {
        DecoupledConstraintLayout()
    }
}
