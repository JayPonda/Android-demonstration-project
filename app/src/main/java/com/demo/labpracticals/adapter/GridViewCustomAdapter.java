package com.demo.labpracticals.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.labpracticals.R;
import com.demo.labpracticals.data.Animals;
import com.demo.labpracticals.data.StaticData;

import java.util.Arrays;

public class GridViewCustomAdapter extends BaseAdapter {

    private final Animals[] animalList;

    public GridViewCustomAdapter(Animals[] animals){
        this.animalList = animals;
    }

    public GridViewCustomAdapter(){
        this.animalList = StaticData.getInstance().getAnimalList(5);
        System.out.println(Arrays.toString(this.animalList));
    }


    @Override
    public int getCount() {
        return animalList.length;
    }

    @Override
    public Object getItem(int position) {
        return animalList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Animals animals = animalList[position];
        if(view == null)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout_templete, parent, false);

        ImageView imageView = view.findViewById(R.id.demoImage);
        TextView textView = view.findViewById(R.id.demoText);

        imageView.setImageResource(animals.getImgRes());
        textView.setText(animals.getName());

        return view;
    }
}