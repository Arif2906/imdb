package com.example.hunterbrothers.imdb;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
  TextView moviesname;
    TextView imdbrating;
    RecyclerView recyclerView;
    public List<Result> collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
      ;

        Gson gson=new Gson();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        movieApiInterface movies = retrofit.create(movieApiInterface.class);
        Call<movieDetail> call = movies.call("c057644a95291eb9fd1dfa7403fa250c");
        call.enqueue(new Callback<movieDetail>() {
            @Override
            public void onResponse(Call<movieDetail> call, Response<movieDetail> response) {
                collection=response.body().getResults();
                recyclerView.setAdapter(new recyclerview(getApplicationContext(),collection));

            }
            @Override
            public void onFailure(Call<movieDetail> call, Throwable t) {
            }
        });
    }
    }



