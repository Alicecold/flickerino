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
import se.alicedarner.flickerino.utils.ImageUtil;

class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {
    private static List<Photo> photos;

    ResultsAdapter(List<Photo> photos) {
        ResultsAdapter.photos = photos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_item_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.image.getContext())
                .load(ImageUtil.getThumbnailUrl(photos.get(position)))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView image;

        ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.resultItemImageView);
            v.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), SelectedPhotoActivity.class);
                    intent.putExtra("photo_id", ResultsAdapter.photos.get(getAdapterPosition()).getId());
                    intent.putExtra("photo_farm", ResultsAdapter.photos.get(getAdapterPosition()).getFarm());
                    intent.putExtra("photo_server", ResultsAdapter.photos.get(getAdapterPosition()).getServer());
                    intent.putExtra("photo_secret", ResultsAdapter.photos.get(getAdapterPosition()).getSecret());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
