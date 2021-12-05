package com.kwesiwelbred.woocommerce.activity

import android.os.Bundle
import com.kwesiwelbred.woocommerce.AppBaseActivity
import com.kwesiwelbred.woocommerce.R
import com.kwesiwelbred.woocommerce.fragments.SearchFragment
import com.kwesiwelbred.woocommerce.utils.extensions.addFragment

class SearchActivity : AppBaseActivity() {

    private val mSearchFragment = SearchFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search2)
        addFragment(mSearchFragment, R.id.fragmentContainer)
    }

}