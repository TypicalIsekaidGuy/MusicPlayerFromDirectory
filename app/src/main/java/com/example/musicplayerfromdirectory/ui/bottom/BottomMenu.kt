package com.example.musicplayerfromdirectory.ui.bottom

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.musicplayerfromdirectory.R
import com.example.musicplayerfromdirectory.ui.theme.TextWhite
import com.example.musicplayerfromdirectory.ui.theme.TextBlack
import com.example.musicplayerfromdirectory.ui.theme.DarkGreenBg

@Composable
fun StandardMenu(){
    Box(modifier = Modifier.fillMaxSize()){
        BottomMenu(items = listOf(
            BottomMenuContent(stringResource(id = R.string.home_bottom_menu),R.drawable.baseline_settings_24, true),
            BottomMenuContent(stringResource(id = R.string.directory_bottom_menu), R.drawable.baseline_settings_24,false),
            BottomMenuContent(stringResource(id = R.string.settings_bottom_menu), R.drawable.baseline_settings_24, true)
        ), modifier = Modifier.align(Alignment.BottomCenter), initialSelectedItemIndex = 0)
    }
}
@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = TextWhite,
    activeTextColor: Color = TextWhite,
    inactiveTextColor: Color = TextBlack,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DarkGreenBg)
            .padding(5.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
            ) {
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeTextColor: Color = TextWhite,
    inactiveTextColor: Color = TextBlack,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}