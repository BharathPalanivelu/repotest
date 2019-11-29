package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.a.d;
import com.google.firebase.c.f;
import com.google.firebase.c.g;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
public final class Registrar implements h {

    private static class a implements com.google.firebase.iid.a.a {

        /* renamed from: a  reason: collision with root package name */
        private final FirebaseInstanceId f14087a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.f14087a = firebaseInstanceId;
        }
    }

    @Keep
    public final List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(FirebaseInstanceId.class).a(n.b(com.google.firebase.b.class)).a(n.b(d.class)).a(n.b(g.class)).a(s.f14176a).a().c(), b.a(com.google.firebase.iid.a.a.class).a(n.b(FirebaseInstanceId.class)).a(r.f14175a).c(), f.a("fire-iid", "18.0.0")});
    }
}
