package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.i;
import androidx.core.content.b;
import com.google.android.gms.common.util.PlatformVersion;
import com.salesforce.android.chat.core.model.PreChatField;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.tls.platform.SigType;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f14208a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* renamed from: b  reason: collision with root package name */
    private final Context f14209b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14210c;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f14211d;

    public e(Context context, String str) {
        this.f14209b = context;
        this.f14210c = str;
    }

    public final d a(Bundle bundle) {
        Uri uri;
        Intent intent;
        PendingIntent pendingIntent;
        i.d dVar = new i.d(this.f14209b, c(a(bundle, "gcm.n.android_channel_id")));
        dVar.e(true);
        dVar.a(e(bundle));
        String d2 = d(bundle, "gcm.n.body");
        if (!TextUtils.isEmpty(d2)) {
            dVar.b((CharSequence) d2);
            dVar.a((i.g) new i.c().b(d2));
        }
        dVar.a(a(a(bundle, "gcm.n.icon")));
        String c2 = c(bundle);
        PendingIntent pendingIntent2 = null;
        if (TextUtils.isEmpty(c2)) {
            uri = null;
        } else if ("default".equals(c2) || this.f14209b.getResources().getIdentifier(c2, "raw", this.f14210c) == 0) {
            uri = RingtoneManager.getDefaultUri(2);
        } else {
            String str = this.f14210c;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(c2).length());
            sb.append("android.resource://");
            sb.append(str);
            sb.append("/raw/");
            sb.append(c2);
            uri = Uri.parse(sb.toString());
        }
        if (uri != null) {
            dVar.a(uri);
        }
        String a2 = a(bundle, "gcm.n.click_action");
        if (!TextUtils.isEmpty(a2)) {
            intent = new Intent(a2);
            intent.setPackage(this.f14210c);
            intent.setFlags(SigType.TLS);
        } else {
            Uri d3 = d(bundle);
            if (d3 != null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(this.f14210c);
                intent.setData(d3);
            } else {
                intent = this.f14209b.getPackageManager().getLaunchIntentForPackage(this.f14210c);
                if (intent == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        }
        if (intent == null) {
            pendingIntent = null;
        } else {
            intent.addFlags(67108864);
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2 != null && str2.startsWith("google.c.")) {
                    it.remove();
                }
            }
            intent.putExtras(bundle2);
            for (String str3 : bundle2.keySet()) {
                if (str3.startsWith("gcm.n.") || str3.startsWith("gcm.notification.")) {
                    intent.removeExtra(str3);
                }
            }
            pendingIntent = PendingIntent.getActivity(this.f14209b, f14208a.incrementAndGet(), intent, 1073741824);
            if (f(bundle)) {
                Intent intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                a(intent2, bundle);
                intent2.putExtra("pending_intent", pendingIntent);
                pendingIntent = a(f14208a.incrementAndGet(), intent2);
            }
        }
        dVar.a(pendingIntent);
        if (f(bundle)) {
            Intent intent3 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
            a(intent3, bundle);
            pendingIntent2 = a(f14208a.incrementAndGet(), intent3);
        }
        if (pendingIntent2 != null) {
            dVar.b(pendingIntent2);
        }
        Integer b2 = b(a(bundle, "gcm.n.color"));
        if (b2 != null) {
            dVar.e(b2.intValue());
        }
        String a3 = a(bundle, "gcm.n.tag");
        if (TextUtils.isEmpty(a3)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("FCM-Notification:");
            sb2.append(uptimeMillis);
            a3 = sb2.toString();
        }
        return new d(dVar, a3, 0);
    }

    private final CharSequence e(Bundle bundle) {
        String d2 = d(bundle, "gcm.n.title");
        if (!TextUtils.isEmpty(d2)) {
            return d2;
        }
        try {
            return b(0).loadLabel(this.f14209b.getPackageManager());
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.e("FirebaseMessaging", sb.toString());
            return "";
        }
    }

    public static boolean b(Bundle bundle) {
        return "1".equals(a(bundle, "gcm.n.e")) || a(bundle, "gcm.n.icon") != null;
    }

    public static String a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    public static Object[] b(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String a2 = a(bundle, "_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(a2);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return objArr;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(str);
            String substring = ("_loc_args".length() != 0 ? valueOf2.concat("_loc_args") : new String(valueOf2)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(a2).length());
            sb.append("Malformed ");
            sb.append(substring);
            sb.append(": ");
            sb.append(a2);
            sb.append("  Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
    }

    private final String d(Bundle bundle, String str) {
        String a2 = a(bundle, str);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return e(bundle, str);
    }

    public static String c(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        return a(bundle, "_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    private final String e(Bundle bundle, String str) {
        String c2 = c(bundle, str);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        Resources resources = this.f14209b.getResources();
        int identifier = resources.getIdentifier(c2, PreChatField.STRING, this.f14210c);
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String substring = ("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(str).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(str);
            sb.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
        Object[] b2 = b(bundle, str);
        if (b2 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, b2);
        } catch (MissingFormatArgumentException e2) {
            String arrays = Arrays.toString(b2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString(), e2);
            return null;
        }
    }

    @TargetApi(26)
    private final boolean a(int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.f14209b.getResources().getDrawable(i, (Resources.Theme) null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    private final int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.f14209b.getResources();
            int identifier = resources.getIdentifier(str, "drawable", this.f14210c);
            if (identifier != 0 && a(identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str, "mipmap", this.f14210c);
            if (identifier2 != 0 && a(identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("Icon resource ");
            sb.append(str);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i = a().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !a(i)) {
            try {
                i = b(0).icon;
            } catch (PackageManager.NameNotFoundException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        if (i == 0 || !a(i)) {
            return 17301651;
        }
        return i;
    }

    private final Integer b(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
                sb.append("Color ");
                sb.append(str);
                sb.append(" not valid. Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = a().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(b.c(this.f14209b, i));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    public static String c(Bundle bundle) {
        String a2 = a(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(a2) ? a(bundle, "gcm.n.sound") : a2;
    }

    static Uri d(Bundle bundle) {
        String a2 = a(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(a2)) {
            a2 = a(bundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty(a2)) {
            return Uri.parse(a2);
        }
        return null;
    }

    private final synchronized Bundle a() {
        if (this.f14211d != null) {
            return this.f14211d;
        }
        try {
            ApplicationInfo b2 = b(128);
            if (!(b2 == null || b2.metaData == null)) {
                this.f14211d = b2.metaData;
                return this.f14211d;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    private final String c(String str) {
        if (!PlatformVersion.isAtLeastO()) {
            return null;
        }
        int i = 0;
        try {
            i = b(0).targetSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (i < 26) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.f14209b.getSystemService(NotificationManager.class);
        if (!TextUtils.isEmpty(str)) {
            if (notificationManager.getNotificationChannel(str) != null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
            sb.append("Notification Channel requested (");
            sb.append(str);
            sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        String string = a().getString("com.google.firebase.messaging.default_notification_channel_id");
        if (TextUtils.isEmpty(string)) {
            Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
        } else if (notificationManager.getNotificationChannel(string) != null) {
            return string;
        } else {
            Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
        }
        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.f14209b.getString(this.f14209b.getResources().getIdentifier("fcm_fallback_notification_channel_label", PreChatField.STRING, this.f14210c)), 3));
        }
        return "fcm_fallback_notification_channel";
    }

    private final ApplicationInfo b(int i) throws PackageManager.NameNotFoundException {
        return this.f14209b.getPackageManager().getApplicationInfo(this.f14210c, i);
    }

    private static void a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private final PendingIntent a(int i, Intent intent) {
        return PendingIntent.getBroadcast(this.f14209b, i, new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(this.f14209b, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }

    private static boolean f(Bundle bundle) {
        return bundle != null && "1".equals(bundle.getString("google.c.a.e"));
    }
}
