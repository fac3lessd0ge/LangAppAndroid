package com.androidcourse.langapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameOneWinActivity : AppCompatActivity() {
    private lateinit var nextButton: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game_one_win)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gameWin)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nextButton = findViewById(R.id.win_button)

        nextButton.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}