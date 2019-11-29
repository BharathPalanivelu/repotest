package com.tencent.qalsdk.core;

import android.content.Context;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.qalsdk.config.NativeConfigStore;
import com.tencent.qalsdk.util.QLog;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static NativeConfigStore f32198a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f32199b = "MSF.C.MsfStore";

    public static NativeConfigStore a() {
        return f32198a;
    }

    public final synchronized boolean a(Context context) {
        f32198a = new NativeConfigStore(context);
        String a2 = b.a(context);
        if (a2 == null) {
            if (QLog.isColorLevel()) {
                QLog.w(f32199b, 2, "can not load data");
            }
            f32198a.loadSaveRootSucc.set(false);
            return false;
        }
        try {
            context.openFileOutput("QALConfigStore.dat", TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG).close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            f32198a.setSaveRootPath(a2);
            f32198a.loadConfig(context, false);
            return true;
        } catch (Throwable th) {
            String str = f32199b;
            QLog.d(str, 1, "setSaveRootPath or loadConfig failed." + th, th);
            return false;
        }
    }
}
