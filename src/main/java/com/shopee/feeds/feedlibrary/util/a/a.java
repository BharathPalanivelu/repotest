package com.shopee.feeds.feedlibrary.util.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.shopee.feeds.feedlibrary.util.BitmapUtil;
import java.io.File;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f28248a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f28249b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public float f28250c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bitmap.CompressFormat f28251d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap.Config f28252e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f28253f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f28254g;
    private String h;
    /* access modifiers changed from: private */
    public String i;

    private a(Context context) {
        this.f28249b = 720.0f;
        this.f28250c = 960.0f;
        this.f28251d = Bitmap.CompressFormat.JPEG;
        this.f28252e = Bitmap.Config.ARGB_8888;
        this.f28253f = 80;
        this.f28248a = context;
        this.f28254g = context.getCacheDir().getPath() + File.pathSeparator + "CompressHelper";
    }

    public File a(File file) {
        return BitmapUtil.a(this.f28248a, Uri.fromFile(file), this.f28249b, this.f28250c, this.f28251d, this.f28252e, this.f28253f, this.f28254g, this.h, this.i);
    }

    /* renamed from: com.shopee.feeds.feedlibrary.util.a.a$a  reason: collision with other inner class name */
    public static class C0435a {

        /* renamed from: a  reason: collision with root package name */
        private a f28255a;

        public C0435a(Context context) {
            this.f28255a = new a(context);
        }

        public C0435a a(float f2) {
            float unused = this.f28255a.f28249b = f2;
            return this;
        }

        public C0435a b(float f2) {
            float unused = this.f28255a.f28250c = f2;
            return this;
        }

        public C0435a a(Bitmap.CompressFormat compressFormat) {
            Bitmap.CompressFormat unused = this.f28255a.f28251d = compressFormat;
            return this;
        }

        public C0435a a(int i) {
            int unused = this.f28255a.f28253f = i;
            return this;
        }

        public C0435a a(String str) {
            String unused = this.f28255a.f28254g = str;
            return this;
        }

        public C0435a b(String str) {
            String unused = this.f28255a.i = str;
            return this;
        }

        public a a() {
            return this.f28255a;
        }
    }
}
