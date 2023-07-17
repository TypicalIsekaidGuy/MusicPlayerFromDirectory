package com.example.musicplayerfromdirectory.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicplayerfromdirectory.R
import com.example.musicplayerfromdirectory.ui.ActionButton
import com.example.musicplayerfromdirectory.ui.bottom.StandardMenu
import com.example.musicplayerfromdirectory.ui.theme.GreenBG
import com.example.musicplayerfromdirectory.ui.theme.LighterGreenBG
import com.example.musicplayerfromdirectory.ui.theme.TextBlack
import com.example.musicplayerfromdirectory.ui.theme.TextWhite
import com.example.musicplayerfromdirectory.viewmodel.HomeViewModel
import com.example.musicplayerfromdirectory.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel){
    Box(
        modifier = Modifier
            .background(GreenBG)
            .fillMaxSize()
    ){
        StandardMenu()
        Column(verticalArrangement = Arrangement.spacedBy(64.dp), modifier = Modifier
            .align(
                Alignment.Center
            )
            .fillMaxWidth()) {
            DropDownSection(viewModel.options)
            VolumeSection()
        }
    }
}
@Composable
fun DropDownSection(options: List<String>){
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(20.dp, 0.dp).fillMaxWidth()){
        Text(text = stringResource(id = R.string.choose_player), fontSize = 32.sp,color = TextBlack, modifier = Modifier.align(Alignment.CenterVertically))


        var selectedOption by remember { mutableStateOf("Select here") }
        var expanded by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .background(LighterGreenBG, shape = RoundedCornerShape(4.dp))
                .clickable { expanded = true }
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = selectedOption,
                modifier = Modifier.padding(16.dp)
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(TextWhite)
                    .width(IntrinsicSize.Min)
                    .wrapContentSize(Alignment.TopStart)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption = option
                            expanded = false
                        }
                    ) {
                        Text(text = option)
                    }
                }
            }
        }
    }
}
@Composable
fun VolumeSection(){
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(20.dp, 0.dp).fillMaxWidth()){

    Text(text = stringResource(id = R.string.volume), fontSize = 24.sp,color = TextBlack, modifier = Modifier.align(Alignment.CenterVertically))
    var sliderValue by remember {
        mutableStateOf(0f) // pass the initial value
    }

    Slider(
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {

        },
        valueRange = 0f..10f,
        modifier = Modifier.padding(start = 10.dp)
    )
    }
}