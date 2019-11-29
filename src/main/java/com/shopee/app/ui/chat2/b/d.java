package com.shopee.app.ui.chat2.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.app.ui.chat2.b.b;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.w;
import java.util.List;

public class d extends LinearLayout implements b.a {

    /* renamed from: a  reason: collision with root package name */
    bi f20292a;

    /* renamed from: b  reason: collision with root package name */
    ViewPager f20293b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f20294c;

    /* renamed from: d  reason: collision with root package name */
    TabLayout f20295d;

    /* renamed from: e  reason: collision with root package name */
    private List<StickerPack> f20296e;

    /* renamed from: f  reason: collision with root package name */
    private b f20297f;

    public interface a {
        void a(d dVar);
    }

    public d(Context context) {
        super(context);
    }

    public void a(List<StickerPack> list) {
        this.f20296e = list;
        this.f20297f.a(this.f20296e);
        this.f20297f.notifyDataSetChanged();
        b();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        ((a) ((x) getContext()).b()).a(this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        this.f20297f = new b();
        this.f20297f.a(this.f20296e);
        this.f20297f.a((b.a) this);
        this.f20293b.setAdapter(this.f20297f);
        this.f20295d.setupWithViewPager(this.f20293b);
    }

    private void b() {
        int tabCount = this.f20295d.getTabCount();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp24);
        if (tabCount <= 1) {
            this.f20294c.setVisibility(8);
            return;
        }
        this.f20294c.setVisibility(0);
        for (int i = 0; i < tabCount; i++) {
            TabLayout.f a2 = this.f20295d.a(i);
            if (a2 != null) {
                View inflate = inflate(getContext(), R.layout.sticker_tab_layout, (ViewGroup) null);
                w.a(inflate.getContext()).a(this.f20296e.get(i).getPack().a()).b(dimensionPixelSize, dimensionPixelSize).a((ImageView) inflate.findViewById(R.id.iv_sticker));
                a2.a(inflate);
            }
        }
    }

    public void a(com.garena.sticker.e.b bVar) {
        this.f20292a.a().r.a(bVar).a();
    }

    public void a(String str) {
        this.f20292a.a().m.a(str).a();
    }
}
