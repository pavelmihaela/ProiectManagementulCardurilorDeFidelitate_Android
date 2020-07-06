package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DateUtilizator extends AppCompatActivity {

    String Nume;
    String Prenume;
    String Email;
    String Numar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_utilizator);


        Nume=getIntent().getExtras().getString("Numele utilizatorului");
        Prenume=getIntent().getExtras().getString("Prenumele");
        Email=getIntent().getExtras().getString("Email");
        Numar= getIntent().getExtras().getString("Numar de telefon");


        TextView txtView=(TextView)findViewById(R.id.txt_Afisare_Date);
        txtView.setText("Nume: " +" "+Nume+'\n'+"Prenume: "+" "+Prenume+'\n'+"Email: "+" "+Email+'\n'+"Numar: "+" "+Numar);


    }
}
