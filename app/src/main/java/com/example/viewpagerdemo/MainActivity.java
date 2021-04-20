package com.example.viewpagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.net.Uri;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.PagerAdapter;

public class MainActivity extends AppCompatActivity implements
        Tab1Fragment.OnFragmentInteractionListener,
        Tab2Fragment.OnFragmentInteractionListener,
        Tab3Fragment.OnFragmentInteractionListener,
        Tab4Fragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tb);
       setSupportActionBar(toolbar);

        configureTabLayout();
    }

    private void configureTabLayout() {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1 Item").setIcon(
                android.R.drawable.ic_dialog_email));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2 Item").setIcon(
                android.R.drawable.ic_dialog_dialer));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3 Item").setIcon(
                android.R.drawable.ic_dialog_map));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4 Item").setIcon(
                android.R.drawable.ic_dialog_info));
        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new TabPagerAdapter
                (getSupportFragmentManager(),
                        tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}