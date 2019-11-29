package com.shopee.app.ui.image;

import a.h;
import a.k;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.app.data.store.be;
import com.shopee.app.h.f;
import com.shopee.app.h.l;
import com.shopee.app.react.protocol.PopData;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.image.bound.BoundPreview;
import com.shopee.app.ui.image.bound.i;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.ImageSearchData;
import com.shopee.id.R;
import com.squareup.a.af;
import com.squareup.a.w;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

public class p extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f23052a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23053b;

    /* renamed from: c  reason: collision with root package name */
    BoundPreview f23054c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f23055d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f23056e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f23057f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23058g;
    n h;
    bc i;
    Activity j;
    be k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public final boolean m;
    /* access modifiers changed from: private */
    public final boolean n;
    /* access modifiers changed from: private */
    public ProgressWheel o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public boolean q;
    /* access modifiers changed from: private */
    public String r;
    /* access modifiers changed from: private */
    public double s;
    /* access modifiers changed from: private */
    public double t;
    /* access modifiers changed from: private */
    public Rect u;
    /* access modifiers changed from: private */
    public Bitmap v;
    /* access modifiers changed from: private */
    public boolean w = false;
    /* access modifiers changed from: private */
    public af x = new af() {
        public void a(Drawable drawable) {
        }

        public void b(Drawable drawable) {
        }

        public void a(Bitmap bitmap, w.d dVar) {
            Bitmap unused = p.this.v = bitmap;
            p.this.f23052a.setImageBitmap(p.this.v);
            p.this.i();
        }
    };

    /* access modifiers changed from: private */
    public void i() {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                int width = p.this.v.getWidth();
                int height = p.this.v.getHeight();
                if (((double) b.b()) > ((double) Math.min(width, height))) {
                    p pVar = p.this;
                    double b2 = (double) b.b();
                    double min = (double) Math.min(width, height);
                    Double.isNaN(b2);
                    Double.isNaN(min);
                    double unused = pVar.t = b2 / min;
                    return null;
                }
                double unused2 = p.this.t = 1.0d;
                f a2 = f.a();
                File file = new File(a2.b(a.a() + "_scaled.jpg.tmp"));
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                p.this.v.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(file));
                String unused3 = p.this.l = Uri.fromFile(file).toString();
                return null;
            }
        }).a(new h<Object, Object>() {
            public Object then(k<Object> kVar) {
                if (kVar.e()) {
                    com.garena.android.appkit.d.a.a(kVar.g());
                    p.this.d();
                    return null;
                } else if (p.this.m) {
                    p.this.h.a(p.this.l);
                    p.this.h();
                    p.this.f23055d.setVisibility(0);
                    p.this.f23054c.setVisibility(8);
                    return null;
                } else if (!p.this.n || p.this.u == null) {
                    return null;
                } else {
                    p.this.j();
                    p.this.f23054c.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                            com.garena.android.appkit.d.a.b("image-search onLayoutChange top %d", Integer.valueOf(i2));
                            p.this.k();
                        }
                    });
                    return null;
                }
            }
        }, k.f377b);
    }

    public void a(final Bitmap bitmap) {
        k.a(new Callable<Object>() {
            public Object call() {
                l a2 = l.a();
                Bitmap bitmap = bitmap;
                Uri b2 = a2.b(bitmap, p.this.r + ".jpg");
                com.shopee.app.camera.a.b(b2.getPath());
                com.garena.android.appkit.d.a.b("image_search image search hint photo saved " + b2, new Object[0]);
                return null;
            }
        }).a(new h<Object, Object>() {
            public Object then(k<Object> kVar) {
                if (!kVar.e()) {
                    return null;
                }
                com.garena.android.appkit.d.a.a(kVar.g());
                return null;
            }
        });
    }

    public p(Context context, String str, boolean z, boolean z2, Rect rect, String str2, double d2, boolean z3, boolean z4) {
        super(context);
        ((h) ((x) context).b()).a(this);
        this.l = str;
        this.m = z;
        this.n = z2;
        this.u = rect;
        this.r = str2;
        this.s = d2;
        this.p = z3;
        this.q = z4;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (this.m) {
            return this.k.D();
        }
        return this.k.E();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.w) {
            return;
        }
        if (this.m) {
            this.k.F();
        } else {
            this.k.G();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.i.a(this.h);
        this.h.a(this);
        this.f23054c.setOnBoundBoxChangedCallback(new i() {
            public void a() {
                p.this.f23058g.setVisibility(8);
                k.a(new Callable<Object>() {
                    public Object call() throws Exception {
                        p.this.b();
                        return null;
                    }
                });
            }
        });
        k.a(new Callable<l.b>() {
            /* renamed from: a */
            public l.b call() {
                l.b b2 = l.b(Uri.parse(p.this.l));
                p pVar = p.this;
                boolean unused = pVar.w = pVar.a();
                return b2;
            }
        }).a(new h<l.b, Object>() {
            public Object then(k<l.b> kVar) throws Exception {
                if (kVar.e()) {
                    com.garena.android.appkit.d.a.a(kVar.g());
                    p.this.d();
                    return null;
                } else if (p.this.p) {
                    w.a(p.this.getContext()).a(Uri.parse(p.this.l)).b(b.b(), b.d()).f().d().a(p.this.x);
                    return null;
                } else {
                    l.b f2 = kVar.f();
                    double doubleValue = Double.valueOf((double) f2.f17679b).doubleValue();
                    double d2 = (double) f2.f17678a;
                    Double.isNaN(d2);
                    double d3 = doubleValue / d2;
                    int b2 = b.b();
                    double d4 = (double) b2;
                    Double.isNaN(d4);
                    w.a(p.this.getContext()).a(Uri.parse(p.this.l)).b(b2, (int) (d4 * d3)).f().a(p.this.x);
                    return null;
                }
            }
        }, k.f377b);
    }

    /* access modifiers changed from: private */
    public void j() {
        double height = (double) this.v.getHeight();
        double width = (double) this.v.getWidth();
        Double.isNaN(height);
        Double.isNaN(width);
        double d2 = height / width;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23054c.getLayoutParams();
        double b2 = (double) b.b();
        Double.isNaN(b2);
        layoutParams.height = (int) (b2 * d2);
        layoutParams.width = -1;
        layoutParams.gravity = 17;
        this.f23054c.setLayoutParams(layoutParams);
    }

    public void a(int i2) {
        ProgressWheel progressWheel = this.o;
        if (progressWheel != null) {
            progressWheel.setProgress(((float) i2) / 100.0f);
            TextView textView = this.f23053b;
            textView.setText(i2 + "%");
            if (this.o.getVisibility() != 0) {
                this.o.setVisibility(0);
            }
        }
        this.f23057f.setVisibility(8);
        this.f23055d.setVisibility(0);
    }

    public void a(String str, double d2, Rect rect) {
        this.r = str;
        this.s = d2;
        this.u = rect;
        j();
        if (this.p) {
            a(this.v);
        }
        postDelayed(new Runnable() {
            public void run() {
                if (p.this.o != null) {
                    p.this.o.setVisibility(8);
                    p.this.f23053b.setVisibility(8);
                    p.this.f23055d.setVisibility(8);
                }
                if (p.this.u != null) {
                    p.this.k();
                } else {
                    p.this.d();
                }
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    public void k() {
        double width = (double) this.u.width();
        double d2 = this.s;
        Double.isNaN(width);
        double d3 = width * d2 * this.t;
        double height = (double) this.u.height();
        double d4 = this.s;
        Double.isNaN(height);
        double d5 = height * d4 * this.t;
        double centerX = (double) this.u.centerX();
        double d6 = this.s;
        Double.isNaN(centerX);
        double d7 = centerX * d6 * this.t;
        double centerY = (double) this.u.centerY();
        double d8 = this.s;
        Double.isNaN(centerY);
        double d9 = centerY * d8 * this.t;
        if (d3 > ((double) (this.f23054c.getWidth() - (b.a.f7690a * 2)))) {
            d3 = (double) (this.f23054c.getWidth() - (b.a.f7690a * 2));
            d7 = (double) (this.f23054c.getWidth() / 2);
        }
        double d10 = d3;
        double d11 = d7;
        if (d5 > ((double) (this.f23054c.getHeight() - (b.a.f7690a * 2)))) {
            d5 = (double) (this.f23054c.getHeight() - (b.a.f7690a * 2));
            d9 = (double) (this.f23054c.getHeight() / 2);
        }
        this.f23054c.a(d10, d5, d11, d9);
        this.f23054c.setVisibility(0);
        this.f23054c.postDelayed(new Runnable() {
            public void run() {
                p.this.f23057f.setVisibility(0);
                if (p.this.w) {
                    p.this.f23058g.setVisibility(0);
                }
            }
        }, 200);
    }

    public void d() {
        if (!this.j.isFinishing()) {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_image_search_error_message, (int) R.string.sp_label_cancel, (int) R.string.sp_label_retry, (a.C0318a) new a.C0318a() {
                public void onPositive() {
                    p.this.h.a(p.this.l);
                }

                public void onNegative() {
                    p.this.g();
                }
            });
            this.f23055d.setVisibility(8);
            this.o.setVisibility(8);
            this.f23057f.setVisibility(8);
            this.o.setProgress(BitmapDescriptorFactory.HUE_RED);
            this.f23053b.setText("0%");
        }
    }

    public void e() {
        k.a(new Callable<ImageSearchData>() {
            /* renamed from: a */
            public ImageSearchData call() throws Exception {
                Rect boundBoxRect = p.this.f23054c.getBoundBoxRect();
                double d2 = (double) boundBoxRect.left;
                double n = p.this.t;
                Double.isNaN(d2);
                double d3 = d2 / n;
                double d4 = (double) boundBoxRect.top;
                double n2 = p.this.t;
                Double.isNaN(d4);
                double d5 = d4 / n2;
                double width = (double) boundBoxRect.width();
                double n3 = p.this.t;
                Double.isNaN(width);
                double d6 = width / n3;
                double height = (double) boundBoxRect.height();
                double n4 = p.this.t;
                Double.isNaN(height);
                double d7 = height / n4;
                Bitmap createBitmap = Bitmap.createBitmap(p.this.v, (int) d3, (int) d5, (int) d6, (int) d7);
                f a2 = f.a();
                File file = new File(a2.b(com.garena.android.appkit.tools.a.a.a() + "_cropped.jpg.tmp"));
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(file));
                ImageSearchData imageSearchData = new ImageSearchData();
                imageSearchData.imageId = p.this.r;
                imageSearchData.bigImageUri = p.this.l;
                imageSearchData.isFromHint = p.this.q;
                if (!p.this.f23054c.a()) {
                    imageSearchData.boundBox = new int[]{p.this.u.left, p.this.u.top, p.this.u.width(), p.this.u.height()};
                } else {
                    imageSearchData.boundBox = new int[]{(int) (d3 / p.this.s), (int) (d5 / p.this.s), (int) (d6 / p.this.s), (int) (d7 / p.this.s)};
                }
                imageSearchData.scale = p.this.s;
                imageSearchData.croppedImageUri = Uri.fromFile(file).toString();
                return imageSearchData;
            }
        }).a(new h() {
            /* renamed from: a */
            public ImageSearchData then(k kVar) {
                if (kVar.e()) {
                    com.garena.android.appkit.d.a.a("image_search", kVar.g());
                    com.garena.android.appkit.d.a.a(kVar.g());
                    p.this.d();
                    return null;
                }
                PopData popData = new PopData();
                popData.setCount(0);
                popData.setData(WebRegister.GSON.b(kVar.f()));
                Intent intent = new Intent();
                intent.putExtra("popData", WebRegister.GSON.b((Object) popData));
                p.this.j.setResult(-1, intent);
                p.this.j.finish();
                return null;
            }
        }, k.f377b);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!TextUtils.isEmpty(this.r)) {
            e();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        Intent intent = new Intent();
        intent.putExtra("isFromHint", this.q);
        this.j.setResult(0, intent);
        this.j.finish();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.o == null) {
            this.o = new ProgressWheel(getContext());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.o.setLayoutParams(layoutParams);
        this.o.setCircleRadius(b.a.m + b.a.f7693d);
        this.o.setBarColor(com.garena.android.appkit.tools.b.a(R.color.white));
        this.o.setRimColor(com.garena.android.appkit.tools.b.a(R.color.rim_bg));
        this.o.setBarWidth(b.a.f7691b);
        this.o.setRimWidth(b.a.f7691b);
        this.o.setLinearProgress(true);
        addView(this.o);
    }
}
