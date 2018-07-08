package no.larssyversen.fadderullan2018

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var markers: ArrayList<LatLng>
    private val LOCATION_REQUEST_CODE: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        markers = ArrayList()
        markers.add(LatLng(63.418832, 10.406671)) // Dødens dal
        markers.add(LatLng(63.422509, 10.394998)) // Samf
        markers.add(LatLng(63.421050, 10.388002)) // St. Olavs
        markers.add(LatLng(63.441252, 10.402787)) // BI TRD
        markers.add(LatLng(63.430035, 10.393109)) // Torget
    }

    /**
     * Manipulates the map once available.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val trondheim = LatLng(63.430515, 10.395053)
        val markerTitles = resources.getStringArray(R.array.array_map_markers)

        // Set starting position of mapView
        val cameraPosition = CameraPosition.builder()
                .target(trondheim)
                .zoom(14.toFloat())
                .build()
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        markers.forEach { mMap.addMarker(MarkerOptions().position(it).title(markerTitles[markers.indexOf(it)])) }

        mMap.setMinZoomPreference(10.toFloat())
        mMap.setMaxZoomPreference(18.toFloat())

        // Check for location permissions and enable current location on map.
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_REQUEST_CODE)
        }

    }

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: Array<Int>) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (permissions.size == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                Toast.makeText(this, "Fikk ikke tillatelse til å bruke gps",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }
}
