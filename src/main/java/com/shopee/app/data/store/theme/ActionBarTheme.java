package com.shopee.app.data.store.theme;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import d.h.m;

public final class ActionBarTheme {
    @c(a = "color")
    private final String color;
    @c(a = "background_image_long")
    private final String longBg;
    @c(a = "background_image_standard")
    private final String standardBg;

    public ActionBarTheme() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    private final String component1() {
        return this.standardBg;
    }

    private final String component2() {
        return this.longBg;
    }

    private final String component3() {
        return this.color;
    }

    public static /* synthetic */ ActionBarTheme copy$default(ActionBarTheme actionBarTheme, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionBarTheme.standardBg;
        }
        if ((i & 2) != 0) {
            str2 = actionBarTheme.longBg;
        }
        if ((i & 4) != 0) {
            str3 = actionBarTheme.color;
        }
        return actionBarTheme.copy(str, str2, str3);
    }

    public final ActionBarTheme copy(String str, String str2, String str3) {
        return new ActionBarTheme(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionBarTheme)) {
            return false;
        }
        ActionBarTheme actionBarTheme = (ActionBarTheme) obj;
        return j.a((Object) this.standardBg, (Object) actionBarTheme.standardBg) && j.a((Object) this.longBg, (Object) actionBarTheme.longBg) && j.a((Object) this.color, (Object) actionBarTheme.color);
    }

    public int hashCode() {
        String str = this.standardBg;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.longBg;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.color;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ActionBarTheme(standardBg=" + this.standardBg + ", longBg=" + this.longBg + ", color=" + this.color + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ActionBarTheme(String str, String str2, String str3) {
        this.standardBg = str;
        this.longBg = str2;
        this.color = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionBarTheme(String str, String str2, String str3, int i, g gVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getFullStandardBgUrl() {
        CharSequence charSequence = this.standardBg;
        if (charSequence == null || m.a(charSequence)) {
            return "";
        }
        return "http://cf.shopee.co.id/file/" + this.standardBg;
    }

    public final String getLongBg() {
        String str = this.longBg;
        return str != null ? str : "";
    }

    public final int getThemeType() {
        String str = this.color;
        return (str != null && str.hashCode() == 113101865 && str.equals("white")) ? 1 : 0;
    }
}
