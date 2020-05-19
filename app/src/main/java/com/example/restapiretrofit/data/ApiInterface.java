package com.example.restapiretrofit.data;

import com.example.restapiretrofit.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("posts")
    public Observable<List<PostModel>> getPosts();

}
