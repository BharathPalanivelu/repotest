package com.tencent.imsdk;

public enum TIMMessageStatus {
    Invalid(0),
    Sending(1),
    SendSucc(2),
    SendFail(3),
    HasDeleted(4),
    LocalImported(5),
    HasRevoked(6);
    
    private int status;

    private TIMMessageStatus(int i) {
        this.status = 2;
        this.status = i;
    }

    public final int getStatus() {
        return this.status;
    }
}
