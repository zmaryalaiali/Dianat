package com.zmaryalai_ali.dianat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zmaryalai_ali.dianat.our_child_app.Date;
import com.zmaryalai_ali.dianat.our_child_app.Tasbih;
import com.zmaryalai_ali.dianat.our_child_app.Zakate;

public class Home extends Fragment {
Button tasbih,zakate,date;
View rootview;
Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview=inflater.inflate(R.layout.fragment_home, container, false);

        date=rootview.findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(),Date.class);
                startActivity(intent);
            }
        });


        zakate =rootview.findViewById(R.id.zakate);
        zakate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(),Zakate.class);
                startActivity(intent);
            }
        });


tasbih=rootview.findViewById(R.id.tasbih);
tasbih.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context.getApplicationContext(), Tasbih.class);
        startActivity(intent);
    }
});

        return rootview;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
}