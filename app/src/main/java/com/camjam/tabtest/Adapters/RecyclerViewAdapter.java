package com.camjam.tabtest.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.camjam.tabtest.Food;
import com.camjam.tabtest.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Food> mData;
    private OnNoteListener mOnNoteListener;
    private int itemIndex;

    public RecyclerViewAdapter(Context mContext, List<Food> mData, OnNoteListener onNoteListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.food_item_viewer_layout, viewGroup, false);

        return new MyViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.labelView.setText(mData.get(i).getLabel());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView labelView;
        OnNoteListener onNoteListener;
        private int itemIndex;

        public MyViewHolder(View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            labelView = itemView.findViewById(R.id.label_view);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
            labelView.setBackgroundColor(Color.parseColor("#d3d3d3"));
        }

    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
