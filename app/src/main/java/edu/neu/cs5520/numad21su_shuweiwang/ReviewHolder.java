package edu.neu.cs5520.numad21su_shuweiwang;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class ReviewHolder extends RecyclerView.ViewHolder {
    public TextView itemName;
    public TextView itemURL;

    public ReviewHolder (Context context, View itemView, final ItemClickListener listener) {
        super(itemView);
        itemURL = itemView.findViewById(R.id.URL);
        itemName = itemView.findViewById(R.id.item_name);
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
        itemURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String address = itemURL.getText().toString();
                // if URL is valid, go to the website. Otherwise, notify user.
                if (URLUtil.isValidUrl(address)) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                    context.startActivity(browserIntent);
                } else {
                    Toast.makeText(context, "Invalid URL, please tap the item to re-enter.", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

    }
}
