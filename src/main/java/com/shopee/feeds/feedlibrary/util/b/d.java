package com.shopee.feeds.feedlibrary.util.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    b f28261a;

    /* renamed from: b  reason: collision with root package name */
    public a f28262b;

    /* renamed from: c  reason: collision with root package name */
    private Context f28263c;

    /* renamed from: d  reason: collision with root package name */
    private int f28264d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f28265e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Integer, Float> f28266f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Integer, Boolean> f28267g = new HashMap<>();
    private boolean h;

    public interface a {
        void a(int i);
    }

    public d(Context context, RecyclerView recyclerView, int i, boolean z) {
        this.f28263c = context;
        this.f28265e = recyclerView;
        this.f28264d = i;
        this.h = z;
        this.f28261a = new b();
    }

    public void a() {
        this.f28261a.removeCallbacks((Runnable) null);
        this.f28261a.sendEmptyMessage(291);
    }

    public void b() {
        HashMap<Integer, Float> hashMap = this.f28266f;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<Integer, Boolean> hashMap2 = this.f28267g;
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
                d.this.d();
            }
        }
    }

    public void c() {
        b bVar = this.f28261a;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        int height = this.f28265e.getHeight();
        RecyclerView.a adapter = this.f28265e.getAdapter();
        int itemCount = adapter.getItemCount();
        if (height > 0 && itemCount > 0) {
            if (this.f28267g.size() < adapter.getItemCount()) {
                int i = this.f28264d;
                if (i == 2) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f28265e.getLayoutManager();
                    int n = linearLayoutManager.n();
                    View c2 = linearLayoutManager.c(n);
                    if (c2 != null) {
                        int height2 = c2.getHeight();
                        int top = c2.getTop();
                        int p = linearLayoutManager.p();
                        View c3 = linearLayoutManager.c(p);
                        if (c3 != null) {
                            int bottom = c3.getBottom();
                            int i2 = height2 / 2;
                            if (Math.abs(top) > i2) {
                                n++;
                            }
                            if (bottom >= height + i2) {
                                p--;
                            }
                            if (p >= n) {
                                a(n, p);
                            }
                        }
                    }
                } else if (i == 1) {
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f28265e.getLayoutManager();
                    int n2 = gridLayoutManager.n();
                    View c4 = gridLayoutManager.c(n2);
                    if (c4 != null) {
                        int height3 = c4.getHeight();
                        int top2 = c4.getTop();
                        int p2 = gridLayoutManager.p();
                        View c5 = gridLayoutManager.c(p2);
                        if (c5 != null) {
                            int bottom2 = c5.getBottom();
                            int i3 = height3 / 2;
                            if (Math.abs(top2) > i3) {
                                n2 += 2;
                            }
                            if (bottom2 >= height + i3) {
                                p2 -= 2;
                            }
                            if (p2 > n2) {
                                a(n2, p2);
                            }
                        }
                    }
                }
            } else if (!this.h) {
                this.f28261a.removeCallbacksAndMessages((Object) null);
            }
        }
    }

    private void a(int i, int i2) {
        while (i <= i2) {
            if (!this.f28267g.containsKey(Integer.valueOf(i))) {
                if (!this.f28266f.containsKey(Integer.valueOf(i))) {
                    this.f28266f.put(Integer.valueOf(i), Float.valueOf(0.1f));
                } else {
                    float floatValue = this.f28266f.get(Integer.valueOf(i)).floatValue();
                    if (((double) floatValue) >= 1.0d) {
                        a aVar = this.f28262b;
                        if (aVar != null) {
                            aVar.a(i);
                            this.f28266f.remove(Integer.valueOf(i));
                            this.f28267g.put(Integer.valueOf(i), true);
                        }
                    } else {
                        this.f28266f.put(Integer.valueOf(i), Float.valueOf(floatValue + 0.1f));
                    }
                }
            }
            i++;
        }
    }

    public void a(a aVar) {
        this.f28262b = aVar;
    }
}
