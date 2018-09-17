package com.example.mrkha.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.mrkha.swoosh.Model.Player
import com.example.mrkha.swoosh.R
import com.example.mrkha.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }

    }


    fun onMenClicked (view: View) {

        womenLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "men"

    }

    fun onWomenClicked (view: View) {

        menLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "women"
    }

    fun onCoedClicked (view: View) {

        menLeagueBtn.isChecked = false
        womenLeagueBtn.isChecked = false

        player.league = "co-ed"
    }
    fun leagueNextBtnClicked(view: View){

        if(player.league != "")
        {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player.league)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }

    }

}
