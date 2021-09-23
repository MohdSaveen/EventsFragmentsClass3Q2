package com.example.eventsfragmentsclass3q2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private TextView mTvDesc;
    private TextView mTvStartTime;
    private TextView mTvEndTime;
    private TextView mTvStartDate;
    private TextView mTvEndDate;
    private TextView mTvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Model model= (Model) getIntent().getSerializableExtra("model");
        mTvTitle.setText(model.getTitle());
        mTvDesc.setText(model.getDesc());
        mTvStartTime.setText(model.getStartTime());
        mTvEndTime.setText(model.getEndTime());
        mTvPrice.setText(model.getPrice());
        mTvStartDate.setText(model.getStartDate());
        mTvEndDate.setText(model.getEndDate());

    }

    private void initViews() {
        mTvTitle=findViewById(R.id.tvEventTitle);
        mTvDesc=findViewById(R.id.tvDescription);
        mTvStartTime=findViewById(R.id.tvStartTime);
        mTvEndTime=findViewById(R.id.tvEndTime);
        mTvStartDate=findViewById(R.id.tvStartDate);
        mTvEndDate=findViewById(R.id.tvEndDate);
        mTvPrice=findViewById(R.id.tvPrice);

    }


}