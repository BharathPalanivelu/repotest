package com.shopee.app.web;

import android.app.Dialog;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import com.shopee.shopeetracker.EventRepository;
import d.d.b.j;

final class RenderProcessGoneHandlerClient$subscribeToLifecycleEvents$lifecycleObserver$1 implements f {
    final /* synthetic */ Dialog $dialog;

    RenderProcessGoneHandlerClient$subscribeToLifecycleEvents$lifecycleObserver$1(Dialog dialog) {
        this.$dialog = dialog;
    }

    public final void onStateChanged(h hVar, e.a aVar) {
        j.b(hVar, "<anonymous parameter 0>");
        j.b(aVar, EventRepository.TABLE);
        if (aVar == e.a.ON_DESTROY && this.$dialog.isShowing()) {
            this.$dialog.dismiss();
        }
    }
}
