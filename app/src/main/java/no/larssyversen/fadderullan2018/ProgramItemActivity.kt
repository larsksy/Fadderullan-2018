package no.larssyversen.fadderullan2018

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_program_item.*

class ProgramItemActivity : AppCompatActivity() {

    lateinit var link: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program_item)

        val bundle = intent.extras
        val i = bundle.getInt("no.larssyversen.fadderullan2018.INDEX")

        if(bundle != null) {
            val titleArray = resources.getStringArray(R.array.programListItems)
            val descriptionArray = resources.getStringArray(R.array.programListDescriptions)
            txtItemTitle.text = titleArray[i]
            txtItemDescription.text = descriptionArray[i]
            txtItemDescription.movementMethod = ScrollingMovementMethod()

            val font_thin = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
            val font_regular = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
            txtItemTitle.typeface = font_thin
            txtItemDescription.typeface = font_regular

            if(i == 7) { // When the arrangement needs to show action-button
                btnProgramItemAction.visibility = Button.VISIBLE
            }

           link = resources.getString(R.string.link_google_doc_shopping)
        }
    }

    fun handleActionButtonClicked(v: View) {

        if (!DateManager.dateCalc("2018:08:20 00:00:00")) {
            var ad: AlertDialog.Builder? = AlertDialog.Builder(this)
            ad!!.setTitle(R.string.dialog_not_available)
            ad.setMessage(R.string.dialog_availability_shopping)
            ad.setPositiveButton(R.string.dialogOk, null)

            ad.show()
            ad = null
            return
        }

        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("no.larssyversen.fadderullan2018.LINK", link)
        intent.putExtra("no.larssyversen.fadderullan2018.TITLE", R.string.webview_title_offers)
        startActivity(intent)
    }
}
