package no.larssyversen.fadderullan2018

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Typeface



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        btnProgram.typeface = custom_font
        btnGroups.typeface = custom_font
        btnInfo.typeface = custom_font
        btnSponsors.typeface = custom_font
        btnSpotify.typeface = custom_font
    }

    fun handleButtonProgramClicked(v: View) {
        val intent = Intent(this, ProgramActivity::class.java)
        startActivity(intent)
    }

    fun handleButtonSponsorsClicked(v: View) {
        val intent = Intent(this, SponsorActivity::class.java)
        startActivity(intent)
    }
}
