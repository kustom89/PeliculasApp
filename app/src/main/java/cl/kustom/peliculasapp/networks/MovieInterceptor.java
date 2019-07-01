package cl.kustom.peliculasapp.networks;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieInterceptor {

    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    public GetMovie get() {



        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                /*Never forget about adding the converter, otherwise you can not parse the data*/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetMovie someRequest = interceptor.create(GetMovie.class);
        /*The interceptor must return an interface, is the same interface where you wrote the methods for the request http*/
        return someRequest;


    }
}
