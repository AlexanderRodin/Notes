package com.example.notes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class noteList extends ListFragment {

    String[] countries = {"Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};

    public noteList() {
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
        ListView countriesList = (ListView) view.findViewById(R.id.countriesList);
        countriesList.setAdapter(list);
        return view;
    }
}