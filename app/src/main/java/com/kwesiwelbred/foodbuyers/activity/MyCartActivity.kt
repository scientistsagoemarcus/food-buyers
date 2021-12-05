package com.kwesiwelbred.woocommerce.activity

import android.os.Bundle
import com.kwesiwelbred.woocommerce.AppBaseActivity
import com.kwesiwelbred.woocommerce.R
import com.kwesiwelbred.woocommerce.fragments.MyCartFragment
import com.kwesiwelbred.woocommerce.utils.Constants.AppBroadcasts.CART_COUNT_CHANGE
import com.kwesiwelbred.woocommerce.utils.extensions.BroadcastReceiverExt
import com.kwesiwelbred.woocommerce.utils.extensions.addFragment
import com.kwesiwelbred.woocommerce.utils.extensions.getCartListFromPref
import com.kwesiwelbred.woocommerce.utils.extensions.launchActivityWithNewTask
import kotlinx.android.synthetic.main.toolbar.*

class MyCartActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)
        setToolbar(toolbar)
        title = getString(R.string.menu_my_cart)

        val fr = MyCartFragment()
        addFragment(fr, R.id.container)
        BroadcastReceiverExt(this) {
            onAction(CART_COUNT_CHANGE) {
                if (fr.isAdded) {
                    fr.invalidateCartLayout(getCartListFromPref())
                }
            }
        }
    }

    fun shopNow() {
        launchActivityWithNewTask<DashBoardActivity>()
        finish()
    }

}
