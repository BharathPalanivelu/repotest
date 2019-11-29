package com.shopee.app.network.http.data.reddot;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import java.util.List;

public final class TabRedDotStatusData {
    @c(a = "reddots")
    private final List<TabRedDot> redDots;

    public static /* synthetic */ TabRedDotStatusData copy$default(TabRedDotStatusData tabRedDotStatusData, List<TabRedDot> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tabRedDotStatusData.redDots;
        }
        return tabRedDotStatusData.copy(list);
    }

    public final List<TabRedDot> component1() {
        return this.redDots;
    }

    public final TabRedDotStatusData copy(List<TabRedDot> list) {
        j.b(list, "redDots");
        return new TabRedDotStatusData(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TabRedDotStatusData) && j.a((Object) this.redDots, (Object) ((TabRedDotStatusData) obj).redDots);
        }
        return true;
    }

    public int hashCode() {
        List<TabRedDot> list = this.redDots;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "TabRedDotStatusData(redDots=" + this.redDots + SQLBuilder.PARENTHESES_RIGHT;
    }

    public TabRedDotStatusData(List<TabRedDot> list) {
        j.b(list, "redDots");
        this.redDots = list;
    }

    public final List<TabRedDot> getRedDots() {
        return this.redDots;
    }
}
