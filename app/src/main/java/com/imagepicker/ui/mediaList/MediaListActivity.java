package com.imagepicker.ui.mediaList;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.imagepicker.R;
import com.imagepicker.utils.PermissionsAndroid;
import com.imagepicker.utils.RecyclerViewFastScroller;

/**
 * auther Anuj Sharma on 9/18/2017.
 */

public class MediaListActivity extends AppCompatActivity implements MediaListView {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerViewFastScroller fastScroller;
    public MenuItem save, count;

    private MediaListPresenterImpl presenterImpl;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_save, menu);
        save = menu.findItem(R.id.action_save);
        count = menu.findItem(R.id.action_count);
        save.setVisible(false);
        count.setVisible(false);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                if(presenterImpl!=null){
                    presenterImpl.saveSelectedMedia();
                }
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_media_list);
        initViews();
        presenterImpl = new MediaListPresenterImpl(this, this);

    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.media_recycler);
        fastScroller = findViewById(R.id.fastscroller);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public RecyclerViewFastScroller getFastScroller() {
        return fastScroller;
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionsAndroid.WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Show option to update profile
                    if (presenterImpl != null) {
                        presenterImpl.fetchMediaFiles();
                    }

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "Camera/Storage permission Denied", Toast.LENGTH_SHORT).show();
//                    Utils.getInstance().showToast("Camera/Storage permission Denied");
                }
            }

        }
    }
}
