package no.larssyversen.fadderullan2018

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_more_info.*
import kotlinx.android.synthetic.main.activity_sponsor.*
import java.text.SimpleDateFormat
import java.util.*



class SponsorActivity : AppCompatActivity() {

    // references to our images
    companion object {
        val mSponsorLogos = arrayOf<Int>(
                R.drawable.mercur, R.drawable.byhaven,
                R.drawable.eplehuset, R.drawable.studio,
                R.drawable.egon, R.drawable.heimdal,
                R.drawable.menightclub)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor)

        gridview.adapter = ImageAdapter(this)

        gridview.onItemClickListener =
                AdapterView.OnItemClickListener { parent, v, position, id -> openSponsor(position) }

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
        txtTitle.typeface = custom_font
    }

    //Open sponsor information activity
    fun openSponsor(index: Int) {
        val listItems = resources.getStringArray(R.array.sponsorListTitles)
        val sponsorDeals = resources.getStringArray(R.array.sponsorDeals)
        val intent = Intent(this, SponsorItemActivity::class.java)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", listItems[index])
        intent.putExtra("no.larssyversen.fadderullan2018.DEALS", sponsorDeals[index])
        intent.putExtra("no.larssyversen.fadderullan2018.LOGO", mSponsorLogos[index])
        startActivity(intent)
    }

    fun handleOffersButtonClicked(v: View) {
        val i = Intent(this, WebViewActivity::class.java)
        i.putExtra("no.larssyversen.fadderullan2018.TITLE", R.string.webview_title_more_offers)
        i.putExtra( "no.larssyversen.fadderullan2018.LINK",resources.getString(R.string.link_bi_more_offers))
        startActivity(i)
    }

}
