package com.apocatech.leaderboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ResultRecycleAdapter extends RecyclerView.Adapter<ResultRecycleAdapter.MyViewHolder> {

    Context context;
    private LayoutInflater inflater;

    List<Result> data;

    String tab;

    public ResultRecycleAdapter(Context context, List<Result> data, String tab)
    {
        this.context = context;
        this.data = data;
        this.tab = tab;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = inflater.inflate(R.layout.results_textview, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int i)
    {
        final Result current = data.get(i);
        String imageUrl = current.getBadgeUrl();

        String description = (tab.equals("1")) ? current.getHours()+" learning hours, ": current.getScore()+" skill IQ Score, ";

        Picasso.get().load(imageUrl).into(viewHolder.img_badge);
        viewHolder.txt_name.setText(current.getName());
        viewHolder.txt_desc.setText(description+current.getCountry()+".");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_name, txt_desc;
        ImageView img_badge;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            img_badge = itemView.findViewById(R.id.img_badge);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_desc = itemView.findViewById(R.id.txt_desc);
        }
    }
}
