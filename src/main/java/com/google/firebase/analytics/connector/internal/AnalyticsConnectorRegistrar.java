package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.a.d;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.c.f;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
public class AnalyticsConnectorRegistrar implements h {
    @SuppressLint({"MissingPermission"})
    @Keep
    @KeepForSdk
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(a.class).a(n.b(com.google.firebase.b.class)).a(n.b(Context.class)).a(n.b(d.class)).a(a.f6782a).b().c(), f.a("fire-analytics", "16.5.0")});
    }
}
