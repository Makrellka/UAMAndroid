package com.example.lab2.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.gridlayout.widget.GridLayout
import com.example.lab2.BaseFragment
import com.example.lab2.R
import com.example.lab2.databinding.FragmentAdChildBinding
import com.google.android.material.imageview.ShapeableImageView

class AdChildFragment : BaseFragment<AdChildViewModel>(AdChildViewModel::class.java) {

    companion object {
        fun newInstance() = AdChildFragment()
    }

    private var _binding: FragmentAdChildBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAdChildBinding.inflate(inflater, container, false)
        createAvatarsCardInGridLocation()
        return binding.root
    }

    private fun createAvatarsCardInGridLocation(){
        var avatarList = listOf(
            Pair(R.drawable.cook, "cook"),
            Pair(R.drawable.firefighter, "firefighter"),
            Pair(R.drawable.policeman, "policeman"),
            Pair(R.drawable.worker, "worker")
        )

        for (i in avatarList.indices){
            val cardView: CardView = LayoutInflater.from(context)
                .inflate(R.layout.item_avatar,binding.gridLayoutAvatarList,false) as CardView
            cardView.findViewWithTag<ShapeableImageView>("ShapeableImageView")
                ?.setImageResource(avatarList[i].first)
            val myGLP = GridLayout.LayoutParams()
            val rowSpec = GridLayout.spec(i / 4,1,0.25f)
            val colSpec = GridLayout.spec(i % 4,1,0.25f)

            myGLP.rowSpec = rowSpec
            myGLP.columnSpec = colSpec
            binding.gridLayoutAvatarList.addView(cardView,myGLP)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewmodel = this.viewModel
        binding.lifecycleOwner = this

    }

}