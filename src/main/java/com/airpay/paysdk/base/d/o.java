package com.airpay.paysdk.base.d;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.airpay.paysdk.b;
import com.airpay.paysdk.common.b.a;
import java.lang.reflect.Method;

public class o {
    private static void a(Bundle bundle, String str, IBinder iBinder) throws Exception {
        if (a()) {
            bundle.putBinder(str, iBinder);
            return;
        }
        Method declaredMethod = Bundle.class.getDeclaredMethod("putIBinder", new Class[]{String.class, IBinder.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(bundle, new Object[]{str, iBinder});
    }

    private static IBinder a(Bundle bundle, String str) throws Exception {
        if (a()) {
            return bundle.getBinder(str);
        }
        Method declaredMethod = Bundle.class.getDeclaredMethod("getIBinder", new Class[]{String.class});
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(bundle, new Object[]{str});
        if (invoke == null) {
            return null;
        }
        return (IBinder) invoke;
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static void a(Bundle bundle, b bVar) {
        if (bVar != null) {
            try {
                a(bundle, "pay_call", bVar);
            } catch (Exception e2) {
                a.a((Throwable) e2);
            }
        }
    }

    public static b a(Bundle bundle) {
        Object obj;
        if (bundle == null) {
            return null;
        }
        try {
            obj = a(bundle, "pay_call");
        } catch (Exception e2) {
            a.a((Throwable) e2);
            obj = null;
        }
        if (obj instanceof b) {
            return (b) obj;
        }
        return null;
    }
}
