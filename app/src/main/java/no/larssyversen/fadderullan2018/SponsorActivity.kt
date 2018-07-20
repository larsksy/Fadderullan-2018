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
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_more_info.*
import kotlinx.android.synthetic.main.activity_sponsor.*
import java.text.SimpleDateFormat
import java.util.*

class SponsorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor)

        val listItems = resources.getStringArray(R.array.sponsorListTitles)
        val adapter = SponsorListAdapter(this, listItems, assets)

        lstSponsors.adapter = adapter
        lstSponsors.setOnItemClickListener({ parent: AdapterView<*>?, v: View?, i: Int, id: Long -> openSponsorBreakdown(i) })

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
        txtTitle.typeface = custom_font
    }

    //Open sponsor information activity
    fun openSponsorBreakdown(index: Int) {
        val listItems = resources.getStringArray(R.array.sponsorListTitles)
        val intent = Intent(this, SponsorItemActivity::class.java)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", listItems[index])
        intent.putExtra("no.larssyversen.fadderullan2018.DEALS", R.string.loremIpsum)
        intent.putExtra("no.larssyversen.fadderullan2018.INDEX", index)
        startActivity(intent)
    }


}
