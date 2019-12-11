package com.mvvm.mvvm_dagger.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.fragments.SaveIdeasFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritedMessagedAdapter extends RecyclerView.Adapter<FavoritedMessagedAdapter.ViewHolder> {
    Context context;

    Fragment savedIdeaFragment;
    View view;

    public FavoritedMessagedAdapter(Context context, SaveIdeasFragment fragment) {
        this.context = context;
        this.savedIdeaFragment = fragment;
    }

    @NonNull
    @Override
    public FavoritedMessagedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.row_favouriteormessaged, viewGroup, false);
        return new FavoritedMessagedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritedMessagedAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
