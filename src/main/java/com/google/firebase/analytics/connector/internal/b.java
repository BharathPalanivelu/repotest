package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzho;
import com.google.firebase.analytics.connector.a;
import com.shopee.livequiz.data.bean.LiveParams;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f6783a = new HashSet(Arrays.asList(new String[]{"_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}));

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f6784b = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open"});

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f6785c = Arrays.asList(new String[]{"auto", LiveParams.SYNC_TYPE_APP, "am"});

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f6786d = Arrays.asList(new String[]{"_r", "_dbg"});

    /* renamed from: e  reason: collision with root package name */
    private static final List<String> f6787e = Arrays.asList((String[]) ArrayUtils.concat(AppMeasurement.UserProperty.zzpp, AppMeasurement.UserProperty.zzpq));

    /* renamed from: f  reason: collision with root package name */
    private static final List<String> f6788f = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    public static boolean a(String str) {
        return !f6785c.contains(str);
    }

    public static boolean a(String str, Bundle bundle) {
        if (f6784b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        for (String containsKey : f6786d) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if (AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION.equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (f6787e.contains(str2)) {
            return false;
        }
        for (String matches : f6788f) {
            if (str2.matches(matches)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(a.C0117a aVar) {
        if (aVar == null) {
            return false;
        }
        String str = aVar.f6770a;
        if (str == null || str.isEmpty()) {
            return false;
        }
        if ((aVar.f6772c != null && zzho.zza(aVar.f6772c) == null) || !a(str) || !a(str, aVar.f6771b)) {
            return false;
        }
        if (aVar.k != null && (!a(aVar.k, aVar.l) || !a(str, aVar.k, aVar.l))) {
            return false;
        }
        if (aVar.h != null && (!a(aVar.h, aVar.i) || !a(str, aVar.h, aVar.i))) {
            return false;
        }
        if (aVar.f6775f == null) {
            return true;
        }
        if (a(aVar.f6775f, aVar.f6776g) && a(str, aVar.f6775f, aVar.f6776g)) {
            return true;
        }
        return false;
    }

    public static boolean a(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!a(str) || bundle == null) {
            return false;
        }
        for (String containsKey : f6786d) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c2 = 2;
                }
            } else if (str.equals("fdl")) {
                c2 = 1;
            }
        } else if (str.equals("fcm")) {
            c2 = 0;
        }
        if (c2 == 0) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        } else if (c2 == 1) {
            bundle.putString("_cis", "fdl_integration");
            return true;
        } else if (c2 != 2) {
            return false;
        } else {
            bundle.putString("_cis", "fiam_integration");
            return true;
        }
    }

    public static AppMeasurement.ConditionalUserProperty b(a.C0117a aVar) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mOrigin = aVar.f6770a;
        conditionalUserProperty.mActive = aVar.n;
        conditionalUserProperty.mCreationTimestamp = aVar.m;
        conditionalUserProperty.mExpiredEventName = aVar.k;
        if (aVar.l != null) {
            conditionalUserProperty.mExpiredEventParams = new Bundle(aVar.l);
        }
        conditionalUserProperty.mName = aVar.f6771b;
        conditionalUserProperty.mTimedOutEventName = aVar.f6775f;
        if (aVar.f6776g != null) {
            conditionalUserProperty.mTimedOutEventParams = new Bundle(aVar.f6776g);
        }
        conditionalUserProperty.mTimeToLive = aVar.j;
        conditionalUserProperty.mTriggeredEventName = aVar.h;
        if (aVar.i != null) {
            conditionalUserProperty.mTriggeredEventParams = new Bundle(aVar.i);
        }
        conditionalUserProperty.mTriggeredTimestamp = aVar.o;
        conditionalUserProperty.mTriggerEventName = aVar.f6773d;
        conditionalUserProperty.mTriggerTimeout = aVar.f6774e;
        if (aVar.f6772c != null) {
            conditionalUserProperty.mValue = zzho.zza(aVar.f6772c);
        }
        return conditionalUserProperty;
    }

    public static a.C0117a a(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        a.C0117a aVar = new a.C0117a();
        aVar.f6770a = conditionalUserProperty.mOrigin;
        aVar.n = conditionalUserProperty.mActive;
        aVar.m = conditionalUserProperty.mCreationTimestamp;
        aVar.k = conditionalUserProperty.mExpiredEventName;
        if (conditionalUserProperty.mExpiredEventParams != null) {
            aVar.l = new Bundle(conditionalUserProperty.mExpiredEventParams);
        }
        aVar.f6771b = conditionalUserProperty.mName;
        aVar.f6775f = conditionalUserProperty.mTimedOutEventName;
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            aVar.f6776g = new Bundle(conditionalUserProperty.mTimedOutEventParams);
        }
        aVar.j = conditionalUserProperty.mTimeToLive;
        aVar.h = conditionalUserProperty.mTriggeredEventName;
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            aVar.i = new Bundle(conditionalUserProperty.mTriggeredEventParams);
        }
        aVar.o = conditionalUserProperty.mTriggeredTimestamp;
        aVar.f6773d = conditionalUserProperty.mTriggerEventName;
        aVar.f6774e = conditionalUserProperty.mTriggerTimeout;
        if (conditionalUserProperty.mValue != null) {
            aVar.f6772c = zzho.zza(conditionalUserProperty.mValue);
        }
        return aVar;
    }
}
