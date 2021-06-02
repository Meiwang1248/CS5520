package edu.neu.cs5520.numad21su_shuweiwang;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ReviewHolder extends RecyclerView.ViewHolder {
    public TextView itemName;
    public TextView itemURL;

    public ReviewHolder (View itemView, final ItemClickListener listener) {
        super(itemView);
//        itemIcon = itemView.findViewById(R.id.item_icon);
//        itemName = itemView.findViewById(R.id.item_name);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });

    }
}
