package com.example.project_1.activities.data

import android.content.Context
import android.util.Log
import com.example.project_1.activities.model.Team
import com.example.project_1.R
import com.example.project_1.activities.model.Player
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class TeamDataSource(val context: Context) {

    val db = FirebaseFirestore.getInstance()
    val teamsRef = db.collection("teams_db")


//    fun getTeamByName(name : String) : Team?{
//        val teams = loadTeams()
//        for(team : Team in teams){
//            if(team.name == name){
//                return team
//            }
//        }
//        return null
//    }

    suspend fun getTeamByName(name : String) : Team? {
        val teams = loadTeams()
        for (team: Team in teams) {
            if (team.name == name) {
                return team
            }
        }
        return null
    }

suspend fun loadTeams(): MutableList<Team> {
    return withContext(Dispatchers.IO) {
        val teamsList = mutableListOf<Team>()
        try {
            val result = teamsRef.get().await()
            for (document in result) {
                val name = document.getString("name")
                val records = document.getString("records")
                val photoUrl = document.getString("photoUrl")

                val team = Team(name.toString(), records.toString(), photoUrl.toString())
                teamsList.add(team)
            }
            for (team in teamsList) {
                Log.d("teamsList", team.name)
                Log.d("teamsList", team.record)
                Log.d("teamsList", team.photoUrl)
            }
        } catch (e: Exception) {
            Log.w("Error", "Error getting documents.", e)
        }
        teamsList
    }
}
}