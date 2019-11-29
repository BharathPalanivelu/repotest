package com.tencent.imsdk.ext.group;

import com.tencent.imcore.GroupPendencyItemVec;
import com.tencent.imcore.GroupPendencyResult;
import java.util.ArrayList;
import java.util.List;

public class TIMGroupPendencyListGetSucc {
    private String identifer;
    private TIMGroupPendencyMeta meta;
    private List<TIMGroupPendencyItem> pendencies = new ArrayList();

    TIMGroupPendencyListGetSucc(String str, GroupPendencyResult groupPendencyResult) {
        this.identifer = str;
        this.meta = new TIMGroupPendencyMeta(groupPendencyResult.getMeta());
        GroupPendencyItemVec items = groupPendencyResult.getItems();
        for (int i = 0; ((long) i) < items.size(); i++) {
            this.pendencies.add(new TIMGroupPendencyItem(str, items.get(i)));
        }
    }

    public List<TIMGroupPendencyItem> getPendencies() {
        return this.pendencies;
    }

    public TIMGroupPendencyMeta getPendencyMeta() {
        return this.meta;
    }
}
