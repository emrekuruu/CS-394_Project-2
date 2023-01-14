package com.example.project_1.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs

import com.example.project_1.databinding.FragmentTeamDetailBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TeamDetailFragment : Fragment() {

    private lateinit var binding: FragmentTeamDetailBinding

    val args : TeamDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var viewModel = ViewModelProvider(this).get(com.example.project_1.activities.ViewModels.TeamDetailViewModel::class.java)
        binding = FragmentTeamDetailBinding.inflate(inflater,container,false)


        lifecycleScope.launch {
            val team = async { viewModel.getTeam(args.teamName, context) }.await()
            binding.team = team
        }

        return binding.root
    }
}
