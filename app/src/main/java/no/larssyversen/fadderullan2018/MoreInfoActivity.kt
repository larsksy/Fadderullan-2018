package no.larssyversen.fadderullan2018

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MoreInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)
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
