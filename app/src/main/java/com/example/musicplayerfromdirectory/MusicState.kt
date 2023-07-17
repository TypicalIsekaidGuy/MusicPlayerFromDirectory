package com.example.musicplayerfromdirectory

import java.time.LocalTime

data class MusicState(
    val isFullScreen: Boolean = true,
    val isPaused: Boolean = false,
    val currentTittle: String = "",
    val currentTime: LocalTime = LocalTime.now()
)