package se.alicedarner.flickerino;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.alicedarner.flickerino.service.RetrofitHandler;
import se.alicedarner.flickerino.service.searchObjects.SearchResult;

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


        Button searchButton = findViewById(R.id.searchButton);
        final TextView searchTextView = findViewById(R.id.searchTextView);

        recyclerView = findViewById(R.id.resultRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);


        final RetrofitHandler retrofit = new RetrofitHandler();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchTextView.getText().toString();
                if (!query.trim().isEmpty()) {
                    Call<SearchResult> call = retrofit.search(query, getApplicationContext().getResources().getString(R.string.flickr_key));

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
        });

    }

}
