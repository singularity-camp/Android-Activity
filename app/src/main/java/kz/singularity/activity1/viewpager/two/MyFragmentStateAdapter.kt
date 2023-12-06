package kz.singularity.activity1.viewpager.two

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kz.singularity.activity1.activity.ui.gallery.GalleryFragment
import kz.singularity.activity1.activity.ui.home.HomeFragment
import kz.singularity.activity1.activity.ui.slideshow.SlideshowFragment

class MyFragmentStateAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
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
}