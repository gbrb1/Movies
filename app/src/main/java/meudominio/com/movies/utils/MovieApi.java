package meudominio.com.movies.utils;

import meudominio.com.movies.response.MovieSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    //buscando filmes

    @GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );


}
