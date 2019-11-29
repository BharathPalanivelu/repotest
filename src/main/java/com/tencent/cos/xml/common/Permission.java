package com.tencent.cos.xml.common;

public enum Permission {
    READ("READ"),
    WRITE("WRITE"),
    FULL_CONTROL("FULL_CONTROL");
    
    private String permission;

    private Permission(String str) {
        this.permission = str;
    }

    public String getPermission() {
        return this.permission;
    }

    public static Permission fromValue(String str) {
        for (Permission permission2 : values()) {
            if (permission2.permission.equalsIgnoreCase(str)) {
                return permission2;
            }
        }
        return null;
    }
}
