package no.larssyversen.fadderullan2018

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_groups.*

class GroupsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)

        webViewGroups.loadUrl(resources.getString(R.string.groups_webview_link))

    }
}
