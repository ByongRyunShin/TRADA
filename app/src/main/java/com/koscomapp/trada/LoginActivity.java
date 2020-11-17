package com.koscomapp.trada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText id, pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id=findViewById(R.id.editTextTextPersonName);
        pw=findViewById(R.id.editTextTextPassword);
    }

    public void onRegisterBtClicked(View v){
        Toast.makeText(getApplicationContext(), "준비중입니다.", Toast.LENGTH_LONG).show();
    }

    public void onLoginBtClicked(View v){
        if(!id.getText().equals("test1") || !id.getText().equals("test2")){
            if(!pw.getText().equals("1234")){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                finish();
            }
            else{
                Toast.makeText(getApplicationContext(), "비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "없는 계정입니다.", Toast.LENGTH_LONG).show();
        }
    }
}