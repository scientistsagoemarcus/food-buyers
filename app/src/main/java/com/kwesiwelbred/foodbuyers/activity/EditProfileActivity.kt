package com.kwesiwelbred.woocommerce.activity

import android.os.Bundle
import com.kwesiwelbred.woocommerce.AppBaseActivity
import com.kwesiwelbred.woocommerce.R
import com.kwesiwelbred.woocommerce.fragments.ProfileFragment
import com.kwesiwelbred.woocommerce.utils.extensions.addFragment
import kotlinx.android.synthetic.main.toolbar.*

class EditProfileActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        setToolbar(toolbar)
        title=getString(R.string.lbl_edit_profile)
        addFragment(ProfileFragment(),R.id.profilecontainer)
    }
}
