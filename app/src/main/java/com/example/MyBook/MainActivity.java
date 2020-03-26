package com.example.MyBook;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {


    TextInputEditText txtSearch;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtSearch = findViewById(R.id.txtSearch);


    }


    public void Search(View view) {

        Intent intent = new Intent(this,BookShow.class);
        url = txtSearch.getText().toString();
        intent.putExtra("Word",url);
        startActivity(intent);
    }
}
