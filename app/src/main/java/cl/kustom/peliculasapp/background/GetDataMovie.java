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


        //Log.d("Kustom 1","Kustom");
        GetMovie movie = new MovieInterceptor().get();
        ///Log.d("Kustom2",movie.toString());
        Call <MoviesWrapper> indicator = movie.movieBypopularity(GetMovie.key);
        //Log.d("Kustom3",indicator.toString());

        try {
            Response <MoviesWrapper> response = indicator.execute();
            Log.d("Kustom4",response.toString());
            Log.d("Kustom4","Pasando por el if");
            if(200 == response.code() && response.isSuccessful())
            {


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
        Log.d("Kustom ", "Las putah");
        if(movies !=null){
            Log.d("Kustom post Fragment", movies.get(0).getTitle());

            //adapter.update(Arrays.asList(moviesWrappers));
        }else{
           Log.d("Kustom","else del asynctaks"); //Toast.makeText(getContext(), "Esta tirando null", Toast.LENGTH_SHORT).show();


        }

        //progressDialog.dismiss();
    }




    //protected abstract void onPostExecute(MoviesWrapper[] moviesWrappers);

}


