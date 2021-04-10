package org.mahendroo.recordstat.views;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.mahendroo.recordstat.R;
import org.mahendroo.recordstat.callbacks.RecordStatCallback;
import org.mahendroo.recordstat.databinding.ActivityRecordStatBinding;
import org.mahendroo.recordstat.utils.Utililty;
import org.mahendroo.recordstat.viewmodels.RecordStatViewModel;

public class RecordStatActivity extends AppCompatActivity implements RecordStatCallback {

    private RecordStatViewModel viewModel;
    private ActivityRecordStatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_record_stat);
        viewModel = new RecordStatViewModel(getApplication());

        binding.setActionCallback(this);

        initObservers();
        requestInitialData();
    }

    private void initObservers() {
        viewModel.getRecordStatModelMutableLiveData().observe(this, recordStatModel -> {
            if (recordStatModel != null) {
                binding.setRecordStatModel(recordStatModel);
            }
        });
    }

    /**
     * Used to request the data from all the APIs, altogether
     */
    private void requestInitialData() {

        // A handler to execute the API request after 5 seconds of delay
        new Handler().postDelayed(() -> {
            if (this != null && viewModel != null) {
                fetchComments();
                fetchPhotos();
                fetchPosts();
                fetchTodos();
            }

        }, 5000);

    }

    @Override
    public void fetchComments() {
        if (Utililty.INSTANCE.isNetworkConnected(getApplicationContext()))
            viewModel.fetchComments();
    }

    @Override
    public void fetchPhotos() {
        if (Utililty.INSTANCE.isNetworkConnected(getApplicationContext()))
            viewModel.fetchPhotos();
    }

    @Override
    public void fetchTodos() {
        if (Utililty.INSTANCE.isNetworkConnected(getApplicationContext()))
            viewModel.fetchTodos();
    }

    @Override
    public void fetchPosts() {
        if (Utililty.INSTANCE.isNetworkConnected(getApplicationContext()))
            viewModel.fetchPosts();
    }
}