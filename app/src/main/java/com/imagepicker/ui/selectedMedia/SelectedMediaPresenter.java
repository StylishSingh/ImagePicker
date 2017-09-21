package com.imagepicker.ui.selectedMedia;

import android.widget.ImageView;

import com.imagepicker.model.MediaItemBean;

/**
 * Created by Anuj Sharma on 9/21/2017.
 */

public interface SelectedMediaPresenter {
    void onMediaClick(MediaItemBean obj, int position);

    void onMediaLongClick(MediaItemBean obj, int position, ImageView view);
}
