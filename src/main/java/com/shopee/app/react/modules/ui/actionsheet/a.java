package com.shopee.app.react.modules.ui.actionsheet;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.afollestad.materialdialogs.f;
import com.facebook.react.bridge.Promise;
import com.google.a.o;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.ShowActionsMessage;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private final c f18805a;

    public a(c cVar) {
        this.f18805a = cVar;
    }

    public void a(String str, Promise promise) {
        ShowActionsMessage showActionsMessage = (ShowActionsMessage) WebRegister.GSON.a(str, ShowActionsMessage.class);
        if (showActionsMessage != null) {
            a(showActionsMessage.getActionString(), showActionsMessage.getSheetTitle(), promise);
        }
    }

    public void a(int i, Promise promise) {
        o oVar = new o();
        oVar.a("btnIndexTapped", (Number) Integer.valueOf(i));
        promise.resolve(oVar.toString());
    }

    public void a(CharSequence[] charSequenceArr, String str, final Promise promise) {
        Dialog dialog;
        if (charSequenceArr != null) {
            if (TextUtils.isEmpty(str)) {
                dialog = com.shopee.app.ui.dialog.a.a((Context) this.f18805a.a(), charSequenceArr, (a.c) new a.c() {
                    public void a(f fVar, View view, int i, CharSequence charSequence) {
                        a.this.a(i, promise);
                    }
                }, (a.g) new a.g() {
                    public void a() {
                        a.this.a(-1, promise);
                    }
                });
            } else {
                dialog = com.shopee.app.ui.dialog.a.a((Context) this.f18805a.a(), str, charSequenceArr, (a.c) new a.c() {
                    public void a(f fVar, View view, int i, CharSequence charSequence) {
                        a.this.a(i, promise);
                    }
                }, (a.g) new a.g() {
                    public void a() {
                        a.this.a(-1, promise);
                    }
                });
            }
            dialog.show();
        }
    }
}
