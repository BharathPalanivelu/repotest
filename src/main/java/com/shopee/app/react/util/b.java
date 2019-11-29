package com.shopee.app.react.util;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Arrays;

public class b extends Exception {
    private b() {
    }

    private b(String str) {
        super(str);
    }

    public static Exception a(Exception exc) {
        int i;
        String message = exc.getMessage();
        if (TextUtils.isEmpty(message)) {
            return exc;
        }
        String[] split = message.split("\\r?\\n");
        String str = split[0];
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 < split.length; i2++) {
            String str2 = split[i2];
            int lastIndexOf = str2.lastIndexOf("@");
            if (lastIndexOf > 0) {
                String substring = str2.substring(0, lastIndexOf);
                String[] split2 = str2.substring(lastIndexOf).split(":");
                int length = split2.length;
                String str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                String str4 = length > 0 ? split2[0] : str3;
                try {
                    if (split2.length > 1) {
                        str3 = split2[1];
                    }
                    i = Integer.valueOf(str3).intValue();
                } catch (Exception unused) {
                    i = 0;
                }
                arrayList.add(new StackTraceElement("", substring, str4, i));
            }
        }
        arrayList.addAll(Arrays.asList(exc.getStackTrace()));
        b bVar = new b(str);
        bVar.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
        return bVar;
    }
}
