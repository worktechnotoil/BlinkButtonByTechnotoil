package com.example.blinkbuttonbytechnotoil

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebViewClient

class WebViewScreen(url: String) : AppCompatActivity() {
    val _url: String

    init {
        _url = url
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webiew_layout)

        showwebview(_url);
    }

    fun showwebview(url: String) {
        var webView = findViewById<WebView>(R.id.web)
        webView.webViewClient = WebViewClient()

        webView.loadUrl(url)

        webView.settings.javaScriptEnabled = true

        webView.settings.setSupportZoom(true)
    }

}