package com.shopee.app.ui.setting.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoButton;
import com.google.a.o;
import com.shopee.app.data.store.theme.ThemeConfig;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import java.util.ArrayList;
import java.util.List;

public class j extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    ThemeStore f25141a;

    /* renamed from: b  reason: collision with root package name */
    ak f25142b;

    /* renamed from: c  reason: collision with root package name */
    r f25143c;

    /* renamed from: d  reason: collision with root package name */
    RobotoButton f25144d;

    /* renamed from: e  reason: collision with root package name */
    RobotoButton f25145e;

    /* renamed from: f  reason: collision with root package name */
    LinearLayout f25146f;

    /* renamed from: g  reason: collision with root package name */
    private List<i> f25147g;

    public j(Context context) {
        super(context);
        ((m) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        d();
    }

    private void d() {
        this.f25147g = new ArrayList();
        for (ThemeConfig.ThemeTextItem next : ((ThemeConfig.ThemeText) this.f25141a.getConfig().getRaw().first).data) {
            o json = next.toJson();
            i iVar = new i(getContext());
            iVar.setOnClickListener(this);
            iVar.setTitleViewText(json);
            iVar.setContentViewText(json);
            iVar.setStartTime(json);
            iVar.setSelected(this.f25141a.getForceSelected() == next.toJson().c("start_time").f());
            this.f25147g.add(iVar);
            this.f25146f.addView(iVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f25141a.setForceSelected(-1);
        this.f25141a.fetchThemeConfig();
        this.f25143c.a();
        for (i selected : this.f25147g) {
            selected.setSelected(false);
        }
        postDelayed(new Runnable() {
            public void run() {
                j.this.f25143c.b();
                j.this.f25142b.w();
            }
        }, 2000);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        long j = -1;
        for (i next : this.f25147g) {
            if (next.isSelected()) {
                j = next.getStartTime();
            }
        }
        this.f25141a.setForceSelected(j);
        this.f25142b.w();
    }

    public void onClick(View view) {
        for (i next : this.f25147g) {
            if (next != view || next.isSelected()) {
                next.setSelected(false);
            } else {
                next.setSelected(true);
            }
        }
    }
}
