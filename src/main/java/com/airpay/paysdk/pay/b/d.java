package com.airpay.paysdk.pay.b;

import com.airpay.paysdk.base.different.a;
import com.airpay.paysdk.pay.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.arcatch.data.common_bean.Country;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Format f4161a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4162b;

    public static d a(String str) {
        Format format;
        if (Country.COUNTRY_TH.equals(str)) {
            format = a();
        } else {
            format = a(a.a().l());
        }
        return new d(format, str);
    }

    private static Format a() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(",".charAt(0));
        decimalFormatSymbols.setDecimalSeparator(".".charAt(0));
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        decimalFormat.setGroupingUsed(true);
        return decimalFormat;
    }

    private static Format a(Locale locale) {
        int defaultFractionDigits = Currency.getInstance(locale).getDefaultFractionDigits();
        NumberFormat numberInstance = NumberFormat.getNumberInstance(locale);
        numberInstance.setMinimumFractionDigits(defaultFractionDigits);
        numberInstance.setMaximumFractionDigits(defaultFractionDigits);
        return numberInstance;
    }

    private d(Format format, String str) {
        this.f4161a = format;
        this.f4162b = str;
    }

    public String a(double d2) {
        return this.f4161a.format(Double.valueOf(d2));
    }

    public String b(double d2) {
        String format = a(a.a().l()).format(Double.valueOf(b.c(d2)));
        String b2 = b.b(this.f4162b);
        if (Country.COUNTRY_TH.equalsIgnoreCase(this.f4162b)) {
            return b2 + SQLBuilder.BLANK + format;
        } else if (!Country.COUNTRY_VN.equalsIgnoreCase(this.f4162b)) {
            return format;
        } else {
            return format + SQLBuilder.BLANK + b2;
        }
    }
}
