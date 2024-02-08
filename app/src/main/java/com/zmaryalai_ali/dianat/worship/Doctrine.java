package com.zmaryalai_ali.dianat.worship;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.zmaryalai_ali.dianat.Adapter;
import com.zmaryalai_ali.dianat.Open_Lis;
import com.zmaryalai_ali.dianat.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctrine extends Fragment {
    ExpandableListView expandableListView;
    Context context;
    Map<String, List<String>> group;
    List<String> child;
    ExpandableListAdapter expandableListAdapter;
    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_doctrine, container, false);
        expandableListView = rootview.findViewById(R.id.expandable);
        setlist();
        Adapter adapter = new Adapter(context, group, child);
        expandableListAdapter=adapter;
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                Toast.makeText(context, "the menu is close", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent intent=new Intent(context, Open_Lis.class);
                intent.putExtra("main",group.get(child.get(i)).get(i1));
                startActivity(intent);
                return true;
            }
        });

        return rootview;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void setlist() {
        child=new ArrayList();
        group=new HashMap<>();
        child.add("java");
        child.add("C++");
        ArrayList<String> java=new ArrayList<>();
        java.add("oop");
        java.add("Inheraitance");
        java.add("aaaaaaaaaaa");
        ArrayList c=new ArrayList();
        c.add("C++");
        c.add("classes");
        c.add("COnstracture");
        group.put("java",java);
        group.put("C++",c);
    }
}