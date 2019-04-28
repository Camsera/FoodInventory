package com.camjam.tabtest;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.camjam.tabtest.Adapters.RecyclerViewAdapter;
import com.camjam.tabtest.Adapters.ViewPagerAdapter;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements IMainActivity  {

    private static final String TAG = "MainActivity";
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    protected String label;
    private FragmentAddItem fragmentAddItem;




    //Holder Variables for logic
    //Search Variables


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBar);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // Adding Fragments
        adapter.addFragment(new FragmentShelf(), "Shelf");
        adapter.addFragment(new FragmentSearch(), "Search");
        fragmentAddItem = new FragmentAddItem();
        adapter.addFragment(fragmentAddItem, "Add Item");
        // Adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //Dumb Animation
        ImageView imageView = (ImageView) findViewById(R.id.swordsLogoId);
        imageView.animate().rotation(360).setDuration(3200).start();
        //Set up Search Fragment activities

    }
        //Sends list data to populate add item fragment

    public void doFragmentTransaction(String tag, String label, String brand, String food_id){
        fragmentAddItem.setValues(label, brand, food_id);
        viewPager.setCurrentItem(3);


    }


    @Override
    public void inflateFragment(String tag, String label, String brand, String food_id) {
        if(tag.equals(getString(R.string.FragmentAddItem))){
           doFragmentTransaction(tag, label, brand, food_id);
        }
    }



}
