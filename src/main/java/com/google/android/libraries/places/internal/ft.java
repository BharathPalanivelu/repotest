package com.google.android.libraries.places.internal;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;

public class ft implements ny {
    public static fw a(ax axVar, fg fgVar, gg ggVar, dq dqVar) {
        return new fw(axVar, fgVar, ggVar, dqVar);
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public static int a(String str) {
        if (str == null) {
            return 13;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1698126997:
                if (str.equals("REQUEST_DENIED")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1125000185:
                if (str.equals("INVALID_REQUEST")) {
                    c2 = 4;
                    break;
                }
                break;
            case -813482689:
                if (str.equals("ZERO_RESULTS")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2524:
                if (str.equals("OK")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1023286998:
                if (str.equals("NOT_FOUND")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1776037267:
                if (str.equals("UNKNOWN_ERROR")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1831775833:
                if (str.equals("OVER_QUERY_LIMIT")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1) {
            return 0;
        }
        if (c2 == 2) {
            return PlacesStatusCodes.OVER_QUERY_LIMIT;
        }
        if (c2 == 3) {
            return PlacesStatusCodes.REQUEST_DENIED;
        }
        if (c2 == 4) {
            return PlacesStatusCodes.INVALID_REQUEST;
        }
        if (c2 != 5) {
            return 13;
        }
        return PlacesStatusCodes.NOT_FOUND;
    }

    public static String a(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static HandlerThread b(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return handlerThread;
    }
}
