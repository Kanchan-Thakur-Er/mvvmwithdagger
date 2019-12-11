package com.mvvm.mvvm_dagger.fragments;


import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ember.ember.R;
import com.mvvm.mvvm_dagger.adapter.ChatAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageScreen extends Fragment {
    private View rootView;
    @BindView(R.id.rvChat)
    RecyclerView rvChat;
    @BindView(R.id.etMsgSend)
    EditText etMsgSend;
    private ChatAdapter chatAdapter;

    public MessageScreen() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_message_screen, container, false);
        ButterKnife.bind(this, rootView);
        init();

        etMsgSend.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (etMsgSend.getRight() - etMsgSend.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Toast.makeText(getActivity(), "Msg Sent", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
                return false;
            }
        });
        return rootView;
    }

    private void init() {
        rvChat.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        chatAdapter = new ChatAdapter(getActivity(), MessageScreen.this);
        rvChat.setAdapter(chatAdapter);
    }

    @OnClick(R.id.imgSavedIdea)
    public void businessProfileImage() {
        getFragmentManager().beginTransaction().replace(R.id.container, new BusinessProfilePage()).addToBackStack("").commit();

    }

    @OnClick(R.id.tvLogDate)
    public void logDate() {
        getFragmentManager().beginTransaction().replace(R.id.container, new LogDateFragment()).addToBackStack("").commit();

    }

}
