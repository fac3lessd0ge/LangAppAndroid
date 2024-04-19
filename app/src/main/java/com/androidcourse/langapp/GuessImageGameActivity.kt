package com.androidcourse.langapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GuessImageGameActivity : AppCompatActivity() {
    private lateinit var checkButton: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_guess_image_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gameOne)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        checkButton = findViewById(R.id.checkButton)

        checkButton.setOnClickListener {
            val i = Intent(this, GameOneWinActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}