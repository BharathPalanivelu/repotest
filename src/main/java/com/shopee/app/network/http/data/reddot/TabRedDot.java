package com.shopee.app.network.http.data.reddot;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;

public final class TabRedDot {
    @c(a = "timestamp")
    private final int creationTime;
    @c(a = "noti_code")
    private final int notiCode;

    public static /* synthetic */ TabRedDot copy$default(TabRedDot tabRedDot, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tabRedDot.notiCode;
        }
        if ((i3 & 2) != 0) {
            i2 = tabRedDot.creationTime;
        }
        return tabRedDot.copy(i, i2);
    }

    public final int component1() {
        return this.notiCode;
    }

    public final int component2() {
        return this.creationTime;
    }

    public final TabRedDot copy(int i, int i2) {
        return new TabRedDot(i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TabRedDot) {
                TabRedDot tabRedDot = (TabRedDot) obj;
                if (this.notiCode == tabRedDot.notiCode) {
                    if (this.creationTime == tabRedDot.creationTime) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Integer.valueOf(this.notiCode).hashCode() * 31) + Integer.valueOf(this.creationTime).hashCode();
    }

    public String toString() {
        return "TabRedDot(notiCode=" + this.notiCode + ", creationTime=" + this.creationTime + SQLBuilder.PARENTHESES_RIGHT;
    }

    public TabRedDot(int i, int i2) {
        this.notiCode = i;
        this.creationTime = i2;
    }

    public final int getNotiCode() {
        return this.notiCode;
    }

    public final int getCreationTime() {
        return this.creationTime;
    }
}
