package com.shopee.app.util.k;

import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.b;
import com.shopee.app.network.g;
import com.shopee.app.ui.product.add.a;
import com.shopee.protocol.action.ResponseCommon;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private b f26396a;

    /* renamed from: b  reason: collision with root package name */
    private BlockingQueue<ResponseCommon> f26397b = new ArrayBlockingQueue(1);

    /* renamed from: c  reason: collision with root package name */
    private a f26398c;

    public e(g gVar, boolean z) {
        this.f26396a = new b(new g(gVar.requestId), gVar.item, gVar.models, z, false);
    }

    public ResponseCommon a() {
        o.a().a((az) this.f26396a);
        o.a().a(this.f26396a.i().a(), (a) this);
        this.f26396a.g();
        try {
            return this.f26397b.take();
        } catch (InterruptedException unused) {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            return builder.build();
        }
    }

    public void onFailed(ResponseCommon responseCommon) {
        this.f26397b.add(responseCommon);
    }

    public void onSuccess(a aVar) {
        this.f26398c = aVar;
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = 0;
        this.f26397b.add(builder.build());
    }

    public a b() {
        return this.f26398c;
    }
}
