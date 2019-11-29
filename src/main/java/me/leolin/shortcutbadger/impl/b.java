package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.j256.ormlite.field.FieldType;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.a;

@Deprecated
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f33810a = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "class"};

    public void a(Context context, ComponentName componentName, int i) throws me.leolin.shortcutbadger.b {
        Uri parse = Uri.parse("content://com.sec.badge/apps?notify=true");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(parse, f33810a, "package=?", new String[]{componentName.getPackageName()}, (String) null);
            if (cursor != null) {
                String className = componentName.getClassName();
                boolean z = false;
                while (cursor.moveToNext()) {
                    int i2 = cursor.getInt(0);
                    contentResolver.update(parse, a(componentName, i, false), "_id=?", new String[]{String.valueOf(i2)});
                    if (className.equals(cursor.getString(cursor.getColumnIndex("class")))) {
                        z = true;
                    }
                }
                if (!z) {
                    contentResolver.insert(parse, a(componentName, i, true));
                }
            }
        } finally {
            me.leolin.shortcutbadger.a.b.a(cursor);
        }
    }

    private ContentValues a(ComponentName componentName, int i, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i));
        return contentValues;
    }

    public List<String> a() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }
}
