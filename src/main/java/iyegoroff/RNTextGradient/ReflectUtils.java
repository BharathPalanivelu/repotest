package iyegoroff.RNTextGradient;

import com.facebook.common.logging.FLog;
import com.facebook.react.common.ReactConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ReflectUtils {
    ReflectUtils() {
    }

    static <T> T getFieldValue(Object obj, String str, Class<?> cls) {
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e2) {
            FLog.w(ReactConstants.TAG, "Can't get " + cls.getName() + " field " + str);
            FLog.w(ReactConstants.TAG, e2.getMessage());
            return null;
        }
    }

    static <T> T invokeMethod(Object obj, String str, Class<?> cls) {
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, new Object[0]);
        } catch (Exception e2) {
            FLog.w(ReactConstants.TAG, "Can't invoke " + cls.getName() + " method " + str);
            FLog.w(ReactConstants.TAG, e2.getMessage());
            return null;
        }
    }
}
