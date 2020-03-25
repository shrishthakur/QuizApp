package com.example.myquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<HomeViewModel> homelist;
    private Context context;
    public class HomeViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tv;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=(ImageView) itemView.findViewById(R.id.iv1);
            tv=(TextView) itemView.findViewById(R.id.tv1);
        }
    }

    public HomeAdapter(Context context,List<HomeViewModel>homelist)

    {
        this.homelist=homelist;
        this.context=context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_layout,parent,false);
        HomeViewHolder homeViewHolder = new HomeViewHolder(itemView);
        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

        HomeViewModel homeViewModel = homelist.get(position);
        holder.iv.setImageResource(homeViewModel.getIv());
        holder.tv.setText(homeViewModel.getTv());
    }

    @Override
    public int getItemCount() {
        return homelist.size();
    }
}
