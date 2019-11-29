package com.shopee.app.d.c;

import android.text.TextUtils;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.theme.ThemeConfig;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.viewmodel.ToolTipHomeViewItem;
import com.shopee.app.ui.home.a;
import com.shopee.app.ui.home.l;
import com.shopee.app.util.n;

public class cr extends a {

    /* renamed from: c  reason: collision with root package name */
    private final bd f16714c;

    /* renamed from: d  reason: collision with root package name */
    private final ThemeStore f16715d;

    /* renamed from: e  reason: collision with root package name */
    private final SettingConfigStore f16716e;

    /* renamed from: f  reason: collision with root package name */
    private final aa f16717f;

    /* renamed from: g  reason: collision with root package name */
    private final l f16718g;

    /* access modifiers changed from: protected */
    public String d() {
        return "PrepareHomeViewToolTipItem";
    }

    protected cr(n nVar, l lVar, SettingConfigStore settingConfigStore, aa aaVar, ThemeStore themeStore, bd bdVar) {
        super(nVar);
        this.f16714c = bdVar;
        this.f16715d = themeStore;
        this.f16716e = settingConfigStore;
        this.f16717f = aaVar;
        this.f16718g = lVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        a c2 = this.f16718g.c(2);
        ThemeConfig.ThemeTextItem animationText = this.f16715d.getAnimationText(c2.getId());
        String text = animationText != null ? animationText.getText(this.f16717f.b()) : null;
        ToolTipHomeViewItem.ToolTipStyle toolTipStyle = ToolTipHomeViewItem.ToolTipStyle.ORANGE;
        if (c2 == a.TAB_MALL_RN) {
            toolTipStyle = ToolTipHomeViewItem.ToolTipStyle.RED;
        }
        if (!TextUtils.isEmpty(text)) {
            this.f16402a.a().aO.a(new ToolTipHomeViewItem(this.f16716e.showMallTabTooltip() && this.f16718g.c(), this.f16714c.a(), text, toolTipStyle)).a();
        }
    }
}
