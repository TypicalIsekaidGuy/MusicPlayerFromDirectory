package com.example.musicplayerfromdirectory.service

interface PlayerListener {

    fun playMusic()
    fun pauseMusic()
    fun skipSongBack()
    fun skipSongForward()
    fun toggleReplaySong()
    fun skipSongTo()

}