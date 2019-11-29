package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.FriendPendencyItemVec;
import com.tencent.imcore.FriendPendencyResult;
import java.util.ArrayList;
import java.util.List;

public class TIMGetFriendPendencyListSucc {
    private TIMFriendPendencyMeta meta;
    private List<TIMFriendPendencyItem> pendencies;

    TIMGetFriendPendencyListSucc(FriendPendencyResult friendPendencyResult) {
        if (friendPendencyResult != null) {
            setMeta(new TIMFriendPendencyMeta(friendPendencyResult.getMeta()));
            FriendPendencyItemVec pendencies2 = friendPendencyResult.getPendencies();
            ArrayList arrayList = new ArrayList();
            int size = (int) pendencies2.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new TIMFriendPendencyItem(pendencies2.get(i)));
            }
            setPendencies(arrayList);
        }
    }

    public TIMFriendPendencyMeta getMeta() {
        return this.meta;
    }

    public List<TIMFriendPendencyItem> getPendencies() {
        return this.pendencies;
    }

    /* access modifiers changed from: package-private */
    public void setMeta(TIMFriendPendencyMeta tIMFriendPendencyMeta) {
        this.meta = tIMFriendPendencyMeta;
    }

    /* access modifiers changed from: package-private */
    public void setPendencies(List<TIMFriendPendencyItem> list) {
        this.pendencies = list;
    }
}
