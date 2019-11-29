package com.shopee.app.data.viewmodel;

import com.litesuits.orm.db.assit.SQLBuilder;

public final class RedDotData {
    private final int currentCreationTime;
    private final int lastDismissDotCreationTime;

    public RedDotData() {
        this(0, 0, 3, (g) null);
    }

    public static /* synthetic */ RedDotData copy$default(RedDotData redDotData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = redDotData.lastDismissDotCreationTime;
        }
        if ((i3 & 2) != 0) {
            i2 = redDotData.currentCreationTime;
        }
        return redDotData.copy(i, i2);
    }

    public final int component1() {
        return this.lastDismissDotCreationTime;
    }

    public final int component2() {
        return this.currentCreationTime;
    }

    public final RedDotData copy(int i, int i2) {
        return new RedDotData(i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RedDotData) {
                RedDotData redDotData = (RedDotData) obj;
                if (this.lastDismissDotCreationTime == redDotData.lastDismissDotCreationTime) {
                    if (this.currentCreationTime == redDotData.currentCreationTime) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Integer.valueOf(this.lastDismissDotCreationTime).hashCode() * 31) + Integer.valueOf(this.currentCreationTime).hashCode();
    }

    public String toString() {
        return "RedDotData(lastDismissDotCreationTime=" + this.lastDismissDotCreationTime + ", currentCreationTime=" + this.currentCreationTime + SQLBuilder.PARENTHESES_RIGHT;
    }

    public RedDotData(int i, int i2) {
        this.lastDismissDotCreationTime = i;
        this.currentCreationTime = i2;
    }

    public final int getLastDismissDotCreationTime() {
        return this.lastDismissDotCreationTime;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedDotData(int i, int i2, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getCurrentCreationTime() {
        return this.currentCreationTime;
    }

    public final boolean isShowing() {
        return this.currentCreationTime > 0;
    }

    public final boolean isNewData(int i) {
        return i > this.currentCreationTime && i > this.lastDismissDotCreationTime;
    }
}
