package com.leblebi.alone.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings


class BGAndroidServices: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    private lateinit var player: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI)
        player.isLooping = true
        player.start()

        return START_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }


}