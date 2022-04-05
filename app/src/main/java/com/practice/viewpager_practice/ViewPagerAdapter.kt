package com.practice.viewpager_practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewPagerAdapter(private val list: ArrayList<ItemPage>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.page,container,false)

        val pagerImage = view.findViewById<ImageView>(R.id.pagerImg)
        val mainTitle = view.findViewById<TextView>(R.id.mainTitle)
        val subTitle = view.findViewById<TextView>(R.id.subTitle)
        val descript = view.findViewById<TextView>(R.id.descript)

        pagerImage.setImageResource(list[position].getItemId(container.context))
        mainTitle.text = list[position].mainTitle
        subTitle.text = list[position].subTitle
        descript.text = list[position].descript

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return list.size
    }



}