package com.example.hotel.ui.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.hotel.R
import com.example.hotel.domain.repository.Repository
import com.example.hotel.utils.Constans
import com.example.hotel.utils.NumberYdobstva.Companion.ARRAY_YDOBSTV
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("id") ?: 7777777
        val repository = Repository()
        val viewModelFactory = DetailsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailsViewModel::class.java)
        viewModel.getNumbers(id - 1)
        viewModel.repo.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(Constans.BASE_IMG + it.genImg).into(imgDetailsLogo)
            tvDetailsTitle.text = it.name
            tvDetailsDesc.text = it.bDesc

            it.ydobstva?.forEach{
                it?.let {
                    val imageView = ImageView(activity)
                    imageView.layoutParams = LinearLayout.LayoutParams(80, 80)
                    imageView.setImageResource(ARRAY_YDOBSTV.get(it.toInt()-1))
                    imageView.setPadding(10,0,10,0)
                    linerIcons.addView(imageView)
                }
            }
        })
    }
}