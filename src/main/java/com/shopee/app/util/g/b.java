package com.shopee.app.util.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.garena.android.appkit.b.b;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.path.android.jobqueue.RetryConstraint;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.h.m;
import com.shopee.app.h.o;
import com.shopee.app.network.c.d.a;
import com.shopee.app.network.d.b.g;
import com.shopee.app.pushnotification.NotificationDataBuilder;
import com.shopee.app.pushnotification.c;
import com.shopee.app.util.FailedMessageBroadcastReceiver;
import com.shopee.id.R;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.concurrent.ArrayBlockingQueue;

public class b extends Job {

    /* renamed from: a  reason: collision with root package name */
    transient p f26355a;

    /* renamed from: b  reason: collision with root package name */
    transient UserInfo f26356b;

    /* renamed from: c  reason: collision with root package name */
    transient a f26357c;
    private final String mRequestId;

    public b(String str) {
        super(new Params(1).requireNetwork().groupBy("chat_conv").persist());
        this.mRequestId = str;
    }

    public void onAdded() {
        Intent intent = new Intent(ar.f(), FailedMessageBroadcastReceiver.class);
        intent.putExtra("reqID", this.mRequestId);
        ((AlarmManager) ar.f().getSystemService("alarm")).set(0, com.garena.android.appkit.tools.a.a.b() + 3600000, PendingIntent.getBroadcast(ar.f(), this.mRequestId.hashCode(), intent, 0));
    }

    public void onRun() throws Throwable {
        int i;
        DBChatMessage a2 = this.f26355a.a(this.mRequestId);
        if (a2 != null) {
            if (!b(a2)) {
                a();
                if (a2.k() == 1) {
                    c(a2);
                    return;
                }
                return;
            }
            final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            o.a().a(this.mRequestId, (a) new a() {
                public void a() {
                    b.this.f26357c = null;
                    arrayBlockingQueue.add(Integer.valueOf(RNCartPanelDataEntity.ERROR_FE_SERVER_ERROR));
                }

                public void a(a aVar) {
                    b.this.f26357c = aVar;
                    arrayBlockingQueue.add(Integer.valueOf(aVar.f17892a));
                }
            });
            new g(new com.shopee.app.network.g(this.mRequestId)).a(a2, this.f26356b.isMyShop(a2.h()) ? this.f26356b.getUserId() : a2.e());
            try {
                i = ((Integer) arrayBlockingQueue.take()).intValue();
            } catch (InterruptedException unused) {
                i = -998;
            }
            if (i == -999) {
                a();
            } else if (i == -998 || i == -100) {
                a(a2);
            } else {
                a aVar = this.f26357c;
                if (aVar != null) {
                    a(aVar, a2);
                }
                a();
            }
        }
    }

    private void a(DBChatMessage dBChatMessage) {
        if (!b(dBChatMessage)) {
            c(dBChatMessage);
            return;
        }
        throw new RuntimeException("Error in sending.. Retrying now!");
    }

    private boolean b(DBChatMessage dBChatMessage) {
        return com.garena.android.appkit.tools.a.a.a() - dBChatMessage.f() < 3600;
    }

    private void a(a aVar, DBChatMessage dBChatMessage) {
        dBChatMessage.f(4);
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            dBChatMessage.c(aVar.f17893b);
        }
        this.f26355a.a(dBChatMessage);
        d(dBChatMessage);
    }

    private void c(DBChatMessage dBChatMessage) {
        dBChatMessage.f(2);
        this.f26355a.a(dBChatMessage);
        String str = "m/" + dBChatMessage.e();
        a(com.garena.android.appkit.tools.b.e(R.string.sp_chat_msg_failed_notification), str, c.b(str));
        d(dBChatMessage);
    }

    private void d(DBChatMessage dBChatMessage) {
        com.garena.android.appkit.b.b.a("CHAT_SEND_SUCCESS", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, m.a(dBChatMessage.h()))), b.a.NETWORK_BUS);
    }

    private void a(String str, String str2, Intent intent) {
        c.a(NotificationDataBuilder.notificationData().withId(8).ofType(8).withLaunchIntent(intent).withMessage(str).shouldKeepSilent(false).shouldStack(true).withMetadata(str2).build());
    }

    private void a() {
        Intent intent = new Intent(ar.f(), FailedMessageBroadcastReceiver.class);
        intent.putExtra("reqID", this.mRequestId);
        PendingIntent.getBroadcast(ar.f(), this.mRequestId.hashCode(), intent, 0).cancel();
    }

    /* access modifiers changed from: protected */
    public RetryConstraint shouldReRunOnThrowable(Throwable th, int i, int i2) {
        RetryConstraint createExponentialBackoff = RetryConstraint.createExponentialBackoff(i, 1000);
        createExponentialBackoff.setApplyNewDelayToGroup(true);
        com.garena.android.appkit.d.a.b("SendChatJob: DELAY=%d | RUN=%d", createExponentialBackoff.getNewDelayInMs(), Integer.valueOf(i));
        return createExponentialBackoff;
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        DBChatMessage a2 = this.f26355a.a(this.mRequestId);
        if (a2 != null) {
            this.f26355a.b(a2);
        }
    }
}
