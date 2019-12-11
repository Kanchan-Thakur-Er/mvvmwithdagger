package com.mvvm.mvvm_dagger.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.fragments.AddLogDate;
import com.mvvm.mvvm_dagger.fragments.DateDiaryEntry;
import com.mvvm.mvvm_dagger.fragments.DateDiaryFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DateDiaryAdapter extends RecyclerView.Adapter<DateDiaryAdapter.ViewHolder> {
    Context context;
    Fragment fragment;
    View view;

    public DateDiaryAdapter(Context context, DateDiaryFragment fragment) {
        this.context = context;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.row_datediary, viewGroup, false);
        return new DateDiaryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @OnClick(R.id.imgBusiness)
        public void imgBusiness(){
            fragment.getFragmentManager().beginTransaction().replace(R.id.container, new DateDiaryEntry()).addToBackStack("").commit();

        }
        @OnClick(R.id.tvBusinessName)
        public void tvBusinessName(){
            fragment.getFragmentManager().beginTransaction().replace(R.id.container, new DateDiaryEntry()).addToBackStack("").commit();

        }
        @OnClick(R.id.tvDate)
        public void tvDate(){
            fragment.getFragmentManager().beginTransaction().replace(R.id.container, new DateDiaryEntry()).addToBackStack("").commit();

        }
        @OnClick(R.id.tvLogDate)
        public void tvLogDate(){
            fragment.getFragmentManager().beginTransaction().replace(R.id.container, new AddLogDate()).addToBackStack("").commit();

        }
    }
}
