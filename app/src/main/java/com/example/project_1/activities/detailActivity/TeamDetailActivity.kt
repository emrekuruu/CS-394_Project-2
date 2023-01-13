package com.example.project_1.activities.detailActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.project_1.R
import com.example.project_1.databinding.ActivityTeamDetailBinding
import com.example.project_1.activities.model.Team

class TeamDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityTeamDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_team_detail)
        val selectedTeam =intent.getSerializableExtra("TEAM") as Team
        binding.team = selectedTeam
    }
}