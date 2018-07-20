package no.larssyversen.fadderullan2018

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_more_info.*

class MoreInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        val custom_font_regular = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
        val custom_font_thin = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        txtInfoTitle.typeface = custom_font_regular
        btnInfoAbout.typeface = custom_font_thin
        btnInfoAtBI.typeface = custom_font_thin
        btnInfoFAQ.typeface = custom_font_thin
        btnInfoFacebook.typeface = custom_font_thin
        btnInfoInstagram.typeface = custom_font_thin
        btnInfoMaps.typeface = custom_font_thin
    }

    fun handleButtonMapsClicked(v: View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    fun handleButtonInstagramClicked(v: View) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(resources.getString(R.string.link_button_instagram))
        startActivity(i)
    }

    fun handleButtonFacebookClicked(v: View) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(resources.getString(R.string.link_button_facebook))
        startActivity(i)
    }

    fun handleButtonBIClicked(v: View) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(resources.getString(R.string.link_button_bi))
        startActivity(i)
    }

    fun handleButtonAboutClicked(v: View) {
        val text = resources.getString(R.string.dialog_text_about)
        val view: View = layoutInflater.inflate(R.layout.sponsorlist_dialog, null)
        val itemText: TextView = view.findViewById(R.id.txtInfo)
        itemText.text = text

        var ad: AlertDialog.Builder? = AlertDialog.Builder(this)
        ad!!.setView(view)

        ad.setPositiveButton(R.string.dialogOk, null)

        ad.show()
        ad = null
    }


}
