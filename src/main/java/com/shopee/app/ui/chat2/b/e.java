package com.shopee.app.ui.chat2.b;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f20298e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f20299f = new c();

    public e(Context context) {
        super(context);
        b();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f20298e) {
            this.f20298e = true;
            inflate(getContext(), R.layout.chat_stickers_layout, this);
            this.f20299f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20299f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20293b = (ViewPager) aVar.internalFindViewById(R.id.viewPager);
        this.f20294c = (LinearLayout) aVar.internalFindViewById(R.id.tabContainer);
        this.f20295d = (TabLayout) aVar.internalFindViewById(R.id.tabLayout);
        a();
    }
}
