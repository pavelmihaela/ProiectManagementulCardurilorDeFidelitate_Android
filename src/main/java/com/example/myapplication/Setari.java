package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Setari extends AppCompatActivity {

    private CheckBox c1,c2,c3;
    private Button btn;
    private TextView mResult;
    private ArrayList<String>  arrayList;
    private Spinner numeOrase;
    private String[] orase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari);


        c1=(CheckBox)findViewById(R.id.ch_1);
        c2=(CheckBox)findViewById(R.id.ch_2);
        c3=(CheckBox)findViewById(R.id.ch_3);

        btn=(Button)findViewById(R.id.rezultat);
        mResult=(TextView)findViewById(R.id.afisare_rez);

        arrayList= new ArrayList<>();
        mResult.setEnabled(false);


        numeOrase=(Spinner)findViewById(R.id.my_spnr);
        orase= getResources().getStringArray(R.array.NumeOrase);
        ArrayAdapter adapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item,orase);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numeOrase.setAdapter(adapter);



        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked())
                    arrayList.add("Da,doar detalii despre contul meu");
                else
                    arrayList.remove("Da, doar detalii despre contul meu");
            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c2.isChecked())
                    arrayList.add("Da,atat despre contul meu cat si despre cele mai recente oferte");
                else
                    arrayList.remove("Da,atat despre contul meu cat si despre cele mai recente oferte");
            }
        });


        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c3.isChecked())
                    arrayList.add("Nu,multumesc");
                else
                    arrayList.remove("Nu,multumesc");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder stringBuilder= new StringBuilder();
                for(String s : arrayList)
                    stringBuilder.append(s).append("\n");
                mResult.setText(stringBuilder.toString());
                mResult.setEnabled(false);
            }
        });


    }
}
