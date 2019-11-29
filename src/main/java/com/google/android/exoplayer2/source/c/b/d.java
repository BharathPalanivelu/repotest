package com.google.android.exoplayer2.source.c.b;

import android.net.Uri;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r.t;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.c.b.b;
import com.google.android.exoplayer2.source.q;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.JobManager;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d implements t.a<c> {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11658a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11659b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f11660c = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f11661d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f11662e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f11663f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f11664g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern m = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern n = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern o = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern q = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern r = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern t = b("AUTOSELECT");
    private static final Pattern u = b(MessengerShareContentUtility.PREVIEW_DEFAULT);
    private static final Pattern v = b("FORCED");

    /* renamed from: a */
    public c b(Uri uri, InputStream inputStream) throws IOException {
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
                                v.a((Closeable) bufferedReader);
                                return a2;
                            }
                        }
                    } else {
                        v.a((Closeable) bufferedReader);
                        throw new p("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                linkedList.add(trim);
                return b(new a(linkedList, bufferedReader), uri.toString());
            }
            throw new q("Input does not start with the #EXTM3U header.", uri);
        } finally {
            v.a((Closeable) bufferedReader);
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
        return v.a(a(bufferedReader, false, a2));
    }

    private static int a(BufferedReader bufferedReader, boolean z, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z || !v.a(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.c.b.a a(com.google.android.exoplayer2.source.c.b.d.a r33, java.lang.String r34) throws java.io.IOException {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r1 = 0
            r7 = r1
            r8 = r7
            r1 = 0
        L_0x001d:
            boolean r9 = r33.a()
            if (r9 == 0) goto L_0x0190
            java.lang.String r9 = r33.b()
            java.lang.String r10 = "#EXT"
            boolean r10 = r9.startsWith(r10)
            if (r10 == 0) goto L_0x0032
            r3.add(r9)
        L_0x0032:
            java.lang.String r10 = "#EXT-X-MEDIA"
            boolean r10 = r9.startsWith(r10)
            r11 = 1
            if (r10 == 0) goto L_0x010c
            int r21 = a((java.lang.String) r9)
            java.util.regex.Pattern r10 = n
            java.lang.String r10 = c(r9, r10)
            java.util.regex.Pattern r13 = r
            java.lang.String r13 = d(r9, r13)
            java.util.regex.Pattern r14 = q
            java.lang.String r22 = c(r9, r14)
            java.util.regex.Pattern r14 = p
            java.lang.String r14 = d(r9, r14)
            int r15 = r14.hashCode()
            r12 = -959297733(0xffffffffc6d2473b, float:-26915.615)
            r2 = 2
            if (r15 == r12) goto L_0x0080
            r12 = -333210994(0xffffffffec239a8e, float:-7.911391E26)
            if (r15 == r12) goto L_0x0076
            r12 = 62628790(0x3bba3b6, float:1.1028458E-36)
            if (r15 == r12) goto L_0x006c
            goto L_0x008a
        L_0x006c:
            java.lang.String r12 = "AUDIO"
            boolean r12 = r14.equals(r12)
            if (r12 == 0) goto L_0x008a
            r12 = 0
            goto L_0x008b
        L_0x0076:
            java.lang.String r12 = "CLOSED-CAPTIONS"
            boolean r12 = r14.equals(r12)
            if (r12 == 0) goto L_0x008a
            r12 = 2
            goto L_0x008b
        L_0x0080:
            java.lang.String r12 = "SUBTITLES"
            boolean r12 = r14.equals(r12)
            if (r12 == 0) goto L_0x008a
            r12 = 1
            goto L_0x008b
        L_0x008a:
            r12 = -1
        L_0x008b:
            if (r12 == 0) goto L_0x00ec
            if (r12 == r11) goto L_0x00d2
            if (r12 == r2) goto L_0x0092
            goto L_0x001d
        L_0x0092:
            java.util.regex.Pattern r10 = s
            java.lang.String r9 = d(r9, r10)
            java.lang.String r10 = "CC"
            boolean r10 = r9.startsWith(r10)
            if (r10 == 0) goto L_0x00ab
            java.lang.String r2 = r9.substring(r2)
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.String r9 = "application/cea-608"
            goto L_0x00b6
        L_0x00ab:
            r2 = 7
            java.lang.String r2 = r9.substring(r2)
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.String r9 = "application/cea-708"
        L_0x00b6:
            r20 = r2
            r15 = r9
            if (r8 != 0) goto L_0x00c0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x00c0:
            r14 = 0
            r16 = 0
            r17 = -1
            r18 = r21
            r19 = r22
            com.google.android.exoplayer2.Format r2 = com.google.android.exoplayer2.Format.a((java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (int) r17, (int) r18, (java.lang.String) r19, (int) r20)
            r8.add(r2)
            goto L_0x001d
        L_0x00d2:
            r16 = 0
            r17 = -1
            java.lang.String r14 = "application/x-mpegURL"
            java.lang.String r15 = "text/vtt"
            r18 = r21
            r19 = r22
            com.google.android.exoplayer2.Format r2 = com.google.android.exoplayer2.Format.a((java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (int) r17, (int) r18, (java.lang.String) r19)
            com.google.android.exoplayer2.source.c.b.a$a r9 = new com.google.android.exoplayer2.source.c.b.a$a
            r9.<init>(r10, r2)
            r6.add(r9)
            goto L_0x001d
        L_0x00ec:
            r15 = 0
            r16 = 0
            r17 = -1
            r18 = -1
            r19 = -1
            r20 = 0
            java.lang.String r14 = "application/x-mpegURL"
            com.google.android.exoplayer2.Format r2 = com.google.android.exoplayer2.Format.a((java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (int) r17, (int) r18, (int) r19, (java.util.List<byte[]>) r20, (int) r21, (java.lang.String) r22)
            if (r10 != 0) goto L_0x0102
            r7 = r2
            goto L_0x001d
        L_0x0102:
            com.google.android.exoplayer2.source.c.b.a$a r9 = new com.google.android.exoplayer2.source.c.b.a$a
            r9.<init>(r10, r2)
            r5.add(r9)
            goto L_0x001d
        L_0x010c:
            java.lang.String r2 = "#EXT-X-STREAM-INF"
            boolean r2 = r9.startsWith(r2)
            if (r2 == 0) goto L_0x001d
            java.util.regex.Pattern r2 = f11659b
            int r2 = a((java.lang.String) r9, (java.util.regex.Pattern) r2)
            java.util.regex.Pattern r10 = f11658a
            java.lang.String r10 = c(r9, r10)
            if (r10 == 0) goto L_0x0126
            int r2 = java.lang.Integer.parseInt(r10)
        L_0x0126:
            r27 = r2
            java.util.regex.Pattern r2 = f11660c
            java.lang.String r26 = c(r9, r2)
            java.util.regex.Pattern r2 = f11661d
            java.lang.String r2 = c(r9, r2)
            java.lang.String r10 = "CLOSED-CAPTIONS=NONE"
            boolean r9 = r9.contains(r10)
            r1 = r1 | r9
            if (r2 == 0) goto L_0x0161
            java.lang.String r9 = "x"
            java.lang.String[] r2 = r2.split(r9)
            r9 = 0
            r10 = r2[r9]
            int r10 = java.lang.Integer.parseInt(r10)
            r2 = r2[r11]
            int r2 = java.lang.Integer.parseInt(r2)
            if (r10 <= 0) goto L_0x0159
            if (r2 > 0) goto L_0x0155
            goto L_0x0159
        L_0x0155:
            r12 = r2
            r16 = r10
            goto L_0x015c
        L_0x0159:
            r12 = -1
            r16 = -1
        L_0x015c:
            r29 = r12
            r28 = r16
            goto L_0x0166
        L_0x0161:
            r9 = 0
            r28 = -1
            r29 = -1
        L_0x0166:
            java.lang.String r2 = r33.b()
            boolean r10 = r0.add(r2)
            if (r10 == 0) goto L_0x001d
            int r10 = r4.size()
            java.lang.String r23 = java.lang.Integer.toString(r10)
            r25 = 0
            r30 = -1082130432(0xffffffffbf800000, float:-1.0)
            r31 = 0
            r32 = 0
            java.lang.String r24 = "application/x-mpegURL"
            com.google.android.exoplayer2.Format r10 = com.google.android.exoplayer2.Format.a((java.lang.String) r23, (java.lang.String) r24, (java.lang.String) r25, (java.lang.String) r26, (int) r27, (int) r28, (int) r29, (float) r30, (java.util.List<byte[]>) r31, (int) r32)
            com.google.android.exoplayer2.source.c.b.a$a r11 = new com.google.android.exoplayer2.source.c.b.a$a
            r11.<init>(r2, r10)
            r4.add(r11)
            goto L_0x001d
        L_0x0190:
            if (r1 == 0) goto L_0x0197
            java.util.List r0 = java.util.Collections.emptyList()
            r8 = r0
        L_0x0197:
            com.google.android.exoplayer2.source.c.b.a r0 = new com.google.android.exoplayer2.source.c.b.a
            r1 = r0
            r2 = r34
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.b.d.a(com.google.android.exoplayer2.source.c.b.d$a, java.lang.String):com.google.android.exoplayer2.source.c.b.a");
    }

    private static int a(String str) {
        char c2 = 0;
        boolean a2 = a(str, u, false) | (a(str, v, false) ? (char) 2 : 0);
        if (a(str, t, false)) {
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
        boolean z3 = false;
        b.a aVar2 = null;
        int i7 = 0;
        long j8 = -1;
        boolean z4 = false;
        loop0:
        while (true) {
            String str2 = null;
            String str3 = null;
            while (true) {
                if (!aVar.a()) {
                    break loop0;
                }
                String b2 = aVar.b();
                if (b2.startsWith("#EXT")) {
                    arrayList2.add(b2);
                }
                if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String d2 = d(b2, f11664g);
                    if ("VOD".equals(d2)) {
                        i3 = 1;
                    } else if ("EVENT".equals(d2)) {
                        i3 = 2;
                    }
                } else if (b2.startsWith("#EXT-X-START")) {
                    j2 = (long) (b(b2, j) * 1000000.0d);
                } else if (b2.startsWith("#EXT-X-MAP")) {
                    String d3 = d(b2, n);
                    String c2 = c(b2, l);
                    if (c2 != null) {
                        String[] split = c2.split("@");
                        j8 = Long.parseLong(split[0]);
                        if (split.length > 1) {
                            j5 = Long.parseLong(split[1]);
                        }
                    }
                    aVar2 = new b.a(d3, j5, j8);
                    j5 = 0;
                    j8 = -1;
                } else if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                    j3 = JobManager.NS_PER_MS * ((long) a(b2, f11662e));
                } else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    i7 = a(b2, h);
                    i5 = i7;
                } else if (b2.startsWith("#EXT-X-VERSION")) {
                    i6 = a(b2, f11663f);
                } else if (b2.startsWith("#EXTINF")) {
                    j7 = (long) (b(b2, i) * 1000000.0d);
                } else if (b2.startsWith("#EXT-X-KEY")) {
                    z4 = "AES-128".equals(d(b2, m));
                    if (z4) {
                        String d4 = d(b2, n);
                        str2 = c(b2, o);
                        str3 = d4;
                    }
                } else if (b2.startsWith("#EXT-X-BYTERANGE")) {
                    String[] split2 = d(b2, k).split("@");
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
                        j4 = com.google.android.exoplayer2.b.b(v.f(b2.substring(b2.indexOf(58) + 1))) - j6;
                    }
                } else if (!b2.startsWith("#")) {
                    String hexString = !z4 ? null : str2 != null ? str2 : Integer.toHexString(i7);
                    int i8 = i7 + 1;
                    if (j8 == -1) {
                        j5 = 0;
                    }
                    arrayList.add(new b.a(b2, j7, i2, j6, z4, str3, hexString, j5, j8));
                    j6 += j7;
                    if (j8 != -1) {
                        j5 += j8;
                    }
                    i7 = i8;
                    j7 = 0;
                    j8 = -1;
                } else if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    z2 = true;
                } else if (b2.equals("#EXT-X-ENDLIST")) {
                    z3 = true;
                }
            }
        }
        return new b(i3, str, arrayList2, j2, j4, z, i4, i5, i6, j3, z2, z3, j4 != 0, aVar2, arrayList);
    }

    private static int a(String str, Pattern pattern) throws p {
        return Integer.parseInt(d(str, pattern));
    }

    private static double b(String str, Pattern pattern) throws p {
        return Double.parseDouble(d(str, pattern));
    }

    private static String c(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static String d(String str, Pattern pattern) throws p {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new p("Couldn't match " + pattern.pattern() + " in " + str);
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
        private final BufferedReader f11665a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<String> f11666b;

        /* renamed from: c  reason: collision with root package name */
        private String f11667c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f11666b = queue;
            this.f11665a = bufferedReader;
        }

        public boolean a() throws IOException {
            if (this.f11667c != null) {
                return true;
            }
            if (!this.f11666b.isEmpty()) {
                this.f11667c = this.f11666b.poll();
                return true;
            }
            do {
                String readLine = this.f11665a.readLine();
                this.f11667c = readLine;
                if (readLine == null) {
                    return false;
                }
                this.f11667c = this.f11667c.trim();
            } while (this.f11667c.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (!a()) {
                return null;
            }
            String str = this.f11667c;
            this.f11667c = null;
            return str;
        }
    }
}
