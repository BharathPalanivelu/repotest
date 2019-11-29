package com.shopee.feeds.feedlibrary.bg;

import a.k;
import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.shopee.feeds.feedlibrary.bg.a.a;
import com.shopee.feeds.feedlibrary.util.h;
import java.util.concurrent.Callable;

public class BackgroundService extends IntentService {
    public BackgroundService() {
        super("BackgroundService");
        h.b("BackgroundService", "BackgroundService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("module_key");
            if (!TextUtils.isEmpty(stringExtra)) {
                a(intent, stringExtra);
            }
        }
    }

    private void a(Intent intent, String str) {
        if ("post_status".equals(str)) {
            String stringExtra = intent.getStringExtra("method_key");
            if (!TextUtils.isEmpty(stringExtra)) {
                b(intent, stringExtra);
            }
        }
    }

    private void b(Intent intent, String str) {
        if ("status_method_retry".equals(str)) {
            final String stringExtra = intent.getStringExtra(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
            k.a(new Callable<String>() {
                /* renamed from: a */
                public String call() throws Exception {
                    try {
                        new a().a(stringExtra);
                        return null;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
            });
        }
    }

    public void onCreate() {
        super.onCreate();
        h.b("BackgroundService", "onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
        h.b("BackgroundService", "onDestroy");
    }
}
