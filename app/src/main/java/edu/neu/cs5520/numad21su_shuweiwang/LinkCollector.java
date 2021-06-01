package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LinkCollector extends AppCompatActivity {
    // Creating RecyclerView, Adapter, LayoutManager
    private ArrayList<ItemCard> itemlist = new ArrayList<>();

    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    private RecyclerView.LayoutManager rLayoutManager;
    private FloatingActionButton addButton;

}
