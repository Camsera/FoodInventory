package com.camjam.tabtest;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.camjam.tabtest.Adapters.RecyclerViewAdapter;
import com.camjam.tabtest.Adapters.ViewPagerAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;


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
        adapter.addFragment(new FragmentAddItem(), "Add Item");
        // Adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //Dumb Animation
        ImageView imageView = (ImageView) findViewById(R.id.swordsLogoId);
        imageView.animate().rotation(360).setDuration(3200).start();
        //Set up Search Fragment activities

    }

}
