package se.alicedarner.flickerino;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import se.alicedarner.flickerino.service.searchObjects.Photo;

class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {
    private List<Photo> photos;

    static class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView image;

        ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.resultItemImageView);
            v.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ViewPhotoActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    ResultsAdapter(List<Photo> photos) {
        this.photos = photos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_result_item_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.image.getContext()).load(getThumbnailUrl(photos.get(position))).into(holder.image);
    }


    private String getThumbnailUrl(Photo photo){
        return String.format("https://farm%s.staticflickr.com/%s/%s_%s_t.jpg", photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret());
    }


    @Override
    public int getItemCount() {
        return photos.size();
    }
}
