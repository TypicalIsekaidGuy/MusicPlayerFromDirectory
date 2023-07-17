package com.example.musicplayerfromdirectory.ui

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicplayerfromdirectory.ui.theme.DarkGreenBg
import com.example.musicplayerfromdirectory.ui.theme.GreenBG
import com.example.musicplayerfromdirectory.ui.theme.LighterGreenBG
import com.example.musicplayerfromdirectory.ui.theme.TextBlack
import com.example.musicplayerfromdirectory.R
import com.example.musicplayerfromdirectory.viewmodel.HomeViewModel

@Composable
fun MusicPlayerScreen(name: MutableState<String>, isPaused: MutableState<Boolean>, musicTime: MutableState<Float>, viewModel: HomeViewModel){
    var isMaximised = remember{ mutableStateOf(true) }
    if(isMaximised.value){
        MusicPlayer(name, viewModel.isPaused, viewModel.isFullScreen, musicTime, viewModel::playMusic,viewModel::pauseMusic)
    }
    else{
        Box(modifier = Modifier.fillMaxSize()){

            Box(modifier = Modifier.padding(bottom = 64.dp).align(Alignment.BottomCenter)){
                BottomMusicPlayer(name, isPaused, isMaximised)
            }

    }
    }
}
@Composable
fun MusicPlayer(name: MutableState<String>, isPaused: MutableState<Boolean>, isMaximised: MutableState<Boolean>, musicTime: MutableState<Float>, playMusic: () -> Unit, pauseMusic:() -> Unit){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(GreenBG)){
        Box(modifier = Modifier
            .fillMaxWidth()
            .size(width = 0.dp, height = 20.dp)
            .align(Alignment.TopCenter)
            .clickable { isMaximised.value = false })
        Column(verticalArrangement = Arrangement.spacedBy(100.dp, alignment = Alignment.CenterVertically), horizontalAlignment = Alignment.CenterHorizontally,  modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.padding(horizontal = 20.dp)){
                Column(verticalArrangement = Arrangement.spacedBy(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = name.value, fontSize = 32.sp,color = TextBlack, textAlign = TextAlign.Center)
                }
            }
            Slider(
                value = musicTime.value,
                onValueChange = { sliderValue_ ->
                    musicTime.value = sliderValue_
                },
                onValueChangeFinished = {

                },
                valueRange = 0f..10f,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Row(horizontalArrangement = Arrangement.spacedBy(32.dp)){
                Icon(painter = painterResource(id = R.drawable.baseline_skip_previous_24), contentDescription = null, modifier = Modifier
                    .clickable { }
                    .size(46.dp))
                Icon(painter = painterResource(id = if(isPaused.value) R.drawable.play_arrow else R.drawable.pause), contentDescription = null, modifier = Modifier
                    .clickable { isPaused.value = !isPaused.value
                                if(isPaused.value)
                                    playMusic()
                                else
                                    pauseMusic()
                    }
                    .size(46.dp))
                Icon(painter = painterResource(id = R.drawable.skip_next), contentDescription = null, modifier = Modifier
                    .clickable { }
                    .size(46.dp))
            }
        }
    }
}
@Composable
fun BottomMusicPlayer(name: MutableState<String>, isPaused: MutableState<Boolean>,isMaximised: MutableState<Boolean>,){
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(color = LighterGreenBG)
        .clickable { isMaximised.value = true }){
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .padding(horizontal = 40.dp)
            .fillMaxWidth()) {
            Text(text = if (name.value.length> 18) name.value.take(15) +"..." else name.value, fontSize = 30.sp, textAlign = TextAlign.Center, color = TextBlack)
            Icon(painter = painterResource(id = if(isPaused.value) R.drawable.play_arrow else R.drawable.pause), contentDescription = null, modifier = Modifier
                .clickable { isPaused.value = !isPaused.value }
                .size(46.dp))
        }
    }
}