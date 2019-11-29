package com.garena.android.gpns.storage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class LocalStorage {
    public static final String ACK_MSG_LIST = "ACK_MSG_LIST";
    private static final String BEETALK_ID = "BEETALK_ID";
    private static final String CONNECTION_ADDRESS = "CONNECTION_ADDRESS";
    private static final String CONNECTION_ID = "CONNECTION_ID";
    private static final String DEVICE_ID = "DEVICE_ID";
    private static final String LAST_REGION_REFRESH_TIME = "LAST_REGION_REFRESH_TIME";
    private static final String REGIONAL_SERVER_ADDRESS = "REGIONAL_SERVER_ADDRESS";

    public static void saveConnectionId(long j) {
        SharedPreferenceStore.getInstance().putLong(CONNECTION_ID, j);
    }

    public static long getConnectionId() {
        return SharedPreferenceStore.getInstance().getLong(CONNECTION_ID, -1);
    }

    public static void saveConnectionAddress(String str) {
        SharedPreferenceStore.getInstance().putString(CONNECTION_ADDRESS, str);
    }

    public static String getConnectionAddress() {
        return SharedPreferenceStore.getInstance().getString(CONNECTION_ADDRESS, "");
    }

    private LocalStorage() {
    }

    public static long getDeviceId() {
        return SharedPreferenceStore.getInstance().getLong(DEVICE_ID, -1);
    }

    public static void setDeviceId(long j) {
        SharedPreferenceStore.getInstance().putLong(DEVICE_ID, j);
    }

    public static long getBeetalkId() {
        return SharedPreferenceStore.getInstance().getLong(BEETALK_ID, -1);
    }

    public static void setBeetalkId(long j) {
        SharedPreferenceStore.getInstance().putLong(BEETALK_ID, j);
    }

    public static List<Integer> getAcknowledgedMsgList() {
        ArrayList arrayList = new ArrayList();
        for (String str : SharedPreferenceStore.getInstance().getString(ACK_MSG_LIST, "").split(";")) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
        }
        return arrayList;
    }

    public static void putAcknowledgedMsgList(List<Integer> list) {
        StringBuilder sb = new StringBuilder("");
        for (Integer intValue : list) {
            sb.append(intValue.intValue());
            sb.append(";");
        }
        SharedPreferenceStore.getInstance().putString(ACK_MSG_LIST, sb.toString());
    }

    public static long getRegionRequestTime() {
        return SharedPreferenceStore.getInstance().getLong(LAST_REGION_REFRESH_TIME, 0);
    }

    public static void updateRegionRequestTime(long j) {
        SharedPreferenceStore.getInstance().putLong(LAST_REGION_REFRESH_TIME, j);
    }

    public static void setAuthServerAddress(String str) {
        SharedPreferenceStore.getInstance().putString(REGIONAL_SERVER_ADDRESS, str);
    }

    public static String getAuthServerAddress() {
        return SharedPreferenceStore.getInstance().getString(REGIONAL_SERVER_ADDRESS, "203.116.50.191:10086");
    }
}
