package no.larssyversen.fadderullan2018

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_program.*
import java.util.ArrayList

class ProgramActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program)


        val listItems = resources.getStringArray(R.array.programListItems)
        val listDates = resources.getStringArray(R.array.programListDates)
        val adapter = ProgramListAdapter(this, listItems, listDates, assets)
        programList.adapter = adapter
        programList
        programList.setOnItemClickListener({ parent: AdapterView<*>?, v: View?, i: Int, id: Long -> openActivityBreakdown(i) })
    }

    fun openActivityBreakdown(index: Int) {
        val newActivityIntent: Intent = Intent(this, ProgramItemActivity::class.java)
        newActivityIntent.putExtra("no.larssyversen.fadderullan2018.INDEX", index)
        startActivity(newActivityIntent)
    }
}
