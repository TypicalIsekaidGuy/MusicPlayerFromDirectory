package com.example.musicplayerfromdirectory.service

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.musicplayerfromdirectory.R
import com.example.musicplayerfromdirectory.settings.MyMediaPlayer
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.net.URI

class MusicService: Service() , PlayerListener {
    private val mediaPlayer = MyMediaPlayer(applicationContext)
    private val uri = Uri.EMPTY

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
    }
    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val uriPath: String? = intent?.getStringExtra("EXTRA_MESSAGE")
        mediaPlayer.playOrResumeMusic(mediaPlayer.getCurrentSong(Uri.parse(uriPath)))
        start(uriPath!!)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun playMusic() {
        mediaPlayer.playOrResumeMusic(mediaPlayer.getCurrentSong(uri))
    }

    override fun pauseMusic() {
        mediaPlayer.pauseMusic(mediaPlayer.getCurrentSong(uri))
    }

    override fun skipSongBack() {
        TODO("Not yet implemented")
    }

    override fun skipSongForward() {
        TODO("Not yet implemented")
    }

    override fun toggleReplaySong() {
        TODO("Not yet implemented")
    }

    override fun skipSongTo() {
        TODO("Not yet implemented")
    }


    private fun start(name: String){
        val notification = NotificationCompat.Builder(applicationContext, "running_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(name)
            .setContentText("4:00")
            .build()
        startForeground(1, notification)
    }
    enum class Actions{
        START, STOP
    }
}