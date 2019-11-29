package com.shopee.feeds.feedlibrary.b;

import android.content.Context;
import com.shopee.feeds.feedlibrary.a.a;
import com.shopee.feeds.feedlibrary.data.c.d;
import com.shopee.feeds.feedlibrary.view.a.g;
import java.util.ArrayList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.view.a.c f27581a;

    /* renamed from: b  reason: collision with root package name */
    g f27582b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27583c;

    /* renamed from: d  reason: collision with root package name */
    private d f27584d;

    public c(Context context, com.shopee.feeds.feedlibrary.view.a.c cVar) {
        this.f27583c = context;
        this.f27581a = cVar;
        this.f27584d = new d(context);
    }

    public c(Context context, g gVar) {
        this.f27583c = context;
        this.f27582b = gVar;
        this.f27584d = new d(context);
    }

    public void a() {
        this.f27584d.b(new a() {
            public void a(String str) {
            }

            public void a(Object obj, String str) {
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList != null && arrayList.size() > 0 && c.this.f27581a != null) {
                    c.this.f27581a.a(arrayList);
                }
            }
        });
    }

    public void b() {
        this.f27584d.a(3, false, (a) new a() {
            public void a(Object obj, String str) {
                ArrayList arrayList = (ArrayList) obj;
                if (c.this.f27582b == null) {
                    return;
                }
                if (arrayList != null) {
                    c.this.f27582b.a(arrayList);
                } else {
                    c.this.f27582b.a(new ArrayList());
                }
            }

            public void a(String str) {
                if (c.this.f27582b != null) {
                    c.this.f27582b.a(new ArrayList());
                }
            }
        });
    }
}
