package com.salesforce.android.service.common.ui.internal.android;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AsyncViewHolder extends RecyclerView.w {
    private boolean mAsyncComplete = false;

    /* access modifiers changed from: protected */
    public abstract void handleAsyncComplete();

    public AsyncViewHolder(View view) {
        super(view);
    }

    public boolean isAsyncComplete() {
        return this.mAsyncComplete;
    }

    /* access modifiers changed from: protected */
    public void setAsyncComplete(boolean z) {
        this.mAsyncComplete = z;
        handleAsyncComplete();
    }
}
