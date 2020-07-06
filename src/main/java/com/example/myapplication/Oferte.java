package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Oferte extends AppCompatActivity {

    ListView listView;
    String[] denumire={"ALTEX","AUCHAN","BILLA", "CARREFOUR","CORA","DECATHLON","DM","DOUGLAS","FLANCO"
            ,"INTERSPORT","KAUFLAND","MEGAIMAGE","METRO","NIKE","PENNY","PROFI","SELGROS"};
    int[] img={ R.drawable.altex, R.drawable.auchan, R.drawable.billa, R.drawable.carrefour, R.drawable.cora,
    R.drawable.decathlon, R.drawable.dm, R.drawable.douglas, R.drawable.flanco,R.drawable.intersport,
    R.drawable.kaufland, R.drawable.megaimage, R.drawable.metro,R.drawable.nike, R.drawable.penny,
    R.drawable.profi, R.drawable.selgros};
    String[] descriere={ "Top electrocasnice", "Preturi mici!","Diversitate garantata!","Calitate superioara",
            "Gasesti orice doresti!", "Am dat startul ofertelor de Craciun!", "Produse de ingrijire,calitate net superioara",
   "Avem noi beauty adviseri","Televizor ultraHd redus!", "Brand-ul nike vine cu reduceri considerabile","Cele mai proaspete alimente",
     "Noi reduceri","Gasesti tot ce-ti doresti!"," Lansam colectia de iarna!","Alimentatia ta conteaza pentru noi",
    " Ai tot ce vrei!", "Dam start reducerilor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oferte);
        getSupportActionBar().setTitle("Oferte de actualitate");

        listView= findViewById(R.id.listView_oferte);


        AdaptorPersonalizat adaptorPersonalizat= new AdaptorPersonalizat();
        listView.setAdapter(adaptorPersonalizat);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0) {
                    Toast.makeText(Oferte.this, "Reduceri de 25% la toate articolele!",Toast.LENGTH_SHORT).show();
                }

                if(position==1) {
                    Toast.makeText(Oferte.this, "Transforma fiecare masa intr-o poveste cu zahar la doar 2,49 lei!",Toast.LENGTH_SHORT).show();
                }

                if(position==2) {
                    Toast.makeText(Oferte.this, "Cafeaua, un adevarat ritual, savureaza-o la un pret special de 1,49 lei!",Toast.LENGTH_LONG).show();
                }

                if(position==3) {
                    Toast.makeText(Oferte.this, "La cumparaturi de 150 de lei primesti discount 15%!",Toast.LENGTH_SHORT).show();
                }


                if(position==4) {
                    Toast.makeText(Oferte.this, "Nu sunt oferte disponibile momentan",Toast.LENGTH_SHORT).show();
                }

                if(position==5) {
                    Toast.makeText(Oferte.this, "10% la orice produs,oferta valabila toata luna decembrie!",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }


    private class AdaptorPersonalizat  extends BaseAdapter {
        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View view1= getLayoutInflater().inflate(R.layout.oferte2,null);
            TextView den= view1.findViewById(R.id.nume);
            TextView descr=view1.findViewById(R.id.desc);
            ImageView imgg= view1.findViewById(R.id.image1);

            descr.setText(descriere[i]);
            den.setText(denumire[i]);
            imgg.setImageResource(img[i]);

            return view1;
        }
    }


}
