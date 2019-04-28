package com.camjam.tabtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camjam.tabtest.Adapters.RecyclerViewAdapter;
import com.camjam.tabtest.Adapters.ShelfListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentShelf extends Fragment {

    View view; //Layout viewer
    List<Food> food_list = new ArrayList<Food>();
    InsertSQL dbHelper = null;

    public FragmentShelf() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shelf_fragment_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.shelfViewer);
        ShelfListViewAdapter adapter = new ShelfListViewAdapter(getActivity(), food_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        createFoodList();
        return view;
    }
    public void createFoodList(){
        dbHelper = new InsertSQL(getActivity());
        food_list = dbHelper.keywordDBSearch();
    }
}
