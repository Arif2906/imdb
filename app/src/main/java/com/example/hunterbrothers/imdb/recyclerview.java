package com.example.hunterbrothers.imdb;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import retrofit2.http.Url;

/**
 * Created by hunter brothers on 2/27/2017.
 */
public class recyclerview extends RecyclerView.Adapter<ViewHolder>{
    Context context;
    List<Result> collection;
    URL url;
    Intent intent;
    public recyclerview(Context context, List<Result> collection) {
        this.context=context;
        this.collection=collection;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.showmovies,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
         final String movieurl="http://image.tmdb.org/t/p/w342"+collection.get(position).getPosterPath();
         Picasso.with(context).load(movieurl).into(holder.moviepicture);
       holder.moviesname.setText(collection.get(position).getTitle());
        Log.d("check","backimage"+collection.get(position).getBackdropPath());
       holder.imdbrating.setImageResource(R.drawable.imdb);
        holder.rating.setText(collection.get(position).getvote_average().toString());
       holder.moviepicture.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                intent=new Intent(context,Video.class);
               intent.putExtra("movieid",collection.get(position).getId().toString());
               intent.putExtra("overview",collection.get(position).getOverview());
               intent.putExtra("backimage",collection.get(position).getBackdropPath());

               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return collection.size();
    }
}
