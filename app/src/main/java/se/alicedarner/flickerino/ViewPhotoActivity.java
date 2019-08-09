package se.alicedarner.flickerino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import se.alicedarner.flickerino.service.searchObjects.Photo;

public class ViewPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_photo_activity);

        Intent intent = getIntent();
        String id = intent.getStringExtra("photo_id");
        String farm = intent.getStringExtra("photo_farm");
        String owner = intent.getStringExtra("photo_owner");
        String server = intent.getStringExtra("photo_server");
        String secret = intent.getStringExtra("photo_secret");

        TextView textView = findViewById(R.id.titleTextView);
        textView.setText(id);

        ImageView image = findViewById(R.id.selectedPhotoImageView);

        Glide.with(image.getContext()).load(getHeroImageUrl(farm, server, id, secret)).into(image);
    }

    private String getHeroImageUrl(String farm, String server, String id, String secret) {
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s_b.jpg", farm, server, id, secret);

    }
}
