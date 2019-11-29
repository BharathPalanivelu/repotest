package com.shopee.sdk.modules.ui.d;

import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f30427a;

    /* renamed from: b  reason: collision with root package name */
    private String f30428b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30429c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f30430d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f30431e;

    private c(a aVar) {
        this.f30427a = aVar.f30432a;
        this.f30428b = aVar.f30433b;
        this.f30429c = aVar.f30434c;
        this.f30430d = aVar.f30435d;
        this.f30431e = aVar.f30436e;
    }

    public String a() {
        return this.f30427a;
    }

    public String b() {
        return this.f30428b;
    }

    public boolean c() {
        return this.f30429c;
    }

    public List<String> d() {
        return this.f30430d;
    }

    public List<String> e() {
        return this.f30431e;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f30432a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f30433b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f30434c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public List<String> f30435d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public List<String> f30436e;

        public a a(String str) {
            this.f30432a = str;
            return this;
        }

        public a b(String str) {
            this.f30433b = str;
            return this;
        }

        public a a(List<String> list) {
            this.f30435d = list;
            return this;
        }

        public a b(List<String> list) {
            this.f30436e = list;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
