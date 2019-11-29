package com.shopee.app.web;

import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.f;
import androidx.lifecycle.h;

final class RenderProcessGoneHandlerClient$subscribeToLifecycleEvents$1 implements DialogInterface.OnDismissListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ f $lifecycleObserver;

    RenderProcessGoneHandlerClient$subscribeToLifecycleEvents$1(Context context, f fVar) {
        this.$context = context;
        this.$lifecycleObserver = fVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ((h) this.$context).getLifecycle().b(this.$lifecycleObserver);
    }
}
