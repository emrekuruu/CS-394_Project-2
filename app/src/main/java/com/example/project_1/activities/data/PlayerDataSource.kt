package com.example.project_1.activities.data

import android.content.Context
import android.util.Log
import com.example.project_1.R
import com.example.project_1.activities.model.Player
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class PlayerDataSource(val context: Context) {

    val db = FirebaseFirestore.getInstance()
    val playersRef = db.collection("players_db")

    suspend fun getPlayerByName(name : String) : Player? {
        val players = loadPlayers()
        for (player: Player in players) {
            if (player.name == name) {
                return player
            }
        }
        return null
    }

    suspend fun loadPlayers(): List<Player> {
        return withContext(Dispatchers.IO) {
            val playersList = mutableListOf<Player>()
            try {
                val result = playersRef.get().await()
                for (document in result) {
                    val name = document.getString("name")
                    val APG = document.getString("APG")
                    val PPG = document.getString("PPG")
                    val RPG = document.getString("RPG")
                    val photoUrl = document.getString("photoUrl")

                    val player = Player(name.toString(), PPG.toString(), APG.toString(), RPG.toString(), photoUrl.toString())
                    playersList.add(player)
                }
                for (player in playersList) {
                    Log.d("PlayersList", player.name)
                    Log.d("PlayersList", player.APG)
                    Log.d("PlayersList", player.PPG)
                    Log.d("PlayersList", player.RPG)
                    Log.d("PlayersList", player.photoUrl)
                }
            } catch (e: Exception) {
                Log.w("Error", "Error getting documents.", e)
            }
            playersList
        }
    }
}