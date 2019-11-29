package com.shopee.app.pushnotification.a.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.i;
import com.garena.android.appkit.d.a;
import com.shopee.app.application.ar;
import com.shopee.app.pushnotification.NotificationData;
import com.shopee.app.pushnotification.e;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static List<e> f18510a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static e f18511b = new e("SOUND_DEFAULT", R.string.sp_label_notification_sound_name_type_1, R.raw.shopee_noti);

    static {
        f18510a.add(f18511b);
        f18510a.add(new e("SOUND_2", R.string.sp_label_notification_sound_name_type_2, R.raw.shopee_noti_2));
        f18510a.add(new e("SOUND_3", R.string.sp_label_notification_sound_name_type_3, R.raw.shopee_noti_3));
        f18510a.add(new e("SOUND_4", R.string.sp_label_notification_sound_name_type_4, R.raw.shopee_noti_4));
        f18510a.add(new e("SOUND_5", R.string.sp_label_notification_sound_name_type_5, R.raw.shopee_noti_5));
        f18510a.add(new e("SOUND_6", R.string.sp_label_notification_sound_name_type_6, R.raw.shopee_noti_6));
    }

    public static e a() {
        ar f2 = ar.f();
        if (f2 != null) {
            return a(f2.e().crossUserStatusStore().g());
        }
        return f18511b;
    }

    public static Uri a(Context context) {
        return a().a(context);
    }

    public static int a(NotificationData notificationData) {
        if (notificationData.isSilentMode()) {
            return -1;
        }
        return notificationData.useCustomSound() ? 1 : 0;
    }

    public static void a(Context context, i.d dVar, int i) {
        if (i == 0) {
            dVar.c(-1);
        } else if (i == 1) {
            dVar.a(a(context));
            dVar.c(6);
        } else if (i == -1) {
            dVar.c(6);
            dVar.a((Uri) null);
        }
    }

    public static void a(Context context, i.d dVar, NotificationData notificationData) {
        a(context, dVar, a(notificationData));
    }

    public static MediaPlayer a(Context context, String str) {
        try {
            MediaPlayer create = MediaPlayer.create(context, a(str).c());
            create.start();
            return create;
        } catch (Exception e2) {
            a.a(e2);
            return null;
        }
    }

    private static e a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "SOUND_DEFAULT";
        }
        for (int i = 0; i < f18510a.size(); i++) {
            e eVar = f18510a.get(i);
            if (eVar.a().equals(str)) {
                return eVar;
            }
        }
        return f18511b;
    }
}
