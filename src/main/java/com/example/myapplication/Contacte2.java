package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class Contacte2 extends AppCompatActivity {

    private String[] emails={ "altex@yahooc.com", "office@kaufland.ro","contact@auchan.ro", "info@lidl.ro", "relatii.clienti@dm-markt.ro",
            "contact@mediaGalaxi.ro","office@noriel.com","contact@profi.com","contact@selgros.ro","office@sephora.com","contact@teilor.com","office@cora.ro"
    ,"contact@teka.ro"};


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacte2);

        listView=(ListView)findViewById(R.id.list);

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
                ,new ArrayList<String>()));


        new MyTask().execute();
    }

    class  MyTask extends AsyncTask<Void,String,String> {


        ArrayAdapter<String> adapter;
        ProgressBar progressBar;
        int count;


        @Override
        protected void onPreExecute() {
           adapter= (ArrayAdapter<String>)listView.getAdapter();
           progressBar=(ProgressBar)findViewById(R.id.progress_bar);
           progressBar.setMax(15);
           progressBar.setProgress(0);
           progressBar.setVisibility(View.VISIBLE);
           count=0;
        }

        @Override
        protected String doInBackground(Void... voids) {

            for(String Email: emails) {

                publishProgress(Email);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Toate datele au fost adauagate cu succes!";
        }


        @Override
        protected void onProgressUpdate(String... values) {

            adapter.add(values[0]);
            count++;
            progressBar.setProgress(count);

        }

        @Override
        protected void onPostExecute(String s) {

            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
        }
    }
}
