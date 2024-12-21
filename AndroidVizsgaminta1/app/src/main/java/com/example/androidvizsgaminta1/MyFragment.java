package com.example.androidvizsgaminta1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    private ListView listView;
    private String[] items = {"Item 1", "Item 2", "Item 3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        listView = rootView.findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = items[position];
            ((ThirdActivity) getActivity()).updateTextView(selectedItem);
        });

        return rootView;
    }
}
