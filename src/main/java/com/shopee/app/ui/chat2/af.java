package com.shopee.app.ui.chat2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.h.q;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.z;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class af extends LinearLayout {
    private static CharSequence[] o = new CharSequence[1];

    /* renamed from: a  reason: collision with root package name */
    ListView f20267a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20268b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.app.ui.setting.cell.a f20269c;

    /* renamed from: d  reason: collision with root package name */
    View f20270d;

    /* renamed from: e  reason: collision with root package name */
    r f20271e;

    /* renamed from: f  reason: collision with root package name */
    bc f20272f;

    /* renamed from: g  reason: collision with root package name */
    ad f20273g;
    SettingConfigStore h;
    Activity i;
    ak j;
    b k;
    List<aj> l = new ArrayList();
    /* access modifiers changed from: private */
    public int m = -1;
    private View.OnClickListener n = new View.OnClickListener() {
        public void onClick(View view) {
            af.this.f20273g.a(af.this.f20269c.c());
        }
    };
    private a.c p = new a.c() {
        public void a(f fVar, View view, int i, CharSequence charSequence) {
            if (i == 0 && !com.shopee.app.util.af.a(af.this.l) && af.this.m >= 0) {
                af.this.f20273g.b(af.this.m);
            }
            fVar.dismiss();
        }
    };

    public interface a {
        void a(af afVar);
    }

    public af(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20272f.a(this.f20273g);
        this.f20273g.a(this);
        this.k = new b();
        ((ViewGroup) this.f20268b.getParent()).removeView(this.f20268b);
        this.f20268b.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        this.f20267a.addFooterView(this.f20268b);
        this.f20267a.setAdapter(this.k);
        this.f20273g.e();
    }

    /* access modifiers changed from: package-private */
    public void a(aj ajVar) {
        if (ajVar == null) {
            return;
        }
        if (TextUtils.isEmpty(ajVar.f20279b)) {
            b();
        } else {
            a(ajVar.f20278a, ajVar.f20279b);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(aj ajVar) {
        if (!TextUtils.isEmpty(ajVar.f20279b)) {
            this.m = ajVar.f20278a;
            com.shopee.app.ui.dialog.a.a(getContext(), o, this.p);
        }
    }

    public void a(boolean z, List<aj> list) {
        this.f20269c.setOnClickListener((View.OnClickListener) null);
        this.f20269c.setChecked(z);
        this.f20269c.setOnClickListener(this.n);
        int chatShortcutCount = this.h.chatShortcutCount();
        this.f20268b.setText(com.garena.android.appkit.tools.b.a(R.string.sp_message_shortcut_limit_X, String.valueOf(chatShortcutCount)));
        if (z) {
            this.l = list;
            this.f20268b.setVisibility(0);
            this.f20267a.setVisibility(0);
            this.f20270d.setVisibility(0);
            this.k.a(this.l);
            this.k.notifyDataSetChanged();
            return;
        }
        this.f20268b.setVisibility(8);
        this.f20267a.setVisibility(8);
        this.f20270d.setVisibility(8);
    }

    public void a(int i2, String str) {
        this.j.c(i2, str);
    }

    public void b() {
        this.j.ap();
    }

    public void c() {
        this.f20271e.a();
    }

    public void d() {
        this.f20271e.b();
    }

    public void a(String str) {
        com.shopee.app.h.r.a().a(str);
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    static {
        o[0] = com.garena.android.appkit.tools.b.e(R.string.sp_label_delete);
    }

    private static class b extends z<aj> {
        private b() {
        }

        /* access modifiers changed from: protected */
        public n<aj> a(Context context, int i) {
            return ac.a(context);
        }
    }
}
