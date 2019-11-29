package com.shopee.feeds.feedlibrary.util;

import android.graphics.Rect;
import android.text.TextUtils;
import com.shopee.feeds.feedlibrary.data.b.a;
import com.shopee.feeds.feedlibrary.data.entity.ImageCompressUploadParams;
import com.shopee.feeds.feedlibrary.data.entity.ImageSizeEntity;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.OriginImageInfo;
import com.shopee.feeds.feedlibrary.data.entity.VideoCompressUploadEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoPostParams;
import com.shopee.feeds.feedlibrary.editor.multitouch.c;
import java.util.ArrayList;
import java.util.HashMap;

public class j {
    private static j r;
    private int A;
    private int B;

    /* renamed from: a  reason: collision with root package name */
    private String f28318a;

    /* renamed from: b  reason: collision with root package name */
    private String f28319b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28320c;

    /* renamed from: d  reason: collision with root package name */
    private MediaCompressParam f28321d;

    /* renamed from: e  reason: collision with root package name */
    private VideoPostParams f28322e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<ImageCompressUploadParams> f28323f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28324g = false;
    private String h;
    private HashMap<String, OriginImageInfo> i;
    private int j;
    private VideoCompressUploadEntity k;
    private int l;
    private boolean m;
    private float n;
    private float o;
    private c p;
    private a q = null;
    private String s = null;
    private String t;
    private boolean u = false;
    private boolean v = false;
    private ImageSizeEntity w;
    private String x;
    private boolean y = false;
    private Rect z;

    private j() {
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (r == null) {
                r = new j();
            }
            jVar = r;
        }
        return jVar;
    }

    public void a(ImageSizeEntity imageSizeEntity) {
        this.w = imageSizeEntity;
    }

    public ImageSizeEntity b() {
        if (this.w == null) {
            this.w = new ImageSizeEntity();
        }
        return this.w;
    }

    public void a(String str) {
        this.x = str;
    }

    public String c() {
        return this.x;
    }

    public void a(boolean z2) {
        this.y = z2;
    }

    public boolean d() {
        return this.y;
    }

    public void b(String str) {
        this.s = str;
    }

    public String e() {
        String str = this.s;
        return str == null ? "" : str;
    }

    public float f() {
        return this.n;
    }

    public void a(float f2) {
        this.n = f2;
    }

    public float g() {
        return this.o;
    }

    public void b(float f2) {
        this.o = f2;
    }

    public int h() {
        return this.l;
    }

    public void a(int i2) {
        this.l = i2;
    }

    public void b(boolean z2) {
        this.v = z2;
    }

    public boolean i() {
        return this.v;
    }

    public VideoCompressUploadEntity j() {
        if (this.k == null) {
            this.k = new VideoCompressUploadEntity();
        }
        return this.k;
    }

    public HashMap<String, OriginImageInfo> k() {
        return this.i;
    }

    public void a(HashMap<String, OriginImageInfo> hashMap) {
        this.i = hashMap;
    }

    public void b(int i2) {
        this.A = i2;
    }

    public int l() {
        return this.A;
    }

    public void c(int i2) {
        this.B = i2;
    }

    public int m() {
        return this.B;
    }

    public void a(Rect rect) {
        this.z = rect;
    }

    public Rect n() {
        return this.z;
    }

    public void c(String str) {
        this.t = str;
    }

    public String o() {
        return this.t;
    }

    public boolean p() {
        return this.m;
    }

    public void c(boolean z2) {
        this.m = z2;
    }

    public int q() {
        return this.j;
    }

    public void d(int i2) {
        this.j = i2;
    }

    public String r() {
        String str = this.h;
        return str == null ? "" : str;
    }

    public void d(String str) {
        this.h = str;
    }

    public MediaCompressParam s() {
        return this.f28321d;
    }

    public void a(MediaCompressParam mediaCompressParam) {
        this.f28321d = mediaCompressParam;
    }

    public VideoPostParams t() {
        return this.f28322e;
    }

    public void a(VideoPostParams videoPostParams) {
        this.f28322e = videoPostParams;
    }

    public void d(boolean z2) {
        this.f28324g = z2;
    }

    public synchronized void e(boolean z2) {
        if (this.q == null) {
            this.q = new a();
        }
        this.q.hasPulled = true;
        this.q.isWhiteList = z2;
    }

    public synchronized a u() {
        if (this.q == null) {
            this.q = new a();
        }
        return this.q;
    }

    public void f(boolean z2) {
        this.u = z2;
    }

    public boolean v() {
        return this.u;
    }

    public boolean w() {
        return this.f28324g;
    }

    public ArrayList<ImageCompressUploadParams> x() {
        ArrayList<ImageCompressUploadParams> arrayList = this.f28323f;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void a(ImageCompressUploadParams imageCompressUploadParams) {
        if (this.f28323f == null) {
            this.f28323f = new ArrayList<>();
        }
        this.f28323f.add(imageCompressUploadParams);
    }

    public String y() {
        String str = this.f28318a;
        return str == null ? "" : str;
    }

    public void e(String str) {
        this.f28318a = str;
    }

    public String z() {
        String str = this.f28319b;
        return str == null ? "" : str;
    }

    public void f(String str) {
        this.f28319b = str;
    }

    public boolean A() {
        return this.f28320c;
    }

    public void g(boolean z2) {
        this.f28320c = z2;
    }

    public synchronized boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.p == null) {
            this.p = new c(str);
        }
        return this.p.f27969b;
    }

    public synchronized void a(String str, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.p == null) {
                this.p = new c(str);
            }
            if (z2) {
                this.p.f27969b = true;
                this.p.f27968a = str;
            } else if (str.equals(this.p.f27968a)) {
                this.p.f27969b = false;
            }
            h.b("%s", "dbaction setElementTouching " + str + "," + this.p.f27969b + "," + z2 + "," + this.p.f27968a);
        }
    }

    public void B() {
        this.p = null;
    }

    public void C() {
        r = null;
    }
}
