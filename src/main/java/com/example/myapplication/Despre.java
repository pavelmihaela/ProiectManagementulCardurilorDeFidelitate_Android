package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Despre extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despre);

        final RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        Button btnRating=(Button)findViewById(R.id.btn_rating);
        final TextView ratingDisplay=(TextView) findViewById(R.id.tx_rating);

        btn=(Button)findViewById(R.id.btn_despre);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingDisplay.setText("Ratingul este: " + ratingBar.getRating());

            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float r, boolean b) {

                int rating=(int) r;
                String message=null;


                switch (rating) {

                    case 1:
                        message="Imi pare rau sa aud asta..";
                    break;

                    case 2:
                        message=" Sugestii sunt acceptate mereu!" ;
                    break;

                    case 3:
                        message=" Destul de bine!";
                        break;

                    case 4:
                        message=" Super! Multumesc!";
                        break;

                    case 5:
                        message=" Foarte tare! Multumesc!";
                        break;
                }

                Toast.makeText(Despre.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void openActivity2() {

        Intent intent= new Intent(this, Descriere.class) ;
        startActivity(intent);


    }


}
