package com.camjam.tabtest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.camjam.tabtest.Adapters.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class FragmentSearch extends Fragment implements RecyclerViewAdapter.OnNoteListener {

    private static final String TAG = "FragmentSearch";
    View view; //Layout viewer
    protected String searchCriteria = "";
    protected String jsonURL = "";
    final List<Food> food_list = new ArrayList<>();
    protected String label = "";
    protected String brand = "";
    protected String food_id = "";



    private IMainActivity iMainActivity;



    public FragmentSearch() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_fragment_layout, container, false);
        Button searchBtn = (Button) view.findViewById(R.id.searchBtn);
        RecyclerView recyclerView = view.findViewById(R.id.food_viewer);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), food_list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        final EditText searchFoodText = (EditText) view.findViewById(R.id.searchForFoodEditText);
        //Functions
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food_list.clear();
                searchCriteria = searchFoodText.getText().toString();
                searchCriteria = searchCriteria.replace(" ", "%20");
                Toast.makeText(getActivity(), "Searching", Toast.LENGTH_SHORT).show();
                try {
                    String encodedKeyword = URLEncoder.encode(searchCriteria, "UTF8");
                    jsonURL = "https://api.edamam.com/api/food-database/parser?ingr=" + encodedKeyword + "&app_id=3466b7e1&app_key=b01e658fc34ee624f8c11ab001172e32";
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                jsonRequest();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Components
    }
    public void jsonRequest(){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, jsonURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                JSONObject foodObject = response;
                JSONArray foodHints = null;
                try {
                    foodHints = foodObject.getJSONArray("hints");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < foodHints.length(); i++) {
                    try {

                        JSONObject foodFood = foodHints.getJSONObject(i);
                        foodFood = foodFood.getJSONObject("food");
                        Food foodList = new Food();
                        foodList.setLabel(foodFood.getString("label"));
                        foodList.setBrand(foodFood.getString("brand"));
                        foodList.setFood_id(foodFood.getString("foodId"));
                        food_list.add(foodList);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }//End jsonRequest

    //This method comes from the recycler view interface
    //provides an onClick event to each list item
    @Override
    public void onNoteClick(int position) {
        food_list.get(position);
        Toast.makeText(getActivity(),food_list.get(position).getLabel(), Toast.LENGTH_SHORT).show();
        label = food_list.get(position).getLabel();
        brand = food_list.get(position).getBrand();
        food_id = food_list.get(position).getFood_id();
        //iMainActivity.setData(R., R.id.editBrand, R.id.food_idView, label, brand, food_id);
        iMainActivity.inflateFragment(getString(R.string.FragmentAddItem), label, brand, food_id);



    }
    //Interface to create a communication link from SearchFrag to MAct to AddFrag


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iMainActivity = (MainActivity) getActivity();
    }


}
