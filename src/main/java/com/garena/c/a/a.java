package com.garena.c.a;

import android.text.TextUtils;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public float f7799a;

    /* renamed from: b  reason: collision with root package name */
    public float f7800b;

    /* renamed from: c  reason: collision with root package name */
    public String f7801c;

    /* renamed from: d  reason: collision with root package name */
    public String f7802d;

    public String toString() {
        return "BBLocationInfo{latitude=" + this.f7799a + ", longitude=" + this.f7800b + '}';
    }

    public String a() {
        return String.format(Locale.ENGLISH, "%f,%f", new Object[]{Float.valueOf(this.f7799a), Float.valueOf(this.f7800b)});
    }

    public String b() {
        String str = this.f7801c;
        if (str == null) {
            str = SQLBuilder.BLANK;
        }
        String str2 = TextUtils.isEmpty(this.f7802d) ? str : this.f7802d;
        Locale locale = Locale.ENGLISH;
        return String.format(locale, "%f;%f;%s;%s", new Object[]{Float.valueOf(this.f7799a), Float.valueOf(this.f7800b), URLEncoder.encode(str + SQLBuilder.BLANK), URLEncoder.encode(str2)});
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(";");
                if (split.length == 4) {
                    this.f7799a = Float.valueOf(split[0]).floatValue();
                    this.f7800b = Float.valueOf(split[1]).floatValue();
                    this.f7801c = URLDecoder.decode(split[2]);
                    this.f7802d = URLDecoder.decode(split[3]);
                }
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }
}
