package com.garena.reactpush.a;

import android.app.Dialog;
import android.content.Context;

public class b extends Dialog {
    public b(Context context, int i, String str, Throwable th) {
        super(context, 16973832);
        requestWindowFeature(1);
        c cVar = new c(context, i, str, th);
        cVar.setDialog(this);
        setContentView(cVar);
    }
}
