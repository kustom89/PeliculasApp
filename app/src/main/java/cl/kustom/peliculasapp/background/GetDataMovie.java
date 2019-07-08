package cl.kustom.peliculasapp.background;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import cl.kustom.peliculasapp.models.Movie;
import cl.kustom.peliculasapp.models.MoviesWrapper;
import cl.kustom.peliculasapp.networks.GetMovie;
import cl.kustom.peliculasapp.networks.MovieInterceptor;
import retrofit2.Call;
import retrofit2.Response;

public class GetDataMovie extends AsyncTask <String, String, List <Movie>>{

    public GetDataMovie() {
    }

    @Override
    protected List <Movie> doInBackground(String... voids) {


        Log.d("Kustom 1","***************DO-IN-BACKGROUND*************");
        GetMovie movie = new MovieInterceptor().get();
        Call <MoviesWrapper> indicator = movie.movieBypopularity(GetMovie.key);

        try {
            Response <MoviesWrapper> response = indicator.execute();
            Log.d("Kustom ", "************************OBTENIENDO URL DEL SERVICIO*********************");
            Log.d("Kustom URL",response.toString());

            if(200 == response.code() && response.isSuccessful())
            {

                Log.d("Kustom ", "************************OBTENIENDO DATOS DEL SERVICIO*********************");
                Log.d("Kustom CANTIDAD DE RESULTADOS =====> ", String.valueOf(response.body().getTotal_results()));
                return response.body().getResults();

            }else
            {

                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

   @Override
    protected void onPostExecute(List <Movie> movies) {
      Log.d("Kustom ", "**********************ON-POST-EXECUTE***********************");

        if(movies !=null){
        for (int i = 0; i < movies.size(); i++) {
            Log.d("Kustom post Fragment", String.valueOf(movies.get(i).getTitle()));
        }

        }else{



        }

    }




    //protected abstract void onPostExecute(MoviesWrapper[] moviesWrappers);

}


