package com.tencent.qalsdk.util;

import android.app.Application;
import java.util.ArrayList;

public abstract class BaseApplication extends Application {
    public static final String DATA_KEY_CHANNEL_ID = "channel_id";
    public static int appnewavmsgicon;
    public static int appnewmsgicon;
    static BaseApplication context;
    public static int defaultNotifSoundResourceId;
    public static int devlockQuickloginIcon;
    public static ArrayList<String> exclusiveStreamList = new ArrayList<>();
    public static int qqWifiConnecticon3;
    public static int qqWifiLayout;
    public static int qqWifiMissions;
    public static int qqWifiNoSignal;
    public static int qqWifiOperation;
    public static int qqWifiOperationTextViewId;
    public static int qqWifiRedTouchViewId;
    public static int qqWifiSettingViewId;
    public static int qqWifiSettings;
    public static int qqWifiStateIconViewId;
    public static int qqWifiStateTextSingleLine;
    public static int qqWifiStateTextViewId;
    public static int qqWifiTextDoubleLine;
    public static int qqWifiUserful;
    public static int qqlaunchicon;
    public static int qqwifinotifyconnectedicon;
    public static int qqwifinotifydivide;
    public static int qqwifinotifynoneicon;
    public static int qqwifinotifyusefulicon;
    public static int sAppLaunchSeq;
    public static long sAppLaunchTime;
    public static boolean sIsCleanInstall = false;

    public abstract Object getAppData(String str);

    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
