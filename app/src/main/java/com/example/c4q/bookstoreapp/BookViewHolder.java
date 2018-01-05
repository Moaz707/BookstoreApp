package com.example.c4q.bookstoreapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by c4q on 1/3/18.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView author;
    TextView price;

    public BookViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_view);
        author = itemView.findViewById(R.id.author_view);
        price = itemView.findViewById(R.id.price_view);
    }

    public void onBind(Book book) {
        title.setText(book.getName());
        author.setText(book.getAuthor());
        price.setText(String.valueOf(book.getPrice()));

    }


}
