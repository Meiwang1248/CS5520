package edu.neu.cs5520.numad21su_shuweiwang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WebService extends AppCompatActivity {
    private static final String TAG ="WebServiceActivity";

    private ListView mainList;
    private EditText mWebDestEditText;
    private Button loader;
    private TextView progressText;
    private ProgressBar progressBar;
    private ArrayList<ListItem> arrayList;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Starting...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);


        mWebDestEditText = (EditText) findViewById(R.id.editText);
        loader = (Button) findViewById(R.id.loadButton);
        mainList = (ListView) findViewById(R.id.listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        progressText = (TextView) findViewById(R.id.textView2);

        arrayList = new ArrayList<ListItem>();
        mainList.setAdapter(new ArrayAdapter<ListItem>(this, android.R.layout.simple_list_item_2,
                android.R.id.text1,
                arrayList) {

            @Override
            public View getView(int pos, View convert, ViewGroup group) {
                View v = super.getView(pos, convert, group);
                TextView t1 = (TextView) v.findViewById(android.R.id.text1);
                TextView t2 = (TextView) v.findViewById(android.R.id.text2);
                t1.setText(getItem(pos).getCountry());
                t2.setText(getItem(pos).getCapital());

                return v;
            }
        });
        initializeData(savedInstanceState);

        loader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callWebserviceButtonHandler(view);
            }
        });
    }

    public void callWebserviceButtonHandler(View view) {
        PingWebServiceTask task = new PingWebServiceTask();
        task.execute(mWebDestEditText.getText().toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        int size = arrayList == null ? 0 : arrayList.size();
        outState.putInt(NUMBER_OF_ITEMS, size);

        // generate unique key for each item
        for (int i = 0; i < size; i++) {
            // put country name into instance
            outState.putString(KEY_OF_INSTANCE + i + "0", arrayList.get(i).getCountry());
            outState.putString(KEY_OF_INSTANCE + i + "1", arrayList.get(i).getCapital());
        }
        super.onSaveInstanceState(outState);

    }

    private void initializeData(Bundle savedInstanceState) {
        // Not the first time to open this Activity
        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            if(arrayList == null || arrayList.size() == 0) {
                int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);

                // Retrieve keys we stored in the instance
                for (int i = 0; i < size; i++) {
                    String country = savedInstanceState.getString(KEY_OF_INSTANCE + i + "0");
                    String capital = savedInstanceState.getString(KEY_OF_INSTANCE + i + "1");
                    arrayList.add(new ListItem(country, capital));
                }
            }
        }
    }



    private class PingWebServiceTask extends AsyncTask<String, ListItem, String> {
        private ArrayAdapter<ListItem> adapter;

        @Override
        protected void onProgressUpdate(ListItem... values) {
            Log.i(TAG, "Making Progress...");
            Log.i(TAG, String.valueOf(Arrays.stream(values).count()));
            adapter.add(values[0]);

        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute: " + Thread.currentThread().getName());
            progressText.setText("Making Progress...");
            progressBar.setVisibility(View.VISIBLE);
            adapter = (ArrayAdapter<ListItem>) mainList.getAdapter();
            adapter.clear();
        }

        @Override
        protected void onPostExecute(String str) {
            // pass the string from doInBackground()
            progressText.setText("Complete!");
            progressBar.setVisibility(View.INVISIBLE);


        }
        @Override
        protected String doInBackground(String... strings) {
            Log.i(TAG, "Entered Country: " + strings[0]);
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                URL url = new URL("https://restcountries.eu/rest/v2/name/" + strings[0]);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setDoInput(true);

                conn.connect();

                //Read response
                InputStream inputStream = conn.getInputStream();
                final String resp = convertStreamToString(inputStream);
                JSONArray jsonArray = new JSONArray(resp);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject;
                    jsonObject = jsonArray.getJSONObject(i);
                    publishProgress(new ListItem(String.valueOf(jsonObject.get("name")),
                            String.valueOf(jsonObject.get("capital"))));

                }
                return null;
            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException");
                e.printStackTrace();;
            } catch (ProtocolException e) {
                Log.e(TAG, "ProtocolException");
            } catch (IOException e) {
                Log.e(TAG, "IOException");
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e(TAG, "JSONException");
                e.printStackTrace();
            }
            return null;
        }

        // Helper function
        private String convertStreamToString(InputStream is) {
            Scanner s = new Scanner(is).useDelimiter("\\A");
            return s.hasNext() ? s.next().replace(",", ",\n") : "";
        }
    }
}