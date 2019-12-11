package com.mvvm.mvvm_dagger.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public class EmojisAdapter extends RecyclerView.Adapter<EmojisAdapter.DataHolder> {
    Fragment fragment;
    Activity mContext;

    public EmojisAdapter( Activity mContext, Fragment fragment) {
        this.mContext = mContext;
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public EmojisAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_emogis, parent, false);
        EmojisAdapter.DataHolder dataHolder = new EmojisAdapter.DataHolder(view);
        return dataHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmojisAdapter.DataHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 12;
    }


    public class DataHolder extends RecyclerView.ViewHolder {
        public DataHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
