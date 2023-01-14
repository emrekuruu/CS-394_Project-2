package com.example.project_1.activities.data

import android.content.Context
import android.util.Log
import com.example.project_1.R
import com.example.project_1.activities.model.Player
import com.google.firebase.firestore.FirebaseFirestore


class PlayerDataSource(val context: Context) {

    val db = FirebaseFirestore.getInstance()
    val playersRef = db.collection("players_db")



    fun getNames():Array<String>{

        return context.resources.getStringArray(R.array.name_array)
    }

    fun getPPG():Array<String>{
        return context.resources.getStringArray(R.array.ppg_array)
    }
    fun getAPG():Array<String>{
        return context.resources.getStringArray(R.array.apg_array)
    }
    fun getRPG():Array<String>{
        return context.resources.getStringArray(R.array.rpg_array)
    }

    fun getPhotoUrl():Array<String>{
        return context.resources.getStringArray(R.array.url_array)
    }

    fun getPlayerByName(name : String) : Player? {
        val players = loadPlayers()
        for (player: Player in players) {
            if (player.name == name) {
                return player
            }
        }
        return null
    }

    fun loadPlayers() : List<Player>{
        val players = mutableListOf<Player>()
        val nameList = getNames()
        val ppgs = getPPG()
        val apgs = getAPG()
        val rpgs = getRPG()
        val urls = getPhotoUrl()
        


        for(i in 0..14){
            val player = Player(nameList[i],ppgs[i],apgs[i],rpgs[i],urls[i])
            players.add(player)
        }
        return players
    }
}