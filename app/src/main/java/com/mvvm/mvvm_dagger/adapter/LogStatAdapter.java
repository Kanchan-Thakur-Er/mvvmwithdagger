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

public class LogStatAdapter  extends RecyclerView.Adapter<LogStatAdapter.DataHolder> {
    Fragment fragment;
    Activity mContext;

    public LogStatAdapter( Activity mContext, Fragment fragment) {
        this.mContext = mContext;
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public LogStatAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_logs, parent, false);
        LogStatAdapter.DataHolder dataHolder = new LogStatAdapter.DataHolder(view);
        return dataHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LogStatAdapter.DataHolder holder, int position) {


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