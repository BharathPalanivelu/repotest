package com.google.android.exoplayer2.source.c.a;

import android.net.Uri;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.t;
import com.google.android.exoplayer2.source.ae;
import com.google.android.exoplayer2.source.c.a.a;
import com.google.android.exoplayer2.source.c.a.b;
import com.google.android.exoplayer2.z;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.JobManager;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d implements t.a<c> {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11612a = Pattern.compile("BANDWIDTH=(\\d+)\\b");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11613b = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f11614c = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f11615d = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f11616e = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f11617f = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f11618g = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern h = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern i = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern j = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern k = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern l = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern m = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern n = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern o = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern p = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern q = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern r = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern s = b("AUTOSELECT");
    private static final Pattern t = b(MessengerShareContentUtility.PREVIEW_DEFAULT);
    private static final Pattern u = b("FORCED");

    /* renamed from: b */
    public c a(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        LinkedList linkedList = new LinkedList();
        try {
            if (a(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                    break;
                                } else if (trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                } else {
                                    linkedList.add(trim);
                                }
                            } else {
                                linkedList.add(trim);
                                a a2 = a(new a(linkedList, bufferedReader), uri.toString());
                                com.google.android.exoplayer2.n.t.a((Closeable) bufferedReader);
                                return a2;
                            }
                        }
                    } else {
                        com.google.android.exoplayer2.n.t.a((Closeable) bufferedReader);
                        throw new ak("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                linkedList.add(trim);
                return b(new a(linkedList, bufferedReader), uri.toString());
            }
            throw new ae("Input does not start with the #EXTM3U header.", uri);
        } finally {
            com.google.android.exoplayer2.n.t.a((Closeable) bufferedReader);
        }
    }

    private static boolean a(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int a2 = a(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (a2 != "#EXTM3U".charAt(i2)) {
                return false;
            }
            a2 = bufferedReader.read();
        }
        return com.google.android.exoplayer2.n.t.a(a(bufferedReader, false, a2));
    }

    private static int a(BufferedReader bufferedReader, boolean z, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z || !com.google.android.exoplayer2.n.t.a(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    private static a a(a aVar, String str) throws IOException {
        int i2;
        int i3;
        String str2;
        int i4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        j jVar = null;
        List list = null;
        boolean z = false;
        while (aVar.a()) {
            String b2 = aVar.b();
            int i5 = -1;
            if (b2.startsWith("#EXT-X-MEDIA")) {
                int a2 = a(b2);
                String d2 = d(b2, m);
                String a3 = a(b2, q);
                String d3 = d(b2, p);
                String a4 = a(b2, o);
                int hashCode = a4.hashCode();
                if (hashCode != -959297733) {
                    if (hashCode != -333210994) {
                        if (hashCode == 62628790 && a4.equals("AUDIO")) {
                            i5 = 0;
                        }
                    } else if (a4.equals("CLOSED-CAPTIONS")) {
                        i5 = 2;
                    }
                } else if (a4.equals("SUBTITLES")) {
                    i5 = 1;
                }
                if (i5 == 0) {
                    j a5 = j.a(a3, "application/x-mpegURL", (String) null, (String) null, -1, -1, -1, (List<byte[]>) null, a2, d3);
                    if (d2 == null) {
                        jVar = a5;
                    } else {
                        arrayList2.add(new a.C0186a(d2, a5));
                    }
                } else if (i5 == 1) {
                    arrayList3.add(new a.C0186a(d2, j.a(a3, "application/x-mpegURL", "text/vtt", (String) null, -1, a2, d3)));
                } else if (i5 == 2) {
                    String a6 = a(b2, r);
                    if (a6.startsWith("CC")) {
                        i4 = Integer.parseInt(a6.substring(2));
                        str2 = "application/cea-608";
                    } else {
                        i4 = Integer.parseInt(a6.substring(7));
                        str2 = "application/cea-708";
                    }
                    int i6 = i4;
                    String str3 = str2;
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(j.a(a3, (String) null, str3, (String) null, -1, a2, d3, i6));
                }
            } else if (b2.startsWith("#EXT-X-STREAM-INF")) {
                int b3 = b(b2, f11612a);
                String d4 = d(b2, f11613b);
                String d5 = d(b2, f11614c);
                z |= b2.contains("CLOSED-CAPTIONS=NONE");
                if (d5 != null) {
                    String[] split = d5.split("x");
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt <= 0 || parseInt2 <= 0) {
                        parseInt = -1;
                    } else {
                        i5 = parseInt2;
                    }
                    i3 = parseInt;
                    i2 = i5;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                arrayList.add(new a.C0186a(aVar.b(), j.a(Integer.toString(arrayList.size()), "application/x-mpegURL", (String) null, d4, b3, i3, i2, -1.0f, (List<byte[]>) null, 0)));
            }
        }
        if (z) {
            list = Collections.emptyList();
        }
        return new a(str, arrayList, arrayList2, arrayList3, jVar, list);
    }

    private static int a(String str) {
        char c2 = 0;
        boolean a2 = a(str, t, false) | (a(str, u, false) ? (char) 2 : 0);
        if (a(str, s, false)) {
            c2 = 4;
        }
        return a2 | c2 ? 1 : 0;
    }

    private static b b(a aVar, String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        boolean z2 = false;
        b.a aVar2 = null;
        int i7 = 0;
        long j8 = -1;
        boolean z3 = false;
        while (true) {
            String str2 = null;
            String str3 = null;
            while (true) {
                if (aVar.a()) {
                    String b2 = aVar.b();
                    if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                        String a2 = a(b2, f11617f);
                        if ("VOD".equals(a2)) {
                            i3 = 1;
                        } else if ("EVENT".equals(a2)) {
                            i3 = 2;
                        } else {
                            throw new ak("Illegal playlist type: " + a2);
                        }
                    } else if (b2.startsWith("#EXT-X-START")) {
                        j2 = (long) (c(b2, i) * 1000000.0d);
                    } else if (b2.startsWith("#EXT-X-MAP")) {
                        String a3 = a(b2, m);
                        String d2 = d(b2, k);
                        if (d2 != null) {
                            String[] split = d2.split("@");
                            j8 = Long.parseLong(split[0]);
                            if (split.length > 1) {
                                j5 = Long.parseLong(split[1]);
                            }
                        }
                        aVar2 = new b.a(a3, j5, j8);
                        j5 = 0;
                        j8 = -1;
                    } else if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                        j3 = JobManager.NS_PER_MS * ((long) b(b2, f11615d));
                    } else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        i7 = b(b2, f11618g);
                        i5 = i7;
                    } else if (b2.startsWith("#EXT-X-VERSION")) {
                        i6 = b(b2, f11616e);
                    } else if (b2.startsWith("#EXTINF")) {
                        j7 = (long) (c(b2, h) * 1000000.0d);
                    } else if (b2.startsWith("#EXT-X-KEY")) {
                        z3 = "AES-128".equals(a(b2, l));
                        if (z3) {
                            str3 = a(b2, m);
                            str2 = d(b2, n);
                        }
                    } else if (b2.startsWith("#EXT-X-BYTERANGE")) {
                        String[] split2 = a(b2, j).split("@");
                        j8 = Long.parseLong(split2[0]);
                        if (split2.length > 1) {
                            j5 = Long.parseLong(split2[1]);
                        }
                    } else if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                        i4 = Integer.parseInt(b2.substring(b2.indexOf(58) + 1));
                        z = true;
                    } else if (b2.equals("#EXT-X-DISCONTINUITY")) {
                        i2++;
                    } else if (b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        if (j4 == 0) {
                            j4 = z.b(com.google.android.exoplayer2.n.t.f(b2.substring(b2.indexOf(58) + 1))) - j6;
                        }
                    } else if (b2.startsWith("#EXT-X-DATERANGE")) {
                        arrayList2.add(b2);
                    } else if (!b2.startsWith("#")) {
                        String hexString = !z3 ? null : str2 != null ? str2 : Integer.toHexString(i7);
                        int i8 = i7 + 1;
                        long j9 = j8 == -1 ? 0 : j5;
                        arrayList.add(new b.a(b2, j7, i2, j6, z3, str3, hexString, j9, j8));
                        j6 += j7;
                        if (j8 != -1) {
                            j9 += j8;
                        }
                        j5 = j9;
                        i7 = i8;
                        j7 = 0;
                        j8 = -1;
                    } else if (b2.equals("#EXT-X-ENDLIST")) {
                        z2 = true;
                    }
                } else {
                    return new b(i3, str, j2, j4, z, i4, i5, i6, j3, z2, j4 != 0, aVar2, arrayList, arrayList2);
                }
            }
        }
    }

    private static String a(String str, Pattern pattern) throws ak {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new ak("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static int b(String str, Pattern pattern) throws ak {
        return Integer.parseInt(a(str, pattern));
    }

    private static double c(String str, Pattern pattern) throws ak {
        return Double.parseDouble(a(str, pattern));
    }

    private static String d(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static boolean a(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals("YES") : z;
    }

    private static Pattern b(String str) {
        return Pattern.compile(str + "=(" + "NO" + "|" + "YES" + SQLBuilder.PARENTHESES_RIGHT);
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedReader f11619a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<String> f11620b;

        /* renamed from: c  reason: collision with root package name */
        private String f11621c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f11620b = queue;
            this.f11619a = bufferedReader;
        }

        public boolean a() throws IOException {
            if (this.f11621c != null) {
                return true;
            }
            if (!this.f11620b.isEmpty()) {
                this.f11621c = this.f11620b.poll();
                return true;
            }
            do {
                String readLine = this.f11619a.readLine();
                this.f11621c = readLine;
                if (readLine == null) {
                    return false;
                }
                this.f11621c = this.f11621c.trim();
            } while (this.f11621c.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (!a()) {
                return null;
            }
            String str = this.f11621c;
            this.f11621c = null;
            return str;
        }
    }
}
