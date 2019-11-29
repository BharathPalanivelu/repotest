package com.garena.g.a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.garena.g.a;

public class d extends a {
    public d() {
        super("");
    }

    public void a(Context context, a aVar) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(aVar.a(), aVar.b()));
    }
}
