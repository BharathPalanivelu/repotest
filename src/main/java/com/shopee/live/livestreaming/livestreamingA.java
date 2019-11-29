package com.shopee.live.livestreaming;

import android.content.Context;
import com.shopee.live.livestreaming.data.store.LiveStreamingStore;
import com.shopee.live.livestreaming.util.aa;

public class livestreamingA extends com.shopee.sdk.sdkA.sdkA {
//public class a extends com.shopee.sdk.sdkA.sdkA {

    /* renamed from: a  reason: collision with root package name */
    public static int f28741a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f28742b;

    /* renamed from: c  reason: collision with root package name */
    private LiveStreamingStore f28743c;

    public livestreamingA(Context context) {
        super(context);
        this.f28742b = context;
    }

    public LiveStreamingStore a() {
        if (this.f28743c == null) {
            this.f28743c = new LiveStreamingStore(this.f28742b.getSharedPreferences("livestreaming_module_store", 0));
        }
        return this.f28743c;
    }

    public aa b() {
        return aa.a(this.f28742b);
    }

    public Context c() {
        return this.f28742b;
    }
}
