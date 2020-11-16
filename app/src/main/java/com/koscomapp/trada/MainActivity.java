package com.koscomapp.trada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_1);


        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        Button button1 = (Button) findViewById(R.id.btn_stat1);
        Button button2 = (Button) findViewById(R.id.btn_stat2);
        Button button3 = (Button) findViewById(R.id.btn_stat3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.scrollTo(0,0);


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.scrollTo(0,1450);


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollView.scrollTo(0,2900);


            }
        });




    }
}

