package com.shopee.app.util.q;

import com.facebook.share.internal.ShareConstants;
import d.d.b.j;

public abstract class d {
    private d() {
    }

    public /* synthetic */ d(g gVar) {
        this();
    }

    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f26486a = new b();

        public String toString() {
            return "ValidateResult.Success";
        }

        private b() {
            super((g) null);
        }
    }

    public static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        private final String f26487a;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && j.a((Object) this.f26487a, (Object) ((c) obj).f26487a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f26487a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String a() {
            return this.f26487a;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super((g) null);
            j.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            this.f26487a = str;
        }

        public String toString() {
            return "ValidateResult.Warning: " + this.f26487a;
        }
    }

    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private final String f26485a;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && j.a((Object) this.f26485a, (Object) ((a) obj).f26485a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f26485a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String a() {
            return this.f26485a;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super((g) null);
            j.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            this.f26485a = str;
        }

        public String toString() {
            return "ValidateResult.Error: " + this.f26485a;
        }
    }
}
