package com.shopee.app.data.store;

import android.util.LruCache;
import com.shopee.app.util.d.a;
import com.tencent.ijk.media.player.IjkMediaMeta;

public class WebDataStore {
    private static final int APPROX_VALUE_SIZE_KB = 10;
    private LruCache<String, String> mDataStore;
    private a mPersistentData;

    public WebDataStore(a aVar) {
        double maxMemory = (double) (Runtime.getRuntime().maxMemory() / IjkMediaMeta.AV_CH_SIDE_RIGHT);
        Double.isNaN(maxMemory);
        this.mDataStore = new LruCache<>(Math.max(((int) (maxMemory * 0.012d)) / 10, 50));
        this.mPersistentData = aVar;
    }

    public void put(String str, String str2, boolean z) {
        if (str != null && str2 != null) {
            putInStore(str, str2, z);
        }
    }

    private void putInStore(String str, String str2, boolean z) {
        if (z) {
            a aVar = this.mPersistentData;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                    return;
                } catch (Exception unused) {
                    return;
                } catch (Error unused2) {
                    System.gc();
                    return;
                }
            }
        }
        this.mDataStore.put(str, str2);
    }

    public String get(String str) {
        if (str == null) {
            return null;
        }
        String str2 = this.mDataStore.get(str);
        if (str2 != null) {
            return str2;
        }
        a aVar = this.mPersistentData;
        if (aVar != null) {
            try {
                a.b a2 = aVar.a(str);
                if (a2 != null) {
                    return a2.a();
                }
            } catch (Exception unused) {
            } catch (Error unused2) {
                System.gc();
            }
        }
        return null;
    }
}
