package com.example.musicplayerfromdirectory.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicplayerfromdirectory.R
import com.example.musicplayerfromdirectory.Song
import com.example.musicplayerfromdirectory.ui.ActionButton
import com.example.musicplayerfromdirectory.ui.bottom.StandardMenu
import com.example.musicplayerfromdirectory.ui.theme.DarkGreenBg
import com.example.musicplayerfromdirectory.ui.theme.GreenBG
import com.example.musicplayerfromdirectory.ui.theme.TextBlack
import com.example.musicplayerfromdirectory.viewmodel.HomeViewModel

@Composable
fun DirectoryScreen(viewModel: HomeViewModel){
    Box(
        modifier = Modifier
            .background(GreenBG)
            .fillMaxSize()
    ){
        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
            .align(Alignment.Center)
            .fillMaxSize()) {
            ActionButton(name = stringResource(id = R.string.directory_button),modifier = Modifier.align(Alignment.CenterHorizontally)) {viewModel.debugOnly()}
        }
        LazySongsList(
            listOf(Song("sssss"),Song("sssss"),Song("sssss"),Song("sssss"),Song("sssss"),Song("sssss"),Song("sssss"))
        )
        StandardMenu()
    }
}
@Composable
fun LazySongsList(songs: List<Song>){
    Box(modifier = Modifier.padding(top = 50.dp)){
        LazyColumn{
            items(songs.size) {
                LazySongsItem(item = songs[it])
            }
        }
    }
}
@Composable
fun LazySongsItem(item: Song){
    Box(modifier = Modifier){
        Column() {
            Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .background(DarkGreenBg)
                .padding(vertical = 20.dp)
                .clickable { }
                .fillMaxWidth()){
                Column() {
                    Text(text = item.name, fontSize = 32.sp,color = TextBlack, textAlign = TextAlign.Center)
                    Text(text = "04:00", fontSize = 32.sp,color = TextBlack, textAlign = TextAlign.Center)
                }
                Icon(painter = painterResource(id = R.drawable.play_arrow), contentDescription = null, modifier = Modifier
                    .size(46.dp))
            }
            Box(modifier = Modifier.fillMaxWidth().size(5.dp).background(TextBlack))
        }
    }
}