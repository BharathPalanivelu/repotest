package com.shopee.app.web.protocol;

import java.util.List;

public class RequestPermissionMessage {
    public final List<String> permissionList;
    public final String popupText;

    public RequestPermissionMessage(List<String> list, String str) {
        this.permissionList = list;
        this.popupText = str;
    }
}
