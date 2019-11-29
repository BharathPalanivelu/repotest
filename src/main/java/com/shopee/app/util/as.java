package com.shopee.app.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import com.facebook.appevents.AppEventsConstants;
import com.google.b.a.h;
import com.google.b.a.j;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.rengwuxian.materialedittext.a.b;
import com.shopee.arcatch.data.common_bean.Country;
import java.util.HashMap;
import org.slf4j.Marker;

public class as {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, String> f26168a = new HashMap<>();

    public static String a(String str) {
        return str != null ? str.replaceAll("[^0-9]+", "") : "";
    }

    protected static boolean a(j.a aVar) {
        return aVar != null && h.a().b(aVar);
    }

    public static boolean b(String str) {
        j.a a2 = a(str, (String) null);
        return a2 != null && h.a().b(a2);
    }

    public static String c(String str) {
        j.a a2 = a(str, (String) null);
        if (a2 == null) {
            return str;
        }
        return a(a2, (String) null);
    }

    public static String d(String str) {
        String c2 = c(str);
        if (TextUtils.isEmpty(str) || c2.length() < 2) {
            return c2;
        }
        return "*****" + c2.substring(c2.length() - 2);
    }

    public static String a(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (TextUtils.isEmpty(simCountryIso)) {
                simCountryIso = telephonyManager.getNetworkCountryIso();
            }
            str = simCountryIso.toUpperCase();
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getResources().getConfiguration().locale.getCountry();
        }
        return TextUtils.isEmpty(str) ? "ID" : str;
    }

    public static int a(Context context, Editable editable) {
        return a(context, editable, false);
    }

    public static void a(Context context, EditText editText) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(editText.getText().toString());
        a(context, spannableStringBuilder, true);
        editText.setText(spannableStringBuilder.toString());
    }

    public static String a(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        a(context, spannableStringBuilder, true);
        return spannableStringBuilder.toString();
    }

    public static int a(Context context, Editable editable, boolean z) {
        String str;
        String a2;
        String trim = editable.toString().trim();
        int i = -1;
        if (o.a((CharSequence) trim)) {
            i = 1;
        } else if (trim.startsWith(Marker.ANY_NON_NULL_MARKER) || trim.startsWith("(+")) {
            j.a a3 = a(trim, (String) null);
            if (a(a3)) {
                trim = a(a3, (String) null);
                i = 2;
            }
        } else if (!trim.matches("[0-9\\*#]+")) {
            i = 3;
        } else {
            String a4 = !trim.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO) ? a(context) : "ID";
            j.a a5 = a(trim, a4);
            if (a5 != null) {
                if (a(a5)) {
                    a2 = a(a5, (String) null);
                } else {
                    j.a a6 = a(Marker.ANY_NON_NULL_MARKER + trim, (String) null);
                    if (a(a6)) {
                        a2 = a(a6, (String) null);
                    } else {
                        trim = Marker.ANY_NON_NULL_MARKER + e(a4) + SQLBuilder.BLANK + trim;
                    }
                }
                str = a2;
                i = 2;
                if (i == 2 || z) {
                    editable.replace(0, editable.length(), str, 0, str.length());
                }
                return i;
            }
        }
        str = trim;
        editable.replace(0, editable.length(), str, 0, str.length());
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r0 = com.google.b.a.h.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        return r0.a((java.lang.CharSequence) org.slf4j.Marker.ANY_NON_NULL_MARKER + r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.google.b.a.j.a a(java.lang.String r3, java.lang.String r4) {
        /*
            com.google.b.a.h r0 = com.google.b.a.h.a()     // Catch:{ Exception -> 0x0009 }
            com.google.b.a.j$a r3 = r0.a((java.lang.CharSequence) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0009 }
            return r3
        L_0x0009:
            com.google.b.a.h r0 = com.google.b.a.h.a()     // Catch:{ Exception -> 0x0023 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
            r1.<init>()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = "+"
            r1.append(r2)     // Catch:{ Exception -> 0x0023 }
            r1.append(r3)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x0023 }
            com.google.b.a.j$a r3 = r0.a((java.lang.CharSequence) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0023 }
            return r3
        L_0x0023:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.as.a(java.lang.String, java.lang.String):com.google.b.a.j$a");
    }

    protected static String a(j.a aVar, String str) {
        aVar.a(j.a.C0222a.FROM_NUMBER_WITH_PLUS_SIGN);
        String b2 = h.a().b(aVar, str);
        int a2 = aVar.a();
        String str2 = Marker.ANY_NON_NULL_MARKER + a2;
        if (!b2.startsWith(str2)) {
            return b2;
        }
        return b2.replace(str2, "(+" + a2 + SQLBuilder.PARENTHESES_RIGHT);
    }

    protected static int e(String str) {
        return h.a().b(str);
    }

    public static class a extends b {
        public a(String str) {
            super(str);
        }

        public boolean a(CharSequence charSequence, boolean z) {
            if (TextUtils.isEmpty(charSequence)) {
                return false;
            }
            j.a a2 = as.a(charSequence.toString(), (String) null);
            if (a2 != null) {
                return h.a().b(a2);
            }
            return as.a(charSequence.toString()).startsWith("00065");
        }
    }

    static {
        f26168a.put(Country.COUNTRY_SG, "65");
        f26168a.put(Country.COUNTRY_TH, "66");
        f26168a.put(Country.COUNTRY_TW, "886");
        f26168a.put(Country.COUNTRY_VN, "84");
        f26168a.put("ID", "62");
        f26168a.put(Country.COUNTRY_MY, "60");
        f26168a.put(Country.COUNTRY_PH, "63");
        f26168a.put(Country.COUNTRY_IR, "98");
    }

    public static String b(String str, String str2) {
        String upperCase = str == null ? "" : str.toUpperCase();
        return f26168a.containsKey(upperCase) ? f26168a.get(upperCase) : str2;
    }

    public static boolean a(CharSequence charSequence) {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}
