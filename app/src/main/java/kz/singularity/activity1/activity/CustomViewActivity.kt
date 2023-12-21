package kz.singularity.activity1.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import kz.singularity.activity1.R
import kz.singularity.activity1.showToast
import kz.singularity.activity1.views.TitleSubtitleView
import kz.singularity.activity1.views.UnderlinedTextView

class CustomViewActivity : AppCompatActivity() {

    @BindView(R.id.tv_basic)
    lateinit var tvBasic: TextView
    @BindView(R.id.tsv_first)
    lateinit var tsvFirst: TitleSubtitleView
    @BindView(R.id.lt_main)
    lateinit var ltMain: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        ButterKnife.bind(this)

        tsvFirst.clickListener = View.OnClickListener { showToast("Clicked on the button inside custom view") }
        ltMain.addView(TitleSubtitleView(this).apply {
            setTitle("Custom View")
            setSubtitle("Created programmatically")
        })
    }

}