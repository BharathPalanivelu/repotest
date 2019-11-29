package com.shopee.react.sdk.bridge.protocol;

import com.shopee.navigator.b;
import java.util.List;

public class ReactPermissionResponse extends b {
    private final List<Boolean> resultList;

    public ReactPermissionResponse(List<Boolean> list) {
        this.resultList = list;
    }

    public List<Boolean> getResultList() {
        return this.resultList;
    }
}
