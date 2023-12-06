package kz.singularity.activity1.viewpager

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.tabs.TabLayout
import kz.singularity.activity1.R

class ViewPagerOneActivity : AppCompatActivity() {

    @BindView(R.id.vp_main)
    lateinit var vpMain: ViewPager

    @BindView(R.id.tv_indicator)
    lateinit var tvIndicator: TextView

    @BindView(R.id.btn_left)
    lateinit var btnLeft: Button

    @BindView(R.id.btn_right)
    lateinit var btnRight: Button

    @BindView(R.id.tl_main)
    lateinit var tlMain: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_one)
        ButterKnife.bind(this, this)

        setupViewPager()
    }

    private fun setupViewPager() {
        vpMain.adapter = MyFragmentPagerAdapter(supportFragmentManager)
        vpMain.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                setIndicatorText(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
        tlMain.setupWithViewPager(vpMain)
        setIndicatorText(vpMain.currentItem)
    }

    private fun setIndicatorText(currentPosition: Int) {
        tvIndicator.text = "${currentPosition + 1}/3"
    }

    @OnClick(R.id.btn_left)
    fun onLeftClick() {
        vpMain.setCurrentItem(vpMain.currentItem - 1)
    }

    @OnClick(R.id.btn_right)
    fun onRightClick() {
        vpMain.setCurrentItem(vpMain.currentItem + 1)
    }

    override fun onDestroy() {
        super.onDestroy()
        vpMain.clearOnPageChangeListeners()
    }

}