package com.example.jiaming.dataretrive;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    ImageView imageView;
    private List<Reponse> list;

    public CustomAdapter(List<Reponse> list){
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.each_row, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.textView.setText(list.get(i).getID()+"");
        viewHolder.textView2.setText(list.get(i).getTitle());
        Glide.with(viewHolder.itemView)
                .load(list.get(i).getUrl())
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
