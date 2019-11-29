package com.shopee.app.react;

import android.app.Activity;
import android.content.Context;
import com.afollestad.materialdialogs.f;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.UiThreadUtil;
import com.garena.android.appkit.e.a;
import com.garena.android.appkit.f.f;
import com.shopee.app.application.ar;
import com.shopee.app.react.util.b;
import com.shopee.app.ui.home.c;
import com.shopee.id.R;
import com.tencent.ugc.TXRecordCommon;

public class i implements NativeModuleCallExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private long f18690a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Runnable f18691b = new Runnable() {
        public void run() {
            final Activity b2 = a.a().b();
            if (b2 == null || b2.isFinishing()) {
                if (!i.this.a((int) TXRecordCommon.AUDIO_SAMPLERATE_8000)) {
                    f.a().a(i.this.f18691b, 400);
                }
            } else if (b2 instanceof c) {
                com.shopee.app.ui.dialog.a.a((Context) b2, 0, (int) R.string.sp_rn_exception_msg, 0, (int) R.string.sp_label_back_to_home, (f.b) new f.b() {
                    public void onAny(com.afollestad.materialdialogs.f fVar) {
                        if (b2 instanceof c) {
                            ar.f().e().uiStatusStore().b(g.a().i());
                        }
                        ar.a(false);
                    }
                }, false);
            }
        }
    };

    public void handleException(Exception exc) {
        Exception a2 = b.a(exc);
        com.garena.android.appkit.d.a.a(a2);
        com.crashlytics.android.a.a((Throwable) a2);
        if (a(2000)) {
            this.f18690a = System.currentTimeMillis();
            a();
        }
    }

    private void a() {
        UiThreadUtil.runOnUiThread(this.f18691b);
    }

    /* access modifiers changed from: private */
    public boolean a(int i) {
        return System.currentTimeMillis() - this.f18690a > ((long) i);
    }
}
