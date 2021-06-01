package edu.neu.cs5520.numad21su_shuweiwang;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ReviewHolder extends RecyclerView.ViewHolder {
    public TextView itemName;
    public TextView itemURL;

    public ReviewHolder (View itemView, final ItemClickListener listener) {
        super(itemView);

    }
}
