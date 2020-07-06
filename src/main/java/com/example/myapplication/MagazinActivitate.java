package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MagazinActivitate extends AppCompatActivity {

    private TextView tx1;
    private TextView tx2;
    private TextView tx3;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazin_activitate);

        tx1=(TextView)findViewById(R.id.den);
        tx2=(TextView)findViewById(R.id.descriere);
        tx3=(TextView)findViewById(R.id.categ);
        img=(ImageView)findViewById(R.id.img);


        Intent intent= getIntent();
        String Titlu= intent.getExtras().getString("Titlu");
        String Descriere= intent.getExtras().getString("Descriere");
        String Categorie=intent.getExtras().getString("Categorie");
        int imagine= intent.getExtras().getInt("Thumbnail");


        tx1.setText(Titlu);
        tx2.setText(Descriere);
        img.setImageResource(imagine);
        tx3.setText(Categorie);
    }
}
