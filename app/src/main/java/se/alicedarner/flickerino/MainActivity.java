package se.alicedarner.flickerino;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RetrofitHandler retrofit = new RetrofitHandler();

        Call<SearchResult> call = retrofit.getService().search("flickr.photos.search", "wood", getApplicationContext().getResources().getString(R.string.flickr_key), "json", 1);

        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                Log.d("Yay!", response.raw().toString());
                SearchResult searchResult = response.body();
                Log.d("Yay!", String.valueOf(searchResult.getResult().getPage()));
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.e("Oh no!", t.getMessage());
            }
        });
    }

}
