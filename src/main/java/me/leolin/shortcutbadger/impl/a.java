package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.b;

public class a implements me.leolin.shortcutbadger.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33809a = "a";

    public void a(Context context, ComponentName componentName, int i) throws b {
        String className = componentName.getClassName();
        if (className == null) {
            Log.d(f33809a, "Main activity is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", className);
        bundle.putInt("badgenumber", i);
        context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
    }

    public List<String> a() {
        return Arrays.asList(new String[]{"com.huawei.android.launcher"});
    }
}
