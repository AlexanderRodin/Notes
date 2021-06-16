package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements openThisNote {
    noteList noteList = new noteList();
    openNote openNote = new openNote();
    ShowNote showNote = new ShowNote();
    Boolean currentSnippet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, noteList)
                .commit();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getString("Текст заметки 1");
            currentSnippet = true;
        }

        findViewById(R.id.buttonNewNote).setOnClickListener(v -> {

            if (!(currentSnippet)) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, openNote)
                        .addToBackStack(null)
                        .commit();
            } else if (currentSnippet) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.right_fragment, openNote)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void getString(String s) {

        //TODO "Заполнить поля заметки"

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, showNote)
                    .addToBackStack(null)
                    .commit();
        } else if (!(currentSnippet)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.right_fragment, showNote)
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.right_fragment, showNote)
                    .addToBackStack(null)
                    .commit();
        }
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.open_settings:
                Toast.makeText(this, "Открыть", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.save_settings:
                Toast.makeText(this, "Сохранить", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}