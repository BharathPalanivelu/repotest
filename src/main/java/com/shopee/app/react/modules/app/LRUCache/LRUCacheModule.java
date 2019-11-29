package com.shopee.app.react.modules.app.LRUCache;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.WebRegister;
import com.shopee.react.sdk.bridge.modules.app.lrucache.LruCacheModule;
import d.d.b.j;
import d.d.b.k;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;

@ReactModule(name = "LRUCache")
public final class LRUCacheModule extends ReactContextBaseJavaModule {
    static final /* synthetic */ d.f.e[] $$delegatedProperties = {p.a((m) new n(p.a(LRUCacheModule.class), "cache", "getCache()Lcom/shopee/app/react/modules/app/LRUCache/Cache;"))};
    private final d.e cache$delegate = d.f.a(new a(this));
    private final ReactApplicationContext reactContext;

    public final a getCache() {
        d.e eVar = this.cache$delegate;
        d.f.e eVar2 = $$delegatedProperties[0];
        return (a) eVar.a();
    }

    public String getName() {
        return LruCacheModule.NAME;
    }

    public final ReactApplicationContext getReactContext() {
        return this.reactContext;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LRUCacheModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        j.b(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
    }

    static final class a extends k implements d.d.a.a<a> {
        final /* synthetic */ LRUCacheModule this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(LRUCacheModule lRUCacheModule) {
            super(0);
            this.this$0 = lRUCacheModule;
        }

        /* renamed from: a */
        public final a invoke() {
            return new a(this.this$0.getReactContext());
        }
    }

    @ReactMethod
    public final void put(String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        c cVar = (c) WebRegister.GSON.a(str, c.class);
        if (TextUtils.isEmpty(cVar.b()) || TextUtils.isEmpty(cVar.a())) {
            promise.resolve(BridgeResult.Companion.fail(2).toString());
        } else {
            getCache().a(cVar.a(), cVar.b()).a(io.b.h.a.b()).a(new d(promise), new e(promise));
        }
    }

    static final class d implements io.b.d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18699a;

        d(Promise promise) {
            this.f18699a = promise;
        }

        public final void a() {
            this.f18699a.resolve(BridgeResult.Companion.success().toString());
        }
    }

    static final class e<T> implements io.b.d.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18700a;

        e(Promise promise) {
            this.f18700a = promise;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f18700a.resolve(BridgeResult.Companion.fail(2).toString());
        }
    }

    @ReactMethod
    public final void get(String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        b bVar = (b) WebRegister.GSON.a(str, b.class);
        if (TextUtils.isEmpty(bVar.a())) {
            promise.resolve(BridgeResult.Companion.fail(1).toString());
        } else {
            getCache().a(bVar.a()).b(io.b.h.a.b()).a(new b(promise), new c(promise));
        }
    }

    static final class b<T> implements io.b.d.f<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18697a;

        b(Promise promise) {
            this.f18697a = promise;
        }

        /* renamed from: a */
        public final void accept(String str) {
            this.f18697a.resolve(BridgeResult.Companion.success(str).toString());
        }
    }

    static final class c<T> implements io.b.d.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18698a;

        c(Promise promise) {
            this.f18698a = promise;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f18698a.resolve(BridgeResult.Companion.fail(2).toString());
        }
    }

    @ReactMethod
    public final void remove(String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        getCache().b(((b) WebRegister.GSON.a(str, b.class)).a()).a(io.b.h.a.b()).a(new f(promise), new g(promise));
    }

    static final class f implements io.b.d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18701a;

        f(Promise promise) {
            this.f18701a = promise;
        }

        public final void a() {
            this.f18701a.resolve(BridgeResult.Companion.success().toString());
        }
    }

    static final class g<T> implements io.b.d.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18702a;

        g(Promise promise) {
            this.f18702a = promise;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f18702a.resolve(BridgeResult.Companion.fail(1).toString());
        }
    }

    @ReactMethod
    public final void removeAll(String str, Promise promise) {
        j.b(str, NativeProtocol.WEB_DIALOG_PARAMS);
        j.b(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        getCache().b().a(io.b.h.a.b()).a(new h(promise), new i(promise));
    }

    static final class h implements io.b.d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18703a;

        h(Promise promise) {
            this.f18703a = promise;
        }

        public final void a() {
            this.f18703a.resolve(BridgeResult.Companion.success().toString());
        }
    }

    static final class i<T> implements io.b.d.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f18704a;

        i(Promise promise) {
            this.f18704a = promise;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f18704a.resolve(BridgeResult.Companion.fail(1).toString());
        }
    }
}
