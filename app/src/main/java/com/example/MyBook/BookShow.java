package com.example.MyBook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class BookShow extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Book>> {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager lm ;
    myAdapter adapter;
    String url ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_show);

         url = getIntent().getStringExtra("Word");
        Toast.makeText(this, url, Toast.LENGTH_LONG).show();
         recyclerView = findViewById(R.id.myRecycleView);

        //args data from user or any thing and pass to create loader
        getSupportLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @NonNull  //#5F266D
    @Override
    //create loader here (call asyncTaskLoader
    public Loader<ArrayList<Book>> onCreateLoader(int id, @Nullable Bundle args) {
        return new MyLoader(getApplicationContext(), url);
    }

    //result from doBackground come in this function
    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Book>> loader, ArrayList<Book> data) {
        adapter = new myAdapter(data, new setOnRecycleViewListener() {
            @Override
            public void onMyClick(Book book) {
                Intent intent = new Intent(getApplicationContext(),DetailsMyBook.class);
                intent.putExtra("title",book.getTitle());
                intent.putExtra("categry",book.getCatogry());
                intent.putExtra("date",book.getDate());
                intent.putExtra("rate",book.getRate());
                intent.putExtra("page",book.getPageCount());
                intent.putExtra("countVote",book.getVoteCount());
                intent.putExtra("desc",book.getDescription());
                startActivity(intent);
            }
        });
        lm = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Book>> loader) {

    }
}
