package com.example.c4q.bookstoreapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 1/3/18.
 */

public interface BookService {

    @GET("tamingtext/book/master/apache-solr/example/exampledocs/books.json")
    Call<List<Book>> getBook();

}
