package com.teamwork.android.samples.clean.app.feature2.detail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.teamwork.android.samples.clean.app.R;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class Feature2DetailsActivity extends AppCompatActivity implements Feature2DetailsView {

    @Inject
    Feature2DetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_feature2_details);
        presenter.onViewCreated(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDestroyed();
    }

}
