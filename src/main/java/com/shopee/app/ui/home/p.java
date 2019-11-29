package com.shopee.app.ui.home;

import android.content.Context;
import android.view.ViewGroup;
import com.garena.android.uikit.a.a.a;
import com.shopee.app.ui.home.c.b;
import com.shopee.app.ui.home.chat.ChatTab_;
import com.shopee.app.ui.home.follow.FollowTab_;
import com.shopee.app.ui.home.me.v3.MeTabView3_;

public class p extends a {

    /* renamed from: a  reason: collision with root package name */
    private final int f22688a;

    /* renamed from: b  reason: collision with root package name */
    private int f22689b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22690c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f22691d = 0;

    /* renamed from: e  reason: collision with root package name */
    private a f22692e;

    public p(Context context, int i) {
        super(context);
        this.f22688a = i;
        this.f22689b = 0;
        d();
    }

    public p(Context context, int i, int i2) {
        super(context);
        this.f22688a = i;
        this.f22689b = i2;
        d();
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (!this.f22690c) {
            if (this.f22691d >= 30) {
                e();
            } else {
                postDelayed(new Runnable() {
                    public void run() {
                        p.this.d();
                    }
                }, 1000);
            }
            this.f22691d++;
            return;
        }
        e();
    }

    private void e() {
        try {
            int i = this.f22688a;
            if (i == 1) {
                this.f22692e = FollowTab_.a(getContext());
            } else if (i == 3) {
                this.f22692e = ChatTab_.a(getContext());
            } else if (i != 4) {
                this.f22692e = b.a(getContext());
            } else {
                this.f22692e = MeTabView3_.a(getContext());
                setSubIndex(this.f22689b);
            }
        } catch (Exception unused) {
            this.f22692e = b.a(getContext());
        }
        addView(this.f22692e, new ViewGroup.LayoutParams(-1, -1));
        if (this.f22690c) {
            a aVar = this.f22692e;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void setSubIndex(int i) {
        this.f22689b = i;
        a aVar = this.f22692e;
        if (aVar instanceof MeTabView3_) {
            int i2 = this.f22689b;
            if (i2 >= 0) {
                ((MeTabView3_) aVar).setSwitchIndex(i2);
            }
        }
    }

    public int getReactTag() {
        a aVar = this.f22692e;
        if (aVar instanceof MeTabView3_) {
            return ((MeTabView3_) aVar).getReactTag();
        }
        return 0;
    }

    public void a() {
        super.a();
        this.f22690c = true;
        a aVar = this.f22692e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b() {
        super.b();
        a aVar = this.f22692e;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void c() {
        super.c();
        a aVar = this.f22692e;
        if (aVar != null) {
            aVar.c();
        }
    }
}
