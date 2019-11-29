package com.shopee.app.ui.home.d;

import android.content.Intent;
import android.view.View;
import b.a;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.shopee.app.react.e.f;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.home.m;
import com.shopee.react.sdk.bridge.modules.base.d;
import java.util.HashMap;
import java.util.Map;

public class g extends b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a<ReactInstanceManager> f22167a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b> f22168b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, d> f22169c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final c f22170d;

    /* renamed from: e  reason: collision with root package name */
    private f f22171e;

    /* renamed from: f  reason: collision with root package name */
    private f f22172f;

    /* renamed from: g  reason: collision with root package name */
    private f f22173g;
    private f h;
    private com.shopee.app.react.e.b i;
    private com.shopee.app.react.e.a j = new com.shopee.app.react.e.a() {
        public ReactContext getReactContext() {
            return ((ReactInstanceManager) g.this.f22167a.get()).getCurrentReactContext();
        }

        public int getReactTag() {
            m p = g.this.f22170d.p();
            if (p != null) {
                return p.b(0);
            }
            return 0;
        }

        public View getViewRef() {
            return g.this.f22170d.p();
        }
    };
    private com.shopee.app.react.e.a k = new com.shopee.app.react.e.a() {
        public ReactContext getReactContext() {
            return ((ReactInstanceManager) g.this.f22167a.get()).getCurrentReactContext();
        }

        public int getReactTag() {
            m p = g.this.f22170d.p();
            if (p != null) {
                return p.b(2);
            }
            return 0;
        }

        public View getViewRef() {
            return g.this.f22170d.p();
        }
    };
    private com.shopee.app.react.e.a l = new com.shopee.app.react.e.a() {
        public ReactContext getReactContext() {
            return ((ReactInstanceManager) g.this.f22167a.get()).getCurrentReactContext();
        }

        public int getReactTag() {
            m p = g.this.f22170d.p();
            if (p != null) {
                return p.b(1);
            }
            return 0;
        }

        public View getViewRef() {
            return g.this.f22170d.p();
        }
    };

    public g(c cVar, a<ReactInstanceManager> aVar) {
        this.f22170d = cVar;
        this.f22167a = aVar;
        this.f22168b = new HashMap();
        this.f22169c = new HashMap();
        this.f22171e = new f(this.j, true);
        this.f22172f = new f(this.j, false);
        this.f22173g = new f(this.k, true);
        this.h = new f(this.k, false);
        this.i = new com.shopee.app.react.e.b();
    }

    public void a(String str, b bVar) {
        this.f22168b.put(str, bVar);
    }

    public b a(String str) {
        return this.f22168b.get(str);
    }

    public void a(String str, d dVar) {
        this.f22169c.put(str, dVar);
    }

    public d b(String str) {
        return this.f22169c.get(str);
    }

    public int a() {
        m p = this.f22170d.p();
        if (p != null) {
            return p.getReactTag();
        }
        return 0;
    }

    public void b() {
        super.b();
        if (this.f22167a.get() != null) {
            this.f22167a.get().onHostPause(this.f22170d);
        }
        m p = this.f22170d.p();
        if (p != null) {
            p.B = null;
        }
    }

    public void c() {
        super.c();
        a<ReactInstanceManager> aVar = this.f22167a;
        if (aVar != null) {
            c cVar = this.f22170d;
            aVar.get().onHostResume(cVar, cVar);
        }
        m p = this.f22170d.p();
        if (p != null) {
            p.B = this;
        }
    }

    public void d() {
        super.d();
        m p = this.f22170d.p();
        if (p != null) {
            p.post(this.f22171e);
            p.post(this.f22173g);
        }
    }

    public void e() {
        super.e();
        m p = this.f22170d.p();
        if (p != null) {
            p.post(this.f22172f);
            p.post(this.h);
        }
    }

    public void a(int i2, int i3, Intent intent) {
        if (this.f22167a.get() != null) {
            this.f22167a.get().onActivityResult(this.f22170d, i2, i3, intent);
        }
    }

    public void f() {
        super.f();
        for (b next : this.f22168b.values()) {
            if (next instanceof com.shopee.app.react.util.a) {
                ((com.shopee.app.react.util.a) next).d();
            }
        }
        this.f22171e.a();
        this.f22173g.a();
        this.f22172f.a();
        this.h.a();
        a<ReactInstanceManager> aVar = this.f22167a;
        if (aVar != null) {
            aVar.get().onHostDestroy(this.f22170d);
        }
    }

    public void c(String str) {
        if (com.shopee.app.ui.home.a.TAB_HOME_RN.getId().equals(str)) {
            this.i.a(this.j, "home");
        } else if (com.shopee.app.ui.home.a.TAB_FEED.getId().equals(str)) {
            this.i.a(this.l, "feed");
        } else if (com.shopee.app.ui.home.a.TAB_MALL_RN.getId().equals(str)) {
            this.i.a(this.k, "mall");
        }
    }
}
