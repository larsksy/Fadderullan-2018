package no.larssyversen.fadderullan2018

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Typeface


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        btnMainProgram.typeface = custom_font
        btnMainGoups.typeface = custom_font
        btnMainInfo.typeface = custom_font
        btnMainSponsors.typeface = custom_font
        btnMainSpotify.typeface = custom_font
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
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("no.larssyversen.fadderullan2018.LINK", resources.getString(R.string.link_google))
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", R.string.webview_title_groups)
        startActivity(intent)
    }

    fun handleButtonInfoClicked(v: View) {
        val intent = Intent(this, MoreInfoActivity::class.java)
        startActivity(intent)
    }
}
