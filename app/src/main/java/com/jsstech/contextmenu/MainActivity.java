package com.jsstech.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String [] item={"item1","item2","item3","item4"};
    ArrayAdapter adapter;


    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        super.onCreateContextMenu(menu,v,menuInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list_v);

        adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,item);
        list.setAdapter(adapter);
        registerForContextMenu(list);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.call:
                Toast.makeText(MainActivity.this,"call",Toast.LENGTH_LONG).show();
                break;

            case R.id.chat:
                Toast.makeText(MainActivity.this,"chat",Toast.LENGTH_LONG).show();

                break;

            case R.id.email:
                Toast.makeText(MainActivity.this,"email",Toast.LENGTH_LONG).show();

                break;


        }


        return super.onContextItemSelected(item);
    }
}