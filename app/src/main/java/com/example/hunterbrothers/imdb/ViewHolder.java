package com.example.hunterbrothers.imdb;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hunter brothers on 2/27/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView moviesname;
    TextView rating;
    ImageView imdbrating;
    ImageView moviepicture;
    RelativeLayout relativeLayout;
    public ViewHolder(View itemView) {
        super(itemView);
        moviesname= (TextView) itemView.findViewById(R.id.moviesname);
        rating= (TextView) itemView.findViewById(R.id.myImageViewText);
        imdbrating= (ImageView) itemView.findViewById(R.id.imdbrating);
        moviepicture=(ImageView)itemView.findViewById(R.id.movieImage);
        relativeLayout= (RelativeLayout) itemView.findViewById(R.id.moviepage);
    }
}
