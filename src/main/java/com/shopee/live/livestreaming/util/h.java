package com.shopee.live.livestreaming.util;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.liveimsdk.custom.a.a;
import com.shopee.sdk.modules.app.e.a;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class h {
    public static RequestBody a(Object obj) {
        return RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new f().b(obj));
    }

    public static DanmaKuContentEntity a(String str) {
        if (!d.a(str)) {
            return (DanmaKuContentEntity) new f().a(str, DanmaKuContentEntity.class);
        }
        return null;
    }

    public static String a() {
        a e2 = x.e();
        return e2 != null ? e2.c() : "";
    }

    public static String a(a.d dVar) {
        return dVar == null ? "" : dVar.f29595c;
    }

    public static String a(a.d dVar, DanmaKuContentEntity danmaKuContentEntity) {
        return (dVar == null || danmaKuContentEntity == null) ? "" : danmaKuContentEntity.getContent();
    }

    public static String a(LiveStreamingSessionEntity.Session session) {
        return session == null ? "" : session.getUsername();
    }
}
