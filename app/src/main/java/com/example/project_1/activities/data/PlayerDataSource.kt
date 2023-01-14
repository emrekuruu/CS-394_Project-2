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



        // benim list bu
        val playersList = mutableListOf<Player>()

        //burdan liste ekliyom
        playersRef.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val name = document.getString("name")
                    val APG = document.getString("APG")
                    val PPG = document.getString("PPG")
                    val RPG = document.getString("RPG")
                    val photoUrl = document.getString("photoUrl")

                    val player = Player(name.toString(), PPG.toString(), APG.toString(), RPG.toString(), photoUrl.toString())
                    playersList.add(player)
                }
                //Logcate printliyo
                for (player in playersList) {
                    Log.d("PlayersList", player.name)
                    Log.d("PlayersList", player.APG)
                    Log.d("PlayersList", player.PPG)
                    Log.d("PlayersList", player.RPG)
                    Log.d("PlayersList", player.photoUrl)
                }
            }
                //error handling
            .addOnFailureListener { exception ->
                Log.w("Error", "Error getting documents.", exception)
            }


        for(i in 0..14){
            val player = Player(nameList[i],ppgs[i],apgs[i],rpgs[i],urls[i])
            players.add(player)
        }
        return players
    }
}