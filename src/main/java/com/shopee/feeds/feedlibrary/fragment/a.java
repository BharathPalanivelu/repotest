package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.fragment.app.Fragment;

public abstract class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7128a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7129b;

    /* renamed from: c  reason: collision with root package name */
    C0433a f7130c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f7131d = false;

    public abstract void a();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7130c = new C0433a();
    }

    /* renamed from: com.shopee.feeds.feedlibrary.fragment.a$a  reason: collision with other inner class name */
    class C0433a extends Handler {
        C0433a() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 123) {
                boolean unused = a.this.f7131d = false;
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f7129b = z;
        b();
    }

    public void onResume() {
        super.onResume();
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f7130c.removeCallbacksAndMessages((Object) null);
    }

    private void b() {
        if (!this.f7131d && this.f7129b) {
            if (this.f7130c == null) {
                this.f7130c = new C0433a();
            }
            a();
            this.f7128a = false;
            this.f7131d = true;
            this.f7130c.sendEmptyMessageDelayed(123, 500);
        }
    }
}
