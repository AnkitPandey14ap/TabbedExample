package com.example.krishnapandey.tabbedexample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by krishna pandey on 22-07-2017.
 */

class MyCustomAdapter extends BaseAdapter implements ListAdapter{

    private final Context context;
    private final ArrayList<String> list;
    private final ArrayList<String> iconList;


    public MyCustomAdapter(Context context, ArrayList<String> list,ArrayList<String> iconList) {

        this.context = context;
        this.list = list;

        this.iconList = iconList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_topic_view, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.textView);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        textView.setText(list.get(position));
        imageView.setImageResource(Integer.parseInt(iconList.get(position)));



        return view;
    }
}
