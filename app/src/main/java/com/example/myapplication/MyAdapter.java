package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Post> mData;

    public MyAdapter(Context context, ArrayList<Post> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater
                .from(mContext)
                .inflate(R.layout.cell_post, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.firstStartTime = view.findViewById(R.id.firstStartTime);
        holder.firstEndTime = view.findViewById(R.id.firstEndTime);
        holder.temperature = view.findViewById(R.id.temperature);
        holder.secondStartTime = view.findViewById(R.id.secondStartTime);
        holder.secondEndTime = view.findViewById(R.id.secondEndTime);
        holder.temperature2 = view.findViewById(R.id.temperature2);
        holder.thirdStartTime = view.findViewById(R.id.thirdStartTime);
        holder.thirdEndTime = view.findViewById(R.id.thirdEndTime);
        holder.temperature3 = view.findViewById(R.id.temperature3);
        holder.firstLinear = view.findViewById(R.id.firstLinear);
        holder.secondLinear = view.findViewById(R.id.secondLinear);
        holder.thirdLinear = view.findViewById(R.id.thirdLinear);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post post = mData.get(position);
        holder.firstStartTime.setText(post.firstStartTime);
        holder.firstEndTime.setText(post.firstEndTime);
        holder.temperature.setText(post.temperature);
        holder.secondStartTime.setText(post.secondStartTime);
        holder.secondEndTime.setText(post.secondEndTime);
        holder.temperature2.setText(post.temperature2);
        holder.thirdStartTime.setText(post.thirdStartTime);
        holder.thirdEndTime.setText(post.thirdEndTime);
        holder.temperature3.setText(post.temperature3);


        holder.firstLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondLayout.class);
                Bundle bundle = new Bundle();
                bundle.putString("startTime", post.firstStartTime);
                bundle.putString("endTime", post.firstEndTime);
                bundle.putString("temperature", post.temperature);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
        holder.secondLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondLayout.class);
                Bundle bundle = new Bundle();
                bundle.putString("startTime", post.secondStartTime);
                bundle.putString("endTime", post.secondEndTime);
                bundle.putString("temperature", post.temperature2);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
        holder.thirdLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondLayout.class);
                Bundle bundle = new Bundle();
                bundle.putString("startTime", post.thirdStartTime);
                bundle.putString("endTime", post.thirdEndTime);
                bundle.putString("temperature", post.temperature3);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public TextView firstStartTime;
        public TextView firstEndTime;
        public TextView temperature;
        public TextView secondStartTime;
        public TextView secondEndTime;
        public TextView temperature2;
        public TextView thirdStartTime;
        public TextView thirdEndTime;
        public TextView temperature3;
        public LinearLayout firstLinear;
        public LinearLayout secondLinear;
        public LinearLayout thirdLinear;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}