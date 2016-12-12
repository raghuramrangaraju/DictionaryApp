package com.example.raghuram.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WordMeaning extends AppCompatActivity {

    TextView words,tamilmeaning,englishmeaning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_meaning);
        words = (TextView)findViewById(R.id.text_word);
        tamilmeaning = (TextView)findViewById(R.id.text_tamilmeaning);
        englishmeaning = (TextView)findViewById(R.id.text_englishmeaning);
        words.setText(getIntent().getStringExtra("text_words"));
        tamilmeaning.setText(getIntent().getStringExtra("text_tamilmeanings"));
        englishmeaning.setText(getIntent().getStringExtra("text_englishmeanings"));
    }
}
