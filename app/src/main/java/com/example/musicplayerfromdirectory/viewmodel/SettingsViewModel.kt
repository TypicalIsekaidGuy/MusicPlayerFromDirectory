package com.example.musicplayerfromdirectory.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class SettingsViewModel: ViewModel() {

    val options = listOf("Option 1", "Option 2", "Option 3")
    fun debugOnly(){
        Log.d("s","ss")
    }
}