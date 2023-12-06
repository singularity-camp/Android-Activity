package kz.singularity.activity1.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kz.singularity.activity1.R

class MyPagerAdapter : PagerAdapter() {

    private val layouts = listOf(
        R.layout.viewpager1_text,
        R.layout.viewpager1_button
    )

    override fun instantiateItem(collection: ViewGroup, position: Int): View {
        val inflater = LayoutInflater.from(collection.context)
        val layout = inflater.inflate(layouts[position], collection, false) as ViewGroup
        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, obj: Any) {
        collection.removeView(obj as View?)
    }

    override fun getCount(): Int =
        layouts.size

    override fun isViewFromObject(view: View, obj: Any): Boolean =
        view === obj

    override fun getPageTitle(position: Int): CharSequence =
        "Title $position"
}