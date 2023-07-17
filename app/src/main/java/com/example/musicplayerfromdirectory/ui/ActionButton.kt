package com.example.musicplayerfromdirectory.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicplayerfromdirectory.ui.theme.LighterGreenBG
import com.example.musicplayerfromdirectory.ui.theme.TextBlack

@Composable
fun ActionButton(
    modifier: Modifier,
    name: String,
    onClick: () -> Unit
){
    Box(modifier = modifier) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(LighterGreenBG)
            .clickable { onClick() }) {
            Text(
                text = name,
                color = TextBlack,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Center).padding(40.dp, 10.dp)
            )
        }
    }
}