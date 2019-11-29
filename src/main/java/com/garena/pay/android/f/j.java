package com.garena.pay.android.f;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.telephony.SmsManager;
import android.webkit.JavascriptInterface;
import com.beetalk.sdk.e.a;
import com.beetalk.sdk.e.b;
import com.beetalk.sdk.e.f;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private Context f8300a;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f8301b = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int resultCode = getResultCode();
            a.b("sms sent boradcast received %d", Integer.valueOf(resultCode));
            if (resultCode != -1 && resultCode != 1) {
            }
        }
    };

    public j(Context context) {
        this.f8300a = context;
    }

    public void a() {
        this.f8300a.registerReceiver(this.f8301b, new IntentFilter("WebViewJSInterface.sms_sent"));
    }

    public void b() {
        this.f8300a.unregisterReceiver(this.f8301b);
    }

    @JavascriptInterface
    public void sendSms(String str, String str2) {
        a.c("local sendSms function called", new Object[0]);
        if (!f.a(str) && !f.a(str2)) {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            this.f8300a.startActivity(intent);
        }
    }

    @JavascriptInterface
    public void sendSmsInApp(String str, String str2) {
        a.c("send sms inside app, %s, %s", str, str2);
        if (!f.a(str) && !f.a(str2)) {
            if (b.e(this.f8300a)) {
                SmsManager.getDefault().sendTextMessage(str, (String) null, str2, PendingIntent.getBroadcast(this.f8300a, 0, new Intent("WebViewJSInterface.sms_sent"), 0), (PendingIntent) null);
                return;
            }
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            this.f8300a.startActivity(intent);
        }
    }
}
