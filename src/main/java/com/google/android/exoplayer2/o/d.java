package com.google.android.exoplayer2.o;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.facebook.common.util.ByteConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.s.v;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.imsdk.TIMGroupManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tencent.tls.platform.SigType;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final a f11008a = a.a("OMX.google.raw.decoder");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11009b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<a, List<a>> f11010c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f11011d = new SparseIntArray();

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f11012e = new SparseIntArray();

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Integer> f11013f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private static int f11014g = -1;

    private interface c {
        int a();

        MediaCodecInfo a(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    private static int a(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE /*16384*/:
                return 5652480;
            case TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG /*32768*/:
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST:
                return 9437184;
            default:
                return -1;
        }
    }

    public static class b extends Exception {
        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static {
        f11011d.put(66, 1);
        f11011d.put(77, 2);
        f11011d.put(88, 4);
        f11011d.put(100, 8);
        f11012e.put(10, 1);
        f11012e.put(11, 4);
        f11012e.put(12, 8);
        f11012e.put(13, 16);
        f11012e.put(20, 32);
        f11012e.put(21, 64);
        f11012e.put(22, 128);
        f11012e.put(30, 256);
        f11012e.put(31, 512);
        f11012e.put(32, 1024);
        f11012e.put(40, 2048);
        f11012e.put(41, 4096);
        f11012e.put(42, 8192);
        f11012e.put(50, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
        f11012e.put(51, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG);
        f11012e.put(52, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        f11013f.put("L30", 1);
        f11013f.put("L60", 4);
        f11013f.put("L63", 16);
        f11013f.put("L90", 64);
        f11013f.put("L93", 256);
        f11013f.put("L120", 1024);
        f11013f.put("L123", 4096);
        f11013f.put("L150", Integer.valueOf(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE));
        f11013f.put("L153", Integer.valueOf(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
        f11013f.put("L156", Integer.valueOf(SigType.D2));
        f11013f.put("L180", Integer.valueOf(ByteConstants.MB));
        f11013f.put("L183", 4194304);
        f11013f.put("L186", 16777216);
        f11013f.put("H30", 2);
        f11013f.put("H60", 8);
        f11013f.put("H63", 32);
        f11013f.put("H90", 128);
        f11013f.put("H93", 512);
        f11013f.put("H120", 2048);
        f11013f.put("H123", 8192);
        f11013f.put("H150", Integer.valueOf(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG));
        f11013f.put("H153", 131072);
        f11013f.put("H156", 524288);
        f11013f.put("H180", 2097152);
        f11013f.put("H183", 8388608);
        f11013f.put("H186", 33554432);
    }

    public static a a() {
        return f11008a;
    }

    public static a a(String str, boolean z) throws b {
        List<a> b2 = b(str, z);
        if (b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
    }

    public static synchronized List<a> b(String str, boolean z) throws b {
        synchronized (d.class) {
            a aVar = new a(str, z);
            List<a> list = f11010c.get(aVar);
            if (list != null) {
                return list;
            }
            List<a> a2 = a(aVar, v.f11449a >= 21 ? new e(z) : new C0179d());
            if (z && a2.isEmpty() && 21 <= v.f11449a && v.f11449a <= 23) {
                a2 = a(aVar, (c) new C0179d());
                if (!a2.isEmpty()) {
                    Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + a2.get(0).f10994a);
                }
            }
            a(a2);
            List<a> unmodifiableList = Collections.unmodifiableList(a2);
            f11010c.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int b() throws b {
        if (f11014g == -1) {
            int i = 0;
            a a2 = a("video/avc", false);
            if (a2 != null) {
                MediaCodecInfo.CodecProfileLevel[] a3 = a2.a();
                int length = a3.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(a(a3[i].level), i2);
                    i++;
                }
                i = Math.max(i2, v.f11449a >= 21 ? 345600 : 172800);
            }
            f11014g = i;
        }
        return f11014g;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r3.equals("hev1") != false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String r9) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r9.split(r1)
            r2 = 0
            r3 = r1[r2]
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r5) {
                case 3006243: goto L_0x0036;
                case 3006244: goto L_0x002c;
                case 3199032: goto L_0x0023;
                case 3214780: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0040
        L_0x0019:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0023:
            java.lang.String r5 = "hev1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0040
            goto L_0x0041
        L_0x002c:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 3
            goto L_0x0041
        L_0x0036:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 2
            goto L_0x0041
        L_0x0040:
            r2 = -1
        L_0x0041:
            if (r2 == 0) goto L_0x004f
            if (r2 == r8) goto L_0x004f
            if (r2 == r7) goto L_0x004a
            if (r2 == r6) goto L_0x004a
            return r0
        L_0x004a:
            android.util.Pair r9 = b((java.lang.String) r9, (java.lang.String[]) r1)
            return r9
        L_0x004f:
            android.util.Pair r9 = a((java.lang.String) r9, (java.lang.String[]) r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.o.d.a(java.lang.String):android.util.Pair");
    }

    private static List<a> a(a aVar, c cVar) throws b {
        ArrayList arrayList;
        String name;
        String str;
        a aVar2 = aVar;
        c cVar2 = cVar;
        try {
            arrayList = new ArrayList();
            String str2 = aVar2.f11015a;
            int a2 = cVar.a();
            boolean b2 = cVar.b();
            int i = 0;
            while (i < a2) {
                MediaCodecInfo a3 = cVar2.a(i);
                name = a3.getName();
                if (a(a3, name, b2)) {
                    String[] supportedTypes = a3.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i2 = 0;
                    while (i2 < length) {
                        str = supportedTypes[i2];
                        if (str.equalsIgnoreCase(str2)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = a3.getCapabilitiesForType(str);
                            boolean a4 = cVar2.a(str2, capabilitiesForType);
                            boolean b3 = b(name);
                            if (b2) {
                                if (aVar2.f11016b != a4) {
                                }
                                arrayList.add(a.a(name, str2, capabilitiesForType, b3, false));
                            }
                            if (!b2 && !aVar2.f11016b) {
                                arrayList.add(a.a(name, str2, capabilitiesForType, b3, false));
                            } else if (!b2 && a4) {
                                arrayList.add(a.a(name + ".secure", str2, capabilitiesForType, b3, true));
                                return arrayList;
                            }
                        }
                        i2++;
                        cVar2 = cVar;
                    }
                    continue;
                }
                i++;
                cVar2 = cVar;
            }
            return arrayList;
        } catch (Exception e2) {
            if (v.f11449a <= 23) {
                if (!arrayList.isEmpty()) {
                    Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                }
            }
            Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str + SQLBuilder.PARENTHESES_RIGHT);
            throw e2;
        } catch (Exception e3) {
            throw new b(e3);
        }
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        if (v.f11449a < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (v.f11449a < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (v.f11449a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && "a70".equals(v.f11450b)) {
            return false;
        }
        if (v.f11449a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(v.f11450b) || "protou".equals(v.f11450b) || "ville".equals(v.f11450b) || "villeplus".equals(v.f11450b) || "villec2".equals(v.f11450b) || v.f11450b.startsWith("gee") || "C6602".equals(v.f11450b) || "C6603".equals(v.f11450b) || "C6606".equals(v.f11450b) || "C6616".equals(v.f11450b) || "L36h".equals(v.f11450b) || "SO-02E".equals(v.f11450b))) {
            return false;
        }
        if (v.f11449a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(v.f11450b) || "C1505".equals(v.f11450b) || "C1604".equals(v.f11450b) || "C1605".equals(v.f11450b))) {
            return false;
        }
        if (v.f11449a <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(v.f11451c) && (v.f11450b.startsWith("d2") || v.f11450b.startsWith("serrano") || v.f11450b.startsWith("jflte") || v.f11450b.startsWith("santos") || v.f11450b.startsWith("t0"))) {
            return false;
        }
        if (v.f11449a > 19 || !v.f11450b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(str)) {
            return true;
        }
        return false;
    }

    private static void a(List<a> list) {
        if (v.f11449a < 26) {
            if (list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(list.get(0).f10994a)) {
                for (int i = 1; i < list.size(); i++) {
                    a aVar = list.get(i);
                    if ("OMX.google.raw.decoder".equals(aVar.f10994a)) {
                        list.remove(i);
                        list.add(0, aVar);
                        return;
                    }
                }
            }
        }
    }

    private static boolean b(String str) {
        return v.f11449a <= 22 && (v.f11452d.equals("ODROID-XU3") || v.f11452d.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        int i;
        if (strArr.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = f11009b.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i = 1;
        } else if ("2".equals(group)) {
            i = 2;
        } else {
            Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + group);
            return null;
        }
        Integer num = f11013f.get(strArr[3]);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i), num);
        }
        Log.w("MediaCodecUtil", "Unknown HEVC level string: " + matcher.group(1));
        return null;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        Integer num;
        Integer num2;
        if (strArr.length < 2) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                num2 = valueOf;
            } else if (strArr.length >= 3) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            Integer valueOf2 = Integer.valueOf(f11011d.get(num2.intValue()));
            if (valueOf2 == null) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: " + num2);
                return null;
            }
            Integer valueOf3 = Integer.valueOf(f11012e.get(num.intValue()));
            if (valueOf3 != null) {
                return new Pair<>(valueOf2, valueOf3);
            }
            Log.w("MediaCodecUtil", "Unknown AVC level: " + num);
            return null;
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    @TargetApi(21)
    private static final class e implements c {

        /* renamed from: a  reason: collision with root package name */
        private final int f11017a;

        /* renamed from: b  reason: collision with root package name */
        private MediaCodecInfo[] f11018b;

        public boolean b() {
            return true;
        }

        public e(boolean z) {
            this.f11017a = z ? 1 : 0;
        }

        public int a() {
            c();
            return this.f11018b.length;
        }

        public MediaCodecInfo a(int i) {
            c();
            return this.f11018b[i];
        }

        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void c() {
            if (this.f11018b == null) {
                this.f11018b = new MediaCodecList(this.f11017a).getCodecInfos();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.o.d$d  reason: collision with other inner class name */
    private static final class C0179d implements c {
        public boolean b() {
            return false;
        }

        private C0179d() {
        }

        public int a() {
            return MediaCodecList.getCodecCount();
        }

        public MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f11015a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11016b;

        public a(String str, boolean z) {
            this.f11015a = str;
            this.f11016b = z;
        }

        public int hashCode() {
            String str = this.f11015a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f11016b ? 1231 : 1237);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (!TextUtils.equals(this.f11015a, aVar.f11015a) || this.f11016b != aVar.f11016b) {
                return false;
            }
            return true;
        }
    }
}
