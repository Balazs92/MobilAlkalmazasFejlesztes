package com.example.myrecyclerviewcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private Integer[] imageArray;
    private String[] nameArray;
    private String[] infoArray;

    public CustomAdapter(Context context, String[] names, String[] infos, Integer[] images) {
        this.context = context;
        this.nameArray = names;
        this.infoArray = infos;
        this.imageArray = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(nameArray[position]);
        holder.info.setText(infoArray[position]);
        holder.image.setImageResource(imageArray[position]);
    }

    @Override
    public int getItemCount() {
        return nameArray.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, info;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            info = itemView.findViewById(R.id.info);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}