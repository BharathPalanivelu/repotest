package com.shopee.app.ui.proxy;

import a.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.shopee.app.h.k;
import com.shopee.app.ui.home.HomeActivity_;

public class ProxyActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        k.a((Context) this);
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            String str2 = "";
            String str3 = null;
            if (data.getScheme().startsWith("shopee")) {
                Uri a2 = c.a(this, intent);
                if (a2 == null) {
                    str = data.getHost() + "?" + data.getEncodedQuery();
                } else if (a2.getScheme().startsWith("shopee")) {
                    str = data.getHost() + "?" + data.getEncodedQuery();
                } else {
                    str3 = a2.toString();
                }
                str2 = str;
            } else {
                String lastPathSegment = data.getLastPathSegment();
                if (lastPathSegment == null || !lastPathSegment.equals("launchapp")) {
                    str3 = data.toString();
                } else {
                    str2 = lastPathSegment + "?" + data.getEncodedQuery();
                }
            }
            Intent b2 = HomeActivity_.a(this).b(str3).a(str2).b();
            b2.addFlags(67108864);
            b2.setAction(intent.getAction());
            b2.setData(intent.getData());
            a(b2);
            startActivity(b2);
            overridePendingTransition(0, 0);
            finish();
        }
    }

    private void a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 22) {
            intent.putExtra("android.intent.extra.REFERRER_URI", getReferrer());
            return;
        }
        if (intent.hasExtra("android.intent.extra.REFERRER")) {
            intent.putExtra("android.intent.extra.REFERRER", intent.getParcelableExtra("android.intent.extra.REFERRER"));
        }
        if (intent.hasExtra("android.intent.extra.REFERRER_NAME")) {
            intent.putExtra("android.intent.extra.REFERRER_NAME", intent.getStringExtra("android.intent.extra.REFERRER_NAME"));
        }
    }
}
