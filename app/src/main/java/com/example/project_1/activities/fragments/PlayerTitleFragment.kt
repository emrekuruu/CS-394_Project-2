package com.example.project_1.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.project_1.R
import com.example.project_1.databinding.PlayerTitleFragmentBinding

class PlayerTitleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<PlayerTitleFragmentBinding>(inflater, R.layout.player_title_fragment,container,false)
        return binding.root
    }
}