package com.example.myquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;//add these
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
  //
    private BottomNavigationView b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView =(BottomNavigationView)findViewById(R.id.botnav);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//setOnlistner type func must be called in oncreate
        toolbar = getSupportActionBar();
        toolbar.setTitle("Home");
        loadFragment(new Home_Fragment());


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.icon1:
                    toolbar.setTitle("Home");
                    fragment = new Home_Fragment();
                    loadFragment(fragment);
                    return true;


                case R.id.icon2:
                    toolbar.setTitle("Topics");
                    fragment = new Topics_Fragment();
                    loadFragment(fragment);
                    return true;

                case R.id.icon3:
                    toolbar.setTitle("Leaderboard");
                    fragment = new LeaderboardFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.icon4:

                    Log.d("TAG","working");
                    toolbar.setTitle("Profile");
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;

            }
            return false;
        }

    };


        private void loadFragment(Fragment fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }



}


