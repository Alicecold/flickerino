package se.alicedarner.flickerino.service;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import se.alicedarner.flickerino.service.getImageDataObjects.Selectedimage;
import se.alicedarner.flickerino.service.searchObjects.SearchResult;

public interface FlickrService {
    @Headers("Content-Type: application/json")
    @GET("services/rest/")
    Call<SearchResult> search(@Query("method") String method,
                              @Query("text") String text,
                              @Query("api_key") String api_key,
                              @Query("format") String format,
                              @Query("is_commons") boolean is_commons,
                              @Query("nojsoncallback") int jsonCallback);

    @Headers("Content-Type: application/json")
    @GET("services/rest/")
    Call<SearchResult> search(@Query("method") String method,
                              @Query("text") String text,
                              @Query("api_key") String api_key,
                              @Query("format") String format,
                              @Query("nojsoncallback") int jsonCallback);

    @Headers("Content-Type: application/json")
    @GET("services/rest/")
    Call<Selectedimage> getImage(@Query("method") String method,
                                 @Query("photo_id") String photoId,
                                 @Query("api_key")String apiKey,
                                 @Query("format")String format,
                                 @Query("nojsoncallback") int jsonCallback);
}
