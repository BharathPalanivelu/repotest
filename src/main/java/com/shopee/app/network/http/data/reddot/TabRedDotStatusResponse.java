package com.shopee.app.network.http.data.reddot;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.network.http.data.BaseResponse;
import d.d.b.j;

public final class TabRedDotStatusResponse extends BaseResponse {
    @c(a = "data")
    private final TabRedDotStatusData data;

    public static /* synthetic */ TabRedDotStatusResponse copy$default(TabRedDotStatusResponse tabRedDotStatusResponse, TabRedDotStatusData tabRedDotStatusData, int i, Object obj) {
        if ((i & 1) != 0) {
            tabRedDotStatusData = tabRedDotStatusResponse.data;
        }
        return tabRedDotStatusResponse.copy(tabRedDotStatusData);
    }

    public final TabRedDotStatusData component1() {
        return this.data;
    }

    public final TabRedDotStatusResponse copy(TabRedDotStatusData tabRedDotStatusData) {
        j.b(tabRedDotStatusData, "data");
        return new TabRedDotStatusResponse(tabRedDotStatusData);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TabRedDotStatusResponse) && j.a((Object) this.data, (Object) ((TabRedDotStatusResponse) obj).data);
        }
        return true;
    }

    public int hashCode() {
        TabRedDotStatusData tabRedDotStatusData = this.data;
        if (tabRedDotStatusData != null) {
            return tabRedDotStatusData.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "TabRedDotStatusResponse(data=" + this.data + SQLBuilder.PARENTHESES_RIGHT;
    }

    public final TabRedDotStatusData getData() {
        return this.data;
    }

    public TabRedDotStatusResponse(TabRedDotStatusData tabRedDotStatusData) {
        j.b(tabRedDotStatusData, "data");
        this.data = tabRedDotStatusData;
    }
}
