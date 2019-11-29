package com.shopee.live.livestreaming.util;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import com.facebook.appevents.AppEventsConstants;
import com.path.android.jobqueue.JobManager;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ab {
    public static String a() {
        String a2 = x.a();
        if (Country.COUNTRY_SG.equals(a2)) {
            return "$";
        }
        if ("ID".equals(a2)) {
            return "Rp";
        }
        if (Country.COUNTRY_MY.equals(a2)) {
            return "RM";
        }
        if (Country.COUNTRY_TW.equals(a2)) {
            return "$";
        }
        if (Country.COUNTRY_TH.equals(a2)) {
            return "฿";
        }
        if (Country.COUNTRY_VN.equals(a2)) {
            return "₫";
        }
        if (Country.COUNTRY_PH.equals(a2)) {
            return "₱";
        }
        if (Country.COUNTRY_IR.equals(a2)) {
            return "تومان";
        }
        if (Country.COUNTRY_MM.equals(a2)) {
            return "Ks";
        }
        if (Country.COUNTRY_HK.equals(a2)) {
            return "$";
        }
        return "";
    }

    public static String a(String str) {
        String a2 = x.a();
        try {
            double parseDouble = Double.parseDouble(str);
            if (!Country.COUNTRY_VN.equals(a2)) {
                if (!"ID".equals(a2)) {
                    str = NumberFormat.getInstance(Locale.CHINA).format(parseDouble);
                    return c(str);
                }
            }
            str = NumberFormat.getInstance(Locale.GERMAN).format(parseDouble);
        } catch (NumberFormatException unused) {
            a.b("StringUtil: formatNumber error: " + str, new Object[0]);
        }
        return c(str);
    }

    public static String b(String str) {
        String a2 = x.a();
        try {
            if (!Country.COUNTRY_SG.equals(a2) && !Country.COUNTRY_MY.equals(a2)) {
                if (!Country.COUNTRY_PH.equals(a2)) {
                    if (!Country.COUNTRY_VN.equals(a2)) {
                        if (!"ID".equals(a2)) {
                            str = NumberFormat.getInstance(Locale.CHINA).format((long) Double.parseDouble(str));
                            return c(str);
                        }
                    }
                    str = NumberFormat.getInstance(Locale.GERMAN).format((long) Double.parseDouble(str));
                    return c(str);
                }
            }
            str = NumberFormat.getInstance(Locale.CHINA).format(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            a.b("StringUtil: formatNumberWithDecimal error: " + str, new Object[0]);
        }
        return c(str);
    }

    public static String c(String str) {
        String a2 = x.a();
        if (Country.COUNTRY_VN.equals(a2) || "ID".equals(a2)) {
            return str.indexOf(",") > 0 ? str.replaceAll("0+?$", "").replaceAll("[,]$", "") : str;
        }
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public static String a(String str, int i) {
        if (!d.a(str) && d.b(str)) {
            String a2 = x.a();
            if (Country.COUNTRY_SG.equals(a2)) {
                str = a(Long.valueOf(str).longValue(), i, "k", "m", "b");
            } else if ("ID".equals(a2)) {
                str = a(Long.valueOf(str).longValue(), i, "rb", "juta", "miliar");
            } else if (Country.COUNTRY_MY.equals(a2)) {
                str = a(Long.valueOf(str).longValue(), i, "k", "m", "b");
            } else if (Country.COUNTRY_TW.equals(a2)) {
                str = a(Long.valueOf(str).longValue(), i, "k", "m", "b");
            } else if (Country.COUNTRY_TH.equals(a2)) {
                if (Long.valueOf(str).longValue() < 1000000000) {
                    str = a(Long.valueOf(str).longValue(), i, "พัน", "ล้าน", "b");
                } else {
                    str = b(str);
                }
            } else if (Country.COUNTRY_VN.equals(a2)) {
                if (Long.valueOf(str).longValue() < 1000000000) {
                    str = a(Long.valueOf(str).longValue(), i, "k", "tr", "b");
                } else {
                    str = b(str);
                }
            } else if (Country.COUNTRY_PH.equals(a2)) {
                str = a(Long.valueOf(str).longValue(), i, "k", "mil", "b");
            } else if (Country.COUNTRY_IR.equals(a2)) {
                str = b(str);
            } else if (Country.COUNTRY_MM.equals(a2)) {
                str = b(str);
            }
        }
        return f(str);
    }

    private static String a(long j, int i, String str, String str2, String str3) {
        if (j >= 0 && j < 1000) {
            return String.valueOf(j);
        }
        if (j >= 1000 && j < JobManager.NS_PER_MS) {
            String a2 = a(j / 1000, (j % 1000) / ((long) ((int) Math.pow(10.0d, (double) ((3 - i) - 1)))));
            if (a2.equals("1000")) {
                return "1" + str2;
            }
            return a2 + str;
        } else if (j >= JobManager.NS_PER_MS && j < 1000000000) {
            String a3 = a(j / JobManager.NS_PER_MS, (j % JobManager.NS_PER_MS) / ((long) ((int) Math.pow(10.0d, (double) ((6 - i) - 1)))));
            if (a3.equals("1000")) {
                return "1" + str3;
            }
            return a3 + str2;
        } else if (j < 1000000000) {
            return "";
        } else {
            return a(j / 1000000000, (j % 1000000000) / ((long) ((int) Math.pow(10.0d, (double) ((9 - i) - 1))))) + str3;
        }
    }

    private static String a(long j, long j2) {
        String valueOf = String.valueOf(j2);
        if (j2 < 10) {
            valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO + valueOf;
        }
        String str = String.valueOf(j) + "." + valueOf + "1";
        return c(f(String.valueOf((d.a(str) || (!d.b(str) && str.indexOf(46) == -1)) ? 0.0d : new BigDecimal(Double.valueOf(str).doubleValue()).setScale(1, 4).doubleValue())));
    }

    private static String f(String str) {
        if (d.a(str) || !str.contains(".")) {
            return str;
        }
        String a2 = x.a();
        return ("ID".equals(a2) || Country.COUNTRY_VN.equals(a2)) ? str.replace(".", ",") : str;
    }

    public static String d(String str) {
        SimpleDateFormat simpleDateFormat;
        if (d.a(str)) {
            return "";
        }
        String a2 = x.a();
        if (Country.COUNTRY_PH.equals(a2)) {
            simpleDateFormat = new SimpleDateFormat("MM.dd.yyyy");
        } else if (Country.COUNTRY_TW.equals(a2)) {
            simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        } else {
            simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        }
        return simpleDateFormat.format(new Date(Long.valueOf(str).longValue() * 1000));
    }

    public static String a(int i) {
        if (Country.COUNTRY_TW == x.a()) {
            return b(i);
        }
        return String.valueOf(i) + "%";
    }

    public static String b(int i) {
        int i2 = 100 - i;
        try {
            if (i2 % 10 == 0) {
                return String.valueOf(i2 / 10);
            }
            return a(i2, 10);
        } catch (Exception unused) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    public static String a(int i, int i2) {
        return new DecimalFormat("0.0").format((double) (((float) i) / ((float) i2)));
    }

    public static float a(float f2) {
        return TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.app.Activity r10, int r11) {
        /*
            java.lang.String r0 = com.shopee.live.livestreaming.util.x.a()
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r3 = "SG"
            java.lang.String r4 = "en"
            r2.<init>(r4, r3)
            int r4 = r0.hashCode()
            r5 = 2331(0x91b, float:3.266E-42)
            java.lang.String r6 = "VN"
            java.lang.String r7 = "TW"
            java.lang.String r8 = "TH"
            java.lang.String r9 = "ID"
            if (r4 == r5) goto L_0x006f
            r5 = 2476(0x9ac, float:3.47E-42)
            if (r4 == r5) goto L_0x0065
            r5 = 2552(0x9f8, float:3.576E-42)
            if (r4 == r5) goto L_0x005b
            r5 = 2644(0xa54, float:3.705E-42)
            if (r4 == r5) goto L_0x0053
            r3 = 2676(0xa74, float:3.75E-42)
            if (r4 == r3) goto L_0x004b
            r3 = 2691(0xa83, float:3.771E-42)
            if (r4 == r3) goto L_0x0043
            r3 = 2744(0xab8, float:3.845E-42)
            if (r4 == r3) goto L_0x003b
            goto L_0x0077
        L_0x003b:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0077
            r0 = 6
            goto L_0x0078
        L_0x0043:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0077
            r0 = 5
            goto L_0x0078
        L_0x004b:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0077
            r0 = 4
            goto L_0x0078
        L_0x0053:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0077
            r0 = 3
            goto L_0x0078
        L_0x005b:
            java.lang.String r3 = "PH"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0077
            r0 = 2
            goto L_0x0078
        L_0x0065:
            java.lang.String r3 = "MY"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0077
            r0 = 1
            goto L_0x0078
        L_0x006f:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0077
            r0 = 0
            goto L_0x0078
        L_0x0077:
            r0 = -1
        L_0x0078:
            switch(r0) {
                case 0: goto L_0x0094;
                case 1: goto L_0x009b;
                case 2: goto L_0x009b;
                case 3: goto L_0x009b;
                case 4: goto L_0x008c;
                case 5: goto L_0x0084;
                case 6: goto L_0x007c;
                default: goto L_0x007b;
            }
        L_0x007b:
            goto L_0x009b
        L_0x007c:
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r0 = "vi"
            r2.<init>(r0, r6)
            goto L_0x009b
        L_0x0084:
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r0 = "zh"
            r2.<init>(r0, r7)
            goto L_0x009b
        L_0x008c:
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r0 = "th"
            r2.<init>(r0, r8)
            goto L_0x009b
        L_0x0094:
            java.util.Locale r2 = new java.util.Locale
            java.lang.String r0 = "in"
            r2.<init>(r0, r9)
        L_0x009b:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r0 < r3) goto L_0x00a5
            r1.setLocale(r2)
            goto L_0x00a7
        L_0x00a5:
            r1.locale = r2
        L_0x00a7:
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            android.view.WindowManager r2 = r10.getWindowManager()
            android.view.Display r2 = r2.getDefaultDisplay()
            r2.getMetrics(r0)
            android.content.res.Resources r2 = new android.content.res.Resources
            android.content.res.AssetManager r10 = r10.getAssets()
            r2.<init>(r10, r0, r1)
            java.lang.String r10 = r2.getString(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.util.ab.a(android.app.Activity, int):java.lang.String");
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return RNCartPanelDataEntity.NULL_VALUE;
        }
    }
}
