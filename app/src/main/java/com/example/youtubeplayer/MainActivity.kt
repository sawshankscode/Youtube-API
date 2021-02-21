package com.example.youtubeplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity(){
    private val videoList= arrayListOf<String>("LMSkM-WIXoI","FopqfajeDf0","XNcuFOOkxW8")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        player.initialize(getString(R.string.api),object: YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1!!.loadVideo("FopqfajeDf0")
                p1.play()
                p1.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
                next.setOnClickListener {
                    val random=(0 until (videoList.size)).random()
                    p1!!.loadVideo(videoList[random])
                    p1.play()
                    p1.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)

                }


            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext,"error occured",Toast.LENGTH_SHORT).show()
            }

        })
        next.setOnClickListener {
            val random=(0 until (videoList.size)).random()


        }






    }
}