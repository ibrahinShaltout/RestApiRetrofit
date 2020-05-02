package com.example.restapiretrofit;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    //  using Path
//    @GET("posts/{id}")
//    public Call <List<Post>> getPost(@Path("userId") int userId);

    @GET("posts")
    public Call<List<Post>> getPost(@Query("userId") String userId);

    @POST("posts")
    public Call<Post> storePost(@Body Post post);

    @POST("posts")
    public Call<Post> storePost(@Body HashMap<Object , Object> map);

}
