package com.example.musicplayerfromdirectory.settings

import android.content.Context
import android.media.MediaPlayer;
import android.net.Uri
import android.os.Build
import android.webkit.URLUtil
import androidx.annotation.RawRes
import androidx.annotation.RequiresApi


class MyMediaPlayer(context: Context) {
        private lateinit var MediaPlayerinstance : MediaPlayer
        private val context = context

        fun getCurrentSong(uri: Uri): MediaPlayer{
            if(URLUtil.isValidUrl(uri.path) ||MediaPlayerinstance==null)
                MediaPlayerinstance = MediaPlayer.create(context,uri)
            return MediaPlayerinstance
        }

        fun playOrResumeMusic(mediaPlayer: MediaPlayer){
            mediaPlayer.start()
        }

        fun pauseMusic(mediaPlayer: MediaPlayer){
            mediaPlayer.pause()
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun rewindForwardMusic(mediaPlayer: MediaPlayer, msec: Long){
            mediaPlayer.seekTo(msec, MediaPlayer.SEEK_NEXT_SYNC)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun rewindBackMusic(mediaPlayer: MediaPlayer, msec: Long){
            mediaPlayer.seekTo(msec,MediaPlayer.SEEK_PREVIOUS_SYNC)
        }

}