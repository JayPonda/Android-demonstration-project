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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RvHolder> {

    private final Animals[] list;

    public RecyclerViewAdapter(Animals[] animals){
        this.list = animals;
    }

    @NonNull
    @Override
    public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_detailed_layout_templete, parent, false);
        return new RvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHolder holder, int position) {
        Animals animals = list[position];
        holder.getImageView().setImageResource(animals.getImgRes());
        holder.getTextViewForName().setText(animals.getName());
        holder.getTextViewForDescription().setText(animals.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public static class RvHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textViewForName;
        private final TextView textViewForDescription;

        public RvHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.rvImage);
            textViewForName = view.findViewById(R.id.rvTitle);
            textViewForDescription = view.findViewById(R.id.rvDescription);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextViewForName() {
            return textViewForName;
        }

        public TextView getTextViewForDescription() {
            return textViewForDescription;
        }
    }
}
