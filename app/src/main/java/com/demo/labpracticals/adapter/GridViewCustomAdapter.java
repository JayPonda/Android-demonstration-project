package com.demo.labpracticals.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.labpracticals.R;
import com.demo.labpracticals.data.Animals;
import com.demo.labpracticals.data.StaticData;

import java.util.Arrays;

public class GridViewCustomAdapter extends RecyclerView.Adapter<GridViewCustomAdapter.GridHolder> {

    private final Animals[] animalList;

    public GridViewCustomAdapter(Animals[] animals){
        this.animalList = animals;
    }

    public GridViewCustomAdapter(){
        this.animalList = StaticData.getInstance().getAnimalList(5);
        System.out.println(Arrays.toString(this.animalList));
    }



    @NonNull
    @Override
    public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_layout_templete, parent, false);

        return new GridHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridHolder holder, int position) {
        holder.getImageView().setImageResource(animalList[position].getImgRes());
        holder.getTextView().setText(animalList[position].getName());
    }

    @Override
    public int getItemCount() {
        return animalList.length;
    }

    public static class GridHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public TextView getTextView() {
            return textView;
        }

        private final TextView textView;

        public GridHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.demoImage);
            textView = view.findViewById(R.id.demoText);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }
}