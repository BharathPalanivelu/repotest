package com.shopee.app.web.protocol;

import com.google.a.l;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class SharingDataMessage {
    private final String sharingAppID;
    private final l sharingData;

    public static /* synthetic */ SharingDataMessage copy$default(SharingDataMessage sharingDataMessage, String str, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharingDataMessage.sharingAppID;
        }
        if ((i & 2) != 0) {
            lVar = sharingDataMessage.sharingData;
        }
        return sharingDataMessage.copy(str, lVar);
    }

    public final String component1() {
        return this.sharingAppID;
    }

    public final l component2() {
        return this.sharingData;
    }

    public final SharingDataMessage copy(String str, l lVar) {
        return new SharingDataMessage(str, lVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SharingDataMessage)) {
            return false;
        }
        SharingDataMessage sharingDataMessage = (SharingDataMessage) obj;
        return j.a((Object) this.sharingAppID, (Object) sharingDataMessage.sharingAppID) && j.a((Object) this.sharingData, (Object) sharingDataMessage.sharingData);
    }

    public int hashCode() {
        String str = this.sharingAppID;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        l lVar = this.sharingData;
        if (lVar != null) {
            i = lVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SharingDataMessage(sharingAppID=" + this.sharingAppID + ", sharingData=" + this.sharingData + SQLBuilder.PARENTHESES_RIGHT;
    }

    public SharingDataMessage(String str, l lVar) {
        this.sharingAppID = str;
        this.sharingData = lVar;
    }

    public final String getSharingAppID() {
        return this.sharingAppID;
    }

    public final l getSharingData() {
        return this.sharingData;
    }
}
