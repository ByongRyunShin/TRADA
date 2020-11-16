package com.koscomapp.trada.mainFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.koscomapp.trada.R;

public class StatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_stat, container, false);

        // Inflate the layout for this fragment
        ScrollView scrollView = (ScrollView) root.findViewById(R.id.scrollView);
        Button button1 = (Button) root.findViewById(R.id.btn_stat1);
        Button button2 = (Button) root.findViewById(R.id.btn_stat2);
        Button button3 = (Button) root.findViewById(R.id.btn_stat3);

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

        return root;
    }
}