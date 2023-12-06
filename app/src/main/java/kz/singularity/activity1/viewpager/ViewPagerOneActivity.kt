package kz.singularity.activity1.viewpager

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import kz.singularity.activity1.R

class ViewPagerOneActivity : AppCompatActivity() {

    @BindView(R.id.vp_main)
    lateinit var vpMain: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_one)
        ButterKnife.bind(this, this)

        setupViewPager()
    }

    private fun setupViewPager() {
        vpMain.adapter = MyFragmentPagerAdapter(supportFragmentManager)
    }
}