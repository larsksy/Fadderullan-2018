package no.larssyversen.fadderullan2018

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_program.*

class ProgramActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program)

        val listItems = resources.getStringArray(R.array.programListItems)
        val listDates = resources.getStringArray(R.array.programListDates)
        val adapter = ProgramListAdapter(this, listItems, listDates, assets)
        val header = layoutInflater.inflate(R.layout.listview_header, programList, false)

        val txtOverheadContacts = header.findViewById<TextView>(R.id.txtOverheadContacts)
        val txtOverheadFacebook1 = header.findViewById<TextView>(R.id.txtOverheadFacebook1)
        val txtOverheadFacebook2 = header.findViewById<TextView>(R.id.txtOverheadFacebook2)
        val txtOverheadPerson1 = header.findViewById<TextView>(R.id.txtOverheadPerson1)
        val txtOverheadPerson2 = header.findViewById<TextView>(R.id.txtOverheadPerson2)
        val txtOverheadNumber1 = header.findViewById<TextView>(R.id.txtOverheadNumber1)
        val txtOverheadNumber2 = header.findViewById<TextView>(R.id.txtOverheadNumber2)

        txtOverheadContacts.text = resources.getString(R.string.program_list_overhead_conctacts)
        txtOverheadPerson1.text = resources.getString(R.string.program_list_overhead_name1)
        txtOverheadPerson2.text = resources.getString(R.string.program_list_overhead_name2)
        txtOverheadNumber1.text = resources.getString(R.string.program_list_overhead_number1)
        txtOverheadNumber2.text = resources.getString(R.string.program_list_overhead_number2)

        val custom_font_regular = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
        val custom_font_thin = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        txtProgramTitle.typeface = custom_font_regular
        txtOverheadContacts.typeface = custom_font_regular
        txtOverheadFacebook1.typeface = custom_font_regular
        txtOverheadFacebook2.typeface = custom_font_regular
        txtOverheadPerson1.typeface = custom_font_thin
        txtOverheadPerson2.typeface = custom_font_thin
        txtOverheadNumber1.typeface = custom_font_thin
        txtOverheadNumber2.typeface = custom_font_thin

        programList.addHeaderView(header, null, false)
        programList.adapter = adapter
        programList.setOnItemClickListener({ parent: AdapterView<*>?, v: View?, i: Int, id: Long -> openActivityBreakdown(i) })
    }

    fun openActivityBreakdown(index: Int) {
        val newActivityIntent: Intent = Intent(this, ProgramItemActivity::class.java)
        newActivityIntent.putExtra("no.larssyversen.fadderullan2018.INDEX", index - 1)
        startActivity(newActivityIntent)
    }
}
