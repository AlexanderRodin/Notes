package com.example.notes;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class openNote extends Fragment {
    @Override
    public void onCreate(Bundle saveIncenseState) {
        super.onCreate(saveIncenseState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveIncenseState) {
        View view = inflater.inflate(R.layout.open_notes, null);
        return view;
    }
}
