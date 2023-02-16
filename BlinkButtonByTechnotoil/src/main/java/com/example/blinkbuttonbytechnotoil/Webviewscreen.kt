package com.example.blinkbuttonbytechnotoil

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView

class Webviewscreen: Activity() {
    var data = "FirstActivity"
    var INSTANCE: Webviewscreen? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        INSTANCE=this;
        super.onCreate(savedInstanceState)
        val theWebPage = WebView(this)
        theWebPage.settings.javaScriptEnabled = true
        theWebPage.settings.pluginState = WebSettings.PluginState.ON
        theWebPage.setWebChromeClient(object : WebChromeClient() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onPermissionRequest(request: PermissionRequest) {
                request.grant(request.resources)
            }
        })
        setContentView(theWebPage)
        theWebPage.loadUrl("https://cdn.camweara.com/camweara_jewelry_client/index.php?skus=demo_1020054,demo_panerai1&company_name=Teststore&1676527013359")
    }
    fun getActivityInstance(): Webviewscreen? {
        return INSTANCE
    }

    @JvmName("getData1")
    fun getData(): String? {
        return data
    }
}