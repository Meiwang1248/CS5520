package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button buttonLink;
    private Button buttonLocation;
    private Button webButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.launcher2);
        buttonLocation = (Button) findViewById(R.id.buttonLocation);
        webButton = (Button) findViewById(R.id.webService);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        buttonLink = (Button) findViewById(R.id.links);
        buttonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkCollector();
            }
        });

        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLocator();
            }
        });

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebService();
            }
        });
    }

    private void openWebService() {
        Intent intent = new Intent(this, WebService.class);
        startActivity(intent);
    }

    // Assignment 3
    private void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    // Assignment 4 Recycler View
    private void openLinkCollector() {
        Intent intent = new Intent(this, LinksCollector.class);
        startActivity(intent);
    }

    private void openLocator() {
        Intent intent = new Intent(this,Locator.class);
        startActivity(intent);
    }

    // Assignment 1
    public void introduceMyself(View view) {
        TextView textView = findViewById(R.id.myInfo);
        textView.setVisibility(View.VISIBLE);
    }





}