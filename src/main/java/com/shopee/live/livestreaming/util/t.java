package com.shopee.live.livestreaming.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.SparseArray;
import tencent.tls.platform.SigType;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<b> f29484a;

    /* renamed from: b  reason: collision with root package name */
    private String f29485b;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final t f29487a = new t((AnonymousClass1) null);
    }

    public interface b {
        void a(String str);

        void a(String str, boolean z);
    }

    /* synthetic */ t(AnonymousClass1 r1) {
        this();
    }

    private t() {
        this.f29484a = new SparseArray<>();
    }

    public static t a() {
        return a.f29487a;
    }

    public void a(Activity activity, int i, String[] strArr, int[] iArr) {
        b bVar = this.f29484a.get(i);
        if (bVar != null) {
            if (strArr.length <= 0) {
                bVar.a("all");
                this.f29484a.remove(i);
            } else {
                String a2 = a(strArr[0]);
                if (iArr[0] == 0) {
                    if (a2 == null) {
                        a2 = strArr[0];
                    }
                    bVar.a(a2);
                    this.f29484a.remove(i);
                } else {
                    if (a2 == null) {
                        a2 = strArr[0];
                    }
                    bVar.a(a2, !androidx.core.app.a.a(activity, strArr[0]));
                }
            }
        }
        this.f29485b = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            switch(r0) {
                case -2062386608: goto L_0x007c;
                case -1888586689: goto L_0x0072;
                case -406040016: goto L_0x0068;
                case -63024214: goto L_0x005e;
                case -5573545: goto L_0x0054;
                case 112197485: goto L_0x004a;
                case 214526995: goto L_0x003f;
                case 463403621: goto L_0x0035;
                case 1271781903: goto L_0x002a;
                case 1365911975: goto L_0x0020;
                case 1831139720: goto L_0x0014;
                case 1977429404: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0087
        L_0x0009:
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 7
            goto L_0x0088
        L_0x0014:
            java.lang.String r0 = "android.permission.RECORD_AUDIO"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 11
            goto L_0x0088
        L_0x0020:
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 1
            goto L_0x0088
        L_0x002a:
            java.lang.String r0 = "android.permission.GET_ACCOUNTS"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 9
            goto L_0x0088
        L_0x0035:
            java.lang.String r0 = "android.permission.CAMERA"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 6
            goto L_0x0088
        L_0x003f:
            java.lang.String r0 = "android.permission.WRITE_CONTACTS"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 8
            goto L_0x0088
        L_0x004a:
            java.lang.String r0 = "android.permission.CALL_PHONE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 5
            goto L_0x0088
        L_0x0054:
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 4
            goto L_0x0088
        L_0x005e:
            java.lang.String r0 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 3
            goto L_0x0088
        L_0x0068:
            java.lang.String r0 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 0
            goto L_0x0088
        L_0x0072:
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 2
            goto L_0x0088
        L_0x007c:
            java.lang.String r0 = "android.permission.READ_SMS"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0087
            r5 = 10
            goto L_0x0088
        L_0x0087:
            r5 = -1
        L_0x0088:
            java.lang.String r0 = "android.permission-group.PHONE"
            r1 = 17
            r2 = 23
            r3 = 0
            switch(r5) {
                case 0: goto L_0x00bc;
                case 1: goto L_0x00bc;
                case 2: goto L_0x00b9;
                case 3: goto L_0x00b9;
                case 4: goto L_0x00b4;
                case 5: goto L_0x00af;
                case 6: goto L_0x00a8;
                case 7: goto L_0x00a1;
                case 8: goto L_0x00a1;
                case 9: goto L_0x00a1;
                case 10: goto L_0x009a;
                case 11: goto L_0x0093;
                default: goto L_0x0092;
            }
        L_0x0092:
            goto L_0x00bf
        L_0x0093:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r1) goto L_0x0099
            java.lang.String r3 = "android.permission-group.MICROPHONE"
        L_0x0099:
            return r3
        L_0x009a:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L_0x00bf
            java.lang.String r0 = "android.permission-group.SMS"
            goto L_0x00c0
        L_0x00a1:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L_0x00bf
            java.lang.String r0 = "android.permission-group.CONTACTS"
            goto L_0x00c0
        L_0x00a8:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r1) goto L_0x00bf
            java.lang.String r0 = "android.permission-group.CAMERA"
            goto L_0x00c0
        L_0x00af:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L_0x00bf
            goto L_0x00c0
        L_0x00b4:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L_0x00bf
            goto L_0x00c0
        L_0x00b9:
            java.lang.String r0 = "android.permission-group.LOCATION"
            goto L_0x00c0
        L_0x00bc:
            java.lang.String r0 = "android.permission-group.STORAGE"
            goto L_0x00c0
        L_0x00bf:
            r0 = r3
        L_0x00c0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.util.t.a(java.lang.String):java.lang.String");
    }

    public void a(Activity activity, b bVar) {
        a(activity, bVar, 1);
    }

    public void b(Activity activity, b bVar) {
        a(activity, bVar, 4);
    }

    public void c(Activity activity, b bVar) {
        a(activity, bVar, 7);
    }

    private void a(Activity activity, b bVar, int i) {
        this.f29484a.clear();
        c a2 = a(i);
        if (a2 != null) {
            for (String str : a2.f29488a) {
                if (androidx.core.app.a.b((Context) activity, str) != 0 || "oppo".equalsIgnoreCase(Build.MANUFACTURER)) {
                    this.f29484a.put(i, bVar);
                    androidx.core.app.a.a(activity, new String[]{str}, i);
                    return;
                }
            }
            if (bVar != null) {
                bVar.a(a2.f29489b);
            }
        } else if (bVar != null) {
            bVar.a("all");
        }
    }

    private c a(int i) {
        switch (i) {
            case 1:
                c cVar = new c();
                cVar.f29489b = "android.permission-group.STORAGE";
                if (Build.VERSION.SDK_INT >= 16) {
                    cVar.f29488a = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
                } else {
                    cVar.f29488a = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
                }
                return cVar;
            case 2:
                c cVar2 = new c();
                if (Build.VERSION.SDK_INT >= 23) {
                    cVar2.f29489b = "android.permission-group.PHONE";
                } else {
                    cVar2.f29489b = "all";
                }
                cVar2.f29488a = new String[]{"android.permission.READ_PHONE_STATE"};
                return cVar2;
            case 3:
                c cVar3 = new c();
                cVar3.f29489b = "android.permission-group.LOCATION";
                cVar3.f29488a = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
                return cVar3;
            case 4:
                c cVar4 = new c();
                if (Build.VERSION.SDK_INT >= 17) {
                    cVar4.f29489b = "android.permission-group.CAMERA";
                } else {
                    cVar4.f29489b = "all";
                }
                cVar4.f29488a = new String[]{"android.permission.CAMERA"};
                return cVar4;
            case 5:
                c cVar5 = new c();
                if (Build.VERSION.SDK_INT >= 23) {
                    cVar5.f29489b = "android.permission-group.CONTACTS";
                } else {
                    cVar5.f29489b = "all";
                }
                cVar5.f29488a = new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
                return cVar5;
            case 6:
                c cVar6 = new c();
                if (Build.VERSION.SDK_INT >= 23) {
                    cVar6.f29489b = "android.permission-group.SMS";
                } else {
                    cVar6.f29489b = "all";
                }
                cVar6.f29488a = new String[]{"android.permission.READ_SMS"};
                return cVar6;
            case 7:
                c cVar7 = new c();
                if (Build.VERSION.SDK_INT >= 17) {
                    cVar7.f29489b = "android.permission-group.MICROPHONE";
                } else {
                    cVar7.f29489b = "all";
                }
                cVar7.f29488a = new String[]{"android.permission.RECORD_AUDIO"};
                return cVar7;
            case 8:
                c cVar8 = new c();
                if (Build.VERSION.SDK_INT >= 23) {
                    cVar8.f29489b = "android.permission-group.PHONE";
                } else {
                    cVar8.f29489b = "all";
                }
                cVar8.f29488a = new String[]{"android.permission.CALL_PHONE"};
                return cVar8;
            default:
                return null;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        String[] f29488a;

        /* renamed from: b  reason: collision with root package name */
        String f29489b;

        c() {
        }
    }

    public static void a(Activity activity) {
        if ("oppo".equalsIgnoreCase(Build.MANUFACTURER) || "vivo".equalsIgnoreCase(Build.MANUFACTURER)) {
            Intent intent = new Intent("android.settings.SETTINGS");
            intent.addFlags(SigType.TLS);
            activity.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + activity.getPackageName()));
        intent2.addFlags(SigType.TLS);
        activity.startActivity(intent2);
    }

    /* renamed from: com.shopee.live.livestreaming.util.t$1  reason: invalid class name */
    static class AnonymousClass1 extends com.shopee.sdk.f.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f29486a;

        public void a(int i, String str) {
        }

        public void a(Integer num) {
            int intValue = num.intValue();
            if (intValue != 0) {
                if (intValue == 1) {
                    t.a(this.f29486a);
                    return;
                } else if (intValue != 2) {
                    return;
                }
            }
            this.f29486a.finish();
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return Settings.canDrawOverlays(context);
    }
}
