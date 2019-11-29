package com.shopee.app.react.f;

import com.google.a.l;
import com.shopee.app.application.ar;
import com.shopee.app.util.n;
import com.shopee.app.web.processor.WebProcessor;

public class b extends WebProcessor {
    public void onProcess(l lVar) {
        a().a();
    }

    public a a() {
        return ar.f().e().reactPageDidMountProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f18672a;

        public a(n nVar) {
            this.f18672a = nVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f18672a.a().i.a();
        }
    }
}
