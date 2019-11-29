package com.dieam.reactnativepushnotification.modules;

import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.i;
import com.appsflyer.share.Constants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6647c = false;

    /* renamed from: a  reason: collision with root package name */
    private Context f6648a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f6649b;

    public b(Application application) {
        this.f6648a = application;
        this.f6649b = application.getSharedPreferences("rn_push_notification", 0);
    }

    public Class a() {
        try {
            return Class.forName(this.f6648a.getPackageManager().getLaunchIntentForPackage(this.f6648a.getPackageName()).getComponent().getClassName());
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private AlarmManager d() {
        return (AlarmManager) this.f6648a.getSystemService("alarm");
    }

    private PendingIntent d(Bundle bundle) {
        int parseInt = Integer.parseInt(bundle.getString("id"));
        Intent intent = new Intent(this.f6648a, RNPushNotificationPublisher.class);
        intent.putExtra("notificationId", parseInt);
        intent.putExtras(bundle);
        return PendingIntent.getBroadcast(this.f6648a, parseInt, intent, 134217728);
    }

    public void a(Bundle bundle) {
        if (a() == null) {
            Log.e(RNPushNotification.LOG_TAG, "No activity class found for the scheduled notification");
        } else if (bundle.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE) == null) {
            Log.e(RNPushNotification.LOG_TAG, "No message specified for the scheduled notification");
        } else if (bundle.getString("id") == null) {
            Log.e(RNPushNotification.LOG_TAG, "No notification ID specified for the scheduled notification");
        } else if (bundle.getDouble("fireDate") == 0.0d) {
            Log.e(RNPushNotification.LOG_TAG, "No date specified for the scheduled notification");
        } else {
            a aVar = new a(bundle);
            String c2 = aVar.c();
            Log.d(RNPushNotification.LOG_TAG, "Storing push notification with id " + c2);
            SharedPreferences.Editor edit = this.f6649b.edit();
            edit.putString(c2, aVar.b().toString());
            a(edit);
            if (!this.f6649b.contains(c2)) {
                Log.e(RNPushNotification.LOG_TAG, "Failed to save " + c2);
            }
            b(bundle);
        }
    }

    public void b(Bundle bundle) {
        long j = (long) bundle.getDouble("fireDate");
        PendingIntent d2 = d(bundle);
        Log.d(RNPushNotification.LOG_TAG, String.format("Setting a notification with id %s at time %s", new Object[]{bundle.getString("id"), Long.toString(j)}));
        if (Build.VERSION.SDK_INT >= 19) {
            d().setExact(0, j, d2);
        } else {
            d().set(0, j, d2);
        }
    }

    public void c(Bundle bundle) {
        String str;
        int identifier;
        int i;
        JSONArray jSONArray;
        int i2;
        Bundle bundle2 = bundle;
        try {
            Class a2 = a();
            if (a2 == null) {
                Log.e(RNPushNotification.LOG_TAG, "No activity class found for the notification");
            } else if (bundle2.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE) == null) {
                Log.d(RNPushNotification.LOG_TAG, "Cannot send to notification centre because there is no 'message' field in: " + bundle2);
            } else {
                String string = bundle2.getString("id");
                if (string == null) {
                    Log.e(RNPushNotification.LOG_TAG, "No notification ID specified for the notification");
                    return;
                }
                Resources resources = this.f6648a.getResources();
                String packageName = this.f6648a.getPackageName();
                String string2 = bundle2.getString("title");
                if (string2 == null) {
                    string2 = this.f6648a.getPackageManager().getApplicationLabel(this.f6648a.getApplicationInfo()).toString();
                }
                Context context = this.f6648a;
                String str2 = RNPushNotification.LOG_TAG;
                try {
                    i.d e2 = new i.d(context, "rn-push-notification-channel-id").a((CharSequence) string2).e((CharSequence) bundle2.getString("ticker")).f(0).d(1).e(bundle2.getBoolean("autoCancel", true));
                    String string3 = bundle2.getString("group");
                    if (string3 != null) {
                        e2.c(string3);
                    }
                    e2.b((CharSequence) bundle2.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
                    String string4 = bundle2.getString("largeIcon");
                    String string5 = bundle2.getString("subText");
                    if (string5 != null) {
                        e2.c((CharSequence) string5);
                    }
                    String string6 = bundle2.getString("number");
                    if (string6 != null) {
                        e2.b(Integer.parseInt(string6));
                    }
                    String string7 = bundle2.getString("smallIcon");
                    if (string7 != null) {
                        identifier = resources.getIdentifier(string7, "mipmap", packageName);
                    } else {
                        identifier = resources.getIdentifier("ic_notification", "mipmap", packageName);
                    }
                    String str3 = "vibrate";
                    if (identifier == 0) {
                        identifier = resources.getIdentifier("ic_launcher", "mipmap", packageName);
                        if (identifier == 0) {
                            identifier = 17301659;
                        }
                    }
                    if (string4 != null) {
                        i = resources.getIdentifier(string4, "mipmap", packageName);
                    } else {
                        i = resources.getIdentifier("ic_launcher", "mipmap", packageName);
                    }
                    Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
                    if (i != 0 && (string4 != null || Build.VERSION.SDK_INT >= 21)) {
                        e2.a(decodeResource);
                    }
                    e2.a(identifier);
                    String string8 = bundle2.getString("bigText");
                    if (string8 == null) {
                        string8 = bundle2.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    }
                    e2.a((i.g) new i.c().b(string8));
                    Intent intent = new Intent(this.f6648a, a2);
                    intent.addFlags(536870912);
                    bundle2.putBoolean("userInteraction", true);
                    intent.putExtra("notification", bundle2);
                    if (!bundle2.containsKey("playSound") || bundle2.getBoolean("playSound")) {
                        Uri defaultUri = RingtoneManager.getDefaultUri(2);
                        String string9 = bundle2.getString("soundName");
                        if (string9 != null && !"default".equalsIgnoreCase(string9)) {
                            if (this.f6648a.getResources().getIdentifier(string9, "raw", this.f6648a.getPackageName()) != 0) {
                                i2 = this.f6648a.getResources().getIdentifier(string9, "raw", this.f6648a.getPackageName());
                            } else {
                                i2 = this.f6648a.getResources().getIdentifier(string9.substring(0, string9.lastIndexOf(46)), "raw", this.f6648a.getPackageName());
                            }
                            defaultUri = Uri.parse("android.resource://" + this.f6648a.getPackageName() + Constants.URL_PATH_DELIMITER + i2);
                        }
                        e2.a(defaultUri);
                    }
                    if (bundle2.containsKey("ongoing") || bundle2.getBoolean("ongoing")) {
                        e2.c(bundle2.getBoolean("ongoing"));
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        e2.a("call");
                        String string10 = bundle2.getString(ViewProps.COLOR);
                        if (string10 != null) {
                            e2.e(Color.parseColor(string10));
                        }
                    }
                    int parseInt = Integer.parseInt(string);
                    PendingIntent activity = PendingIntent.getActivity(this.f6648a, parseInt, intent, 134217728);
                    NotificationManager e3 = e();
                    a(e3);
                    e2.a(activity);
                    String str4 = str3;
                    if (!bundle2.containsKey(str4) || bundle2.getBoolean(str4)) {
                        long j = bundle2.containsKey("vibration") ? (long) bundle2.getDouble("vibration") : 300;
                        if (j == 0) {
                            j = 300;
                        }
                        e2.a(new long[]{0, j});
                    }
                    try {
                        jSONArray = bundle2.getString("actions") != null ? new JSONArray(bundle2.getString("actions")) : null;
                        str = str2;
                    } catch (JSONException e4) {
                        str = str2;
                        try {
                            Log.e(str, "Exception while converting actions to JSON object.", e4);
                            jSONArray = null;
                        } catch (Exception e5) {
                            e = e5;
                            Log.e(str, "failed to send push notification", e);
                        }
                    }
                    if (jSONArray != null) {
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            try {
                                String string11 = jSONArray.getString(i3);
                                Intent intent2 = new Intent();
                                intent2.setAction(this.f6648a.getPackageName() + "." + string11);
                                bundle2.putString("action", string11);
                                intent2.putExtra("notification", bundle2);
                                e2.a(0, (CharSequence) string11, PendingIntent.getBroadcast(this.f6648a, parseInt, intent2, 134217728));
                            } catch (JSONException e6) {
                                Log.e(str, "Exception while getting action from actionsArray.", e6);
                            }
                        }
                    }
                    if (this.f6649b.getString(string, (String) null) != null) {
                        SharedPreferences.Editor edit = this.f6649b.edit();
                        edit.remove(string);
                        a(edit);
                    }
                    Notification b2 = e2.b();
                    b2.defaults |= 4;
                    if (bundle2.containsKey("tag")) {
                        e3.notify(bundle2.getString("tag"), parseInt, b2);
                    } else {
                        e3.notify(parseInt, b2);
                    }
                    e(bundle);
                } catch (Exception e7) {
                    e = e7;
                    str = str2;
                    Log.e(str, "failed to send push notification", e);
                }
            }
        } catch (Exception e8) {
            e = e8;
            str = RNPushNotification.LOG_TAG;
            Log.e(str, "failed to send push notification", e);
        }
    }

    private void e(Bundle bundle) {
        long j;
        long j2;
        Bundle bundle2 = bundle;
        String string = bundle2.getString("repeatType");
        long j3 = (long) bundle2.getDouble("repeatTime");
        if (string != null) {
            long j4 = (long) bundle2.getDouble("fireDate");
            if (!Arrays.asList(new String[]{"time", "week", "day", "hour", "minute"}).contains(string)) {
                Log.w(RNPushNotification.LOG_TAG, String.format("Invalid repeatType specified as %s", new Object[]{string}));
            } else if (!"time".equals(string) || j3 > 0) {
                char c2 = 65535;
                switch (string.hashCode()) {
                    case -1074026988:
                        if (string.equals("minute")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 99228:
                        if (string.equals("day")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3208676:
                        if (string.equals("hour")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3560141:
                        if (string.equals("time")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3645428:
                        if (string.equals("week")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        j2 = 604800000;
                    } else if (c2 == 2) {
                        j2 = 86400000;
                    } else if (c2 == 3) {
                        j2 = 3600000;
                    } else if (c2 != 4) {
                        j = 0;
                    } else {
                        j2 = 60000;
                    }
                    j = j2 + j4;
                } else {
                    j = j3 + j4;
                }
                if (j != 0) {
                    Log.d(RNPushNotification.LOG_TAG, String.format("Repeating notification with id %s at time %s", new Object[]{bundle2.getString("id"), Long.toString(j)}));
                    bundle2.putDouble("fireDate", (double) j);
                    a(bundle);
                }
            } else {
                Log.w(RNPushNotification.LOG_TAG, "repeatType specified as time but no repeatTime has been mentioned");
            }
        }
    }

    public void b() {
        Log.i(RNPushNotification.LOG_TAG, "Clearing alerts from the notification centre");
        e().cancelAll();
    }

    public void c() {
        Log.i(RNPushNotification.LOG_TAG, "Cancelling all notifications");
        for (String a2 : this.f6649b.getAll().keySet()) {
            a(a2);
        }
    }

    public void a(ReadableMap readableMap) {
        for (String next : this.f6649b.getAll().keySet()) {
            try {
                String string = this.f6649b.getString(next, (String) null);
                if (string != null && a.a(string).a(readableMap)) {
                    a(next);
                }
            } catch (JSONException e2) {
                Log.w(RNPushNotification.LOG_TAG, "Problem dealing with scheduled notification " + next, e2);
            }
        }
    }

    private void a(String str) {
        Log.i(RNPushNotification.LOG_TAG, "Cancelling notification: " + str);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        d().cancel(d(bundle));
        if (this.f6649b.contains(str)) {
            SharedPreferences.Editor edit = this.f6649b.edit();
            edit.remove(str);
            a(edit);
        } else {
            Log.w(RNPushNotification.LOG_TAG, "Unable to find notification " + str);
        }
        e().cancel(Integer.parseInt(str));
    }

    private NotificationManager e() {
        return (NotificationManager) this.f6648a.getSystemService("notification");
    }

    private static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    private static void a(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= 26 && !f6647c && notificationManager != null) {
            NotificationChannel notificationChannel = new NotificationChannel("rn-push-notification-channel-id", "rn-push-notification-channel", 3);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
            f6647c = true;
        }
    }
}
