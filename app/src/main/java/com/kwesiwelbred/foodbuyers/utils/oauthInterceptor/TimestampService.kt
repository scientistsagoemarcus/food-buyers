package com.kwesiwelbred.woocommerce.utils.oauthInterceptor

interface TimestampService {
    val timestampInSeconds: String
    val nonce: String
}