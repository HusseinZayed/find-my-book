package com.example.MyBook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

public class DetailsMyBook extends AppCompatActivity {

    private TextInputEditText title;
    private TextInputEditText categry;
    private TextInputEditText date;
    private TextInputEditText rate;
    private TextInputEditText countVote;
    private TextInputEditText countPage;
    private TextInputEditText desc;

    private String titleD,categryD,dateD,rateD,countPageD,countVoteD,descD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_my_book);

        title =findViewById(R.id.txtTitle);
        categry =findViewById(R.id.txtCategory);
        date =findViewById(R.id.txtDatePublisher);
        rate =findViewById(R.id.txtRate);
        countPage =findViewById(R.id.txtPageCount);
        countVote =findViewById(R.id.txtVoteCount);
        desc =findViewById(R.id.txtDesc);

        titleD = getIntent().getStringExtra("title");
        categryD = getIntent().getStringExtra("categry");
        dateD = getIntent().getStringExtra("date");
        rateD = getIntent().getStringExtra("rate");
        countPageD = getIntent().getStringExtra("page");
        countVoteD = getIntent().getStringExtra("countVote");
        descD = getIntent().getStringExtra("desc");

       disEnable();
       fillField();


    }


    private void fillField()
    {
        title.setText(titleD);
        categry.setText(categryD);
        date.setText(dateD);
        rate.setText(rateD);
        countVote.setText(countVoteD);
        countPage.setText(countPageD);
        desc.setText(descD);
    }

    private void disEnable()
    {
        title.setEnabled(false);
        countVote.setEnabled(false);
        categry.setEnabled(false);
        date.setEnabled(false);
        desc.setEnabled(false);
        rate.setEnabled(false);
        countPage.setEnabled(false);
    }
}
