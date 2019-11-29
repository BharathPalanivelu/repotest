package com.shopee.app.ui.chat2.block;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.g.d;
import com.shopee.app.h.q;
import com.shopee.app.ui.a.y;
import com.shopee.app.ui.chat2.block.c;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class l extends FrameLayout implements c.a {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20340a;

    /* renamed from: b  reason: collision with root package name */
    View f20341b;

    /* renamed from: c  reason: collision with root package name */
    bc f20342c;

    /* renamed from: d  reason: collision with root package name */
    i f20343d;

    /* renamed from: e  reason: collision with root package name */
    r f20344e;

    /* renamed from: f  reason: collision with root package name */
    Activity f20345f;

    /* renamed from: g  reason: collision with root package name */
    private a f20346g;

    public l(Context context) {
        super(context);
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20342c.a(this.f20343d);
        this.f20343d.a(this);
        this.f20346g = new a(new k());
        d.a(this.f20340a, this.f20341b, this.f20346g);
        this.f20340a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20340a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f20340a.setAdapter(this.f20346g);
        this.f20346g.a(new ArrayList());
        this.f20346g.notifyDataSetChanged();
        this.f20343d.f();
    }

    public void x_() {
        this.f20344e.a();
    }

    public void d() {
        this.f20344e.b();
    }

    public void a(List<UserBriefInfo> list) {
        this.f20346g.a(list);
        this.f20346g.notifyItemRangeChanged(0, list.size());
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    public void c(String str) {
        com.shopee.app.ui.dialog.a.a(getContext(), str, "", b.e(R.string.button_ok), (a.C0318a) null);
    }

    private static class a extends y<UserBriefInfo> {
        public a(com.shopee.app.ui.a.s<UserBriefInfo> sVar) {
            super(sVar);
        }
    }
}
