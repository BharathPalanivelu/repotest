package com.shopee.app.ui.home.me.control;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class MeControlView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    a f22283a;

    /* renamed from: b  reason: collision with root package name */
    bc f22284b;

    /* renamed from: c  reason: collision with root package name */
    RegionConfig f22285c;

    /* renamed from: d  reason: collision with root package name */
    MeCounter f22286d;

    /* renamed from: e  reason: collision with root package name */
    SettingConfigStore f22287e;

    public interface a {
        void a(MeControlView meControlView);
    }

    public MeControlView(Context context) {
        super(context);
        a(context);
    }

    public MeControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        if (!isInEditMode()) {
            ((a) ((x) context).b()).a(this);
            setOrientation(1);
            setBackgroundColor(b.a(R.color.white));
            this.f22284b.a(this.f22283a);
            this.f22283a.a(this);
        }
    }
}
