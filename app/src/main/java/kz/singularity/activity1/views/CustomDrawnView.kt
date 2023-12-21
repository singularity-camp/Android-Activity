package kz.singularity.activity1.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomDrawnView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    val rectPaint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.FILL
    }

    val circlePaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(0f,0f, 100f, 100f, rectPaint)
        canvas.drawCircle(200f, 200f, 100f, circlePaint)
    }

}