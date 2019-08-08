package se.alicedarner.flickerino;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHandler {
    Retrofit retrofit;
    FlickrService service;
    private static OkHttpClient httpClient = new OkHttpClient();

    private void setHttpClient(HttpLoggingInterceptor interceptor) {
        httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public RetrofitHandler() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        setHttpClient(interceptor);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.flickr.com/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(FlickrService.class);
    }

    public FlickrService getService() {
        return service;
    }
}
