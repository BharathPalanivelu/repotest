package com.shopee.app.util.g;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.path.android.jobqueue.RetryConstraint;
import com.shopee.app.h.f;
import com.shopee.app.h.o;
import com.shopee.app.util.f.a;
import java.io.File;

public class d extends Job {

    /* renamed from: a  reason: collision with root package name */
    transient a f26360a;
    private final String mFileName;

    public void onAdded() {
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
    }

    public d(String str) {
        super(new Params(1).persist());
        this.mFileName = str;
    }

    public void onRun() throws Throwable {
        if (new File(f.a().b(this.mFileName)).exists()) {
            if (this.f26360a.a(this.mFileName) == 1) {
                o.a().b(this.mFileName, 2);
            } else {
                o.a().b(this.mFileName, 3);
                throw new RuntimeException("Unable to upload file");
            }
        }
    }

    /* access modifiers changed from: protected */
    public RetryConstraint shouldReRunOnThrowable(Throwable th, int i, int i2) {
        RetryConstraint createExponentialBackoff = RetryConstraint.createExponentialBackoff(i, 1000);
        createExponentialBackoff.setApplyNewDelayToGroup(true);
        return createExponentialBackoff;
    }
}
