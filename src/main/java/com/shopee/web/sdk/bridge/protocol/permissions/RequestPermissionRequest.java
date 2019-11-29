package com.shopee.web.sdk.bridge.protocol.permissions;

import java.util.List;

public class RequestPermissionRequest {
    private final List<String> permissionList;
    private final String popupText;

    public RequestPermissionRequest(String str, List<String> list) {
        this.popupText = str;
        this.permissionList = list;
    }

    public String getPopupText() {
        return this.popupText;
    }

    public List<String> getPermissionList() {
        return this.permissionList;
    }
}
