package com.google.firebase.abt.component;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.abt.b;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, b> f6760a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f6761b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.analytics.connector.a f6762c;

    protected a(Context context, com.google.firebase.analytics.connector.a aVar) {
        this.f6761b = context;
        this.f6762c = aVar;
    }

    @KeepForSdk
    public synchronized b a(String str) {
        if (!this.f6760a.containsKey(str)) {
            this.f6760a.put(str, new b(this.f6761b, this.f6762c, str));
        }
        return this.f6760a.get(str);
    }
}
