package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LinksCollector extends AppCompatActivity {

    // Creating RecyclerView, Adapter, LayoutManager
    private ArrayList<ItemCard> itemList = new ArrayList<>();

    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    private RecyclerView.LayoutManager rLayoutManager;
    private FloatingActionButton addButton;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_collector);

        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        initialItemData(savedInstanceState)
    }

    private void initialItemData(Bundle savedInstanceState) {
        // Not the first time to open this Activity
        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            if (itemList == null || itemList.size() == 0) {
                int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);

                // Retrieve keys we stored in the intance
                for (int i = 0; i < size; i++) {

                }
            }
        }
    }
}