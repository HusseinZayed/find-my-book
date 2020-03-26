package com.example.MyBook;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


// class adapter   should extend    <> have ViewHolder (class extend from RecyclerView.ViewHolder )
// in inside this class send data to layout
public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    ArrayList<Book> modelview;

    public myAdapter(ArrayList<Book> modelview) {
        this.modelview = modelview;

    }

    @NonNull
    @Override
    //note : this method do with number item(view_holder)  which display on screen only after this no
    // this oppsite list view all time dispaly item call method getView() from adapter
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate to custom layout which hold data
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_book_show, null, false);
        // send layout to class myViewHolder
        myViewHolder myHolder = new myViewHolder(v);

        //return holder to can all method see it
        return myHolder;
    }


    // link data to holder
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        Book model = modelview.get(position);
        holder.author.setText("Author : "+model.getAuthor());
        holder.tilte.setText("Tilte : "+model.getTitle());


    }

    @Override
    public int getItemCount() {
        return modelview.size();
    }


    // holder class to recive custom_layout to can find_view_item
    //may declare out no problem

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView tilte,author;

        public myViewHolder(@NonNull View itemView) {  // itemView == custom_layout
            super(itemView);
            tilte=itemView.findViewById(R.id.txtTitle);
            author=itemView.findViewById(R.id.txtAuthor);
        }
    }
}
