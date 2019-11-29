package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.UnBindAccount;

public class bt extends az {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f18222a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public final boolean f18223b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f18224c;

    private bt(a aVar) {
        this.f18222a = aVar.f18226b;
        this.f18223b = aVar.f18227c;
        this.f18224c = aVar.f18225a;
    }

    /* access modifiers changed from: protected */
    public f a() {
        UnBindAccount.Builder builder = new UnBindAccount.Builder();
        builder.is_unbind_facebook(Boolean.valueOf(this.f18222a)).is_unbind_beetalk(Boolean.valueOf(this.f18223b)).is_unbind_line(Boolean.valueOf(this.f18224c)).country("ID").requestid(i().a());
        return new f(131, builder.build().toByteArray());
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f18225a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f18226b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f18227c;

        public a a(boolean z) {
            this.f18225a = z;
            return this;
        }

        public a b(boolean z) {
            this.f18226b = z;
            return this;
        }

        public bt a() {
            return new bt(this);
        }
    }
}
