package com.shopee.app.util.i;

import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f26363a;

    /* renamed from: b  reason: collision with root package name */
    private final e f26364b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26365c;

    /* renamed from: d  reason: collision with root package name */
    private final b f26366d;

    public interface b {
        void onError(String str, String str2, Exception exc);

        void onResponse(String str, String str2, String str3);
    }

    public /* synthetic */ a(b bVar, e eVar, String str, b bVar2, g gVar) {
        this(bVar, eVar, str, bVar2);
    }

    private a(b bVar, e eVar, String str, b bVar2) {
        this.f26363a = bVar;
        this.f26364b = eVar;
        this.f26365c = str;
        this.f26366d = bVar2;
    }

    public final b a() {
        return this.f26363a;
    }

    public final e b() {
        return this.f26364b;
    }

    public final String c() {
        return this.f26365c;
    }

    public final b d() {
        return this.f26366d;
    }

    /* renamed from: com.shopee.app.util.i.a$a  reason: collision with other inner class name */
    public static final class C0403a {

        /* renamed from: a  reason: collision with root package name */
        private b f26367a;

        /* renamed from: b  reason: collision with root package name */
        private e f26368b;

        /* renamed from: c  reason: collision with root package name */
        private String f26369c;

        /* renamed from: d  reason: collision with root package name */
        private b f26370d;

        public C0403a() {
            this((b) null, (e) null, (String) null, (b) null, 15, (g) null);
        }

        public C0403a(b bVar, e eVar, String str, b bVar2) {
            this.f26367a = bVar;
            this.f26368b = eVar;
            this.f26369c = str;
            this.f26370d = bVar2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0403a(b bVar, e eVar, String str, b bVar2, int i, g gVar) {
            this((i & 1) != 0 ? null : bVar, (i & 2) != 0 ? null : eVar, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bVar2);
        }

        public final C0403a a(b bVar) {
            j.b(bVar, "filter");
            this.f26367a = bVar;
            return this;
        }

        public final C0403a a(e eVar) {
            j.b(eVar, "tech");
            this.f26368b = eVar;
            return this;
        }

        public final C0403a a(String str) {
            j.b(str, "command");
            this.f26369c = str;
            return this;
        }

        public final C0403a a(b bVar) {
            this.f26370d = bVar;
            return this;
        }

        public final a a() {
            b bVar = this.f26367a;
            if (bVar == null) {
                throw new IllegalStateException("NfcFilter must not be null");
            } else if (this.f26368b == null) {
                throw new IllegalStateException("NfcTech must not be null");
            } else if (this.f26369c != null) {
                if (bVar == null) {
                    j.a();
                }
                e eVar = this.f26368b;
                if (eVar == null) {
                    j.a();
                }
                String str = this.f26369c;
                if (str == null) {
                    j.a();
                }
                return new a(bVar, eVar, str, this.f26370d, (g) null);
            } else {
                throw new IllegalStateException("NFC command must not be null");
            }
        }
    }
}
