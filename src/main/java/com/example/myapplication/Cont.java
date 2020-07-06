package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Cont extends AppCompatActivity {

    private TextInputLayout textInputNume;
    private TextInputLayout textInputPrenume;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputParola;
    private TextInputLayout textInputTelefon;
    private Button btnDetaliiCont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont);
        getSupportActionBar().setTitle("Conectare");


        textInputNume=findViewById(R.id.text_input_nume);
        textInputPrenume=findViewById(R.id.text_input_prenume);
        textInputEmail=findViewById(R.id.text_input_email);
        textInputParola=findViewById(R.id.text_input_parola);
        textInputTelefon=findViewById(R.id.text_input_telefon);
        btnDetaliiCont=(Button)findViewById(R.id.btn_vezi_detalii_cont);
        btnDetaliiCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nume= textInputNume.getEditText().getText().toString();
                String prenume= textInputPrenume.getEditText().getText().toString();
                String email= textInputEmail.getEditText().getText().toString();
                String numarTelefon= textInputTelefon.getEditText().getText().toString();

                Intent intent= new Intent(Cont.this, DateUtilizator.class);
                intent.putExtra("Numele utilizatorului",nume);
                intent.putExtra("Prenumele",prenume);
                intent.putExtra("Email",email);
                intent.putExtra("Numar de telefon",numarTelefon);
                startActivity(intent);



            }
        });

    }


    private boolean validareNume() {

        String nume = textInputNume.getEditText().getText().toString().trim();

        if (nume.isEmpty()) {
            textInputNume.setError(" Acest camp trebuie completat!");
            return false;
        } else if (nume.length() > 20) {
            textInputNume.setError("Numele este prea lung!");
        } else

            textInputNume.setError(null);
            return true;

    }

    private boolean validarePrenume() {

        String prenume = textInputPrenume.getEditText().getText().toString().trim();

        if (prenume.isEmpty()) {
            textInputNume.setError(" Acest camp trebuie completat!");
            return false;

        } else {
            textInputNume.setError(null);
            return true;
        }
    }




    private boolean validareEmail() {

        String emailInput= textInputEmail.getEditText().getText().toString().trim();

        if(emailInput.isEmpty()) {
            textInputEmail.setError("Acest camp trebuie completat!");
            return false;
        }
        else{
            textInputEmail.setError(null);

            return true;
        }
    }

    private boolean validareParola() {

        String parolaInput = textInputParola.getEditText().getText().toString().trim();

        if(parolaInput.isEmpty()) {
            textInputEmail.setError("Acest camp trebuie completat!");
            return false;
        }
        else{
            textInputEmail.setError(null);

            return true;
        }
    }




    public void inregistrare(View view) {

        if(!validareNume() | !validarePrenume() | !validareEmail() |!validareParola()) {
            return;
        }

        String input= "Nume: " + textInputNume.getEditText().getText().toString();
        input +="\n";
        input +="Prenume: " +textInputPrenume.getEditText().getText().toString();
        input +="\n";

        input+="Email: "+ textInputEmail.getEditText().getText().toString();
        input+="\n";
        input+="Parola: "+textInputParola.getEditText().getText().toString();
        input+="\n";
        input+="Numar de telefon: "+textInputTelefon.getEditText().getText().toString();

        Toast.makeText(this,input,Toast.LENGTH_SHORT).show();

    }
}
