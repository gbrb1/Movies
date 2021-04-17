package meudominio.com.movies.request;

import meudominio.com.movies.utils.Credentials;
import meudominio.com.movies.utils.MovieApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//Serviço MVVM

public class Servicey {

    private static Retrofit.Builder retrofiBuilder =
            new Retrofit.Builder()
                    .baseUrl(Credentials.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofiBuilder.build();

    private static MovieApi movieApi = retrofit.create(MovieApi.class);

    static public MovieApi getMovieApi(){
        return movieApi;
    }

}
