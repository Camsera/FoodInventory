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

public class ShelfListViewAdapter extends RecyclerView.Adapter<ShelfListViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Food> mData;
    private int itemIndex;

    public ShelfListViewAdapter(Context mContext, List<Food> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.shelf_item_viewer_layout, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.labelInShelf.setText(mData.get(i).getLabel());
        myViewHolder.brandInShelf.setText(mData.get(i).getBrand());
        myViewHolder.expirationDateInShelf.setText(mData.get(i).getExpirationDate());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView labelInShelf;
        TextView brandInShelf;
        TextView expirationDateInShelf;

        public MyViewHolder(View itemView) {
            super(itemView);

            labelInShelf = itemView.findViewById(R.id.labelInShelf);
            brandInShelf = itemView.findViewById(R.id.brandInShelf);
            expirationDateInShelf = itemView.findViewById(R.id.expirationDateInShelf);

        }
    }

}
