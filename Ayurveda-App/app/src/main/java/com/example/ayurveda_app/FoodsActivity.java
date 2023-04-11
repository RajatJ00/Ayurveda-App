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


public class FoodsActivity extends AppCompatActivity {
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
        list.add("Amla");
        list.add("Neem");
        list.add("Harda");
        list.add("Ginger");
        list.add("Garlic");
        list.add("Turmeric");
        list.add("Coriander");
        list.add("Black pepper");
        list.add("Cinnamon");

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
                    Intent intent = new Intent(view.getContext(),AmlaActivity.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(view.getContext(),NeemActivity.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(view.getContext(),HaradActivity.class);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent(view.getContext(),GingerActivity.class);
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent = new Intent(view.getContext(),GarlicActivity.class);
                    startActivity(intent);
                }
                if(position==5){
                    Intent intent = new Intent(view.getContext(),TurmericActivity.class);
                    startActivity(intent);
                }
                if(position==6){
                    Intent intent = new Intent(view.getContext(),CorianderActivity.class);
                    startActivity(intent);
                }
                if(position==7){
                    Intent intent = new Intent(view.getContext(),BlackPepperActivity.class);
                    startActivity(intent);
                }
                if(position==8){
                    Intent intent = new Intent(view.getContext(),CinnamonActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
