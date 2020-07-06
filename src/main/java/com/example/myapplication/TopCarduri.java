package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TopCarduri extends AppCompatActivity {

    List<Magazin> lstMagazin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_carduri);


        lstMagazin= new ArrayList<>();
        lstMagazin.add(new Magazin("Catena","Produse farmaceutice"," Cel mai bun pret de pe piata!"
                ,R.drawable.catena));
        lstMagazin.add(new Magazin("Emag","Diverse categorii"," Reducerile acordate au fost colosale!"
                ,R.drawable.emag));
        lstMagazin.add(new Magazin("Penny","Produse alimentare"," Ieftin si bun"
                ,R.drawable.penny2));
        lstMagazin.add(new Magazin("Rompetrol","Combustibil"," Motorina la super pret!"
                ,R.drawable.rompetrol));
        lstMagazin.add(new Magazin("Sephora","Produse cosmetice"," Ruj Dior la doar 55 de lei!"
                ,R.drawable.sephora));
        lstMagazin.add(new Magazin("Altex","Electrocasnice","Cel mai mic pret din Romania!"
                ,R.drawable.altex));
        lstMagazin.add(new Magazin("Cinema City","Divertisment","Un super voucher la filemele 3D"
                ,R.drawable.cinema));




        RecyclerView myrv= (RecyclerView)findViewById(R.id.recyclerview_id);

        RecyclerViewAdapter myAdapter= new RecyclerViewAdapter(this,lstMagazin);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
