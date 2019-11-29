package com.shopee.live.livestreaming.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

public class ad {

    /* renamed from: a  reason: collision with root package name */
    b f29405a;

    /* renamed from: b  reason: collision with root package name */
    public a f29406b;

    /* renamed from: c  reason: collision with root package name */
    private Context f29407c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f29408d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Integer, Float> f29409e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Integer, Boolean> f29410f = new HashMap<>();

    public interface a {
        void a(int i);
    }

    public ad(Context context, RecyclerView recyclerView) {
        this.f29407c = context;
        this.f29408d = recyclerView;
        this.f29405a = new b();
    }

    public void a() {
        this.f29405a.sendEmptyMessage(291);
    }

    public void b() {
        HashMap<Integer, Float> hashMap = this.f29409e;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<Integer, Boolean> hashMap2 = this.f29410f;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
    }

    class b extends Handler {
        b() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 291) {
                sendEmptyMessageDelayed(291, 100);
                ad.this.d();
            }
        }
    }

    public void c() {
        b bVar = this.f29405a;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        int height = this.f29408d.getHeight();
        RecyclerView.a adapter = this.f29408d.getAdapter();
        int itemCount = adapter.getItemCount();
        if (height > 0 && itemCount > 0) {
            if (this.f29410f.size() >= adapter.getItemCount()) {
                this.f29405a.removeCallbacksAndMessages((Object) null);
                return;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f29408d.getLayoutManager();
            int n = linearLayoutManager.n();
            View c2 = linearLayoutManager.c(n);
            if (c2 != null) {
                int height2 = c2.getHeight();
                int top = c2.getTop();
                int p = linearLayoutManager.p();
                View c3 = linearLayoutManager.c(p);
                if (c3 != null) {
                    int bottom = c3.getBottom();
                    int i = height2 / 2;
                    if (Math.abs(top) > i) {
                        n++;
                    }
                    if (bottom >= height + i) {
                        p--;
                    }
                    if (p > n) {
                        a(n, p);
                    }
                }
            }
        }
    }

    private void a(int i, int i2) {
        while (i <= i2) {
            if (!this.f29410f.containsKey(Integer.valueOf(i))) {
                if (!this.f29409e.containsKey(Integer.valueOf(i))) {
                    this.f29409e.put(Integer.valueOf(i), Float.valueOf(0.1f));
                } else {
                    float floatValue = this.f29409e.get(Integer.valueOf(i)).floatValue();
                    if (((double) floatValue) >= 1.0d) {
                        a aVar = this.f29406b;
                        if (aVar != null) {
                            aVar.a(i);
                            this.f29409e.remove(Integer.valueOf(i));
                            this.f29410f.put(Integer.valueOf(i), true);
                        }
                    } else {
                        this.f29409e.put(Integer.valueOf(i), Float.valueOf(floatValue + 0.1f));
                    }
                }
            }
            i++;
        }
    }

    public void a(a aVar) {
        this.f29406b = aVar;
    }
}
