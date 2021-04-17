package meudominio.com.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import meudominio.com.movies.models.MovieModel;
import meudominio.com.movies.request.Servicey;
import meudominio.com.movies.response.MovieSearchResponse;
import meudominio.com.movies.utils.Credentials;
import meudominio.com.movies.utils.MovieApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {
    //botão para fazer as requisições através do retrofit
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetRetrofitResponse();
            }

            private void GetRetrofitResponse() {

                MovieApi movieApi = Servicey.getMovieApi();

                Call<MovieSearchResponse> responseCall = movieApi
                        .searchMovie(
                                Credentials.API_KEY,
                                "Jack Reacher",
                                "1");
                responseCall.enqueue(new Callback<MovieSearchResponse>() {
                    @Override

                    public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                        if(response.code() == 200){
                            Log.v("Tag", "the response"+response.body().toString());
                            List<MovieModel> movies = new ArrayList<>(response.body().getMovies());

                            for(MovieModel movie: movies){

                                Log.v("Tag", "The relese date"+ movie.getRelease_date());
                            }
                        } else {

                            try {
                                Log.v("Tag", "Error"+response.errorBody().string());
                            }
                                catch (IOException e){
                                    e.printStackTrace();
                                }
                        }

                    }

                    @Override
                    public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

                    }
                });
            }
        });


    }
}