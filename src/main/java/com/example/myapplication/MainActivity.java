package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionB;
    private NavigationView navigationView;
    private Button btnJson;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mActionB = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mActionB);
        mActionB.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView=(NavigationView)findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);

        btnJson= findViewById(R.id.btn_json);
        btnJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),VeziDateContact.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {


        if(mActionB.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected( MenuItem menuItem) {

        int id=menuItem.getItemId();

        if(id==R.id.cont){

            Intent intent= new Intent(MainActivity.this, Cont.class);
            startActivity(intent);

            return true;
        }
        else if(id==R.id.carduri) {

            Intent intent= new Intent(MainActivity.this, Carduri.class);
            startActivity(intent);
            return true;
        }
        else if( id==R.id.oferte) {
            Intent intent= new Intent(MainActivity.this, Oferte.class);
            startActivity(intent);
            return true;
        }
        else if( id== R.id.lista) {
            Intent intent= new Intent(MainActivity.this, ListaCumparaturi.class);
            startActivity(intent);
            return true;
        }
        else if( id==R.id.despre) {

            Intent intent= new Intent(MainActivity.this, Despre.class);
            startActivity(intent);
            return true;
        }
        else if( id==R.id.setari) {
            Intent intent= new Intent(MainActivity.this, Setari.class);
            startActivity(intent);
            return  true;
        }


        return false;
    }


    public void Vezi(View view) {

        Intent intent= new Intent(MainActivity.this,TopCarduri.class);
        startActivity(intent);
    }

    public void vezi_date_contact(View view) {

        Intent intent=new Intent(getApplicationContext(),VeziDateContact.class );
        startActivity(intent);

    }



}



