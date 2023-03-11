package com.example.hotel.ui.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hotel.R
import com.example.hotel.domain.repository.Repository
import com.example.hotel.utils.NumberYdobstva.Companion.ARRAY_YDOBSTV
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {
    private lateinit var viewModel: DetailsViewModel
    private lateinit var detailsAdapter:DetailViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        val id = arguments?.getInt("id") ?: 7777777
        val repository = Repository()
        val viewModelFactory = DetailsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailsViewModel::class.java)
        viewModel.getNumbers(id - 1)
        viewModel.repo.observe(viewLifecycleOwner, Observer {
//            Glide.with(this).load(Constans.BASE_IMG + it.genImg).into(imgDetailsLogo)
            detailsAdapter.setList(it.gallery as List<String>)

            tvDetailsTitle.text = it.name
            tvDetailsDesc.text = it.bDesc
            tvTitlePrice.text = it.name
            it.ydobstva?.forEach{
                it?.let {
                    val imageView = ImageView(activity)
                    imageView.layoutParams = LinearLayout.LayoutParams(80, 80)
                    imageView.setImageResource(ARRAY_YDOBSTV.get(it.toInt()-1))
                    imageView.setPadding(10,0,10,0)
                    linerIcons.addView(imageView)
                }
            }
            firstPrise.text = it?.priceTable?.get(0) ?: "-"
            twoPrice.text = it?.priceTable?.get(1) ?: "-"
            threePrice.text = it?.priceTable?.get(2) ?: "-"
            forePrice.text = it?.priceTable?.get(3) ?: "-"
        })
        btnReservation.setOnClickListener{
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Дата бронирования:")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()
            datePicker.show(childFragmentManager,"show")
        }
    }
    private fun initAdapter() {
        detailsAdapter = DetailViewPagerAdapter()
        imgDetailsLogo.apply {
            adapter = detailsAdapter
        }
    }
}

