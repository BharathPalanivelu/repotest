package com.shopee.app.pushnotification.a.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.i;
import com.shopee.app.pushnotification.NotificationData;
import com.shopee.app.pushnotification.a;
import com.shopee.id.R;
import d.d.b.j;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<Integer, Notification> f18506a = new LinkedHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<Integer, Integer> f18507b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final int f18508c = 99900000;

    /* renamed from: d  reason: collision with root package name */
    private final List<NotificationData> f18509d;

    public b(List<? extends NotificationData> list) {
        j.b(list, "dataList");
        this.f18509d = list;
    }

    public final LinkedHashMap<Integer, Notification> a(Context context) {
        j.b(context, "context");
        c(context);
        b(context);
        return this.f18506a;
    }

    private final void b(Context context) {
        if (!this.f18507b.isEmpty()) {
            for (Map.Entry entry : this.f18507b.entrySet()) {
                int intValue = ((Number) entry.getKey()).intValue();
                int intValue2 = ((Number) entry.getValue()).intValue();
                i.d a2 = new i.d(context, a.a(intValue2)).g(true).c(String.valueOf(intValue)).a(d(context)).a((int) R.drawable.com_garena_shopee_logo_shopee_stat_white).c(6).a((i.g) new i.f().a((CharSequence) com.garena.android.appkit.tools.b.e(R.string.sp_app_system_notification_title)).b(com.garena.android.appkit.tools.b.e(R.string.sp_app_system_notification_title)));
                c.a(context, a2, intValue2);
                Integer valueOf = Integer.valueOf(this.f18508c + intValue);
                Notification b2 = a2.b();
                j.a((Object) b2, "summaryBuilder.build()");
                this.f18506a.put(valueOf, b2);
            }
        }
    }

    private final void c(Context context) {
        if (!this.f18509d.isEmpty()) {
            for (NotificationData next : this.f18509d) {
                int currentTimeMillis = (int) System.currentTimeMillis();
                i.d c2 = new com.shopee.app.pushnotification.a.b.a(next).c(context);
                c2.c(String.valueOf(next.getType()));
                c2.g(1);
                Integer valueOf = Integer.valueOf(currentTimeMillis);
                Notification b2 = c2.b();
                j.a((Object) b2, "singleBuilder.build()");
                this.f18506a.put(valueOf, b2);
                this.f18507b.put(Integer.valueOf(next.getType()), Integer.valueOf(c.a(next)));
            }
        }
    }

    private final int a() {
        return Build.VERSION.SDK_INT >= 21 ? R.mipmap.com_garena_shopee_logo_shopee_launcher : R.drawable.com_garena_shopee_logo_shopee_stat_white;
    }

    private final Bitmap d(Context context) {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), a());
        j.a((Object) decodeResource, "BitmapFactory.decodeReso…t.resources, drawableRes)");
        return decodeResource;
    }
}
