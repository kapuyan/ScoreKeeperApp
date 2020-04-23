package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var mScore1: Int = 0
    private var mScore2: Int = 0
    lateinit var mScoreText1:TextView
    lateinit var mScoreText2:TextView
    final var STATE_SCORE_1: String ="Team 1 score"
    final var STATE_SCORE_2:String ="Team 2 Score"


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu);
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu?.findItem(R.id.night_mode)?.setTitle(R.string.day_mode)
        }
        else {
            menu?.findItem(R.id.night_mode)?.setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId ==R.id.night_mode){
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            if (nightMode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()

        }

        return true;
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //reference to TextView elements
        mScoreText1 = findViewById<TextView>(R.id.score_1) as TextView
        mScoreText2 = findViewById<TextView>(R.id.score_2) as TextView

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScoreText1.text = mScore1.toString()
            mScoreText2.text = mScore2.toString()
          //  mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    fun decreaseScore(view: View) {

        //equivalent to switch statement in java
        when (view.id){
                    R.id.decreaseTeam1 -> {
                        mScore1--
                        mScoreText1.text = mScore1.toString()
                    }
            R.id.decreaseTeam2 -> {
                mScore2--
                mScoreText2.text = mScore2.toString()
            }
        }
    }
    fun increaseScore(view: View) {
        when (view.id){
            R.id.increaseTeam1 -> {
                mScore1++
                mScoreText1.text = mScore1.toString()
            }
            R.id.increaseTeam2 -> {
                mScore2++
                mScoreText2.text = mScore2.toString()
            }
        }
    }
}
