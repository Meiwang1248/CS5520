package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    String pressed = "Pressed: None";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        if(savedInstanceState != null) {
            pressed = savedInstanceState.getString("text");
        }
        TextView text = findViewById(R.id.textViewPress);
        text.setText(pressed);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.A_button:
                TextView text = findViewById(R.id.textViewPress);
                pressed = "Pressed: A";
                text.setText(pressed);
                break;
            case R.id.B_button:
                text = findViewById(R.id.textViewPress);
                pressed = "Pressed: B";
                text.setText(pressed);
                break;
            case R.id.C_button:
                text = findViewById(R.id.textViewPress);
                pressed = "Pressed: C";
                text.setText(pressed);
                break;
            case R.id.D_button:
                text = findViewById(R.id.textViewPress);
                pressed = "Pressed: D";
                text.setText(pressed);
                break;
            case R.id.E_button:
                text = findViewById(R.id.textViewPress);
                pressed = "Pressed: E";
                text.setText(pressed);
                break;
            case R.id.F_button:
                text = findViewById(R.id.textViewPress);
                pressed = "Pressed: F";
                text.setText(pressed);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", pressed);
    }
}