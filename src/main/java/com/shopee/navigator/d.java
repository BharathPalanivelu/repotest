package com.shopee.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.a.o;

public class d {
    public static Intent a(Context context, Class<? extends Activity> cls, o oVar) {
        if (oVar == null) {
            oVar = new o();
        }
        Intent intent = new Intent(context, cls);
        intent.putExtra("PUSH_DATA_KEY", oVar.toString());
        return intent;
    }

    public static <T> T a(Intent intent, Class<T> cls) {
        return b.fromJson(new c(intent).d(), cls);
    }

    public static o a(o oVar, o oVar2) {
        for (String next : oVar.q()) {
            if (!oVar2.b(next)) {
                oVar2.a(next, oVar.c(next));
            }
        }
        return oVar2;
    }
}
