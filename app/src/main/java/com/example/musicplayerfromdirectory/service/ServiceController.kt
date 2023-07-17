package com.example.musicplayerfromdirectory.service

import android.content.Context
import android.content.Intent
import android.net.Uri

class ServiceController(context: Context) {

    val context = context

    fun startMusicService(uri: Uri) {
        val serviceIntent = Intent(context, MusicService::class.java)
            .putExtra("EXTRA_MESSAGE",uri.path)
        context.startService(serviceIntent)
    }
    fun stopMusicService(){
        val serviceIntent = Intent(context, MusicService::class.java)
        context.stopService(serviceIntent)
    }
}