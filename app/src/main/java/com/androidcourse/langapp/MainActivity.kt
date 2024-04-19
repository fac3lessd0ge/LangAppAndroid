package com.androidcourse.langapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var slideViewPager: ViewPager
    private lateinit var dotLayout: LinearLayout
    private lateinit var nextButton: Button
    private lateinit var skipButton: Button

    private lateinit var dots: Array<TextView?>
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        nextButton = findViewById(R.id.nextbtn)
        skipButton = findViewById(R.id.skipButton)


        nextButton.setOnClickListener {

            if (getItem(0) < 2)
                slideViewPager.setCurrentItem(getItem(1), true)
            else {
                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
                finish()
            }

        }

        skipButton.setOnClickListener {

            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()

        }

        slideViewPager = findViewById(R.id.slideViewPager)
        dotLayout = findViewById(R.id.indicator_layout)

        viewPagerAdapter = ViewPagerAdapter(this)

        slideViewPager.adapter = viewPagerAdapter

        setUpIndicator(0)
        slideViewPager.addOnPageChangeListener(viewListener)
    }

    fun setUpIndicator(position: Int){

        dots = arrayOfNulls(3)
        dotLayout.removeAllViews()

        for (i in dots.indices) {

            dots[i] = TextView(this)
            dots[i]!!.text = "o"
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(resources.getColor(R.color.purple_200, application.theme))
            dotLayout.addView(dots[i])

        }

        dots[position]!!.setTextColor(resources.getColor(R.color.background, application.theme))

    }

    private var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        }

        override fun onPageSelected(position: Int) {

            setUpIndicator(position)


        }

        override fun onPageScrollStateChanged(state: Int) {

        }
    }

    private fun getItem(i: Int): Int {

        return slideViewPager.currentItem + i
    }

}