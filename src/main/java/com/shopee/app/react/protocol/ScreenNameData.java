package com.shopee.app.react.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class ScreenNameData {
    private final String name;

    public static /* synthetic */ ScreenNameData copy$default(ScreenNameData screenNameData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = screenNameData.name;
        }
        return screenNameData.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final ScreenNameData copy(String str) {
        j.b(str, "name");
        return new ScreenNameData(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ScreenNameData) && j.a((Object) this.name, (Object) ((ScreenNameData) obj).name);
        }
        return true;
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ScreenNameData(name=" + this.name + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ScreenNameData(String str) {
        j.b(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
