package com.example.eventsfragmentsclass3q2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;


public class PriceDetailsFragment extends Fragment {

    private EditText mEtCurrency;
    private EditText mEtPrice;
    private Button mBtnPreview;
    private String title;
    private String desc;
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;


    public PriceDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title=getArguments().getString("title");
            desc=getArguments().getString("desc");
            startTime=getArguments().getString("startTime");
            endTime=getArguments().getString("endTime");
            startDate=getArguments().getString("startDate");
            endDate=getArguments().getString("endDate");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtCurrency=view.findViewById(R.id.etCurrency);
        mEtPrice=view.findViewById(R.id.etPrice);
        mBtnPreview=view.findViewById(R.id.previewButton);

        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price=mEtPrice.getText().toString();
                Model model=new Model(title,desc,startTime,endTime,startDate,endDate,price);
                Intent intent=new Intent(getContext(),PreviewActivity.class);
                intent.putExtra("model",  model);
                startActivity(intent);

            }
        });
    }
}