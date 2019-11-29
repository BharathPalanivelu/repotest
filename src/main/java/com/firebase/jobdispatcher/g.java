package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.shopee.livequiz.data.bean.LiveParams;

public final class g implements c {

    /* renamed from: a  reason: collision with root package name */
    private final v f7196a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7197b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f7198c;

    /* renamed from: d  reason: collision with root package name */
    private final i f7199d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7200e = true;

    public boolean b() {
        return true;
    }

    public g(Context context) {
        this.f7197b = context;
        this.f7198c = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        this.f7199d = new i();
        this.f7196a = new b(context);
    }

    public int a(n nVar) {
        GooglePlayReceiver.a(nVar);
        this.f7197b.sendBroadcast(a((r) nVar));
        return 0;
    }

    public int a(String str) {
        this.f7197b.sendBroadcast(b(str));
        return 0;
    }

    /* access modifiers changed from: protected */
    public Intent b(String str) {
        Intent c2 = c("CANCEL_TASK");
        c2.putExtra("tag", str);
        c2.putExtra("component", new ComponentName(this.f7197b, c()));
        return c2;
    }

    /* access modifiers changed from: protected */
    public Class<GooglePlayReceiver> c() {
        return GooglePlayReceiver.class;
    }

    public v a() {
        return this.f7196a;
    }

    private Intent a(r rVar) {
        Intent c2 = c("SCHEDULE_TASK");
        c2.putExtras(this.f7199d.a(rVar, c2.getExtras()));
        return c2;
    }

    private Intent c(String str) {
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("scheduler_action", str);
        intent.putExtra(LiveParams.SYNC_TYPE_APP, this.f7198c);
        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, 8);
        intent.putExtra("source_version", 1);
        return intent;
    }
}
