package no.larssyversen.fadderullan2018

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ProgramListAdapter constructor(c: Context, items: Array<String>, dates: Array<String>, am: AssetManager) : BaseAdapter() {

    var mInflater: LayoutInflater
    var listItems: Array<String>
    var listDates: Array<String>
    val assets: AssetManager

    init {
        listItems = items
        listDates = dates
        mInflater = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        assets = am
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v: View = mInflater.inflate(R.layout.programlist_detail, null)
        val titleTextView: TextView = v.findViewById(R.id.txtItemTitle)
        val dateTextView: TextView = v.findViewById(R.id.txtDate)
        val custom_font_thin = Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
        val custom_font_regular = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")

        val title: String = listItems[position]
        val date: String = listDates[position]

        titleTextView.setText(title)
        dateTextView.setText(date)

        titleTextView.typeface = custom_font_regular
        dateTextView.typeface = custom_font_thin

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