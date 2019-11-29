package com.firebase.jobdispatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f7195a;

    f() {
    }

    public Pair<o, Bundle> a(Bundle bundle) {
        if (bundle != null) {
            return b(bundle);
        }
        Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
        return null;
    }

    @SuppressLint({"ParcelClassLoader"})
    private static Pair<o, Bundle> b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Parcel c2 = c(bundle);
        try {
            if (c2.readInt() <= 0) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                return null;
            } else if (c2.readInt() != 1279544898) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                c2.recycle();
                return null;
            } else {
                int readInt = c2.readInt();
                h hVar = null;
                for (int i = 0; i < readInt; i++) {
                    String a2 = a(c2);
                    if (a2 != null) {
                        if (hVar == null) {
                            if ("callback".equals(a2)) {
                                if (c2.readInt() != 4) {
                                    Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                                    c2.recycle();
                                    return null;
                                } else if (!"com.google.android.gms.gcm.PendingCallback".equals(c2.readString())) {
                                    Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                                    c2.recycle();
                                    return null;
                                } else {
                                    hVar = new h(c2.readStrongBinder());
                                }
                            }
                        }
                        Object readValue = c2.readValue((ClassLoader) null);
                        if (readValue instanceof String) {
                            bundle2.putString(a2, (String) readValue);
                        } else if (readValue instanceof Boolean) {
                            bundle2.putBoolean(a2, ((Boolean) readValue).booleanValue());
                        } else if (readValue instanceof Integer) {
                            bundle2.putInt(a2, ((Integer) readValue).intValue());
                        } else if (readValue instanceof ArrayList) {
                            bundle2.putParcelableArrayList(a2, (ArrayList) readValue);
                        } else if (readValue instanceof Bundle) {
                            bundle2.putBundle(a2, (Bundle) readValue);
                        } else if (readValue instanceof Parcelable) {
                            bundle2.putParcelable(a2, (Parcelable) readValue);
                        }
                    }
                }
                if (hVar == null) {
                    Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                    c2.recycle();
                    return null;
                }
                Pair<o, Bundle> create = Pair.create(hVar, bundle2);
                c2.recycle();
                return create;
            }
        } finally {
            c2.recycle();
        }
    }

    private static Parcel c(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        return obtain;
    }

    private static String a(Parcel parcel) {
        if (a()) {
            return parcel.readString();
        }
        Object readValue = parcel.readValue((ClassLoader) null);
        if (readValue instanceof String) {
            return (String) readValue;
        }
        Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        f7195a = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0054 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean a() {
        /*
            java.lang.Class<com.firebase.jobdispatcher.f> r0 = com.firebase.jobdispatcher.f.class
            monitor-enter(r0)
            java.lang.Boolean r1 = f7195a     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x005d
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "key"
            java.lang.String r3 = "value"
            r1.putString(r2, r3)     // Catch:{ all -> 0x0065 }
            android.os.Parcel r1 = c(r1)     // Catch:{ all -> 0x0065 }
            int r2 = r1.readInt()     // Catch:{ RuntimeException -> 0x0054 }
            r3 = 0
            r4 = 1
            if (r2 <= 0) goto L_0x0021
            r2 = 1
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            a((boolean) r2)     // Catch:{ RuntimeException -> 0x0054 }
            int r2 = r1.readInt()     // Catch:{ RuntimeException -> 0x0054 }
            r5 = 1279544898(0x4c444e42, float:5.146036E7)
            if (r2 != r5) goto L_0x0030
            r2 = 1
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            a((boolean) r2)     // Catch:{ RuntimeException -> 0x0054 }
            int r2 = r1.readInt()     // Catch:{ RuntimeException -> 0x0054 }
            if (r2 != r4) goto L_0x003b
            r3 = 1
        L_0x003b:
            a((boolean) r3)     // Catch:{ RuntimeException -> 0x0054 }
            java.lang.String r2 = "key"
            java.lang.String r3 = r1.readString()     // Catch:{ RuntimeException -> 0x0054 }
            boolean r2 = r2.equals(r3)     // Catch:{ RuntimeException -> 0x0054 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ RuntimeException -> 0x0054 }
            f7195a = r2     // Catch:{ RuntimeException -> 0x0054 }
        L_0x004e:
            r1.recycle()     // Catch:{ all -> 0x0065 }
            goto L_0x005d
        L_0x0052:
            r2 = move-exception
            goto L_0x0059
        L_0x0054:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0052 }
            f7195a = r2     // Catch:{ all -> 0x0052 }
            goto L_0x004e
        L_0x0059:
            r1.recycle()     // Catch:{ all -> 0x0065 }
            throw r2     // Catch:{ all -> 0x0065 }
        L_0x005d:
            java.lang.Boolean r1 = f7195a     // Catch:{ all -> 0x0065 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0065 }
            monitor-exit(r0)
            return r1
        L_0x0065:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x0069
        L_0x0068:
            throw r1
        L_0x0069:
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.f.a():boolean");
    }

    private static void a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
