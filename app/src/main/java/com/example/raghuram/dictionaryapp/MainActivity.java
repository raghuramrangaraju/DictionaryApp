package com.example.raghuram.dictionaryapp;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import android.view.Window;
import android.view.WindowManager;

import com.example.raghuram.dictionaryapp.Adapter.RecyclerAdapter;
import com.example.raghuram.dictionaryapp.Model.Wordsclass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Wordsclass> words = new ArrayList<>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);

      //   getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new RecyclerAdapter(words, getApplicationContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        preparewordsdata();
    }

    public void preparewordsdata() {
        words.add(new Wordsclass("A", "ஒரு", "First Letter of the alphabet, denoting the first"));

        words.add(new Wordsclass("Abase", "இழிவுபடுத்து", "Degrades"));
        words.add(new Wordsclass("Abash", "வெட்கமடை", "Feel embarrassed"));
        words.add(new Wordsclass("Abate", "குறைய", "Become less intense"));
        words.add(new Wordsclass("Abatement", "தணிப்ப", "widespread"));
        words.add(new Wordsclass("Abbacy", "மடத்துத் தலைவரின் பதவி", "An office of abott"));
        words.add(new Wordsclass("Abbreviate", "சுருக்கியது", "Shorten"));
        words.add(new Wordsclass("Adicate", "ராஜினாமா", "Fail to fullfill"));
        words.add(new Wordsclass("Abductor", "கடத்திச்சென்ற", "deception"));
        words.add(new Wordsclass("Accost", "அணுகத்", "C"));
        words.add(new Wordsclass("Administer", "நிர்வாகி", "Carry out"));
        words.add(new Wordsclass("Banish", "வெளியேற்று", "Dismiss from one's mind"));
        words.add(new Wordsclass("Banner", "பேனர்", "Advertisment"));
        words.add(new Wordsclass("Barber", "பார்பர்", "Person who cuts mens hair"));
        words.add(new Wordsclass("Bare", "பார்", "Not covered"));
        words.add(new Wordsclass("Barker", "பார்க்கர்", "tout an action"));
        words.add(new Wordsclass("Cherish", "நெஞ்சார", "to treasure"));
        words.add(new Wordsclass("Circulate", "பரப்பு", "to spread"));
        words.add(new Wordsclass("Circumstance", "சூழ்நிலைக்க", "a paricular incident"));
        words.add(new Wordsclass("Clique", "குழுவில்", "an exclusive group"));
        words.add(new Wordsclass("Collate", "பணிக்கவு", "to put information in a specific order"));
        words.add(new Wordsclass("Cherish", "B", "to treasure"));
        words.add(new Wordsclass("Cherish", "B", "to treasure"));
        words.add(new Wordsclass("Cherish", "B", "to treasure"));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,menu);
        MenuItem menuitem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuitem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Wordsclass> newwords = new ArrayList<>();
        for(Wordsclass wordsclass : words)
        {
            String words = wordsclass.getWords().toLowerCase();
            if(words.contains(newText))
            {
                newwords.add(wordsclass);
            }
        }

        //adapter = new RecyclerAdapter(newwords, getApplicationContext());

        adapter = new RecyclerAdapter(newwords, getApplicationContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
     //  adapter.setFilter(newwords);
        return true;
    }
}
