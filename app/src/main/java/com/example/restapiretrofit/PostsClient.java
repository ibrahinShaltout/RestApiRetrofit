package com.example.restapiretrofit;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private  static  final  String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private ApiInterface apiInterface;
    private static PostsClient INSTANCE ;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static PostsClient getINSTANCE() {

        if (null == INSTANCE)
            INSTANCE = new PostsClient();
        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts()
    {
        return apiInterface.getPosts();
    }
}
