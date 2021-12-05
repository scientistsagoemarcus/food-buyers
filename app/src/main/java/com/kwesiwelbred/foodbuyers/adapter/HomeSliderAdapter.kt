package com.kwesiwelbred.woocommerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.kwesiwelbred.woocommerce.R
import com.kwesiwelbred.woocommerce.models.SliderImagesResponse
import com.kwesiwelbred.woocommerce.utils.extensions.loadImageFromUrl
import com.kwesiwelbred.woocommerce.utils.extensions.onClick
import com.kwesiwelbred.woocommerce.utils.extensions.openCustomTab
import kotlinx.android.synthetic.main.item_slider.view.*

class HomeSliderAdapter(var context: Context, private var mImg: ArrayList<SliderImagesResponse>) : PagerAdapter() {
    var size: Int? = null

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slider, parent, false)

        view.imgSlider.loadImageFromUrl(mImg[position].image)
        view.imgSlider.onClick { if (mImg[position].url.isNotEmpty()) context.openCustomTab(mImg[position].url) }

        parent.addView(view)
        return view
    }

    override fun isViewFromObject(v: View, `object`: Any): Boolean = v === `object` as View

    override fun getCount(): Int = mImg.size
    // override fun getCount(): Int = if (size == null || mImg.size <= size!!) mImg.size  else  size!!
    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) = parent.removeView(`object` as View)

}
