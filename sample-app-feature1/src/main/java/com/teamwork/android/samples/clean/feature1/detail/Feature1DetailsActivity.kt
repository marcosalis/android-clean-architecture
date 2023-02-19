package com.teamwork.android.samples.clean.feature1.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.teamwork.android.samples.clean.feature1.R

/**
 * TODO: handle Dagger injection with a Subcomponent in the feature module
 */
@Suppress("unused")
class Feature1DetailsActivity : AppCompatActivity(), Feature1DetailsView {

    private val exampleViewModel: Feature1DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature1)
    }

}
