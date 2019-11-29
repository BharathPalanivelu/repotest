package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.appsflyer.share.Constants;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.a;
import me.leolin.shortcutbadger.b;

public class NovaHomeBadger implements a {
    public void a(Context context, ComponentName componentName, int i) throws b {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", componentName.getPackageName() + Constants.URL_PATH_DELIMITER + componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }

    public List<String> a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }
}
