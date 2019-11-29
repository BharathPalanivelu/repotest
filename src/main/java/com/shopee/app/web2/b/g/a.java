package com.shopee.app.web2.b.g;

import android.content.Context;
import com.google.a.i;
import com.google.a.l;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.web.sdk.bridge.protocol.tracking.TrackBIEventRequest;
import d.d.b.j;
import d.m;
import java.util.Iterator;

public final class a extends com.shopee.web.sdk.bridge.a.h.a {

    /* renamed from: a  reason: collision with root package name */
    public com.shopee.app.tracking.a f26662a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((com.shopee.app.web2.b.a) b2).a(this);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web2.bridge.WebBridgeSdkInjector");
    }

    /* access modifiers changed from: protected */
    public void a(TrackBIEventRequest trackBIEventRequest) {
        if (trackBIEventRequest != null) {
            String events = trackBIEventRequest.getEvents();
            CharSequence charSequence = events;
            if (!(charSequence == null || d.h.m.a(charSequence))) {
                i iVar = (i) WebRegister.GSON.a(events, i.class);
                if (iVar != null && iVar.a() != 0) {
                    Iterator<l> it = iVar.iterator();
                    while (it.hasNext()) {
                        l next = it.next();
                        com.shopee.app.tracking.a aVar = this.f26662a;
                        if (aVar == null) {
                            j.b("tracker");
                        }
                        aVar.d(WebRegister.GSON.a(next));
                    }
                }
            }
        }
    }
}
