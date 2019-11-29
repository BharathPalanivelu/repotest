package com.shopee.app.ui.datapoint.data;

import com.google.a.l;
import com.google.a.o;
import com.google.a.q;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.web.WebRegister;
import d.d.b.j;

public final class CollectDataEvent {
    private final String contentType;
    private final Object data;
    private final int error;
    private final String errorMessage;

    public static /* synthetic */ CollectDataEvent copy$default(CollectDataEvent collectDataEvent, String str, int i, String str2, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = collectDataEvent.contentType;
        }
        if ((i2 & 2) != 0) {
            i = collectDataEvent.error;
        }
        if ((i2 & 4) != 0) {
            str2 = collectDataEvent.errorMessage;
        }
        if ((i2 & 8) != 0) {
            obj = collectDataEvent.data;
        }
        return collectDataEvent.copy(str, i, str2, obj);
    }

    public final String component1() {
        return this.contentType;
    }

    public final int component2() {
        return this.error;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final Object component4() {
        return this.data;
    }

    public final CollectDataEvent copy(String str, int i, String str2, Object obj) {
        j.b(str, "contentType");
        return new CollectDataEvent(str, i, str2, obj);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CollectDataEvent) {
                CollectDataEvent collectDataEvent = (CollectDataEvent) obj;
                if (j.a((Object) this.contentType, (Object) collectDataEvent.contentType)) {
                    if (!(this.error == collectDataEvent.error) || !j.a((Object) this.errorMessage, (Object) collectDataEvent.errorMessage) || !j.a(this.data, collectDataEvent.data)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.contentType;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.error).hashCode()) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.data;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CollectDataEvent(contentType=" + this.contentType + ", error=" + this.error + ", errorMessage=" + this.errorMessage + ", data=" + this.data + SQLBuilder.PARENTHESES_RIGHT;
    }

    public CollectDataEvent(String str, int i, String str2, Object obj) {
        j.b(str, "contentType");
        this.contentType = str;
        this.error = i;
        this.errorMessage = str2;
        this.data = obj;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final Object getData() {
        return this.data;
    }

    public final int getError() {
        return this.error;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final o getJson() {
        l a2 = new q().a(WebRegister.GSON.b((Object) this));
        j.a((Object) a2, "JsonParser().parse(WebRegister.GSON.toJson(this))");
        o m = a2.m();
        j.a((Object) m, "JsonParser().parse(WebRe…oJson(this)).asJsonObject");
        return m;
    }
}
