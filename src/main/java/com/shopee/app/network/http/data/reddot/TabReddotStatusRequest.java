package com.shopee.app.network.http.data.reddot;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import java.util.List;

public final class TabReddotStatusRequest {
    @c(a = "reddots")
    private final List<TabRedDot> redDots;

    public static /* synthetic */ TabReddotStatusRequest copy$default(TabReddotStatusRequest tabReddotStatusRequest, List<TabRedDot> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tabReddotStatusRequest.redDots;
        }
        return tabReddotStatusRequest.copy(list);
    }

    public final List<TabRedDot> component1() {
        return this.redDots;
    }

    public final TabReddotStatusRequest copy(List<TabRedDot> list) {
        j.b(list, "redDots");
        return new TabReddotStatusRequest(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TabReddotStatusRequest) && j.a((Object) this.redDots, (Object) ((TabReddotStatusRequest) obj).redDots);
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
        return "TabReddotStatusRequest(redDots=" + this.redDots + SQLBuilder.PARENTHESES_RIGHT;
    }

    public TabReddotStatusRequest(List<TabRedDot> list) {
        j.b(list, "redDots");
        this.redDots = list;
    }

    public final List<TabRedDot> getRedDots() {
        return this.redDots;
    }
}
