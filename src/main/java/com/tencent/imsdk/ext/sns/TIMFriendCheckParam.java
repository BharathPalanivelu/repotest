package com.tencent.imsdk.ext.sns;

import java.util.List;

public class TIMFriendCheckParam {
    boolean bidirection = true;
    List<String> identifiers;

    /* access modifiers changed from: package-private */
    public List<String> getIdentifiers() {
        return this.identifiers;
    }

    /* access modifiers changed from: package-private */
    public boolean isBidirection() {
        return this.bidirection;
    }

    public void setBidirection(boolean z) {
        this.bidirection = z;
    }

    public void setIdentifiers(List<String> list) {
        this.identifiers = list;
    }
}
