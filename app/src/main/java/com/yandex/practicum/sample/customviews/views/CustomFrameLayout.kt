package com.yandex.practicum.sample.customviews.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.yandex.practicum.sample.customviews.R

class CustomFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var circleView: PracticumCircleView
    private var button: ColorChangeButton

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_compound, this, true)

        circleView = findViewById(R.id.circle_view)
        button = findViewById(R.id.button)
    }
}
