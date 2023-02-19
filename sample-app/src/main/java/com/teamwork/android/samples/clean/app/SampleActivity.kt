package com.teamwork.android.samples.clean.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.teamwork.android.samples.clean.app.databinding.ActivitySampleBinding
import com.teamwork.android.samples.clean.app.feature2.detail.Feature2DetailsPresenter
import com.teamwork.android.samples.clean.feature1.detail.Feature1DetailsView
import com.teamwork.android.samples.clean.feature1.detail.Feature1DetailsViewModel
import com.teamwork.android.samples.clean.feature1.list.Feature1ListPresenter
import com.teamwork.android.samples.clean.feature1.list.Feature1ListView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@Suppress("unused")
class SampleActivity : AppCompatActivity(), Feature1ListView, Feature1DetailsView {

    /*
     * Note: in general, a real world app wouldn't use a mix of `ViewModel` and `Presenter`
     * dependencies. This is only done for showing the D.I. approach with Hilt on both components.
     */

    private val exampleViewModel: Feature1DetailsViewModel by viewModels()

    @Inject
    lateinit var presenter: Feature1ListPresenter

    @Inject
    lateinit var details2Presenter: Feature2DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySampleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setContentView(R.layout.activity_sample)
        setSupportActionBar(binding.toolbar)

        presenter.onViewCreated(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_sample, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
