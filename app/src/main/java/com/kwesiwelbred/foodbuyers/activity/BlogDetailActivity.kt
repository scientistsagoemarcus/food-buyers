package com.kwesiwelbred.woocommerce.activity

import android.os.Bundle
import com.kwesiwelbred.woocommerce.AppBaseActivity
import com.kwesiwelbred.woocommerce.R
import com.kwesiwelbred.woocommerce.models.Blog
import com.kwesiwelbred.woocommerce.utils.Constants.KeyIntent.DATA
import com.kwesiwelbred.woocommerce.utils.extensions.loadImageFromUrl
import kotlinx.android.synthetic.main.activity_blog_detail.*
import kotlinx.android.synthetic.main.toolbar.*

class BlogDetailActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_detail)

        setToolbar(toolbar)

        val blog = intent.getSerializableExtra(DATA) as Blog
        title = blog.title

        ivProduct.loadImageFromUrl(blog.image!!)
        tvTitle.text = blog.title
        tvPublishDate.text = blog.publish_date
        tvDescription.text = blog.description
    }
}
