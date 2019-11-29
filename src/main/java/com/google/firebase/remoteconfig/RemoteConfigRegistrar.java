package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.abt.component.a;
import com.google.firebase.c.f;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;

@Keep
public class RemoteConfigRegistrar implements h {
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(j.class).a(n.b(Context.class)).a(n.b(com.google.firebase.b.class)).a(n.b(FirebaseInstanceId.class)).a(n.b(a.class)).a(n.a(com.google.firebase.analytics.connector.a.class)).a(t.f14372a).a().c(), f.a("fire-rc", "17.0.0")});
    }
}
