package com.example.musicplayerfromdirectory

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.musicplayerfromdirectory.ui.ActionButton
import com.example.musicplayerfromdirectory.ui.MusicPlayerScreen
import com.example.musicplayerfromdirectory.ui.bottom.StandardMenu
import com.example.musicplayerfromdirectory.ui.theme.GreenBG
import com.example.musicplayerfromdirectory.ui.theme.TextBlack
import com.example.musicplayerfromdirectory.ui.theme.TextWhite
import com.example.musicplayerfromdirectory.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel){
    Box(
        modifier = Modifier
            .background(GreenBG)
            .fillMaxSize()
    ){
        Column(verticalArrangement = Arrangement.spacedBy(64.dp), modifier = Modifier
            .align(Alignment.Center)
            .fillMaxWidth()) {
            ActionButton(name = stringResource(id = R.string.file_button), modifier = Modifier.align(Alignment.CenterHorizontally)) {viewModel.debugOnly()}
            ActionButton(name = stringResource(id = R.string.directory_button),modifier = Modifier.align(Alignment.CenterHorizontally)) {viewModel.debugOnly()}
        }
        MusicPlayerScreen(mutableStateOf("sssssssssssssssssssssssss"),mutableStateOf(true),mutableStateOf(10f),viewModel)
        StandardMenu()
    }
}