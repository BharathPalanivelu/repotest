package com.tencent.cos.xml.common;

public class VersionInfo {
    public static final String platform = "cos-android-sdk-5.4.10";
    public static final int version = 50410;

    public static String getUserAgent() {
        return platform;
    }
}
