package no.larssyversen.fadderullan2018

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_groups.*
import kotlinx.android.synthetic.main.activity_program.*

class GroupsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        btnGroupsEconomy.typeface = custom_font
        btnGroupsMarketing.typeface = custom_font
        btnGroupsRealestate.typeface = custom_font
        btnGroupsOthers.typeface = custom_font
    }


    fun handleEconomyButtonClicked(v: View) {
        val docLink: String = resources.getString(R.string.link_google_doc_economy)
        val webViewTitleId: Int = R.string.title_activity_groups
        val intent = Intent(this, WebViewActivity::class.java)

        intent.putExtra("no.larssyversen.fadderullan2018.LINK", docLink)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", webViewTitleId)
        startActivity(intent)
    }

    fun handleMarketingButtonClicked(v: View) {
        val docLink: String = resources.getString(R.string.link_google_doc_marketing)
        val webViewTitleId: Int = R.string.title_activity_groups
        val intent = Intent(this, WebViewActivity::class.java)

        intent.putExtra("no.larssyversen.fadderullan2018.LINK", docLink)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", webViewTitleId)
        startActivity(intent)
    }

    fun handleRealestateButtonClicked(v: View) {
        val docLink: String = resources.getString(R.string.link_google_doc_realestate)
        val webViewTitleId: Int = R.string.title_activity_groups
        val intent = Intent(this, WebViewActivity::class.java)

        intent.putExtra("no.larssyversen.fadderullan2018.LINK", docLink)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", webViewTitleId)
        startActivity(intent)
    }

    fun handleOthersButtonClicked(v: View) {
        var docLink: String = resources.getString(R.string.link_google_doc_others)
        val webViewTitleId: Int = R.string.title_activity_groups
        val intent = Intent(this, WebViewActivity::class.java)

        intent.putExtra("no.larssyversen.fadderullan2018.LINK", docLink)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", webViewTitleId)
        startActivity(intent)
    }
}
