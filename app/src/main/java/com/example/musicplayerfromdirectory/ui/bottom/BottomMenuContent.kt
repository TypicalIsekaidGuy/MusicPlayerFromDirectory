package com.example.musicplayerfromdirectory.ui.bottom

import kotlin.reflect.KClass
import android.content.Intent
import androidx.annotation.DrawableRes

data class BottomMenuContent(
    val title: String,
    @DrawableRes val iconId: Int,
    val isActive: Boolean
)