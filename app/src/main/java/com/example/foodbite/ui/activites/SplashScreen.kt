package com.example.foodbite.ui.activites

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.LottieCompositionFactory
import com.example.foodbite.R

class SplashScreen : AppCompatActivity() {
    private lateinit var animationView: LottieAnimationView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        animationView = findViewById(R.id.animation)

        LottieCompositionFactory.fromRawRes(this, R.raw.animations).addListener { composition: LottieComposition ->
            animationView.setComposition(composition)
            animationView.playAnimation()

            animationView.addAnimatorUpdateListener {
                if (it.animatedFraction == 1f) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        startWelcomeActivity()
                    }, 1000)
                }
            }
        }
    }
    private fun startWelcomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}