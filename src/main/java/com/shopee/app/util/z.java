package com.shopee.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.garena.android.appkit.tools.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.h.f;
import com.shopee.id.R;
import com.squareup.a.aa;
import com.squareup.a.af;
import com.squareup.a.ah;
import com.squareup.a.r;
import com.squareup.a.w;
import java.io.File;

public class z {
    public static a a(Context context) {
        return new a(context);
    }

    public static d b(Context context) {
        return new d(context);
    }

    public static b c(Context context) {
        return new b(context);
    }

    public static c d(Context context) {
        return new c(context);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f26556a;

        /* renamed from: b  reason: collision with root package name */
        private String f26557b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f26558c = false;

        /* renamed from: d  reason: collision with root package name */
        private int f26559d = b.a.t;

        /* renamed from: e  reason: collision with root package name */
        private boolean f26560e;

        /* renamed from: f  reason: collision with root package name */
        private int f26561f = -1;

        public a(Context context) {
            this.f26556a = context;
        }

        public a a(String str) {
            this.f26557b = str;
            return this;
        }

        public a a(boolean z) {
            this.f26558c = z;
            return this;
        }

        public a a(int i) {
            this.f26561f = i;
            return this;
        }

        public a a() {
            this.f26560e = true;
            this.f26559d = b.a.m;
            return this;
        }

        public void a(ImageView imageView) {
            int i = this.f26561f;
            if (i != -1) {
                imageView.setImageResource(i);
            } else if (this.f26560e) {
                imageView.setImageResource(R.drawable.com_garena_shopee_img_avatar_default_s);
            } else {
                imageView.setBackgroundResource(R.drawable.default_avatar);
            }
            if (!TextUtils.isEmpty(this.f26557b)) {
                aa a2 = w.a(this.f26556a).a(z.f(this.f26557b));
                aa a3 = a2.a(z.f(this.f26557b) + "_" + this.f26558c);
                int i2 = this.f26559d;
                a3.b(i2, i2).d().a((ah) new j(this.f26558c)).a(imageView);
            } else if (this.f26560e) {
            } else {
                if (this.f26558c) {
                    aa a4 = w.a(this.f26556a).a((int) R.drawable.com_garena_shopee_img_cover_scrim);
                    aa a5 = a4.a(z.f(this.f26557b) + "_" + this.f26558c);
                    int i3 = this.f26559d;
                    a5.b(i3, i3).d().a((ah) new j(this.f26558c)).a(imageView);
                    return;
                }
                aa a6 = w.a(this.f26556a).a((String) null);
                aa a7 = a6.a(z.f(this.f26557b) + "_" + this.f26558c);
                int i4 = this.f26559d;
                a7.b(i4, i4).d().a((ah) new j(this.f26558c)).a(imageView);
            }
        }

        public void b(ImageView imageView) {
            int i = this.f26561f;
            if (i != -1) {
                imageView.setImageResource(i);
            } else if (this.f26560e) {
                imageView.setImageResource(R.drawable.com_garena_shopee_img_avatar_default_s);
            } else {
                imageView.setBackgroundResource(R.drawable.default_avatar);
            }
            if (!TextUtils.isEmpty(this.f26557b)) {
                w.a(this.f26556a).a(z.g(this.f26557b)).a((ah) new j(this.f26558c)).a(imageView);
            } else if (!this.f26560e) {
                w.a(this.f26556a).a((String) null).a(imageView);
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Context f26571a;

        /* renamed from: b  reason: collision with root package name */
        private String f26572b;

        /* renamed from: c  reason: collision with root package name */
        private ah f26573c;

        /* renamed from: d  reason: collision with root package name */
        private int f26574d = (b.a.o * 2);

        public d(Context context) {
            this.f26571a = context;
        }

        public d a(ah ahVar) {
            this.f26573c = ahVar;
            return this;
        }

        public d a(String str) {
            this.f26572b = str;
            return this;
        }

        public d a(int i) {
            this.f26574d = i;
            return this;
        }

        public void a(ImageView imageView) {
            String c2 = TextUtils.isEmpty(this.f26572b) ? null : z.i(this.f26572b);
            if (this.f26573c == null) {
                aa a2 = w.a(this.f26571a).a(c2).a((int) R.drawable.com_garena_shopee_ic_product_default);
                int i = this.f26574d;
                a2.b(i, i).d().a(imageView);
                return;
            }
            aa a3 = w.a(this.f26571a).a(c2).a((int) R.drawable.com_garena_shopee_ic_product_default);
            int i2 = this.f26574d;
            a3.b(i2, i2).d().a(this.f26573c).a(imageView);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private Context f26562a;

        /* renamed from: b  reason: collision with root package name */
        private String f26563b;

        /* renamed from: c  reason: collision with root package name */
        private int f26564c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f26565d = (b.a.q * 4);

        /* renamed from: e  reason: collision with root package name */
        private boolean f26566e = false;

        public b(Context context) {
            this.f26562a = context;
        }

        public b a(String str) {
            this.f26563b = str;
            return this;
        }

        public b a(int i) {
            this.f26564c = i;
            return this;
        }

        public b a(boolean z) {
            this.f26566e = z;
            return this;
        }

        public void a(ImageView imageView) {
            if (TextUtils.isEmpty(this.f26563b)) {
                c(imageView);
                return;
            }
            a(w.a(this.f26562a).a(z.j(this.f26563b)), imageView);
        }

        public void b(ImageView imageView) {
            if (TextUtils.isEmpty(this.f26563b)) {
                c(imageView);
                return;
            }
            a(w.a(this.f26562a).a(z.h(this.f26563b)), imageView);
        }

        private void a(aa aaVar, final ImageView imageView) {
            aaVar.a(Bitmap.Config.RGB_565).a(r.NO_CACHE, r.NO_STORE);
            int i = this.f26564c;
            if (i != 0) {
                aaVar.a((ah) new k(i));
            }
            if (this.f26566e) {
                aaVar.b(com.garena.android.appkit.tools.b.b(), 0).a((af) new af() {
                    public void a(Drawable drawable) {
                        imageView.setTag(this);
                    }

                    public void a(Bitmap bitmap, w.d dVar) {
                        imageView.setTag((Object) null);
                        Matrix matrix = new Matrix();
                        matrix.setTranslate(BitmapDescriptorFactory.HUE_RED, (float) (imageView.getHeight() - bitmap.getHeight()));
                        imageView.setScaleType(ImageView.ScaleType.MATRIX);
                        imageView.setImageMatrix(matrix);
                        imageView.setImageBitmap(bitmap);
                    }

                    public void b(Drawable drawable) {
                        imageView.setTag((Object) null);
                    }
                });
                return;
            }
            int b2 = (int) (((float) com.garena.android.appkit.tools.b.b()) * 0.8f);
            aaVar.b(b2, (int) (((float) b2) / 2.28f)).f().d().a(imageView);
        }

        private void c(ImageView imageView) {
            imageView.setBackgroundColor(imageView.getResources().getColor(R.color.primary));
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private Context f26569a;

        /* renamed from: b  reason: collision with root package name */
        private String f26570b;

        public c(Context context) {
            this.f26569a = context;
        }

        public c a(String str) {
            this.f26570b = str;
            return this;
        }

        public void a(ImageView imageView) {
            float f2 = this.f26569a.getResources().getDisplayMetrics().density;
            if (f2 <= 1.0f) {
                this.f26570b += "_mdpi";
            } else if (f2 <= 2.0f) {
                this.f26570b += "_xhdpi";
            } else if (f2 <= 3.0f) {
                this.f26570b += "_xxhdpi";
            }
            imageView.setVisibility(0);
            w.a(this.f26569a).a(this.f26570b).a().e().a(imageView);
        }
    }

    /* access modifiers changed from: private */
    public static String f(String str) {
        return "http://cf.shopee.co.id/file/" + str + "_tn";
    }

    /* access modifiers changed from: private */
    public static File g(String str) {
        f a2 = f.a();
        return new File(a2.b(str + "_tn"));
    }

    /* access modifiers changed from: private */
    public static File h(String str) {
        return new File(f.a().b(str));
    }

    /* access modifiers changed from: private */
    public static String i(String str) {
        String str2 = str.split(",")[0];
        if (str2.startsWith("http://") || str2.startsWith("https://")) {
            return str2;
        }
        if (!str2.endsWith("_tn")) {
            str2 = str2 + "_tn";
        }
        return "http://cf.shopee.co.id/file/" + str2;
    }

    /* access modifiers changed from: private */
    public static String j(String str) {
        String str2 = str.split(",")[0];
        return "http://cf.shopee.co.id/file/" + str2;
    }
}
