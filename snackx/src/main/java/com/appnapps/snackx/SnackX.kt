package com.appnapps.snackx

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.*
import androidx.core.content.ContextCompat

object SnackX {
    enum class Position { TOP, BOTTOM }
    enum class AnimationStyle { FADE, SLIDE, SCALE, BOUNCE }  // 👈 여기에 함께 선언

    fun show(
        context: Context,
        message: String,
        iconResId: Int? = null,
        duration: Long = 2000,
        position: Position = Position.BOTTOM,
        backgroundColor: Int = Color.BLACK,
        textColor: Int = Color.WHITE,
        animation: AnimationStyle = AnimationStyle.FADE,
        animationDuration: Long = 300L // 👈 추가
    ) {
        val activity = context as? Activity ?: return
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.snackx_view, null)

        val messageView = view.findViewById<TextView>(R.id.snackx_message)
        val iconView = view.findViewById<ImageView>(R.id.snackx_icon)

        messageView.text = message
        messageView.setTextColor(textColor)

        iconResId?.let {
            iconView.setImageResource(it)
            iconView.visibility = View.VISIBLE
        }

        // ✅ Drawable에서 배경색만 변경
        val background = view.background as? GradientDrawable
        background?.setColor(backgroundColor)

        val rootView = activity.findViewById<ViewGroup>(android.R.id.content)
        val layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.gravity = if (position == Position.BOTTOM) Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
        else Gravity.TOP or Gravity.CENTER_HORIZONTAL
        layoutParams.bottomMargin = 100.dp

        rootView.addView(view, layoutParams)

        // 애니메이션 in
        SnackXAnimator.applyIn(view, animation, animationDuration, position)

        // 애니메이션 out
        Handler(Looper.getMainLooper()).postDelayed({
            SnackXAnimator.applyOut(view, animation, animationDuration, position) {
                rootView.removeView(view)
            }
        }, duration)
    }

    // 확장 함수로 dp 변환
    private val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()
}