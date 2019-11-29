package com.shopee.live.livestreaming.util.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f29425a = {"copyInfo", "copyLink", "sms", "email"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f29426b = {"whatsapp", "facebookMessenger", "twitter"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f29427c = {"whatsapp", "facebookMessenger", "twitter", "lineChat", "facebookLink", "instagram"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f29428d = {"whatsapp", "lineChat", "facebookLink"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f29429e = {"whatsapp", "lineChat", "facebookLink", "instagram", "facebookMessenger", "twitter"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f29430f = {"lineChat", "facebookMessenger", "twitter"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f29431g = {"lineChat", "facebookMessenger", "twitter", "facebookLink", "instagram", "whatsapp"};
    public static final String[] h = {"facebookMessenger", "facebookLink", "whatsapp"};
    public static final String[] i = {"facebookMessenger", "facebookLink", "whatsapp", "lineChat", "instagram", "twitter"};
    public static final String[] j = {"lineChat", "facebookMessenger", "whatsapp"};
    public static final String[] k = {"lineChat", "facebookMessenger", "whatsapp", "facebookLink", "instagram"};
    public static final String[] l = {"facebookMessenger", "whatsapp", "facebookLink"};
    public static final String[] m = {"facebookMessenger", "whatsapp", "facebookLink", "instagram"};
    public static final String[] n = {"whatsapp", "facebookMessenger", "lineChat"};
    public static final String[] o = {"whatsapp", "facebookMessenger", "lineChat", "facebookLink", "instagram", "twitter"};

    public static String[] a() {
        return f29427c;
    }

    public static String a(String str) {
        if ("copyInfo".equals(str)) {
            return "#copy_info";
        }
        if ("copyLink".equals(str)) {
            return "#copy_link";
        }
        if ("sms".equals(str)) {
            return "#sms";
        }
        if ("email".equals(str)) {
            return "#email";
        }
        if ("whatsapp".equals(str)) {
            return "#whatsapp";
        }
        if ("lineChat".equals(str)) {
            return "#line";
        }
        if ("twitter".equals(str)) {
            return "#twitter";
        }
        if ("facebookMessenger".equals(str)) {
            return "#fb_messenger";
        }
        if ("facebookLink".equals(str)) {
            return "#facebook";
        }
        return "instagram".equals(str) ? "#instagram" : "";
    }
}
