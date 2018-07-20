package no.larssyversen.fadderullan2018

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sponsor_item.*
import java.text.SimpleDateFormat
import java.util.*

class SponsorItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor_item)

        val bundle = intent.extras
        val title = bundle.getString("no.larssyversen.fadderullan2018.TITLE")
        var deals = resources.getString(bundle.getInt("no.larssyversen.fadderullan2018.DEALS"))
        val index = bundle.getInt("no.larssyversen.fadderullan2018.INDEX")

        if(showExtraInfo(index)) {
            deals += "\n\n NEW DEAL WOW!!!"
        }

        txtSponsorItemTitle.text = title
        txtSponsorItemDeals.text = deals

        val custom_font_regular = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
        val custom_font_thin = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        txtSponsorItemTitle.typeface = custom_font_thin
        txtSponsorItemDeals.typeface = custom_font_regular
    }


    // Calculates wether or not its time to show extra deal
    fun showExtraInfo (index: Int) : Boolean {

        if (index != 3) { return false }

        val sdf = SimpleDateFormat("yyyy:MM:dd HH:mm:ss")
        val currentTimeString = sdf.format(Date())
        val currentTime = sdf.parse(currentTimeString)
        val targetTime = sdf.parse("2018:07:08 17:04:00")

        Log.d("MVA-SponsorActivity", "Current time: " + currentTime)
        Log.d("MVA-SponsorActivity", "Target time: " + targetTime)

        return currentTime.after(targetTime)
    }
}
