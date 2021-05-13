package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void introduceMyself(View view) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(R.string.info_string);

    }
}