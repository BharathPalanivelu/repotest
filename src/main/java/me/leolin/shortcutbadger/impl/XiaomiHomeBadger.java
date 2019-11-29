package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.appsflyer.share.Constants;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.a;
import me.leolin.shortcutbadger.b;

public class XiaomiHomeBadger implements a {
    public void a(Context context, ComponentName componentName, int i) throws b {
        Object obj;
        Object obj2 = "";
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            if (i == 0) {
                obj = obj2;
            } else {
                obj = Integer.valueOf(i);
            }
            declaredField.set(newInstance, String.valueOf(obj));
        } catch (Exception unused) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", componentName.getPackageName() + Constants.URL_PATH_DELIMITER + componentName.getClassName());
            if (i != 0) {
                obj2 = Integer.valueOf(i);
            }
            intent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(obj2));
            if (me.leolin.shortcutbadger.a.a.a(context, intent)) {
                context.sendBroadcast(intent);
                return;
            }
            throw new b("unable to resolve intent: " + intent.toString());
        }
    }

    public List<String> a() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2"});
    }
}
