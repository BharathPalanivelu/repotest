package com.shopee.app.tracking;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.a.o;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.shopeetracker.bimodel.TrackingImpression;
import d.d.b.j;
import d.d.b.k;
import d.m;
import d.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImpressionObserver implements g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List<o> f6981a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f6982b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f6983c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f6984d;

    /* renamed from: e  reason: collision with root package name */
    private final c f6985e;

    /* renamed from: f  reason: collision with root package name */
    private final com.shopee.app.tracking.trackingv3.b f6986f;

    /* renamed from: g  reason: collision with root package name */
    private final b f6987g;
    private final d.d.a.b<Integer, o> h;

    public interface a {
        int a();

        int b();
    }

    static final class c extends k implements d.d.a.c<c, String, p> {
        final /* synthetic */ ImpressionObserver this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ImpressionObserver impressionObserver) {
            super(2);
            this.this$0 = impressionObserver;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
            a((c) obj, (String) obj2);
            return p.f32714a;
        }

        public final void a(c cVar, String str) {
            j.b(cVar, "biTracker");
            j.b(str, TouchesHelper.TARGET_KEY);
            Iterable<o> a2 = this.this$0.f6981a;
            Collection arrayList = new ArrayList(d.a.j.a(a2, 10));
            for (o oVar : a2) {
                TrackingImpression trackingImpression = new TrackingImpression();
                trackingImpression.targetData = oVar.toString();
                arrayList.add(trackingImpression);
            }
            cVar.a(str, (List<TrackingImpression>) d.a.j.b((List) arrayList));
        }
    }

    public ImpressionObserver(a aVar, c cVar, com.shopee.app.tracking.trackingv3.b bVar, b bVar2, d.d.a.b<? super Integer, o> bVar3) {
        j.b(aVar, "itemVisibleHandler");
        j.b(bVar, "biTrackerV3");
        j.b(bVar3, "converter");
        this.f6984d = aVar;
        this.f6985e = cVar;
        this.f6986f = bVar;
        this.f6987g = bVar2;
        this.h = bVar3;
        this.f6981a = new ArrayList();
        this.f6983c = new Handler(Looper.getMainLooper(), new d(this));
    }

    static final class d implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImpressionObserver f19146a;

        d(ImpressionObserver impressionObserver) {
            this.f19146a = impressionObserver;
        }

        public final boolean handleMessage(Message message) {
            int a2 = this.f19146a.f6984d.a();
            int b2 = this.f19146a.f6984d.b();
            int i = message.what;
            if (a2 > i || b2 < i || this.f19146a.f6982b) {
                return true;
            }
            this.f19146a.a(message.what);
            return true;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImpressionObserver(final RecyclerView recyclerView, c cVar, com.shopee.app.tracking.trackingv3.b bVar, b bVar2, d.d.a.b<? super Integer, o> bVar3) {
        this((a) new a() {
            public int a() {
                RecyclerView.i layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    return ((LinearLayoutManager) layoutManager).n();
                }
                return 0;
            }

            public int b() {
                RecyclerView.i layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    return ((LinearLayoutManager) layoutManager).p();
                }
                return 0;
            }
        }, cVar, bVar, bVar2, bVar3);
        j.b(recyclerView, "recyclerView");
        j.b(bVar, "biTrackerV3");
        j.b(bVar3, "converter");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImpressionObserver(final ListView listView, c cVar, com.shopee.app.tracking.trackingv3.b bVar, b bVar2, d.d.a.b<? super Integer, o> bVar3) {
        this((a) new a() {
            public int a() {
                return listView.getFirstVisiblePosition();
            }

            public int b() {
                return listView.getLastVisiblePosition();
            }
        }, cVar, bVar, bVar2, bVar3);
        j.b(listView, "listView");
        j.b(bVar, "biTrackerV3");
        j.b(bVar3, "converter");
    }

    public final void a(View view, int i) {
        if (view != null) {
            this.f6983c.removeMessages(i);
            Handler handler = this.f6983c;
            Message message = new Message();
            message.what = i;
            handler.sendMessageDelayed(message, 1000);
            view.setTag(Integer.valueOf(i));
        }
    }

    public final void a(View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof Integer)) {
            Handler handler = this.f6983c;
            Object tag = view.getTag();
            if (tag != null) {
                handler.removeMessages(((Integer) tag).intValue());
                return;
            }
            throw new m("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public void a(int i) {
        o a2 = this.h.a(Integer.valueOf(i));
        if (a2 != null) {
            this.f6981a.add(a2);
        }
    }

    public final void a() {
        b();
    }

    public void b() {
        if (!this.f6981a.isEmpty()) {
            c();
            this.f6981a.clear();
        }
        this.f6983c.removeCallbacksAndMessages((Object) null);
    }

    @androidx.lifecycle.o(a = e.a.ON_PAUSE)
    public final void onPause() {
        this.f6982b = true;
        b();
    }

    @androidx.lifecycle.o(a = e.a.ON_RESUME)
    public final void onResume() {
        if (this.f6982b) {
            int b2 = this.f6984d.b();
            for (int a2 = this.f6984d.a(); a2 < b2; a2++) {
                a((View) null, a2);
            }
        }
        this.f6982b = false;
    }

    private final void c() {
        b bVar = this.f6987g;
        if (bVar != null) {
            a(this.f6985e, bVar.c(), new c(this));
            this.f6986f.a(this.f6987g.a(), this.f6987g.b(), this.f6981a);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f19143a;

        /* renamed from: b  reason: collision with root package name */
        private final String f19144b;

        /* renamed from: c  reason: collision with root package name */
        private final String f19145c;

        public b(String str) {
            this(str, (String) null, (String) null, 6, (g) null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return j.a((Object) this.f19143a, (Object) bVar.f19143a) && j.a((Object) this.f19144b, (Object) bVar.f19144b) && j.a((Object) this.f19145c, (Object) bVar.f19145c);
        }

        public int hashCode() {
            String str = this.f19143a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f19144b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f19145c;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "TargetData(targetType=" + this.f19143a + ", pageSection=" + this.f19144b + ", targetV0=" + this.f19145c + SQLBuilder.PARENTHESES_RIGHT;
        }

        public b(String str, String str2, String str3) {
            j.b(str, "targetType");
            j.b(str2, "pageSection");
            this.f19143a = str;
            this.f19144b = str2;
            this.f19145c = str3;
        }

        public final String a() {
            return this.f19143a;
        }

        public final String b() {
            return this.f19144b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(String str, String str2, String str3, int i, g gVar) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3);
        }

        public final String c() {
            return this.f19145c;
        }
    }

    private final <A, B> void a(A a2, B b2, d.d.a.c<? super A, ? super B, p> cVar) {
        if (a2 != null && b2 != null) {
            cVar.a(a2, b2);
        }
    }
}
