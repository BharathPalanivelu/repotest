package com.shopee.app.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.appsflyer.share.Constants;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.aa;
import com.shopee.app.util.af;
import com.shopee.app.util.bc;
import com.shopee.app.util.bj;
import com.shopee.app.util.w;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class j extends FrameLayout {
    /* access modifiers changed from: private */
    public static CharSequence[] p = new CharSequence[1];

    /* renamed from: a  reason: collision with root package name */
    GImageBrowserView f21966a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f21967b;

    /* renamed from: c  reason: collision with root package name */
    int f21968c;

    /* renamed from: d  reason: collision with root package name */
    int f21969d;

    /* renamed from: e  reason: collision with root package name */
    Activity f21970e;

    /* renamed from: f  reason: collision with root package name */
    h f21971f;

    /* renamed from: g  reason: collision with root package name */
    bc f21972g;
    r h;
    UserInfo i;
    /* access modifiers changed from: private */
    public List<GalleryData> j;
    /* access modifiers changed from: private */
    public final int k;
    /* access modifiers changed from: private */
    public int l = 0;
    private GalleryData m;
    private final long n;
    private final String o;

    static /* synthetic */ int d(j jVar) {
        int i2 = jVar.l;
        jVar.l = i2 + 1;
        return i2;
    }

    static /* synthetic */ int e(j jVar) {
        int i2 = jVar.l;
        jVar.l = i2 - 1;
        return i2;
    }

    public j(Context context, List<GalleryData> list, long j2, int i2, GalleryData galleryData, int i3, String str) {
        super(context);
        ((m) ((x) context).b()).a(this);
        this.j = w.a(list);
        this.k = i2;
        this.n = j2;
        this.m = galleryData;
        this.l = i3;
        this.o = str;
    }

    static {
        p[0] = com.garena.android.appkit.tools.b.e(R.string.sp_saved_to_photo);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21972g.a(this.f21971f);
        this.f21971f.a(this);
        this.f21966a.setBackgroundColor(-16777216);
        this.f21966a.setAdapter(new a());
        this.f21967b.setVisibility(this.k == 1 ? 0 : 8);
        this.f21971f.a(this.n);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putInt("selectedCount", this.l);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.l = bundle.getInt("selectedCount");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f21970e.onBackPressed();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (af.a(this.j)) {
            com.shopee.app.h.r.a().b((int) R.string.sp_unable_to_load_image);
            return;
        }
        String str = this.j.get(this.f21966a.getSelectedIndex()).f21838b;
        if (new File(str).exists()) {
            Intent intent = new Intent();
            this.j.get(this.f21966a.getSelectedIndex()).f21837a = true;
            intent.putParcelableArrayListExtra("imageList", getImageList());
            intent.putExtra("submit", true);
            intent.putExtra("index", this.f21966a.getSelectedIndex());
            this.f21970e.setResult(-1, intent);
            this.f21970e.finish();
        } else if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
            com.shopee.app.h.r.a().b((int) R.string.sp_unable_to_load_image);
        } else {
            new b().execute(new String[]{str});
        }
    }

    public ArrayList<GalleryData> getImageList() {
        ArrayList<GalleryData> arrayList = new ArrayList<>();
        for (GalleryData next : this.j) {
            if (next.f21837a) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void setImageList(List<GalleryItemInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (GalleryItemInfo next : list) {
            boolean z = false;
            for (GalleryData next2 : this.j) {
                if (next2.f21838b.equals(next.getPath()) && next2.f21837a) {
                    z = true;
                }
            }
            arrayList.add(GalleryData.a(next, z, !w.a(next, this.o)));
        }
        this.j = w.a((List<GalleryData>) arrayList);
        this.f21966a.a();
        GalleryData galleryData = this.m;
        if (galleryData != null && this.j.indexOf(galleryData) != -1) {
            this.f21966a.setSelectedIndex(this.j.indexOf(this.m));
        }
    }

    public void d() {
        this.f21966a.a();
        GalleryData galleryData = this.m;
        if (galleryData != null && this.j.indexOf(galleryData) != -1) {
            this.f21966a.setSelectedIndex(this.j.indexOf(this.m));
        }
    }

    private class a extends com.garena.android.uikit.image.browser.a<GalleryData> {
        private a() {
        }

        public List<GalleryData> a() {
            return j.this.j;
        }

        /* access modifiers changed from: private */
        public void a(TextView textView) {
            textView.setText(SQLBuilder.PARENTHESES_LEFT + j.this.l + Constants.URL_PATH_DELIMITER + j.this.k + SQLBuilder.PARENTHESES_RIGHT);
        }

        public View a(Context context, GalleryData galleryData, int i) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(context, R.layout.gallery_browser_overlay_layout, (ViewGroup) null);
            CheckBox checkBox = (CheckBox) frameLayout.findViewById(R.id.checkbox);
            final TextView textView = (TextView) frameLayout.findViewById(R.id.label_view);
            if (j.this.k != 1) {
                textView.setVisibility(0);
                a(textView);
            } else {
                textView.setVisibility(8);
            }
            if (j.this.k == 1) {
                checkBox.setVisibility(8);
            } else {
                checkBox.setVisibility(0);
                final boolean z = galleryData.f21837a;
                checkBox.setChecked(galleryData.f21837a);
                final CheckBox checkBox2 = checkBox;
                final GalleryData galleryData2 = galleryData;
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            j.d(j.this);
                        } else {
                            j.e(j.this);
                        }
                        if (j.this.l <= j.this.k || z) {
                            a.this.a(textView);
                            galleryData2.f21837a = z;
                            return;
                        }
                        com.shopee.app.h.r.a().b((int) R.string.sp_gallery_max_reached);
                        checkBox2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                        checkBox2.setChecked(false);
                        checkBox2.setOnCheckedChangeListener(this);
                        j.e(j.this);
                    }
                });
            }
            return frameLayout;
        }

        public void c(View view, View view2, int i) {
            super.c(view, view2, i);
            TextView textView = (TextView) view2.findViewById(R.id.label_view);
            if (j.this.k != 1) {
                textView.setVisibility(0);
                a(textView);
                return;
            }
            textView.setVisibility(8);
        }

        public void a(com.garena.android.uikit.image.c.a aVar, GalleryData galleryData, int i) {
            aa.a(j.this.getContext(), aVar, galleryData.f21838b);
            bj.a(aVar.getActualImageView(), j.this.getContext(), j.p);
        }

        public void a(View view, View view2, int i) {
            super.a(view, view2, i);
            com.squareup.a.af afVar = (com.squareup.a.af) view.getTag();
            if (afVar != null) {
                com.squareup.a.w.a(j.this.getContext()).a(afVar);
            }
            view.setTag("");
        }
    }

    private class b extends AsyncTask<String, Void, List<String>> {
        private b() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            j.this.h.a();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0078 A[SYNTHETIC, Splitter:B:26:0x0078] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0080 A[SYNTHETIC, Splitter:B:30:0x0080] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0088 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x008d A[SYNTHETIC] */
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
                if (r3 >= r1) goto L_0x0091
                r4 = r10[r3]
                com.shopee.app.h.f r5 = com.shopee.app.h.f.a()
                java.lang.String r6 = com.shopee.app.g.c.a((java.lang.String) r4)
                java.lang.String r5 = r5.b(r6)
                java.io.File r6 = new java.io.File
                r6.<init>(r5)
                boolean r6 = r6.exists()
                if (r6 == 0) goto L_0x0027
                r0.add(r5)
                goto L_0x008d
            L_0x0027:
                com.shopee.app.ui.gallery.j r6 = com.shopee.app.ui.gallery.j.this     // Catch:{ IOException -> 0x0089 }
                android.content.Context r6 = r6.getContext()     // Catch:{ IOException -> 0x0089 }
                com.squareup.a.w r6 = com.squareup.a.w.a((android.content.Context) r6)     // Catch:{ IOException -> 0x0089 }
                com.squareup.a.aa r4 = r6.a((java.lang.String) r4)     // Catch:{ IOException -> 0x0089 }
                com.squareup.a.r r6 = com.squareup.a.r.NO_CACHE     // Catch:{ IOException -> 0x0089 }
                r7 = 1
                com.squareup.a.r[] r7 = new com.squareup.a.r[r7]     // Catch:{ IOException -> 0x0089 }
                com.squareup.a.r r8 = com.squareup.a.r.NO_STORE     // Catch:{ IOException -> 0x0089 }
                r7[r2] = r8     // Catch:{ IOException -> 0x0089 }
                com.squareup.a.aa r4 = r4.a((com.squareup.a.r) r6, (com.squareup.a.r[]) r7)     // Catch:{ IOException -> 0x0089 }
                android.graphics.Bitmap r4 = r4.h()     // Catch:{ IOException -> 0x0089 }
                r6 = 0
                com.shopee.app.h.l r7 = com.shopee.app.h.l.a()     // Catch:{ Exception -> 0x0072 }
                r8 = 100
                byte[] r4 = r7.a((android.graphics.Bitmap) r4, (int) r8)     // Catch:{ Exception -> 0x0072 }
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0072 }
                java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x0072 }
                r8.<init>(r5)     // Catch:{ Exception -> 0x0072 }
                r7.<init>(r8)     // Catch:{ Exception -> 0x0072 }
                r7.write(r4)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
                r0.add(r5)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
                r7.close()     // Catch:{ IOException -> 0x0065 }
                goto L_0x008d
            L_0x0065:
                r4 = move-exception
            L_0x0066:
                com.garena.android.appkit.d.a.a(r4)     // Catch:{ IOException -> 0x0089 }
                goto L_0x008d
            L_0x006a:
                r4 = move-exception
                r6 = r7
                goto L_0x007e
            L_0x006d:
                r4 = move-exception
                r6 = r7
                goto L_0x0073
            L_0x0070:
                r4 = move-exception
                goto L_0x007e
            L_0x0072:
                r4 = move-exception
            L_0x0073:
                com.garena.android.appkit.d.a.a(r4)     // Catch:{ all -> 0x0070 }
                if (r6 == 0) goto L_0x008d
                r6.close()     // Catch:{ IOException -> 0x007c }
                goto L_0x008d
            L_0x007c:
                r4 = move-exception
                goto L_0x0066
            L_0x007e:
                if (r6 == 0) goto L_0x0088
                r6.close()     // Catch:{ IOException -> 0x0084 }
                goto L_0x0088
            L_0x0084:
                r5 = move-exception
                com.garena.android.appkit.d.a.a(r5)     // Catch:{ IOException -> 0x0089 }
            L_0x0088:
                throw r4     // Catch:{ IOException -> 0x0089 }
            L_0x0089:
                r4 = move-exception
                com.garena.android.appkit.d.a.a(r4)
            L_0x008d:
                int r3 = r3 + 1
                goto L_0x0008
            L_0x0091:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.gallery.j.b.doInBackground(java.lang.String[]):java.util.List");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<String> list) {
            j.this.h.b();
            Intent intent = new Intent();
            ((GalleryData) j.this.j.get(0)).f21837a = true;
            ((GalleryData) j.this.j.get(0)).f21838b = list.get(0);
            intent.putParcelableArrayListExtra("imageList", j.this.getImageList());
            intent.putExtra("submit", true);
            intent.putExtra("index", j.this.f21966a.getSelectedIndex());
            j.this.f21970e.setResult(-1, intent);
            j.this.f21970e.finish();
        }
    }
}
