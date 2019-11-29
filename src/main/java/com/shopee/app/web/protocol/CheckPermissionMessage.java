package com.shopee.app.web.protocol;

import java.util.List;

public class CheckPermissionMessage {
    public final List<String> permissionList;

    public CheckPermissionMessage(List<String> list) {
        this.permissionList = list;
    }
}
