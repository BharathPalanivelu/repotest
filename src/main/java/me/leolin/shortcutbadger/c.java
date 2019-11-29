package me.leolin.shortcutbadger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import me.leolin.shortcutbadger.impl.ApexHomeBadger;
import me.leolin.shortcutbadger.impl.AsusHomeLauncher;
import me.leolin.shortcutbadger.impl.DefaultBadger;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import me.leolin.shortcutbadger.impl.NovaHomeBadger;
import me.leolin.shortcutbadger.impl.SonyHomeBadger;
import me.leolin.shortcutbadger.impl.XiaomiHomeBadger;
import me.leolin.shortcutbadger.impl.a;
import me.leolin.shortcutbadger.impl.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Class<? extends a>> f33803a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private static a f33804b;

    /* renamed from: c  reason: collision with root package name */
    private static ComponentName f33805c;

    static {
        f33803a.add(AdwHomeBadger.class);
        f33803a.add(ApexHomeBadger.class);
        f33803a.add(NewHtcHomeBadger.class);
        f33803a.add(NovaHomeBadger.class);
        f33803a.add(SonyHomeBadger.class);
        f33803a.add(XiaomiHomeBadger.class);
        f33803a.add(AsusHomeLauncher.class);
        f33803a.add(a.class);
        f33803a.add(b.class);
    }

    public static boolean a(Context context, int i) {
        try {
            b(context, i);
            return true;
        } catch (b e2) {
            Log.e("ShortcutBadger", "Unable to execute badge", e2);
            return false;
        }
    }

    public static void b(Context context, int i) throws b {
        if (f33804b != null || a(context)) {
            try {
                f33804b.a(context, f33805c, i);
            } catch (Exception e2) {
                throw new b("Unable to execute badge", e2);
            }
        } else {
            throw new b("No default launcher available");
        }
    }

    private static boolean a(Context context) {
        a aVar;
        f33805c = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (resolveActivity == null || resolveActivity.activityInfo.name.toLowerCase().contains("resolver")) {
            return false;
        }
        String str = resolveActivity.activityInfo.packageName;
        Iterator<Class<? extends a>> it = f33803a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            try {
                aVar = (a) it.next().newInstance();
            } catch (Exception unused) {
                aVar = null;
            }
            if (aVar != null && aVar.a().contains(str)) {
                f33804b = aVar;
                break;
            }
        }
        if (f33804b != null) {
            return true;
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            f33804b = new XiaomiHomeBadger();
            return true;
        }
        f33804b = new DefaultBadger();
        return true;
    }
}
