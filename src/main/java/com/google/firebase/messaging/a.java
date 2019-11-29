package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f14202a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: b  reason: collision with root package name */
    private static a f14203b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f14204c;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f14203b == null) {
                f14203b = new a(FirebaseInstanceId.getInstance());
            }
            aVar = f14203b;
        }
        return aVar;
    }

    private a(FirebaseInstanceId firebaseInstanceId) {
        this.f14204c = firebaseInstanceId;
    }

    public Task<Void> a(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
            str = str.substring(8);
        }
        if (str == null || !f14202a.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
            sb.append("Invalid topic name: ");
            sb.append(str);
            sb.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(sb.toString());
        }
        FirebaseInstanceId firebaseInstanceId = this.f14204c;
        String valueOf = String.valueOf(str);
        return firebaseInstanceId.zza(valueOf.length() != 0 ? "S!".concat(valueOf) : new String("S!"));
    }
}
