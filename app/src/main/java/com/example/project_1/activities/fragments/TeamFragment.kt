import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_1.R
import com.example.project_1.activities.adapter.PlayerAdapter
import com.example.project_1.activities.adapter.TeamAdapter
import com.example.project_1.activities.data.PlayerDataSource
import com.example.project_1.activities.data.TeamDataSource
import com.example.project_1.databinding.FragmentPlayersBinding
import com.example.project_1.databinding.FragmentTeamsBinding

class TeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentTeamsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_teams, container, false)

        // Initialize the RecyclerView
        val recyclerView: RecyclerView = binding.teamsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        val teams = context?.let { TeamDataSource(it).loadTeams() }
        val teamAdapter = teams?.let { TeamAdapter(TeamAdapter.TeamClickListener { teamName ->
            Toast.makeText(context?.applicationContext, "$teamName is chosen", Toast.LENGTH_SHORT).show()
        }) }


        recyclerView.adapter = teamAdapter
        teamAdapter?.submitList(teams)


        // Return the inflated layout
        return binding.root
    }




}

