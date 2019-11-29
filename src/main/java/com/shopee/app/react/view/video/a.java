package com.shopee.app.react.view.video;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.garena.videolib.player.PlayerView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.q.g;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.x;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.react.view.video.a.b;

public class a extends FrameLayout implements r.a {

    /* renamed from: a  reason: collision with root package name */
    final EventDispatcher f19116a;

    /* renamed from: b  reason: collision with root package name */
    private PlayerView f19117b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public w f19118c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f19119d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19120e;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f19121f = new Runnable() {
        public void run() {
            a aVar = a.this;
            aVar.measure(View.MeasureSpec.makeMeasureSpec(aVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(a.this.getHeight(), 1073741824));
            a aVar2 = a.this;
            aVar2.layout(aVar2.getLeft(), a.this.getTop(), a.this.getRight(), a.this.getBottom());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Runnable f19122g = new Runnable() {
        public void run() {
            if (a.this.f19118c != null && a.this.f19118c.b()) {
                a.this.b((int) a.this.f19118c.f());
            }
            if (!a.this.f19119d) {
                a aVar = a.this;
                aVar.postDelayed(aVar.f19122g, 500);
            }
        }
    };

    private String c(int i) {
        return i != 2 ? i != 3 ? i != 4 ? "buffering" : "ended" : "ready" : "buffering";
    }

    public void a() {
    }

    public void a(q qVar) {
    }

    public void a(p pVar, g gVar) {
    }

    public void a(x xVar, Object obj) {
    }

    public void a(boolean z) {
    }

    public a(Context context) {
        super(context);
        this.f19117b = new PlayerView(context);
        addView(this.f19117b, new FrameLayout.LayoutParams(-1, -1));
        this.f19116a = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.f19121f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        if (r0 != 3) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSource(java.lang.String r9) {
        /*
            r8 = this;
            android.net.Uri r0 = android.net.Uri.parse(r9)
            java.lang.String r1 = "type"
            java.lang.String r0 = r0.getQueryParameter(r1)
            r1 = -1
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x005f
            int r6 = r0.hashCode()
            r7 = 3680(0xe60, float:5.157E-42)
            if (r6 == r7) goto L_0x0047
            r7 = 103407(0x193ef, float:1.44904E-40)
            if (r6 == r7) goto L_0x003d
            r7 = 108273(0x1a6f1, float:1.51723E-40)
            if (r6 == r7) goto L_0x0033
            r7 = 106069776(0x6527f10, float:3.958996E-35)
            if (r6 == r7) goto L_0x0029
            goto L_0x0051
        L_0x0029:
            java.lang.String r6 = "other"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0051
            r0 = 3
            goto L_0x0052
        L_0x0033:
            java.lang.String r6 = "mp4"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0051
            r0 = 2
            goto L_0x0052
        L_0x003d:
            java.lang.String r6 = "hls"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0047:
            java.lang.String r6 = "ss"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0051
            r0 = 0
            goto L_0x0052
        L_0x0051:
            r0 = -1
        L_0x0052:
            if (r0 == 0) goto L_0x005d
            if (r0 == r4) goto L_0x005b
            if (r0 == r3) goto L_0x0060
            if (r0 == r2) goto L_0x0060
            goto L_0x005f
        L_0x005b:
            r2 = 2
            goto L_0x0060
        L_0x005d:
            r2 = 1
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            com.garena.videolib.player.PlayerView r0 = r8.f19117b
            r0.a((java.lang.String) r9, (int) r2, (boolean) r5, (int) r1)
            com.garena.videolib.player.PlayerView r9 = r8.f19117b
            com.google.android.exoplayer2.w r9 = r9.getPlayer()
            r8.f19118c = r9
            com.google.android.exoplayer2.w r9 = r8.f19118c
            r9.a((com.google.android.exoplayer2.r.a) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.view.video.a.setSource(java.lang.String):void");
    }

    public void b() {
        w wVar = this.f19118c;
        if (wVar != null) {
            wVar.a(this.f19120e ? BitmapDescriptorFactory.HUE_RED : 1.0f);
            this.f19117b.setAutoPlay(true);
            this.f19118c.a(true);
            this.f19118c.a();
        }
    }

    public void c() {
        if (this.f19118c != null) {
            this.f19117b.setAutoPlay(false);
            this.f19118c.a(false);
            this.f19118c.a();
        }
    }

    public void a(int i) {
        w wVar = this.f19118c;
        if (wVar != null) {
            wVar.a((long) (i * 1000));
        }
    }

    public void setMuted(boolean z) {
        this.f19120e = z;
        w wVar = this.f19118c;
        if (wVar != null) {
            wVar.a(this.f19120e ? BitmapDescriptorFactory.HUE_RED : 1.0f);
            if (this.f19118c.a() != 1) {
                a((int) this.f19118c.e(), c(this.f19118c.a()), this.f19118c.b(), (int) this.f19118c.f(), this.f19120e);
            }
        }
    }

    public void b(int i) {
        this.f19116a.dispatchEvent(new b(getId(), i));
    }

    public void a(int i, String str, boolean z, int i2, boolean z2) {
        int i3;
        int i4;
        if (this.f19117b.getPlayer() == null || this.f19117b.getPlayer().g() == null) {
            i4 = 0;
            i3 = 0;
        } else {
            Format g2 = this.f19117b.getPlayer().g();
            int i5 = g2.j;
            i3 = g2.k;
            i4 = i5;
        }
        this.f19116a.dispatchEvent(new com.shopee.app.react.view.video.a.a(getId(), str, z, i, i2, z2, i4, i3));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        c();
        return super.onSaveInstanceState();
    }

    public void d() {
        this.f19119d = true;
        this.f19117b.a();
    }

    public void a(boolean z, int i) {
        int e2 = (int) this.f19118c.e();
        boolean b2 = this.f19118c.b();
        int f2 = (int) this.f19118c.f();
        if (i != 1) {
            a(e2, c(i), b2, f2, this.f19120e);
        }
        this.f19122g.run();
    }

    public void a(e eVar) {
        a(0, "error", false, 0, this.f19120e);
    }
}
