package com.shopee.app.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.afollestad.materialdialogs.f;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.b.i;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.app.ui.gallery.a.d;
import com.shopee.app.ui.gallery.instagram.InstagramGalleryActivity_;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.io.File;
import java.util.ArrayList;

public class s extends MaterialTabView {

    /* renamed from: a  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f22000a;

    /* renamed from: b  reason: collision with root package name */
    Activity f22001b;

    /* renamed from: d  reason: collision with root package name */
    i f22002d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f22003e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f22004f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final int f22005g;
    /* access modifiers changed from: private */
    public final String h;
    /* access modifiers changed from: private */
    public int[] i = {R.string.sp_label_photos, R.string.sp_label_videos};
    /* access modifiers changed from: private */
    public v j;
    /* access modifiers changed from: private */
    public com.shopee.app.ui.gallery.a.c k;
    private a.b l;
    /* access modifiers changed from: private */
    public b m;
    private a.b n = new a.b(ShareConstants.VIDEO_URL, R.drawable.ic_images_video) {
        public void a() {
            if (s.this.f22004f == 0) {
                com.shopee.app.ui.dialog.a.a(s.this.getContext(), 0, (int) R.string.sp_video_gallery_replace_text, (int) R.string.sp_label_cancel, (int) R.string.sp_label_replace, (f.b) new f.b() {
                    public void onPositive(f fVar) {
                        fVar.dismiss();
                        s.this.l();
                    }
                }, false);
            } else {
                s.this.l();
            }
        }
    };
    private a.b o = new a.b("CAMERA", R.drawable.com_garena_shopee_ic_instagram) {
        public void a() {
            InstagramGalleryActivity_.a(s.this.getContext()).b(s.this.f22003e).a(s.this.h).a(1837);
        }
    };
    private a.b p = new a.b("CAMERA", R.drawable.com_garena_shopee_ic_camera) {
        public void a() {
            int i = 2;
            if (s.this.f22005g != 2) {
                i = 0;
            }
            PhotoProxyActivity_.a(s.this.getContext()).b(i).g(s.this.f22004f).a(true).a(4);
        }
    };
    private a.b q = new a.b("SUBMIT_PHOTO", R.drawable.com_garena_shopee_ic_done) {
        public void a() {
            s.this.k();
        }
    };

    public s(Context context, int i2, int i3, int i4, String str) {
        super(context);
        this.f22005g = i2;
        this.f22003e = i3;
        this.f22004f = i4;
        this.h = str;
        ((m) ((x) context).b()).a(this);
        this.f22002d = com.garena.a.a.a.b.a(this);
        h();
    }

    private void h() {
        a aVar = new a();
        int b2 = aVar.b();
        if (b2 <= 1) {
            setShadowOffset(0);
        } else {
            setTabIndicator(new ap(b2));
        }
        setAdapter(aVar);
        a();
        g();
    }

    public void b() {
        super.b();
        g();
        this.f22002d.c();
    }

    public void c() {
        super.c();
        this.f22002d.d();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        g();
    }

    public void a(ArrayList<GalleryData> arrayList, boolean z) {
        this.m = new b(arrayList, z);
        f();
    }

    public void f() {
        v vVar = this.j;
        if (vVar != null) {
            vVar.c(this.m.f22012a);
            if (this.m.f22013b) {
                this.j.e();
            }
            this.m = null;
        }
    }

    private class a extends com.garena.android.uikit.a.a {
        public View a(Context context) {
            return null;
        }

        private a() {
        }

        public int b() {
            return s.this.f22005g == 2 ? 2 : 1;
        }

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            ao aoVar = new ao(context);
            aoVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.secondary_dark));
            aoVar.setDeselectedColor(com.garena.android.appkit.tools.b.a(R.color.white54));
            aoVar.setTitle(s.this.i[i]);
            if (b() <= 1) {
                aoVar.setVisibility(8);
            }
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            int a2 = s.this.f22005g;
            if (a2 != 0) {
                if (a2 != 2) {
                    if (a2 != 3) {
                        if (i != 0) {
                            return null;
                        }
                        s sVar = s.this;
                        com.shopee.app.ui.gallery.a.c unused = sVar.k = d.a(context, sVar.f22004f);
                        s sVar2 = s.this;
                        return new c(context, sVar2.k);
                    }
                } else if (i != 0) {
                    s sVar3 = s.this;
                    com.shopee.app.ui.gallery.a.c unused2 = sVar3.k = d.a(context, sVar3.f22004f);
                    s sVar4 = s.this;
                    return new c(context, sVar4.k);
                } else {
                    s sVar5 = s.this;
                    v unused3 = sVar5.j = w.a(context, sVar5.f22003e, s.this.h);
                    s sVar6 = s.this;
                    return new c(context, sVar6.j);
                }
            }
            if (i != 0) {
                return null;
            }
            s sVar7 = s.this;
            v unused4 = sVar7.j = w.a(context, sVar7.f22003e, s.this.h);
            s sVar8 = s.this;
            return new c(context, sVar8.j);
        }
    }

    public void g() {
        v vVar = this.j;
        int i2 = 0;
        if (vVar != null) {
            i2 = 0 + vVar.getCheckedCount();
        }
        com.shopee.app.ui.gallery.a.c cVar = this.k;
        if (cVar != null) {
            i2 += cVar.getCheckedCount();
        }
        if (i2 >= 1) {
            i();
        } else {
            j();
        }
    }

    private void i() {
        if (this.l != this.q) {
            this.f22000a.c();
            this.f22000a.a(this.q);
            this.l = this.q;
        }
    }

    private void j() {
        if (this.l != this.p) {
            this.f22000a.c();
            int i2 = this.f22005g;
            if (i2 == 0) {
                this.f22000a.a(this.o);
                this.f22000a.a(this.p);
            } else if (i2 == 1) {
                this.f22000a.a(this.n);
            } else if (i2 == 2) {
                this.f22000a.a(this.o);
                this.f22000a.a(this.n);
                this.f22000a.a(this.p);
            }
            this.l = this.p;
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        v vVar = this.j;
        if (vVar != null) {
            for (String file : vVar.getSelected()) {
                arrayList.add(Uri.fromFile(new File(file)).toString());
            }
        }
        intent.putStringArrayListExtra("imageList", arrayList);
        ArrayList arrayList2 = new ArrayList();
        com.shopee.app.ui.gallery.a.c cVar = this.k;
        if (cVar != null) {
            for (String file2 : cVar.getSelected()) {
                arrayList2.add(Uri.fromFile(new File(file2)).toString());
            }
        }
        intent.putStringArrayListExtra("videoList", arrayList2);
        this.f22001b.setResult(-1, intent);
        this.f22001b.finish();
    }

    /* access modifiers changed from: private */
    public void l() {
        PhotoProxyActivity_.a(getContext()).a(true).b(this.f22005g != 2 ? 1 : 3).a(4);
    }

    private class c extends com.garena.android.uikit.a.a.a {
        public c(Context context, View view) {
            super(context);
            addView(view, new LinearLayout.LayoutParams(-1, -1));
        }

        public void a() {
            if (s.this.m != null) {
                s.this.f();
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<GalleryData> f22012a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f22013b;

        public b(ArrayList<GalleryData> arrayList, boolean z) {
            this.f22012a = arrayList;
            this.f22013b = z;
        }
    }
}
