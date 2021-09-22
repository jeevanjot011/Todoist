package com.example.todoist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et=findViewById(R.id.txt);
        Button btn = findViewById(R.id.button);
        ListView lv= findViewById(R.id.l1);
        ArrayList items =new ArrayList();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemText=et.getText().toString();
                if (!(itemText.equals("")))
                {
                    items.add(itemText);
                    et.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter text",Toast.LENGTH_SHORT).show();
                }
            }
        });
                ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,items);
                lv.setAdapter(arrayAdapter);
                lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(),"Item Removed",Toast.LENGTH_SHORT).show();
                        items.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                        return false;

            }
        });
    }
}