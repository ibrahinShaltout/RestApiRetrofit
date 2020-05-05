package com.example.restapiretrofit;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("posts")
    public Call<List<PostModel>> getPosts();

}
