package com.example.MyBook;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;


// take type return
public class MyLoader extends AsyncTaskLoader<ArrayList<Book>> {
    String url;
    NetworkUtils networkUtils = new NetworkUtils();
    BookINFO bookINFO = new BookINFO();

    public MyLoader(@NonNull Context context,String url) {
        super(context);
        this.url = url;
    }

    @Nullable
    @Override
    public ArrayList<Book> loadInBackground() {

        String myJsonFile = networkUtils.getJsonFile(url);
        return bookINFO.getAllBook(myJsonFile) ; //data return to loadfinsh in mainactivity
    }
}
