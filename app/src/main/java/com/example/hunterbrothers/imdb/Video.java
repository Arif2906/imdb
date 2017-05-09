package com.example.hunterbrothers.imdb;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.list;

public class Video extends AppCompatActivity {

    Button button;
    private String movieid;
    ImageView backImage;
    TextView overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        backImage= (ImageView) findViewById(R.id.backmovieimage);
        overview= (TextView) findViewById(R.id.overview);
        button= (Button) findViewById(R.id.playerButton);
        Intent intent=getIntent();
        String description=intent.getStringExtra("overview");
        String uri=intent.getStringExtra("backimage");
        Log.d("check ","uri is"+uri);
         movieid=intent.getStringExtra("movieid");
        overview.setText(description);
        Picasso.with(Video.this).load("http://image.tmdb.org/t/p/w500"+uri).into(backImage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadVideo();
            }
        });
    }

    public void loadVideo(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        movievideoapiInterface movievideoapiInterface=retrofit.create(movievideoapiInterface.class);
        Log.d("check","movie id is"+movieid);
        Call<movievideoresult> call=movievideoapiInterface.call(movieid,"c057644a95291eb9fd1dfa7403fa250c");
        call.enqueue(new Callback<movievideoresult>() {
            @Override
            public void onResponse(Call<movievideoresult> call, Response<movievideoresult> response) {
               //   String videokey = response.body().getResults().get(1).getKey().toString();
                for(videoResult v:response.body().getResults()) {
                    if (v.getType().contains("Trailer")){
                        watchYoutubeVideo(v.getKey());
                        break;
                    }
                }


            }

            @Override
            public void onFailure(Call<movievideoresult> call, Throwable t) {
            }
        });
    }

    public void watchYoutubeVideo(String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
