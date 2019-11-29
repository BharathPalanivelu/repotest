package androidx.e.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.imsdk.protocol.im_common;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class a {
    private static final c A = new c("JPEGInterchangeFormat", im_common.GRP_CONFERENCE, 4);
    private static final c B = new c("JPEGInterchangeFormatLength", im_common.GRP_HRTX, 4);
    private static final HashMap<Integer, c>[] C;
    private static final HashMap<String, c>[] D;
    private static final HashSet<String> E = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    private static final HashMap<Integer, Integer> F = new HashMap<>();
    private static final Pattern X = Pattern.compile(".*[1-9].*");
    private static final Pattern Y = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f2001a = {8, 8, 8};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f2002b = {4};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f2003c = {8};

    /* renamed from: d  reason: collision with root package name */
    static final byte[] f2004d = {-1, -40, -1};

    /* renamed from: e  reason: collision with root package name */
    static final String[] f2005e = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f2006f = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: g  reason: collision with root package name */
    static final byte[] f2007g = {65, 83, 67, 73, 73, 0, 0, 0};
    static final c[][] h;
    static final Charset i = Charset.forName("US-ASCII");
    static final byte[] j = "Exif\u0000\u0000".getBytes(i);
    private static final List<Integer> k = Arrays.asList(new Integer[]{1, 6, 3, 8});
    private static final List<Integer> l = Arrays.asList(new Integer[]{2, 7, 4, 5});
    private static final byte[] m = {79, 76, 89, 77, 80, 0};
    private static final byte[] n = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static SimpleDateFormat o = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private static final c[] p = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", TiffUtil.TIFF_TAG_ORIENTATION, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", im_common.NEARBY_PEOPLE_TMP_OWN_MSG, 2), new c("DateTime", im_common.BUSINESS_MB_WPA_C2C_TMP_MSG, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", im_common.GRP_CONFERENCE, 4), new c("JPEGInterchangeFormatLength", im_common.GRP_HRTX, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
    private static final c[] q = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c[] r = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
    private static final c[] s = {new c("InteroperabilityIndex", 1, 2)};
    private static final c[] t = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", TiffUtil.TIFF_TAG_ORIENTATION, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", im_common.NEARBY_PEOPLE_TMP_OWN_MSG, 2), new c("DateTime", im_common.BUSINESS_MB_WPA_C2C_TMP_MSG, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", im_common.GRP_CONFERENCE, 4), new c("JPEGInterchangeFormatLength", im_common.GRP_HRTX, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c u = new c("StripOffsets", 273, 3);
    private static final c[] v = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
    private static final c[] w = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
    private static final c[] x = {new c("AspectFrame", 4371, 3)};
    private static final c[] y = {new c("ColorSpace", 55, 3)};
    private static final c[] z = {new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
    private final String G;
    private final AssetManager.AssetInputStream H;
    private int I;
    private final HashMap<String, b>[] J;
    private Set<Integer> K;
    private ByteOrder L = ByteOrder.BIG_ENDIAN;
    private boolean M;
    private int N;
    private int O;
    private byte[] P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;

    static {
        c[] cVarArr = p;
        h = new c[][]{cVarArr, q, r, s, t, cVarArr, v, w, x, y};
        c[][] cVarArr2 = h;
        C = new HashMap[cVarArr2.length];
        D = new HashMap[cVarArr2.length];
        o.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < h.length; i2++) {
            C[i2] = new HashMap<>();
            D[i2] = new HashMap<>();
            for (c cVar : h[i2]) {
                C[i2].put(Integer.valueOf(cVar.f2017a), cVar);
                D[i2].put(cVar.f2018b, cVar);
            }
        }
        F.put(Integer.valueOf(z[0].f2017a), 5);
        F.put(Integer.valueOf(z[1].f2017a), 1);
        F.put(Integer.valueOf(z[2].f2017a), 2);
        F.put(Integer.valueOf(z[3].f2017a), 3);
        F.put(Integer.valueOf(z[4].f2017a), 7);
        F.put(Integer.valueOf(z[5].f2017a), 8);
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f2021a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2022b;

        d(long j, long j2) {
            if (j2 == 0) {
                this.f2021a = 0;
                this.f2022b = 1;
                return;
            }
            this.f2021a = j;
            this.f2022b = j2;
        }

        public String toString() {
            return this.f2021a + Constants.URL_PATH_DELIMITER + this.f2022b;
        }

        public double a() {
            double d2 = (double) this.f2021a;
            double d3 = (double) this.f2022b;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f2014a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2015b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f2016c;

        b(int i, int i2, byte[] bArr) {
            this.f2014a = i;
            this.f2015b = i2;
            this.f2016c = bArr;
        }

        public static b a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f2006f[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new b(3, iArr.length, wrap.array());
        }

        public static b a(int i, ByteOrder byteOrder) {
            return a(new int[]{i}, byteOrder);
        }

        public static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f2006f[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new b(4, jArr.length, wrap.array());
        }

        public static b a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static b a(String str) {
            byte[] bytes = (str + 0).getBytes(a.i);
            return new b(2, bytes.length, bytes);
        }

        public static b a(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f2006f[5] * dVarArr.length)]);
            wrap.order(byteOrder);
            for (d dVar : dVarArr) {
                wrap.putInt((int) dVar.f2021a);
                wrap.putInt((int) dVar.f2022b);
            }
            return new b(5, dVarArr.length, wrap.array());
        }

        public static b a(d dVar, ByteOrder byteOrder) {
            return a(new d[]{dVar}, byteOrder);
        }

        public String toString() {
            return SQLBuilder.PARENTHESES_LEFT + a.f2005e[this.f2014a] + ", data length:" + this.f2016c.length + SQLBuilder.PARENTHESES_RIGHT;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x01ab A[SYNTHETIC, Splitter:B:164:0x01ab] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                androidx.e.a.a$a r3 = new androidx.e.a.a$a     // Catch:{ IOException -> 0x0196, all -> 0x0193 }
                byte[] r4 = r10.f2016c     // Catch:{ IOException -> 0x0196, all -> 0x0193 }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0196, all -> 0x0193 }
                r3.a((java.nio.ByteOrder) r11)     // Catch:{ IOException -> 0x0191 }
                int r11 = r10.f2014a     // Catch:{ IOException -> 0x0191 }
                r4 = 1
                r5 = 0
                switch(r11) {
                    case 1: goto L_0x014c;
                    case 2: goto L_0x00fd;
                    case 3: goto L_0x00e3;
                    case 4: goto L_0x00c9;
                    case 5: goto L_0x00a6;
                    case 6: goto L_0x014c;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x008c;
                    case 9: goto L_0x0072;
                    case 10: goto L_0x004d;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ IOException -> 0x0191 }
            L_0x0016:
                goto L_0x0188
            L_0x0018:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x001c:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x0029
                double r6 = r3.readDouble()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x001c
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0031:
                return r11
            L_0x0032:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x0036:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x0044
                float r4 = r3.readFloat()     // Catch:{ IOException -> 0x0191 }
                double r6 = (double) r4     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x0036
            L_0x0044:
                r3.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x004c
            L_0x0048:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004c:
                return r11
            L_0x004d:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                androidx.e.a.a$d[] r11 = new androidx.e.a.a.d[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x0051:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x0069
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0191 }
                long r6 = (long) r4     // Catch:{ IOException -> 0x0191 }
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0191 }
                long r8 = (long) r4     // Catch:{ IOException -> 0x0191 }
                androidx.e.a.a$d r4 = new androidx.e.a.a$d     // Catch:{ IOException -> 0x0191 }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x0051
            L_0x0069:
                r3.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0071:
                return r11
            L_0x0072:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x0076:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x0083
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x0076
            L_0x0083:
                r3.close()     // Catch:{ IOException -> 0x0087 }
                goto L_0x008b
            L_0x0087:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008b:
                return r11
            L_0x008c:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x0090:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x009d
                short r4 = r3.readShort()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x0090
            L_0x009d:
                r3.close()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a5:
                return r11
            L_0x00a6:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                androidx.e.a.a$d[] r11 = new androidx.e.a.a.d[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x00aa:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x00c0
                long r6 = r3.b()     // Catch:{ IOException -> 0x0191 }
                long r8 = r3.b()     // Catch:{ IOException -> 0x0191 }
                androidx.e.a.a$d r4 = new androidx.e.a.a$d     // Catch:{ IOException -> 0x0191 }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x00aa
            L_0x00c0:
                r3.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c8:
                return r11
            L_0x00c9:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x00cd:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x00da
                long r6 = r3.b()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x00cd
            L_0x00da:
                r3.close()     // Catch:{ IOException -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e2:
                return r11
            L_0x00e3:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191 }
            L_0x00e7:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x00f4
                int r4 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0191 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0191 }
                int r5 = r5 + 1
                goto L_0x00e7
            L_0x00f4:
                r3.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00fc
            L_0x00f8:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fc:
                return r11
            L_0x00fd:
                int r11 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                byte[] r6 = androidx.e.a.a.f2007g     // Catch:{ IOException -> 0x0191 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0191 }
                if (r11 < r6) goto L_0x011e
                r11 = 0
            L_0x0105:
                byte[] r6 = androidx.e.a.a.f2007g     // Catch:{ IOException -> 0x0191 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0191 }
                if (r11 >= r6) goto L_0x0119
                byte[] r6 = r10.f2016c     // Catch:{ IOException -> 0x0191 }
                byte r6 = r6[r11]     // Catch:{ IOException -> 0x0191 }
                byte[] r7 = androidx.e.a.a.f2007g     // Catch:{ IOException -> 0x0191 }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x0191 }
                if (r6 == r7) goto L_0x0116
                r4 = 0
                goto L_0x0119
            L_0x0116:
                int r11 = r11 + 1
                goto L_0x0105
            L_0x0119:
                if (r4 == 0) goto L_0x011e
                byte[] r11 = androidx.e.a.a.f2007g     // Catch:{ IOException -> 0x0191 }
                int r5 = r11.length     // Catch:{ IOException -> 0x0191 }
            L_0x011e:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0191 }
                r11.<init>()     // Catch:{ IOException -> 0x0191 }
            L_0x0123:
                int r4 = r10.f2015b     // Catch:{ IOException -> 0x0191 }
                if (r5 >= r4) goto L_0x013f
                byte[] r4 = r10.f2016c     // Catch:{ IOException -> 0x0191 }
                byte r4 = r4[r5]     // Catch:{ IOException -> 0x0191 }
                if (r4 != 0) goto L_0x012e
                goto L_0x013f
            L_0x012e:
                r6 = 32
                if (r4 < r6) goto L_0x0137
                char r4 = (char) r4     // Catch:{ IOException -> 0x0191 }
                r11.append(r4)     // Catch:{ IOException -> 0x0191 }
                goto L_0x013c
            L_0x0137:
                r4 = 63
                r11.append(r4)     // Catch:{ IOException -> 0x0191 }
            L_0x013c:
                int r5 = r5 + 1
                goto L_0x0123
            L_0x013f:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0191 }
                r3.close()     // Catch:{ IOException -> 0x0147 }
                goto L_0x014b
            L_0x0147:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x014b:
                return r11
            L_0x014c:
                byte[] r11 = r10.f2016c     // Catch:{ IOException -> 0x0191 }
                int r11 = r11.length     // Catch:{ IOException -> 0x0191 }
                if (r11 != r4) goto L_0x0176
                byte[] r11 = r10.f2016c     // Catch:{ IOException -> 0x0191 }
                byte r11 = r11[r5]     // Catch:{ IOException -> 0x0191 }
                if (r11 < 0) goto L_0x0176
                byte[] r11 = r10.f2016c     // Catch:{ IOException -> 0x0191 }
                byte r11 = r11[r5]     // Catch:{ IOException -> 0x0191 }
                if (r11 > r4) goto L_0x0176
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0191 }
                char[] r4 = new char[r4]     // Catch:{ IOException -> 0x0191 }
                byte[] r6 = r10.f2016c     // Catch:{ IOException -> 0x0191 }
                byte r6 = r6[r5]     // Catch:{ IOException -> 0x0191 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0191 }
                r4[r5] = r6     // Catch:{ IOException -> 0x0191 }
                r11.<init>(r4)     // Catch:{ IOException -> 0x0191 }
                r3.close()     // Catch:{ IOException -> 0x0171 }
                goto L_0x0175
            L_0x0171:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0175:
                return r11
            L_0x0176:
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0191 }
                byte[] r4 = r10.f2016c     // Catch:{ IOException -> 0x0191 }
                java.nio.charset.Charset r5 = androidx.e.a.a.i     // Catch:{ IOException -> 0x0191 }
                r11.<init>(r4, r5)     // Catch:{ IOException -> 0x0191 }
                r3.close()     // Catch:{ IOException -> 0x0183 }
                goto L_0x0187
            L_0x0183:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0187:
                return r11
            L_0x0188:
                r3.close()     // Catch:{ IOException -> 0x018c }
                goto L_0x0190
            L_0x018c:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0190:
                return r2
            L_0x0191:
                r11 = move-exception
                goto L_0x0198
            L_0x0193:
                r11 = move-exception
                r3 = r2
                goto L_0x01a9
            L_0x0196:
                r11 = move-exception
                r3 = r2
            L_0x0198:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x01a8 }
                if (r3 == 0) goto L_0x01a7
                r3.close()     // Catch:{ IOException -> 0x01a3 }
                goto L_0x01a7
            L_0x01a3:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x01a7:
                return r2
            L_0x01a8:
                r11 = move-exception
            L_0x01a9:
                if (r3 == 0) goto L_0x01b3
                r3.close()     // Catch:{ IOException -> 0x01af }
                goto L_0x01b3
            L_0x01af:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x01b3:
                goto L_0x01b5
            L_0x01b4:
                throw r11
            L_0x01b5:
                goto L_0x01b4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.e.a.a.b.a(java.nio.ByteOrder):java.lang.Object");
        }

        public double b(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (a2 instanceof String) {
                return Double.parseDouble((String) a2);
            } else {
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof double[]) {
                    double[] dArr = (double[]) a2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof d[]) {
                    d[] dVarArr = (d[]) a2;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int c(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (a2 instanceof String) {
                return Integer.parseInt((String) a2);
            } else {
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String d(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                return null;
            }
            if (a2 instanceof String) {
                return (String) a2;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (a2 instanceof long[]) {
                long[] jArr = (long[]) a2;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (a2 instanceof int[]) {
                int[] iArr = (int[]) a2;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (a2 instanceof double[]) {
                double[] dArr = (double[]) a2;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(a2 instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) a2;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].f2021a);
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb.append(dVarArr[i].f2022b);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f2017a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2018b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2019c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2020d;

        c(String str, int i, int i2) {
            this.f2018b = str;
            this.f2017a = i;
            this.f2019c = i2;
            this.f2020d = -1;
        }

        c(String str, int i, int i2, int i3) {
            this.f2018b = str;
            this.f2017a = i;
            this.f2019c = i2;
            this.f2020d = i3;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i) {
            int i2 = this.f2019c;
            if (!(i2 == 7 || i == 7 || i2 == i)) {
                int i3 = this.f2020d;
                if (i3 != i) {
                    if ((i2 == 4 || i3 == 4) && i == 3) {
                        return true;
                    }
                    if ((this.f2019c == 9 || this.f2020d == 9) && i == 8) {
                        return true;
                    }
                    if ((this.f2019c == 12 || this.f2020d == 12) && i == 11) {
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }
    }

    public a(String str) throws IOException {
        c[][] cVarArr = h;
        this.J = new HashMap[cVarArr.length];
        this.K = new HashSet(cVarArr.length);
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.H = null;
            this.G = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    a((InputStream) fileInputStream2);
                    a((Closeable) fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) fileInputStream);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    public a(InputStream inputStream) throws IOException {
        c[][] cVarArr = h;
        this.J = new HashMap[cVarArr.length];
        this.K = new HashSet(cVarArr.length);
        if (inputStream != null) {
            this.G = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.H = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.H = null;
            }
            a(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }

    private b b(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < h.length; i2++) {
            b bVar = this.J[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    public String a(String str) {
        b b2 = b(str);
        if (b2 != null) {
            if (!E.contains(str)) {
                return b2.d(this.L);
            }
            if (!str.equals("GPSTimeStamp")) {
                try {
                    return Double.toString(b2.b(this.L));
                } catch (NumberFormatException unused) {
                }
            } else if (b2.f2014a == 5 || b2.f2014a == 10) {
                d[] dVarArr = (d[]) b2.a(this.L);
                if (dVarArr == null || dVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                    return null;
                }
                return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) dVarArr[0].f2021a) / ((float) dVarArr[0].f2022b))), Integer.valueOf((int) (((float) dVarArr[1].f2021a) / ((float) dVarArr[1].f2022b))), Integer.valueOf((int) (((float) dVarArr[2].f2021a) / ((float) dVarArr[2].f2022b)))});
            } else {
                Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + b2.f2014a);
                return null;
            }
        }
        return null;
    }

    public int a(String str, int i2) {
        b b2 = b(str);
        if (b2 == null) {
            return i2;
        }
        try {
            return b2.c(this.L);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.W = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.io.InputStream r5) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            androidx.e.a.a$c[][] r2 = h     // Catch:{ IOException -> 0x004a }
            int r2 = r2.length     // Catch:{ IOException -> 0x004a }
            if (r1 >= r2) goto L_0x0013
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r2 = r4.J     // Catch:{ IOException -> 0x004a }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x004a }
            r3.<init>()     // Catch:{ IOException -> 0x004a }
            r2[r1] = r3     // Catch:{ IOException -> 0x004a }
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0013:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x004a }
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x004a }
            r5 = r1
            java.io.BufferedInputStream r5 = (java.io.BufferedInputStream) r5     // Catch:{ IOException -> 0x004a }
            int r5 = r4.a((java.io.BufferedInputStream) r5)     // Catch:{ IOException -> 0x004a }
            r4.I = r5     // Catch:{ IOException -> 0x004a }
            androidx.e.a.a$a r5 = new androidx.e.a.a$a     // Catch:{ IOException -> 0x004a }
            r5.<init>((java.io.InputStream) r1)     // Catch:{ IOException -> 0x004a }
            int r1 = r4.I     // Catch:{ IOException -> 0x004a }
            switch(r1) {
                case 0: goto L_0x003e;
                case 1: goto L_0x003e;
                case 2: goto L_0x003e;
                case 3: goto L_0x003e;
                case 4: goto L_0x003a;
                case 5: goto L_0x003e;
                case 6: goto L_0x003e;
                case 7: goto L_0x0036;
                case 8: goto L_0x003e;
                case 9: goto L_0x0032;
                case 10: goto L_0x002e;
                case 11: goto L_0x003e;
                default: goto L_0x002d;
            }     // Catch:{ IOException -> 0x004a }
        L_0x002d:
            goto L_0x0041
        L_0x002e:
            r4.d((androidx.e.a.a.C0043a) r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0041
        L_0x0032:
            r4.b((androidx.e.a.a.C0043a) r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0041
        L_0x0036:
            r4.c((androidx.e.a.a.C0043a) r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0041
        L_0x003a:
            r4.a(r5, r0, r0)     // Catch:{ IOException -> 0x004a }
            goto L_0x0041
        L_0x003e:
            r4.a((androidx.e.a.a.C0043a) r5)     // Catch:{ IOException -> 0x004a }
        L_0x0041:
            r4.f(r5)     // Catch:{ IOException -> 0x004a }
            r5 = 1
            r4.W = r5     // Catch:{ IOException -> 0x004a }
            goto L_0x004c
        L_0x0048:
            r5 = move-exception
            goto L_0x0050
        L_0x004a:
            r4.W = r0     // Catch:{ all -> 0x0048 }
        L_0x004c:
            r4.a()
            return
        L_0x0050:
            r4.a()
            goto L_0x0055
        L_0x0054:
            throw r5
        L_0x0055:
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.e.a.a.a(java.io.InputStream):void");
    }

    private int a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (a(bArr)) {
            return 4;
        }
        if (b(bArr)) {
            return 9;
        }
        if (c(bArr)) {
            return 7;
        }
        return d(bArr) ? 10 : 0;
    }

    private static boolean a(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f2004d;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean b(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean c(byte[] bArr) throws IOException {
        C0043a aVar = new C0043a(bArr);
        this.L = e(aVar);
        aVar.a(this.L);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 20306 || readShort == 21330;
    }

    private boolean d(byte[] bArr) throws IOException {
        C0043a aVar = new C0043a(bArr);
        this.L = e(aVar);
        aVar.a(this.L);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 85;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0088 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.e.a.a.C0043a r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r10.a((java.nio.ByteOrder) r0)
            long r0 = (long) r11
            r10.a((long) r0)
            byte r0 = r10.readByte()
            java.lang.String r1 = "Invalid marker: "
            r2 = -1
            if (r0 != r2) goto L_0x0153
            r3 = 1
            int r11 = r11 + r3
            byte r4 = r10.readByte()
            r5 = -40
            if (r4 != r5) goto L_0x0138
            int r11 = r11 + r3
        L_0x001d:
            byte r0 = r10.readByte()
            if (r0 != r2) goto L_0x011b
            int r11 = r11 + r3
            byte r0 = r10.readByte()
            int r11 = r11 + r3
            r1 = -39
            if (r0 == r1) goto L_0x0115
            r1 = -38
            if (r0 != r1) goto L_0x0033
            goto L_0x0115
        L_0x0033:
            int r1 = r10.readUnsignedShort()
            int r1 = r1 + -2
            int r11 = r11 + 2
            java.lang.String r4 = "Invalid length"
            if (r1 < 0) goto L_0x010f
            r5 = -31
            r6 = 0
            java.lang.String r7 = "Invalid exif"
            if (r0 == r5) goto L_0x00ba
            r5 = -2
            if (r0 == r5) goto L_0x0090
            switch(r0) {
                case -64: goto L_0x0057;
                case -63: goto L_0x0057;
                case -62: goto L_0x0057;
                case -61: goto L_0x0057;
                default: goto L_0x004c;
            }
        L_0x004c:
            switch(r0) {
                case -59: goto L_0x0057;
                case -58: goto L_0x0057;
                case -57: goto L_0x0057;
                default: goto L_0x004f;
            }
        L_0x004f:
            switch(r0) {
                case -55: goto L_0x0057;
                case -54: goto L_0x0057;
                case -53: goto L_0x0057;
                default: goto L_0x0052;
            }
        L_0x0052:
            switch(r0) {
                case -51: goto L_0x0057;
                case -50: goto L_0x0057;
                case -49: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x00e4
        L_0x0057:
            int r0 = r10.skipBytes(r3)
            if (r0 != r3) goto L_0x0088
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r0 = r9.J
            r0 = r0[r12]
            int r5 = r10.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r9.L
            androidx.e.a.a$b r5 = androidx.e.a.a.b.a((long) r5, (java.nio.ByteOrder) r7)
            java.lang.String r6 = "ImageLength"
            r0.put(r6, r5)
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r0 = r9.J
            r0 = r0[r12]
            int r5 = r10.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r9.L
            androidx.e.a.a$b r5 = androidx.e.a.a.b.a((long) r5, (java.nio.ByteOrder) r7)
            java.lang.String r6 = "ImageWidth"
            r0.put(r6, r5)
            int r1 = r1 + -5
            goto L_0x00e4
        L_0x0088:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Invalid SOFx"
            r10.<init>(r11)
            throw r10
        L_0x0090:
            byte[] r0 = new byte[r1]
            int r5 = r10.read(r0)
            if (r5 != r1) goto L_0x00b4
            java.lang.String r1 = "UserComment"
            java.lang.String r5 = r9.a((java.lang.String) r1)
            if (r5 != 0) goto L_0x00b2
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r5 = r9.J
            r5 = r5[r3]
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r8 = i
            r7.<init>(r0, r8)
            androidx.e.a.a$b r0 = androidx.e.a.a.b.a((java.lang.String) r7)
            r5.put(r1, r0)
        L_0x00b2:
            r1 = 0
            goto L_0x00e4
        L_0x00b4:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x00ba:
            r0 = 6
            if (r1 >= r0) goto L_0x00be
            goto L_0x00e4
        L_0x00be:
            byte[] r5 = new byte[r0]
            int r8 = r10.read(r5)
            if (r8 != r0) goto L_0x0109
            int r11 = r11 + 6
            int r1 = r1 + -6
            byte[] r0 = j
            boolean r0 = java.util.Arrays.equals(r5, r0)
            if (r0 != 0) goto L_0x00d3
            goto L_0x00e4
        L_0x00d3:
            if (r1 <= 0) goto L_0x0103
            r9.R = r11
            byte[] r0 = new byte[r1]
            int r5 = r10.read(r0)
            if (r5 != r1) goto L_0x00fd
            int r11 = r11 + r1
            r9.a((byte[]) r0, (int) r12)
            goto L_0x00b2
        L_0x00e4:
            if (r1 < 0) goto L_0x00f7
            int r0 = r10.skipBytes(r1)
            if (r0 != r1) goto L_0x00ef
            int r11 = r11 + r1
            goto L_0x001d
        L_0x00ef:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Invalid JPEG segment"
            r10.<init>(r11)
            throw r10
        L_0x00f7:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r4)
            throw r10
        L_0x00fd:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x0103:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x0109:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r7)
            throw r10
        L_0x010f:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r4)
            throw r10
        L_0x0115:
            java.nio.ByteOrder r11 = r9.L
            r10.a((java.nio.ByteOrder) r11)
            return
        L_0x011b:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Invalid marker:"
            r11.append(r12)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0138:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0153:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            goto L_0x016f
        L_0x016e:
            throw r10
        L_0x016f:
            goto L_0x016e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.e.a.a.a(androidx.e.a.a$a, int, int):void");
    }

    private void a(C0043a aVar) throws IOException {
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        b((InputStream) aVar);
        if (this.I == 8) {
            b bVar = this.J[1].get("MakerNote");
            if (bVar != null) {
                C0043a aVar2 = new C0043a(bVar.f2016c);
                aVar2.a(this.L);
                aVar2.a(6);
                b(aVar2, 9);
                b bVar2 = this.J[9].get("ColorSpace");
                if (bVar2 != null) {
                    this.J[1].put("ColorSpace", bVar2);
                }
            }
        }
    }

    private void b(C0043a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i2, 5);
        aVar.a((long) i3);
        aVar.a(ByteOrder.BIG_ENDIAN);
        int readInt = aVar.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == u.f2017a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b a2 = b.a((int) readShort, this.L);
                b a3 = b.a((int) readShort2, this.L);
                this.J[0].put("ImageLength", a2);
                this.J[0].put("ImageWidth", a3);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    private void c(C0043a aVar) throws IOException {
        a(aVar);
        b bVar = this.J[1].get("MakerNote");
        if (bVar != null) {
            C0043a aVar2 = new C0043a(bVar.f2016c);
            aVar2.a(this.L);
            byte[] bArr = new byte[m.length];
            aVar2.readFully(bArr);
            aVar2.a(0);
            byte[] bArr2 = new byte[n.length];
            aVar2.readFully(bArr2);
            if (Arrays.equals(bArr, m)) {
                aVar2.a(8);
            } else if (Arrays.equals(bArr2, n)) {
                aVar2.a(12);
            }
            b(aVar2, 6);
            b bVar2 = this.J[7].get("PreviewImageStart");
            b bVar3 = this.J[7].get("PreviewImageLength");
            if (!(bVar2 == null || bVar3 == null)) {
                this.J[5].put("JPEGInterchangeFormat", bVar2);
                this.J[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.J[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.a(this.L);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i3 = (iArr[3] - iArr[1]) + 1;
                    if (i2 < i3) {
                        int i4 = i2 + i3;
                        i3 = i4 - i3;
                        i2 = i4 - i3;
                    }
                    b a2 = b.a(i2, this.L);
                    b a3 = b.a(i3, this.L);
                    this.J[0].put("ImageWidth", a2);
                    this.J[0].put("ImageLength", a3);
                }
            }
        }
    }

    private void d(C0043a aVar) throws IOException {
        a(aVar);
        if (this.J[0].get("JpgFromRaw") != null) {
            a(aVar, this.V, 5);
        }
        b bVar = this.J[0].get("ISO");
        b bVar2 = this.J[1].get("PhotographicSensitivity");
        if (bVar != null && bVar2 == null) {
            this.J[1].put("PhotographicSensitivity", bVar);
        }
    }

    private void a(byte[] bArr, int i2) throws IOException {
        C0043a aVar = new C0043a(bArr);
        a(aVar, bArr.length);
        b(aVar, i2);
    }

    private void a() {
        String a2 = a("DateTimeOriginal");
        if (a2 != null && a("DateTime") == null) {
            this.J[0].put("DateTime", b.a(a2));
        }
        if (a("ImageWidth") == null) {
            this.J[0].put("ImageWidth", b.a(0, this.L));
        }
        if (a("ImageLength") == null) {
            this.J[0].put("ImageLength", b.a(0, this.L));
        }
        if (a("Orientation") == null) {
            this.J[0].put("Orientation", b.a(0, this.L));
        }
        if (a("LightSource") == null) {
            this.J[1].put("LightSource", b.a(0, this.L));
        }
    }

    private ByteOrder e(C0043a aVar) throws IOException {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void a(C0043a aVar, int i2) throws IOException {
        this.L = e(aVar);
        aVar.a(this.L);
        int readUnsignedShort = aVar.readUnsignedShort();
        int i3 = this.I;
        if (i3 == 7 || i3 == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i4 = readInt - 8;
            if (i4 > 0 && aVar.skipBytes(i4) != i4) {
                throw new IOException("Couldn't jump to first Ifd: " + i4);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(androidx.e.a.a.C0043a r24, int r25) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.util.Set<java.lang.Integer> r3 = r0.K
            int r4 = r1.f2011b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r1.f2011b
            int r3 = r3 + 2
            int r4 = r1.f2010a
            if (r3 <= r4) goto L_0x001a
            return
        L_0x001a:
            short r3 = r24.readShort()
            int r4 = r1.f2011b
            int r5 = r3 * 12
            int r4 = r4 + r5
            int r5 = r1.f2010a
            if (r4 > r5) goto L_0x0326
            if (r3 > 0) goto L_0x002b
            goto L_0x0326
        L_0x002b:
            r5 = 0
        L_0x002c:
            java.lang.String r9 = "ExifInterface"
            if (r5 >= r3) goto L_0x02b7
            int r10 = r24.readUnsignedShort()
            int r11 = r24.readUnsignedShort()
            int r12 = r24.readInt()
            int r13 = r24.a()
            long r13 = (long) r13
            r15 = 4
            long r13 = r13 + r15
            java.util.HashMap<java.lang.Integer, androidx.e.a.a$c>[] r17 = C
            r4 = r17[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            java.lang.Object r4 = r4.get(r8)
            androidx.e.a.a$c r4 = (androidx.e.a.a.c) r4
            r8 = 7
            if (r4 != 0) goto L_0x006b
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r6 = "Skip the tag entry since tag number is not defined: "
            r15.append(r6)
            r15.append(r10)
            java.lang.String r6 = r15.toString()
            android.util.Log.w(r9, r6)
            goto L_0x00e7
        L_0x006b:
            if (r11 <= 0) goto L_0x00d3
            int[] r6 = f2006f
            int r6 = r6.length
            if (r11 < r6) goto L_0x0073
            goto L_0x00d3
        L_0x0073:
            boolean r6 = r4.a(r11)
            if (r6 != 0) goto L_0x009c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since data format ("
            r6.append(r7)
            java.lang.String[] r7 = f2005e
            r7 = r7[r11]
            r6.append(r7)
            java.lang.String r7 = ") is unexpected for tag: "
            r6.append(r7)
            java.lang.String r7 = r4.f2018b
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r9, r6)
            goto L_0x00e7
        L_0x009c:
            if (r11 != r8) goto L_0x00a0
            int r11 = r4.f2019c
        L_0x00a0:
            long r6 = (long) r12
            int[] r15 = f2006f
            r15 = r15[r11]
            r16 = r9
            long r8 = (long) r15
            long r6 = r6 * r8
            r8 = 0
            int r15 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r15 < 0) goto L_0x00bc
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r15 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r15 <= 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            r8 = 1
            r9 = r16
            goto L_0x00ea
        L_0x00bc:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Skip the tag entry since the number of components is invalid: "
            r8.append(r9)
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            r9 = r16
            android.util.Log.w(r9, r8)
            goto L_0x00e9
        L_0x00d3:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since data format is invalid: "
            r6.append(r7)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r9, r6)
        L_0x00e7:
            r6 = 0
        L_0x00e9:
            r8 = 0
        L_0x00ea:
            if (r8 != 0) goto L_0x00f5
            r1.a((long) r13)
            r16 = r3
            r18 = r5
            goto L_0x02ae
        L_0x00f5:
            java.lang.String r8 = "Compression"
            r15 = 4
            int r18 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r18 <= 0) goto L_0x01a2
            int r15 = r24.readInt()
            r16 = r3
            int r3 = r0.I
            r18 = r5
            r5 = 7
            if (r3 != r5) goto L_0x0165
            java.lang.String r3 = r4.f2018b
            java.lang.String r5 = "MakerNote"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0117
            r0.S = r15
            goto L_0x0160
        L_0x0117:
            r3 = 6
            if (r2 != r3) goto L_0x0160
            java.lang.String r5 = r4.f2018b
            java.lang.String r3 = "ThumbnailImage"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0160
            r0.T = r15
            r0.U = r12
            java.nio.ByteOrder r3 = r0.L
            r5 = 6
            androidx.e.a.a$b r3 = androidx.e.a.a.b.a((int) r5, (java.nio.ByteOrder) r3)
            int r5 = r0.T
            r20 = r11
            r19 = r12
            long r11 = (long) r5
            java.nio.ByteOrder r5 = r0.L
            androidx.e.a.a$b r5 = androidx.e.a.a.b.a((long) r11, (java.nio.ByteOrder) r5)
            int r11 = r0.U
            long r11 = (long) r11
            java.nio.ByteOrder r2 = r0.L
            androidx.e.a.a$b r2 = androidx.e.a.a.b.a((long) r11, (java.nio.ByteOrder) r2)
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r11 = r0.J
            r12 = 4
            r11 = r11[r12]
            r11.put(r8, r3)
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r3 = r0.J
            r3 = r3[r12]
            java.lang.String r11 = "JPEGInterchangeFormat"
            r3.put(r11, r5)
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r3 = r0.J
            r3 = r3[r12]
            java.lang.String r5 = "JPEGInterchangeFormatLength"
            r3.put(r5, r2)
            goto L_0x0179
        L_0x0160:
            r20 = r11
            r19 = r12
            goto L_0x0179
        L_0x0165:
            r20 = r11
            r19 = r12
            r2 = 10
            if (r3 != r2) goto L_0x0179
            java.lang.String r2 = r4.f2018b
            java.lang.String r3 = "JpgFromRaw"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0179
            r0.V = r15
        L_0x0179:
            long r2 = (long) r15
            long r11 = r2 + r6
            int r5 = r1.f2010a
            r21 = r4
            long r4 = (long) r5
            int r22 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r22 > 0) goto L_0x0189
            r1.a((long) r2)
            goto L_0x01ac
        L_0x0189:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip the tag entry since data offset is invalid: "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r9, r2)
            r1.a((long) r13)
            goto L_0x02ae
        L_0x01a2:
            r16 = r3
            r21 = r4
            r18 = r5
            r20 = r11
            r19 = r12
        L_0x01ac:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = F
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r3 = 8
            r4 = 3
            if (r2 == 0) goto L_0x0245
            r5 = -1
            r11 = r20
            if (r11 == r4) goto L_0x01e2
            r4 = 4
            if (r11 == r4) goto L_0x01dd
            if (r11 == r3) goto L_0x01d8
            r3 = 9
            if (r11 == r3) goto L_0x01d3
            r3 = 13
            if (r11 == r3) goto L_0x01d3
        L_0x01d0:
            r3 = 0
            goto L_0x01e8
        L_0x01d3:
            int r3 = r24.readInt()
            goto L_0x01e6
        L_0x01d8:
            short r3 = r24.readShort()
            goto L_0x01e6
        L_0x01dd:
            long r5 = r24.b()
            goto L_0x01d0
        L_0x01e2:
            int r3 = r24.readUnsignedShort()
        L_0x01e6:
            long r5 = (long) r3
            goto L_0x01d0
        L_0x01e8:
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x022d
            int r3 = r1.f2010a
            long r3 = (long) r3
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x022d
            java.util.Set<java.lang.Integer> r3 = r0.K
            int r4 = (int) r5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x020b
            r1.a((long) r5)
            int r2 = r2.intValue()
            r0.b((androidx.e.a.a.C0043a) r1, (int) r2)
            goto L_0x0241
        L_0x020b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r5)
            java.lang.String r2 = ")"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.w(r9, r2)
            goto L_0x0241
        L_0x022d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r9, r2)
        L_0x0241:
            r1.a((long) r13)
            goto L_0x02ae
        L_0x0245:
            r11 = r20
            int r2 = (int) r6
            byte[] r2 = new byte[r2]
            r1.readFully(r2)
            androidx.e.a.a$b r5 = new androidx.e.a.a$b
            r6 = r19
            r5.<init>(r11, r6, r2)
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r2 = r0.J
            r2 = r2[r25]
            r6 = r21
            java.lang.String r7 = r6.f2018b
            r2.put(r7, r5)
            java.lang.String r2 = r6.f2018b
            java.lang.String r7 = "DNGVersion"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x026b
            r0.I = r4
        L_0x026b:
            java.lang.String r2 = r6.f2018b
            java.lang.String r4 = "Make"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x027f
            java.lang.String r2 = r6.f2018b
            java.lang.String r4 = "Model"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x028d
        L_0x027f:
            java.nio.ByteOrder r2 = r0.L
            java.lang.String r2 = r5.d(r2)
            java.lang.String r4 = "PENTAX"
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L_0x02a0
        L_0x028d:
            java.lang.String r2 = r6.f2018b
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x02a2
            java.nio.ByteOrder r2 = r0.L
            int r2 = r5.c(r2)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r4) goto L_0x02a2
        L_0x02a0:
            r0.I = r3
        L_0x02a2:
            int r2 = r24.a()
            long r2 = (long) r2
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x02ae
            r1.a((long) r13)
        L_0x02ae:
            int r5 = r18 + 1
            short r5 = (short) r5
            r2 = r25
            r3 = r16
            goto L_0x002c
        L_0x02b7:
            int r2 = r24.a()
            r3 = 4
            int r2 = r2 + r3
            int r3 = r1.f2010a
            if (r2 > r3) goto L_0x0326
            int r2 = r24.readInt()
            long r3 = (long) r2
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0312
            int r5 = r1.f2010a
            if (r2 >= r5) goto L_0x0312
            java.util.Set<java.lang.Integer> r5 = r0.K
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x02fd
            r1.a((long) r3)
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r2 = r0.J
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x02ee
            r0.b((androidx.e.a.a.C0043a) r1, (int) r3)
            goto L_0x0326
        L_0x02ee:
            java.util.HashMap<java.lang.String, androidx.e.a.a$b>[] r2 = r0.J
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0326
            r0.b((androidx.e.a.a.C0043a) r1, (int) r3)
            goto L_0x0326
        L_0x02fd:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r9, r1)
            goto L_0x0326
        L_0x0312:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r9, r1)
        L_0x0326:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.e.a.a.b(androidx.e.a.a$a, int):void");
    }

    private void c(C0043a aVar, int i2) throws IOException {
        b bVar = this.J[i2].get("ImageLength");
        b bVar2 = this.J[i2].get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            b bVar3 = this.J[i2].get("JPEGInterchangeFormat");
            if (bVar3 != null) {
                a(aVar, bVar3.c(this.L), i2);
            }
        }
    }

    private void f(C0043a aVar) throws IOException {
        HashMap<String, b> hashMap = this.J[4];
        b bVar = hashMap.get("Compression");
        if (bVar != null) {
            this.Q = bVar.c(this.L);
            int i2 = this.Q;
            if (i2 != 1) {
                if (i2 == 6) {
                    a(aVar, (HashMap) hashMap);
                    return;
                } else if (i2 != 7) {
                    return;
                }
            }
            if (a((HashMap) hashMap)) {
                b(aVar, (HashMap) hashMap);
                return;
            }
            return;
        }
        this.Q = 6;
        a(aVar, (HashMap) hashMap);
    }

    private void a(C0043a aVar, HashMap hashMap) throws IOException {
        int i2;
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int c2 = bVar.c(this.L);
            int min = Math.min(bVar2.c(this.L), aVar.available() - c2);
            int i3 = this.I;
            if (i3 == 4 || i3 == 9 || i3 == 10) {
                i2 = this.R;
            } else {
                if (i3 == 7) {
                    i2 = this.S;
                }
                if (c2 > 0 && min > 0) {
                    this.M = true;
                    this.N = c2;
                    this.O = min;
                    if (this.G == null && this.H == null) {
                        byte[] bArr = new byte[min];
                        aVar.a((long) c2);
                        aVar.readFully(bArr);
                        this.P = bArr;
                        return;
                    }
                    return;
                }
            }
            c2 += i2;
            if (c2 > 0) {
            }
        }
    }

    private void b(C0043a aVar, HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("StripOffsets");
        b bVar2 = (b) hashMap.get("StripByteCounts");
        if (bVar != null && bVar2 != null) {
            long[] a2 = a(bVar.a(this.L));
            long[] a3 = a(bVar2.a(this.L));
            if (a2 == null) {
                Log.w("ExifInterface", "stripOffsets should not be null.");
            } else if (a3 == null) {
                Log.w("ExifInterface", "stripByteCounts should not be null.");
            } else {
                long j2 = 0;
                for (long j3 : a3) {
                    j2 += j3;
                }
                byte[] bArr = new byte[((int) j2)];
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < a2.length; i4++) {
                    int i5 = (int) a2[i4];
                    int i6 = (int) a3[i4];
                    int i7 = i5 - i2;
                    if (i7 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                    }
                    aVar.a((long) i7);
                    int i8 = i2 + i7;
                    byte[] bArr2 = new byte[i6];
                    aVar.read(bArr2);
                    i2 = i8 + i6;
                    System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
                    i3 += bArr2.length;
                }
                this.M = true;
                this.P = bArr;
                this.O = bArr.length;
            }
        }
    }

    private boolean a(HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("BitsPerSample");
        if (bVar == null) {
            return false;
        }
        int[] iArr = (int[]) bVar.a(this.L);
        if (Arrays.equals(f2001a, iArr)) {
            return true;
        }
        if (this.I != 3) {
            return false;
        }
        b bVar2 = (b) hashMap.get("PhotometricInterpretation");
        if (bVar2 == null) {
            return false;
        }
        int c2 = bVar2.c(this.L);
        if ((c2 != 1 || !Arrays.equals(iArr, f2003c)) && (c2 != 6 || !Arrays.equals(iArr, f2001a))) {
            return false;
        }
        return true;
    }

    private boolean b(HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.c(this.L) <= 512 && bVar2.c(this.L) <= 512;
    }

    private void b(InputStream inputStream) throws IOException {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b bVar = this.J[1].get("PixelXDimension");
        b bVar2 = this.J[1].get("PixelYDimension");
        if (!(bVar == null || bVar2 == null)) {
            this.J[0].put("ImageWidth", bVar);
            this.J[0].put("ImageLength", bVar2);
        }
        if (this.J[4].isEmpty() && b((HashMap) this.J[5])) {
            HashMap<String, b>[] hashMapArr = this.J;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!b((HashMap) this.J[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
    }

    private void d(C0043a aVar, int i2) throws IOException {
        b bVar;
        b bVar2;
        b bVar3 = this.J[i2].get("DefaultCropSize");
        b bVar4 = this.J[i2].get("SensorTopBorder");
        b bVar5 = this.J[i2].get("SensorLeftBorder");
        b bVar6 = this.J[i2].get("SensorBottomBorder");
        b bVar7 = this.J[i2].get("SensorRightBorder");
        if (bVar3 != null) {
            if (bVar3.f2014a == 5) {
                d[] dVarArr = (d[]) bVar3.a(this.L);
                if (dVarArr == null || dVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                    return;
                }
                bVar2 = b.a(dVarArr[0], this.L);
                bVar = b.a(dVarArr[1], this.L);
            } else {
                int[] iArr = (int[]) bVar3.a(this.L);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                bVar2 = b.a(iArr[0], this.L);
                bVar = b.a(iArr[1], this.L);
            }
            this.J[i2].put("ImageWidth", bVar2);
            this.J[i2].put("ImageLength", bVar);
        } else if (bVar4 == null || bVar5 == null || bVar6 == null || bVar7 == null) {
            c(aVar, i2);
        } else {
            int c2 = bVar4.c(this.L);
            int c3 = bVar6.c(this.L);
            int c4 = bVar7.c(this.L);
            int c5 = bVar5.c(this.L);
            if (c3 > c2 && c4 > c5) {
                b a2 = b.a(c3 - c2, this.L);
                b a3 = b.a(c4 - c5, this.L);
                this.J[i2].put("ImageLength", a2);
                this.J[i2].put("ImageWidth", a3);
            }
        }
    }

    /* renamed from: androidx.e.a.a$a  reason: collision with other inner class name */
    private static class C0043a extends InputStream implements DataInput {

        /* renamed from: c  reason: collision with root package name */
        private static final ByteOrder f2008c = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: d  reason: collision with root package name */
        private static final ByteOrder f2009d = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        final int f2010a;

        /* renamed from: b  reason: collision with root package name */
        int f2011b;

        /* renamed from: e  reason: collision with root package name */
        private DataInputStream f2012e;

        /* renamed from: f  reason: collision with root package name */
        private ByteOrder f2013f;

        public C0043a(InputStream inputStream) throws IOException {
            this.f2013f = ByteOrder.BIG_ENDIAN;
            this.f2012e = new DataInputStream(inputStream);
            this.f2010a = this.f2012e.available();
            this.f2011b = 0;
            this.f2012e.mark(this.f2010a);
        }

        public C0043a(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }

        public void a(ByteOrder byteOrder) {
            this.f2013f = byteOrder;
        }

        public void a(long j) throws IOException {
            int i = this.f2011b;
            if (((long) i) > j) {
                this.f2011b = 0;
                this.f2012e.reset();
                this.f2012e.mark(this.f2010a);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int a() {
            return this.f2011b;
        }

        public int available() throws IOException {
            return this.f2012e.available();
        }

        public int read() throws IOException {
            this.f2011b++;
            return this.f2012e.read();
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.f2012e.read(bArr, i, i2);
            this.f2011b += read;
            return read;
        }

        public int readUnsignedByte() throws IOException {
            this.f2011b++;
            return this.f2012e.readUnsignedByte();
        }

        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public boolean readBoolean() throws IOException {
            this.f2011b++;
            return this.f2012e.readBoolean();
        }

        public char readChar() throws IOException {
            this.f2011b += 2;
            return this.f2012e.readChar();
        }

        public String readUTF() throws IOException {
            this.f2011b += 2;
            return this.f2012e.readUTF();
        }

        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.f2011b += i2;
            if (this.f2011b > this.f2010a) {
                throw new EOFException();
            } else if (this.f2012e.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public void readFully(byte[] bArr) throws IOException {
            this.f2011b += bArr.length;
            if (this.f2011b > this.f2010a) {
                throw new EOFException();
            } else if (this.f2012e.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public byte readByte() throws IOException {
            this.f2011b++;
            if (this.f2011b <= this.f2010a) {
                int read = this.f2012e.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.f2011b += 2;
            if (this.f2011b <= this.f2010a) {
                int read = this.f2012e.read();
                int read2 = this.f2012e.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f2013f;
                    if (byteOrder == f2008c) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f2009d) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f2013f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public int readInt() throws IOException {
            this.f2011b += 4;
            if (this.f2011b <= this.f2010a) {
                int read = this.f2012e.read();
                int read2 = this.f2012e.read();
                int read3 = this.f2012e.read();
                int read4 = this.f2012e.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f2013f;
                    if (byteOrder == f2008c) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f2009d) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f2013f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.f2010a - this.f2011b);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.f2012e.skipBytes(min - i2);
            }
            this.f2011b += i2;
            return i2;
        }

        public int readUnsignedShort() throws IOException {
            this.f2011b += 2;
            if (this.f2011b <= this.f2010a) {
                int read = this.f2012e.read();
                int read2 = this.f2012e.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f2013f;
                    if (byteOrder == f2008c) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f2009d) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f2013f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long b() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public long readLong() throws IOException {
            this.f2011b += 8;
            if (this.f2011b <= this.f2010a) {
                int read = this.f2012e.read();
                int read2 = this.f2012e.read();
                int read3 = this.f2012e.read();
                int read4 = this.f2012e.read();
                int read5 = this.f2012e.read();
                int read6 = this.f2012e.read();
                int read7 = this.f2012e.read();
                int read8 = this.f2012e.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f2013f;
                    if (byteOrder == f2008c) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    int i = read2;
                    if (byteOrder == f2009d) {
                        return (((long) read) << 56) + (((long) i) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.f2013f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }
    }

    private void a(int i2, int i3) throws IOException {
        if (!this.J[i2].isEmpty() && !this.J[i3].isEmpty()) {
            b bVar = this.J[i2].get("ImageLength");
            b bVar2 = this.J[i2].get("ImageWidth");
            b bVar3 = this.J[i3].get("ImageLength");
            b bVar4 = this.J[i3].get("ImageWidth");
            if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null) {
                int c2 = bVar.c(this.L);
                int c3 = bVar2.c(this.L);
                int c4 = bVar3.c(this.L);
                int c5 = bVar4.c(this.L);
                if (c2 < c4 && c3 < c5) {
                    HashMap<String, b>[] hashMapArr = this.J;
                    HashMap<String, b> hashMap = hashMapArr[i2];
                    hashMapArr[i2] = hashMapArr[i3];
                    hashMapArr[i3] = hashMap;
                }
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
