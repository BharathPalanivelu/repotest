package com.google.android.gms.measurement.internal;

import com.facebook.AccessToken;
import com.google.android.gms.measurement.AppMeasurement;
import com.j256.ormlite.field.FieldType;
import com.shopee.shopeetracker.EventSender;

public class zzgl {
    public static final String[] zzpp = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", AccessToken.USER_ID_KEY, "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "session_number", "ga_session_number", EventSender.TRACKING_DATA_SESSION_ID, "ga_session_id", "last_gclid"};
    public static final String[] zzpq = {AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", FieldType.FOREIGN_ID_FIELD_SUFFIX, "_fi", "_lte", "_se", "_npa", "_sno", "_sno", "_sid", "_sid", "_lgclid"};

    protected zzgl() {
    }

    public static String zzbe(String str) {
        return zzho.zza(str, zzpp, zzpq);
    }
}
