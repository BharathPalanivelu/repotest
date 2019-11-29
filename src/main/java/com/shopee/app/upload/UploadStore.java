package com.shopee.app.upload;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.shopee.app.data.store.ay;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.util.j.b;
import java.util.ArrayList;
import java.util.List;

public class UploadStore extends ay {
    private b<UploadGroup> mUploadList;

    public UploadStore(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.mUploadList = new b<>(sharedPreferences, "product_upload_list2", new a<List<UploadGroup>>() {
        });
    }

    public synchronized List<UploadGroup> getAll() {
        return (List) this.mUploadList.a();
    }

    private synchronized void saveAll(List<UploadGroup> list) {
        this.mUploadList.a(list);
    }

    public synchronized void add(UploadGroup uploadGroup) {
        this.mUploadList.b(uploadGroup);
    }

    public synchronized void update(UploadGroup uploadGroup) {
        List<UploadGroup> all = getAll();
        ArrayList arrayList = new ArrayList();
        for (UploadGroup next : all) {
            if (next.getRequestId().equals(uploadGroup.getRequestId())) {
                arrayList.add(uploadGroup);
            } else {
                arrayList.add(next);
            }
        }
        saveAll(arrayList);
    }

    public synchronized void delete(UploadGroup uploadGroup) {
        List<UploadGroup> all = getAll();
        ArrayList arrayList = new ArrayList();
        for (UploadGroup next : all) {
            if (!next.getRequestId().equals(uploadGroup.getRequestId())) {
                arrayList.add(next);
            }
        }
        saveAll(arrayList);
    }
}
