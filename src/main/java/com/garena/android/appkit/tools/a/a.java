package com.garena.android.appkit.tools.a;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import com.facebook.internal.NativeProtocol;
import com.garena.android.appkit.c;
import com.garena.android.appkit.tools.b;
import com.shopee.arcatch.data.common_bean.Country;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, SimpleDateFormat> f7687a = new HashMap<String, SimpleDateFormat>() {
        {
            put("ID", new SimpleDateFormat("dd-MM-yyyy"));
            put(Country.COUNTRY_SG, new SimpleDateFormat("dd-MM-yyyy"));
            put(Country.COUNTRY_PH, new SimpleDateFormat("MM/dd/yyyy"));
            put(Country.COUNTRY_TW, new SimpleDateFormat("yyyy-MM-dd"));
            put(Country.COUNTRY_VN, new SimpleDateFormat("dd-MM-yyyy"));
            put(Country.COUNTRY_MY, new SimpleDateFormat("dd-MM-yyyy"));
            put(Country.COUNTRY_TH, new SimpleDateFormat("dd-MM-yyyy"));
            put(Country.COUNTRY_IR, new SimpleDateFormat("yyyy-MM-dd"));
            put(Country.COUNTRY_MM, new SimpleDateFormat("dd-MM-yyyy"));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, SimpleDateFormat> f7688b = new HashMap<String, SimpleDateFormat>() {
        {
            put("ID", new SimpleDateFormat("dd-MM-yyyy HH:mm"));
            put(Country.COUNTRY_SG, new SimpleDateFormat("dd-MM-yyyy HH:mm"));
            put(Country.COUNTRY_PH, new SimpleDateFormat("MM/dd/yyyy HH:mm"));
            put(Country.COUNTRY_TW, new SimpleDateFormat("yyyy-MM-dd HH:mm"));
            put(Country.COUNTRY_VN, new SimpleDateFormat("HH:mm dd-MM-yy"));
            put(Country.COUNTRY_MY, new SimpleDateFormat("dd-MM-yyyy HH:mm"));
            put(Country.COUNTRY_TH, new SimpleDateFormat("dd-MM-yyyy HH:mm"));
            put(Country.COUNTRY_IR, new SimpleDateFormat("yyyy-MM-dd HH:mm"));
            put(Country.COUNTRY_MM, new SimpleDateFormat("dd-MM-yyyy HH:mm"));
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, SimpleDateFormat> f7689c = new HashMap<String, SimpleDateFormat>() {
        {
            put("ID", new SimpleDateFormat("HH:mm"));
            put(Country.COUNTRY_SG, new SimpleDateFormat("HH:mm"));
            put(Country.COUNTRY_PH, new SimpleDateFormat("HH:mm"));
            put(Country.COUNTRY_TW, new SimpleDateFormat("HH:mm"));
            put(Country.COUNTRY_VN, new SimpleDateFormat("HH:mm"));
            put(Country.COUNTRY_MY, new SimpleDateFormat("HH:mm"));
            put(Country.COUNTRY_TH, new SimpleDateFormat("HH:mm"));
            put(Country.COUNTRY_IR, new SimpleDateFormat("HH:mm"));
            put(Country.COUNTRY_MM, new SimpleDateFormat("HH:mm"));
        }
    };

    public static int a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static long b() {
        return System.currentTimeMillis();
    }

    public static int a(int i) {
        int i2 = i / 60;
        int i3 = i % 60;
        int i4 = i2 / 60;
        int i5 = i2 % 60;
        int i6 = i4 / 24;
        int i7 = i4 % 24;
        return i6;
    }

    public static int b(int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(((long) i) * 1000);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return (int) (instance.getTimeInMillis() / 1000);
    }

    public static String a(long j) {
        return DateFormat.getTimeFormat(com.garena.android.appkit.tools.a.f6696a.getApplicationContext()).format(Long.valueOf(j));
    }

    public static int a(String str, String str2) {
        long j;
        SimpleDateFormat simpleDateFormat = f7687a.get(str2);
        if (simpleDateFormat != null) {
            try {
                j = simpleDateFormat.parse(str).getTime();
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            return (int) (j / 1000);
        }
        j = 0;
        return (int) (j / 1000);
    }

    public static String a(int i, String str) {
        return f7688b.get(str).format(Long.valueOf(((long) i) * 1000));
    }

    public static String b(int i, String str) {
        return f7689c.get(str).format(Long.valueOf(((long) i) * 1000));
    }

    public static String c(int i, String str) {
        return f7687a.get(str).format(Long.valueOf(((long) i) * 1000));
    }

    public static String c(int i) {
        int a2 = (a() - i) / 60;
        if (a2 < 1) {
            return b.e(c.i.time_just_now);
        }
        int i2 = a2 / 60;
        if (i2 < 1) {
            return b.a(c.i.time_x_minutes, Integer.valueOf(a2));
        }
        int i3 = i2 / 24;
        if (i3 < 1) {
            return b.a(c.i.time_x_hour, Integer.valueOf(i2));
        }
        int i4 = i3 / 7;
        if (i3 < 1 || i3 >= 7) {
            return b.a(c.i.time_x_week, Integer.valueOf(i4));
        }
        return b.a(c.i.time_x_day, Integer.valueOf(i3));
    }

    public static String d(int i, String str) {
        com.garena.android.appkit.tools.a.f6696a.getApplicationContext();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(((long) i) * 1000);
        Calendar instance2 = Calendar.getInstance();
        boolean z = false;
        boolean z2 = instance.get(1) == instance2.get(1);
        if (instance.get(6) > instance2.get(6) - 7) {
            z = true;
        }
        int i2 = instance2.get(6) - instance.get(6);
        if (!z2 || !z || i2 < 0) {
            return a(i, str);
        }
        if (i2 == 0) {
            return b.e(c.i.sp_label_today) + ", " + b(i, str);
        } else if (i2 != 1) {
            return a(i, str);
        } else {
            return b.e(c.i.sp_label_yesterday) + ", " + b(i, str);
        }
    }

    public static String e(int i, String str) {
        long j = ((long) i) * 1000;
        return a(j, true, str) + ", " + a(j);
    }

    public static String a(long j, boolean z, String str) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.add(6, -1);
        Calendar instance3 = Calendar.getInstance();
        instance3.add(6, 1);
        Context applicationContext = com.garena.android.appkit.tools.a.f6696a.getApplicationContext();
        if (instance.get(1) == instance3.get(1) && instance.get(6) == instance3.get(6)) {
            if (!z) {
                return b.e(c.i.sp_label_tomorrow);
            }
            return DateUtils.formatDateTime(applicationContext, j, NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST);
        } else if (instance.get(1) != instance2.get(1)) {
            return f7687a.get(str).format(Long.valueOf(j));
        } else {
            if (z || instance.get(6) != instance2.get(6)) {
                return DateUtils.formatDateTime(applicationContext, j, NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST);
            }
            return b.e(c.i.sp_label_yesterday);
        }
    }
}
