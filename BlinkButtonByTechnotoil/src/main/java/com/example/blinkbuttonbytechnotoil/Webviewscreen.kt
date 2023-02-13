package com.example.blinkbuttonbytechnotoil

import android.app.Activity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class Webviewscreen(url: String) : Activity() {
    var _url = url
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val theWebPage = WebView(this)
        theWebPage.settings.javaScriptEnabled = true
        theWebPage.settings.pluginState = WebSettings.PluginState.ON
        setContentView(theWebPage)
        theWebPage.loadUrl(_url)
    }
}