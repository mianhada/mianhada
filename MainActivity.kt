package com.example.myapplication

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.NotificationCompat
import android.os.Build
import android.app.NotificationManager
import android.app.NotificationChannel
import android.content.Context
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import android.widget.ImageView


//a=0 means user doesn't allow yet, a=1 means user allow AG to use their personal information
var a :Int=0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.play)
        // if users click 'play' button
        button.setOnClickListener {
            val url = "https://chrislee0326.github.io/AGgame/cardgame.html" // open website_card
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)

        }
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(R.drawable.card_game_image)

        val next = findViewById<Button>(R.id.next)
        //if users click 'next' button
        next.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                when(a) {
                    0->findViewById<TextView>(R.id.permission_text).text="please allow permission"
                    else->findViewById<TextView>(R.id.permission_text).text="move to next page, please add the code to moving next page" //please add the code to moving next page here
                }
            }
        })
    }
}

