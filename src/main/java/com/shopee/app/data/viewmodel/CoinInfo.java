package com.shopee.app.data.viewmodel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class CoinInfo {
    private final BigDecimal mMultiplier;

    public CoinInfo(String str) {
        BigDecimal bigDecimal;
        try {
            bigDecimal = new BigDecimal(str);
        } catch (Exception unused) {
            bigDecimal = new BigDecimal(1);
        }
        this.mMultiplier = bigDecimal;
    }

    public boolean isInt() {
        return this.mMultiplier.scale() <= 0;
    }

    public String value(long j) {
        DecimalFormat decimalFormat = new DecimalFormat();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        decimalFormatSymbols.setMonetaryDecimalSeparator(',');
        if (!isInt()) {
            decimalFormat.setMaximumFractionDigits(2);
            decimalFormat.setMinimumFractionDigits(2);
        } else {
            decimalFormat.setMaximumFractionDigits(0);
        }
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat.format(new BigDecimal(j).multiply(this.mMultiplier));
    }
}
