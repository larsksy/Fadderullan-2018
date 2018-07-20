package no.larssyversen.fadderullan2018

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        webView.webViewClient = WebViewClient()

        if (intent.hasExtra("no.larssyversen.fadderullan2018.LINK")) {
            val bundle = intent.extras
            val link = bundle.getString("no.larssyversen.fadderullan2018.LINK")
            val title = bundle.getInt("no.larssyversen.fadderullan2018.TITLE")
            txtWebViewTitle.text = resources.getString(title)
            webView.loadUrl(link)
        }

    }
}
