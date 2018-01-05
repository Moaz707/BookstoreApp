package com.example.c4q.bookstoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private BookService bookService;
    public static final String TAG = "JSON?";
    RecyclerView bookRecyclerView; //RecyclerView is in layout resources, so to be able to use it in application resources, we are binding the data into java


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookRecyclerView = findViewById(R.id.book_recycler_view);
        connectApi();



    }

    public void connectApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bookService = retrofit.create(BookService.class);

        Call<List<Book>> book = bookService.getBook();
        book.enqueue(new Callback<List<Book>>() {

            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                bookRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //setting it inside the onResponse bc the list only exists in the onResponse method
                BookAdapter bookAdapter = new BookAdapter(response.body()); //this is just a class and can be called anywhere
                bookRecyclerView.setAdapter(bookAdapter);

                Log.d(TAG, "onResponse " + response.body());
                Log.d(TAG, "bookObject " + response.body().get(1).getName());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                t.printStackTrace(); //to catch errors

            }
        });

    }

}
