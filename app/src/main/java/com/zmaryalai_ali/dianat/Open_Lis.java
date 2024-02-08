package com.zmaryalai_ali.dianat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class Open_Lis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_lis);

        Intent i=getIntent();
        String j=  i.getStringExtra("main");
        TextView tv=findViewById(R.id.tv);
//        Toolbar toolbar=findViewById(R.id.toolbar1);
//        setSupportActionBar(toolbar);
        tv.setText(j);
    }


    public void finish_our(View view){
        finish();
    }

}