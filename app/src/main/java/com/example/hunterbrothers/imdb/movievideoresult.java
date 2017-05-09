package com.example.hunterbrothers.imdb;

import java.util.List;

/**
 * Created by hunter brothers on 5/7/2017.
 */



    import java.util.ArrayList;
    import java.util.List;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    public class movievideoresult {


        private List<videoResult> results =null;


        public List<videoResult> getResults() {
            return results;
        }

        public void setResults(List<videoResult> results) {
            this.results = results;
        }

    }



