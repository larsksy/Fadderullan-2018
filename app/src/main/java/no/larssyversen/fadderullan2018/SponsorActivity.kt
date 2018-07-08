package no.larssyversen.fadderullan2018

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
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
        lstSponsors.setOnItemClickListener({ parent: AdapterView<*>?, v: View?, i: Int, id: Long -> openInfoDialog(i) })
    }

    //Show sponsor information dialog
    fun openInfoDialog(index: Int) {

        val array = resources.getStringArray(R.array.sponsorListTitles)
        var text = resources.getString(R.string.dialogIpsum)
        val v: View = layoutInflater.inflate(R.layout.sponsorlist_dialog, null)
        val itemText: TextView = v.findViewById(R.id.txtInfo)

        // Show extra deal
        if (showExtraInfo(index)) {
            text += "\n\n NEW DEAL WOW!!"
        }

        itemText.text = text

        var ad: AlertDialog.Builder? = AlertDialog.Builder(this)
        ad!!.setView(v)
        ad.setPositiveButton(R.string.dialogOk, null)

        if (index == array.size - 1) {
            ad.setNegativeButton(R.string.dialogMoreInfo, DialogInterface.OnClickListener { dialog, which ->
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(resources.getString(R.string.link_button_bi))
                startActivity(i)
            })
        }

        ad.show()
        ad = null
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
