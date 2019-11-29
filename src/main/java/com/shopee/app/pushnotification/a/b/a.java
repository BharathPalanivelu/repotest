package com.shopee.app.pushnotification.a.b;

import a.k;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.i;
import com.garena.android.appkit.tools.b;
import com.shopee.app.h.g;
import com.shopee.app.pushnotification.NotificationData;
import com.shopee.app.pushnotification.a.a.c;
import com.shopee.app.pushnotification.d;
import com.shopee.id.R;
import com.squareup.a.r;
import com.squareup.a.w;
import java.io.IOException;
import java.util.concurrent.Callable;

public class a {

    /* renamed from: d  reason: collision with root package name */
    private static final double f18512d = Math.pow(10.0d, 10.0d);

    /* renamed from: a  reason: collision with root package name */
    protected final NotificationData f18513a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f18514b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f18515c;

    /* renamed from: e  reason: collision with root package name */
    private Callable<Bitmap> f18516e = new Callable<Bitmap>() {
        /* renamed from: a */
        public Bitmap call() throws Exception {
            try {
                w a2 = w.a(a.this.f18515c);
                return a2.a("http://cf.shopee.co.id/file/" + a.this.f18514b).a(r.NO_STORE, r.NO_CACHE).h();
            } catch (IOException unused) {
                return null;
            }
        }
    };

    public a(NotificationData notificationData) {
        this.f18513a = notificationData;
    }

    public String a() {
        return this.f18513a.getMessage();
    }

    /* access modifiers changed from: protected */
    public Intent a(Context context) {
        Intent intent = this.f18513a.getIntent();
        return intent == null ? d.a() : intent;
    }

    /* access modifiers changed from: protected */
    public PendingIntent b(Context context) {
        Intent a2 = a(context);
        a2.addFlags(67108864);
        if (this.f18513a.isInGroup()) {
            double currentTimeMillis = (double) System.currentTimeMillis();
            double d2 = f18512d;
            Double.isNaN(currentTimeMillis);
            return PendingIntent.getActivity(context, (int) (currentTimeMillis % d2), a2, 134217728);
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, a2, 1207959552);
        if (g.b()) {
            activity.cancel();
        }
        return PendingIntent.getActivity(context, 0, a2, 1207959552);
    }

    public i.d c(Context context) {
        Bitmap bitmap;
        RemoteViews remoteViews;
        this.f18515c = context;
        i.c cVar = new i.c();
        a(cVar);
        i.d dVar = new i.d(context, com.shopee.app.pushnotification.a.a(c.a(this.f18513a)));
        this.f18514b = this.f18513a.getImageUrl();
        if (this.f18514b != null) {
            k<TResult> a2 = k.a(this.f18516e);
            try {
                a2.h();
            } catch (InterruptedException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
            bitmap = (Bitmap) a2.f();
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                remoteViews = new RemoteViews(context.getPackageName(), R.layout.big_picture_lollipop);
            } else {
                remoteViews = new RemoteViews(context.getPackageName(), R.layout.big_picture);
            }
            remoteViews.setImageViewBitmap(R.id.big_picture, bitmap);
            remoteViews.setTextViewText(R.id.title, this.f18513a.getTitle());
            remoteViews.setImageViewBitmap(R.id.icon, e(context));
            remoteViews.setTextViewText(R.id.text2, this.f18513a.getMessage());
            a(dVar, context);
            dVar.a((i.g) new i.b().b(e(context)).a(bitmap).a((CharSequence) this.f18513a.getMessage())).a(b(context));
            dVar.f(1);
            if (Build.VERSION.SDK_INT >= 16) {
                dVar.c(remoteViews);
            }
            return dVar;
        }
        dVar.a(e(context));
        a(dVar, context);
        dVar.a((i.g) cVar).a(b(context));
        dVar.f(1);
        a(context, dVar);
        return dVar;
    }

    public Notification d(Context context) {
        return c(context).b();
    }

    /* access modifiers changed from: protected */
    public void a(Context context, i.d dVar) {
        c.a(context, dVar, this.f18513a);
    }

    /* access modifiers changed from: protected */
    public void a(i.c cVar) {
        cVar.b(this.f18513a.getMessage());
        cVar.a((CharSequence) b.e(R.string.sp_app_name));
    }

    /* access modifiers changed from: protected */
    public void a(i.d dVar, Context context) {
        dVar.a((int) R.drawable.com_garena_shopee_logo_shopee_stat_white).a((CharSequence) this.f18513a.getTitle()).b((CharSequence) this.f18513a.getMessage()).e((CharSequence) a()).b(1).e(true);
    }

    private int b() {
        return Build.VERSION.SDK_INT >= 21 ? R.mipmap.com_garena_shopee_logo_shopee_launcher : R.drawable.com_garena_shopee_logo_shopee_stat_white;
    }

    private Bitmap e(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), b());
    }
}
