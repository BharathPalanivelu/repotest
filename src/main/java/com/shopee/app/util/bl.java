package com.shopee.app.util;

import android.net.Uri;
import android.webkit.URLUtil;
import com.facebook.share.internal.ShareConstants;
import com.shopee.arcatch.data.common_bean.Country;
import com.tencent.qcloud.core.util.IOUtils;
import d.a.ae;
import d.d.b.j;
import d.h.m;
import java.util.HashSet;

public final class bl {

    /* renamed from: a  reason: collision with root package name */
    public static final bl f7034a = new bl();

    /* renamed from: b  reason: collision with root package name */
    private static int f7035b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final String f7036c = f7036c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashSet<String> f7037d = ae.a("com.scb.phone");

    private final String b(int i) {
        return i != 0 ? i != 1 ? (i == 2 || i != 3) ? "" : "uat." : "staging." : "test.";
    }

    private bl() {
    }

    public final void a(int i) {
        f7035b = i;
    }

    public final String a() {
        return a("aggregation#home_tab");
    }

    public final String b() {
        return a("setup");
    }

    public final String a(String str) {
        return "https://live." + d() + "shopee" + e() + IOUtils.DIR_SEPARATOR_UNIX + str;
    }

    public final String c() {
        return "https://feeds." + d() + "shopee" + e();
    }

    public final String b(String str) {
        if (!URLUtil.isNetworkUrl(str)) {
            return "https://h5." + d() + "lenteradana" + e() + "/?channel=mepage";
        } else if (str != null) {
            return str;
        } else {
            j.a();
            return str;
        }
    }

    private final String d() {
        return b(f7035b);
    }

    private final String e() {
        return d("ID");
    }

    private final String d(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 2331) {
            if (hashCode != 2476) {
                if (hashCode != 2552) {
                    if (hashCode != 2644) {
                        if (hashCode != 2676) {
                            if (hashCode != 2691) {
                                if (hashCode == 2744 && str.equals(Country.COUNTRY_VN)) {
                                    return ".vn";
                                }
                            } else if (str.equals(Country.COUNTRY_TW)) {
                                return ".tw";
                            }
                        } else if (str.equals(Country.COUNTRY_TH)) {
                            return ".co.th";
                        }
                    } else if (str.equals(Country.COUNTRY_SG)) {
                        return ".sg";
                    }
                } else if (str.equals(Country.COUNTRY_PH)) {
                    return ".ph";
                }
            } else if (str.equals(Country.COUNTRY_MY)) {
                return ".com.my";
            }
        } else if (str.equals("ID")) {
            return ".co.id";
        }
        return "";
    }

    public static final boolean c(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || m.a(charSequence)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String str2 = f7036c;
        j.a((Object) parse, ShareConstants.MEDIA_URI);
        if (!j.a((Object) str2, (Object) parse.getHost())) {
            return false;
        }
        String queryParameter = parse.getQueryParameter("id");
        return queryParameter != null && f7037d.contains(queryParameter);
    }
}
