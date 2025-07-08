package com.appnapps.snackx

import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator

object SnackXAnimator {

    fun applyIn(view: View, style: SnackX.AnimationStyle, duration: Long, position: SnackX.Position) {
        when (style) {
            SnackX.AnimationStyle.FADE -> {
                view.alpha = 0f
                view.animate().alpha(1f).setDuration(duration).start()
            }
            SnackX.AnimationStyle.SLIDE -> {
                view.translationY = if (position == SnackX.Position.BOTTOM) 100f else -100f
                view.alpha = 0f
                view.animate().translationY(0f).alpha(1f).setDuration(duration).start()
            }
            SnackX.AnimationStyle.SCALE -> {
                view.scaleX = 0.5f
                view.scaleY = 0.5f
                view.alpha = 0f
                view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)
                    .setDuration(duration)
                    .start()
            }
            SnackX.AnimationStyle.BOUNCE -> {
                view.scaleX = 0.3f
                view.scaleY = 0.3f
                view.alpha = 0f

                // Scale bounce 애니메이션
                val scaleAnimator = view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .alpha(1f)
                    .setDuration(duration)
                    .setInterpolator(OvershootInterpolator(2f))

                // 좌우 흔들림 (Shake)
                val shake = ObjectAnimator.ofFloat(view, "translationX",
                    0f, 15f, -15f, 10f, -10f, 5f, -5f, 0f
                ).setDuration(duration)

                // 동시에 실행
                shake.start()
                scaleAnimator.start()
            }


        }
    }

    fun applyOut(view: View, style: SnackX.AnimationStyle, duration: Long, position: SnackX.Position, onEnd: () -> Unit) {
        when (style) {
            SnackX.AnimationStyle.FADE -> {
                view.animate().alpha(0f).setDuration(duration).withEndAction(onEnd).start()
            }
            SnackX.AnimationStyle.SLIDE -> {
                view.animate()
                    .translationY(if (position == SnackX.Position.BOTTOM) 100f else -100f)
                    .alpha(0f)
                    .setDuration(duration)
                    .withEndAction(onEnd)
                    .start()
            }
            SnackX.AnimationStyle.SCALE -> {
                view.animate()
                    .scaleX(0.5f)
                    .scaleY(0.5f)
                    .alpha(0f)
                    .setDuration(duration)
                    .withEndAction(onEnd)
                    .start()
            }
            SnackX.AnimationStyle.BOUNCE -> {
                view.animate()
                    .scaleX(0.8f)
                    .scaleY(0.8f)
                    .alpha(0f)
                    .setDuration(duration)
                    .withEndAction(onEnd)
                    .start()
            }
        }
    }
}
