package com.pr.java_mvc_retrofit.Controller;

import com.pr.java_mvc_retrofit.Model.Api.Api;
import com.pr.java_mvc_retrofit.Model.Model.Posts;
import com.pr.java_mvc_retrofit.View.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {
    MainActivity mainActivity;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);
        Call<List<Posts>> call=api.getAllposts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful()){
                    mainActivity.postsArrayList=(ArrayList<Posts>) response.body();
                    mainActivity.updateUi();
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });

    }
}
