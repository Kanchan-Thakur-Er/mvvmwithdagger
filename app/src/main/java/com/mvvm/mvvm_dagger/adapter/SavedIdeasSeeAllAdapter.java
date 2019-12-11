package com.mvvm.mvvm_dagger.adapter;

import android.app.Dialog;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.fragments.BusinessProfilePage;
import com.mvvm.mvvm_dagger.fragments.MessageScreen;
import com.mvvm.mvvm_dagger.fragments.SavedIdeasSeeAll;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SavedIdeasSeeAllAdapter extends RecyclerView.Adapter<SavedIdeasSeeAllAdapter.ViewHolder> {
    Context context;
    Fragment savedIdeaFragment;
    View view;

    public SavedIdeasSeeAllAdapter(Context context, SavedIdeasSeeAll fragment) {
        this.context = context;
        this.savedIdeaFragment = fragment;
    }

    @NonNull
    @Override
    public SavedIdeasSeeAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.row_saveideasseeall, viewGroup, false);
        return new SavedIdeasSeeAllAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedIdeasSeeAllAdapter.ViewHolder holder, int position) {

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
        @OnClick(R.id.imgSavedIdea)
        public void imgsavedIdea(){
            final Dialog dialgLogTrack = new Dialog(context);
            //   dialgLogTrack.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialgLogTrack.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialgLogTrack.setCancelable(false);
            dialgLogTrack.setContentView(R.layout.dialogsavedideas);
            TextView tvCancel=dialgLogTrack.findViewById(R.id.tvCancel);
            LinearLayout lnrMessage=dialgLogTrack.findViewById(R.id.lnrMessage);
            LinearLayout lnrEntry=dialgLogTrack.findViewById(R.id.lnrEntry);
            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialgLogTrack.dismiss();
                }
            });
            lnrMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialgLogTrack.dismiss();
                    savedIdeaFragment.getFragmentManager().beginTransaction().replace(R.id.container, new MessageScreen()).addToBackStack("").commit();

                }
            });
            lnrEntry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialgLogTrack.dismiss();
                    savedIdeaFragment.getFragmentManager().beginTransaction().replace(R.id.container, new BusinessProfilePage()).addToBackStack("").commit();

                }
            });
            dialgLogTrack.show();

        }

    }

}
