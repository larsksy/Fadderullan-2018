package no.larssyversen.fadderullan2018

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_spotify.*
import java.util.zip.Inflater
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.widget.TextView
import android.widget.Toast


class SpotifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spotify)

        val listItems = resources.getStringArray(R.array.spotifyListTitles)
        val mAdapter = ArrayAdapter(this, R.layout.spotifylist_detail, R.id.itemName, listItems)
        lstSpotify.adapter = mAdapter

        lstSpotify.setOnItemClickListener({ parent: AdapterView<*>?, v: View?, i: Int, id: Long -> openSpotifyLink(i) })

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
        txtTitle.typeface = custom_font
    }

    fun openSpotifyLink(index: Int) {

        if (index == 6 && !DateManager.dateCalc("2018:08:20 00:00:00")) {
            var ad: AlertDialog.Builder? = AlertDialog.Builder(this)
            ad!!.setTitle(R.string.dialog_not_available)
            ad.setMessage(R.string.dialog_availability_spotify)
            ad.setPositiveButton(R.string.dialogOk, null)

            ad.show()
            ad = null
            return
        }

        val uris = resources.getStringArray(R.array.spotifyListUri)
        val links = resources.getStringArray(R.array.spotifyListLinks)

        var i = Intent(Intent.ACTION_VIEW, Uri.parse(uris[index]))

        // Check if spotify is installed, if not, open in web-browser
        if (i.resolveActivity(packageManager) != null) { startActivity(i) }
        else {
            i = Intent(Intent.ACTION_VIEW, Uri.parse(links[index]))
            startActivity(i)
        }

    }
}
