package com.android.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.b.m;
import com.appsflyer.share.Constants;
import java.io.File;

public class l {
    public static m a(Context context, f fVar) {
        String str;
        File file = new File(context.getCacheDir(), "volley");
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            str = packageName + Constants.URL_PATH_DELIMITER + packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "volley/0";
        }
        if (fVar == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                fVar = new g();
            } else {
                fVar = new d(AndroidHttpClient.newInstance(str));
            }
        }
        m mVar = new m(new c(file), new a(fVar));
        mVar.a();
        return mVar;
    }

    public static m a(Context context) {
        return a(context, (f) null);
    }
}
