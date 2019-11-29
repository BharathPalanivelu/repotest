package com.salesforce.android.service.common.http.okhttp;

import e.c;
import e.h;
import e.u;
import java.io.IOException;

class ProgressObservingSink extends h {
    private final Listener mListener;

    interface Listener {
        void onBytesWritten(long j) throws IOException;
    }

    public ProgressObservingSink(u uVar, Listener listener) {
        super(uVar);
        this.mListener = listener;
    }

    public void write(c cVar, long j) throws IOException {
        super.write(cVar, j);
        this.mListener.onBytesWritten(j);
    }
}
