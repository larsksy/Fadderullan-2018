package no.larssyversen.fadderullan2018

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.ImageView

class ImageAdapter(private val mContext: Context) : BaseAdapter() {

    override fun getCount(): Int = SponsorActivity.mSponsorLogos.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        val res = mContext.resources
        if (convertView == null) {
            imageView = ImageView(mContext)
            imageView.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT,  res.getDimension(R.dimen.gridview_height).toInt() )
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.background = res.getDrawable(R.drawable.frame)
            imageView.setPadding(24, 24, 24, 24)
        } else {
            imageView = convertView as ImageView
        }

        imageView.setImageDrawable(res.getDrawable(SponsorActivity.mSponsorLogos[position]))
        return imageView
    }
}