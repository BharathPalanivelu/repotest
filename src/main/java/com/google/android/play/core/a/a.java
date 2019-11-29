package com.google.android.play.core.a;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f13569a;

    public a(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        String valueOf2 = String.valueOf(str);
        this.f13569a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private int a(int i, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return Log.i("PlayCore", a(this.f13569a, str, objArr));
        }
        return 0;
    }

    private static String a(String str, String str2, Object... objArr) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        String sb2 = sb.toString();
        if (objArr == null || objArr.length <= 0) {
            return sb2;
        }
        try {
            return String.format(Locale.US, sb2, objArr);
        } catch (IllegalFormatException e2) {
            String valueOf = String.valueOf(sb2);
            Log.e("PlayCore", valueOf.length() != 0 ? "Unable to format ".concat(valueOf) : new String("Unable to format "), e2);
            String valueOf2 = String.valueOf(sb2);
            String join = TextUtils.join(", ", objArr);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 3 + String.valueOf(join).length());
            sb3.append(valueOf2);
            sb3.append(" [");
            sb3.append(join);
            sb3.append("]");
            return sb3.toString();
        }
    }

    public int a(String str, Object... objArr) {
        return a(4, str, objArr);
    }

    public int b(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public int c(String str, Object... objArr) {
        return a(5, str, objArr);
    }
}
