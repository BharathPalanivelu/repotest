package com.google.maps.android.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.maps.android.a.c;
import com.google.maps.android.a.h;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class m extends h {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<String> f14406a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f14407b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14408c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public HashMap<e, GroundOverlay> f14409d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b> f14410e;

    m(GoogleMap googleMap, Context context) {
        super(googleMap, context);
    }

    private static BitmapDescriptor a(Bitmap bitmap, Double d2) {
        double width = (double) bitmap.getWidth();
        double doubleValue = d2.doubleValue();
        Double.isNaN(width);
        double height = (double) bitmap.getHeight();
        double doubleValue2 = d2.doubleValue();
        Double.isNaN(height);
        return BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(bitmap, (int) (width * doubleValue), (int) (height * doubleValue2), false));
    }

    static boolean a(b bVar, boolean z) {
        boolean z2 = !bVar.c("visibility") || Integer.parseInt(bVar.b("visibility")) != 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public void j() {
        a(true);
        this.f14409d = g();
        this.f14410e = h();
        i();
        a(e(), d());
        a(this.f14409d, (Iterable<b>) this.f14410e);
        a((Iterable<b>) this.f14410e, true);
        b(b());
        if (!this.f14408c) {
            m();
        }
        if (!this.f14407b) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(HashMap<String, n> hashMap, HashMap<String, String> hashMap2, HashMap<j, Object> hashMap3, ArrayList<b> arrayList, HashMap<e, GroundOverlay> hashMap4) {
        a(hashMap, hashMap2, hashMap3, arrayList, hashMap4);
    }

    public Iterable<b> k() {
        return this.f14410e;
    }

    private void b(HashMap<? extends com.google.maps.android.a.b, Object> hashMap) {
        for (com.google.maps.android.a.b a2 : hashMap.keySet()) {
            a(a2);
        }
    }

    private void a(Iterable<b> iterable, boolean z) {
        for (b next : iterable) {
            boolean a2 = a(next, z);
            if (next.a() != null) {
                a(next.a());
            }
            if (next.b() != null) {
                super.a(next.b(), d());
            }
            b(next, a2);
            if (next.e()) {
                a(next.f(), a2);
            }
        }
    }

    private void b(b bVar, boolean z) {
        for (com.google.maps.android.a.b next : bVar.g()) {
            boolean z2 = z && b(next);
            if (next.c() != null) {
                String b2 = next.b();
                c c2 = next.c();
                n a2 = a(b2);
                j jVar = (j) next;
                Object a3 = a(jVar, c2, a2, jVar.f(), z2);
                bVar.a(jVar, a3);
                a(a3, next);
            }
        }
    }

    private void l() {
        this.f14407b = true;
        Iterator<String> it = c().iterator();
        while (it.hasNext()) {
            new b(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, HashMap<j, Object> hashMap) {
        for (com.google.maps.android.a.b next : hashMap.keySet()) {
            n nVar = d().get(next.b());
            j jVar = (j) next;
            n f2 = jVar.f();
            if ("Point".equals(next.c().c())) {
                boolean z = true;
                boolean z2 = f2 != null && str.equals(f2.g());
                if (nVar == null || !str.equals(nVar.g())) {
                    z = false;
                }
                if (z2) {
                    a(f2, hashMap, jVar);
                } else if (z) {
                    a(nVar, hashMap, jVar);
                }
            }
        }
    }

    private void a(n nVar, HashMap<j, Object> hashMap, j jVar) {
        double d2 = nVar.d();
        ((Marker) hashMap.get(jVar)).setIcon(a(f().get(nVar.g()), Double.valueOf(d2)));
    }

    /* access modifiers changed from: private */
    public void a(String str, Iterable<b> iterable) {
        for (b next : iterable) {
            a(str, next.d());
            if (next.e()) {
                a(str, next.f());
            }
        }
    }

    private void a(HashMap<e, GroundOverlay> hashMap, Iterable<b> iterable) {
        c(hashMap);
        for (b next : iterable) {
            a(next.c(), next.f());
        }
    }

    private void c(HashMap<e, GroundOverlay> hashMap) {
        for (e next : hashMap.keySet()) {
            String a2 = next.a();
            if (!(a2 == null || next.b() == null)) {
                if (f().get(a2) != null) {
                    a(a2, this.f14409d, true);
                } else if (!this.f14406a.contains(a2)) {
                    this.f14406a.add(a2);
                }
            }
        }
    }

    private void m() {
        this.f14408c = true;
        Iterator<String> it = this.f14406a.iterator();
        while (it.hasNext()) {
            new a(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, HashMap<e, GroundOverlay> hashMap, boolean z) {
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(f().get(str));
        for (e next : hashMap.keySet()) {
            if (next.a().equals(str)) {
                GroundOverlay a2 = a(next.c().image(fromBitmap));
                if (!z) {
                    a2.setVisible(false);
                }
                hashMap.put(next, a2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, Iterable<b> iterable, boolean z) {
        for (b next : iterable) {
            boolean a2 = a(next, z);
            a(str, next.c(), a2);
            if (next.e()) {
                a(str, next.f(), a2);
            }
        }
    }

    private class b extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        private final String f14414b;

        public b(String str) {
            this.f14414b = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            try {
                return BitmapFactory.decodeStream((InputStream) FirebasePerfUrlConnection.getContent(new URL(this.f14414b)));
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.f14414b);
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap == null) {
                Log.e("KmlRenderer", "Image at this URL could not be found " + this.f14414b);
                return;
            }
            m.this.a(this.f14414b, bitmap);
            if (m.this.a()) {
                m mVar = m.this;
                mVar.a(this.f14414b, (HashMap<j, Object>) mVar.b());
                m mVar2 = m.this;
                mVar2.a(this.f14414b, (Iterable<b>) mVar2.f14410e);
            }
        }
    }

    private class a extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        private final String f14412b;

        public a(String str) {
            this.f14412b = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            try {
                return BitmapFactory.decodeStream((InputStream) FirebasePerfUrlConnection.getContent(new URL(this.f14412b)));
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.f14412b);
            } catch (IOException e2) {
                Log.e("KmlRenderer", "Image [" + this.f14412b + "] download issue", e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap == null) {
                Log.e("KmlRenderer", "Image at this URL could not be found " + this.f14412b);
                return;
            }
            m.this.a(this.f14412b, bitmap);
            if (m.this.a()) {
                m mVar = m.this;
                mVar.a(this.f14412b, (HashMap<e, GroundOverlay>) mVar.f14409d, true);
                m mVar2 = m.this;
                mVar2.a(this.f14412b, (Iterable<b>) mVar2.f14410e, true);
            }
        }
    }
}
