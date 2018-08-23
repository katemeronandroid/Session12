package com.emarkova.session12cp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter {
    //private String[] mDataName = {"abc", "cba", "asdf", "sDA", "ASDFSADF", "Ssfsd", "asdfsf", "sasdf", "asdfsad"};
    //private String[] mDataDate = {"abc", "cba", "asdf", "sDA", "ASDFSADF", "Ssfsd", "asdfsf", "sasdf", "asdfsad"};
    private ArrayList<String> mDataName;
    private ArrayList<String> mDataDate;

    MyAdapter(ArrayList names, ArrayList dates){
        mDataName = names;
        mDataDate = dates;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("Logs", "create" + String.valueOf(i));
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Log.d("Logs", String.valueOf(position));
        ((MyViewHolder) viewHolder).mTextView.setText(mDataName.get(position));
        ((MyViewHolder) viewHolder).mTextDate.setText(mDataDate.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataName.size();
    }

    public interface OnUserClickListener {
        void onUserClick();
    }

}
