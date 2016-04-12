package com.sage.mydemotest.adapter;

import android.view.View;
import android.widget.TextView;

import com.sage.mydemotest.R;

/**
 * Created by Sage on 2016/4/1.
 */
public class AdapterRVanima extends AdapterVHbase {
    @Override
    public int getLayoutID() {
        return R.layout.item_rv_anima;
    }

    @Override
    public void onBindViewHolder(ChangeViewHolder holder, int position) {
        TextView tvDescription= (TextView) holder.itemView.findViewById(R.id.tv_description);
        tvDescription.setText("position="+position);

        holder.itemView.findViewById(R.id.iv_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.itemView.findViewById(R.id.iv_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
