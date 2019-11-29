package com.shopee.app.h.a;

import com.beetalklib.a.a.b;
import com.garena.android.appkit.d.a;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e implements b {
    public void onDestroy() {
    }

    public void onDownloading(int i, int i2) {
    }

    public void onError(int i) {
    }

    /* access modifiers changed from: protected */
    public abstract void onJSonObject(JSONObject jSONObject) throws JSONException;

    public void onFinish(byte[] bArr, int i) {
        try {
            onJSonObject(new JSONObject(new String(bArr, "UTF-8")));
        } catch (UnsupportedEncodingException | JSONException e2) {
            a.a(e2);
        }
    }
}
