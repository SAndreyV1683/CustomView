package com.yandex.practicum.sample.customviews.views

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.appcompat.widget.AppCompatButton

class ColorChangeButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {
    init {
        setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_light))

        setOnClickListener {
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
        }
    }
}
