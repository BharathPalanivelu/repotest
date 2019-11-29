package com.google.android.exoplayer2.e.d;

import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a {
    public static final int A = t.g("sidx");
    public static final int B = t.g("moov");
    public static final int C = t.g("mvhd");
    public static final int D = t.g("trak");
    public static final int E = t.g("mdia");
    public static final int F = t.g("minf");
    public static final int G = t.g("stbl");
    public static final int H = t.g("avcC");
    public static final int I = t.g("hvcC");
    public static final int J = t.g("esds");
    public static final int K = t.g("moof");
    public static final int L = t.g("traf");
    public static final int M = t.g("mvex");
    public static final int N = t.g("mehd");
    public static final int O = t.g("tkhd");
    public static final int P = t.g("edts");
    public static final int Q = t.g("elst");
    public static final int R = t.g("mdhd");
    public static final int S = t.g("hdlr");
    public static final int T = t.g("stsd");
    public static final int U = t.g("pssh");
    public static final int V = t.g("sinf");
    public static final int W = t.g("schm");
    public static final int X = t.g("schi");
    public static final int Y = t.g("tenc");
    public static final int Z = t.g("encv");

    /* renamed from: a  reason: collision with root package name */
    public static final int f9401a = t.g("ftyp");
    public static final int aA = t.g("udta");
    public static final int aB = t.g("meta");
    public static final int aC = t.g("ilst");
    public static final int aD = t.g("mean");
    public static final int aE = t.g("name");
    public static final int aF = t.g("data");
    public static final int aG = t.g("emsg");
    public static final int aH = t.g("st3d");
    public static final int aI = t.g("sv3d");
    public static final int aJ = t.g("proj");
    public static final int aK = t.g("vp08");
    public static final int aL = t.g("vp09");
    public static final int aM = t.g("vpcC");
    public static final int aN = t.g("camm");
    public static final int aO = t.g("alac");
    public static final int aa = t.g("enca");
    public static final int ab = t.g("frma");
    public static final int ac = t.g("saiz");
    public static final int ad = t.g("saio");
    public static final int ae = t.g("sbgp");
    public static final int af = t.g("sgpd");
    public static final int ag = t.g("uuid");
    public static final int ah = t.g("senc");
    public static final int ai = t.g("pasp");
    public static final int aj = t.g("TTML");
    public static final int ak = t.g("vmhd");
    public static final int al = t.g("mp4v");
    public static final int am = t.g("stts");
    public static final int an = t.g("stss");
    public static final int ao = t.g("ctts");
    public static final int ap = t.g("stsc");
    public static final int aq = t.g("stsz");
    public static final int ar = t.g("stz2");
    public static final int as = t.g("stco");
    public static final int at = t.g("co64");
    public static final int au = t.g("tx3g");
    public static final int av = t.g("wvtt");
    public static final int aw = t.g("stpp");
    public static final int ax = t.g("c608");
    public static final int ay = t.g("samr");
    public static final int az = t.g("sawb");

    /* renamed from: b  reason: collision with root package name */
    public static final int f9402b = t.g("avc1");

    /* renamed from: c  reason: collision with root package name */
    public static final int f9403c = t.g("avc3");

    /* renamed from: d  reason: collision with root package name */
    public static final int f9404d = t.g("hvc1");

    /* renamed from: e  reason: collision with root package name */
    public static final int f9405e = t.g("hev1");

    /* renamed from: f  reason: collision with root package name */
    public static final int f9406f = t.g("s263");

    /* renamed from: g  reason: collision with root package name */
    public static final int f9407g = t.g("d263");
    public static final int h = t.g("mdat");
    public static final int i = t.g("mp4a");
    public static final int j = t.g(".mp3");
    public static final int k = t.g("wave");
    public static final int l = t.g("lpcm");
    public static final int m = t.g("sowt");
    public static final int n = t.g("ac-3");
    public static final int o = t.g("dac3");
    public static final int p = t.g("ec-3");
    public static final int q = t.g("dec3");
    public static final int r = t.g("dtsc");
    public static final int s = t.g("dtsh");
    public static final int t = t.g("dtsl");
    public static final int u = t.g("dtse");
    public static final int v = t.g("ddts");
    public static final int w = t.g("tfdt");
    public static final int x = t.g("tfhd");
    public static final int y = t.g("trex");
    public static final int z = t.g("trun");
    public final int aP;

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public a(int i2) {
        this.aP = i2;
    }

    public String toString() {
        return c(this.aP);
    }

    static final class b extends a {
        public final k aQ;

        public b(int i, k kVar) {
            super(i);
            this.aQ = kVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.e.d.a$a  reason: collision with other inner class name */
    static final class C0162a extends a {
        public final long aQ;
        public final List<b> aR = new ArrayList();
        public final List<C0162a> aS = new ArrayList();

        public C0162a(int i, long j) {
            super(i);
            this.aQ = j;
        }

        public void a(b bVar) {
            this.aR.add(bVar);
        }

        public void a(C0162a aVar) {
            this.aS.add(aVar);
        }

        public b d(int i) {
            int size = this.aR.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.aR.get(i2);
                if (bVar.aP == i) {
                    return bVar;
                }
            }
            return null;
        }

        public C0162a e(int i) {
            int size = this.aS.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0162a aVar = this.aS.get(i2);
                if (aVar.aP == i) {
                    return aVar;
                }
            }
            return null;
        }

        public String toString() {
            return c(this.aP) + " leaves: " + Arrays.toString(this.aR.toArray()) + " containers: " + Arrays.toString(this.aS.toArray());
        }
    }

    public static String c(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }
}
