package com.example.project_1.activities.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.project_1.activities.data.PlayerDataSource
import com.example.project_1.activities.model.Player

class PlayerDetailViewModel : ViewModel()  {

    fun getPlayer(playerName: String, context: Context?) : Player? {
        val db = context?.let { PlayerDataSource(it) }
        if (db != null) {
            return db.getPlayerByName(playerName)
        }
        return null
    }

}