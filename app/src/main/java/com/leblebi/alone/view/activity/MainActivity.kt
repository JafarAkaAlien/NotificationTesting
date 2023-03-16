package com.leblebi.alone.view.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.leblebi.alone.R
import com.leblebi.alone.databinding.ActivityMainBinding
import com.leblebi.alone.services.BGAndroidServices

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "1"
    private val CHANNEL_NAME = "Main"
    private val NOTIFICATION_ID: Int = 0
    val vibrationPattern = longArrayOf(500)
    private lateinit var binding : ActivityMainBinding
    private var serviceOnRun : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createNotificationChannel()

        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.notificon)
            .setContentTitle("Musigi var onsuz")
            .setContentText("GebereBilersen")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVibrate(vibrationPattern)
            .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)




        binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(this,BGAndroidServices::class.java)
        binding.startButton.setOnClickListener{
            if(serviceOnRun){
                notificationManager.notify(NOTIFICATION_ID,notification)
            }
            else{
                Toast.makeText(this, "Starting music", Toast.LENGTH_SHORT).show()
                startService(intent)
                serviceOnRun=true
            }
        }
        binding.stopButton.setOnClickListener {
            stopService(intent)
            serviceOnRun=false
        }



        setContentView(binding.root)

    }

    fun createNotificationChannel(){
        val attr = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ALARM)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build()
        val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH).apply {
            lightColor = Color.CYAN
            setSound(Settings.System.DEFAULT_NOTIFICATION_URI,attr )
            vibrationPattern =vibrationPattern
            enableVibration(true)
            enableLights(true)



        }
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }

}