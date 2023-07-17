package com.example.musicplayerfromdirectory.viewmodel

import android.content.Context
import android.net.Uri
import android.util.Log
import android.webkit.URLUtil
import androidx.lifecycle.ViewModel
import com.example.musicplayerfromdirectory.MusicEvent
import com.example.musicplayerfromdirectory.MusicState
import com.example.musicplayerfromdirectory.service.PlayerListener
import com.example.musicplayerfromdirectory.service.ServiceController
import com.example.musicplayerfromdirectory.settings.MyMediaPlayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import org.greenrobot.eventbus.EventBus

class HomeViewModel(controller: ServiceController): ViewModel() {

    private var musicPlayerListener: PlayerListener? = null


    val isPaused = false
    val isFullScreen = true
    val controller = controller


    fun setMusicPlayerListener(listener: PlayerListener) {
        musicPlayerListener = listener
    }

    fun onEvent(event: MusicEvent){
        when(event){
            is MusicEvent.ChooseFile -> {
                val uri = Uri.parse("android.resource://packageName/raw/song")
                if (URLUtil.isValidUrl(uri.path)){
                    controller.startMusicService(uri)
                }
            }
            is MusicEvent.ChooseFolder -> {
            }
            is MusicEvent.SkipSongBack -> {
                musicPlayerListener?.skipSongBack()
            }
            is MusicEvent.SkipSongForward -> {

                musicPlayerListener?.skipSongForward()
            }
            is MusicEvent.TogglePauseSong -> {
                if(isPaused){

                    musicPlayerListener?.playMusic()
                }
                else
                    musicPlayerListener?.pauseMusic()
            }
            is MusicEvent.ToggleReplaySong -> {

            }
            is MusicEvent.SkipToPart -> {

            }
        }
    }
}
