package com.shopee.app.react.protocol;

import com.google.a.l;
import com.google.a.o;
import com.shopee.app.web.WebRegister;
import d.d.b.j;

public final class BridgeResult<T> {
    public static final Companion Companion = new Companion((g) null);
    private final T data;
    private final int error;
    private final String errorMessage;

    private BridgeResult(int i, T t, String str) {
        this.error = i;
        this.data = t;
        this.errorMessage = str;
    }

    public /* synthetic */ BridgeResult(int i, Object obj, String str, g gVar) {
        this(i, obj, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ BridgeResult(int i, Object obj, String str, int i2, g gVar) {
        this(i, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : str);
    }

    public final o toJson() {
        l a2 = WebRegister.GSON.a((Object) this);
        j.a((Object) a2, "WebRegister.GSON.toJsonTree(this)");
        o m = a2.m();
        j.a((Object) m, "WebRegister.GSON.toJsonTree(this).asJsonObject");
        return m;
    }

    public String toString() {
        String b2 = WebRegister.GSON.b((Object) this);
        j.a((Object) b2, "WebRegister.GSON.toJson(this)");
        return b2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final BridgeResult<?> success() {
            return new BridgeResult(0, (Object) null, (String) null, 6, (g) null);
        }

        public final <T> BridgeResult<?> success(T t) {
            return new BridgeResult(0, t, (String) null, 4, (g) null);
        }

        public final BridgeResult<?> fail() {
            return new BridgeResult(-1, "Unknown Error", (String) null, 4, (g) null);
        }

        public final BridgeResult<?> fail(int i) {
            return new BridgeResult(i, "", (String) null, 4, (g) null);
        }

        public final BridgeResult<?> fail(int i, String str) {
            return new BridgeResult<>(i, "", str, (g) null);
        }

        public final <T> BridgeResult<?> fail(int i, T t, String str) {
            return new BridgeResult<>(i, t, str, (g) null);
        }
    }
}
