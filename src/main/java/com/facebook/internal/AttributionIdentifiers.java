package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = "com.facebook.internal.AttributionIdentifiers";
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
        return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
                if (methodQuietly == null) {
                    return null;
                }
                Object invokeMethodQuietly = Utility.invokeMethodQuietly((Object) null, methodQuietly, context);
                if (invokeMethodQuietly instanceof Integer) {
                    if (((Integer) invokeMethodQuietly).intValue() == 0) {
                        Method methodQuietly2 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                        if (methodQuietly2 == null) {
                            return null;
                        }
                        Object invokeMethodQuietly2 = Utility.invokeMethodQuietly((Object) null, methodQuietly2, context);
                        if (invokeMethodQuietly2 == null) {
                            return null;
                        }
                        Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "getId", (Class<?>[]) new Class[0]);
                        Method methodQuietly4 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                        if (methodQuietly3 != null) {
                            if (methodQuietly4 != null) {
                                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                                attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly3, new Object[0]);
                                attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly4, new Object[0])).booleanValue();
                                return attributionIdentifiers;
                            }
                        }
                    }
                }
                return null;
            }
            throw new FacebookException("getAndroidId cannot be called on the main thread.");
        } catch (Exception e2) {
            Utility.logd("android_id", e2);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e2) {
                Utility.logd("android_id", e2);
            } finally {
                context.unbindService(googleAdServiceConnection);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[Catch:{ Exception -> 0x00d3, all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006f A[Catch:{ Exception -> 0x00d3, all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[Catch:{ Exception -> 0x00d3, all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r13) {
        /*
            java.lang.String r0 = "limit_tracking"
            java.lang.String r1 = "androidid"
            java.lang.String r2 = "aid"
            android.os.Looper r3 = android.os.Looper.myLooper()
            android.os.Looper r4 = android.os.Looper.getMainLooper()
            if (r3 != r4) goto L_0x0017
            java.lang.String r3 = TAG
            java.lang.String r4 = "getAttributionIdentifiers should not be called from the main thread"
            android.util.Log.e(r3, r4)
        L_0x0017:
            com.facebook.internal.AttributionIdentifiers r3 = recentlyFetchedIdentifiers
            if (r3 == 0) goto L_0x002c
            long r3 = java.lang.System.currentTimeMillis()
            com.facebook.internal.AttributionIdentifiers r5 = recentlyFetchedIdentifiers
            long r6 = r5.fetchTime
            long r3 = r3 - r6
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x002c
            return r5
        L_0x002c:
            com.facebook.internal.AttributionIdentifiers r3 = getAndroidId(r13)
            r4 = 3
            r5 = 0
            java.lang.String[] r8 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            r4 = 0
            r8[r4] = r2     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            r6 = 1
            r8[r6] = r1     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            r6 = 2
            r8[r6] = r0     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            java.lang.String r7 = "com.facebook.katana.provider.AttributionIdProvider"
            android.content.pm.ProviderInfo r6 = r6.resolveContentProvider(r7, r4)     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            if (r6 == 0) goto L_0x0051
            java.lang.String r4 = "content://com.facebook.katana.provider.AttributionIdProvider"
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
        L_0x004f:
            r7 = r4
            goto L_0x0065
        L_0x0051:
            android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            java.lang.String r7 = "com.facebook.wakizashi.provider.AttributionIdProvider"
            android.content.pm.ProviderInfo r4 = r6.resolveContentProvider(r7, r4)     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            if (r4 == 0) goto L_0x0064
            java.lang.String r4 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            goto L_0x004f
        L_0x0064:
            r7 = r5
        L_0x0065:
            java.lang.String r4 = getInstallerPackageName(r13)     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            if (r4 == 0) goto L_0x006d
            r3.androidInstallerPackage = r4     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
        L_0x006d:
            if (r7 != 0) goto L_0x0074
            com.facebook.internal.AttributionIdentifiers r13 = cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            return r13
        L_0x0074:
            android.content.ContentResolver r6 = r13.getContentResolver()     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r13 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00d3, all -> 0x00d1 }
            if (r13 == 0) goto L_0x00be
            boolean r4 = r13.moveToFirst()     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            if (r4 != 0) goto L_0x0088
            goto L_0x00be
        L_0x0088:
            int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            int r0 = r13.getColumnIndex(r0)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            r3.attributionId = r2     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            if (r1 <= 0) goto L_0x00b4
            if (r0 <= 0) goto L_0x00b4
            java.lang.String r2 = r3.getAndroidAdvertiserId()     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            if (r2 != 0) goto L_0x00b4
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            r3.androidAdvertiserId = r1     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            java.lang.String r0 = r13.getString(r0)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            r3.limitTracking = r0     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
        L_0x00b4:
            if (r13 == 0) goto L_0x00b9
            r13.close()
        L_0x00b9:
            com.facebook.internal.AttributionIdentifiers r13 = cacheAndReturnIdentifiers(r3)
            return r13
        L_0x00be:
            com.facebook.internal.AttributionIdentifiers r0 = cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            if (r13 == 0) goto L_0x00c7
            r13.close()
        L_0x00c7:
            return r0
        L_0x00c8:
            r0 = move-exception
            r5 = r13
            r13 = r0
            goto L_0x00f7
        L_0x00cc:
            r0 = move-exception
            r12 = r0
            r0 = r13
            r13 = r12
            goto L_0x00d5
        L_0x00d1:
            r13 = move-exception
            goto L_0x00f7
        L_0x00d3:
            r13 = move-exception
            r0 = r5
        L_0x00d5:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00f5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r2.<init>()     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = "Caught unexpected exception in getAttributionId(): "
            r2.append(r3)     // Catch:{ all -> 0x00f5 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00f5 }
            r2.append(r13)     // Catch:{ all -> 0x00f5 }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x00f5 }
            com.facebook.internal.Utility.logd((java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x00f5 }
            if (r0 == 0) goto L_0x00f4
            r0.close()
        L_0x00f4:
            return r5
        L_0x00f5:
            r13 = move-exception
            r5 = r0
        L_0x00f7:
            if (r5 == 0) goto L_0x00fc
            r5.close()
        L_0x00fc:
            goto L_0x00fe
        L_0x00fd:
            throw r13
        L_0x00fe:
            goto L_0x00fd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
    }

    public static AttributionIdentifiers getCachedIdentifiers() {
        return recentlyFetchedIdentifiers;
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public String getAndroidAdvertiserId() {
        if (!FacebookSdk.isInitialized() || !FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return null;
        }
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    private static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        public void onServiceDisconnected(ComponentName componentName) {
        }

        private GoogleAdServiceConnection() {
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                return this.queue.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }
    }

    private static final class GoogleAdInfo implements IInterface {
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private IBinder binder;

        GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
