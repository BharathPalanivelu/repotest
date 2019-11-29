package com.shopee.app.ui.product.b;

import com.garena.android.appkit.tools.b;
import com.shopee.app.util.q.c;
import com.shopee.id.R;
import d.d.b.j;

public final class a implements c {
    public String a() {
        return "";
    }

    public String f() {
        return "";
    }

    public String a(int i, int i2) {
        String a2 = b.a(R.string.sp_x_more_chars, Integer.valueOf(i2 - i));
        j.a((Object) a2, "BBAppResource.string(R.s…requiredLen - currentLen)");
        return a2;
    }

    public String b() {
        String e2 = b.e(R.string.sp_warn_input_invalid_chars);
        j.a((Object) e2, "BBAppResource.string(R.s…warn_input_invalid_chars)");
        return e2;
    }

    public String c() {
        String e2 = b.e(R.string.sp_error_product_title_too_short);
        j.a((Object) e2, "BBAppResource.string(R.s…_product_title_too_short)");
        return e2;
    }

    public String d() {
        String e2 = b.e(R.string.sp_error_product_title_too_long);
        j.a((Object) e2, "BBAppResource.string(R.s…r_product_title_too_long)");
        return e2;
    }

    public String e() {
        String e2 = b.e(R.string.sp_error_product_title_contains_invalid_chars);
        j.a((Object) e2, "BBAppResource.string(R.s…e_contains_invalid_chars)");
        return e2;
    }

    public String b(int i, int i2) {
        String a2 = b.a(R.string.sp_x_more_chars, Integer.valueOf(i2 - i));
        j.a((Object) a2, "BBAppResource.string(R.s…requiredLen - currentLen)");
        return a2;
    }

    public String g() {
        String e2 = b.e(R.string.sp_error_product_desc_too_short);
        j.a((Object) e2, "BBAppResource.string(R.s…r_product_desc_too_short)");
        return e2;
    }

    public String h() {
        String e2 = b.e(R.string.sp_error_product_desc_too_long);
        j.a((Object) e2, "BBAppResource.string(R.s…or_product_desc_too_long)");
        return e2;
    }

    public String c(int i, int i2) {
        String a2 = b.a(R.string.sp_x_more_images, Integer.valueOf(i2 - i));
        j.a((Object) a2, "BBAppResource.string(R.s…edImages - currentImages)");
        return a2;
    }
}
