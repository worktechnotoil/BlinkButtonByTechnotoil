package com.example.blinkbuttonbytechnotoil

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebViewClient

class WebViewScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webiew_layout)

        showwebview("https://www.geeksforgeeks.org");
    }

    fun showwebview(url: String) {
        var webView = findViewById<WebView>(R.id.web)
        webView.webViewClient = WebViewClient()

        webView.loadUrl(url)

        webView.settings.javaScriptEnabled = true

        webView.settings.setSupportZoom(true)
    }

}