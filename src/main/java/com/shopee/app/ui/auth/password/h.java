package com.shopee.app.ui.auth.password;

import com.rengwuxian.materialedittext.a.b;
import com.shopee.id.R;

public class h extends b {
    public static h b() {
        return new h(com.garena.android.appkit.tools.b.e(R.string.sp_error_password_format));
    }

    private h(String str) {
        super(str);
    }

    public boolean a(CharSequence charSequence, boolean z) {
        return charSequence.length() >= 6 && charSequence.length() <= 16;
    }
}
