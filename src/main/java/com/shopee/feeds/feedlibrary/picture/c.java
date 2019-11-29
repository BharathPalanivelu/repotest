package com.shopee.feeds.feedlibrary.picture;

import android.content.Context;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;

public final class c {
    public static int a() {
        return 0;
    }

    public static int b() {
        return 3;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1930021710: goto L_0x0163;
                case -1664118616: goto L_0x0158;
                case -1662382439: goto L_0x014d;
                case -1662095187: goto L_0x0142;
                case -1488379748: goto L_0x0138;
                case -1488003120: goto L_0x012e;
                case -1487394660: goto L_0x0124;
                case -1487018032: goto L_0x011a;
                case -1079884372: goto L_0x010f;
                case -879299344: goto L_0x0104;
                case -879290539: goto L_0x00f9;
                case -879272239: goto L_0x00ee;
                case -879267568: goto L_0x00e3;
                case -879258763: goto L_0x00d8;
                case -586683234: goto L_0x00cc;
                case -107252314: goto L_0x00c0;
                case -48069494: goto L_0x00b4;
                case 5703450: goto L_0x00a8;
                case 187078282: goto L_0x009c;
                case 187078669: goto L_0x0090;
                case 187090232: goto L_0x0084;
                case 187099443: goto L_0x0078;
                case 201674286: goto L_0x006c;
                case 1331792072: goto L_0x0060;
                case 1331836736: goto L_0x0054;
                case 1331848029: goto L_0x0048;
                case 1338492737: goto L_0x003c;
                case 1503095341: goto L_0x0030;
                case 1504787571: goto L_0x0024;
                case 1504831518: goto L_0x0018;
                case 2039520277: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x016e
        L_0x000c:
            java.lang.String r0 = "video/x-matroska"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 17
            goto L_0x016f
        L_0x0018:
            java.lang.String r0 = "audio/mpeg"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 21
            goto L_0x016f
        L_0x0024:
            java.lang.String r0 = "audio/lamr"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 29
            goto L_0x016f
        L_0x0030:
            java.lang.String r0 = "audio/3gpp"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 30
            goto L_0x016f
        L_0x003c:
            java.lang.String r0 = "audio/quicktime"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 28
            goto L_0x016f
        L_0x0048:
            java.lang.String r0 = "video/mp4"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 14
            goto L_0x016f
        L_0x0054:
            java.lang.String r0 = "video/avi"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 13
            goto L_0x016f
        L_0x0060:
            java.lang.String r0 = "video/3gp"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 10
            goto L_0x016f
        L_0x006c:
            java.lang.String r0 = "imagex-ms-bmp"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 9
            goto L_0x016f
        L_0x0078:
            java.lang.String r0 = "audio/wav"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 25
            goto L_0x016f
        L_0x0084:
            java.lang.String r0 = "audio/mp4"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 27
            goto L_0x016f
        L_0x0090:
            java.lang.String r0 = "audio/amr"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 24
            goto L_0x016f
        L_0x009c:
            java.lang.String r0 = "audio/aac"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 26
            goto L_0x016f
        L_0x00a8:
            java.lang.String r0 = "video/mp2ts"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 20
            goto L_0x016f
        L_0x00b4:
            java.lang.String r0 = "video/3gpp2"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 12
            goto L_0x016f
        L_0x00c0:
            java.lang.String r0 = "video/quicktime"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 15
            goto L_0x016f
        L_0x00cc:
            java.lang.String r0 = "audio/x-wav"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 23
            goto L_0x016f
        L_0x00d8:
            java.lang.String r0 = "image/png"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 0
            goto L_0x016f
        L_0x00e3:
            java.lang.String r0 = "image/gif"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 6
            goto L_0x016f
        L_0x00ee:
            java.lang.String r0 = "image/bmp"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 7
            goto L_0x016f
        L_0x00f9:
            java.lang.String r0 = "image/PNG"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 1
            goto L_0x016f
        L_0x0104:
            java.lang.String r0 = "image/GIF"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 8
            goto L_0x016f
        L_0x010f:
            java.lang.String r0 = "video/x-msvideo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 16
            goto L_0x016f
        L_0x011a:
            java.lang.String r0 = "image/webp"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 4
            goto L_0x016f
        L_0x0124:
            java.lang.String r0 = "image/jpeg"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 2
            goto L_0x016f
        L_0x012e:
            java.lang.String r0 = "image/WEBP"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 5
            goto L_0x016f
        L_0x0138:
            java.lang.String r0 = "image/JPEG"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 3
            goto L_0x016f
        L_0x0142:
            java.lang.String r0 = "video/webm"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 19
            goto L_0x016f
        L_0x014d:
            java.lang.String r0 = "video/mpeg"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 18
            goto L_0x016f
        L_0x0158:
            java.lang.String r0 = "video/3gpp"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 11
            goto L_0x016f
        L_0x0163:
            java.lang.String r0 = "audio/x-ms-wma"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x016e
            r4 = 22
            goto L_0x016f
        L_0x016e:
            r4 = -1
        L_0x016f:
            switch(r4) {
                case 0: goto L_0x0175;
                case 1: goto L_0x0175;
                case 2: goto L_0x0175;
                case 3: goto L_0x0175;
                case 4: goto L_0x0175;
                case 5: goto L_0x0175;
                case 6: goto L_0x0175;
                case 7: goto L_0x0175;
                case 8: goto L_0x0175;
                case 9: goto L_0x0175;
                case 10: goto L_0x0174;
                case 11: goto L_0x0174;
                case 12: goto L_0x0174;
                case 13: goto L_0x0174;
                case 14: goto L_0x0174;
                case 15: goto L_0x0174;
                case 16: goto L_0x0174;
                case 17: goto L_0x0174;
                case 18: goto L_0x0174;
                case 19: goto L_0x0174;
                case 20: goto L_0x0174;
                case 21: goto L_0x0173;
                case 22: goto L_0x0173;
                case 23: goto L_0x0173;
                case 24: goto L_0x0173;
                case 25: goto L_0x0173;
                case 26: goto L_0x0173;
                case 27: goto L_0x0173;
                case 28: goto L_0x0173;
                case 29: goto L_0x0173;
                case 30: goto L_0x0173;
                default: goto L_0x0172;
            }
        L_0x0172:
            return r3
        L_0x0173:
            return r1
        L_0x0174:
            return r2
        L_0x0175:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.picture.c.a(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -879299344(0xffffffffcb96f4f0, float:-1.9786208E7)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = -879267568(0xffffffffcb977110, float:-1.984976E7)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "image/gif"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0025
            r4 = 0
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "image/GIF"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0025
            r4 = 1
            goto L_0x0026
        L_0x0025:
            r4 = -1
        L_0x0026:
            if (r4 == 0) goto L_0x002b
            if (r4 == r3) goto L_0x002b
            return r2
        L_0x002b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.picture.c.b(java.lang.String):boolean");
    }

    public static boolean a(LocalMedia localMedia) {
        if (localMedia == null) {
            return false;
        }
        if (localMedia.e() > localMedia.d() * 3) {
            return true;
        }
        return false;
    }

    public static String a(Context context, int i) {
        context.getApplicationContext();
        if (i == 1) {
            return b.e(c.g.feeds_picture_error);
        }
        if (i == 2) {
            return b.e(c.g.feeds_picture_video_error);
        }
        if (i != 3) {
            return b.e(c.g.feeds_picture_error);
        }
        return b.e(c.g.feeds_picture_audio_error);
    }
}
