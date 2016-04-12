package com.sage.mydemotest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sage on 2016/4/1.
 */
public abstract class AdapterVHbase extends RecyclerView.Adapter<AdapterVHbase.ChangeViewHolder>{


    public abstract int getLayoutID();

    @Override
    public ChangeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(getLayoutID(),parent,false);
        return new ChangeViewHolder(view);
    }





    public class ChangeViewHolder extends RecyclerView.ViewHolder{
        public View itemView;
        public ChangeViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
        }
    }
}
