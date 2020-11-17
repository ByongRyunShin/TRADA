package com.koscomapp.trada.mainFragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.koscomapp.trada.R;

public class WriteManualDiaryFragment extends  Fragment{
    EditText name, memo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_write_manual_diary, container, false);
        //Type here

        name = root.findViewById(R.id.editTextNa);
        memo = root.findViewById(R.id.editTextMe);


        return root;
    }
    public void onSaveBtClicked(View v){
        Toast.makeText(getContext(), "저장되었습니다.", Toast.LENGTH_LONG).show();
    }

}