package com.example.dataapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void InternalStorageAndroid(View v){
        Intent i =new Intent(MainActivity.this,InternalStorageAndroid.class);
        startActivity(i);
    }

    public void ExternalStorage(View v){
        Intent i =new Intent(MainActivity.this,ExternalStorage.class);
        startActivity(i);
    }
}