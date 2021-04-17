package meudominio.com.movies.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import meudominio.com.movies.models.MovieModel;

//classe para se obter um único filme
public class MovieResponse {
 //buscando o objeto 'filme'
    @SerializedName("results")
    @Expose()
    private MovieModel movie;
    public MovieModel getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
