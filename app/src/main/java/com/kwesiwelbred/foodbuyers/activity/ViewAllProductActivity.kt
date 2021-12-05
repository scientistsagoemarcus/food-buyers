package com.kwesiwelbred.woocommerce.activity

import android.os.Bundle
import com.kwesiwelbred.woocommerce.AppBaseActivity
import com.kwesiwelbred.woocommerce.R
import com.kwesiwelbred.woocommerce.fragments.ViewAllProductFragment
import com.kwesiwelbred.woocommerce.utils.Constants
import com.kwesiwelbred.woocommerce.utils.Constants.AppBroadcasts.CART_COUNT_CHANGE
import com.kwesiwelbred.woocommerce.utils.extensions.BroadcastReceiverExt
import com.kwesiwelbred.woocommerce.utils.extensions.replaceFragment
import kotlinx.android.synthetic.main.toolbar.*

class ViewAllProductActivity : AppBaseActivity() {

    private var mFragment: ViewAllProductFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        setToolbar(toolbar)

        title = intent.getStringExtra(Constants.KeyIntent.TITLE)
        val mViewAllId = intent.getIntExtra(Constants.KeyIntent.VIEWALLID, 0)
        val mCategoryId = intent.getIntExtra(Constants.KeyIntent.KEYID, -1)

        mFragment = ViewAllProductFragment.getNewInstance(mViewAllId, mCategoryId)
        replaceFragment(mFragment!!, R.id.fragmentContainer)
        BroadcastReceiverExt(this) { onAction(CART_COUNT_CHANGE) { mFragment?.setCartCount() } }
        showBannerAds()
    }
}