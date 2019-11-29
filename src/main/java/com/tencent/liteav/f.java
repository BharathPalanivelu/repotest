package com.tencent.liteav;

import android.graphics.Bitmap;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import com.tencent.liteav.audio.TXEAudioDef;

public class f implements Cloneable {
    public int A = 0;
    public float B = BitmapDescriptorFactory.HUE_RED;
    public float C = BitmapDescriptorFactory.HUE_RED;
    public float D = -1.0f;
    public boolean E = true;
    public boolean F = false;
    public boolean G = false;
    public boolean H = true;
    public int I = 1;
    public boolean J = false;
    public boolean K = false;
    public int L = 0;
    public boolean M = false;
    public boolean N = true;
    public boolean O = false;
    public boolean P = false;
    public int Q = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f31618a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f31619b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f31620c = 400;

    /* renamed from: d  reason: collision with root package name */
    public int f31621d = IjkMediaCodecInfo.RANK_LAST_CHANCE;

    /* renamed from: e  reason: collision with root package name */
    public int f31622e = 300;

    /* renamed from: f  reason: collision with root package name */
    public int f31623f = 5;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31624g = true;
    public int h = 20;
    public int i = 1;
    public int j = 2;
    public int k = 1;
    public int l = 1;
    public boolean m = true;
    public boolean n = true;
    public int o = 3;
    public int p = 3;
    public int q = 48000;
    public int r = 1;
    public boolean s = true;
    public int t = 10;
    public Bitmap u = null;
    public int v = 300;
    public int w = 10;
    public int x = 1;
    public Bitmap y = null;
    public int z = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f31625a;

        /* renamed from: b  reason: collision with root package name */
        public int f31626b;
    }

    public static a a(int i2) {
        a aVar = new a();
        switch (i2) {
            case 0:
                aVar.f31625a = 368;
                aVar.f31626b = 640;
                break;
            case 1:
                aVar.f31625a = 544;
                aVar.f31626b = TXEAudioDef.TXE_OPUS_SAMPLE_NUM;
                break;
            case 2:
                aVar.f31625a = 720;
                aVar.f31626b = 1280;
                break;
            case 3:
                aVar.f31625a = 640;
                aVar.f31626b = 368;
                break;
            case 4:
                aVar.f31625a = TXEAudioDef.TXE_OPUS_SAMPLE_NUM;
                aVar.f31626b = 544;
                break;
            case 5:
                aVar.f31625a = 1280;
                aVar.f31626b = 720;
                break;
            case 6:
                aVar.f31625a = 320;
                aVar.f31626b = 480;
                break;
            case 7:
                aVar.f31625a = JfifUtil.MARKER_SOFn;
                aVar.f31626b = 320;
                break;
            case 8:
                aVar.f31625a = 272;
                aVar.f31626b = 480;
                break;
            case 9:
                aVar.f31625a = 320;
                aVar.f31626b = JfifUtil.MARKER_SOFn;
                break;
            case 10:
                aVar.f31625a = 480;
                aVar.f31626b = 272;
                break;
            case 11:
                aVar.f31625a = 240;
                aVar.f31626b = 320;
                break;
            case 12:
                aVar.f31625a = 368;
                aVar.f31626b = 480;
                break;
            case 13:
                aVar.f31625a = 480;
                aVar.f31626b = 640;
                break;
            case 14:
                aVar.f31625a = 320;
                aVar.f31626b = 240;
                break;
            case 15:
                aVar.f31625a = 480;
                aVar.f31626b = 368;
                break;
            case 16:
                aVar.f31625a = 640;
                aVar.f31626b = 480;
                break;
            case 17:
                aVar.f31625a = 480;
                aVar.f31626b = 480;
                break;
            case 18:
                aVar.f31625a = 272;
                aVar.f31626b = 272;
                break;
            case 19:
                aVar.f31625a = 160;
                aVar.f31626b = 160;
                break;
            case 20:
                aVar.f31625a = 128;
                aVar.f31626b = 128;
                break;
            default:
                aVar.f31625a = 368;
                aVar.f31626b = 640;
                break;
        }
        return aVar;
    }

    public boolean a() {
        a a2 = a(this.k);
        this.f31618a = a2.f31625a;
        this.f31619b = a2.f31626b;
        return this.f31618a > this.f31619b;
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return (f) super.clone();
    }
}
