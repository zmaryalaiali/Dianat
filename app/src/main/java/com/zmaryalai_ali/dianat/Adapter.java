package com.zmaryalai_ali.dianat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class Adapter extends BaseExpandableListAdapter {
    Context context;
    Map<String, List<String>> group;
    List<String> child;

    public Adapter(Context context, Map<String,List<String>> group, List child) {
        this.context = context;
        this.group = group;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return child.size();
    }


    @Override
    public int getChildrenCount(int i) {
        return group.get(child.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return child.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return group.get(child.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String group_title= (String) getGroup(i);
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.parent,null);
        }
        TextView tvgroup=view.findViewById(R.id.group);
        tvgroup.setText(group_title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        String child_title= (String) getChild(i,i1);
        if (view==null){
            view=LayoutInflater.from(context).inflate(R.layout.child,null);
        }
        TextView tvchild=view.findViewById(R.id.child);
        tvchild.setText(child_title);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
