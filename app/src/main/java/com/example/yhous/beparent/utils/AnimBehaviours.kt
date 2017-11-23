package com.example.yhous.beparent.utils

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.view.View
import android.widget.Button
import com.example.yhous.beparent.R

/**
 * Created by yannickhoussin on 23/11/2017.
 */
object AnimBehaviours {
  fun animateBtn(view: View, context: Context, duration: Long) {
    val animateBtn = AnimatorInflater.loadAnimator(context, R.animator.scaly) as AnimatorSet
    val bothAnimatorSet = AnimatorSet()
    animateBtn.setTarget(view)
    bothAnimatorSet.play(animateBtn)
    bothAnimatorSet.duration = duration
    bothAnimatorSet.start()
  }
}