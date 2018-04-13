package com.example.leesnriud.kaiyan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mData;

    public MyAdapter(List<String> data) {
        super();
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null);

        ViewHolder holder = new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.mTextView.setText(mData.get(i));

    }

    @Override
    public int getItemCount() {

        return mData.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View itemView) {

            super(itemView);

            mTextView = (TextView) itemView;

        }

    }

}



