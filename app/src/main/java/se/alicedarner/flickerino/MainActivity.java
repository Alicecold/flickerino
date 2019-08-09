package se.alicedarner.flickerino;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.alicedarner.flickerino.service.RetrofitHandler;
import se.alicedarner.flickerino.service.searchObjects.SearchResult;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private boolean use_commons = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem safeSearchCheckbox = navigationView.getMenu().findItem(R.id.commons);
        CompoundButton checkView = (CompoundButton) safeSearchCheckbox.getActionView();
        checkView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                use_commons = isChecked;
            }
        });


        //////

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
                    Call<SearchResult> call;

                    if (use_commons) {
                        call = retrofit.search(query, getApplicationContext().getResources().getString(R.string.flickr_key), use_commons);
                    } else {
                        call = retrofit.search(query, getApplicationContext().getResources().getString(R.string.flickr_key));
                    }

                    call.enqueue(new Callback<SearchResult>() {
                        @Override
                        public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                            SearchResult searchResult = response.body();
                            ResultsAdapter adapter = new ResultsAdapter(searchResult.getResult().getPhotos());
                            recyclerView.setAdapter(adapter);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.commons) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
