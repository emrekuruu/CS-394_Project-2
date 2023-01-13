package com.example.project_1.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.project_1.R
import com.example.project_1.activities.model.Player
import com.example.project_1.databinding.FragmentPlayerDetailBinding


class PlayerDetailFragment : Fragment() {

    private lateinit var binding: FragmentPlayerDetailBinding

    val args : PlayerDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)

        var player = args.player
        binding.player =player

        return binding.root
    }

}
