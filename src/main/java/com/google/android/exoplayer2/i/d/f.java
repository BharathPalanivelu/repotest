package com.google.android.exoplayer2.i.d;

import android.util.Log;
import com.appsflyer.share.Constants;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;

final class f {
    private static final int A = v.g("sosn");
    private static final int B = v.g("tvsh");
    private static final int C = v.g("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* renamed from: a  reason: collision with root package name */
    private static final int f10099a = v.g("nam");

    /* renamed from: b  reason: collision with root package name */
    private static final int f10100b = v.g("trk");

    /* renamed from: c  reason: collision with root package name */
    private static final int f10101c = v.g("cmt");

    /* renamed from: d  reason: collision with root package name */
    private static final int f10102d = v.g("day");

    /* renamed from: e  reason: collision with root package name */
    private static final int f10103e = v.g("ART");

    /* renamed from: f  reason: collision with root package name */
    private static final int f10104f = v.g("too");

    /* renamed from: g  reason: collision with root package name */
    private static final int f10105g = v.g("alb");
    private static final int h = v.g("com");
    private static final int i = v.g("wrt");
    private static final int j = v.g("lyr");
    private static final int k = v.g("gen");
    private static final int l = v.g("covr");
    private static final int m = v.g("gnre");
    private static final int n = v.g("grp");
    private static final int o = v.g("disk");
    private static final int p = v.g("trkn");
    private static final int q = v.g("tmpo");
    private static final int r = v.g("cpil");
    private static final int s = v.g("aART");
    private static final int t = v.g("sonm");
    private static final int u = v.g("soal");
    private static final int v = v.g("soar");
    private static final int w = v.g("soaa");
    private static final int x = v.g("soco");
    private static final int y = v.g("rtng");
    private static final int z = v.g("pgap");

    public static Metadata.Entry a(l lVar) {
        int d2 = lVar.d() + lVar.n();
        int n2 = lVar.n();
        int i2 = (n2 >> 24) & 255;
        if (i2 == 169 || i2 == 65533) {
            int i3 = 16777215 & n2;
            if (i3 == f10101c) {
                CommentFrame a2 = a(n2, lVar);
                lVar.c(d2);
                return a2;
            }
            if (i3 != f10099a) {
                if (i3 != f10100b) {
                    if (i3 != h) {
                        if (i3 != i) {
                            if (i3 == f10102d) {
                                TextInformationFrame a3 = a(n2, "TDRC", lVar);
                                lVar.c(d2);
                                return a3;
                            } else if (i3 == f10103e) {
                                TextInformationFrame a4 = a(n2, "TPE1", lVar);
                                lVar.c(d2);
                                return a4;
                            } else if (i3 == f10104f) {
                                TextInformationFrame a5 = a(n2, "TSSE", lVar);
                                lVar.c(d2);
                                return a5;
                            } else if (i3 == f10105g) {
                                TextInformationFrame a6 = a(n2, "TALB", lVar);
                                lVar.c(d2);
                                return a6;
                            } else if (i3 == j) {
                                TextInformationFrame a7 = a(n2, "USLT", lVar);
                                lVar.c(d2);
                                return a7;
                            } else if (i3 == k) {
                                TextInformationFrame a8 = a(n2, "TCON", lVar);
                                lVar.c(d2);
                                return a8;
                            } else if (i3 == n) {
                                TextInformationFrame a9 = a(n2, "TIT1", lVar);
                                lVar.c(d2);
                                return a9;
                            }
                        }
                    }
                    TextInformationFrame a10 = a(n2, "TCOM", lVar);
                    lVar.c(d2);
                    return a10;
                }
            }
            TextInformationFrame a11 = a(n2, "TIT2", lVar);
            lVar.c(d2);
            return a11;
        }
        try {
            if (n2 == m) {
                return b(lVar);
            }
            if (n2 == o) {
                TextInformationFrame b2 = b(n2, "TPOS", lVar);
                lVar.c(d2);
                return b2;
            } else if (n2 == p) {
                TextInformationFrame b3 = b(n2, "TRCK", lVar);
                lVar.c(d2);
                return b3;
            } else if (n2 == q) {
                Id3Frame a12 = a(n2, "TBPM", lVar, true, false);
                lVar.c(d2);
                return a12;
            } else if (n2 == r) {
                Id3Frame a13 = a(n2, "TCMP", lVar, true, true);
                lVar.c(d2);
                return a13;
            } else if (n2 == l) {
                ApicFrame c2 = c(lVar);
                lVar.c(d2);
                return c2;
            } else if (n2 == s) {
                TextInformationFrame a14 = a(n2, "TPE2", lVar);
                lVar.c(d2);
                return a14;
            } else if (n2 == t) {
                TextInformationFrame a15 = a(n2, "TSOT", lVar);
                lVar.c(d2);
                return a15;
            } else if (n2 == u) {
                TextInformationFrame a16 = a(n2, "TSO2", lVar);
                lVar.c(d2);
                return a16;
            } else if (n2 == v) {
                TextInformationFrame a17 = a(n2, "TSOA", lVar);
                lVar.c(d2);
                return a17;
            } else if (n2 == w) {
                TextInformationFrame a18 = a(n2, "TSOP", lVar);
                lVar.c(d2);
                return a18;
            } else if (n2 == x) {
                TextInformationFrame a19 = a(n2, "TSOC", lVar);
                lVar.c(d2);
                return a19;
            } else if (n2 == y) {
                Id3Frame a20 = a(n2, "ITUNESADVISORY", lVar, false, false);
                lVar.c(d2);
                return a20;
            } else if (n2 == z) {
                Id3Frame a21 = a(n2, "ITUNESGAPLESS", lVar, false, true);
                lVar.c(d2);
                return a21;
            } else if (n2 == A) {
                TextInformationFrame a22 = a(n2, "TVSHOWSORT", lVar);
                lVar.c(d2);
                return a22;
            } else if (n2 == B) {
                TextInformationFrame a23 = a(n2, "TVSHOW", lVar);
                lVar.c(d2);
                return a23;
            } else if (n2 == C) {
                Id3Frame a24 = a(lVar, d2);
                lVar.c(d2);
                return a24;
            }
        } finally {
            lVar.c(d2);
        }
        Log.d("MetadataUtil", "Skipped unknown metadata entry: " + a.c(n2));
        lVar.c(d2);
        return null;
    }

    private static TextInformationFrame a(int i2, String str, l lVar) {
        int n2 = lVar.n();
        if (lVar.n() == a.aF) {
            lVar.d(8);
            return new TextInformationFrame(str, (String) null, lVar.f(n2 - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + a.c(i2));
        return null;
    }

    private static CommentFrame a(int i2, l lVar) {
        int n2 = lVar.n();
        if (lVar.n() == a.aF) {
            lVar.d(8);
            String f2 = lVar.f(n2 - 16);
            return new CommentFrame("und", f2, f2);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + a.c(i2));
        return null;
    }

    private static Id3Frame a(int i2, String str, l lVar, boolean z2, boolean z3) {
        int d2 = d(lVar);
        if (z3) {
            d2 = Math.min(1, d2);
        }
        if (d2 < 0) {
            Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + a.c(i2));
            return null;
        } else if (z2) {
            return new TextInformationFrame(str, (String) null, Integer.toString(d2));
        } else {
            return new CommentFrame("und", str, Integer.toString(d2));
        }
    }

    private static TextInformationFrame b(int i2, String str, l lVar) {
        int n2 = lVar.n();
        if (lVar.n() == a.aF && n2 >= 22) {
            lVar.d(10);
            int h2 = lVar.h();
            if (h2 > 0) {
                String str2 = "" + h2;
                int h3 = lVar.h();
                if (h3 > 0) {
                    str2 = str2 + Constants.URL_PATH_DELIMITER + h3;
                }
                return new TextInformationFrame(str, (String) null, str2);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + a.c(i2));
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame b(com.google.android.exoplayer2.s.l r3) {
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
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L_0x001c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            android.util.Log.w(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.d.f.b(com.google.android.exoplayer2.s.l):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static ApicFrame c(l lVar) {
        int n2 = lVar.n();
        if (lVar.n() == a.aF) {
            int b2 = a.b(lVar.n());
            String str = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
            if (str == null) {
                Log.w("MetadataUtil", "Unrecognized cover art flags: " + b2);
                return null;
            }
            lVar.d(4);
            byte[] bArr = new byte[(n2 - 16)];
            lVar.a(bArr, 0, bArr.length);
            return new ApicFrame(str, (String) null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    private static Id3Frame a(l lVar, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (lVar.d() < i2) {
            int d2 = lVar.d();
            int n2 = lVar.n();
            int n3 = lVar.n();
            lVar.d(4);
            if (n3 == a.aD) {
                str = lVar.f(n2 - 12);
            } else if (n3 == a.aE) {
                str2 = lVar.f(n2 - 12);
            } else {
                if (n3 == a.aF) {
                    i3 = d2;
                    i4 = n2;
                }
                lVar.d(n2 - 12);
            }
        }
        if (!"com.apple.iTunes".equals(str) || !"iTunSMPB".equals(str2) || i3 == -1) {
            return null;
        }
        lVar.c(i3);
        lVar.d(16);
        return new CommentFrame("und", str2, lVar.f(i4 - 16));
    }

    private static int d(l lVar) {
        lVar.d(4);
        if (lVar.n() == a.aF) {
            lVar.d(8);
            return lVar.g();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
