package com.shopee.react.sdk.bridge.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.navigator.b;

public final class PrinterStatusEventData extends b {
    private final int statusCode;

    public static /* synthetic */ PrinterStatusEventData copy$default(PrinterStatusEventData printerStatusEventData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = printerStatusEventData.statusCode;
        }
        return printerStatusEventData.copy(i);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final PrinterStatusEventData copy(int i) {
        return new PrinterStatusEventData(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PrinterStatusEventData) {
                if (this.statusCode == ((PrinterStatusEventData) obj).statusCode) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.statusCode;
    }

    public String toString() {
        return "PrinterStatusEventData(statusCode=" + this.statusCode + SQLBuilder.PARENTHESES_RIGHT;
    }

    public PrinterStatusEventData(int i) {
        this.statusCode = i;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
