package com.garena.pay.android.a;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class b implements Serializable {
    private static final long serialVersionUID = 1;
    private String appId;
    private Integer appServerId;
    private String buyerId;
    private Float conversionRatio;
    private List<a> denominations;
    private String description;
    private Locale locale;
    private Integer platform;
    private Long rebateId;
    private Integer roleId;
    private String token;
    private String transactionId;
    private String virtualCurrencyName;

    public Long a() {
        return this.rebateId;
    }

    public Integer b() {
        return this.appServerId;
    }

    public Integer c() {
        return this.roleId;
    }

    public String d() {
        return this.token;
    }

    public String e() {
        return this.appId;
    }

    public String f() {
        return this.buyerId;
    }

    public Locale g() {
        return this.locale;
    }

    public Integer h() {
        return this.platform;
    }

    public static class a implements Serializable {
        private static final long serialVersionUID = 1;
        private Integer appPoints;
        private String iconUrl;
        private boolean isPromo;
        private String itemId;
        private String mCurrencyIconUrl = null;
        private String name;
        private String price;
        private long rebateId = 0;

        public a(String str, String str2, Integer num, String str3, String str4, boolean z) {
            this.name = str;
            this.itemId = str2;
            this.appPoints = num;
            this.iconUrl = str3;
            this.price = str4;
            this.isPromo = z;
        }

        public String a() {
            return this.price;
        }

        public String b() {
            return this.itemId;
        }

        public Integer c() {
            return this.appPoints;
        }

        public String d() {
            return this.name;
        }

        public String e() {
            return this.iconUrl;
        }

        public boolean f() {
            return this.isPromo;
        }

        public String g() {
            return this.mCurrencyIconUrl;
        }

        public void a(String str) {
            this.mCurrencyIconUrl = str;
        }

        public long h() {
            return this.rebateId;
        }

        public void a(long j) {
            this.rebateId = j;
        }
    }

    /* renamed from: com.garena.pay.android.a.b$b  reason: collision with other inner class name */
    public static class C0136b implements Serializable {
        private String channelId;
        private String description;
        private float discount;
        private String iconUrl;
        private List<a> items;
        private String name;

        public List<a> a() {
            return this.items;
        }

        public boolean b() {
            List<a> list = this.items;
            return list == null || list.size() == 0;
        }

        public a a(String str) {
            List<a> list = this.items;
            if (list == null) {
                return null;
            }
            for (a next : list) {
                if (next.b().equalsIgnoreCase(str)) {
                    return next;
                }
            }
            return null;
        }

        public void a(List<a> list) {
            this.items = list;
        }

        public String c() {
            return this.channelId;
        }

        public void b(String str) {
            this.channelId = str;
        }

        public String d() {
            return this.name;
        }

        public void c(String str) {
            this.name = str;
        }

        public String e() {
            return this.iconUrl;
        }

        public void d(String str) {
            this.iconUrl = str;
        }

        public void a(float f2) {
            this.discount = f2;
        }

        public void e(String str) {
            this.description = str;
        }
    }
}
