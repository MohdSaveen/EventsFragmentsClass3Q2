package com.example.eventsfragmentsclass3q2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EventDetailsFragments extends Fragment {

    private EditText mEtEventTitle;
    private EditText mEtEventDesc;
    private Button mBtnNext1;
    private CommunicationListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener= (CommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details_fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtEventTitle=view.findViewById(R.id.etEventTitle);
        mEtEventDesc=view.findViewById(R.id.etEventDescription);
        mBtnNext1=view.findViewById(R.id.btnNext);

        mBtnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=mEtEventTitle.getText().toString();
                String desc=mEtEventDesc.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("title",title);
                bundle.putString("desc",desc);
                if(listener!=null){
                    listener.launchFragments(bundle,"event");
                }
            }
        });
    }
}