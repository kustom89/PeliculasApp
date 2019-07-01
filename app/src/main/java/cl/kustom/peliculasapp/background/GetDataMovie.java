package cl.kustom.peliculasapp.background;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.Map;


import cl.kustom.peliculasapp.models.MovieResults;
import cl.kustom.peliculasapp.networks.GetMovie;
import cl.kustom.peliculasapp.networks.MovieInterceptor;
import retrofit2.Call;
import retrofit2.Response;

public abstract class GetDataMovie extends AsyncTask <String, Void, MovieResults[]> {



    @Override
    protected MovieResults[] doInBackground(String... voids) {
        Log.d("Kustom 1","Kustom");
        GetMovie movie = new MovieInterceptor().get();
        Log.d("Kustom2",movie.toString());
        Call <MovieResults[]> indicator = movie.movieBypopularity("34738023d27013e6d1b995443764da44");
        Log.d("Kustom3",indicator.toString());

        try {
            Response<MovieResults[]> response = indicator.execute();
            Log.d("Kustom4",response.toString());
            if(200 == response.code() && response.isSuccessful())
            {
                Log.d("Kustom4",response.body().toString());
                return response.body();
            }else
            {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}


