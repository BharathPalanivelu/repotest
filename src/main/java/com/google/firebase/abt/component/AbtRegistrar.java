package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.c.f;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import java.util.Arrays;
import java.util.List;

@Keep
public class AbtRegistrar implements h {
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(a.class).a(n.b(Context.class)).a(n.a(a.class)).a(b.f6763a).c(), f.a("fire-abt", "17.1.1")});
    }
}
