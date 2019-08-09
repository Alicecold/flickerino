package se.alicedarner.flickerino;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.alicedarner.flickerino.service.RetrofitInstance;
import se.alicedarner.flickerino.service.searchObjects.SearchResult;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem useCommonsCheckbox = navigationView.getMenu().findItem(R.id.commons);
        CompoundButton checkView = (CompoundButton) useCommonsCheckbox.getActionView();
        checkView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SearchSettings.setUseCommons(isChecked);
            }
        });

        Button searchButton = findViewById(R.id.searchButton);
        final TextView searchTextView = findViewById(R.id.searchTextView);

        RecyclerView recyclerView = findViewById(R.id.resultRecyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);


        final RetrofitInstance retrofit = RetrofitInstance.getInstance();
        searchButton.setOnClickListener(onSearchButtonClickListerner(searchTextView, retrofit, recyclerView));
    }

    private View.OnClickListener onSearchButtonClickListerner(final TextView searchTextView, final RetrofitInstance retrofit, final RecyclerView recyclerView) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchTextView.getText().toString();
                if (!query.trim().isEmpty()) {
                    Call<SearchResult> call;

                    /* For some reason, use_commons flag in the flickr API acts like true when explicitly set to false */
                    if (SearchSettings.useCommons()) {
                        call = retrofit.search(query, getApplicationContext().getResources().getString(R.string.flickr_key),
                                SearchSettings.useCommons());
                    } else {
                        call = retrofit.search(query, getApplicationContext().getResources().getString(R.string.flickr_key));
                    }

                    call.enqueue(getUpdateUICallback(recyclerView));
                }
            }
        };
    }

    private Callback<SearchResult> getUpdateUICallback(final RecyclerView recyclerView) {
        return new Callback<SearchResult>() {
            @Override
            public void onResponse(@NonNull Call<SearchResult> call, @NonNull Response<SearchResult> response) {
                SearchResult searchResult = response.body();
                if (searchResult != null) {
                    ResultsAdapter adapter = new ResultsAdapter(searchResult.getResult().getPhotos());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<SearchResult> call, @NonNull Throwable t) {
                Log.e("Oh no!", t.getMessage());
            }
        };
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.commons) {
            MenuItem useCommonsCheckbox = navigationView.getMenu().findItem(R.id.commons);
            CompoundButton checkView = (CompoundButton) useCommonsCheckbox.getActionView();
            checkView.setChecked(!checkView.isChecked());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
