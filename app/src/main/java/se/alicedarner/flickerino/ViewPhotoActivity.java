package se.alicedarner.flickerino;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.alicedarner.flickerino.service.RetrofitInstance;
import se.alicedarner.flickerino.service.getImageDataObjects.Selectedimage;
import se.alicedarner.flickerino.utils.ImageUtil;

public class ViewPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_selected_photo_activity);

        Intent intent = getIntent();
        String id = intent.getStringExtra("photo_id");
        String farm = intent.getStringExtra("photo_farm");
        String server = intent.getStringExtra("photo_server");
        String secret = intent.getStringExtra("photo_secret");

        ImageView image = findViewById(R.id.selectedPhotoImageView);
        Glide.with(image.getContext())
                .load(ImageUtil.getHeroImageUrl(farm, server, id, secret))
                .override(1024, 800)
                .centerCrop()
                .into(image);

        RetrofitInstance retrofit = RetrofitInstance.getInstance();
        Call<Selectedimage> call = retrofit.getImage(id, getApplicationContext().getResources().getString(R.string.flickr_key));
        call.enqueue(new Callback<Selectedimage>() {
            @Override
            public void onResponse(@NonNull Call<Selectedimage> call, @NonNull Response<Selectedimage> response) {
                Selectedimage selected = response.body();
                TextView textView = findViewById(R.id.titleTextView);
                if (selected != null) {
                    textView.setText(selected.getPhoto().getTitle().getContent());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Selectedimage> call, @NonNull Throwable t) {
                Log.e("Oh no!", t.getMessage());
            }
        });
    }
}
