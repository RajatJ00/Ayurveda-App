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

public class PrakritiActivity extends AppCompatActivity {
    SearchView mySearchView;
    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sl);

        //Declaring Searchbar and and list
        mySearchView = (SearchView)findViewById(R.id.searchView);
        myList = (ListView)findViewById(R.id.myList);

        list = new ArrayList<String>();

        //Adding elements to the list
        list.add("Pitta");
        list.add("Vata");
        list.add("Khapa");

        //Use of array adapter which provides access to the data items in a list.
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);

        //Functionality for Searchbar
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        //Backend for clicking on Almond option and it will send you to the description page.
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(view.getContext(),PittaActivity.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(view.getContext(),VataActivity.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(view.getContext(),KhapaActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}