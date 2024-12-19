package com.yandex.practicum.sample.customviews.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.yandex.practicum.sample.customviews.R

class PracticumCircleView: View {

    // Constructor for programmatic instantiation
    constructor(context: Context) : super(context) {
        init(null, 0, 0)
    }

    // Constructor for XML inflation
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs, 0, 0)
    }

    // Constructor for XML inflation with style
    constructor(
        context: Context,
        attrs: AttributeSet?,
        @AttrRes defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(attrs, defStyleAttr, 0)
    }

    // Constructor for XML inflation with style and default style
    constructor(
        context: Context,
        attrs: AttributeSet,
        @AttrRes defStyleAttr: Int,
        @StyleRes defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs, defStyleAttr, defStyleRes)
    }

    private var circleColor: Int = Color.BLACK
    private var circleRadius: Float = 0f
    private var paint: Paint = Paint()

    private fun init(
        attrs: AttributeSet?,
        @AttrRes defStyleAttr: Int,
        @StyleRes defStyleRes: Int
    ) {
        val typedArray: TypedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.PracticumCircleView,
            defStyleAttr,
            defStyleRes
        )

        circleColor = context.getColor(R.color.default_circle_color)
        circleRadius = context.resources.getDimension(R.dimen.default_circle_radius)

        try {
            circleColor = typedArray.getColor(
                R.styleable.PracticumCircleView_practicum_circleColor,
                circleColor
            )
            circleRadius = typedArray.getDimension(
                R.styleable.PracticumCircleView_practicum_circleRadius,
                circleRadius
            )
        } finally {
            typedArray.recycle()
        }

        paint.color = circleColor
    }

    fun setCircleColor(color: Int) {
        circleColor = color
        invalidate()
    }

    fun setCircleRadius(radius: Float) {
        circleRadius = radius
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = (circleRadius * 2).toInt() + paddingLeft + paddingRight
        val desiredHeight = (circleRadius * 2).toInt() + paddingTop + paddingBottom

        val width = resolveSize(desiredWidth, widthMeasureSpec)
        val height = resolveSize(desiredHeight, heightMeasureSpec)

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, height / 2f, circleRadius, paint)
    }
}
