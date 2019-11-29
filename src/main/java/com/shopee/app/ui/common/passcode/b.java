package com.shopee.app.ui.common.passcode;

import android.content.Context;
import com.rengwuxian.materialedittext.MaterialEditText;

class b extends MaterialEditText {
    private a i;

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setCursorVisible(true);
    }

    public void a(a aVar) {
        this.i = aVar;
    }
}
