package com.imagepicker.model;

/**
 * author by Anuj Sharma on 10/3/2017.
 */

public class MessageEvent {
    private int totalCount;
    private MediaItemBean mediaItemBean;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public MediaItemBean getMediaItemBean() {
        return mediaItemBean;
    }

    public void setMediaItemBean(MediaItemBean mediaItemBean) {
        this.mediaItemBean = mediaItemBean;
    }
}
