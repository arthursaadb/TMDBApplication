package com.example.tmdbapplication.presentation.gateway

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tmdbapplication.R
import com.example.tmdbapplication.databinding.FragmentGatewayBinding
import kotlinx.android.synthetic.main.fragment_gateway.*

class GatewayFragment : Fragment() {
    private lateinit var binding: FragmentGatewayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gateway, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        bt_movies.setOnClickListener {
            findNavController().navigate(R.id.action_gatewayFragment_to_movieFragment)
        }
    }
}