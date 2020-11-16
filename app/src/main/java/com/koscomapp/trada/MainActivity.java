package com.koscomapp.trada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.koscomapp.trada.mainFragment.MyPageFragment;
import com.koscomapp.trada.mainFragment.StatFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    private Fragment myPageFrag, statFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        myPageFrag = new MyPageFragment();
        statFrag = new StatFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, myPageFrag).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

    }
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.tab_tradeDiary:
                    transaction.replace(R.id.frameLayout, statFrag).commitAllowingStateLoss();

                    break;
                case R.id.tab_feed:
                    transaction.replace(R.id.frameLayout, statFrag).commitAllowingStateLoss();
                    break;
                case R.id.tab_writeDiary:
                    transaction.replace(R.id.frameLayout, statFrag).commitAllowingStateLoss();
                    break;
                case R.id.tab_stats:
                    transaction.replace(R.id.frameLayout, statFrag).commitAllowingStateLoss();
                    break;
                case R.id.tab_myPage:
                    transaction.replace(R.id.frameLayout, myPageFrag).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }

}

