package no.larssyversen.fadderullan2018

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Typeface
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
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    private val LOCATION_REQUEST_CODE: Int = 100

    private lateinit var mMap: GoogleMap
    private lateinit var markers: ArrayList<LatLng>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val custom_font = Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
        txtTitle.typeface = custom_font

        markers = ArrayList()
        markers.add(LatLng(63.418832, 10.406671)) // Dødens dal
        markers.add(LatLng(63.422509, 10.394998)) // Samf
        markers.add(LatLng(63.421250, 10.388063)) // Legevakt
        markers.add(LatLng(63.441252, 10.402787)) // BI TRD
        markers.add(LatLng(63.430035, 10.393109)) // Torget
        markers.add(LatLng(63.434388, 10.397551)) // The Mint
        markers.add(LatLng(63.433269, 10.396120)) // Nattergalen
        markers.add(LatLng(63.434573, 10.397373)) // Wildside
        markers.add(LatLng(63.434737, 10.411471)) // Egon Solsiden
        markers.add(LatLng(63.433278, 10.400662)) // BK
        markers.add(LatLng(63.433171, 10.402008)) // Nova
        markers.add(LatLng(63.434917, 10.411727)) // Solsiden
        markers.add(LatLng(63.433228, 10.414345)) // Møllenberg
        markers.add(LatLng(63.441704, 10.403139)) // Akademika BI
        markers.add(LatLng(63.433488, 10.394053)) // O'Learys
        markers.add(LatLng(63.430109, 10.399786)) // Frimurerlogo
        markers.add(LatLng(63.433370, 10.404909)) // Royal Garden Radisson Blu
        markers.add(LatLng(63.434116, 10.398232)) // Lille London
        markers.add(LatLng(63.422419, 10.431924)) // Egon Tårnet
        markers.add(LatLng(63.440422, 10.400511)) // 3T Pirbadet
        markers.add(LatLng(63.435062, 10.412104)) // Cubus Solsiden

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
