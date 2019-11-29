package com.shopee.app.ui.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import java.util.List;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f26067a;

    /* renamed from: b  reason: collision with root package name */
    private ValueCallback<Uri> f26068b;

    /* renamed from: c  reason: collision with root package name */
    private ValueCallback<Uri[]> f26069c;

    public k(Activity activity) {
        this.f26067a = activity;
    }

    public void a(ValueCallback<Uri[]> valueCallback) {
        this.f26069c = valueCallback;
        PhotoProxyActivity_.a(this.f26067a).d(true).a(8772);
    }

    public void a(int i, List<String> list) {
        if (i != -1 || list.size() <= 0) {
            ValueCallback<Uri[]> valueCallback = this.f26069c;
            if (valueCallback != null) {
                valueCallback.onReceiveValue((Object) null);
            }
            ValueCallback<Uri> valueCallback2 = this.f26068b;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue((Object) null);
                return;
            }
            return;
        }
        Uri parse = Uri.parse(list.get(0));
        this.f26067a.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", parse));
        ValueCallback<Uri> valueCallback3 = this.f26068b;
        if (valueCallback3 != null) {
            valueCallback3.onReceiveValue(parse);
            this.f26068b = null;
        }
        ValueCallback<Uri[]> valueCallback4 = this.f26069c;
        if (valueCallback4 != null) {
            valueCallback4.onReceiveValue(new Uri[]{parse});
            this.f26069c = null;
        }
    }
}
