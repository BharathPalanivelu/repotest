package com.shopee.app.util;

import com.beetalklib.a.a.b;
import com.garena.android.appkit.d.a;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class ab implements b {
    public void onDestroy() {
    }

    public void onDownloading(int i, int i2) {
    }

    public void onError(int i) {
    }

    /* access modifiers changed from: protected */
    public abstract void onJSONArray(JSONArray jSONArray) throws JSONException;

    public void onFinish(byte[] bArr, int i) {
        try {
            onJSONArray(new JSONArray(new String(bArr, "UTF-8")));
        } catch (UnsupportedEncodingException | JSONException e2) {
            a.a(e2);
        }
    }
}
