package no.larssyversen.fadderullan2018

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Typeface
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        btnFAQ.typeface = custom_font
        btnMap.typeface = custom_font
        btnInfo.typeface = custom_font
        btnFacebook.typeface = custom_font
        btnInstagram.typeface = custom_font
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
}
