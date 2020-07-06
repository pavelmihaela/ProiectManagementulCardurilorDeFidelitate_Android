package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class Carduri extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    private TextInputLayout nume;
    private TextInputLayout nr;

    private Button btn;
    private Switch switch1;
    private TextView txt;
    private ListView listView;
    private ArrayList<String> list;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carduri);
        getSupportActionBar().setTitle("Adauga card");


        listView=(ListView)findViewById(R.id.lista_carduri);
        nume=(TextInputLayout)findViewById(R.id.text_input_nume);
        nr=(TextInputLayout)findViewById(R.id.text_input_nrCard);

        btn=(Button)findViewById(R.id.btn_adauga);

        list= new ArrayList<String>();
        arrayAdapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,list);

        txt=(TextView)findViewById(R.id.txt1);
        switch1=(Switch)findViewById(R.id.sw);

        switch1.setOnCheckedChangeListener(this);
    }

    public void Adauga(View view) {

        String Nume= nume.getEditText().getText().toString();
        String Numar= nr.getEditText().getText().toString();


        list.add(Nume);
        list.add(Numar);

        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();


    }



    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(switch1.isChecked()){
            txt.setText("Da");
        }
        else{
            txt.setText("Nu");
        }
    }


}
