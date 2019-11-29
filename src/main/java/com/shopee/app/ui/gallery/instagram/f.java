package com.shopee.app.ui.gallery.instagram;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.instagram.h;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.gallery.GalleryBrowserActivity_;
import com.shopee.app.ui.gallery.GalleryData;
import com.shopee.app.ui.gallery.f;
import com.shopee.app.ui.gallery.n;
import com.shopee.app.util.bc;
import com.shopee.app.util.w;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f extends FrameLayout implements f.b {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f21946a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21947b;

    /* renamed from: c  reason: collision with root package name */
    bc f21948c;

    /* renamed from: d  reason: collision with root package name */
    Activity f21949d;

    /* renamed from: e  reason: collision with root package name */
    d f21950e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f21951f;

    /* renamed from: g  reason: collision with root package name */
    r f21952g;
    UserInfo h;
    private com.shopee.app.ui.gallery.f i;
    private final int j;
    private a.b k;
    /* access modifiers changed from: private */
    public GridLayoutManager l;
    private boolean m;
    /* access modifiers changed from: private */
    public Map<String, h> n;
    private List<h> o;
    private final String p;
    private a.b q = new a.b("SUBMIT_PHOTO", R.drawable.com_garena_shopee_ic_done) {
        public void a() {
            ArrayList<String> f2 = f.this.f21950e.f();
            new a().execute(f2.toArray(new String[f2.size()]));
        }
    };
    private RecyclerView.n r = new RecyclerView.n() {

        /* renamed from: b  reason: collision with root package name */
        private int f21959b = 0;

        /* renamed from: c  reason: collision with root package name */
        private boolean f21960c = true;

        /* renamed from: d  reason: collision with root package name */
        private int f21961d = 3;

        /* renamed from: e  reason: collision with root package name */
        private int f21962e;

        /* renamed from: f  reason: collision with root package name */
        private int f21963f;

        /* renamed from: g  reason: collision with root package name */
        private int f21964g;

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            this.f21963f = f.this.f21946a.getChildCount();
            this.f21964g = f.this.l.I();
            this.f21962e = f.this.l.n();
            if (this.f21960c) {
                int i3 = this.f21964g;
                if (i3 > this.f21959b) {
                    this.f21960c = false;
                    this.f21959b = i3;
                }
            }
            if (!this.f21960c && this.f21964g - this.f21963f <= this.f21962e + this.f21961d) {
                f.this.f21950e.g();
                this.f21960c = true;
            }
        }
    };

    public f(Context context, int i2, boolean z, String str) {
        super(context);
        setId(R.id.view);
        this.j = i2;
        this.p = str;
        ((c) ((x) context).b()).a(this);
        setBackgroundColor(Color.parseColor("#161719"));
        this.m = z;
        this.n = new HashMap();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.n = (Map) WebRegister.GSON.a(bundle.getString("instagramInfoMap"), new com.google.a.c.a<Map<String, h>>() {
            }.getType());
            this.o = (List) WebRegister.GSON.a(bundle.getString("instagramDataList"), new com.google.a.c.a<List<h>>() {
            }.getType());
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putString("instagramDataList", WebRegister.GSON.b(this.o, new com.google.a.c.a<List<h>>() {
        }.getType()));
        bundle.putString("instagramInfoMap", WebRegister.GSON.b(this.n, new com.google.a.c.a<Map<String, h>>() {
        }.getType()));
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21948c.a(this.f21950e);
        this.f21950e.a(this);
        boolean z = this.j == 1;
        this.f21946a.setHasFixedSize(true);
        this.l = new GridLayoutManager(getContext(), 3);
        this.f21946a.setLayoutManager(this.l);
        this.f21946a.a((RecyclerView.h) new n(b.a.f7693d));
        this.f21946a.a(this.r);
        this.i = new com.shopee.app.ui.gallery.f(z, this.p);
        this.i.a((f.b) this);
        this.i.setHasStableIds(true);
        this.i.a((f.a) this.f21950e);
        this.f21946a.setAdapter(this.i);
        if (this.m) {
            this.f21950e.a(this.j);
        }
        if (z) {
            this.f21947b.setVisibility(8);
        }
        b();
    }

    public void b() {
        int e2 = this.f21950e.e();
        b(e2);
        a(e2);
    }

    public void a(int i2) {
        TextView textView = this.f21947b;
        textView.setText(i2 + Constants.URL_PATH_DELIMITER + this.j);
    }

    public void b(int i2) {
        if (i2 >= 1) {
            e();
        } else {
            f();
        }
    }

    private void e() {
        if (this.k != this.q) {
            this.f21951f.c();
            this.f21951f.a(this.q);
            this.k = this.q;
        }
    }

    private void f() {
        if (this.k == this.q) {
            this.f21951f.c();
            this.k = null;
        }
    }

    public void a(List<GalleryItemInfo> list, HashMap<String, h> hashMap, List<h> list2) {
        if (!list.isEmpty()) {
            this.n = hashMap;
            this.o = list2;
            a(list);
        }
    }

    public void a(List<GalleryItemInfo> list) {
        if (!list.isEmpty()) {
            this.i.a(list);
            this.i.notifyDataSetChanged();
        }
    }

    public void a(String str) {
        com.shopee.app.h.r.a().a(str);
    }

    public void a(List<GalleryData> list, int i2, GalleryData galleryData) {
        if (galleryData.a()) {
            com.shopee.app.h.r.a().a(w.a(this.p));
            return;
        }
        GalleryBrowserActivity_.a(getContext()).a((ArrayList<GalleryData>) new ArrayList(list)).a(-98).a(galleryData).b(this.f21950e.e()).c(this.j).a(this.p).a(10092);
    }

    public void a(Intent intent) {
        this.f21950e.a(intent);
    }

    public void a(ArrayList<GalleryData> arrayList) {
        this.f21950e.a(arrayList);
    }

    public void c(int i2) {
        h hVar;
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f21950e.f().iterator();
        while (it.hasNext()) {
            arrayList.add(Uri.fromFile(new File(it.next())).toString());
        }
        intent.putStringArrayListExtra("imageList", arrayList);
        try {
            hVar = this.o.get(i2);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            hVar = null;
        }
        if (hVar != null) {
            intent.putExtra("instagramPackets", WebRegister.GSON.b(hVar, h.class));
        }
        this.f21949d.setResult(-1, intent);
        this.f21949d.finish();
    }

    public void c() {
        this.f21952g.a();
    }

    public void d() {
        this.f21952g.b();
    }

    private class a extends AsyncTask<String, Void, List<String>> {
        private a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            f.this.f21952g.a();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x008f A[SYNTHETIC, Splitter:B:29:0x008f] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0097 A[SYNTHETIC, Splitter:B:33:0x0097] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x009f A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00a4 A[SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<java.lang.String> doInBackground(java.lang.String... r10) {
            /*
                r9 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                int r1 = r10.length
                r2 = 0
                r3 = 0
            L_0x0008:
                if (r3 >= r1) goto L_0x00a8
                r4 = r10[r3]
                com.shopee.app.h.f r5 = com.shopee.app.h.f.a()
                java.lang.String r6 = com.shopee.app.g.c.a((java.lang.String) r4)
                java.lang.String r5 = r5.b(r6)
                com.shopee.app.ui.gallery.instagram.f r6 = com.shopee.app.ui.gallery.instagram.f.this
                java.util.Map r6 = r6.n
                java.lang.Object r6 = r6.get(r4)
                com.shopee.app.instagram.h r6 = (com.shopee.app.instagram.h) r6
                if (r6 == 0) goto L_0x002f
                com.shopee.app.ui.gallery.instagram.f r7 = com.shopee.app.ui.gallery.instagram.f.this
                java.util.Map r7 = r7.n
                r7.put(r5, r6)
            L_0x002f:
                java.io.File r6 = new java.io.File
                r6.<init>(r5)
                boolean r6 = r6.exists()
                if (r6 == 0) goto L_0x003e
                r0.add(r5)
                goto L_0x00a4
            L_0x003e:
                com.shopee.app.ui.gallery.instagram.f r6 = com.shopee.app.ui.gallery.instagram.f.this     // Catch:{ IOException -> 0x00a0 }
                android.content.Context r6 = r6.getContext()     // Catch:{ IOException -> 0x00a0 }
                com.squareup.a.w r6 = com.squareup.a.w.a((android.content.Context) r6)     // Catch:{ IOException -> 0x00a0 }
                com.squareup.a.aa r4 = r6.a((java.lang.String) r4)     // Catch:{ IOException -> 0x00a0 }
                com.squareup.a.r r6 = com.squareup.a.r.NO_CACHE     // Catch:{ IOException -> 0x00a0 }
                r7 = 1
                com.squareup.a.r[] r7 = new com.squareup.a.r[r7]     // Catch:{ IOException -> 0x00a0 }
                com.squareup.a.r r8 = com.squareup.a.r.NO_STORE     // Catch:{ IOException -> 0x00a0 }
                r7[r2] = r8     // Catch:{ IOException -> 0x00a0 }
                com.squareup.a.aa r4 = r4.a((com.squareup.a.r) r6, (com.squareup.a.r[]) r7)     // Catch:{ IOException -> 0x00a0 }
                android.graphics.Bitmap r4 = r4.h()     // Catch:{ IOException -> 0x00a0 }
                r6 = 0
                com.shopee.app.h.l r7 = com.shopee.app.h.l.a()     // Catch:{ Exception -> 0x0089 }
                r8 = 100
                byte[] r4 = r7.a((android.graphics.Bitmap) r4, (int) r8)     // Catch:{ Exception -> 0x0089 }
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0089 }
                java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x0089 }
                r8.<init>(r5)     // Catch:{ Exception -> 0x0089 }
                r7.<init>(r8)     // Catch:{ Exception -> 0x0089 }
                r7.write(r4)     // Catch:{ Exception -> 0x0084, all -> 0x0081 }
                r0.add(r5)     // Catch:{ Exception -> 0x0084, all -> 0x0081 }
                r7.close()     // Catch:{ IOException -> 0x007c }
                goto L_0x00a4
            L_0x007c:
                r4 = move-exception
            L_0x007d:
                com.garena.android.appkit.d.a.a(r4)     // Catch:{ IOException -> 0x00a0 }
                goto L_0x00a4
            L_0x0081:
                r4 = move-exception
                r6 = r7
                goto L_0x0095
            L_0x0084:
                r4 = move-exception
                r6 = r7
                goto L_0x008a
            L_0x0087:
                r4 = move-exception
                goto L_0x0095
            L_0x0089:
                r4 = move-exception
            L_0x008a:
                com.garena.android.appkit.d.a.a(r4)     // Catch:{ all -> 0x0087 }
                if (r6 == 0) goto L_0x00a4
                r6.close()     // Catch:{ IOException -> 0x0093 }
                goto L_0x00a4
            L_0x0093:
                r4 = move-exception
                goto L_0x007d
            L_0x0095:
                if (r6 == 0) goto L_0x009f
                r6.close()     // Catch:{ IOException -> 0x009b }
                goto L_0x009f
            L_0x009b:
                r5 = move-exception
                com.garena.android.appkit.d.a.a(r5)     // Catch:{ IOException -> 0x00a0 }
            L_0x009f:
                throw r4     // Catch:{ IOException -> 0x00a0 }
            L_0x00a0:
                r4 = move-exception
                com.garena.android.appkit.d.a.a(r4)
            L_0x00a4:
                int r3 = r3 + 1
                goto L_0x0008
            L_0x00a8:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.gallery.instagram.f.a.doInBackground(java.lang.String[]):java.util.List");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<String> list) {
            f.this.f21952g.b();
            Intent intent = new Intent();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String next : list) {
                String uri = Uri.fromFile(new File(next)).toString();
                arrayList2.add((h) f.this.n.get(next));
                arrayList.add(uri);
            }
            intent.putStringArrayListExtra("imageList", arrayList);
            if (arrayList2.get(0) != null) {
                intent.putExtra("instagramPackets", WebRegister.GSON.b(arrayList2.get(0), h.class));
            }
            f.this.f21949d.setResult(-1, intent);
            f.this.f21949d.finish();
        }
    }
}
