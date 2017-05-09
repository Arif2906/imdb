package com.example.hunterbrothers.imdb;

/**
 * Created by hunter brothers on 2/24/2017.
 */




    import java.util.List;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    public class movieDetail {


        private Integer page;

        private List<Result> results = null;

        private Integer totalResults;

        private Integer totalPages;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

        public Integer getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

    }


