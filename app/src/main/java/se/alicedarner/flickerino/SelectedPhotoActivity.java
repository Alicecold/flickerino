package se.alicedarner.flickerino;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.alicedarner.flickerino.service.RetrofitInstance;
import se.alicedarner.flickerino.service.getImageDataObjects.Selectedimage;
import se.alicedarner.flickerino.ui.SelectedPhotoMetaData;
import se.alicedarner.flickerino.utils.ImageUtil;

public class SelectedPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_photo_activity);

        RetrofitInstance retrofit = RetrofitInstance.getInstance();

        Intent intent = getIntent();
        String id = intent.getStringExtra("photo_id");
        String farm = intent.getStringExtra("photo_farm");
        String server = intent.getStringExtra("photo_server");
        String secret = intent.getStringExtra("photo_secret");

        makeImage(id, farm, server, secret);

        Call<Selectedimage> call = retrofit.getSelectedPhoto(id, getApplicationContext().getResources().getString(R.string.flickr_key));
        call.enqueue(getUpdateUICallback());
    }

    private Callback<Selectedimage> getUpdateUICallback() {
        return new Callback<Selectedimage>() {
            @Override
            public void onResponse(@NonNull Call<Selectedimage> call, @NonNull Response<Selectedimage> response) {
                Selectedimage selected = response.body();

                SelectedPhotoMetaData data = new SelectedPhotoMetaData(SelectedPhotoActivity.this);
                if (selected != null) {
                    data.setStrings(selected.getPhoto().getTitle().getContent(),
                            selected.getPhoto().getOwner().getUsername(),
                            selected.getPhoto().getDates().getTaken(),
                            selected.getPhoto().getDescription().getContent());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Selectedimage> call, @NonNull Throwable t) {
                Log.e("Oh no!", t.getMessage());
            }
        };
    }

    private void makeImage(String id, String farm, String server, String secret) {
        ImageView image = findViewById(R.id.selected_photo_image_view);
        Glide.with(image.getContext())
                .load(ImageUtil.getHeroImageUrl(farm, server, id, secret))
                .override(1024, 800)
                .centerCrop()
                .into(image);
    }
}
