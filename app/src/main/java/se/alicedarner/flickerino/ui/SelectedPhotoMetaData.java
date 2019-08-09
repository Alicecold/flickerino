package se.alicedarner.flickerino.ui;

import android.app.Activity;
import android.widget.TextView;

import se.alicedarner.flickerino.R;

public class SelectedPhotoMetaData {

    private TextView title;
    private TextView owner;
    private TextView taken;
    private TextView description;

    public SelectedPhotoMetaData(Activity activity) {
        title = activity.findViewById(R.id.title_text_view);
        owner = activity.findViewById(R.id.owner_text_view);
        taken = activity.findViewById(R.id.taken_date_text_view);
        description = activity.findViewById(R.id.description_text_view);
    }

    public void setStrings(String title, String owner, String taken, String description) {
        this.title.setText(title);
        this.owner.setText(String.format("by %s", owner));
        this.taken.setText(taken);
        this.description.setText(description);
    }
}
