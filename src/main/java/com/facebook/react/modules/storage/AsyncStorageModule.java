package com.facebook.react.modules.storage;

import android.database.Cursor;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

@ReactModule(name = "AsyncSQLiteDBStorage")
public final class AsyncStorageModule extends ReactContextBaseJavaModule implements ModuleDataCleaner.Cleanable {
    private static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "AsyncSQLiteDBStorage";
    private final SerialExecutor executor;
    /* access modifiers changed from: private */
    public ReactDatabaseSupplier mReactDatabaseSupplier;
    private boolean mShuttingDown;

    public String getName() {
        return NAME;
    }

    private class SerialExecutor implements Executor {
        private final Executor executor;
        private Runnable mActive;
        private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

        SerialExecutor(Executor executor2) {
            this.executor = executor2;
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                this.executor.execute(this.mActive);
            }
        }
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @VisibleForTesting
    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor2) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        this.executor = new SerialExecutor(executor2);
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(reactApplicationContext);
    }

    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    public void clearSensitiveData() {
        this.mReactDatabaseSupplier.clearAndCloseDatabase();
    }

    @ReactMethod
    public void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError((String) null), null);
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError((String) null), null);
                    return;
                }
                String[] strArr = {"key", AppMeasurementSdk.ConditionalUserProperty.VALUE};
                HashSet hashSet = new HashSet();
                WritableArray createArray = Arguments.createArray();
                int i = 0;
                while (i < readableArray.size()) {
                    int min = Math.min(readableArray.size() - i, 999);
                    int i2 = min;
                    int i3 = i;
                    Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", strArr, AsyncLocalStorageUtil.buildKeySelection(min), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, min), (String) null, (String) null, (String) null);
                    hashSet.clear();
                    try {
                        if (query.getCount() != readableArray.size()) {
                            for (int i4 = i3; i4 < i3 + i2; i4++) {
                                hashSet.add(readableArray.getString(i4));
                            }
                        }
                        if (query.moveToFirst()) {
                            do {
                                WritableArray createArray2 = Arguments.createArray();
                                createArray2.pushString(query.getString(0));
                                createArray2.pushString(query.getString(1));
                                createArray.pushArray(createArray2);
                                hashSet.remove(query.getString(0));
                            } while (query.moveToNext());
                        }
                        query.close();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            WritableArray createArray3 = Arguments.createArray();
                            createArray3.pushString((String) it.next());
                            createArray3.pushNull();
                            createArray.pushArray(createArray3);
                        }
                        hashSet.clear();
                        i = i3 + 999;
                    } catch (Exception e2) {
                        FLog.w(ReactConstants.TAG, e2.getMessage(), (Throwable) e2);
                        callback.invoke(AsyncStorageErrorUtil.getError((String) null, e2.getMessage()), null);
                        query.close();
                        return;
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                callback.invoke(null, createArray);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError((String) null));
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Can't wrap try/catch for region: R(8:46|47|48|(3:50|51|52)|53|54|(2:55|56)|57) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x013e */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void doInBackgroundGuarded(java.lang.Void... r8) {
                /*
                    r7 = this;
                    java.lang.String r8 = "ReactNative"
                    com.facebook.react.modules.storage.AsyncStorageModule r0 = com.facebook.react.modules.storage.AsyncStorageModule.this
                    boolean r0 = r0.ensureDatabase()
                    r1 = 0
                    r2 = 1
                    r3 = 0
                    if (r0 != 0) goto L_0x001b
                    com.facebook.react.bridge.Callback r8 = r5
                    java.lang.Object[] r0 = new java.lang.Object[r2]
                    com.facebook.react.bridge.WritableMap r2 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r3)
                    r0[r1] = r2
                    r8.invoke(r0)
                    return
                L_0x001b:
                    com.facebook.react.modules.storage.AsyncStorageModule r0 = com.facebook.react.modules.storage.AsyncStorageModule.this
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r0 = r0.mReactDatabaseSupplier
                    android.database.sqlite.SQLiteDatabase r0 = r0.get()
                    java.lang.String r4 = "INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);"
                    android.database.sqlite.SQLiteStatement r0 = r0.compileStatement(r4)
                    com.facebook.react.modules.storage.AsyncStorageModule r4 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r4 = r4.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0124 }
                    android.database.sqlite.SQLiteDatabase r4 = r4.get()     // Catch:{ Exception -> 0x0124 }
                    r4.beginTransaction()     // Catch:{ Exception -> 0x0124 }
                    r4 = 0
                L_0x0039:
                    com.facebook.react.bridge.ReadableArray r5 = r4     // Catch:{ Exception -> 0x0124 }
                    int r5 = r5.size()     // Catch:{ Exception -> 0x0124 }
                    if (r4 >= r5) goto L_0x00f6
                    com.facebook.react.bridge.ReadableArray r5 = r4     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r4)     // Catch:{ Exception -> 0x0124 }
                    int r5 = r5.size()     // Catch:{ Exception -> 0x0124 }
                    r6 = 2
                    if (r5 == r6) goto L_0x0072
                    com.facebook.react.bridge.WritableMap r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidValueError(r3)     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.modules.storage.AsyncStorageModule r1 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0060 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r1 = r1.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0060 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.get()     // Catch:{ Exception -> 0x0060 }
                    r1.endTransaction()     // Catch:{ Exception -> 0x0060 }
                    goto L_0x0071
                L_0x0060:
                    r1 = move-exception
                    java.lang.String r2 = r1.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r8, (java.lang.String) r2, (java.lang.Throwable) r1)
                    if (r0 != 0) goto L_0x0071
                    java.lang.String r8 = r1.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r3, r8)
                L_0x0071:
                    return
                L_0x0072:
                    com.facebook.react.bridge.ReadableArray r5 = r4     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r4)     // Catch:{ Exception -> 0x0124 }
                    java.lang.String r5 = r5.getString(r1)     // Catch:{ Exception -> 0x0124 }
                    if (r5 != 0) goto L_0x00a2
                    com.facebook.react.bridge.WritableMap r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidKeyError(r3)     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.modules.storage.AsyncStorageModule r1 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0090 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r1 = r1.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0090 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.get()     // Catch:{ Exception -> 0x0090 }
                    r1.endTransaction()     // Catch:{ Exception -> 0x0090 }
                    goto L_0x00a1
                L_0x0090:
                    r1 = move-exception
                    java.lang.String r2 = r1.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r8, (java.lang.String) r2, (java.lang.Throwable) r1)
                    if (r0 != 0) goto L_0x00a1
                    java.lang.String r8 = r1.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r3, r8)
                L_0x00a1:
                    return
                L_0x00a2:
                    com.facebook.react.bridge.ReadableArray r5 = r4     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r4)     // Catch:{ Exception -> 0x0124 }
                    java.lang.String r5 = r5.getString(r2)     // Catch:{ Exception -> 0x0124 }
                    if (r5 != 0) goto L_0x00d2
                    com.facebook.react.bridge.WritableMap r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidValueError(r3)     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.modules.storage.AsyncStorageModule r1 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x00c0 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r1 = r1.mReactDatabaseSupplier     // Catch:{ Exception -> 0x00c0 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.get()     // Catch:{ Exception -> 0x00c0 }
                    r1.endTransaction()     // Catch:{ Exception -> 0x00c0 }
                    goto L_0x00d1
                L_0x00c0:
                    r1 = move-exception
                    java.lang.String r2 = r1.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r8, (java.lang.String) r2, (java.lang.Throwable) r1)
                    if (r0 != 0) goto L_0x00d1
                    java.lang.String r8 = r1.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r3, r8)
                L_0x00d1:
                    return
                L_0x00d2:
                    r0.clearBindings()     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.bridge.ReadableArray r5 = r4     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r4)     // Catch:{ Exception -> 0x0124 }
                    java.lang.String r5 = r5.getString(r1)     // Catch:{ Exception -> 0x0124 }
                    r0.bindString(r2, r5)     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.bridge.ReadableArray r5 = r4     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r4)     // Catch:{ Exception -> 0x0124 }
                    java.lang.String r5 = r5.getString(r2)     // Catch:{ Exception -> 0x0124 }
                    r0.bindString(r6, r5)     // Catch:{ Exception -> 0x0124 }
                    r0.execute()     // Catch:{ Exception -> 0x0124 }
                    int r4 = r4 + 1
                    goto L_0x0039
                L_0x00f6:
                    com.facebook.react.modules.storage.AsyncStorageModule r0 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r0 = r0.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0124 }
                    android.database.sqlite.SQLiteDatabase r0 = r0.get()     // Catch:{ Exception -> 0x0124 }
                    r0.setTransactionSuccessful()     // Catch:{ Exception -> 0x0124 }
                    com.facebook.react.modules.storage.AsyncStorageModule r0 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0111 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r0 = r0.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0111 }
                    android.database.sqlite.SQLiteDatabase r0 = r0.get()     // Catch:{ Exception -> 0x0111 }
                    r0.endTransaction()     // Catch:{ Exception -> 0x0111 }
                    goto L_0x0168
                L_0x0111:
                    r0 = move-exception
                    java.lang.String r4 = r0.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r8, (java.lang.String) r4, (java.lang.Throwable) r0)
                    java.lang.String r8 = r0.getMessage()
                    com.facebook.react.bridge.WritableMap r3 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r3, r8)
                    goto L_0x0168
                L_0x0122:
                    r0 = move-exception
                    goto L_0x017c
                L_0x0124:
                    r0 = move-exception
                    java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0122 }
                    com.facebook.common.logging.FLog.w((java.lang.String) r8, (java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0122 }
                    boolean r4 = r0 instanceof android.database.sqlite.SQLiteFullException     // Catch:{ all -> 0x0122 }
                    if (r4 == 0) goto L_0x013e
                    java.lang.String r4 = "clear async storage"
                    com.facebook.common.logging.FLog.w((java.lang.String) r8, (java.lang.String) r4)     // Catch:{ Exception -> 0x013e }
                    com.facebook.react.modules.storage.AsyncStorageModule r4 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x013e }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r4 = r4.mReactDatabaseSupplier     // Catch:{ Exception -> 0x013e }
                    r4.clear()     // Catch:{ Exception -> 0x013e }
                L_0x013e:
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0122 }
                    com.facebook.react.bridge.WritableMap r0 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r3, r0)     // Catch:{ all -> 0x0122 }
                    com.facebook.react.modules.storage.AsyncStorageModule r4 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0155 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r4 = r4.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0155 }
                    android.database.sqlite.SQLiteDatabase r4 = r4.get()     // Catch:{ Exception -> 0x0155 }
                    r4.endTransaction()     // Catch:{ Exception -> 0x0155 }
                L_0x0153:
                    r3 = r0
                    goto L_0x0168
                L_0x0155:
                    r4 = move-exception
                    java.lang.String r5 = r4.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r8, (java.lang.String) r5, (java.lang.Throwable) r4)
                    if (r0 != 0) goto L_0x0153
                    java.lang.String r8 = r4.getMessage()
                    com.facebook.react.bridge.WritableMap r8 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r3, r8)
                    r3 = r8
                L_0x0168:
                    if (r3 == 0) goto L_0x0174
                    com.facebook.react.bridge.Callback r8 = r5
                    java.lang.Object[] r0 = new java.lang.Object[r2]
                    r0[r1] = r3
                    r8.invoke(r0)
                    goto L_0x017b
                L_0x0174:
                    com.facebook.react.bridge.Callback r8 = r5
                    java.lang.Object[] r0 = new java.lang.Object[r1]
                    r8.invoke(r0)
                L_0x017b:
                    return
                L_0x017c:
                    com.facebook.react.modules.storage.AsyncStorageModule r1 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x018a }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r1 = r1.mReactDatabaseSupplier     // Catch:{ Exception -> 0x018a }
                    android.database.sqlite.SQLiteDatabase r1 = r1.get()     // Catch:{ Exception -> 0x018a }
                    r1.endTransaction()     // Catch:{ Exception -> 0x018a }
                    goto L_0x0199
                L_0x018a:
                    r1 = move-exception
                    java.lang.String r2 = r1.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r8, (java.lang.String) r2, (java.lang.Throwable) r1)
                    java.lang.String r8 = r1.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r3, r8)
                L_0x0199:
                    goto L_0x019b
                L_0x019a:
                    throw r0
                L_0x019b:
                    goto L_0x019a
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.AnonymousClass2.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError((String) null));
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                WritableMap writableMap = null;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError((String) null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                    for (int i = 0; i < readableArray.size(); i += 999) {
                        int min = Math.min(readableArray.size() - i, 999);
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().delete("catalystLocalStorage", AsyncLocalStorageUtil.buildKeySelection(min), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, min));
                    }
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e2) {
                        FLog.w(ReactConstants.TAG, e2.getMessage(), (Throwable) e2);
                        writableMap = AsyncStorageErrorUtil.getError((String) null, e2.getMessage());
                    }
                } catch (Exception e3) {
                    FLog.w(ReactConstants.TAG, e3.getMessage(), (Throwable) e3);
                    WritableMap error = AsyncStorageErrorUtil.getError((String) null, e3.getMessage());
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e4) {
                        FLog.w(ReactConstants.TAG, e4.getMessage(), (Throwable) e4);
                        if (error == null) {
                            writableMap = AsyncStorageErrorUtil.getError((String) null, e4.getMessage());
                        }
                    }
                    writableMap = error;
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e5) {
                        FLog.w(ReactConstants.TAG, e5.getMessage(), (Throwable) e5);
                        AsyncStorageErrorUtil.getError((String) null, e5.getMessage());
                    }
                    throw th;
                }
                if (writableMap != null) {
                    callback.invoke(writableMap);
                    return;
                }
                callback.invoke(new Object[0]);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Can't wrap try/catch for region: R(10:76|77|78|79|80|81|82|83|84|85) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x01ab */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void doInBackgroundGuarded(java.lang.Void... r9) {
                /*
                    r8 = this;
                    java.lang.String r9 = "clear async storage"
                    java.lang.String r0 = "ReactNative"
                    com.facebook.react.modules.storage.AsyncStorageModule r1 = com.facebook.react.modules.storage.AsyncStorageModule.this
                    boolean r1 = r1.ensureDatabase()
                    r2 = 1
                    r3 = 0
                    r4 = 0
                    if (r1 != 0) goto L_0x001d
                    com.facebook.react.bridge.Callback r9 = r4
                    java.lang.Object[] r0 = new java.lang.Object[r2]
                    com.facebook.react.bridge.WritableMap r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r4)
                    r0[r3] = r1
                    r9.invoke(r0)
                    return
                L_0x001d:
                    com.facebook.react.modules.storage.AsyncStorageModule r1 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r1 = r1.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0197 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.get()     // Catch:{ Exception -> 0x0197 }
                    r1.beginTransaction()     // Catch:{ Exception -> 0x0197 }
                    r1 = 0
                L_0x002b:
                    com.facebook.react.bridge.ReadableArray r5 = r3     // Catch:{ Exception -> 0x0197 }
                    int r5 = r5.size()     // Catch:{ Exception -> 0x0197 }
                    if (r1 >= r5) goto L_0x0158
                    com.facebook.react.bridge.ReadableArray r5 = r3     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r1)     // Catch:{ Exception -> 0x0197 }
                    int r5 = r5.size()     // Catch:{ Exception -> 0x0197 }
                    r6 = 2
                    if (r5 == r6) goto L_0x0076
                    com.facebook.react.bridge.WritableMap r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidValueError(r4)     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.modules.storage.AsyncStorageModule r2 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0052 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r2 = r2.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0052 }
                    android.database.sqlite.SQLiteDatabase r2 = r2.get()     // Catch:{ Exception -> 0x0052 }
                    r2.endTransaction()     // Catch:{ Exception -> 0x0052 }
                    goto L_0x0075
                L_0x0052:
                    r2 = move-exception
                    java.lang.String r3 = r2.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r3, (java.lang.Throwable) r2)
                    boolean r3 = r2 instanceof android.database.sqlite.SQLiteFullException
                    if (r3 == 0) goto L_0x006c
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x006b }
                    com.facebook.react.modules.storage.AsyncStorageModule r9 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x006b }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r9 = r9.mReactDatabaseSupplier     // Catch:{ Exception -> 0x006b }
                    r9.clear()     // Catch:{ Exception -> 0x006b }
                    goto L_0x006c
                L_0x006b:
                L_0x006c:
                    if (r1 != 0) goto L_0x0075
                    java.lang.String r9 = r2.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r4, r9)
                L_0x0075:
                    return
                L_0x0076:
                    com.facebook.react.bridge.ReadableArray r5 = r3     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r1)     // Catch:{ Exception -> 0x0197 }
                    java.lang.String r5 = r5.getString(r3)     // Catch:{ Exception -> 0x0197 }
                    if (r5 != 0) goto L_0x00b8
                    com.facebook.react.bridge.WritableMap r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidKeyError(r4)     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.modules.storage.AsyncStorageModule r2 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0094 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r2 = r2.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0094 }
                    android.database.sqlite.SQLiteDatabase r2 = r2.get()     // Catch:{ Exception -> 0x0094 }
                    r2.endTransaction()     // Catch:{ Exception -> 0x0094 }
                    goto L_0x00b7
                L_0x0094:
                    r2 = move-exception
                    java.lang.String r3 = r2.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r3, (java.lang.Throwable) r2)
                    boolean r3 = r2 instanceof android.database.sqlite.SQLiteFullException
                    if (r3 == 0) goto L_0x00ae
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x00ad }
                    com.facebook.react.modules.storage.AsyncStorageModule r9 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x00ad }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r9 = r9.mReactDatabaseSupplier     // Catch:{ Exception -> 0x00ad }
                    r9.clear()     // Catch:{ Exception -> 0x00ad }
                    goto L_0x00ae
                L_0x00ad:
                L_0x00ae:
                    if (r1 != 0) goto L_0x00b7
                    java.lang.String r9 = r2.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r4, r9)
                L_0x00b7:
                    return
                L_0x00b8:
                    com.facebook.react.bridge.ReadableArray r5 = r3     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.bridge.ReadableArray r5 = r5.getArray(r1)     // Catch:{ Exception -> 0x0197 }
                    java.lang.String r5 = r5.getString(r2)     // Catch:{ Exception -> 0x0197 }
                    if (r5 != 0) goto L_0x00fa
                    com.facebook.react.bridge.WritableMap r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getInvalidValueError(r4)     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.modules.storage.AsyncStorageModule r2 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x00d6 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r2 = r2.mReactDatabaseSupplier     // Catch:{ Exception -> 0x00d6 }
                    android.database.sqlite.SQLiteDatabase r2 = r2.get()     // Catch:{ Exception -> 0x00d6 }
                    r2.endTransaction()     // Catch:{ Exception -> 0x00d6 }
                    goto L_0x00f9
                L_0x00d6:
                    r2 = move-exception
                    java.lang.String r3 = r2.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r3, (java.lang.Throwable) r2)
                    boolean r3 = r2 instanceof android.database.sqlite.SQLiteFullException
                    if (r3 == 0) goto L_0x00f0
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x00ef }
                    com.facebook.react.modules.storage.AsyncStorageModule r9 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x00ef }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r9 = r9.mReactDatabaseSupplier     // Catch:{ Exception -> 0x00ef }
                    r9.clear()     // Catch:{ Exception -> 0x00ef }
                    goto L_0x00f0
                L_0x00ef:
                L_0x00f0:
                    if (r1 != 0) goto L_0x00f9
                    java.lang.String r9 = r2.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r4, r9)
                L_0x00f9:
                    return
                L_0x00fa:
                    com.facebook.react.modules.storage.AsyncStorageModule r5 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r5 = r5.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0197 }
                    android.database.sqlite.SQLiteDatabase r5 = r5.get()     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.bridge.ReadableArray r6 = r3     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.bridge.ReadableArray r6 = r6.getArray(r1)     // Catch:{ Exception -> 0x0197 }
                    java.lang.String r6 = r6.getString(r3)     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.bridge.ReadableArray r7 = r3     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.bridge.ReadableArray r7 = r7.getArray(r1)     // Catch:{ Exception -> 0x0197 }
                    java.lang.String r7 = r7.getString(r2)     // Catch:{ Exception -> 0x0197 }
                    boolean r5 = com.facebook.react.modules.storage.AsyncLocalStorageUtil.mergeImpl(r5, r6, r7)     // Catch:{ Exception -> 0x0197 }
                    if (r5 != 0) goto L_0x0154
                    com.facebook.react.bridge.WritableMap r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getDBError(r4)     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.modules.storage.AsyncStorageModule r2 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0130 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r2 = r2.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0130 }
                    android.database.sqlite.SQLiteDatabase r2 = r2.get()     // Catch:{ Exception -> 0x0130 }
                    r2.endTransaction()     // Catch:{ Exception -> 0x0130 }
                    goto L_0x0153
                L_0x0130:
                    r2 = move-exception
                    java.lang.String r3 = r2.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r3, (java.lang.Throwable) r2)
                    boolean r3 = r2 instanceof android.database.sqlite.SQLiteFullException
                    if (r3 == 0) goto L_0x014a
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x0149 }
                    com.facebook.react.modules.storage.AsyncStorageModule r9 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0149 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r9 = r9.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0149 }
                    r9.clear()     // Catch:{ Exception -> 0x0149 }
                    goto L_0x014a
                L_0x0149:
                L_0x014a:
                    if (r1 != 0) goto L_0x0153
                    java.lang.String r9 = r2.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r4, r9)
                L_0x0153:
                    return
                L_0x0154:
                    int r1 = r1 + 1
                    goto L_0x002b
                L_0x0158:
                    com.facebook.react.modules.storage.AsyncStorageModule r1 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r1 = r1.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0197 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.get()     // Catch:{ Exception -> 0x0197 }
                    r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x0197 }
                    com.facebook.react.modules.storage.AsyncStorageModule r1 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0174 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r1 = r1.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0174 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.get()     // Catch:{ Exception -> 0x0174 }
                    r1.endTransaction()     // Catch:{ Exception -> 0x0174 }
                    goto L_0x01e7
                L_0x0174:
                    r1 = move-exception
                    java.lang.String r5 = r1.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r5, (java.lang.Throwable) r1)
                    boolean r5 = r1 instanceof android.database.sqlite.SQLiteFullException
                    if (r5 == 0) goto L_0x018c
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x018c }
                    com.facebook.react.modules.storage.AsyncStorageModule r9 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x018c }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r9 = r9.mReactDatabaseSupplier     // Catch:{ Exception -> 0x018c }
                    r9.clear()     // Catch:{ Exception -> 0x018c }
                L_0x018c:
                    java.lang.String r9 = r1.getMessage()
                    com.facebook.react.bridge.WritableMap r4 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r4, r9)
                    goto L_0x01e7
                L_0x0195:
                    r1 = move-exception
                    goto L_0x01fb
                L_0x0197:
                    r1 = move-exception
                    java.lang.String r5 = r1.getMessage()     // Catch:{ all -> 0x0195 }
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r5, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0195 }
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x01ab }
                    com.facebook.react.modules.storage.AsyncStorageModule r5 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x01ab }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r5 = r5.mReactDatabaseSupplier     // Catch:{ Exception -> 0x01ab }
                    r5.clear()     // Catch:{ Exception -> 0x01ab }
                L_0x01ab:
                    java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0195 }
                    com.facebook.react.bridge.WritableMap r1 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r4, r1)     // Catch:{ all -> 0x0195 }
                    com.facebook.react.modules.storage.AsyncStorageModule r5 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x01c2 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r5 = r5.mReactDatabaseSupplier     // Catch:{ Exception -> 0x01c2 }
                    android.database.sqlite.SQLiteDatabase r5 = r5.get()     // Catch:{ Exception -> 0x01c2 }
                    r5.endTransaction()     // Catch:{ Exception -> 0x01c2 }
                L_0x01c0:
                    r4 = r1
                    goto L_0x01e7
                L_0x01c2:
                    r5 = move-exception
                    java.lang.String r6 = r5.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r6, (java.lang.Throwable) r5)
                    boolean r6 = r5 instanceof android.database.sqlite.SQLiteFullException
                    if (r6 == 0) goto L_0x01dc
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x01db }
                    com.facebook.react.modules.storage.AsyncStorageModule r9 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x01db }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r9 = r9.mReactDatabaseSupplier     // Catch:{ Exception -> 0x01db }
                    r9.clear()     // Catch:{ Exception -> 0x01db }
                    goto L_0x01dc
                L_0x01db:
                L_0x01dc:
                    if (r1 != 0) goto L_0x01c0
                    java.lang.String r9 = r5.getMessage()
                    com.facebook.react.bridge.WritableMap r9 = com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r4, r9)
                    r4 = r9
                L_0x01e7:
                    if (r4 == 0) goto L_0x01f3
                    com.facebook.react.bridge.Callback r9 = r4
                    java.lang.Object[] r0 = new java.lang.Object[r2]
                    r0[r3] = r4
                    r9.invoke(r0)
                    goto L_0x01fa
                L_0x01f3:
                    com.facebook.react.bridge.Callback r9 = r4
                    java.lang.Object[] r0 = new java.lang.Object[r3]
                    r9.invoke(r0)
                L_0x01fa:
                    return
                L_0x01fb:
                    com.facebook.react.modules.storage.AsyncStorageModule r2 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0209 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r2 = r2.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0209 }
                    android.database.sqlite.SQLiteDatabase r2 = r2.get()     // Catch:{ Exception -> 0x0209 }
                    r2.endTransaction()     // Catch:{ Exception -> 0x0209 }
                    goto L_0x0228
                L_0x0209:
                    r2 = move-exception
                    java.lang.String r3 = r2.getMessage()
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r3, (java.lang.Throwable) r2)
                    boolean r3 = r2 instanceof android.database.sqlite.SQLiteFullException
                    if (r3 == 0) goto L_0x0221
                    com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x0221 }
                    com.facebook.react.modules.storage.AsyncStorageModule r9 = com.facebook.react.modules.storage.AsyncStorageModule.this     // Catch:{ Exception -> 0x0221 }
                    com.facebook.react.modules.storage.ReactDatabaseSupplier r9 = r9.mReactDatabaseSupplier     // Catch:{ Exception -> 0x0221 }
                    r9.clear()     // Catch:{ Exception -> 0x0221 }
                L_0x0221:
                    java.lang.String r9 = r2.getMessage()
                    com.facebook.react.modules.storage.AsyncStorageErrorUtil.getError(r4, r9)
                L_0x0228:
                    goto L_0x022a
                L_0x0229:
                    throw r1
                L_0x022a:
                    goto L_0x0229
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.storage.AsyncStorageModule.AnonymousClass4.doInBackgroundGuarded(java.lang.Void[]):void");
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError((String) null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                    callback.invoke(new Object[0]);
                } catch (Exception e2) {
                    FLog.w(ReactConstants.TAG, e2.getMessage(), (Throwable) e2);
                    callback.invoke(AsyncStorageErrorUtil.getError((String) null, e2.getMessage()));
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError((String) null), null);
                    return;
                }
                WritableArray createArray = Arguments.createArray();
                Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", new String[]{"key"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
                try {
                    if (query.moveToFirst()) {
                        do {
                            createArray.pushString(query.getString(0));
                        } while (query.moveToNext());
                    }
                    query.close();
                    callback.invoke(null, createArray);
                } catch (Exception e2) {
                    FLog.w(ReactConstants.TAG, e2.getMessage(), (Throwable) e2);
                    callback.invoke(AsyncStorageErrorUtil.getError((String) null, e2.getMessage()), null);
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* access modifiers changed from: private */
    public boolean ensureDatabase() {
        return !this.mShuttingDown && this.mReactDatabaseSupplier.ensureDatabase();
    }
}
