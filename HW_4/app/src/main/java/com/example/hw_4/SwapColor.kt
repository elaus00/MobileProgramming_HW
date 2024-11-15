package com.example.hw_4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwapColor() {
    var textColor by remember { mutableStateOf(Color.Black) }
    var coloredText by remember { mutableStateOf("Tap to Change Color") }
    var bgColor by remember { mutableStateOf(Color.White) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ColorSwap") },
                // 색이 랜덤하게 바뀜에 따라 AppBar의 배경색도 바뀌도록 설정
                // title색상은 배경색의 보색으로 나오도록 설정
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = bgColor,
                    titleContentColor = Color(
                        red = 1f - bgColor.red,
                        green = 1f - bgColor.green,
                        blue = 1f - bgColor.blue
                    )
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = coloredText,
                color = textColor,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 32.dp)
            )

            // 여백 추가
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val red = Random.nextInt(256)
                    val green = Random.nextInt(256)
                    val blue = Random.nextInt(256)

                    // 텍스트 색상 설정
                    textColor = Color(red, green, blue)
                    bgColor = textColor

                    coloredText = "COLOR: ${red}r, ${green}g, ${blue}b"
                }
            ) {
                Text("TAP ME!")
            }
        }
    }
}