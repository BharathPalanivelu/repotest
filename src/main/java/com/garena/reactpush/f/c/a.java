package com.garena.reactpush.f.c;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.garena.reactpush.b;
import com.garena.reactpush.c.d;
import com.garena.reactpush.c.g;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ReactBundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class a extends com.garena.reactpush.e.c.a {
    public a(String str) {
        super(str);
    }

    public void onReactContextInitialized(ReactContext reactContext) {
        if (this.f8412e) {
            new C0146a().execute(new Void[0]);
            return;
        }
        this.f8411d = true;
        if (this.f8409b != null) {
            this.f8409b.a();
        }
    }

    public void a(boolean z) {
        super.a(z);
        if (z && this.f8411d && !this.f8413f) {
            new C0146a().execute(new Void[0]);
        }
    }

    public String d() {
        for (ReactBundle next : a().getBundles()) {
            if (next.getPriority() == 0) {
                return this.f8408a.concat(next.getName()).concat(".bundle");
            }
        }
        return "";
    }

    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: com.garena.reactpush.f.c.a$a  reason: collision with other inner class name */
    private class C0146a extends AsyncTask<Void, Void, Boolean> {
        private C0146a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            Manifest a2 = a.this.a();
            CatalystInstance a3 = g.a(a.this.f8410c);
            ArrayList<ReactBundle> arrayList = new ArrayList<>(a2.getBundles());
            Collections.sort(arrayList, new Comparator<ReactBundle>() {
                /* renamed from: a */
                public int compare(ReactBundle reactBundle, ReactBundle reactBundle2) {
                    return reactBundle.getPriority() - reactBundle2.getPriority();
                }
            });
            for (ReactBundle reactBundle : arrayList) {
                if (reactBundle.getPriority() > 0) {
                    String name = reactBundle.getName();
                    d dVar = b.f6701d;
                    dVar.a("Loading Sub Bundle: [" + name + "]");
                    g.a(a3, a.this.f8408a.concat(name).concat(".bundle"));
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            a aVar = a.this;
            aVar.f8411d = true;
            aVar.f8413f = true;
            if (aVar.f8409b != null) {
                a.this.f8409b.a();
            }
        }
    }
}
