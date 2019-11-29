package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import java.util.List;

public final class DataPointBridgeMessage {
    private final List<String> contentTypes;

    public static /* synthetic */ DataPointBridgeMessage copy$default(DataPointBridgeMessage dataPointBridgeMessage, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = dataPointBridgeMessage.contentTypes;
        }
        return dataPointBridgeMessage.copy(list);
    }

    public final List<String> component1() {
        return this.contentTypes;
    }

    public final DataPointBridgeMessage copy(List<String> list) {
        return new DataPointBridgeMessage(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DataPointBridgeMessage) && j.a((Object) this.contentTypes, (Object) ((DataPointBridgeMessage) obj).contentTypes);
        }
        return true;
    }

    public int hashCode() {
        List<String> list = this.contentTypes;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "DataPointBridgeMessage(contentTypes=" + this.contentTypes + SQLBuilder.PARENTHESES_RIGHT;
    }

    public DataPointBridgeMessage(List<String> list) {
        this.contentTypes = list;
    }

    public final List<String> getContentTypes() {
        return this.contentTypes;
    }
}
