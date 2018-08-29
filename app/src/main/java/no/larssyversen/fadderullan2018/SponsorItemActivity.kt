package no.larssyversen.fadderullan2018

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Typeface
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ViewAnimator
import kotlinx.android.synthetic.main.activity_sponsor_item.*
import java.text.SimpleDateFormat
import java.util.*

class SponsorItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor_item)

        val bundle = intent.extras
        val title = bundle.getString("no.larssyversen.fadderullan2018.TITLE")
        val deals = bundle.getString("no.larssyversen.fadderullan2018.DEALS")
        val logo = bundle.getInt("no.larssyversen.fadderullan2018.LOGO")

        txtSponsorItemTitle.text = title
        txtSponsorItemDeals.text = deals
        sponsorItemImageLogo.setImageResource(logo)

        val custom_font_regular = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
        val custom_font_thin = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        txtSponsorItemTitle.typeface = custom_font_thin
        txtSponsorItemDeals.typeface = custom_font_regular

        if (title.equals("Byhaven") || title.equals("Mercursenteret")) {
            btnSponsorAction.visibility = Button.VISIBLE
        }

    }

    fun handleActionButtonClicked(v: View) {
        val link = resources.getString(R.string.link_google_doc_shopping)

        if (!DateManager.dateCalc("2018:08:20 00:00:00")) {
            var ad: AlertDialog.Builder? = AlertDialog.Builder(this)
            ad!!.setTitle(R.string.dialog_not_available)
            ad.setMessage(R.string.dialog_availability_shopping)
            ad.setPositiveButton(R.string.dialogOk, null)

            ad.show()
            ad = null
            return
        }

        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("no.larssyversen.fadderullan2018.LINK", link)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", R.string.webview_title_offers)
        startActivity(intent)
    }
}
