package com.shopee.app.data.store.theme;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.tools.a.a;
import com.google.a.o;
import com.shopee.app.util.af;
import com.shopee.app.web.WebRegister;
import java.util.HashMap;
import java.util.List;

public class ThemeConfig {
    private ThemeText animation_text;
    private ThemeText animation_text_livestream;
    private ThemeTab tab_bar;

    public static class TabContentItem {
        private HashMap<String, String> image;
        private HashMap<String, String> text;
    }

    public static class ThemeTabItem {
        /* access modifiers changed from: private */
        public long end_time;
        /* access modifiers changed from: private */
        public long start_time;
        private HashMap<String, TabContentItem> tabs;
    }

    public static class ThemeText {
        public List<ThemeTextItem> data;
    }

    public ThemeTextItem getCurrentAnimationText(String str) {
        ThemeText themeTextForTab = getThemeTextForTab(str);
        if (themeTextForTab != null && !af.a(themeTextForTab.data)) {
            int a2 = a.a();
            for (ThemeTextItem next : themeTextForTab.data) {
                long j = (long) a2;
                if (next.start_time <= j && next.end_time > j) {
                    return next;
                }
            }
        }
        return null;
    }

    public ThemeTabItem getCurrentTabTheme() {
        ThemeTab themeTab = this.tab_bar;
        if (themeTab != null && !af.a(themeTab.data)) {
            int a2 = a.a();
            for (ThemeTabItem themeTabItem : this.tab_bar.data) {
                long j = (long) a2;
                if (themeTabItem.start_time <= j && themeTabItem.end_time > j) {
                    return themeTabItem;
                }
            }
        }
        return null;
    }

    public Pair<ThemeText, ThemeTab> getRaw() {
        return new Pair<>(this.animation_text, this.tab_bar);
    }

    public ThemeTextItem findAnimText(long j) {
        ThemeText themeText = this.animation_text;
        if (themeText != null && !af.a(themeText.data)) {
            for (ThemeTextItem next : this.animation_text.data) {
                if (next.start_time == j) {
                    return next;
                }
            }
        }
        return null;
    }

    private ThemeText getThemeTextForTab(String str) {
        if (com.shopee.app.ui.home.a.TAB_MALL_RN.getId().equals(str)) {
            return this.animation_text;
        }
        if (com.shopee.app.ui.home.a.TAB_LIVE_STREAMING.getId().equals(str)) {
            return this.animation_text_livestream;
        }
        return null;
    }

    public static class ThemeTextItem {
        /* access modifiers changed from: private */
        public long end_time;
        /* access modifiers changed from: private */
        public long start_time;
        private HashMap<String, String> text;

        public String getText(String str) {
            HashMap<String, String> hashMap = this.text;
            if (hashMap == null) {
                return null;
            }
            if (hashMap.containsKey(str) && !TextUtils.isEmpty(this.text.get(str))) {
                return this.text.get(str);
            }
            if (this.text.containsKey("en")) {
                return this.text.get("en");
            }
            return null;
        }

        public o toJson() {
            return WebRegister.GSON.a((Object) this).m();
        }
    }

    private static class ThemeTab {
        /* access modifiers changed from: private */
        public List<ThemeTabItem> data;

        private ThemeTab() {
        }
    }
}
