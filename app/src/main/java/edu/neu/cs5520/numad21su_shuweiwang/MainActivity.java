package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void introduceMyself(View view) {
        TextView textView = findViewById(R.id.myInfo);
        textView.setVisibility(View.VISIBLE);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.A_button:
                Toast.makeText(getApplicationContext(), "Pressed: A ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.B_button:
                Toast.makeText(getApplicationContext(), "Pressed: B ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.C_button:
                Toast.makeText(getApplicationContext(), "Pressed: C ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.D_button:
                Toast.makeText(getApplicationContext(), "Pressed: D ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.E_button:
                Toast.makeText(getApplicationContext(), "Pressed: E ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.F_button:
                Toast.makeText(getApplicationContext(), "Pressed: F ", Toast.LENGTH_SHORT).show();

        }
    }


}