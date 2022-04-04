package com.practice.viewpager_practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewPagerAdapter(private val context : Context) : PagerAdapter() {


    private var layoutInflater : LayoutInflater? = null

    val Image = arrayOf(
        R.drawable.main_00,
        R.drawable.main_01,
        R.drawable.main_02
    )

    override fun isViewFromObject(view: View, 'object' : Any) : Boolean {
        return view === 'object'
    }

    override fun getCount(): Int {
        return Image.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.page,null)
        val image = v.findViewById<ImageView>(R.id.pagerImg)
        image.setImageResource(Image[position])
        val vp = container as ViewPager
        vp.addView(v, 0)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = 'object' as View
        vp.removeView(v)
    }
}