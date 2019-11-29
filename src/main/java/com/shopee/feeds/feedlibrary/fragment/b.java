package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;

public abstract class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private Handler f7132a = new a(this);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f7133b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7134c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7135d;

    /* renamed from: e  reason: collision with root package name */
    private int f7136e;

    /* renamed from: f  reason: collision with root package name */
    private View f7137f;

    public abstract void a();

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f7137f = view;
        b();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f7135d = z;
        if (this.f7135d) {
            b();
            return;
        }
        this.f7134c = false;
        this.f7132a.removeMessages(1);
    }

    private void b() {
        if (this.f7135d && this.f7137f != null && !this.f7134c) {
            this.f7134c = true;
            if (!this.f7133b) {
                Handler handler = this.f7132a;
                int i = this.f7136e;
                handler.sendEmptyMessageDelayed(1, i <= 0 ? 64 : (long) i);
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f7134c = false;
        this.f7132a.removeCallbacksAndMessages((Object) null);
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f28201a;

        public a(b bVar) {
            this.f28201a = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            b bVar = (b) this.f28201a.get();
            if (bVar != null && message.what == 1) {
                boolean unused = bVar.f7133b = true;
                bVar.a();
            }
        }
    }
}
