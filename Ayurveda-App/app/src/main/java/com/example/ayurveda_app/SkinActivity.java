package com.example.ayurveda_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SkinActivity extends AppCompatActivity {
    SearchView mySearchView2;
    ListView myList2;

    ArrayList<String> list1;
    ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sl);

        //Declaring Searchbar and and list
        mySearchView2 = (SearchView)findViewById(R.id.searchView);
        myList2 = (ListView)findViewById(R.id.myList);

        list1 = new ArrayList<String>();

        //Adding elements to the list
        list1.add("Dark Circle");
        list1.add("Acne");
        list1.add("Tanning");
        list1.add("Pigmentation");

        //Use of array adapter which provides access to the data items in a list.
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list1);
        myList2.setAdapter(adapter1);

        //Functionality for Searchbar
        mySearchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter1.getFilter().filter(s);
                return false;
            }
        });

        //Backend for clicking on Almond option and it will send you to the description page.
        myList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(view.getContext(),DarkCircleActivity.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(view.getContext(),AcneActivity.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(view.getContext(),TanningActivity.class);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent(view.getContext(),PigmentationActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}