package se.alicedarner.flickerino;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface FlickrService {
    @Headers("Content-Type: application/json")
    @GET("services/rest/")
    Call<SearchResult> search(@Query("method") String method,
                              @Query("text") String text,
                              @Query("api_key") String api_key,
                              @Query("format") String format,
                              @Query("nojsoncallback") int jsonCallback);
}
