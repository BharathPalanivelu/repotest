package com.shopee.app.data.a;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.tencent.qcloud.core.http.HttpMetric;
import d.d.b.j;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0259a f17152a = new C0259a((g) null);

    public static final class c extends a {

        /* renamed from: b  reason: collision with root package name */
        private final String f17155b;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && j.a((Object) this.f17155b, (Object) ((c) obj).f17155b);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f17155b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Success(result=" + this.f17155b + SQLBuilder.PARENTHESES_RIGHT;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super((g) null);
            j.b(str, AbTestingModule.KEY_RESULT);
            this.f17155b = str;
        }

        public final String a() {
            return this.f17155b;
        }
    }

    private a() {
    }

    public /* synthetic */ a(g gVar) {
        this();
    }

    public static final class b extends a {

        /* renamed from: b  reason: collision with root package name */
        private final int f17153b;

        /* renamed from: c  reason: collision with root package name */
        private final Exception f17154c;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.f17153b == bVar.f17153b) || !j.a((Object) this.f17154c, (Object) bVar.f17154c)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = Integer.valueOf(this.f17153b).hashCode() * 31;
            Exception exc = this.f17154c;
            return hashCode + (exc != null ? exc.hashCode() : 0);
        }

        public String toString() {
            return "Failure(errCode=" + this.f17153b + ", exception=" + this.f17154c + SQLBuilder.PARENTHESES_RIGHT;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Exception exc) {
            super((g) null);
            j.b(exc, HttpMetric.ATTR_EXCEPTION);
            this.f17153b = i;
            this.f17154c = exc;
        }

        public final int a() {
            return this.f17153b;
        }

        public final Exception b() {
            return this.f17154c;
        }
    }

    /* renamed from: com.shopee.app.data.a.a$a  reason: collision with other inner class name */
    public static final class C0259a {
        private C0259a() {
        }

        public /* synthetic */ C0259a(g gVar) {
            this();
        }
    }
}
