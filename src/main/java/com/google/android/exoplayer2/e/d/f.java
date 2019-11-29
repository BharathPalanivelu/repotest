package com.google.android.exoplayer2.e.d;

import android.util.Log;
import com.appsflyer.share.Constants;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.b.e;
import com.google.android.exoplayer2.f.b.h;
import com.google.android.exoplayer2.f.b.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;

final class f {
    private static final int A = t.g("sosn");
    private static final int B = t.g("tvsh");
    private static final int C = t.g("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* renamed from: a  reason: collision with root package name */
    private static final int f9469a = t.g("nam");

    /* renamed from: b  reason: collision with root package name */
    private static final int f9470b = t.g("trk");

    /* renamed from: c  reason: collision with root package name */
    private static final int f9471c = t.g("cmt");

    /* renamed from: d  reason: collision with root package name */
    private static final int f9472d = t.g("day");

    /* renamed from: e  reason: collision with root package name */
    private static final int f9473e = t.g("ART");

    /* renamed from: f  reason: collision with root package name */
    private static final int f9474f = t.g("too");

    /* renamed from: g  reason: collision with root package name */
    private static final int f9475g = t.g("alb");
    private static final int h = t.g("com");
    private static final int i = t.g("wrt");
    private static final int j = t.g("lyr");
    private static final int k = t.g("gen");
    private static final int l = t.g("covr");
    private static final int m = t.g("gnre");
    private static final int n = t.g("grp");
    private static final int o = t.g("disk");
    private static final int p = t.g("trkn");
    private static final int q = t.g("tmpo");
    private static final int r = t.g("cpil");
    private static final int s = t.g("aART");
    private static final int t = t.g("sonm");
    private static final int u = t.g("soal");
    private static final int v = t.g("soar");
    private static final int w = t.g("soaa");
    private static final int x = t.g("soco");
    private static final int y = t.g("rtng");
    private static final int z = t.g("pgap");

    public static a.C0166a a(k kVar) {
        int d2 = kVar.d() + kVar.n();
        int n2 = kVar.n();
        int i2 = (n2 >> 24) & 255;
        if (i2 == 169 || i2 == 65533) {
            int i3 = 16777215 & n2;
            if (i3 == f9471c) {
                e a2 = a(n2, kVar);
                kVar.c(d2);
                return a2;
            }
            if (i3 != f9469a) {
                if (i3 != f9470b) {
                    if (i3 != h) {
                        if (i3 != i) {
                            if (i3 == f9472d) {
                                j a3 = a(n2, "TDRC", kVar);
                                kVar.c(d2);
                                return a3;
                            } else if (i3 == f9473e) {
                                j a4 = a(n2, "TPE1", kVar);
                                kVar.c(d2);
                                return a4;
                            } else if (i3 == f9474f) {
                                j a5 = a(n2, "TSSE", kVar);
                                kVar.c(d2);
                                return a5;
                            } else if (i3 == f9475g) {
                                j a6 = a(n2, "TALB", kVar);
                                kVar.c(d2);
                                return a6;
                            } else if (i3 == j) {
                                j a7 = a(n2, "USLT", kVar);
                                kVar.c(d2);
                                return a7;
                            } else if (i3 == k) {
                                j a8 = a(n2, "TCON", kVar);
                                kVar.c(d2);
                                return a8;
                            } else if (i3 == n) {
                                j a9 = a(n2, "TIT1", kVar);
                                kVar.c(d2);
                                return a9;
                            }
                        }
                    }
                    j a10 = a(n2, "TCOM", kVar);
                    kVar.c(d2);
                    return a10;
                }
            }
            j a11 = a(n2, "TIT2", kVar);
            kVar.c(d2);
            return a11;
        }
        try {
            if (n2 == m) {
                return b(kVar);
            }
            if (n2 == o) {
                j b2 = b(n2, "TPOS", kVar);
                kVar.c(d2);
                return b2;
            } else if (n2 == p) {
                j b3 = b(n2, "TRCK", kVar);
                kVar.c(d2);
                return b3;
            } else if (n2 == q) {
                h a12 = a(n2, "TBPM", kVar, true, false);
                kVar.c(d2);
                return a12;
            } else if (n2 == r) {
                h a13 = a(n2, "TCMP", kVar, true, true);
                kVar.c(d2);
                return a13;
            } else if (n2 == l) {
                com.google.android.exoplayer2.f.b.a c2 = c(kVar);
                kVar.c(d2);
                return c2;
            } else if (n2 == s) {
                j a14 = a(n2, "TPE2", kVar);
                kVar.c(d2);
                return a14;
            } else if (n2 == t) {
                j a15 = a(n2, "TSOT", kVar);
                kVar.c(d2);
                return a15;
            } else if (n2 == u) {
                j a16 = a(n2, "TSO2", kVar);
                kVar.c(d2);
                return a16;
            } else if (n2 == v) {
                j a17 = a(n2, "TSOA", kVar);
                kVar.c(d2);
                return a17;
            } else if (n2 == w) {
                j a18 = a(n2, "TSOP", kVar);
                kVar.c(d2);
                return a18;
            } else if (n2 == x) {
                j a19 = a(n2, "TSOC", kVar);
                kVar.c(d2);
                return a19;
            } else if (n2 == y) {
                h a20 = a(n2, "ITUNESADVISORY", kVar, false, false);
                kVar.c(d2);
                return a20;
            } else if (n2 == z) {
                h a21 = a(n2, "ITUNESGAPLESS", kVar, false, true);
                kVar.c(d2);
                return a21;
            } else if (n2 == A) {
                j a22 = a(n2, "TVSHOWSORT", kVar);
                kVar.c(d2);
                return a22;
            } else if (n2 == B) {
                j a23 = a(n2, "TVSHOW", kVar);
                kVar.c(d2);
                return a23;
            } else if (n2 == C) {
                h a24 = a(kVar, d2);
                kVar.c(d2);
                return a24;
            }
        } finally {
            kVar.c(d2);
        }
        Log.d("MetadataUtil", "Skipped unknown metadata entry: " + a.c(n2));
        kVar.c(d2);
        return null;
    }

    private static j a(int i2, String str, k kVar) {
        int n2 = kVar.n();
        if (kVar.n() == a.aF) {
            kVar.d(8);
            return new j(str, (String) null, kVar.f(n2 - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + a.c(i2));
        return null;
    }

    private static e a(int i2, k kVar) {
        int n2 = kVar.n();
        if (kVar.n() == a.aF) {
            kVar.d(8);
            String f2 = kVar.f(n2 - 16);
            return new e("und", f2, f2);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + a.c(i2));
        return null;
    }

    private static h a(int i2, String str, k kVar, boolean z2, boolean z3) {
        int d2 = d(kVar);
        if (z3) {
            d2 = Math.min(1, d2);
        }
        if (d2 < 0) {
            Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + a.c(i2));
            return null;
        } else if (z2) {
            return new j(str, (String) null, Integer.toString(d2));
        } else {
            return new e("und", str, Integer.toString(d2));
        }
    }

    private static j b(int i2, String str, k kVar) {
        int n2 = kVar.n();
        if (kVar.n() == a.aF && n2 >= 22) {
            kVar.d(10);
            int h2 = kVar.h();
            if (h2 > 0) {
                String str2 = "" + h2;
                int h3 = kVar.h();
                if (h3 > 0) {
                    str2 = str2 + Constants.URL_PATH_DELIMITER + h3;
                }
                return new j(str, (String) null, str2);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + a.c(i2));
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.f.b.j b(com.google.android.exoplayer2.n.k r3) {
        /*
            int r3 = d(r3)
            r0 = 0
            if (r3 <= 0) goto L_0x0011
            java.lang.String[] r1 = D
            int r2 = r1.length
            if (r3 > r2) goto L_0x0011
            int r3 = r3 + -1
            r3 = r1[r3]
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x001c
            com.google.android.exoplayer2.f.b.j r1 = new com.google.android.exoplayer2.f.b.j
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L_0x001c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            android.util.Log.w(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.f.b(com.google.android.exoplayer2.n.k):com.google.android.exoplayer2.f.b.j");
    }

    private static com.google.android.exoplayer2.f.b.a c(k kVar) {
        int n2 = kVar.n();
        if (kVar.n() == a.aF) {
            int b2 = a.b(kVar.n());
            String str = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
            if (str == null) {
                Log.w("MetadataUtil", "Unrecognized cover art flags: " + b2);
                return null;
            }
            kVar.d(4);
            byte[] bArr = new byte[(n2 - 16)];
            kVar.a(bArr, 0, bArr.length);
            return new com.google.android.exoplayer2.f.b.a(str, (String) null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    private static h a(k kVar, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (kVar.d() < i2) {
            int d2 = kVar.d();
            int n2 = kVar.n();
            int n3 = kVar.n();
            kVar.d(4);
            if (n3 == a.aD) {
                str = kVar.f(n2 - 12);
            } else if (n3 == a.aE) {
                str2 = kVar.f(n2 - 12);
            } else {
                if (n3 == a.aF) {
                    i3 = d2;
                    i4 = n2;
                }
                kVar.d(n2 - 12);
            }
        }
        if (!"com.apple.iTunes".equals(str) || !"iTunSMPB".equals(str2) || i3 == -1) {
            return null;
        }
        kVar.c(i3);
        kVar.d(16);
        return new e("und", str2, kVar.f(i4 - 16));
    }

    private static int d(k kVar) {
        kVar.d(4);
        if (kVar.n() == a.aF) {
            kVar.d(8);
            return kVar.g();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
