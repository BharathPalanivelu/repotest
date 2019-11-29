package com.google.firebase.perf;

import androidx.annotation.Keep;
import com.google.firebase.c.f;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.remoteconfig.j;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebasePerfRegistrar implements h {
    @Keep
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(a.class).a(n.b(com.google.firebase.b.class)).a(n.b(j.class)).a(b.f14224a).b().c(), f.a("fire-perf", "17.0.2")});
    }
}
