package kz.singularity.activity1.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import kz.singularity.activity1.R

private const val IS_UNDERLINED_DEFAULT_VALUE = true

class UnderlinedTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): AppCompatTextView(context, attrs, defStyleAttr) {

    private var isUnderlined = IS_UNDERLINED_DEFAULT_VALUE

    init {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.UnderlinedTextView, defStyleAttr, 0)
        isUnderlined = typedArray.getBoolean(R.styleable.UnderlinedTextView_isUnderlined, IS_UNDERLINED_DEFAULT_VALUE)
        typedArray.recycle()

        paint.isUnderlineText = isUnderlined
    }

}