package com.example.ayurveda_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{
    public CardView card1,card2,card3,card4,card5,card6;
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.category);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.category:
                        return true;
                    case R.id.homeinfo:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),AboutActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //Declaration of options provided in gridlayout
        card1=(CardView) findViewById(R.id.food);
        card2=(CardView) findViewById(R.id.disease);
        card3=(CardView) findViewById(R.id.skincare);
        card4=(CardView) findViewById(R.id.yoga);
        card5=(CardView) findViewById(R.id.health);
        card6=(CardView) findViewById(R.id.prakriti);

        //Applying setonclick listener
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        //Different cases provided. Clicking on one option will shift the user to the next assigned activity.
        switch (v.getId()){
            case R.id.food:
                i = new Intent(this,FoodsActivity.class);
                startActivity(i);
                break;

            case R.id.disease:
                i = new Intent(this,DiseasesActivity.class);
                startActivity(i);
                break;

            case R.id.skincare:
                i = new Intent(this,SkinActivity.class);
                startActivity(i);
                break;

            case R.id.yoga:
                i = new Intent(this,YogaActivity.class);
                startActivity(i);
                break;

            case R.id.health:
                i = new Intent(this,HealthActivity.class);
                startActivity(i);
                break;

            case R.id.prakriti:
                i = new Intent(this,PrakritiActivity.class);
                startActivity(i);
                break;
        }
    }
}