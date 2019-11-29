package com.shopee.app.util.datapoint.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Base64;
import android.util.Pair;
import androidx.core.content.b;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import com.shopee.app.network.http.a.c;
import com.shopee.app.network.http.data.BaseResponse;
import com.shopee.app.network.http.data.datapoint.ReportUserInfoRequest;
import com.shopee.app.util.bd;
import com.shopee.app.util.i;
import f.m;
import java.util.Collections;
import java.util.UUID;
import javax.crypto.spec.SecretKeySpec;
import loan.data_point.ContentData;
import loan.data_point.ContentInfo;
import loan.data_point.LocationInfo;

public class a implements OnSuccessListener<Location> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Pair<Boolean, Location> f26329a = new Pair<>(false, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    private final c f26330b;

    /* renamed from: c  reason: collision with root package name */
    private final aa f26331c;

    public a(c cVar, aa aaVar) {
        this.f26330b = cVar;
        this.f26331c = aaVar;
    }

    public void a(Context context) throws Exception {
        if (b.b(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            Location location = new Location("dummyprovider");
            location.reset();
            b(location);
        } else if (b(context)) {
            final com.shopee.app.react.d.a aVar = new com.shopee.app.react.d.a();
            LocationServices.getFusedLocationProviderClient(context).getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                /* renamed from: a */
                public void onSuccess(Location location) {
                    if (location != null) {
                        aVar.a(new Pair(true, location));
                    } else {
                        aVar.b(a.f26329a);
                    }
                }
            });
            Pair pair = (Pair) aVar.a();
            if (pair != null && ((Boolean) pair.first).booleanValue()) {
                onSuccess((Location) pair.second);
            }
        } else {
            Location location2 = new Location("dummyprovider");
            location2.reset();
            c(location2);
        }
    }

    private boolean b(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(PlaceFields.LOCATION);
        return locationManager != null && locationManager.isProviderEnabled("gps");
    }

    private void b(Location location) {
        long latitude = (long) (location.getLatitude() * 1.0E8d);
        long longitude = (long) (location.getLongitude() * 1.0E8d);
        int a2 = com.garena.android.appkit.tools.a.a.a();
        a(new LocationInfo.Builder().base(100000000).latitude(Long.valueOf(latitude)).longitude(Long.valueOf(longitude)).altitude(Long.valueOf((long) (location.getAltitude() * 1.0E8d))).location_service(false).location_timestamp(Integer.valueOf(a2)).location_permission(false).item_id(a(latitude, longitude, a2)).build());
    }

    private void c(Location location) {
        long latitude = (long) (location.getLatitude() * 1.0E8d);
        long longitude = (long) (location.getLongitude() * 1.0E8d);
        int a2 = com.garena.android.appkit.tools.a.a.a();
        a(new LocationInfo.Builder().base(100000000).latitude(Long.valueOf(latitude)).longitude(Long.valueOf(longitude)).altitude(Long.valueOf((long) (location.getAltitude() * 1.0E8d))).location_service(false).location_timestamp(Integer.valueOf(a2)).location_permission(true).item_id(a(latitude, longitude, a2)).build());
    }

    /* renamed from: a */
    public void onSuccess(Location location) {
        if (location != null) {
            long latitude = (long) (location.getLatitude() * 1.0E8d);
            long longitude = (long) (location.getLongitude() * 1.0E8d);
            int a2 = com.garena.android.appkit.tools.a.a.a();
            a(new LocationInfo.Builder().base(100000000).latitude(Long.valueOf(latitude)).longitude(Long.valueOf(longitude)).altitude(Long.valueOf((long) (location.getAltitude() * 1.0E8d))).location_service(true).location_timestamp(Integer.valueOf(a2)).location_permission(true).item_id(a(latitude, longitude, a2)).build());
        }
    }

    private void a(LocationInfo locationInfo) {
        ContentData build = new ContentData.Builder().content_infos(Collections.singletonList(new ContentInfo.Builder().location_info(locationInfo).status(1).build())).build();
        try {
            SecretKeySpec b2 = bd.b("HELLO_WORLD");
            m<BaseResponse> a2 = this.f26330b.a(com.shopee.app.network.http.b.a.a(), i.f7040c, new ReportUserInfoRequest.Builder().content_type(3).device_fingerprint(a(true)).device_id(this.f26331c.d()).encrypt_key(bd.c(org.apache.commons.c.a.a(bd.f26238a, b2.getEncoded()))).encrypt_data(Base64.encodeToString(bd.a(b2, bd.f26238a, build.toByteArray()), 2)).platform_type(1).app_version(com.shopee.app.react.modules.app.appmanager.a.b()).user_id(ar.f().e().loggedInUser().getUserId()).encrypt_data_hash(UUID.randomUUID().toString()).build()).a();
            if (a2.d()) {
                BaseResponse e2 = a2.e();
                if (e2 != null && e2.isSuccess()) {
                    com.garena.android.appkit.d.a.b(String.valueOf(e2.errorCode), new Object[0]);
                }
            }
        } catch (Exception e3) {
            com.garena.android.appkit.d.a.a(e3);
        }
    }

    private String a(boolean z) {
        String g2 = this.f26331c.g();
        return z ? Base64.encodeToString(g2.getBytes(), 2) : g2;
    }

    private String a(long j, long j2, int i) {
        return a(false) + bd.a(String.valueOf(j) + String.valueOf(j2)) + i;
    }
}
