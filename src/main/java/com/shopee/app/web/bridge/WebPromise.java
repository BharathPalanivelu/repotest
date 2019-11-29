package com.shopee.app.web.bridge;

import android.text.TextUtils;
import com.google.a.o;
import com.shopee.app.ui.webview.g;

public class WebPromise {
    private final String mCallbackId;
    private final g mView;

    public WebPromise(String str, g gVar) {
        this.mCallbackId = str;
        this.mView = gVar;
    }

    public void resolve(o oVar) {
        if (!TextUtils.isEmpty(this.mCallbackId) && oVar != null) {
            g gVar = this.mView;
            if (gVar != null) {
                gVar.a(this.mCallbackId, oVar);
            }
        }
    }

    public void reject(o oVar) {
        if (!TextUtils.isEmpty(this.mCallbackId) && oVar != null) {
            g gVar = this.mView;
            if (gVar != null) {
                gVar.a(this.mCallbackId, oVar);
            }
        }
    }
}
