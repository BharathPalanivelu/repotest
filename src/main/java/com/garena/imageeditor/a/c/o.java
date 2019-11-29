package com.garena.imageeditor.a.c;

import android.content.Context;
import jp.co.cyberagent.android.gpuimage.e;

public class o {
    public static e a(Context context, n nVar) {
        switch (nVar) {
            case NONE:
                return new e();
            case NOCTURNE:
                return new a(context);
            case PRELUDE:
                return new b(context);
            case FUGUE:
                return new c(context);
            case HOMOPHONY:
                return new d(context);
            case OVERTURE:
                return new e(context);
            case OPERA:
                return new f(context);
            case SERENADE:
                return new g(context);
            case CHORALE:
                return new h(context);
            case RHAPSODY:
                return new i(context);
            case SYMPHONY:
                return new j(context);
            case ETUDE:
                return new k(context);
            case CANTATA:
                return new l(context);
            case MARCH:
                return new m(context);
            default:
                return null;
        }
    }
}
