package a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import java.util.Map;

public final class c {
    public static Bundle a(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Bundle b(Intent intent) {
        Bundle a2 = a(intent);
        if (a2 == null) {
            return null;
        }
        return a2.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
    }

    public static Uri a(Context context, Intent intent) {
        Bundle a2 = a(intent);
        if (a2 != null) {
            String string = a2.getString("target_url");
            if (string != null) {
                j.a(context, "al_nav_in", intent, (Map<String, String>) null);
                return Uri.parse(string);
            }
        }
        return null;
    }
}
