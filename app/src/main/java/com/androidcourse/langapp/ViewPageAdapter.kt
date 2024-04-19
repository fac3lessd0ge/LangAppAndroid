package com.androidcourse.langapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val context: Context) : PagerAdapter() {

    private val images = intArrayOf(
        R.drawable.onboarding_first,
        R.drawable.onboarding_second,
        R.drawable.onboarding_third,
    )

    private val headings = intArrayOf(
        R.string.heading_one,
        R.string.heading_two,
        R.string.heading_three,
    )

    private val description = intArrayOf(
        R.string.desc_one,
        R.string.desc_two,
        R.string.desc_three,
    )

    override fun getCount(): Int {
        return headings.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.slider_layout, container, false)
        val slideTitleImage = view.findViewById<ImageView>(R.id.titleImage)
        val slideHeading = view.findViewById<TextView>(R.id.texttitle)
        val slideDescription = view.findViewById<TextView>(R.id.textdescription)
        slideTitleImage.setImageResource(images[position])
        slideHeading.setText(headings[position])
        slideDescription.setText(description[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}