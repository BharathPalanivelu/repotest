package com.shopee.app.web2.b.b;

import android.content.Context;
import android.webkit.WebView;
import com.facebook.react.bridge.UiThreadUtil;
import com.shopee.app.ui.datapoint.c;
import com.shopee.app.ui.datapoint.data.CollectDataEvent;
import com.shopee.web.sdk.bridge.internal.BridgeMessage;
import com.shopee.web.sdk.bridge.protocol.datapoint.DataPointBridgeRequest;
import d.d.b.j;
import java.util.HashMap;
import java.util.List;

public final class a extends com.shopee.web.sdk.bridge.a.b.a implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, c> f26643a = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        j.b(context, "context");
    }

    public void a(WebView webView, com.shopee.web.sdk.bridge.internal.c cVar) {
        super.a(webView, cVar);
        this.f26643a.put("contact", new com.shopee.app.ui.datapoint.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(DataPointBridgeRequest dataPointBridgeRequest) {
        if (dataPointBridgeRequest != null) {
            List<String> contentTypes = dataPointBridgeRequest.getContentTypes();
            if (contentTypes != null) {
                for (String str : contentTypes) {
                    c cVar = this.f26643a.get(str);
                    if (cVar != null) {
                        cVar.b();
                    }
                }
            }
        }
    }

    /* renamed from: com.shopee.app.web2.b.b.a$a  reason: collision with other inner class name */
    static final class C0413a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f26644a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CollectDataEvent f26645b;

        C0413a(a aVar, CollectDataEvent collectDataEvent) {
            this.f26644a = aVar;
            this.f26645b = collectDataEvent;
        }

        public final void run() {
            if (this.f26644a.e() != null) {
                this.f26644a.g().a(BridgeMessage.forEvent("COLLECT_DATA_EVENT", this.f26645b));
            }
        }
    }

    public void onDone(CollectDataEvent collectDataEvent) {
        j.b(collectDataEvent, "data");
        UiThreadUtil.runOnUiThread(new C0413a(this, collectDataEvent));
    }
}
