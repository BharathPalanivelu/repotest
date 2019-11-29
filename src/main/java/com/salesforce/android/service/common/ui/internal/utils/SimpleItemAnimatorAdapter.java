package com.salesforce.android.service.common.ui.internal.utils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;

public abstract class SimpleItemAnimatorAdapter extends s {
    public void endAnimation(RecyclerView.w wVar) {
    }

    public void endAnimations() {
    }

    public boolean isRunning() {
        return false;
    }

    public void runPendingAnimations() {
    }

    public boolean animateRemove(RecyclerView.w wVar) {
        dispatchRemoveFinished(wVar);
        return false;
    }

    public boolean animateAdd(RecyclerView.w wVar) {
        dispatchAddFinished(wVar);
        return false;
    }

    public boolean animateMove(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
        dispatchMoveFinished(wVar);
        return false;
    }

    public boolean animateChange(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4) {
        dispatchChangeFinished(wVar2, false);
        return false;
    }
}
