package com.shopee.app.upload;

import android.util.Pair;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.util.af;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadManager {
    private static VideoRunnable mCachedJob;
    private static Map<String, Pair<UploadGroup, UploadRunnable>> mMap = new HashMap();
    public final UploadStore mUploadStore;

    public UploadManager(UploadStore uploadStore) {
        this.mUploadStore = uploadStore;
    }

    public synchronized UploadGroup getUploading() {
        List<UploadGroup> all = this.mUploadStore.getAll();
        if (af.a(all)) {
            return null;
        }
        return all.get(0);
    }

    public synchronized void put(UploadGroup uploadGroup, UploadRunnable uploadRunnable) {
        mMap.put(uploadGroup.getRequestId(), new Pair(uploadGroup, uploadRunnable));
    }

    public synchronized Pair<UploadGroup, UploadRunnable> getCurrent() {
        UploadGroup uploading = getUploading();
        if (uploading == null) {
            return null;
        }
        return mMap.get(uploading.getRequestId());
    }

    public void remove(UploadGroup uploadGroup) {
        mMap.remove(uploadGroup.getRequestId());
    }

    public synchronized ProgressState getCurrentRunning() {
        return null;
    }

    public void cacheJob(VideoRunnable videoRunnable) {
        mCachedJob = videoRunnable;
    }

    public VideoRunnable getCachedJob() {
        return mCachedJob;
    }
}
