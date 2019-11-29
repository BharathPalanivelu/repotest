package com.shopee.app.react.modules.app.data;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.data.store.theme.ActionBarTheme;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.util.n;
import d.d.b.j;

public final class l implements i {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final a f18759a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private final ThemeStore f18760b;

    /* renamed from: c  reason: collision with root package name */
    private final n f18761c;

    public l(ThemeStore themeStore, n nVar) {
        j.b(themeStore, "store");
        j.b(nVar, "eventBus");
        this.f18760b = themeStore;
        this.f18761c = nVar;
    }

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public boolean a(String str) {
        return j.a((Object) str, (Object) "campaignNavBarTheme");
    }

    public String c(String str) {
        if (str == null) {
            return ServiceLogger.PLACEHOLDER;
        }
        try {
            ActionBarTheme actionBarTheme = (ActionBarTheme) com.shopee.web.sdk.bridge.internal.a.f30470a.a(str, ActionBarTheme.class);
            if (actionBarTheme == null) {
                return ServiceLogger.PLACEHOLDER;
            }
            this.f18760b.setActionBarTheme(actionBarTheme);
            this.f18761c.a().bI.a(actionBarTheme).a();
            return ServiceLogger.PLACEHOLDER;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return ServiceLogger.PLACEHOLDER;
        }
    }
}
