package no.larssyversen.fadderullan2018

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_program_item.*

class ProgramItemActivity : AppCompatActivity() {

    lateinit var attendanceLink: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program_item)

        val bundle = intent.extras
        val i = bundle.getInt("no.larssyversen.fadderullan2018.INDEX")

        if(bundle != null) {
            val titleArray = resources.getStringArray(R.array.programListTitles)
            val descriptionArray = resources.getStringArray(R.array.programListDescriptions)
            txtItemTitle.text = titleArray[i]
            txtItemDescription.text = descriptionArray[i]
            txtItemDescription.movementMethod = ScrollingMovementMethod()

            val font = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
            txtItemTitle.typeface = font
            txtItemDescription.typeface = font

            if(i == 2 || i == 3) { // When the arrangement needs to show attendance in another tab
                findViewById<Button>(R.id.btnProgramItemAttendance).visibility = Button.VISIBLE
            }

           attendanceLink = if (i == 2) resources.getString(R.string.link_button_facebook) else resources.getString(R.string.link_button_instagram)
        }
    }

    fun handleAttendanceButtonClicked(v: View) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("no.larssyversen.fadderullan2018.LINK", attendanceLink)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", R.string.webview_title_attendance)
        startActivity(intent)
    }
}
