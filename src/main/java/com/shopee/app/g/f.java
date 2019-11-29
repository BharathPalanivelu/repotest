package com.shopee.app.g;

import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.text.DecimalFormat;
import org.slf4j.Marker;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static double f17505a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    public static String[] f17506b = {"`", "~", "!", "@", "#", "$", "%", "^", "&", "*", SQLBuilder.PARENTHESES_LEFT, SQLBuilder.PARENTHESES_RIGHT, "-", "_", SimpleComparison.EQUAL_TO_OPERATION, Marker.ANY_NON_NULL_MARKER, "[", "{", "]", "}", "\\", "|", ";", ":", "'", "\"", ",", SimpleComparison.LESS_THAN_OPERATION, ".", SimpleComparison.GREATER_THAN_OPERATION, Constants.URL_PATH_DELIMITER, "?"};

    public static boolean a(String str) {
        return str != null && str.length() <= 100;
    }

    public static double b(String str) {
        if (TextUtils.isEmpty(str)) {
            return f17505a;
        }
        try {
            double parseDouble = Double.parseDouble(e.b(str, "IDR"));
            if (parseDouble <= 0.0d) {
                return f17505a;
            }
            return Double.valueOf(new DecimalFormat("#.##").format(parseDouble)).doubleValue();
        } catch (NumberFormatException unused) {
            return f17505a;
        }
    }

    public static int c(String str) {
        if (str == null) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0) {
                return 1;
            }
            if (parseInt == 0) {
                return 4;
            }
            return parseInt > 999999 ? 2 : 3;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str);
    }
}
