package com.example.hunterbrothers.imdb;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hunter brothers on 2/24/2017.
 */

public interface movieApiInterface {
    @GET("3/movie/top_rated")
    Call<movieDetail> call (@Query("api_key") String apikey);

}
