package com.example.musicplayerfromdirectory

import java.net.URI

sealed interface MusicEvent {
    data class ChooseFile(val uri:URI): MusicEvent
    data class ChooseFolder(val uri:URI): MusicEvent
    object SkipSongBack: MusicEvent
    object SkipSongForward: MusicEvent
    object TogglePauseSong: MusicEvent
    object ToggleReplaySong: MusicEvent
    data class SkipToPart(val time: Int): MusicEvent
}