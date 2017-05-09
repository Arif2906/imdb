package com.example.hunterbrothers.imdb;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hunter brothers on 5/7/2017.
 */

public interface movievideoapiInterface {
      @GET("3/movie/{movie_id}/videos")
    Call <movievideoresult> call(@Path("movie_id")String movieId, @Query("api_key") String apikey);

}
