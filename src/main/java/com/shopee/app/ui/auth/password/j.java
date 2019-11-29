package com.shopee.app.ui.auth.password;

import com.rengwuxian.materialedittext.a.b;
import com.shopee.id.R;

public class j extends b {
    public static j b() {
        return new j(com.garena.android.appkit.tools.b.e(R.string.sp_error_password_format_v2));
    }

    private j(String str) {
        super(str);
    }

    public boolean a(CharSequence charSequence, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (Character.isLowerCase(charAt)) {
                z2 = true;
            }
            if (Character.isUpperCase(charAt)) {
                z3 = true;
            }
        }
        if (charSequence.length() < 8 || charSequence.length() > 16 || !z2 || !z3) {
            return false;
        }
        return true;
    }
}
