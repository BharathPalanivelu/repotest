package com.shopee.app.data.store.theme;

import android.content.SharedPreferences;
import c.a.a.a.c;
import com.beetalklib.a.a.b;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.data.store.ay;
import com.shopee.app.data.store.theme.ThemeConfig;
import com.shopee.app.h.a.e;
import com.shopee.app.util.ad;
import com.shopee.app.util.l;
import com.shopee.app.web.WebRegister;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeStore extends ay {
    private ActionBarTheme mActionBarTheme = new ActionBarTheme();
    private b mDownloadCallback = new e() {
        /* access modifiers changed from: protected */
        public void onJSonObject(JSONObject jSONObject) throws JSONException {
            ThemeStore.this.mThemeConfig.a((ThemeConfig) WebRegister.GSON.a(jSONObject.toString(), new a<ThemeConfig>() {
            }.getType()));
            ThemeStore.this.mTimestamp.a(com.garena.android.appkit.tools.a.a.a());
        }
    };
    private c mForceSelected;
    /* access modifiers changed from: private */
    public ad<ThemeConfig> mThemeConfig;
    /* access modifiers changed from: private */
    public c.a.a.a.b mTimestamp;

    public ThemeStore(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.mThemeConfig = new ad<>(sharedPreferences, "app_remote_theme", ServiceLogger.PLACEHOLDER, new a<ThemeConfig>() {
        });
        this.mTimestamp = new c.a.a.a.b(sharedPreferences, "last_update_timestamp");
        this.mForceSelected = new c(sharedPreferences, "forbidden_zone_force_selected");
        checkDownload();
    }

    private void checkDownload() {
        if (com.garena.android.appkit.tools.a.a.a() - this.mTimestamp.a() > 3600) {
            fetchThemeConfig();
        }
    }

    public void fetchThemeConfig() {
        com.shopee.app.h.a.a.a().a(l.q, "ThemeConfigStore", this.mDownloadCallback);
    }

    public ThemeConfig.ThemeTextItem getAnimationText(String str) {
        return this.mThemeConfig.a().getCurrentAnimationText(str);
    }

    public ThemeConfig.ThemeTabItem getTabTheme() {
        return this.mThemeConfig.a().getCurrentTabTheme();
    }

    public void setForceSelected(long j) {
        this.mForceSelected.a(j);
    }

    public long getForceSelected() {
        return this.mForceSelected.a();
    }

    public ThemeConfig getConfig() {
        return this.mThemeConfig.a();
    }

    public ActionBarTheme getActionBarTheme() {
        return this.mActionBarTheme;
    }

    public void setActionBarTheme(ActionBarTheme actionBarTheme) {
        this.mActionBarTheme = actionBarTheme;
    }
}
