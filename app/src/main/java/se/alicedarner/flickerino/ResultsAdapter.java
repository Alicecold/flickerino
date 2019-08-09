package se.alicedarner.flickerino;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import se.alicedarner.flickerino.service.Photo;

class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {
    private List<Photo> photos;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.photo_title);
            v.setOnClickListener(getOnClick());
        }

        private View.OnClickListener getOnClick() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            };
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
        String photoTitle = photos.get(position).getTitle();
        holder.textView.setText(photoTitle);
    }


    @Override
    public int getItemCount() {
        return photos.size();
    }
}
