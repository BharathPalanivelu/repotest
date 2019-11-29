package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.FriendFutureItemVec;
import com.tencent.imcore.FriendFutureResult;
import java.util.ArrayList;
import java.util.List;

public class TIMGetFriendFutureListSucc {
    private List<TIMFriendFutureItem> items;
    private TIMFriendFutureMeta meta;

    TIMGetFriendFutureListSucc(FriendFutureResult friendFutureResult) {
        if (friendFutureResult != null) {
            setMeta(new TIMFriendFutureMeta(friendFutureResult.getMeta()));
            ArrayList arrayList = new ArrayList();
            FriendFutureItemVec futures = friendFutureResult.getFutures();
            int size = (int) futures.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new TIMFriendFutureItem(futures.get(i)));
            }
            setItems(arrayList);
        }
    }

    public List<TIMFriendFutureItem> getItems() {
        return this.items;
    }

    public TIMFriendFutureMeta getMeta() {
        return this.meta;
    }

    /* access modifiers changed from: package-private */
    public void setItems(List<TIMFriendFutureItem> list) {
        this.items = list;
    }

    /* access modifiers changed from: package-private */
    public void setMeta(TIMFriendFutureMeta tIMFriendFutureMeta) {
        this.meta = tIMFriendFutureMeta;
    }
}
