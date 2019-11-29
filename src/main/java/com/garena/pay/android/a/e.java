package com.garena.pay.android.a;

import java.io.Serializable;

public class e implements Serializable {
    private static final long serialVersionUID = 1;
    private Float conversionRatio;
    private String currencyCode;
    private Double currencyRate;
    private String currencySymbolFormat;
    private String virtualCurrencyName;

    public String a() {
        return this.virtualCurrencyName;
    }
}
