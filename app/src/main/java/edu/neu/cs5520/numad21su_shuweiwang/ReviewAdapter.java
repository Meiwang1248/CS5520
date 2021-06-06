package edu.neu.cs5520.numad21su_shuweiwang;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewHolder> {
    private final ArrayList<ItemCard> itemList;
    private ItemClickListener listener;
    Context context;

    @Override
    public ReviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ReviewHolder(context, view, listener);
    }

    //Constructor
    public ReviewAdapter(ArrayList<ItemCard> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        // binds ItemClickListener with ItemCard, as adapter is the middle man
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(ReviewHolder holder, int position) {
        // activity onCreate()后就马上调用了onBindViewHolder()，因为一打开页面，点击item就可以马上更新数据
        // 更新当前viewHolder
        // LayoutManager请求某个位置的item，便去ViewHolder的两个地方找。
        //  在Cache,就啥都不用调动，直接return.
        //  不在Cashe, 在Recycled Pool，调动onBindViewHolder（），就像我们APP，load过的数据，
        //  回看不用重新load，但数据有可能变动了，所以view要进行更新。
        ItemCard currentItem = itemList.get(position);

        holder.itemName.setText(currentItem.getName());
        holder.itemURL.setText(currentItem.getURL());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
