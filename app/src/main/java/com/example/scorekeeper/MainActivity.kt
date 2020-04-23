package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var mScore1: Int = 0
    private var mScore2: Int = 0
    lateinit var mScoreText1:TextView
    lateinit var mScoreText2:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //reference to TextView elements
        mScoreText1 = findViewById<TextView>(R.id.score_1) as TextView
        mScoreText2 = findViewById<TextView>(R.id.score_2) as TextView

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
