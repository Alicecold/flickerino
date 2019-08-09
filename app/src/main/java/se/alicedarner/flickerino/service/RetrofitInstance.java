package se.alicedarner.flickerino.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import se.alicedarner.flickerino.service.getImageDataObjects.Selectedimage;
import se.alicedarner.flickerino.service.searchObjects.SearchResult;

/* So this is a singleton, and I'm aware that's not very testable. */

public class RetrofitInstance {
    private static RetrofitInstance retrofit_instance = null;
    private FlickrService service;
    private static OkHttpClient httpClient =  null;

    private void setHttpClient(HttpLoggingInterceptor interceptor) {
        httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    private RetrofitInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        setHttpClient(interceptor);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.flickr.com/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(FlickrService.class);
    }

    public static RetrofitInstance getInstance(){
        if(retrofit_instance == null){
            retrofit_instance = new RetrofitInstance();
        }
        return retrofit_instance;
    }

    public Call<SearchResult> search(String query, String apiKey, boolean get_commons) {
        return service.search("flickr.photos.search", query, apiKey, "json", get_commons,1);
    }
    public Call<SearchResult> search(String query, String apiKey) {
        return service.search("flickr.photos.search", query, apiKey, "json",1);
    }

    public Call<Selectedimage> getImage(String id, String apiKey){
        return service.getImage("flickr.photos.getInfo", id,  apiKey, "json", 1);
    }
}
