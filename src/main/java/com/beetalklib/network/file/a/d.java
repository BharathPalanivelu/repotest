package com.beetalklib.network.file.a;

import com.beetalklib.network.file.protocol.ImageDownloadRequest;

public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    protected String f5541a;

    /* renamed from: b  reason: collision with root package name */
    protected String f5542b;

    /* renamed from: c  reason: collision with root package name */
    protected String f5543c;

    /* renamed from: d  reason: collision with root package name */
    private int f5544d;

    /* renamed from: e  reason: collision with root package name */
    private c f5545e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5546f = false;

    public int e() {
        return 2;
    }

    public d(String str, int i, String str2, String str3, c cVar) {
        this.f5541a = str2;
        this.f5542b = str3;
        this.f5545e = cVar;
        this.f5543c = str;
        this.f5544d = i;
    }

    /* access modifiers changed from: protected */
    public synchronized boolean a() {
        return this.f5546f;
    }

    /* access modifiers changed from: protected */
    public ImageDownloadRequest b() {
        ImageDownloadRequest.Builder builder = new ImageDownloadRequest.Builder();
        String str = this.f5541a;
        builder.Name = str;
        builder.RequestId = str;
        builder.Token = this.f5542b;
        builder.Thumb(false);
        return builder.build();
    }

    public String c() {
        return this.f5543c;
    }

    public int d() {
        return this.f5544d;
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        this.f5545e.a(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!dVar.f5543c.equals(this.f5543c) || dVar.f5544d != this.f5544d || !this.f5545e.equals(dVar.f5545e) || !this.f5541a.equals(dVar.f5541a)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public synchronized void a(byte[] bArr) {
        this.f5545e.a(bArr);
        this.f5546f = true;
    }
}
