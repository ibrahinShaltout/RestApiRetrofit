package com.example.restapiretrofit.data;

import com.example.restapiretrofit.pojo.PostModel;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private ApiInterface apiInterface;
    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static PostsClient getINSTANCE() {

        if (null == INSTANCE)
            INSTANCE = new PostsClient();
        return INSTANCE;
    }

    public Observable<List<PostModel>> getPosts() {
        return apiInterface.getPosts();
    }
}
