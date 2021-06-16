package com.example.notes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class noteList extends ListFragment {
    //TODO "Заменить массив на map "
    String[] countries = {"Текст заметки 1", "Текст заметки 2", "Текст заметки 3", "Текст заметки 4", "Текст заметки 5"};
    openThisNote thisNote;

    public noteList() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            thisNote = (openThisNote) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_list,
                container, false);
        ArrayAdapter<String> list = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                countries
        );
        ListView countriesList = view.findViewById(android.R.id.list);
        countriesList.setAdapter(list);
        return view;
    }

    //TODO "Прокинуть из данные из списка"
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        thisNote.getString("Отображение текста заметки " + (position + 1));
//        Toast.makeText(getActivity(), "Вы выбрали позицию: " + position, Toast.LENGTH_SHORT).show();

    }

}