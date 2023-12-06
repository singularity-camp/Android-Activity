package kz.singularity.activity1.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kz.singularity.activity1.activity.ui.gallery.GalleryFragment
import kz.singularity.activity1.activity.ui.home.HomeFragment
import kz.singularity.activity1.activity.ui.slideshow.SlideshowFragment

class MyFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {


    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                GalleryFragment()
            }
            else -> {
                SlideshowFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Home"
            1 -> "Gallery"
            else -> "Slideshow"
        }
    }
}