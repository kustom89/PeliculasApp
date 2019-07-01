package cl.kustom.peliculasapp.networks;

import java.util.List;
import java.util.Map;

import cl.kustom.peliculasapp.models.MovieResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GetMovie {

    @GET("popular") // api_key=34738023d27013e6d1b995443764da44
    Call <MovieResults[]> movieBypopularity(@Query("apiKey")String apiKey); // @Query("count") int count
}
