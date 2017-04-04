package com.example.arvind.basicproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout r = (RelativeLayout) findViewById(R.id.layout);
        r.setBackgroundColor(Color.parseColor("#006699"));
        DBHandler dbh = new DBHandler(this, null, null, 1);
        final ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<String> arrayList = dbh.displayData();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        if (!arrayList.isEmpty()) {
            arrayAdapter.addAll(arrayList);
            listView.setAdapter(arrayAdapter);
        }


        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, Details.class);
                        startActivity(i);
                        finish();
                    }
                }
        );

        Button login = (Button) findViewById(R.id.button3);
        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText t = (EditText) findViewById(R.id.editText2);
                        String s = t.getText().toString();
                        DBHandler dbh = new DBHandler(MainActivity.this, null, null, 1);
                        if(dbh.checker(s)==true) {
                            Toast.makeText(MainActivity.this, "Login Complete", Toast.LENGTH_LONG).show();
                            listView.setVisibility(View.VISIBLE);
                            r.setBackgroundColor(Color.GREEN);

                        }
                        else if(dbh.checker(s)==false) {
                            listView.setVisibility(View.INVISIBLE);
                            Toast.makeText(MainActivity.this, "Please click ADD", Toast.LENGTH_LONG).show();
                            r.setBackgroundColor(Color.RED);

                        }

                    }
                }
        );

    }
}
