package no.larssyversen.fadderullan2018

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_sponsor.*

class SponsorActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_extra -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sponsor)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val items = resources.getStringArray(R.array.sponsorListTitles)
        lstSponsors.adapter = ArrayAdapter(this, R.layout.sponsorlist_detail, R.id.itemName,
                items)
    }
}
