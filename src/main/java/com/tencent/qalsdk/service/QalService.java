package com.tencent.qalsdk.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.tencent.qalsdk.base.remote.IBaseService;
import com.tencent.qalsdk.core.NetConnInfoCenter;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;

public class QalService extends Service {
    public static String appChannel = null;
    public static String appVersion = null;
    public static Context context = null;
    public static j core = j.a();
    public static volatile boolean inited = false;
    static d msfServiceReqHandler = new d();
    static g msfServiceRespHandler = null;
    private static String proccessName = null;
    public static volatile boolean sIsCreatedByAutoBoot = false;
    public static final String tag = "QalService";
    private IBaseService.Stub binder = new h(this);
    /* access modifiers changed from: private */
    public a mConnection = null;

    private void stopForegroundCompat() {
    }

    public static synchronized void serviceInit(Context context2, boolean z) {
        synchronized (QalService.class) {
            if (!inited) {
                QLog.d(tag, "serviceInit init");
                proccessName = MsfSdkUtils.getProcessName(context2);
                QLog.init(context2);
                core.a(context2, z);
                c.a(context2, core);
                g gVar = new g(core);
                msfServiceRespHandler = gVar;
                gVar.setName("MsfServiceRespHandler");
                msfServiceRespHandler.start();
                inited = true;
            }
        }
    }

    public static j getCore() {
        return core;
    }

    public static String getProccessName() {
        return proccessName;
    }

    public IBinder onBind(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("to_SenderProcessName");
            if (stringExtra != null) {
                QLog.d(tag, 1, "service onBind by :" + stringExtra);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (qalsdk.a.m()) {
            qalsdk.a.a(false);
        }
        return this.binder;
    }

    public boolean onUnbind(Intent intent) {
        String stringExtra = intent.getStringExtra("to_SenderProcessName");
        QLog.d(tag, 2, "serivce onUnbind by :" + stringExtra);
        inited = false;
        return super.onUnbind(intent);
    }

    public void onCreate() {
        super.onCreate();
        try {
            context = this;
            QLog.d(tag, 1, "serivce onCreate");
            serviceInit(this, sIsCreatedByAutoBoot);
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "serivce onCreate... autoBoot[" + sIsCreatedByAutoBoot + "]");
            }
            sIsCreatedByAutoBoot = false;
        } catch (RuntimeException e2) {
            QLog.e(tag, 1, "serivce onCreate exception:" + e2.getMessage());
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        QLog.d(tag, 1, "serivce onStart");
        return 1;
    }

    public void onDestroy() {
        try {
            QLog.i(tag, "service onDestroy");
            context.unregisterReceiver(j.a().j);
        } catch (Exception e2) {
            QLog.d(tag, 1, "unregisterReceiver failed. " + e2, e2);
        }
        try {
            context.unregisterReceiver(NetConnInfoCenter.impl.f32202c);
            QLog.i(tag, "unregisterReceiver impl rr");
        } catch (Exception e3) {
            QLog.d(tag, 1, "unregisterReceiver  rr failed. " + e3, e3);
        }
        try {
            context.unregisterReceiver(j.a().f32188d);
            QLog.i(tag, "unregisterReceiver pushManager ");
        } catch (Exception e4) {
            QLog.d(tag, 1, "unregisterReceiver pushManager failed. " + e4, e4);
        }
        stopForegroundCompat();
        super.onDestroy();
        System.exit(0);
    }

    private void startForegroundCompat() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                QLog.d(tag, "no assist service:" + Build.VERSION.SDK_INT);
                return;
            }
            if (this.mConnection == null) {
                this.mConnection = new a(this, (byte) 0);
            }
            bindService(new Intent(this, QalAssistService.class), this.mConnection, 1);
        } catch (Exception e2) {
            QLog.e(tag, e2.getMessage());
        }
    }

    public void onTaskRemoved(Intent intent) {
        QLog.i(tag, 1, "onTaskRemoved, restarting QalService...");
        inited = false;
        getApplicationContext().sendBroadcast(new Intent("com.tencent.qalsdk.service.TASK_REMOVED").setFlags(32));
        inited = false;
        super.onTaskRemoved(intent);
    }

    class a implements ServiceConnection {
        private a() {
        }

        /* synthetic */ a(QalService qalService, byte b2) {
            this();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            QLog.i(QalService.tag, "Assist onServiceDisconnected");
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QLog.i(QalService.tag, "Assist onServiceConnected");
            QalAssistService qalAssistService = QalAssistService.this;
            if (qalAssistService != null && Build.VERSION.SDK_INT >= 18) {
                qalAssistService.stopSelf();
            }
            QalService qalService = QalService.this;
            qalService.unbindService(qalService.mConnection);
            a unused = QalService.this.mConnection = null;
        }
    }
}
