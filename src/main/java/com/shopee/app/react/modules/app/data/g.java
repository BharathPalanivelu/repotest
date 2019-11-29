package com.shopee.app.react.modules.app.data;

import com.facebook.internal.NativeProtocol;
import com.shopee.app.data.a.a;
import com.shopee.app.react.protocol.DataBridgeParams;
import d.d.b.j;
import java.util.ArrayList;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<i> f18751a;

    /* renamed from: b  reason: collision with root package name */
    private final List<h> f18752b;

    public g(List<? extends i> list, List<? extends h> list2) {
        j.b(list, "updaters");
        j.b(list2, "providers");
        this.f18751a = list;
        this.f18752b = list2;
    }

    public final com.shopee.app.data.a.a a(DataBridgeParams dataBridgeParams) {
        j.b(dataBridgeParams, NativeProtocol.WEB_DIALOG_PARAMS);
        for (h hVar : this.f18752b) {
            if (hVar.a(dataBridgeParams.key)) {
                String b2 = hVar.b(dataBridgeParams.data);
                if (b2 != null) {
                    return new a.c(b2);
                }
                return new a.b(405, new IllegalStateException("DataBridgeHelper.get(): No such data"));
            }
        }
        return new a.b(404, new IllegalStateException("DataBridgeHelper.get(): No such key"));
    }

    public final com.shopee.app.data.a.a b(DataBridgeParams dataBridgeParams) {
        j.b(dataBridgeParams, NativeProtocol.WEB_DIALOG_PARAMS);
        for (i iVar : this.f18751a) {
            if (iVar.a(dataBridgeParams.key)) {
                String c2 = iVar.c(dataBridgeParams.data);
                if (c2 != null) {
                    return new a.c(c2);
                }
                return new a.b(405, new IllegalStateException("DataBridgeHelper.update(): No such data"));
            }
        }
        return new a.b(404, new IllegalStateException("DataBridgeHelper.update(): No such key"));
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<i> f18753a;

        /* renamed from: b  reason: collision with root package name */
        private final List<h> f18754b;

        public a() {
            this((List) null, (List) null, 3, (g) null);
        }

        public a(List<i> list, List<h> list2) {
            j.b(list, "updaters");
            j.b(list2, "providers");
            this.f18753a = list;
            this.f18754b = list2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(List list, List list2, int i, g gVar) {
            this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new ArrayList() : list2);
        }

        public final a a(i iVar) {
            j.b(iVar, "updater");
            this.f18753a.add(iVar);
            return this;
        }

        public final a a(h hVar) {
            j.b(hVar, "provider");
            this.f18754b.add(hVar);
            return this;
        }

        public final g a() {
            return new g(this.f18753a, this.f18754b);
        }
    }
}
