package com.example.mrkha.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mrkha.swoosh.Model.Player
import com.example.mrkha.swoosh.R
import com.example.mrkha.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        this.player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }


    fun onBeginnerClick(view: View) {
        ballerBtn.isChecked = false

        player.skill = "beginner"
    }

    fun onBallerClick(view: View) {
        beginnerBtn.isChecked = false

        player.skill = "baller"
    }


    fun onFinishClicked(view: View) {
        if (player.skill != "") {
            var finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select your skill.", Toast.LENGTH_SHORT).show()
        }

    }
}
