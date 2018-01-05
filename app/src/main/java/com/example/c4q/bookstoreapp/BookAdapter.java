package com.example.c4q.bookstoreapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q on 1/3/18.
 */

public class BookAdapter extends RecyclerView.Adapter <BookViewHolder> {
    List<Book> bookList;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item_view_layout, parent, false);
        return new BookViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.onBind(book);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

}
