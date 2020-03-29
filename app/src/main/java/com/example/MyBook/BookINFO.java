package com.example.MyBook;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookINFO {

    public ArrayList<Book> getAllBook(String file) {

        JSONObject jsonObject = null;
        JSONArray itemsArray = null;

        ArrayList<Book> Books = new ArrayList<>();

        try {
            jsonObject = new JSONObject(file);
            itemsArray = jsonObject.getJSONArray("items");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        int i = 0;
        String title = null;
        String authors = null;
        String publisherDate = null;
        String description = null;
        String pageCount = null;
        String rate = null;
        String voteCount = null;
        String catogry;

        while (i < itemsArray.length()  ) {
            // Get the current item information.
            JSONObject book = null;
            JSONObject volumeInfo = null;
            try {
                book = itemsArray.getJSONObject(i);
                volumeInfo = book.getJSONObject("volumeInfo");

            } catch (JSONException e) {
                e.printStackTrace();
            }


            // Try to get the author and title from the current item,
            // catch if either field is empty and move on.
            try {
                Book mybook = new Book();
                title = volumeInfo.getString("title");
                authors = volumeInfo.getString("authors");
                publisherDate =volumeInfo.getString("publishedDate");
                description = volumeInfo.getString("description");
                pageCount = volumeInfo.getString("pageCount");
                rate = volumeInfo.getString("averageRating");
                voteCount = volumeInfo.getString("ratingsCount");
                catogry= volumeInfo.getString("categories");

                mybook.setTitle(title);
                mybook.setAuthor(authors);
                mybook.setDate(publisherDate);
                mybook.setRate(rate);
                mybook.setVoteCount(voteCount);
                mybook.setDescription(description);
                mybook.setPageCount(pageCount);
                mybook.setCatogry(catogry);
                Books.add(mybook);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Move to the next item.
            i++;
        }

        return Books;
    }
}
