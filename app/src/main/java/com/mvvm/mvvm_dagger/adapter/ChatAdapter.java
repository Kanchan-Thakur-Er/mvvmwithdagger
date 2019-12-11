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

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.DataHolder> {
    private static final int HEADER = 0;
    private static final int MESSAGES = 1;
    private static final int DEFAULT = 10;

    Fragment fragment;
    Activity mContext;

    public ChatAdapter(Activity mContext, Fragment fragment) {
        this.mContext = mContext;
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public ChatAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_message_chat, parent, false);
        ChatAdapter.DataHolder dataHolder = new ChatAdapter.DataHolder(view);
        return dataHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.DataHolder holder, int position) {


    }

    @Override
    public int getItemViewType(int position) {
        return DEFAULT;
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public class DataHolder extends RecyclerView.ViewHolder {


        public DataHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
