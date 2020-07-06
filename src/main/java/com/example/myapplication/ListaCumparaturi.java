package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class ListaCumparaturi extends AppCompatActivity {

    ListView listView;

    ArrayList<String> arrayList;
    EditText editText;
    ArrayAdapter<String> adapter;
    Button btn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cumparaturi);

        listView = (ListView) findViewById(R.id.listaCump);
        arrayList = new ArrayList<>();


        editText = (EditText) findViewById(R.id.edit_add);
        btn = (Button) findViewById(R.id.add_item);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adauga = editText.getText().toString();


                if(arrayList.contains(adauga)){
                    Toast.makeText(getBaseContext(),"S-a adaugat deja!",Toast.LENGTH_LONG).show();
                }
                else if( adauga==null || adauga.trim().equals(""))
                    {
                        Toast.makeText(getBaseContext(),"Nu ai ce adauga!",Toast.LENGTH_LONG).show();
                }
                else{
                    arrayList.add(adauga);
                    adapter= new ArrayAdapter<String>(ListaCumparaturi.this,android.R.layout.simple_list_item_1,arrayList);
                    listView.setAdapter(adapter);
                    ((EditText)findViewById(R.id.edit_add)).setText(" ");
                }


                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "S-a adaugat!", Toast.LENGTH_SHORT).show();


            }
        });


        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemIdAtPosition(position)+ " Este selectat", Toast.LENGTH_SHORT).show();


            }
        });

        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int itm_selectat=position;

                new AlertDialog.Builder(ListaCumparaturi.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Sunteti sigur?")
                        .setMessage("Vreti sa stergeti acest produs din lista?")
                        .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                arrayList.remove(itm_selectat);
                                adapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("Nu",null)
                        .show();


                return true;
            }
        });

    }
}

