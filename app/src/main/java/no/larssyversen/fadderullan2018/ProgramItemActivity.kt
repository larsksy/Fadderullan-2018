package no.larssyversen.fadderullan2018

import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_program_item.*

class ProgramItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program_item)

        val bundle = intent.extras
        val i: Int = bundle.getInt("no.larssyversen.fadderullan2018.INDEX")
        if(bundle != null) {
            val titleArray = resources.getStringArray(R.array.programListTitles)
            val descriptionArray = resources.getStringArray(R.array.programListDescriptions)
            txtItemTitle.text = titleArray[i]
            txtItemDescription.text = descriptionArray[i]
            txtItemDescription.movementMethod = ScrollingMovementMethod()

            val font = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
            txtItemTitle.typeface = font
            txtItemDescription.typeface = font
        }
    }
}
