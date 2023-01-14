package com.example.project_1.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.project_1.databinding.FragmentPlayerDetailBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class PlayerDetailFragment : Fragment() {

    private lateinit var binding: FragmentPlayerDetailBinding

    val args : PlayerDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var viewModel = ViewModelProvider(this).get(com.example.project_1.activities.ViewModels.PlayerDetailViewModel::class.java)
        binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            val player = async { viewModel.getPlayer(args.playerName, context) }.await()
            binding.player = player
        }
        return binding.root
    }

}
