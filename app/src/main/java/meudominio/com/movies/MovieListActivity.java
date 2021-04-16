package meudominio.com.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import meudominio.com.movies.request.Servicey;
import meudominio.com.movies.response.MovieSearchResponse;
import meudominio.com.movies.utils.Credentials;
import meudominio.com.movies.utils.MovieApi;
import retrofit2.Call;

public class MovieListActivity extends AppCompatActivity {

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

            }
        });


    }
}