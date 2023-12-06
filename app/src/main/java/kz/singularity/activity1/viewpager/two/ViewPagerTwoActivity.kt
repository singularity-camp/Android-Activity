package kz.singularity.activity1.viewpager.two

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import kz.singularity.activity1.R
import kz.singularity.activity1.viewpager.MyFragmentPagerAdapter

class ViewPagerTwoActivity : AppCompatActivity() {
    @BindView(R.id.vp_main)
    lateinit var vpMain: ViewPager2

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
        setContentView(R.layout.activity_view_pager_two)
        ButterKnife.bind(this, this)

        setupViewPager()
    }

    private fun setupViewPager() {
        vpMain.adapter = MyFragmentStateAdapter(this)
        vpMain.registerOnPageChangeCallback(object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setIndicatorText(position)
            }
        })
        TabLayoutMediator(tlMain, vpMain
        ) { tab, position ->
            val title = when (position) {
                0 -> "Home"
                1 -> "Gallery"
                else -> "Slideshow"
            }
            tab.text = title
        }.attach()

        vpMain.setPageTransformer(MarginPageTransformer(40))

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
//        vpMain.clearOnPageChangeListeners()
    }
}