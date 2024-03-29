package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab {
    private final A zaco;

    public zae(int i, A a2) {
        super(i);
        this.zaco = a2;
    }

    public final void zaa(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            this.zaco.run(zaa.zaab());
        } catch (RuntimeException e2) {
            zaa(e2);
        }
    }

    public final void zaa(Status status) {
        this.zaco.setFailedResult(status);
    }

    public final void zaa(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.zaco.setFailedResult(new Status(10, sb.toString()));
    }

    public final void zaa(zaab zaab, boolean z) {
        zaab.zaa((BasePendingResult<? extends Result>) this.zaco, z);
    }
}
