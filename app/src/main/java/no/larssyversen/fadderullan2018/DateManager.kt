package no.larssyversen.fadderullan2018

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class DateManager {

    companion object {

        // Calculates wether or not today is after given target date
        fun  dateCalc (targeDateString: String) : Boolean {

            val sdf = SimpleDateFormat("yyyy:MM:dd HH:mm:ss")
            val currentTimeString = sdf.format(Date())
            val currentTime = sdf.parse(currentTimeString)
            val targetTime = sdf.parse(targeDateString)

            Log.d("DateManager", "Current time: " + currentTime)
            Log.d("DateManager", "Target time: " + targetTime)

            return currentTime.after(targetTime)
        }
    }
}

