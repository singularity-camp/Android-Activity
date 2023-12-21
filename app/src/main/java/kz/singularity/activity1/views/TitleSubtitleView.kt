package kz.singularity.activity1.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import kz.singularity.activity1.R

private const val TITLE_DEFAULT_VALUE = ""
private const val SUBTITLE_DEFAULT_VALUE = ""

class TitleSubtitleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    @BindView(R.id.tv_title)
    lateinit var tvTitle: TextView
    @BindView(R.id.tv_subtitle)
    lateinit var tvSubtitle: TextView
    @BindView(R.id.btn_main)
    lateinit var btnMain: Button

    var clickListener: View.OnClickListener? = null

    init {
        inflate(context, R.layout.view_title_w_subtitle, this)
        ButterKnife.bind(this)

        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.TitleSubtitleView, defStyleAttr, 0)
        val title = typedArray.getString(R.styleable.TitleSubtitleView_title) ?: TITLE_DEFAULT_VALUE
        val subtitle = typedArray.getString(R.styleable.TitleSubtitleView_subtitle) ?: SUBTITLE_DEFAULT_VALUE
        typedArray.recycle()

        setTitle(title)
        setSubtitle(subtitle)
        setOnBtnClickListener()
    }

    fun setTitle(title: String) {
        tvTitle.text = title
    }

    fun setSubtitle(subtitle: String) {
        tvSubtitle.text = subtitle
    }

    private fun setOnBtnClickListener () {
        btnMain.setOnClickListener {
            clickListener?.onClick(btnMain)
        }
    }

}