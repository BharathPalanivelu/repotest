package com.shopee.livequiz.g;

import android.text.TextUtils;
import com.garena.android.appkit.d.a;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.sdk.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j {
    public static boolean a(String str) {
        if (str == null || "".equals(str) || "null".equals(str) || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("((http|ftp|https|file|sftp)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?").matcher(str);
        StringBuilder sb = new StringBuilder(str);
        while (matcher.find()) {
            try {
                int start = matcher.start();
                int end = matcher.end();
                if (start <= end && start >= 0 && end <= str.length()) {
                    sb.replace(start, end, "***");
                }
            } catch (Exception unused) {
                a.a("StringUtil: resolveUrl replace error", new Object[0]);
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        String d2 = b.a().a().a().d();
        try {
            double parseDouble = Double.parseDouble(str);
            if (!Country.COUNTRY_VN.equals(d2)) {
                if (!"ID".equals(d2)) {
                    str = NumberFormat.getInstance(Locale.CHINA).format(parseDouble);
                    return f(str);
                }
            }
            str = NumberFormat.getInstance(Locale.GERMAN).format(parseDouble);
        } catch (NumberFormatException unused) {
            a.a("StringUtil: formatNumber error: " + str, new Object[0]);
        }
        return f(str);
    }

    public static String d(String str) {
        String d2 = b.a().a().a().d();
        try {
            if (!Country.COUNTRY_PH.equals(d2) && !Country.COUNTRY_TH.equals(d2)) {
                if (!Country.COUNTRY_TW.equals(d2)) {
                    if (!Country.COUNTRY_VN.equals(d2)) {
                        if (!"ID".equals(d2)) {
                            str = NumberFormat.getInstance(Locale.CHINA).format((long) Double.parseDouble(str));
                            return f(str);
                        }
                    }
                    str = NumberFormat.getInstance(Locale.GERMAN).format((long) Double.parseDouble(str));
                    return f(str);
                }
            }
            str = NumberFormat.getInstance(Locale.CHINA).format(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            a.a("StringUtil: formatNumberWithDecimal error: " + str, new Object[0]);
        }
        return f(str);
    }

    public static boolean e(String str) {
        String d2 = b.a().a().a().d();
        try {
            if (!Country.COUNTRY_PH.equals(d2) && !Country.COUNTRY_TH.equals(d2)) {
                if (!Country.COUNTRY_TW.equals(d2)) {
                    if (((long) Double.parseDouble(str)) > 0) {
                        return false;
                    }
                    return true;
                }
            }
            if (Double.parseDouble(str) > 0.0d) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            a.a("StringUtil: formatNumberWithDecimal error: " + str, new Object[0]);
            return false;
        }
    }

    public static String f(String str) {
        String d2 = b.a().a().a().d();
        if (Country.COUNTRY_VN.equals(d2) || "ID".equals(d2)) {
            return str.indexOf(",") > 0 ? str.replaceAll("0+?$", "").replaceAll("[,]$", "") : str;
        }
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        URL url = null;
        try {
            url = new URL(str);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        if (url == null) {
            return "";
        }
        return url.getHost();
    }
}
