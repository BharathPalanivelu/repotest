package com.shopee.app.ui.home;

import com.facebook.internal.NativeProtocol;
import d.d.b.j;

public abstract class q {

    public static final class a extends q {

        /* renamed from: a  reason: collision with root package name */
        private final String f22694a;

        /* renamed from: b  reason: collision with root package name */
        private final String f22695b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super((g) null);
            j.b(str, "moduleName");
            j.b(str2, NativeProtocol.WEB_DIALOG_PARAMS);
            this.f22694a = str;
            this.f22695b = str2;
        }

        public final String a() {
            return this.f22694a;
        }

        public final String b() {
            return this.f22695b;
        }
    }

    private q() {
    }

    public /* synthetic */ q(g gVar) {
        this();
    }

    public static final class b extends q {

        /* renamed from: a  reason: collision with root package name */
        private final String f22696a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super((g) null);
            j.b(str, "url");
            this.f22696a = str;
        }

        public final String a() {
            return this.f22696a;
        }
    }

    public static final class c extends q {

        /* renamed from: a  reason: collision with root package name */
        public static final c f22697a = new c();

        private c() {
            super((g) null);
        }
    }
}
