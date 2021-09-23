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


public class TimeAndDateDetailsFragment extends Fragment {

    private EditText mEtStartTime;
    private EditText mEtEndTime;
    private EditText mEtStartDate;
    private EditText mEtEndDate;
    private Button mBtnNext2;
    private CommunicationListener listener;
    private String title;
    private String desc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title=getArguments().getString("title");
            desc=getArguments().getString("desc");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date_details, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener= (CommunicationListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtStartTime=view.findViewById(R.id.etEventStartTime);
        mEtEndTime=view.findViewById(R.id.etEventEndTime);
        mEtStartDate=view.findViewById(R.id.etEventStartDate);
        mEtEndDate=view.findViewById(R.id.etEventEndDate);
        mBtnNext2=view.findViewById(R.id.btnNext2);

        mBtnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startTime=mEtStartTime.getText().toString();
                String endTime=mEtEndTime.getText().toString();
                String startDate=mEtStartDate.getText().toString();
                String endDate=mEtEndDate.getText().toString();

                Bundle bundle=new Bundle();
                bundle.putString("startTime",startTime);
                bundle.putString("endTime",endTime);
                bundle.putString("startDate",startDate);
                bundle.putString("endDate",endDate);
                bundle.putString("title",title);
                bundle.putString("desc",desc);
                if(listener!=null){
                    listener.launchFragments(bundle,"time");
                }
            }
        });


    }
}