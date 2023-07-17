package com.example.musicplayerfromdirectory

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicplayerfromdirectory.service.ServiceController
import com.example.musicplayerfromdirectory.settings.MyMediaPlayer
import com.example.musicplayerfromdirectory.ui.theme.MusicPlayerFromDirectoryTheme
import com.example.musicplayerfromdirectory.viewmodel.HomeViewModel
import com.example.musicplayerfromdirectory.viewmodel.SettingsViewModel

class HomeActivity : ComponentActivity() {
    private val viewModel1 by viewModels<SettingsViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SettingsViewModel() as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val controller = ServiceController(applicationContext)

        val viewModel by viewModels<HomeViewModel>(
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return HomeViewModel(controller) as T
                    }
                }
            }
        )
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
            0
        )
        }
        Log.d("SS","$packageName")

        setContent {
            MusicPlayerFromDirectoryTheme {
                HomeScreen(viewModel)
            }
        }
    }
    fun createService(){
        /*Intent*/
    }
}
