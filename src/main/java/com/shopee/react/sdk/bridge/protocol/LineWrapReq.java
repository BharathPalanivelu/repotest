package com.shopee.react.sdk.bridge.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;

public final class LineWrapReq {
    private final int num;

    public static /* synthetic */ LineWrapReq copy$default(LineWrapReq lineWrapReq, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = lineWrapReq.num;
        }
        return lineWrapReq.copy(i);
    }

    public final int component1() {
        return this.num;
    }

    public final LineWrapReq copy(int i) {
        return new LineWrapReq(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LineWrapReq) {
                if (this.num == ((LineWrapReq) obj).num) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.num;
    }

    public String toString() {
        return "LineWrapReq(num=" + this.num + SQLBuilder.PARENTHESES_RIGHT;
    }

    public LineWrapReq(int i) {
        this.num = i;
    }

    public final int getNum() {
        return this.num;
    }
}
