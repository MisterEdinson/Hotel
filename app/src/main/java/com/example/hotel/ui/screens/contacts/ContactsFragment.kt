package com.example.hotel.ui.screens.contacts

import android.content.Context
import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hotel.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_contacts.*


class ContactsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contacts,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment
        mapFragment.getMapAsync(this)

        btnViberCall.setOnClickListener {
            try {
                val intent = Intent(ACTION_VIEW, Uri.parse("viber://chat?number=%2B79785826569"))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context,"Не могу позвонить...",Toast.LENGTH_SHORT).show()
            }
        }
        btnWhatsAppCall.setOnClickListener {
            try {
                val intent = Intent(ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+79785826569"))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context,"Не могу позвонить...",Toast.LENGTH_SHORT).show()
            }
        }
        btnTelephoneCall.setOnClickListener {
            try {
                val intent = Intent(ACTION_DIAL, Uri.parse("tel:+79780997499"))
                activity?.startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context,"Не могу позвонить...",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val hotel = LatLng(45.095497, 33.563511)
        mMap.addMarker(
            MarkerOptions()
            .position(hotel)
            .title("Отель Мечта"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hotel, 11F))
    }

}