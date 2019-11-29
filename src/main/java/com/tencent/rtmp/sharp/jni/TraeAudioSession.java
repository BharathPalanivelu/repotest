package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.facebook.react.uimanager.ViewProps;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qphone.base.util.QLog;

public class TraeAudioSession extends BroadcastReceiver {
    static int s_nSessionIdAllocator;
    final String TRAE_ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
    private boolean _canSwtich2Earphone = true;
    private String _connectedDev = TraeAudioManager.DEVICE_NONE;
    private a mCallback;
    private Context mContext;
    private boolean mIsHostside = false;
    private long mSessionId = Long.MIN_VALUE;

    public interface a {
        void a(int i);

        void a(int i, int i2);

        void a(int i, String str);

        void a(int i, String str, boolean z);

        void a(int i, boolean z);

        void a(int i, String[] strArr, String str, String str2, String str3);

        void a(String str, long j);

        void a(String str, String str2);

        void a(boolean z);

        void a(String[] strArr, String str, String str2, String str3);

        void b(int i);

        void b(int i, String str);

        void b(boolean z);

        void c(int i, String str);
    }

    public static long requestSessionId() {
        int i = s_nSessionIdAllocator + 1;
        s_nSessionIdAllocator = i;
        return (((long) Process.myPid()) << 32) + ((long) i);
    }

    public static void ExConnectDevice(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECTDEVICE);
            intent.putExtra(TraeAudioManager.CONNECTDEVICE_DEVICENAME, str);
            context.sendBroadcast(intent);
        }
    }

    public TraeAudioSession(Context context, a aVar) {
        boolean z = false;
        this.mIsHostside = Process.myPid() == TraeAudioManager._gHostProcessId ? true : z;
        this.mSessionId = requestSessionId();
        this.mCallback = aVar;
        this.mContext = context;
        if (context == null && QLog.isColorLevel()) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioSession | Invalid parameters: ctx = ");
            String str = "null";
            sb.append(context == null ? str : "{object}");
            sb.append("; cb = ");
            sb.append(aVar != null ? "{object}" : str);
            QLog.w("TRAE", 2, sb.toString());
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES);
        intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
        if (context != null) {
            try {
                context.registerReceiver(this, intentFilter);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "registerReceiver Exception: " + e2.getMessage());
                }
            }
        }
        registerAudioSession(this, true);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioSession create, mSessionId: " + this.mSessionId);
        }
    }

    public void release() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioSession release, mSessionId: " + this.mSessionId);
        }
        Context context = this.mContext;
        if (context != null) {
            try {
                context.unregisterReceiver(this);
            } catch (Exception unused) {
            }
        }
        registerAudioSession(this, false);
        this.mContext = null;
        this.mCallback = null;
    }

    public void setCallback(a aVar) {
        this.mCallback = aVar;
    }

    private int registerAudioSession(TraeAudioSession traeAudioSession, boolean z) {
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        return TraeAudioManager.registerAudioSession(traeAudioSession, z, this.mSessionId, context);
    }

    public int startService(String str) {
        if (str == null || str.length() <= 0) {
            str = "internal_disable_dev_switch";
        }
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.startService(TraeAudioManager.OPERATION_STARTSERVICE, this.mSessionId, z, str);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTSERVICE);
        intent.putExtra(TraeAudioManager.EXTRA_DATA_DEVICECONFIG, str);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int disableDeviceSwitch() {
        return TraeAudioManager.disableDeviceSwitch();
    }

    public int stopService() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.stopService(TraeAudioManager.OPERATION_STOPSERVICE, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STOPSERVICE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int getDeviceList() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.getDeviceList(TraeAudioManager.OPERATION_GETDEVICELIST, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETDEVICELIST);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int getStreamType() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.getStreamType(TraeAudioManager.OPERATION_GETSTREAMTYPE, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETSTREAMTYPE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int connectDevice(String str) {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.connectDevice(TraeAudioManager.OPERATION_CONNECTDEVICE, this.mSessionId, z, str);
        }
        if (this.mContext == null || str == null || str.length() <= 0) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECTDEVICE);
        intent.putExtra(TraeAudioManager.CONNECTDEVICE_DEVICENAME, str);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int connectHighestPriorityDevice() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.connectHighestPriorityDevice(TraeAudioManager.OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int EarAction(int i) {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.earAction(TraeAudioManager.OPERATION_EARACTION, this.mSessionId, z, i);
        }
        if (this.mContext == null) {
            return -1;
        }
        if (i != 0 && i != 1) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_EARACTION);
        intent.putExtra(TraeAudioManager.EXTRA_EARACTION, i);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int isDeviceChangabled() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.isDeviceChangabled(TraeAudioManager.OPERATION_ISDEVICECHANGABLED, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_ISDEVICECHANGABLED);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int getConnectedDevice() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.getConnectedDevice(TraeAudioManager.OPERATION_GETCONNECTEDDEVICE, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETCONNECTEDDEVICE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int getConnectingDevice() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.getConnectingDevice(TraeAudioManager.OPERATION_GETCONNECTINGDEVICE, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETCONNECTINGDEVICE);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int voiceCallPreprocess(int i, int i2) {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.voicecallPreprocess(TraeAudioManager.OPERATION_VOICECALL_PREPROCESS, this.mSessionId, z, i, i2);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_MODEPOLICY, i);
        intent.putExtra(TraeAudioManager.PARAM_STREAMTYPE, i2);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_PREPROCESS);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int voiceCallPostprocess() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.voicecallPostprocess(TraeAudioManager.OPERATION_VOICECALL_POSTPROCESS, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_POSTPROCESS);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int voiceCallAudioParamChanged(int i, int i2) {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.voiceCallAudioParamChanged(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST, this.mSessionId, z, i, i2);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_MODEPOLICY, i);
        intent.putExtra(TraeAudioManager.PARAM_STREAMTYPE, i2);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_AUDIOPARAM_CHANGED);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z) {
        boolean z2 = this.mIsHostside;
        if (z2) {
            return TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, z2, i, i2, uri, str, z, 1, "normal-ring", false);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        int i3 = i;
        intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
        int i4 = i2;
        intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
        intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
        intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
        intent.putExtra(TraeAudioManager.PARAM_RING_MODE, false);
        intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, "normal-ring");
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z, int i3, String str2) {
        boolean z2 = this.mIsHostside;
        if (z2) {
            return TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, z2, i, i2, uri, str, z, i3, str2, false);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        int i4 = i;
        intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
        int i5 = i2;
        intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
        intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
        intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOPCOUNT, i3);
        intent.putExtra(TraeAudioManager.PARAM_RING_MODE, false);
        intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, str2);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z, int i3, String str2, boolean z2) {
        boolean z3 = this.mIsHostside;
        if (z3) {
            return TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, z3, i, i2, uri, str, z, i3, str2, z2);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        int i4 = i;
        intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
        int i5 = i2;
        intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
        intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
        intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
        intent.putExtra(TraeAudioManager.PARAM_RING_LOOPCOUNT, i3);
        intent.putExtra(TraeAudioManager.PARAM_RING_MODE, z2);
        intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, str2);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int stopRing() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.stopRing(TraeAudioManager.OPERATION_STOPRING, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STOPRING);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int requestReleaseAudioFocus() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.requestReleaseAudioFocus(TraeAudioManager.OPERATION_REQUEST_RELEASE_AUDIO_FOCUS, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_REQUEST_RELEASE_AUDIO_FOCUS);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public int recoverAudioFocus() {
        boolean z = this.mIsHostside;
        if (z) {
            return TraeAudioManager.recoverAudioFocus(TraeAudioManager.OPERATION_RECOVER_AUDIO_FOCUS, this.mSessionId, z);
        }
        if (this.mContext == null) {
            return -1;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_RECOVER_AUDIO_FOCUS);
        this.mContext.sendBroadcast(intent);
        return 0;
    }

    public void onReceiveCallback(Intent intent) {
        if (intent == null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[ERROR] intent = null!!");
                }
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + intent.toString() + " intent.getAction():" + intent.getAction() + " Exception:" + e2.getMessage());
                }
            }
        } else {
            long longExtra = intent.getLongExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
            String stringExtra = intent.getStringExtra(TraeAudioManager.PARAM_OPERATION);
            int intExtra = intent.getIntExtra(TraeAudioManager.PARAM_RES_ERRCODE, 0);
            if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES.equals(intent.getAction()) && this.mSessionId == longExtra && TraeAudioManager.OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "AudioSession|[onReceiveCallback onVoicecallPreprocess] err:" + intExtra);
                }
                if (this.mCallback != null) {
                    this.mCallback.b(intExtra);
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        Intent intent2 = intent;
        if (intent2 == null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[ERROR] intent = null!!");
                }
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + intent.toString() + " intent.getAction():" + intent.getAction() + " Exception:" + e2.getMessage());
                }
            }
        } else {
            long longExtra = intent2.getLongExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
            String stringExtra = intent2.getStringExtra(TraeAudioManager.PARAM_OPERATION);
            int intExtra = intent2.getIntExtra(TraeAudioManager.PARAM_RES_ERRCODE, 0);
            if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY.equals(intent.getAction())) {
                if (TraeAudioManager.NOTIFY_SERVICE_STATE.equals(stringExtra)) {
                    boolean booleanExtra = intent2.getBooleanExtra(TraeAudioManager.NOTIFY_SERVICE_STATE_DATE, false);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("AudioSession|[onServiceStateUpdate]");
                        sb.append(booleanExtra ? ViewProps.ON : "off");
                        QLog.w("TRAE", 2, sb.toString());
                    }
                    if (this.mCallback != null) {
                        this.mCallback.a(booleanExtra);
                    }
                } else if (TraeAudioManager.NOTIFY_DEVICELIST_UPDATE.equals(stringExtra)) {
                    String[] stringArrayExtra = intent2.getStringArrayExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
                    String stringExtra2 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
                    String stringExtra3 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
                    String stringExtra4 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME);
                    String str = "\n";
                    boolean z = true;
                    for (int i = 0; i < stringArrayExtra.length; i++) {
                        str = str + "AudioSession|    " + i + SQLBuilder.BLANK + stringArrayExtra[i] + "\n";
                        if (stringArrayExtra[i].equals(TraeAudioManager.DEVICE_WIREDHEADSET) || stringArrayExtra[i].equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
                            z = false;
                        }
                    }
                    String str2 = str + "\n";
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onDeviceListUpdate]  connected:" + stringExtra2 + " prevConnected:" + stringExtra3 + " bt:" + stringExtra4 + " Num:" + stringArrayExtra.length + str2);
                    }
                    this._canSwtich2Earphone = z;
                    this._connectedDev = stringExtra2;
                    if (this.mCallback != null) {
                        this.mCallback.a(stringArrayExtra, stringExtra2, stringExtra3, stringExtra4);
                    }
                } else if (TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE.equals(stringExtra)) {
                    boolean booleanExtra2 = intent2.getBooleanExtra(TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE_DATE, true);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onDeviceChangabledUpdate]" + booleanExtra2);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.b(booleanExtra2);
                    }
                } else if (TraeAudioManager.NOTIFY_STREAMTYPE_UPDATE.equals(stringExtra)) {
                    int intExtra2 = intent2.getIntExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, -1);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onStreamTypeUpdate] err:" + intExtra + " st:" + intExtra2);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.a(intExtra2);
                    }
                } else if (TraeAudioManager.NOTIFY_ROUTESWITCHSTART.equals(stringExtra)) {
                    String stringExtra5 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHSTART_FROM);
                    String stringExtra6 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHSTART_TO);
                    if (this.mCallback != null && stringExtra5 != null && stringExtra6 != null) {
                        this.mCallback.a(stringExtra5, stringExtra6);
                    }
                } else if (TraeAudioManager.NOTIFY_ROUTESWITCHEND.equals(stringExtra)) {
                    String stringExtra7 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHEND_DEV);
                    long longExtra2 = intent2.getLongExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHEND_TIME, -1);
                    if (this.mCallback != null && stringExtra7 != null && longExtra2 != -1) {
                        this.mCallback.a(stringExtra7, longExtra2);
                    }
                }
            } else if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES.equals(intent.getAction()) && this.mSessionId == longExtra) {
                if (TraeAudioManager.OPERATION_GETDEVICELIST.equals(stringExtra)) {
                    String[] stringArrayExtra2 = intent2.getStringArrayExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
                    String stringExtra8 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
                    String stringExtra9 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
                    String stringExtra10 = intent2.getStringExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME);
                    String str3 = "\n";
                    boolean z2 = true;
                    for (int i2 = 0; i2 < stringArrayExtra2.length; i2++) {
                        str3 = str3 + "AudioSession|    " + i2 + SQLBuilder.BLANK + stringArrayExtra2[i2] + "\n";
                        if (stringArrayExtra2[i2].equals(TraeAudioManager.DEVICE_WIREDHEADSET) || stringArrayExtra2[i2].equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
                            z2 = false;
                        }
                    }
                    String str4 = str3 + "\n";
                    this._canSwtich2Earphone = z2;
                    this._connectedDev = stringExtra8;
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onGetDeviceListRes] err:" + intExtra + " connected:" + stringExtra8 + " prevConnected:" + stringExtra9 + " bt:" + stringExtra10 + " Num:" + stringArrayExtra2.length + str4);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.a(intExtra, stringArrayExtra2, stringExtra8, stringExtra9, stringExtra10);
                    }
                } else if (TraeAudioManager.OPERATION_CONNECTDEVICE.equals(stringExtra)) {
                    String stringExtra11 = intent2.getStringExtra(TraeAudioManager.CONNECTDEVICE_RESULT_DEVICENAME);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + intExtra + " dev:" + stringExtra11);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.a(intExtra, stringExtra11, intExtra == 0);
                    }
                } else if (TraeAudioManager.OPERATION_EARACTION.equals(stringExtra)) {
                    int intExtra3 = intent2.getIntExtra(TraeAudioManager.EXTRA_EARACTION, -1);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + intExtra + " earAction:" + intExtra3);
                    }
                    a aVar = this.mCallback;
                } else if (TraeAudioManager.OPERATION_ISDEVICECHANGABLED.equals(stringExtra)) {
                    boolean booleanExtra3 = intent2.getBooleanExtra(TraeAudioManager.ISDEVICECHANGABLED_RESULT_ISCHANGABLED, false);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AudioSession|[onIsDeviceChangabledRes] err:");
                        sb2.append(intExtra);
                        sb2.append(" Changabled:");
                        sb2.append(booleanExtra3 ? "Y" : "N");
                        QLog.w("TRAE", 2, sb2.toString());
                    }
                    if (this.mCallback != null) {
                        this.mCallback.a(intExtra, booleanExtra3);
                    }
                } else if (TraeAudioManager.OPERATION_GETCONNECTEDDEVICE.equals(stringExtra)) {
                    String stringExtra12 = intent2.getStringExtra(TraeAudioManager.GETCONNECTEDDEVICE_RESULT_LIST);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onGetConnectedDeviceRes] err:" + intExtra + " dev:" + stringExtra12);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.a(intExtra, stringExtra12);
                    }
                } else if (TraeAudioManager.OPERATION_GETCONNECTINGDEVICE.equals(stringExtra)) {
                    String stringExtra13 = intent2.getStringExtra(TraeAudioManager.GETCONNECTINGDEVICE_RESULT_LIST);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onGetConnectingDeviceRes] err:" + intExtra + " dev:" + stringExtra13);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.b(intExtra, stringExtra13);
                    }
                } else if (TraeAudioManager.OPERATION_GETSTREAMTYPE.equals(stringExtra)) {
                    int intExtra4 = intent2.getIntExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, -1);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onGetStreamTypeRes] err:" + intExtra + " st:" + intExtra4);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.a(intExtra, intExtra4);
                    }
                } else if (TraeAudioManager.NOTIFY_RING_COMPLETION.equals(stringExtra)) {
                    String stringExtra14 = intent2.getStringExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onRingCompletion] err:" + intExtra + " userData:" + stringExtra14);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.c(intExtra, stringExtra14);
                    }
                } else if (TraeAudioManager.OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "AudioSession|[onVoicecallPreprocess] err:" + intExtra);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.b(intExtra);
                    }
                }
            }
        }
    }
}
