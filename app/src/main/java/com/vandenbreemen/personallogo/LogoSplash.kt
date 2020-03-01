package com.vandenbreemen.personallogo

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.logo_splash.*

class LogoSplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logo_splash)
    }

    override fun onResume() {
        super.onResume()

        val kevinAnimator = getAnimator()
        kevinAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            kevin.alpha = value
        }
        kevinAnimator.startDelay = 500


        val flareAnimator = getAnimator()
        flareAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            flare.alpha = value
        }

        flareAnimator.start()
        kevinAnimator.start()


    }

    fun getAnimator(): ValueAnimator {
        val animator = ValueAnimator.ofFloat(0.0f, 1.0f)
        animator.duration = 1500
        animator.interpolator = LinearInterpolator()

        return animator

    }
}
