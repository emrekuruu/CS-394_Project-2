package com.example.project_1.activities.detailActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.project_1.activities.model.Player
import com.example.project_1.R
import com.example.project_1.databinding.ActivityPlayerDetailBinding
import com.google.android.material.internal.NavigationMenu

class PlayerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding :ActivityPlayerDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_player_detail)
        val selectedPlayer =intent.getSerializableExtra("PLAYER") as Player
        binding.player =selectedPlayer

    }

}