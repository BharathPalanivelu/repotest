package com.shopee.app.pushnotification.a.c;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.i;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.tools.b;
import com.shopee.app.h.g;
import com.shopee.app.pushnotification.NotificationData;
import com.shopee.app.pushnotification.c;
import com.shopee.app.util.af;
import com.shopee.id.R;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected NotificationData f18518a;

    /* renamed from: b  reason: collision with root package name */
    private List<NotificationData> f18519b;

    /* renamed from: c  reason: collision with root package name */
    private int f18520c;

    /* renamed from: d  reason: collision with root package name */
    private int f18521d;

    public a(NotificationData notificationData, List<NotificationData> list, int i) {
        this.f18518a = notificationData;
        this.f18519b = list;
        this.f18520c = i;
        this.f18521d = notificationData.getType();
    }

    /* access modifiers changed from: protected */
    public Intent a(Context context) {
        int i = this.f18521d;
        if (i != 8) {
            if (i == 11 || i == 13) {
                return c.a(4);
            }
            if (i != 99) {
                return c.a(5);
            }
            return c.a(3);
        } else if (af.a(this.f18519b)) {
            return c.b("");
        } else {
            boolean z = true;
            String metadata = this.f18519b.get(0).getMetadata();
            for (NotificationData metadata2 : this.f18519b) {
                if (!metadata2.getMetadata().equals(metadata)) {
                    z = false;
                }
            }
            if (z) {
                return c.b(metadata);
            }
            return c.b("");
        }
    }

    private PendingIntent c(Context context) {
        Intent a2 = a(context);
        a2.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(context, 0, a2, 1207959552);
        if (g.b()) {
            activity.cancel();
        }
        return PendingIntent.getActivity(context, 0, a2, 1207959552);
    }

    public Notification b(Context context) {
        i.f fVar = new i.f();
        a(fVar);
        i.d dVar = new i.d(context, "SHOPEE_NOTIFY_ID");
        dVar.a(d(context));
        b(dVar, context);
        dVar.f(1);
        dVar.e((CharSequence) b(this.f18518a));
        dVar.d(2);
        b(fVar);
        dVar.a((i.g) fVar);
        dVar.a(c(context));
        a(dVar, context);
        return dVar.b();
    }

    /* access modifiers changed from: protected */
    public void a(i.d dVar, Context context) {
        if (!this.f18518a.isSilentMode()) {
            if (this.f18518a.useCustomSound()) {
                dVar.a(Uri.parse("android.resource://" + context.getPackageName() + Constants.URL_PATH_DELIMITER + R.raw.shopee_noti));
                dVar.c(6);
                return;
            }
            dVar.c(-1);
        }
    }

    /* access modifiers changed from: protected */
    public void a(i.f fVar) {
        fVar.a((CharSequence) a()).b(b.e(R.string.sp_app_name));
    }

    /* access modifiers changed from: protected */
    public void b(i.d dVar, Context context) {
        i.d a2 = dVar.a((int) R.drawable.com_garena_shopee_logo_shopee_stat_white).a((CharSequence) a());
        a2.b((CharSequence) "From " + this.f18520c + " conversations").b(this.f18519b.size()).e(true);
    }

    private Bitmap d(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), Build.VERSION.SDK_INT >= 21 ? R.mipmap.com_garena_shopee_logo_shopee_launcher : R.drawable.com_garena_shopee_logo_shopee_stat_white);
    }

    /* access modifiers changed from: protected */
    public void b(i.f fVar) {
        int size = this.f18519b.size() - 5;
        int i = size < 0 ? 0 : size;
        for (int size2 = this.f18519b.size() - 1; size2 >= i; size2--) {
            fVar.c(a(this.f18519b.get(size2)));
        }
        if (size > 0) {
            fVar.c("(+" + size + " more)");
        }
    }

    /* access modifiers changed from: protected */
    public String a(NotificationData notificationData) {
        return b(notificationData);
    }

    /* access modifiers changed from: protected */
    public String b(NotificationData notificationData) {
        return notificationData.getMessage();
    }

    /* access modifiers changed from: protected */
    public String a() {
        if (this.f18519b.size() == 1) {
            return b.a(R.string.sp_label_1_new_message, Integer.valueOf(this.f18519b.size()));
        }
        return b.a(R.string.sp_label_num_new_message, Integer.valueOf(this.f18519b.size()));
    }
}
