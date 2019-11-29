package com.shopee.web.sdk.bridge.protocol.permissions;

import java.util.List;

public class CheckPermissionRequest {
    private final List<String> permissionList;

    public CheckPermissionRequest(List<String> list) {
        this.permissionList = list;
    }

    public List<String> getPermissionList() {
        return this.permissionList;
    }
}
