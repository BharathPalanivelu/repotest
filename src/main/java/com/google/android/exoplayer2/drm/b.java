package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Looper;
import com.google.android.exoplayer2.drm.c;

@TargetApi(16)
public interface b<T extends c> {
    a<T> a(Looper looper, DrmInitData drmInitData);

    void a(a<T> aVar);

    boolean a(DrmInitData drmInitData);
}
