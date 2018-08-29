package no.larssyversen.fadderullan2018

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Typeface
import android.net.Uri
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }*/

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        btnMainProgram.typeface = custom_font
        btnMainGoups.typeface = custom_font
        btnMainInfo.typeface = custom_font
        btnMainSponsors.typeface = custom_font
        btnMainSpotify.typeface = custom_font

        val googleApi = GoogleApiAvailability.getInstance()
        if (googleApi.isGooglePlayServicesAvailable(this) != ConnectionResult.SUCCESS) {
            var ad: AlertDialog.Builder? = AlertDialog.Builder(this)
            ad!!.setTitle(R.string.dialog_google_services_title)
            ad.setMessage(R.string.dialog_google_services_message)
            ad.setNegativeButton(R.string.dialog_google_services_download,
                    DialogInterface.OnClickListener { dialog, which -> openGoogleServicesLink() })
            ad.setPositiveButton(R.string.dialogOk, null)
            ad.show()
            ad = null
        }
    }

    fun handleButtonProgramClicked(v: View) {
        val intent = Intent(this, ProgramActivity::class.java)
        startActivity(intent)
    }

    fun handleButtonSponsorsClicked(v: View) {
        val intent = Intent(this, SponsorActivity::class.java)
        startActivity(intent)
    }

    fun handleButtonSpotifyClicked(v: View) {
        val intent = Intent(this, SpotifyActivity::class.java)
        startActivity(intent)
    }

    fun handleButtonGroupsClicked(v: View) {
        val intent = Intent(this, GroupsActivity::class.java)
        startActivity(intent)
    }

    fun handleButtonInfoClicked(v: View) {
        val intent = Intent(this, MoreInfoActivity::class.java)
        startActivity(intent)
    }

    fun openGoogleServicesLink() {
        try {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=com.google.android.gms")))
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse(resources.getString(R.string.link_google_services))))
        }
    }
}
