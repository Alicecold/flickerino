package se.alicedarner.flickerino;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.alicedarner.flickerino.service.RetrofitHandler;
import se.alicedarner.flickerino.service.SearchResult;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.resultRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RetrofitHandler retrofit = new RetrofitHandler();

        Call<SearchResult> call = retrofit.search("horse", getApplicationContext().getResources().getString(R.string.flickr_key));

        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                SearchResult searchResult = response.body();
                mAdapter = new ResultsAdapter(searchResult.getResult().getPhotos());
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.e("Oh no!", t.getMessage());
            }
        });
    }

}
