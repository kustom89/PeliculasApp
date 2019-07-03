package cl.kustom.peliculasapp.networks;

import cl.kustom.peliculasapp.models.MoviesWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovie {

    String key = "34738023d27013e6d1b995443764da44";
    String id = "api_key";

    @GET("popular") // api_key=34738023d27013e6d1b995443764da44
    Call <MoviesWrapper> movieBypopularity(@Query(id)String apiKey); // @Query("count") int count
}
