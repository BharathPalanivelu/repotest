package com.google.android.libraries.places.internal;

import com.android.b.a;
import com.android.b.h;
import com.android.b.q;
import com.android.b.r;
import com.android.b.s;
import com.c.a.c.b.o;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.HashMap;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final hd<Class<?>, Integer> f12861a = new he().a(UnknownHostException.class, 7).a(FileNotFoundException.class, Integer.valueOf(PlacesStatusCodes.INVALID_REQUEST)).a();

    static ApiException a(o oVar) {
        int i;
        String str;
        if (oVar != null) {
            HashMap hashMap = new HashMap();
            for (Throwable next : oVar.b()) {
                hashMap.put(next.getClass(), next.getMessage());
            }
            hu huVar = (hu) ((hg) f12861a.keySet()).iterator();
            while (true) {
                if (!huVar.hasNext()) {
                    break;
                }
                Class cls = (Class) huVar.next();
                if (hashMap.containsKey(cls)) {
                    i = f12861a.get(cls).intValue();
                    str = (String) hashMap.get(cls);
                    break;
                }
            }
        }
        i = 13;
        str = "Unknown error during photo loading.";
        return new ApiException(new Status(i, str));
    }

    public static ApiException a(s sVar) {
        int i;
        if (sVar instanceof h) {
            i = 7;
        } else if (sVar instanceof r) {
            i = 15;
        } else {
            i = ((sVar instanceof q) || (sVar instanceof com.android.b.k)) ? 8 : sVar instanceof a ? PlacesStatusCodes.REQUEST_DENIED : 13;
        }
        return new ApiException(new Status(i, sVar.getMessage()));
    }

    static ApiException a(Exception exc) {
        if (exc instanceof ApiException) {
            return (ApiException) exc;
        }
        return new ApiException(new Status(13, exc.getMessage()));
    }

    public static ApiException a(t tVar) {
        return new ApiException(new Status(8, tVar.getMessage()));
    }
}
