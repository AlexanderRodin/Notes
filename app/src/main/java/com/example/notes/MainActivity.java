package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteList list = new noteList();
        if (list != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.countriesList, list)
                    .commit();
        }
        findViewById(R.id.buttonNewNote).setOnClickListener(v -> {
            openNote openNote = new openNote();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, openNote)
                    .addToBackStack(null)
                    .commit();
        });
    }
}