package com.shopee.web.sdk.bridge.a.f;

import com.facebook.places.model.PlaceFields;
import d.a.z;
import d.l;
import java.util.HashMap;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30468a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, String> f30469b = z.c(l.a("contact", "android.permission.READ_CONTACTS"), l.a("calendar", "android.permission.WRITE_CALENDAR"), l.a("camera", "android.permission.CAMERA"), l.a(PlaceFields.LOCATION, "android.permission.ACCESS_FINE_LOCATION"), l.a("record_audio", "android.permission.RECORD_AUDIO"), l.a("storage", "android.permission.WRITE_EXTERNAL_STORAGE"), l.a("gallery", "android.permission.WRITE_EXTERNAL_STORAGE"));

    /* renamed from: com.shopee.web.sdk.bridge.a.f.b$b  reason: collision with other inner class name */
    public interface C0475b {
        void onResult(List<Boolean> list);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}
