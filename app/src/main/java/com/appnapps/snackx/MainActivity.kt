package com.appnapps.snackx

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SnackX.show(
            context = this,
            message = "저장되었습니다!",
            iconResId = R.drawable.ic_check,
            duration = 2500,
            position = SnackX.Position.TOP,
            backgroundColor = Color.DKGRAY,
            textColor = Color.WHITE
        )
    }
}

