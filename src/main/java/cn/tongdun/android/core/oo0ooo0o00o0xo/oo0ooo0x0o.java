package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0;
import cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class oo0ooo0x0o {
    private static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("46376174227c23712b643a6a7f306e39672c7f2b7e3c2946184f115a095d084a3c663369356b225c1f", 2);
    static final String[] o00xxox0x0xoox = {o00xxox0x0xoox("704f504a515248", 109), o00xxox0x0xoox("627d457c", 83), o00xxox0x0xoox("604f464d", 119), o00xxox0x0xoox("704e4c49", 111), o00xxox0x0xoox("66714a7d", 79), o00xxox0x0xoox("602f5724474b", 5), o00xxox0x0xoox("602e5725473b", 4), o00xxox0x0xoox("141d1b1b1b", 109), o00xxox0x0xoox("6d4e5f5a4e", 108), o00xxox0x0xoox("6d524e575f", 112), o00xxox0x0xoox("6d7f4b6e", 93), o00xxox0x0xoox("6c2d4826", 25), o00xxox0x0xoox("603c5737472a", 22), o00xxox0x0xoox("69545d", 117), o00xxox0x0xoox("60615f634b", 85), o00xxox0x0xoox("6d354b245a", 23), o00xxox0x0xoox("627559", 88), o00xxox0x0xoox("71584f545f53565f", 113), o00xxox0x0xoox("6c3952345d", 30)};
    public static final String[] oo0ooo0o00o0xo = {o00xxox0x0xoox("425e767a4e7d4f76695a734169", 101), o00xxox0x0xoox("422e7609501e410e50155b124c2961", 21), o00xxox0x0xoox("42217619531e584a27713f7e3869", 26), o00xxox0x0xoox("42197629573a48304e1c63", 34), o00xxox0x0xoox("423576174f1145176d3b653e47055f0a581d", 14), o00xxox0x0xoox("420f76284c2c721a65016d0c4f375738502f", 52), o00xxox0x0xoox("422276185d095e1143086b24713f6b3960095a15", 25), o00xxox0x0xoox("425276685d795e6143786747725061457a5846774a7f", 105), o00xxox0x0xoox("422b76115d005e184301673e7229613c7a21", 16), o00xxox0x0xoox("4228760f4c0b6e347b236836732b4f04430c", 19), o00xxox0x0xoox("424a766e4e694f627e4f775a", 113), o00xxox0x0xoox("423d76075d165e0e43177c3a752f", 6), o00xxox0x0xoox("42447673507a505a735671436c456d", 127), o00xxox0x0xoox("420d76375d3b533459394422432b670d6e0d4b2a4323", 54), o00xxox0x0xoox("420c76395b39741f7d1f58385031", 55)};
    private static final String x0000xo0x0oooooo0 = o00xxox0x0xoox("445b6b4d764b7b01211028193d013a002d574e49744d4d7c4475516d566c41586d5762516046", 109);

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00f8, code lost:
        if (r9 != null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0104, code lost:
        if (r9 != null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0106, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0109, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static cn.tongdun.android.core.oo0ooo0o00o0xo.oo00ox0xx0o0 o00xxox0x0xoox(int r9, android.content.Context r10) {
        /*
            java.lang.String r0 = "46586242734969077c0727162e1f3b073c062b50774a734e74467d"
            r1 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r0, (int) r1)
            android.net.Uri r2 = android.net.Uri.parse(r0)
            android.content.ContentResolver r1 = r10.getContentResolver()
            r10 = 6
            r0 = 0
            java.lang.String[] r3 = new java.lang.String[r10]     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            java.lang.String r10 = "7a6d52"
            r4 = 98
            java.lang.String r10 = o00xxox0x0xoox((java.lang.String) r10, (int) r4)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r7 = 0
            r3[r7] = r10     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            java.lang.String r10 = "56247716411b"
            r4 = 7
            java.lang.String r10 = o00xxox0x0xoox((java.lang.String) r10, (int) r4)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r8 = 1
            r3[r8] = r10     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r10 = 2
            java.lang.String r4 = "4c37690b5f06"
            r5 = 4
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r3[r10] = r4     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r10 = 3
            java.lang.String r4 = "464a704a6b467c6b4d64416c"
            r6 = 113(0x71, float:1.58E-43)
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r6)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r3[r10] = r4     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            java.lang.String r10 = "48746d"
            r4 = 67
            java.lang.String r10 = o00xxox0x0xoox((java.lang.String) r10, (int) r4)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r3[r5] = r10     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r10 = 5
            java.lang.String r4 = "481c60"
            r5 = 38
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r3[r10] = r4     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            java.lang.String r10 = "561c772e4123053e1821"
            r4 = 63
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r10, (int) r4)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            java.lang.String[] r5 = new java.lang.String[r8]     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r5[r7] = r9     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            r6 = 0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0103, all -> 0x00fb }
            if (r9 == 0) goto L_0x00f8
            boolean r10 = r9.moveToFirst()     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            if (r10 == 0) goto L_0x00f8
            java.lang.String r10 = "7a7152"
            r1 = 126(0x7e, float:1.77E-43)
            java.lang.String r10 = o00xxox0x0xoox((java.lang.String) r10, (int) r1)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            int r10 = r9.getColumnIndex(r10)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            int r10 = r9.getInt(r10)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r1 = "4c4569795f74"
            r2 = 118(0x76, float:1.65E-43)
            java.lang.String r1 = o00xxox0x0xoox((java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            int r1 = r9.getColumnIndex(r1)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r2 = "465b705b6b577c7a4d75417d"
            r3 = 96
            java.lang.String r2 = o00xxox0x0xoox((java.lang.String) r2, (int) r3)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            int r2 = r9.getColumnIndex(r2)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r3 = "48656d"
            r4 = 82
            java.lang.String r3 = o00xxox0x0xoox((java.lang.String) r3, (int) r4)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            int r3 = r9.getColumnIndex(r3)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            int r3 = r9.getInt(r3)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r4 = "483160"
            r5 = 11
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            int r4 = r9.getColumnIndex(r4)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            int r4 = r9.getInt(r4)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            r5.<init>()     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            r5.append(r3)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r3 = "00252773"
            r6 = 9
            java.lang.String r3 = o00xxox0x0xoox((java.lang.String) r3, (int) r6)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            r6[r7] = r4     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r3 = java.lang.String.format(r3, r6)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            r5.append(r3)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            if (r10 <= 0) goto L_0x00f8
            cn.tongdun.android.core.oo0ooo0o00o0xo.oo00ox0xx0o0 r4 = new cn.tongdun.android.core.oo0ooo0o00o0xo.oo00ox0xx0o0     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            r4.<init>(r10, r1, r2, r3)     // Catch:{ Exception -> 0x00f6, all -> 0x00f4 }
            if (r9 == 0) goto L_0x00f3
            r9.close()
        L_0x00f3:
            return r4
        L_0x00f4:
            r10 = move-exception
            goto L_0x00fd
        L_0x00f6:
            goto L_0x0104
        L_0x00f8:
            if (r9 == 0) goto L_0x0109
            goto L_0x0106
        L_0x00fb:
            r10 = move-exception
            r9 = r0
        L_0x00fd:
            if (r9 == 0) goto L_0x0102
            r9.close()
        L_0x0102:
            throw r10
        L_0x0103:
            r9 = r0
        L_0x0104:
            if (r9 == 0) goto L_0x0109
        L_0x0106:
            r9.close()
        L_0x0109:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.oo0ooo0o00o0xo.oo0ooo0x0o.o00xxox0x0xoox(int, android.content.Context):cn.tongdun.android.core.oo0ooo0o00o0xo.oo00ox0xx0o0");
    }

    public static Map o00xxox0x0xoox(Context context, TelephonyManager telephonyManager) {
        Map hashMap = new HashMap();
        char c2 = 0;
        try {
            Class<?> cls = Class.forName(o00xx0xx0ooooo0xx00);
            hashMap = o00xxox0x0xoox(context, telephonyManager, cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}), cls);
            if (hashMap.size() > 0) {
                c2 = 1;
            }
        } catch (Exception unused) {
        }
        if (c2 == 0 && xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(23) && telephonyManager.getPhoneCount() == 2) {
            hashMap = o00xxox0x0xoox(context, telephonyManager, telephonyManager, telephonyManager.getClass());
            if (hashMap.size() > 0) {
                c2 = 2;
            }
        }
        if (c2 == 0) {
            try {
                Class<?> cls2 = Class.forName(x0000xo0x0oooooo0);
                Object systemService = context.getSystemService(o00xxox0x0xoox("553877397c034e1d5419", 25));
                if (systemService == null) {
                    systemService = o00xxox0x0xoox((Object) null, cls2, o00xxox0x0xoox("422c761c571f500b4913", 23));
                }
                hashMap = o00xxox0x0xoox(context, telephonyManager, systemService, cls2);
                if (hashMap.size() > 0) {
                    c2 = 3;
                }
            } catch (ClassNotFoundException unused2) {
            }
        }
        return c2 == 0 ? oo0ooo0o00o0xo(context, telephonyManager) : hashMap;
    }

    public static Map oo0ooo0o00o0xo(Context context, TelephonyManager telephonyManager) {
        String str;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        oo00ox0xx0o0 o00xxox0x0xoox2 = o00xxox0x0xoox(0, context);
        if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.READ_PHONE_STATE")) {
            hashMap.put(oo0ooo0o00o0xo[1], telephonyManager.getSubscriberId());
            hashMap.put(oo0ooo0o00o0xo[2], telephonyManager.getLine1Number());
            hashMap.put(oo0ooo0o00o0xo[3], telephonyManager.getDeviceId());
            hashMap.put(oo0ooo0o00o0xo[4], telephonyManager.getVoiceMailNumber());
            if (o00xxox0x0xoox2 != null) {
                str3 = o00xxox0x0xoox2.oo0ooo0o00o0xo();
            } else {
                str3 = telephonyManager.getSimSerialNumber();
            }
            hashMap.put(oo0ooo0o00o0xo[5], str3);
        }
        hashMap.put(oo0ooo0o00o0xo[6], telephonyManager.getNetworkCountryIso());
        if (o00xxox0x0xoox2 != null) {
            str = o00xxox0x0xoox2.o00xx0xx0ooooo0xx00();
            str2 = o00xxox0x0xoox2.x0000xo0x0oooooo0();
        } else {
            str = telephonyManager.getNetworkOperatorName();
            str2 = telephonyManager.getNetworkOperator();
        }
        hashMap.put(oo0ooo0o00o0xo[7], str);
        hashMap.put(oo0ooo0o00o0xo[8], str2);
        String str4 = "";
        hashMap.put(oo0ooo0o00o0xo[9], telephonyManager.getSimState() == 5 ? telephonyManager.getSimOperatorName() : str4);
        int phoneType = telephonyManager.getPhoneType();
        String str5 = oo0ooo0o00o0xo[10];
        hashMap.put(str5, phoneType + str4);
        hashMap.put(oo0ooo0o00o0xo[11], String.valueOf(telephonyManager.getNetworkType()));
        if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION")) {
            oo0ooo0o00o0xo oo0ooo0o00o0xo2 = new oo0ooo0o00o0xo();
            try {
                if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(17)) {
                    o00xxox0x0xoox(telephonyManager.getCellLocation(), oo0ooo0o00o0xo2);
                    o00xxox0x0xoox(telephonyManager.getNeighboringCellInfo(), oo0ooo0o00o0xo2);
                } else {
                    List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                    if (allCellInfo != null) {
                        oo0ooo0o00o0xo((List) allCellInfo, oo0ooo0o00o0xo2);
                    }
                }
            } catch (Throwable unused) {
            }
            str4 = oo0ooo0o00o0xo2.o00xxox0x0xoox();
        }
        hashMap.put(oo0ooo0o00o0xo[12], str4);
        return hashMap;
    }

    /* JADX WARNING: type inference failed for: r21v0, types: [java.lang.Object] */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:87|88|89|90|91|92|93|94|(2:99|(3:101|103|(1:110)(1:109)))|102|103|(1:105)|110) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x042f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x0469 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x04e2  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Map o00xxox0x0xoox(android.content.Context r19, android.telephony.TelephonyManager r20, java.lang.Object r21, java.lang.Class r22) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = r22.getName()
            java.lang.String r5 = o00xx0xx0ooooo0xx00
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0027
            r4 = 23
            boolean r4 = cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(r4)
            if (r4 == 0) goto L_0x0027
            java.lang.Class r4 = r20.getClass()
            r5 = r4
            r4 = r20
            goto L_0x0029
        L_0x0027:
            r4 = r1
            r5 = r2
        L_0x0029:
            r6 = 0
            cn.tongdun.android.core.oo0ooo0o00o0xo.oo00ox0xx0o0 r7 = o00xxox0x0xoox((int) r6, (android.content.Context) r0)
            r8 = 1
            cn.tongdun.android.core.oo0ooo0o00o0xo.oo00ox0xx0o0 r9 = o00xxox0x0xoox((int) r8, (android.content.Context) r0)
            if (r7 == 0) goto L_0x003a
            int r10 = r7.o00xxox0x0xoox()
            goto L_0x003b
        L_0x003a:
            r10 = 0
        L_0x003b:
            if (r9 == 0) goto L_0x0042
            int r11 = r9.o00xxox0x0xoox()
            goto L_0x0043
        L_0x0042:
            r11 = 1
        L_0x0043:
            java.lang.String r12 = "android.permission.READ_PHONE_STATE"
            boolean r12 = cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0.o00xxox0x0xoox((android.content.Context) r0, (java.lang.String) r12)
            java.lang.String r15 = "08"
            if (r12 == 0) goto L_0x020a
            java.lang.String[] r12 = oo0ooo0o00o0xo
            r12 = r12[r8]
            java.lang.Class[] r13 = new java.lang.Class[r8]
            java.lang.Class r16 = java.lang.Integer.TYPE
            r13[r6] = r16
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r10)
            r14[r6] = r17
            java.lang.String r12 = o00xxox0x0xoox(r4, r5, r12, r13, r14)
            java.lang.String[] r13 = oo0ooo0o00o0xo
            r13 = r13[r8]
            java.lang.Class[] r14 = new java.lang.Class[r8]
            java.lang.Class r17 = java.lang.Integer.TYPE
            r14[r6] = r17
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r11)
            r0[r6] = r17
            java.lang.String r0 = o00xxox0x0xoox(r4, r5, r13, r14, r0)
            r13 = 25
            java.lang.String r13 = o00xxox0x0xoox((java.lang.String) r15, (int) r13)
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x0095
            r13 = 125(0x7d, float:1.75E-43)
            java.lang.String r13 = o00xxox0x0xoox((java.lang.String) r15, (int) r13)
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0095
            java.lang.String r12 = r20.getSubscriberId()
        L_0x0095:
            java.lang.String[] r13 = oo0ooo0o00o0xo
            r13 = r13[r8]
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r12, (java.lang.String) r0)
            r3.put(r13, r0)
            java.lang.String[] r0 = oo0ooo0o00o0xo
            r12 = 2
            r0 = r0[r12]
            java.lang.Class[] r13 = new java.lang.Class[r8]
            java.lang.Class r14 = java.lang.Integer.TYPE
            r13[r6] = r14
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Integer r16 = java.lang.Integer.valueOf(r10)
            r14[r6] = r16
            java.lang.String r0 = o00xxox0x0xoox(r4, r5, r0, r13, r14)
            java.lang.String[] r13 = oo0ooo0o00o0xo
            r13 = r13[r12]
            java.lang.Class[] r12 = new java.lang.Class[r8]
            java.lang.Class r14 = java.lang.Integer.TYPE
            r12[r6] = r14
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r11)
            r14[r6] = r17
            java.lang.String r12 = o00xxox0x0xoox(r4, r5, r13, r12, r14)
            r13 = 120(0x78, float:1.68E-43)
            java.lang.String r13 = o00xxox0x0xoox((java.lang.String) r15, (int) r13)
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00e9
            r13 = 16
            java.lang.String r13 = o00xxox0x0xoox((java.lang.String) r15, (int) r13)
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x00e9
            java.lang.String r0 = r20.getLine1Number()
        L_0x00e9:
            java.lang.String[] r13 = oo0ooo0o00o0xo
            r14 = 2
            r13 = r13[r14]
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r0, (java.lang.String) r12)
            r3.put(r13, r0)
            java.lang.String[] r0 = oo0ooo0o00o0xo
            r12 = 3
            r0 = r0[r12]
            java.lang.Class[] r13 = new java.lang.Class[r8]
            java.lang.Class r14 = java.lang.Integer.TYPE
            r13[r6] = r14
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r6)
            r14[r6] = r17
            java.lang.String r0 = o00xxox0x0xoox(r4, r5, r0, r13, r14)
            java.lang.String[] r13 = oo0ooo0o00o0xo
            r13 = r13[r12]
            java.lang.Class[] r14 = new java.lang.Class[r8]
            java.lang.Class r17 = java.lang.Integer.TYPE
            r14[r6] = r17
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Integer r18 = java.lang.Integer.valueOf(r8)
            r12[r6] = r18
            java.lang.String r12 = o00xxox0x0xoox(r4, r5, r13, r14, r12)
            r13 = 18
            java.lang.String r14 = o00xxox0x0xoox((java.lang.String) r15, (int) r13)
            boolean r13 = r14.equals(r0)
            if (r13 == 0) goto L_0x013e
            r13 = 98
            java.lang.String r13 = o00xxox0x0xoox((java.lang.String) r15, (int) r13)
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x013e
            java.lang.String r0 = r20.getDeviceId()
        L_0x013e:
            java.lang.String[] r13 = oo0ooo0o00o0xo
            r14 = 3
            r13 = r13[r14]
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r0, (java.lang.String) r12)
            r3.put(r13, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r12 = 27
            r13 = 4
            if (r0 >= r12) goto L_0x01a6
            java.lang.String[] r0 = oo0ooo0o00o0xo
            r0 = r0[r13]
            java.lang.Class[] r12 = new java.lang.Class[r8]
            java.lang.Class r14 = java.lang.Integer.TYPE
            r12[r6] = r14
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r10)
            r14[r6] = r17
            java.lang.String r0 = o00xxox0x0xoox(r4, r5, r0, r12, r14)
            java.lang.String[] r12 = oo0ooo0o00o0xo
            r12 = r12[r13]
            java.lang.Class[] r14 = new java.lang.Class[r8]
            java.lang.Class r17 = java.lang.Integer.TYPE
            r14[r6] = r17
            java.lang.Object[] r13 = new java.lang.Object[r8]
            java.lang.Integer r18 = java.lang.Integer.valueOf(r11)
            r13[r6] = r18
            java.lang.String r12 = o00xxox0x0xoox(r4, r5, r12, r14, r13)
            r13 = 30
            java.lang.String r13 = o00xxox0x0xoox((java.lang.String) r15, (int) r13)
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0199
            r13 = 40
            java.lang.String r13 = o00xxox0x0xoox((java.lang.String) r15, (int) r13)
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x0199
            java.lang.String r0 = r20.getVoiceMailNumber()
        L_0x0199:
            java.lang.String[] r13 = oo0ooo0o00o0xo
            r14 = 4
            r13 = r13[r14]
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r0, (java.lang.String) r12)
            r3.put(r13, r0)
            goto L_0x01b5
        L_0x01a6:
            r14 = 4
            java.lang.String[] r0 = oo0ooo0o00o0xo
            r0 = r0[r14]
            java.lang.String r12 = "083a2c"
            r13 = 2
            java.lang.String r12 = o00xxox0x0xoox((java.lang.String) r12, (int) r13)
            r3.put(r0, r12)
        L_0x01b5:
            r0 = 98
            o00xxox0x0xoox((java.lang.String) r15, (int) r0)
            if (r7 == 0) goto L_0x01c1
            java.lang.String r0 = r7.oo0ooo0o00o0xo()
            goto L_0x01d8
        L_0x01c1:
            java.lang.String[] r0 = oo0ooo0o00o0xo
            r12 = 5
            r0 = r0[r12]
            java.lang.Class[] r12 = new java.lang.Class[r8]
            java.lang.Class r13 = java.lang.Integer.TYPE
            r12[r6] = r13
            java.lang.Object[] r13 = new java.lang.Object[r8]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)
            r13[r6] = r14
            java.lang.String r0 = o00xxox0x0xoox(r4, r5, r0, r12, r13)
        L_0x01d8:
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r15, (int) r6)
            if (r9 == 0) goto L_0x01e2
            java.lang.String r4 = r9.oo0ooo0o00o0xo()
        L_0x01e2:
            r5 = 79
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r15, (int) r5)
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x01fe
            r5 = 40
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r15, (int) r5)
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x01fe
            java.lang.String r0 = r20.getSimSerialNumber()
        L_0x01fe:
            java.lang.String[] r5 = oo0ooo0o00o0xo
            r12 = 5
            r5 = r5[r12]
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r0, (java.lang.String) r4)
            r3.put(r5, r0)
        L_0x020a:
            java.lang.String[] r0 = oo0ooo0o00o0xo
            r4 = 6
            r0 = r0[r4]
            java.lang.Class[] r5 = new java.lang.Class[r8]
            java.lang.Class r12 = java.lang.Integer.TYPE
            r5[r6] = r12
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r12[r6] = r13
            java.lang.String r0 = o00xxox0x0xoox(r1, r2, r0, r5, r12)
            r5 = 49
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r15, (int) r5)
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0231
            java.lang.String r0 = r20.getNetworkCountryIso()
        L_0x0231:
            java.lang.String[] r5 = oo0ooo0o00o0xo
            r5 = r5[r4]
            java.lang.Class[] r12 = new java.lang.Class[r8]
            java.lang.Class r13 = java.lang.Integer.TYPE
            r12[r6] = r13
            java.lang.Object[] r13 = new java.lang.Object[r8]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            r13[r6] = r14
            java.lang.String r5 = o00xxox0x0xoox(r1, r2, r5, r12, r13)
            java.lang.String[] r12 = oo0ooo0o00o0xo
            r12 = r12[r4]
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r0, (java.lang.String) r5)
            r3.put(r12, r0)
            r0 = 55
            o00xxox0x0xoox((java.lang.String) r15, (int) r0)
            r5 = 7
            if (r7 == 0) goto L_0x025f
            java.lang.String r12 = r7.o00xx0xx0ooooo0xx00()
            goto L_0x0275
        L_0x025f:
            java.lang.String[] r12 = oo0ooo0o00o0xo
            r12 = r12[r5]
            java.lang.Class[] r13 = new java.lang.Class[r8]
            java.lang.Class r14 = java.lang.Integer.TYPE
            r13[r6] = r14
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r10)
            r14[r6] = r17
            java.lang.String r12 = o00xxox0x0xoox(r1, r2, r12, r13, r14)
        L_0x0275:
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r15, (int) r4)
            boolean r4 = r4.equals(r12)
            if (r4 == 0) goto L_0x0283
            java.lang.String r12 = r20.getNetworkOperatorName()
        L_0x0283:
            java.lang.String r4 = ""
            if (r9 == 0) goto L_0x028c
            java.lang.String r13 = r9.o00xx0xx0ooooo0xx00()
            goto L_0x028d
        L_0x028c:
            r13 = r4
        L_0x028d:
            java.lang.String[] r14 = oo0ooo0o00o0xo
            r5 = r14[r5]
            java.lang.String r12 = o00xxox0x0xoox((java.lang.String) r12, (java.lang.String) r13)
            r3.put(r5, r12)
            r5 = 59
            o00xxox0x0xoox((java.lang.String) r15, (int) r5)
            if (r7 == 0) goto L_0x02a4
            java.lang.String r5 = r7.x0000xo0x0oooooo0()
            goto L_0x02bc
        L_0x02a4:
            java.lang.String[] r5 = oo0ooo0o00o0xo
            r7 = 8
            r5 = r5[r7]
            java.lang.Class[] r7 = new java.lang.Class[r8]
            java.lang.Class r12 = java.lang.Integer.TYPE
            r7[r6] = r12
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r12[r6] = r13
            java.lang.String r5 = o00xxox0x0xoox(r1, r2, r5, r7, r12)
        L_0x02bc:
            r7 = 36
            java.lang.String r7 = o00xxox0x0xoox((java.lang.String) r15, (int) r7)
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x02cc
            java.lang.String r5 = r20.getNetworkOperator()
        L_0x02cc:
            if (r9 == 0) goto L_0x02d3
            java.lang.String r7 = r9.x0000xo0x0oooooo0()
            goto L_0x02d4
        L_0x02d3:
            r7 = r4
        L_0x02d4:
            java.lang.String[] r9 = oo0ooo0o00o0xo
            r12 = 8
            r9 = r9[r12]
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (java.lang.String) r7)
            r3.put(r9, r5)
            java.lang.String[] r5 = oo0ooo0o00o0xo
            r7 = 9
            r5 = r5[r7]
            java.lang.Class[] r9 = new java.lang.Class[r8]
            java.lang.Class r12 = java.lang.Integer.TYPE
            r9[r6] = r12
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12[r6] = r13
            java.lang.String r5 = o00xxox0x0xoox(r1, r2, r5, r9, r12)
            r9 = 87
            java.lang.String r9 = o00xxox0x0xoox((java.lang.String) r15, (int) r9)
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x0309
            java.lang.String r5 = r20.getSimOperatorName()
        L_0x0309:
            java.lang.String[] r9 = oo0ooo0o00o0xo
            r9 = r9[r7]
            java.lang.Class[] r12 = new java.lang.Class[r8]
            java.lang.Class r13 = java.lang.Integer.TYPE
            r12[r6] = r13
            java.lang.Object[] r13 = new java.lang.Object[r8]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r8)
            r13[r6] = r14
            java.lang.String r9 = o00xxox0x0xoox(r1, r2, r9, r12, r13)
            java.lang.String[] r12 = oo0ooo0o00o0xo
            r7 = r12[r7]
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (java.lang.String) r9)
            r3.put(r7, r5)
            java.lang.String[] r5 = oo0ooo0o00o0xo
            r7 = 10
            r5 = r5[r7]
            java.lang.Class[] r9 = new java.lang.Class[r8]
            java.lang.Class r12 = java.lang.Integer.TYPE
            r9[r6] = r12
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r12[r6] = r13
            java.lang.String r5 = o00xxox0x0xoox(r1, r2, r5, r9, r12)
            r9 = 18
            java.lang.String r9 = o00xxox0x0xoox((java.lang.String) r15, (int) r9)
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x0361
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r9 = r20.getPhoneType()
            r5.append(r9)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
        L_0x0361:
            java.lang.String[] r9 = oo0ooo0o00o0xo
            r9 = r9[r7]
            java.lang.Class[] r12 = new java.lang.Class[r8]
            java.lang.Class r13 = java.lang.Integer.TYPE
            r12[r6] = r13
            java.lang.Object[] r13 = new java.lang.Object[r8]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            r13[r6] = r14
            java.lang.String r9 = o00xxox0x0xoox(r1, r2, r9, r12, r13)
            java.lang.String[] r12 = oo0ooo0o00o0xo
            r7 = r12[r7]
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (java.lang.String) r9)
            r3.put(r7, r5)
            java.lang.String[] r5 = oo0ooo0o00o0xo
            r7 = 11
            r5 = r5[r7]
            java.lang.Class[] r9 = new java.lang.Class[r8]
            java.lang.Class r12 = java.lang.Integer.TYPE
            r9[r6] = r12
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            r12[r6] = r13
            java.lang.String r5 = o00xxox0x0xoox(r1, r2, r5, r9, r12)
            r9 = 31
            java.lang.String r9 = o00xxox0x0xoox((java.lang.String) r15, (int) r9)
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x03b9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r9 = r20.getNetworkType()
            r5.append(r9)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
        L_0x03b9:
            java.lang.String[] r9 = oo0ooo0o00o0xo
            r9 = r9[r7]
            java.lang.Class[] r12 = new java.lang.Class[r8]
            java.lang.Class r13 = java.lang.Integer.TYPE
            r12[r6] = r13
            java.lang.Object[] r13 = new java.lang.Object[r8]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            r13[r6] = r14
            java.lang.String r9 = o00xxox0x0xoox(r1, r2, r9, r12, r13)
            java.lang.String[] r12 = oo0ooo0o00o0xo
            r7 = r12[r7]
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (java.lang.String) r9)
            r3.put(r7, r5)
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.String r7 = "android.permission.ACCESS_COARSE_LOCATION"
            r5[r6] = r7
            java.lang.String r7 = "android.permission.ACCESS_FINE_LOCATION"
            r5[r8] = r7
            r7 = r19
            boolean r5 = cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0.o00xxox0x0xoox((android.content.Context) r7, (java.lang.String[]) r5)
            r7 = 12
            if (r5 == 0) goto L_0x0506
            cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo r4 = new cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo
            r4.<init>()
            cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo r5 = new cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo
            r5.<init>()
            java.lang.String[] r9 = oo0ooo0o00o0xo     // Catch:{ Throwable -> 0x042f }
            r9 = r9[r7]     // Catch:{ Throwable -> 0x042f }
            java.lang.Class[] r12 = new java.lang.Class[r8]     // Catch:{ Throwable -> 0x042f }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ Throwable -> 0x042f }
            r12[r6] = r13     // Catch:{ Throwable -> 0x042f }
            java.lang.Object[] r13 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x042f }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)     // Catch:{ Throwable -> 0x042f }
            r13[r6] = r14     // Catch:{ Throwable -> 0x042f }
            java.lang.Object r9 = oo0ooo0o00o0xo(r1, r2, r9, r12, r13)     // Catch:{ Throwable -> 0x042f }
            java.lang.String[] r12 = oo0ooo0o00o0xo     // Catch:{ Throwable -> 0x042f }
            r12 = r12[r7]     // Catch:{ Throwable -> 0x042f }
            java.lang.Class[] r13 = new java.lang.Class[r8]     // Catch:{ Throwable -> 0x042f }
            java.lang.Class r14 = java.lang.Integer.TYPE     // Catch:{ Throwable -> 0x042f }
            r13[r6] = r14     // Catch:{ Throwable -> 0x042f }
            java.lang.Object[] r14 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x042f }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r11)     // Catch:{ Throwable -> 0x042f }
            r14[r6] = r15     // Catch:{ Throwable -> 0x042f }
            java.lang.Object r12 = oo0ooo0o00o0xo(r1, r2, r12, r13, r14)     // Catch:{ Throwable -> 0x042f }
            android.telephony.CellLocation r9 = (android.telephony.CellLocation) r9     // Catch:{ Throwable -> 0x042f }
            o00xxox0x0xoox((android.telephony.CellLocation) r9, (cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo) r4)     // Catch:{ Throwable -> 0x042f }
            android.telephony.CellLocation r12 = (android.telephony.CellLocation) r12     // Catch:{ Throwable -> 0x042f }
            o00xxox0x0xoox((android.telephony.CellLocation) r12, (cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo) r5)     // Catch:{ Throwable -> 0x042f }
        L_0x042f:
            java.lang.String[] r9 = oo0ooo0o00o0xo     // Catch:{ Throwable -> 0x0469 }
            r12 = 13
            r9 = r9[r12]     // Catch:{ Throwable -> 0x0469 }
            java.lang.Class[] r12 = new java.lang.Class[r8]     // Catch:{ Throwable -> 0x0469 }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ Throwable -> 0x0469 }
            r12[r6] = r13     // Catch:{ Throwable -> 0x0469 }
            java.lang.Object[] r13 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x0469 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r10)     // Catch:{ Throwable -> 0x0469 }
            r13[r6] = r14     // Catch:{ Throwable -> 0x0469 }
            java.lang.Object r9 = oo0ooo0o00o0xo(r1, r2, r9, r12, r13)     // Catch:{ Throwable -> 0x0469 }
            java.lang.String[] r12 = oo0ooo0o00o0xo     // Catch:{ Throwable -> 0x0469 }
            r13 = 13
            r12 = r12[r13]     // Catch:{ Throwable -> 0x0469 }
            java.lang.Class[] r13 = new java.lang.Class[r8]     // Catch:{ Throwable -> 0x0469 }
            java.lang.Class r14 = java.lang.Integer.TYPE     // Catch:{ Throwable -> 0x0469 }
            r13[r6] = r14     // Catch:{ Throwable -> 0x0469 }
            java.lang.Object[] r14 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x0469 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r11)     // Catch:{ Throwable -> 0x0469 }
            r14[r6] = r15     // Catch:{ Throwable -> 0x0469 }
            java.lang.Object r12 = oo0ooo0o00o0xo(r1, r2, r12, r13, r14)     // Catch:{ Throwable -> 0x0469 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ Throwable -> 0x0469 }
            o00xxox0x0xoox((java.util.List) r9, (cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo) r4)     // Catch:{ Throwable -> 0x0469 }
            java.util.List r12 = (java.util.List) r12     // Catch:{ Throwable -> 0x0469 }
            o00xxox0x0xoox((java.util.List) r12, (cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo) r5)     // Catch:{ Throwable -> 0x0469 }
        L_0x0469:
            java.lang.String[] r9 = oo0ooo0o00o0xo     // Catch:{ Throwable -> 0x04a3 }
            r12 = 14
            r9 = r9[r12]     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Class[] r12 = new java.lang.Class[r8]     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ Throwable -> 0x04a3 }
            r12[r6] = r13     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Object[] r13 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Throwable -> 0x04a3 }
            r13[r6] = r10     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Object r9 = oo0ooo0o00o0xo(r1, r2, r9, r12, r13)     // Catch:{ Throwable -> 0x04a3 }
            java.lang.String[] r10 = oo0ooo0o00o0xo     // Catch:{ Throwable -> 0x04a3 }
            r12 = 14
            r10 = r10[r12]     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Class[] r12 = new java.lang.Class[r8]     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ Throwable -> 0x04a3 }
            r12[r6] = r13     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Throwable -> 0x04a3 }
            r8[r6] = r11     // Catch:{ Throwable -> 0x04a3 }
            java.lang.Object r1 = oo0ooo0o00o0xo(r1, r2, r10, r12, r8)     // Catch:{ Throwable -> 0x04a3 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ Throwable -> 0x04a3 }
            oo0ooo0o00o0xo((java.util.List) r9, (cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo) r4)     // Catch:{ Throwable -> 0x04a3 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ Throwable -> 0x04a3 }
            oo0ooo0o00o0xo((java.util.List) r1, (cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo) r5)     // Catch:{ Throwable -> 0x04a3 }
        L_0x04a3:
            java.lang.String r1 = r4.o00xxox0x0xoox()
            java.lang.String r2 = r5.o00xxox0x0xoox()
            java.lang.String r5 = "7e08"
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r5, (int) r0)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x04d3
            r0 = 69
            java.lang.String r5 = "7e7a"
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r5, (int) r0)
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x04d3
            java.util.List r0 = r20.getAllCellInfo()
            if (r0 == 0) goto L_0x04d3
            oo0ooo0o00o0xo((java.util.List) r0, (cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo) r4)
            java.lang.String r0 = r4.o00xxox0x0xoox()
            goto L_0x04d4
        L_0x04d3:
            r0 = r1
        L_0x04d4:
            r1 = 45
            java.lang.String r5 = "7e12"
            java.lang.String r1 = o00xxox0x0xoox((java.lang.String) r5, (int) r1)
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0504
            r1 = 126(0x7e, float:1.77E-43)
            java.lang.String r5 = "7e41"
            java.lang.String r1 = o00xxox0x0xoox((java.lang.String) r5, (int) r1)
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0504
            r1 = 26
            boolean r1 = cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0.o00xxox0x0xoox(r1)
            if (r1 == 0) goto L_0x0504
            android.telephony.CellLocation r0 = r20.getCellLocation()
            o00xxox0x0xoox((android.telephony.CellLocation) r0, (cn.tongdun.android.core.x0000xo0x0oooooo0.oo0ooo0o00o0xo) r4)
            java.lang.String r4 = r4.o00xxox0x0xoox()
            goto L_0x0507
        L_0x0504:
            r4 = r0
            goto L_0x0507
        L_0x0506:
            r2 = r4
        L_0x0507:
            java.lang.String[] r0 = oo0ooo0o00o0xo
            r0 = r0[r7]
            java.lang.String r1 = o00xxox0x0xoox((java.lang.String) r4, (java.lang.String) r2)
            r3.put(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.oo0ooo0o00o0xo.oo0ooo0x0o.o00xxox0x0xoox(android.content.Context, android.telephony.TelephonyManager, java.lang.Object, java.lang.Class):java.util.Map");
    }

    private static Object o00xxox0x0xoox(Object obj, Class cls, String str) {
        try {
            return cls.getDeclaredMethod(str, new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String o00xxox0x0xoox(Object obj, Class cls, String str, Class[] clsArr, Object... objArr) {
        try {
            Object invoke = cls.getDeclaredMethod(str, clsArr).invoke(obj, objArr);
            if (invoke == null) {
                return o00xxox0x0xoox("08", 124);
            }
            if (invoke.toString().isEmpty()) {
                return "";
            }
            return invoke.toString();
        } catch (Throwable unused) {
            return o00xxox0x0xoox("08", 52);
        }
    }

    private static Object oo0ooo0o00o0xo(Object obj, Class cls, String str, Class[] clsArr, Object... objArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr).invoke(obj, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String o00xxox0x0xoox(String str, String str2) {
        if (str == null || str.equals("")) {
            str = o00xxox0x0xoox("08", 33);
        }
        if (str2 == null || str2.equals("")) {
            str2 = o00xxox0x0xoox("08", 119);
        }
        return str + o00xxox0x0xoox("09", 95) + str2;
    }

    private static void o00xxox0x0xoox(CellLocation cellLocation, oo0ooo0o00o0xo oo0ooo0o00o0xo2) {
        if (cellLocation == null) {
            return;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            oo0ooo0o00o0xo2.o00xxox0x0xoox(0, gsmCellLocation.getLac(), gsmCellLocation.getCid());
        } else if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            oo0ooo0o00o0xo2.o00xxox0x0xoox(1, cdmaCellLocation.getNetworkId(), cdmaCellLocation.getSystemId(), cdmaCellLocation.getBaseStationId(), cdmaCellLocation.getBaseStationLatitude(), cdmaCellLocation.getBaseStationLongitude());
        }
    }

    private static void o00xxox0x0xoox(List list, oo0ooo0o00o0xo oo0ooo0o00o0xo2) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                NeighboringCellInfo neighboringCellInfo = (NeighboringCellInfo) it.next();
                oo0ooo0o00o0xo2.o00xxox0x0xoox(0, neighboringCellInfo.getLac(), neighboringCellInfo.getCid(), neighboringCellInfo.getRssi());
            }
        }
    }

    @TargetApi(17)
    private static void oo0ooo0o00o0xo(List list, oo0ooo0o00o0xo oo0ooo0o00o0xo2) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CellInfo cellInfo = (CellInfo) it.next();
                if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                    CellSignalStrengthGsm cellSignalStrength = cellInfoGsm.getCellSignalStrength();
                    if (Build.VERSION.SDK_INT >= 24) {
                        oo0ooo0o00o0xo2.o00xxox0x0xoox(0, cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellIdentity.getArfcn(), cellIdentity.getBsic(), cellSignalStrength.getDbm());
                    } else {
                        oo0ooo0o00o0xo2.o00xxox0x0xoox(0, cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), 0, 0, cellSignalStrength.getDbm());
                    }
                } else if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                    oo0ooo0o00o0xo2.o00xxox0x0xoox(1, cellIdentity2.getNetworkId(), cellIdentity2.getSystemId(), cellIdentity2.getBasestationId(), cellIdentity2.getLatitude(), cellIdentity2.getLongitude(), cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    if (cellInfoLte.isRegistered()) {
                        CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                        CellSignalStrengthLte cellSignalStrength2 = cellInfoLte.getCellSignalStrength();
                        if (Build.VERSION.SDK_INT >= 24) {
                            oo0ooo0o00o0xo2.o00xxox0x0xoox(2, cellIdentity3.getMnc(), cellIdentity3.getTac(), cellIdentity3.getCi(), cellIdentity3.getEarfcn(), cellIdentity3.getPci(), cellSignalStrength2.getDbm());
                        } else {
                            oo0ooo0o00o0xo2.o00xxox0x0xoox(2, cellIdentity3.getMnc(), cellIdentity3.getTac(), cellIdentity3.getCi(), 0, 0, cellSignalStrength2.getDbm());
                        }
                    }
                } else if (xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(18) && (cellInfo instanceof CellInfoWcdma)) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    CellSignalStrengthWcdma cellSignalStrength3 = cellInfoWcdma.getCellSignalStrength();
                    if (Build.VERSION.SDK_INT >= 24) {
                        oo0ooo0o00o0xo2.o00xxox0x0xoox(3, cellIdentity4.getMnc(), cellIdentity4.getLac(), cellIdentity4.getCid(), cellIdentity4.getUarfcn(), cellIdentity4.getPsc(), cellSignalStrength3.getDbm());
                    } else {
                        oo0ooo0o00o0xo2.o00xxox0x0xoox(3, cellIdentity4.getMnc(), cellIdentity4.getLac(), cellIdentity4.getCid(), 0, 0, cellSignalStrength3.getDbm());
                    }
                }
            }
        }
    }

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 57);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 37);
            byte b3 = bArr[0];
            int i4 = 1;
            while (i4 < length2) {
                byte b4 = bArr[i4];
                bArr[i4] = (byte) ((b3 ^ bArr[i4]) ^ b2);
                i4++;
                b3 = b4;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
