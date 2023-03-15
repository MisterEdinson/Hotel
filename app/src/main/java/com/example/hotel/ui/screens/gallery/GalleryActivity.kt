package com.example.hotel.ui.screens.gallery

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.example.hotel.R
import com.example.hotel.utils.Constans
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {

    private val bundleArs: GalleryActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        val articleArgs = bundleArs.image
        if(articleArgs.isNotEmpty()){
            Glide.with(this).load(Constans.BASE_URL + articleArgs).into(imgBig)
        }
    }
}