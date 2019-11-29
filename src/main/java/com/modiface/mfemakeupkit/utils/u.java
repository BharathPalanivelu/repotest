package com.modiface.mfemakeupkit.utils;

import com.modiface.mfemakeupkit.data.MFETrackingData;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public final MFETrackingData f15398a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f15399b;

    public u(MFETrackingData mFETrackingData, Object obj) {
        this.f15398a = mFETrackingData;
        this.f15399b = obj;
    }

    public u(MFEImage mFEImage, int i, Object obj) {
        this(new MFETrackingData(mFEImage, i), obj);
    }

    public u(MFEImage mFEImage, int i, boolean z, Object obj) {
        this(new MFETrackingData(mFEImage, i, z), obj);
    }
}
