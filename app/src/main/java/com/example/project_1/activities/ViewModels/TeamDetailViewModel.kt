package com.example.project_1.activities.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.project_1.activities.data.PlayerDataSource
import com.example.project_1.activities.data.TeamDataSource
import com.example.project_1.activities.model.Player
import com.example.project_1.activities.model.Team

class TeamDetailViewModel : ViewModel() {


   suspend fun getTeam(teamName: String, context: Context?) : Team? {
        val db = context?.let { TeamDataSource(it) }
        if (db != null) {
            return db.getTeamByName(teamName)
        }
        return null
    }




}