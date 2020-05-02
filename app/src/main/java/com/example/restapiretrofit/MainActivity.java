package com.example.restapiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_feedback)
    TextView textView_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
////////////////////////////////////////////////////
        ButterKnife.bind(this);
////////////////////////////////////////////////////


        Post post = new Post(5, "ibrahim", "this is my name");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

//        Call<List<Post>> call = aopInterface.getPost("2");
//
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                textView_feedback.setText(response.body().get(0).getTitle());
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                textView_feedback.setText(t.getMessage());
//
//            }
//        });


        Call<Post> call = apiInterface.storePost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                textView_feedback.setText(response.body().getTitle());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView_feedback.setText(t.getMessage());
            }
        });
    }
}
