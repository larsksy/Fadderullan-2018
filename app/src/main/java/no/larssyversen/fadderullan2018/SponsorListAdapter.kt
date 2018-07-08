package no.larssyversen.fadderullan2018

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SponsorListAdapter constructor(c: Context, items: Array<String>, am: AssetManager) : BaseAdapter() {

    var mInflater: LayoutInflater
    var listItems: Array<String>
    val assets: AssetManager

    init {
        listItems = items
        mInflater = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        assets = am
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v: View = mInflater.inflate(R.layout.sponsorlist_detail, null)
        val itemText: TextView = v.findViewById(R.id.itemName)
        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")

        val title: String = listItems[position]

        itemText.setText(title)
        itemText.gravity = Gravity.CENTER_VERTICAL

        itemText.typeface = custom_font

        return v
    }

    override fun getItem(position: Int): Any {
        return listItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listItems.size
    }

}