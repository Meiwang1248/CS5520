package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LinksCollector extends AppCompatActivity implements Dialog.DialogListener  {

    // Creating RecyclerView, Adapter, LayoutManager
    private ArrayList<ItemCard> itemList = new ArrayList<>();

    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    private RecyclerView.LayoutManager rLayoutManager;
    private FloatingActionButton addButton;
    private TextView textView;
    private String tips = "Tap URL to go to the website or item to edit the information";

//    private static Context context;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_collector);
//        context = LinksCollector.this;
        textView = findViewById(R.id.textView);
        init(savedInstanceState);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              // we use the add function when we hit the addButton. Therefore, item is null
                // and position is -1
                openDialog(null, -1);
                // we add item only when user clicks on OK, not Cancel
//                addItem(position);
            }
        });




        // Swipe left to remove
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(LinksCollector.this, "Delete an item", Toast.LENGTH_SHORT).show();
                int position = viewHolder.getLayoutPosition();
                itemList.remove(position);

                reviewAdapter.notifyItemRemoved(position);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void openDialog(ItemCard item, int position) {
        Dialog dialog = new Dialog(item, position);
        dialog.show(getSupportFragmentManager(), "first dialog");
    }

    // Handling Orientation Changes on Android
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        int size = itemList == null ? 0 : itemList.size();
        outState.putInt(NUMBER_OF_ITEMS, size);

        // Need to generate unique key for each item

        for (int i = 0; i < size; i++) {
            // put name information into instance
            outState.putString(KEY_OF_INSTANCE + i + "0", itemList.get(i).getName());
            // put URL into instance
            outState.putString(KEY_OF_INSTANCE + i + "1", itemList.get(i).getURL());
        }

        outState.putString("text", tips);
        super.onSaveInstanceState(outState);

    }
    

    private void init(Bundle savedInstanceState) {
        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void createRecyclerView() {
        rLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        reviewAdapter = new ReviewAdapter(itemList, this);
        // 看好了看好了！！！创建了的这个itemClickListener，然后就给ReviewAdapter用了（详情看reviewAdapter)
        // 然后！！！reviewAdapter也把这个listener传给了ReviewHolder给它用了。所以，这里就是listener老祖宗的发源地
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //attributions bond to the item has been changed
                // 通过位置position，get到了itemList里面的itemcard,然后调用itemcard的onItemClick()
                itemList.get(position).onItemClick(position);
                openDialog(itemList.get(position), position);
                reviewAdapter.notifyItemChanged(position);
            }
        };
        reviewAdapter.setOnItemClickListener(itemClickListener);

        recyclerView.setAdapter(reviewAdapter);
        recyclerView.setLayoutManager(rLayoutManager);
    }

    private void initialItemData(Bundle savedInstanceState) {
        // Not the first time to open this Activity
        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            if (itemList == null || itemList.size() == 0) {
                int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);

                // Retrieve keys we stored in the instance
                for (int i = 0; i < size; i++) {
                    String name = savedInstanceState.getString(KEY_OF_INSTANCE + i + "0");
                    String URL = savedInstanceState.getString(KEY_OF_INSTANCE + i + "1");
                    itemList.add(new ItemCard(name, URL));
                }


            }
        }
//        else {
//            ItemCard item1 = new ItemCard("Google", "https://www.google.com");
//            ItemCard item2 = new ItemCard("Youtube", "https://www.youtube.com");
//            itemList.add(item1);
//            itemList.add(item2);
//        }
    }

    @Override
    public void transferInfo(int position, String webName, String URL) {
        if (position == -1) {
            addItem(webName, URL);
        } else {
            editItem(position, webName, URL);
        }
    }

    private void editItem(int position, String webName, String url) {
        // I need the position of the to be edited item but I don't know how to retrieve
        // itemList.set(index, new ItemCard(webName, URL);
        itemList.get(position).setName(webName);
        itemList.get(position).setURL(url);
        // !!!need to notify Adapter when data is updated!!! Otherwise, the view won't show the change
        reviewAdapter.notifyItemChanged(position);
        Toast.makeText(LinksCollector.this, "Item was edited successfully", Toast.LENGTH_SHORT).show();
    }


    public void addItem(String webName, String URL) {
        // dialog---get user's input
        // create an item card object with user's info
        // 传进去itemList.add()
        itemList.add(0, new ItemCard(webName, URL));
        Toast.makeText(LinksCollector.this, "Item was added successfully", Toast.LENGTH_SHORT).show();

        // it's a must! Otherwise,  Recycler view won't be notified
       reviewAdapter.notifyItemInserted(0);
    }
}