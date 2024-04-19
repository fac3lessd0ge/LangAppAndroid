package com.androidcourse.langapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LanguageSelectActivity : AppCompatActivity() {
    private lateinit var russianButton: LinearLayout;
    private lateinit var englishButton: LinearLayout;
    private lateinit var selectLanguageButton: Button;

    private var selectedLang: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_language_select)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.language_select)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        russianButton = findViewById(R.id.russianbtn)
        englishButton = findViewById(R.id.englishbtn)
        selectLanguageButton = findViewById(R.id.choosebtn)

        russianButton.setOnClickListener {
            selectedLang = "ru";

            russianButton.setBackgroundResource(R.drawable.rounded_button_orange_m);
            englishButton.setBackgroundResource(R.drawable.rounded_m);
        }

        englishButton.setOnClickListener {
            selectedLang = "en";

            englishButton.setBackgroundResource(R.drawable.rounded_button_orange_m);
            russianButton.setBackgroundResource(R.drawable.rounded_m);

        }

        selectLanguageButton.setOnClickListener {
            if (selectedLang.length == 2) {
                val i = Intent(this, HomeActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }
}