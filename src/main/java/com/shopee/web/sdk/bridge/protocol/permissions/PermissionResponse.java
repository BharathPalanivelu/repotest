package com.shopee.web.sdk.bridge.protocol.permissions;

import java.util.Collections;
import java.util.List;

public class PermissionResponse {
    private final List<Boolean> resultList;
    private final int status;

    private PermissionResponse(int i, List<Boolean> list) {
        this.status = i;
        this.resultList = list;
    }

    public static PermissionResponse failure() {
        return new PermissionResponse(0, Collections.emptyList());
    }

    public static PermissionResponse success(List<Boolean> list) {
        return new PermissionResponse(1, list);
    }

    public int getStatus() {
        return this.status;
    }

    public List<Boolean> getResultList() {
        return this.resultList;
    }
}
