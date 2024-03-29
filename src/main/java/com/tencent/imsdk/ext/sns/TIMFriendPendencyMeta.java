package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.FriendPendencyMeta;

public class TIMFriendPendencyMeta {
    private long numPerPage;
    private long seq;
    private long timestamp;
    private long unReadCnt;

    public TIMFriendPendencyMeta() {
    }

    TIMFriendPendencyMeta(FriendPendencyMeta friendPendencyMeta) {
        setNumPerPage(friendPendencyMeta.getDdwNumPerPage());
        setSeq(friendPendencyMeta.getDdwSeq());
        setTimestamp(friendPendencyMeta.getDdwTimestamp());
        setUnReadCnt(friendPendencyMeta.getDdwUnReadCnt());
    }

    public long getNumPerPage() {
        return this.numPerPage;
    }

    public long getSeq() {
        return this.seq;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getUnReadCnt() {
        return this.unReadCnt;
    }

    public void setNumPerPage(long j) {
        this.numPerPage = j;
    }

    public void setSeq(long j) {
        this.seq = j;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    /* access modifiers changed from: package-private */
    public void setUnReadCnt(long j) {
        this.unReadCnt = j;
    }

    /* access modifiers changed from: package-private */
    public FriendPendencyMeta toFriendPendencyMeta() {
        FriendPendencyMeta friendPendencyMeta = new FriendPendencyMeta();
        friendPendencyMeta.setDdwNumPerPage(getNumPerPage());
        friendPendencyMeta.setDdwSeq(getSeq());
        friendPendencyMeta.setDdwTimestamp(getTimestamp());
        friendPendencyMeta.setDdwUnReadCnt(getUnReadCnt());
        return friendPendencyMeta;
    }
}
