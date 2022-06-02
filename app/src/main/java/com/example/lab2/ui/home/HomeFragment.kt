package com.example.lab2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.R
import com.example.lab2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val anetkaTextView: TextView = binding.textView12
        homeViewModel.text.observe(viewLifecycleOwner) {
            anetkaTextView.text = getString(R.string.anetkaName)
        }

        val rafalekTextView: TextView = binding.textView21
        homeViewModel.text.observe(viewLifecycleOwner) {
            rafalekTextView.text = getString(R.string.rafalekName)
        }

        val grazynkaTextView: TextView = binding.textView31
        homeViewModel.text.observe(viewLifecycleOwner) {
            grazynkaTextView.text = getString(R.string.grazynkaname)
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}