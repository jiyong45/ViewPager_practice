package com.practice.viewpager_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var bannerSize = shopImg.size

    lateinit var currentText:TextView
    lateinit var totalText:TextView
    //val text by lazy { findViewById<TextView>(R.id.totalText) }
    //val text2 = findViewById<TextView>(R.id.totalText)
    // 추후 세가지 방법중에 언제 어떻게 써야하는지 확인 해보
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(shopImg)
        val mViewPager = findViewById<ViewPager>(R.id.pager)
        mViewPager.adapter = adapter

        currentText = findViewById<TextView>(R.id.currentText)
        totalText = findViewById<TextView>(R.id.totalText)
        totalText.setText(shopImg.size.toString())


        //  indicator
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {

                currentText.setText((position+1).toString())

            }
        })
    }
    companion object{
        val shopImg = arrayListOf(
            ItemPage("main_00","Yanko", "미리 Get 해야 할,\n 윈터 아우터 & 니트 ","쿠폰 & 페이백"),
            ItemPage("main_01","PROIRET", "BIRTHDAY\n BRANDS WEEK ","쿠폰 & 페이백"),
            ItemPage("main_02","GOLDEN GOOSE", "BIRTHDAY\n BRANDS WEEK ","쿠폰 & 페이백"),
            ItemPage("main_04","DELLA LANA", "OUTER\n NEW IN","델라라나 아우터 신상품")
        )
    }


}