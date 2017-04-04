package com.example.arvind.basicproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final EditText e = (EditText)findViewById(R.id.editText);
        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DBHandler dbh = new DBHandler(Details.this, null, null,1);
                        dbh.addData(e.getText().toString());

                        Intent i = new Intent(Details.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
        );
    }
}
