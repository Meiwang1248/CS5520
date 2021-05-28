package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.A_button:
                Toast toast = Toast.makeText(getApplicationContext(), "Pressed: A ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -350);
                toast.show();
                break;
            case R.id.B_button:
                toast = Toast.makeText(getApplicationContext(), "Pressed: B ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -350);
                toast.show();
                break;
            case R.id.C_button:
                toast = Toast.makeText(getApplicationContext(), "Pressed: C ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -350);
                toast.show();
                break;
            case R.id.D_button:
                toast = Toast.makeText(getApplicationContext(), "Pressed: D ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -350);
                toast.show();
                break;
            case R.id.E_button:
                toast = Toast.makeText(getApplicationContext(), "Pressed: E ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -350);
                toast.show();
                break;
            case R.id.F_button:
                toast = Toast.makeText(getApplicationContext(), "Pressed: F ", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -350);
                toast.show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}