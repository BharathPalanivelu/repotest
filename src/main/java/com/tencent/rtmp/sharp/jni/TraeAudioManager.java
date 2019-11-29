package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.facebook.GraphResponse;
import com.facebook.internal.ServerProtocol;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.sharp.jni.TraeMediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class TraeAudioManager extends BroadcastReceiver {
    public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
    public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
    public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP = 128;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO = 16;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
    static final int AUDIO_DEVICE_OUT_EARPIECE = 1;
    static final int AUDIO_DEVICE_OUT_SPEAKER = 2;
    static final int AUDIO_DEVICE_OUT_WIRED_HEADPHONE = 8;
    static final int AUDIO_DEVICE_OUT_WIRED_HEADSET = 4;
    public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
    public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
    public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
    static final String AUDIO_PARAMETER_STREAM_ROUTING = "routing";
    public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
    public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
    public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
    public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
    public static final String DEVICE_NONE = "DEVICE_NONE";
    public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
    public static final int DEVICE_STATUS_CONNECTED = 2;
    public static final int DEVICE_STATUS_CONNECTING = 1;
    public static final int DEVICE_STATUS_DISCONNECTED = 0;
    public static final int DEVICE_STATUS_DISCONNECTING = 3;
    public static final int DEVICE_STATUS_ERROR = -1;
    public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
    public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
    public static final int EARACTION_AWAY = 0;
    public static final int EARACTION_CLOSE = 1;
    public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
    public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
    public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
    public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
    public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
    public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
    public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
    public static final int FORCE_ANALOG_DOCK = 8;
    public static final int FORCE_BT_A2DP = 4;
    public static final int FORCE_BT_CAR_DOCK = 6;
    public static final int FORCE_BT_DESK_DOCK = 7;
    public static final int FORCE_BT_SCO = 3;
    public static final int FORCE_DEFAULT = 0;
    public static final int FORCE_DIGITAL_DOCK = 9;
    public static final int FORCE_HEADPHONES = 2;
    public static final int FORCE_NONE = 0;
    public static final int FORCE_NO_BT_A2DP = 10;
    public static final int FORCE_SPEAKER = 1;
    public static final int FORCE_WIRED_ACCESSORY = 5;
    public static final int FOR_COMMUNICATION = 0;
    public static final int FOR_DOCK = 3;
    public static final int FOR_MEDIA = 1;
    public static final int FOR_RECORD = 2;
    public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
    public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
    public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
    public static boolean IsEarPhoneSupported = false;
    public static boolean IsMusicScene = false;
    public static boolean IsUpdateSceneFlag = false;
    public static final int MODE_MUSIC_PLAYBACK = 2;
    public static final int MODE_MUSIC_PLAY_RECORD = 1;
    public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
    public static final int MODE_MUSIC_PLAY_RECORD_LOW_QUALITY = 5;
    public static final int MODE_VOICE_CHAT = 0;
    public static final int MODE_VOICE_PLAYBACK = 4;
    public static final String MUSIC_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
    public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
    public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
    public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
    public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
    public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
    public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
    public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
    private static final int NUM_FORCE_CONFIG = 11;
    private static final int NUM_FORCE_USE = 4;
    public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
    public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
    public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
    public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
    public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
    public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
    public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
    public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
    public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
    public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
    public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
    public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
    public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
    public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
    public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
    public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
    public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
    public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
    public static final String PARAM_DEVICE = "PARAM_DEVICE";
    public static final String PARAM_ERROR = "PARAM_ERROR";
    public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
    public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
    public static final String PARAM_OPERATION = "PARAM_OPERATION";
    public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
    public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
    public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
    public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
    public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
    public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
    public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
    public static final String PARAM_RING_URI = "PARAM_RING_URI";
    public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
    public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
    public static final String PARAM_STATUS = "PARAM_STATUS";
    public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
    public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
    public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
    public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
    public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
    public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
    public static final int RES_ERRCODE_NONE = 0;
    public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
    public static final int RES_ERRCODE_SERVICE_OFF = 1;
    public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
    public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
    public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
    public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
    public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    static int _gHostProcessId = -1;
    static TraeAudioManager _ginstance = null;
    static ReentrantLock _glock = new ReentrantLock();
    public static boolean enableDeviceSwitchFlag = true;
    static final String[] forceName = {"FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK"};
    boolean IsBluetoothA2dpExisted = true;
    int _activeMode = 0;
    AudioManager _am = null;
    TraeAudioSessionHost _audioSessionHost = null;
    d _bluetoothCheck = null;
    Context _context = null;
    e _deviceConfigManager = null;
    ReentrantLock _lock = new ReentrantLock();
    int _modePolicy = -1;
    int _prevMode = 0;
    int _streamType = 0;
    k _switchThread = null;
    f mTraeAudioManagerLooper = null;
    String sessionConnectedDev = DEVICE_NONE;

    /* access modifiers changed from: package-private */
    public int InternalSessionEarAction(HashMap<String, Object> hashMap) {
        return 0;
    }

    public static boolean checkDevName(String str) {
        if (str == null) {
            return false;
        }
        if (DEVICE_SPEAKERPHONE.equals(str) || DEVICE_EARPHONE.equals(str) || DEVICE_WIREDHEADSET.equals(str) || DEVICE_BLUETOOTHHEADSET.equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isHandfree(String str) {
        if (checkDevName(str) && DEVICE_SPEAKERPHONE.equals(str)) {
            return true;
        }
        return false;
    }

    class e {

        /* renamed from: a  reason: collision with root package name */
        HashMap<String, a> f32433a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        String f32434b = TraeAudioManager.DEVICE_NONE;

        /* renamed from: c  reason: collision with root package name */
        String f32435c = TraeAudioManager.DEVICE_NONE;

        /* renamed from: d  reason: collision with root package name */
        String f32436d = TraeAudioManager.DEVICE_NONE;

        /* renamed from: e  reason: collision with root package name */
        ReentrantLock f32437e = new ReentrantLock();

        /* renamed from: f  reason: collision with root package name */
        boolean f32438f = false;

        /* renamed from: g  reason: collision with root package name */
        String f32439g = "unknow";

        public class a {

            /* renamed from: a  reason: collision with root package name */
            String f32440a = TraeAudioManager.DEVICE_NONE;

            /* renamed from: b  reason: collision with root package name */
            boolean f32441b = false;

            /* renamed from: c  reason: collision with root package name */
            int f32442c = 0;

            public a() {
            }

            public boolean a(String str, int i) {
                if (str == null || str.length() <= 0 || !TraeAudioManager.checkDevName(str)) {
                    return false;
                }
                this.f32440a = str;
                this.f32442c = i;
                return true;
            }

            public String a() {
                return this.f32440a;
            }

            public boolean b() {
                return this.f32441b;
            }

            public int c() {
                return this.f32442c;
            }

            public void a(boolean z) {
                this.f32441b = z;
            }
        }

        public e() {
        }

        public boolean a(String str) {
            AudioDeviceInterface.LogTraceEntry(" strConfigs:" + str);
            if (str != null && str.length() > 0) {
                String replace = str.replace("\n", "").replace("\r", "");
                if (replace != null && replace.length() > 0) {
                    if (replace.indexOf(";") < 0) {
                        replace = replace + ";";
                    }
                    String[] split = replace.split(";");
                    if (split != null && 1 <= split.length) {
                        this.f32437e.lock();
                        for (int i = 0; i < split.length; i++) {
                            a(split[i], i);
                        }
                        this.f32437e.unlock();
                        TraeAudioManager.this.printDevices();
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str, int i) {
            AudioDeviceInterface.LogTraceEntry(" devName:" + str + " priority:" + i);
            a aVar = new a();
            if (!aVar.a(str, i)) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err dev init!");
                }
                return false;
            } else if (this.f32433a.containsKey(str)) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "err dev exist!");
                }
                return false;
            } else {
                this.f32433a.put(str, aVar);
                this.f32438f = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " n" + e() + " 0:" + a(0));
                }
                AudioDeviceInterface.LogTraceExit();
                return true;
            }
        }

        public void a() {
            this.f32437e.lock();
            this.f32433a.clear();
            this.f32434b = TraeAudioManager.DEVICE_NONE;
            this.f32435c = TraeAudioManager.DEVICE_NONE;
            this.f32436d = TraeAudioManager.DEVICE_NONE;
            this.f32437e.unlock();
        }

        public boolean b() {
            this.f32437e.lock();
            boolean z = this.f32438f;
            this.f32437e.unlock();
            return z;
        }

        public void c() {
            this.f32437e.lock();
            this.f32438f = false;
            this.f32437e.unlock();
        }

        public boolean a(String str, boolean z) {
            this.f32437e.lock();
            a aVar = this.f32433a.get(str);
            boolean z2 = true;
            if (aVar == null || aVar.b() == z) {
                z2 = false;
            } else {
                aVar.a(z);
                this.f32438f = true;
                if (QLog.isColorLevel()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" ++setVisible:");
                    sb.append(str);
                    sb.append(z ? " Y" : " N");
                    QLog.w("TRAE", 2, sb.toString());
                }
            }
            this.f32437e.unlock();
            return z2;
        }

        public void b(String str) {
            if (str == null) {
                this.f32439g = "unknow";
            } else if (str.isEmpty()) {
                this.f32439g = "unknow";
            } else {
                this.f32439g = str;
            }
        }

        public String d() {
            return this.f32439g;
        }

        public boolean c(String str) {
            this.f32437e.lock();
            a aVar = this.f32433a.get(str);
            boolean b2 = aVar != null ? aVar.b() : false;
            this.f32437e.unlock();
            return b2;
        }

        public int d(String str) {
            this.f32437e.lock();
            a aVar = this.f32433a.get(str);
            int c2 = aVar != null ? aVar.c() : -1;
            this.f32437e.unlock();
            return c2;
        }

        public int e() {
            this.f32437e.lock();
            int size = this.f32433a.size();
            this.f32437e.unlock();
            return size;
        }

        public String a(int i) {
            a aVar;
            this.f32437e.lock();
            Iterator<Map.Entry<String, a>> it = this.f32433a.entrySet().iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                Map.Entry next = it.next();
                if (i2 == i) {
                    aVar = (a) next.getValue();
                    break;
                }
                i2++;
            }
            String a2 = aVar != null ? aVar.a() : TraeAudioManager.DEVICE_NONE;
            this.f32437e.unlock();
            return a2;
        }

        public String e(String str) {
            this.f32437e.lock();
            a aVar = null;
            for (Map.Entry next : this.f32433a.entrySet()) {
                next.getKey();
                next.getValue();
                a aVar2 = (a) next.getValue();
                if (aVar2 != null && aVar2.b() && !aVar2.a().equals(str)) {
                    if (aVar == null || aVar2.c() >= aVar.c()) {
                        aVar = aVar2;
                    }
                }
            }
            this.f32437e.unlock();
            return aVar != null ? aVar.a() : TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        public String f() {
            this.f32437e.lock();
            a aVar = null;
            for (Map.Entry next : this.f32433a.entrySet()) {
                next.getKey();
                next.getValue();
                a aVar2 = (a) next.getValue();
                if (aVar2 != null && aVar2.b()) {
                    if (aVar == null || aVar2.c() >= aVar.c()) {
                        aVar = aVar2;
                    }
                }
            }
            this.f32437e.unlock();
            return aVar != null ? aVar.a() : TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        public String g() {
            this.f32437e.lock();
            a aVar = this.f32433a.get(this.f32436d);
            String str = (aVar == null || !aVar.b()) ? null : this.f32436d;
            this.f32437e.unlock();
            return str;
        }

        public String h() {
            this.f32437e.lock();
            String m = m();
            this.f32437e.unlock();
            return m;
        }

        public String i() {
            this.f32437e.lock();
            String n = n();
            this.f32437e.unlock();
            return n;
        }

        public boolean f(String str) {
            boolean z;
            this.f32437e.lock();
            a aVar = this.f32433a.get(str);
            if (aVar == null || !aVar.b()) {
                z = false;
            } else {
                this.f32436d = str;
                z = true;
            }
            this.f32437e.unlock();
            return z;
        }

        public boolean g(String str) {
            boolean z;
            this.f32437e.lock();
            a aVar = this.f32433a.get(str);
            if (aVar == null || !aVar.b()) {
                z = false;
            } else {
                String str2 = this.f32435c;
                if (str2 != null && !str2.equals(str)) {
                    this.f32434b = this.f32435c;
                }
                this.f32435c = str;
                this.f32436d = "";
                z = true;
            }
            this.f32437e.unlock();
            return z;
        }

        public HashMap<String, Object> j() {
            HashMap<String, Object> hashMap = new HashMap<>();
            this.f32437e.lock();
            hashMap.put(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, l());
            hashMap.put(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, m());
            hashMap.put(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, n());
            this.f32437e.unlock();
            return hashMap;
        }

        public ArrayList<String> k() {
            new ArrayList();
            this.f32437e.lock();
            ArrayList<String> l = l();
            this.f32437e.unlock();
            return l;
        }

        /* access modifiers changed from: package-private */
        public ArrayList<String> l() {
            ArrayList<String> arrayList = new ArrayList<>();
            for (Map.Entry<String, a> value : this.f32433a.entrySet()) {
                a aVar = (a) value.getValue();
                if (aVar != null && aVar.b()) {
                    arrayList.add(aVar.a());
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public String m() {
            a aVar = this.f32433a.get(this.f32435c);
            return (aVar == null || !aVar.b()) ? TraeAudioManager.DEVICE_NONE : this.f32435c;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            a aVar = this.f32433a.get(this.f32434b);
            return (aVar == null || !aVar.b()) ? TraeAudioManager.DEVICE_NONE : this.f32434b;
        }
    }

    /* access modifiers changed from: package-private */
    public void printDevices() {
        AudioDeviceInterface.LogTraceEntry("");
        int e2 = this._deviceConfigManager.e();
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   ConnectedDevice:" + this._deviceConfigManager.h());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   ConnectingDevice:" + this._deviceConfigManager.g());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   prevConnectedDevice:" + this._deviceConfigManager.i());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   AHPDevice:" + this._deviceConfigManager.f());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   deviceNamber:" + e2);
        }
        for (int i2 = 0; i2 < e2; i2++) {
            String a2 = this._deviceConfigManager.a(i2);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "      " + i2 + " devName:" + a2 + " Visible:" + this._deviceConfigManager.c(a2) + " Priority:" + this._deviceConfigManager.d(a2));
            }
        }
        String[] strArr = (String[]) this._deviceConfigManager.k().toArray(new String[0]);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   AvailableNamber:" + strArr.length);
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "      " + i3 + " devName:" + str + " Visible:" + this._deviceConfigManager.c(str) + " Priority:" + this._deviceConfigManager.d(str));
            }
        }
        AudioDeviceInterface.LogTraceExit();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean isCloseSystemAPM(int r3) {
        /*
            r0 = 0
            r1 = -1
            if (r3 == r1) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r3 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "Xiaomi"
            boolean r3 = r3.equals(r1)
            r1 = 1
            if (r3 == 0) goto L_0x003c
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r2 = "MI 2"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x001b
            return r1
        L_0x001b:
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r2 = "MI 2A"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0026
            return r1
        L_0x0026:
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r2 = "MI 2S"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0031
            return r1
        L_0x0031:
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r2 = "MI 2SC"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0051
            return r1
        L_0x003c:
            java.lang.String r3 = android.os.Build.MANUFACTURER
            java.lang.String r2 = "samsung"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0051
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r2 = "SCH-I959"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0051
            return r1
        L_0x0051:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.TraeAudioManager.isCloseSystemAPM(int):boolean");
    }

    public static boolean IsEabiLowVersionByAbi(String str) {
        if (str == null) {
            return true;
        }
        if (str.contains("x86") || str.contains("mips")) {
            return false;
        }
        if (str.equalsIgnoreCase("armeabi")) {
            return true;
        }
        return !str.equalsIgnoreCase("armeabi-v7a") && !str.equalsIgnoreCase("arm64-v8a");
    }

    static boolean IsEabiLowVersion() {
        String str;
        String str2 = Build.CPU_ABI;
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                str = (String) Build.class.getDeclaredField("CPU_ABI2").get((Object) null);
            } catch (Exception unused) {
                return IsEabiLowVersionByAbi(str2);
            }
        } else {
            str = "unknown";
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "IsEabiVersion CPU_ABI:" + str2 + " CPU_ABI2:" + str);
        }
        return IsEabiLowVersionByAbi(str2) && IsEabiLowVersionByAbi(str);
    }

    static int getAudioSource(int i2) {
        int i3 = 0;
        if (IsMusicScene) {
            return 0;
        }
        if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + i2 + " source:" + 0);
            }
            return 0;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i2 >= 0) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + i2 + " source:" + i2);
            }
            return i2;
        }
        if (i4 >= 11) {
            i3 = 7;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + i2 + " source:" + i3);
        }
        return i3;
    }

    static int getAudioStreamType(int i2) {
        if (IsMusicScene) {
            return 3;
        }
        if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + i2 + " streamType:" + 3);
            }
            return 3;
        }
        int i3 = i2 >= 0 ? i2 : Build.VERSION.SDK_INT >= 9 ? 0 : 3;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + i2 + " streamType:" + i3);
        }
        return i3;
    }

    static int getCallAudioMode(int i2) {
        int i3 = 0;
        if (IsMusicScene) {
            return 0;
        }
        if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + i2 + " mode:" + 0);
            }
            return 0;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i2 >= 0) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] getCallAudioMode modePolicy:" + i2 + " mode:" + i2);
            }
            return i2;
        }
        if (i4 >= 11) {
            i3 = 3;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "[Config] getCallAudioMode _modePolicy:" + i2 + " mode:" + i3 + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public void updateDeviceStatus() {
        boolean z;
        int e2 = this._deviceConfigManager.e();
        for (int i2 = 0; i2 < e2; i2++) {
            String a2 = this._deviceConfigManager.a(i2);
            if (a2 != null) {
                if (a2.equals(DEVICE_BLUETOOTHHEADSET)) {
                    d dVar = this._bluetoothCheck;
                    if (dVar == null) {
                        z = this._deviceConfigManager.a(a2, false);
                    } else {
                        z = this._deviceConfigManager.a(a2, dVar.b());
                    }
                } else if (a2.equals(DEVICE_WIREDHEADSET)) {
                    z = this._deviceConfigManager.a(a2, this._am.isWiredHeadsetOn());
                } else if (a2.equals(DEVICE_SPEAKERPHONE)) {
                    this._deviceConfigManager.a(a2, true);
                }
                if (z && QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "pollUpdateDevice dev:" + a2 + " Visible:" + this._deviceConfigManager.c(a2));
                }
            }
            z = false;
            QLog.w("TRAE", 2, "pollUpdateDevice dev:" + a2 + " Visible:" + this._deviceConfigManager.c(a2));
        }
        checkAutoDeviceListUpdate();
    }

    /* access modifiers changed from: package-private */
    public void _updateEarphoneVisable() {
        if (this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " detected headset plugin,so disable earphone");
            }
            this._deviceConfigManager.a(DEVICE_EARPHONE, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " detected headset plugout,so enable earphone");
        }
        this._deviceConfigManager.a(DEVICE_EARPHONE, true);
    }

    /* access modifiers changed from: package-private */
    public void checkAutoDeviceListUpdate() {
        if (this._deviceConfigManager.b()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "checkAutoDeviceListUpdate got update!");
            }
            _updateEarphoneVisable();
            this._deviceConfigManager.c();
            internalSendMessage(32785, new HashMap());
        }
    }

    /* access modifiers changed from: package-private */
    public void checkDevicePlug(String str, boolean z) {
        if (this._deviceConfigManager.b()) {
            if (QLog.isColorLevel()) {
                StringBuilder sb = new StringBuilder();
                sb.append("checkDevicePlug got update dev:");
                sb.append(str);
                sb.append(z ? " piugin" : " plugout");
                sb.append(" connectedDev:");
                sb.append(this._deviceConfigManager.h());
                QLog.w("TRAE", 2, sb.toString());
            }
            _updateEarphoneVisable();
            this._deviceConfigManager.c();
            if (z) {
                HashMap hashMap = new HashMap();
                hashMap.put(PARAM_DEVICE, str);
                internalSendMessage(32786, hashMap);
                return;
            }
            String h2 = this._deviceConfigManager.h();
            if (h2.equals(str) || h2.equals(DEVICE_NONE)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(PARAM_DEVICE, str);
                internalSendMessage(32787, hashMap2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " ---No switch,plugout:" + str + " connectedDev:" + h2);
            }
            internalSendMessage(32785, new HashMap());
        }
    }

    class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        Handler f32444a = null;

        /* renamed from: b  reason: collision with root package name */
        TraeMediaPlayer f32445b = null;

        /* renamed from: c  reason: collision with root package name */
        long f32446c = -1;

        /* renamed from: d  reason: collision with root package name */
        String f32447d = "";

        /* renamed from: e  reason: collision with root package name */
        String f32448e = "";

        /* renamed from: f  reason: collision with root package name */
        final boolean[] f32449f = {false};

        /* renamed from: g  reason: collision with root package name */
        boolean f32450g = false;
        TraeAudioManager h = null;
        String i = "";
        int j = 0;
        int k = 0;
        long l = -1;
        String m = "";
        AudioManager.OnAudioFocusChangeListener n = null;
        int o = 0;

        /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|(2:8|9)|10|11) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x005b */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public f(com.tencent.rtmp.sharp.jni.TraeAudioManager r7) {
            /*
                r5 = this;
                com.tencent.rtmp.sharp.jni.TraeAudioManager.this = r6
                r5.<init>()
                r6 = 0
                r5.f32444a = r6
                r5.f32445b = r6
                r0 = -1
                r5.f32446c = r0
                java.lang.String r2 = ""
                r5.f32447d = r2
                java.lang.String r2 = ""
                r5.f32448e = r2
                r2 = 1
                boolean[] r2 = new boolean[r2]
                r3 = 0
                r2[r3] = r3
                r5.f32449f = r2
                r5.f32450g = r3
                r5.h = r6
                java.lang.String r2 = ""
                r5.i = r2
                r5.j = r3
                r5.k = r3
                r5.l = r0
                java.lang.String r0 = ""
                r5.m = r0
                r5.n = r6
                r5.o = r3
                r5.h = r7
                long r6 = android.os.SystemClock.elapsedRealtime()
                boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
                r1 = 2
                if (r0 == 0) goto L_0x0048
                java.lang.String r0 = "TRAE"
                java.lang.String r2 = "TraeAudioManagerLooper start..."
                com.tencent.qphone.base.util.QLog.e(r0, r1, r2)
            L_0x0048:
                r5.start()
                boolean[] r0 = r5.f32449f
                monitor-enter(r0)
                boolean[] r2 = r5.f32449f     // Catch:{ all -> 0x0083 }
                boolean r2 = r2[r3]     // Catch:{ all -> 0x0083 }
                if (r2 != 0) goto L_0x005b
                boolean[] r2 = r5.f32449f     // Catch:{ InterruptedException -> 0x005b }
                r3 = 3000(0xbb8, double:1.482E-320)
                r2.wait(r3)     // Catch:{ InterruptedException -> 0x005b }
            L_0x005b:
                monitor-exit(r0)     // Catch:{ all -> 0x0083 }
                boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
                if (r0 == 0) goto L_0x0082
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "  start used:"
                r0.append(r2)
                long r2 = android.os.SystemClock.elapsedRealtime()
                long r2 = r2 - r6
                r0.append(r2)
                java.lang.String r6 = "ms"
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                java.lang.String r7 = "TRAE"
                com.tencent.qphone.base.util.QLog.e(r7, r1, r6)
            L_0x0082:
                return
            L_0x0083:
                r6 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0083 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.TraeAudioManager.f.<init>(com.tencent.rtmp.sharp.jni.TraeAudioManager, com.tencent.rtmp.sharp.jni.TraeAudioManager):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|(2:9|10)|11|12) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0029 */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r6 = this;
                java.lang.String r0 = ""
                com.tencent.rtmp.sharp.jni.AudioDeviceInterface.LogTraceEntry(r0)
                android.os.Handler r0 = r6.f32444a
                if (r0 != 0) goto L_0x000a
                return
            L_0x000a:
                long r0 = android.os.SystemClock.elapsedRealtime()
                android.os.Handler r2 = r6.f32444a
                android.os.Looper r2 = r2.getLooper()
                r2.quit()
                boolean[] r2 = r6.f32449f
                monitor-enter(r2)
                boolean[] r3 = r6.f32449f     // Catch:{ all -> 0x0058 }
                r4 = 0
                boolean r3 = r3[r4]     // Catch:{ all -> 0x0058 }
                r4 = 1
                if (r3 != r4) goto L_0x0029
                boolean[] r3 = r6.f32449f     // Catch:{ InterruptedException -> 0x0029 }
                r4 = 10000(0x2710, double:4.9407E-320)
                r3.wait(r4)     // Catch:{ InterruptedException -> 0x0029 }
            L_0x0029:
                monitor-exit(r2)     // Catch:{ all -> 0x0058 }
                boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()
                if (r2 == 0) goto L_0x0051
                r2 = 2
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "  quit used:"
                r3.append(r4)
                long r4 = android.os.SystemClock.elapsedRealtime()
                long r4 = r4 - r0
                r3.append(r4)
                java.lang.String r0 = "ms"
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                java.lang.String r1 = "TRAE"
                com.tencent.qphone.base.util.QLog.e(r1, r2, r0)
            L_0x0051:
                r0 = 0
                r6.f32444a = r0
                com.tencent.rtmp.sharp.jni.AudioDeviceInterface.LogTraceExit()
                return
            L_0x0058:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0058 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.TraeAudioManager.f.a():void");
        }

        public int a(int i2, HashMap<String, Object> hashMap) {
            Handler handler = this.f32444a;
            if (handler == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" fail mMsgHandler==null _enabled:");
                sb.append(this.f32450g ? "Y" : "N");
                sb.append(" activeMode:");
                sb.append(TraeAudioManager.this._activeMode);
                sb.append(" msg:");
                sb.append(i2);
                AudioDeviceInterface.LogTraceEntry(sb.toString());
                return -1;
            }
            if (this.f32444a.sendMessage(Message.obtain(handler, i2, hashMap))) {
                return 0;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public void a(HashMap<String, Object> hashMap) {
            String str = (String) hashMap.get(TraeAudioManager.EXTRA_DATA_DEVICECONFIG);
            Log.w("TRAE", "startService cfg:" + str);
            StringBuilder sb = new StringBuilder();
            sb.append(" _enabled:");
            sb.append(this.f32450g ? "Y" : "N");
            sb.append(" activeMode:");
            sb.append(TraeAudioManager.this._activeMode);
            sb.append(" cfg:");
            sb.append(str);
            AudioDeviceInterface.LogTraceEntry(sb.toString());
            if (TraeAudioManager.this._context != null) {
                QLog.w("TRAE", 2, "   startService:" + str);
                if ((!this.f32450g || !this.i.equals(str)) && TraeAudioManager.this._activeMode == 0) {
                    if (this.f32450g) {
                        c();
                    }
                    e();
                    AudioManager audioManager = (AudioManager) TraeAudioManager.this._context.getSystemService("audio");
                    TraeAudioManager.this._deviceConfigManager.a();
                    TraeAudioManager.this._deviceConfigManager.a(str);
                    this.i = str;
                    if (TraeAudioManager.this._am != null) {
                        this.j = TraeAudioManager.this._am.getMode();
                    }
                    this.f32450g = true;
                    if (this.f32445b == null) {
                        this.f32445b = new TraeMediaPlayer(TraeAudioManager.this._context, new TraeMediaPlayer.a() {
                            public void a() {
                                if (QLog.isColorLevel()) {
                                    QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + f.this.k);
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put(TraeAudioManager.PARAM_ISHOSTSIDE, true);
                                f.this.a(32783, hashMap);
                                f.this.k();
                            }
                        });
                    }
                    a(this.f32450g);
                    TraeAudioManager.this.updateDeviceStatus();
                    AudioDeviceInterface.LogTraceExit();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            if (!Build.MANUFACTURER.equals("Xiaomi")) {
                return false;
            }
            if (!Build.MODEL.equals("MI 5") && !Build.MODEL.equals("MI 5s") && !Build.MODEL.equals("MI 5s Plus")) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            StringBuilder sb = new StringBuilder();
            sb.append(" _enabled:");
            sb.append(this.f32450g ? "Y" : "N");
            sb.append(" activeMode:");
            sb.append(TraeAudioManager.this._activeMode);
            AudioDeviceInterface.LogTraceEntry(sb.toString());
            if (this.f32450g) {
                if (TraeAudioManager.this._activeMode == 1) {
                    i();
                } else if (TraeAudioManager.this._activeMode == 2) {
                    j();
                }
                if (TraeAudioManager.this._switchThread != null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "_switchThread:" + TraeAudioManager.this._switchThread.b());
                    }
                    TraeAudioManager.this._switchThread.g();
                    TraeAudioManager.this._switchThread = null;
                }
                TraeMediaPlayer traeMediaPlayer = this.f32445b;
                if (traeMediaPlayer != null) {
                    traeMediaPlayer.stopRing();
                }
                this.f32445b = null;
                this.f32450g = false;
                a(this.f32450g);
                if (!(TraeAudioManager.this._am == null || TraeAudioManager.this._context == null)) {
                    try {
                        TraeAudioManager.this.InternalSetMode(0);
                        if (b()) {
                            QLog.w("TRAE", 2, "NeedForceVolumeType: AudioManager.STREAM_MUSIC");
                            TraeAudioManager.forceVolumeControlStream(TraeAudioManager.this._am, 3);
                        }
                    } catch (Exception unused) {
                    }
                }
                f();
                AudioDeviceInterface.LogTraceExit();
            }
        }

        /* access modifiers changed from: package-private */
        public int a(boolean z) {
            if (TraeAudioManager.this._context == null) {
                return -1;
            }
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_SERVICE_STATE);
            intent.putExtra(TraeAudioManager.NOTIFY_SERVICE_STATE_DATE, z);
            if (TraeAudioManager.this._context == null) {
                return 0;
            }
            TraeAudioManager.this._context.sendBroadcast(intent);
            return 0;
        }

        public void run() {
            AudioDeviceInterface.LogTraceEntry("");
            Looper.prepare();
            this.f32444a = new Handler() {
                public void handleMessage(Message message) {
                    HashMap hashMap;
                    try {
                        hashMap = (HashMap) message.obj;
                    } catch (Exception unused) {
                        hashMap = null;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("TraeAudioManagerLooper msg:");
                        sb.append(message.what);
                        sb.append(" _enabled:");
                        sb.append(f.this.f32450g ? "Y" : "N");
                        QLog.w("TRAE", 2, sb.toString());
                    }
                    if (message.what == 32772) {
                        f.this.a((HashMap<String, Object>) hashMap);
                    } else if (!f.this.f32450g) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "******* disabled ,skip msg******");
                        }
                        TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 1);
                    } else {
                        switch (message.what) {
                            case 32773:
                                f.this.c();
                                return;
                            case 32774:
                                f.this.b((HashMap<String, Object>) hashMap);
                                return;
                            case 32775:
                                TraeAudioManager.this.InternalSessionConnectDevice(hashMap);
                                return;
                            case 32776:
                                TraeAudioManager.this.InternalSessionEarAction(hashMap);
                                return;
                            case 32777:
                                TraeAudioManager.this.InternalSessionIsDeviceChangabled(hashMap);
                                return;
                            case 32778:
                                TraeAudioManager.this.InternalSessionGetConnectedDevice(hashMap);
                                return;
                            case 32779:
                                TraeAudioManager.this.InternalSessionGetConnectingDevice(hashMap);
                                return;
                            case 32780:
                                f.this.c(hashMap);
                                return;
                            case 32781:
                                f.this.d(hashMap);
                                return;
                            case 32782:
                                f.this.e(hashMap);
                                return;
                            case 32783:
                                f.this.f(hashMap);
                                return;
                            case 32784:
                                f.this.g(hashMap);
                                return;
                            case 32785:
                            case 32789:
                                String f2 = TraeAudioManager.this._deviceConfigManager.f();
                                String h = TraeAudioManager.this._deviceConfigManager.h();
                                if (QLog.isColorLevel()) {
                                    QLog.w("TRAE", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + h + " highestDev" + f2);
                                }
                                if (TraeAudioManager.IsUpdateSceneFlag) {
                                    if (!TraeAudioManager.IsMusicScene || TraeAudioManager.this.IsBluetoothA2dpExisted) {
                                        TraeAudioManager.this.InternalConnectDevice(f2, (HashMap<String, Object>) null, true);
                                        return;
                                    } else {
                                        TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.e(TraeAudioManager.DEVICE_BLUETOOTHHEADSET), (HashMap<String, Object>) null, true);
                                        return;
                                    }
                                } else if (!f2.equals(h)) {
                                    TraeAudioManager.this.InternalConnectDevice(f2, (HashMap<String, Object>) null, false);
                                    return;
                                } else {
                                    TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                                    return;
                                }
                            case 32786:
                                String str = (String) hashMap.get(TraeAudioManager.PARAM_DEVICE);
                                if (TraeAudioManager.this.InternalConnectDevice(str, (HashMap<String, Object>) null, false) != 0) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, " plugin dev:" + str + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
                                    }
                                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.f(), (HashMap<String, Object>) null, false);
                                    return;
                                }
                                return;
                            case 32787:
                                if (TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this.sessionConnectedDev, (HashMap<String, Object>) null, false) != 0) {
                                    String str2 = (String) hashMap.get(TraeAudioManager.PARAM_DEVICE);
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, " plugout dev:" + str2 + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
                                    }
                                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.f(), (HashMap<String, Object>) null, false);
                                    return;
                                }
                                return;
                            case 32788:
                                Integer num = (Integer) hashMap.get(TraeAudioManager.PARAM_STREAMTYPE);
                                if (num != null) {
                                    TraeAudioManager.this._streamType = num.intValue();
                                    f.this.b(num.intValue());
                                    return;
                                } else if (QLog.isColorLevel()) {
                                    QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
                                    return;
                                } else {
                                    return;
                                }
                            case 32790:
                                f.this.h();
                                return;
                            case 32791:
                                f fVar = f.this;
                                fVar.a(TraeAudioManager.this._streamType);
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            d();
            synchronized (this.f32449f) {
                this.f32449f[0] = true;
                this.f32449f.notifyAll();
            }
            Looper.loop();
            g();
            synchronized (this.f32449f) {
                this.f32449f[0] = false;
                this.f32449f.notifyAll();
            }
            AudioDeviceInterface.LogTraceExit();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            AudioDeviceInterface.LogTraceEntry("");
            try {
                TraeAudioManager.this._audioSessionHost = new TraeAudioSessionHost();
                TraeAudioManager.this._deviceConfigManager = new e();
                TraeAudioManager._gHostProcessId = Process.myPid();
                TraeAudioManager.this._am = (AudioManager) TraeAudioManager.this._context.getSystemService("audio");
                TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                TraeAudioManager.this._bluetoothCheck.b(intentFilter);
                intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                TraeAudioManager.this._context.registerReceiver(this.h, intentFilter);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "======7");
                }
            }
            AudioDeviceInterface.LogTraceExit();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            try {
                TraeAudioManager.this._am = (AudioManager) TraeAudioManager.this._context.getSystemService("audio");
                if (TraeAudioManager.this._bluetoothCheck == null) {
                    TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
                }
                TraeAudioManager.this._context.unregisterReceiver(this.h);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                TraeAudioManager.this._bluetoothCheck.b(intentFilter);
                intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                TraeAudioManager.this._context.registerReceiver(this.h, intentFilter);
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            try {
                if (TraeAudioManager.this._bluetoothCheck != null) {
                    TraeAudioManager.this._bluetoothCheck.a();
                }
                TraeAudioManager.this._bluetoothCheck = null;
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.unregisterReceiver(this.h);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                    TraeAudioManager.this._context.registerReceiver(this.h, intentFilter);
                }
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            AudioDeviceInterface.LogTraceEntry("");
            try {
                c();
                if (TraeAudioManager.this._bluetoothCheck != null) {
                    TraeAudioManager.this._bluetoothCheck.a();
                }
                TraeAudioManager.this._bluetoothCheck = null;
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.unregisterReceiver(this.h);
                    TraeAudioManager.this._context = null;
                }
                if (TraeAudioManager.this._deviceConfigManager != null) {
                    TraeAudioManager.this._deviceConfigManager.a();
                }
                TraeAudioManager.this._deviceConfigManager = null;
            } catch (Exception unused) {
            }
            AudioDeviceInterface.LogTraceExit();
        }

        /* access modifiers changed from: package-private */
        public int b(HashMap<String, Object> hashMap) {
            Intent intent = new Intent();
            HashMap<String, Object> j2 = TraeAudioManager.this._deviceConfigManager.j();
            intent.putExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, (String[]) ((ArrayList) j2.get(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST)).toArray(new String[0]));
            intent.putExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, (String) j2.get(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE));
            intent.putExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, (String) j2.get(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE));
            intent.putExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME, TraeAudioManager.this._deviceConfigManager.d());
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            return 0;
        }

        /* access modifiers changed from: package-private */
        @TargetApi(8)
        public void a(int i2) {
            if (Build.VERSION.SDK_INT > 8 && this.n == null) {
                this.n = new AudioManager.OnAudioFocusChangeListener() {
                    @TargetApi(8)
                    public void onAudioFocusChange(int i) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "focusChange:" + i + " _focusSteamType:" + f.this.o + " currMode:" + TraeAudioManager.this._am.getMode() + " _activeMode:" + TraeAudioManager.this._activeMode);
                        }
                        if (i != -1 && i != -2) {
                        }
                    }
                };
                if (TraeAudioManager.this._am != null) {
                    try {
                        int requestAudioFocus = TraeAudioManager.this._am.requestAudioFocus(this.n, i2, 1);
                        if (requestAudioFocus != 1 && QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "request audio focus fail. " + requestAudioFocus + " mode:" + TraeAudioManager.this._am.getMode());
                        }
                        this.o = i2;
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "-------requestAudioFocus _focusSteamType:" + this.o);
                        }
                    } catch (SecurityException e2) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "request audio focus exception. " + e2);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        @TargetApi(8)
        public void h() {
            if (Build.VERSION.SDK_INT > 8 && TraeAudioManager.this._am != null && this.n != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "-------abandonAudioFocus _focusSteamType:" + this.o);
                }
                TraeAudioManager.this._am.abandonAudioFocus(this.n);
                this.n = null;
            }
        }

        /* access modifiers changed from: package-private */
        public int c(HashMap<String, Object> hashMap) {
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (hashMap == null) {
                return -1;
            }
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalVoicecallPreprocess am==null!!");
                }
                return -1;
            } else if (TraeAudioManager.this._activeMode == 1) {
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 2);
                return -1;
            } else {
                this.l = ((Long) hashMap.get(TraeAudioManager.PARAM_SESSIONID)).longValue();
                this.m = (String) hashMap.get(TraeAudioManager.PARAM_OPERATION);
                TraeAudioManager traeAudioManager = TraeAudioManager.this;
                traeAudioManager._activeMode = 1;
                traeAudioManager._prevMode = traeAudioManager._am.getMode();
                Integer.valueOf(-1);
                Integer.valueOf(0);
                Integer num = (Integer) hashMap.get(TraeAudioManager.PARAM_MODEPOLICY);
                if (num == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, " params.get(PARAM_MODEPOLICY)==null!!");
                    }
                    TraeAudioManager.this._modePolicy = -1;
                } else {
                    TraeAudioManager.this._modePolicy = num.intValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "  _modePolicy:" + TraeAudioManager.this._modePolicy);
                }
                Integer num2 = (Integer) hashMap.get(TraeAudioManager.PARAM_STREAMTYPE);
                if (num2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, " params.get(PARAM_STREAMTYPE)==null!!");
                    }
                    TraeAudioManager.this._streamType = 0;
                } else {
                    TraeAudioManager.this._streamType = num2.intValue();
                }
                if (!TraeAudioManager.isCloseSystemAPM(TraeAudioManager.this._modePolicy) || TraeAudioManager.this._activeMode == 2 || TraeAudioManager.this._deviceConfigManager == null) {
                    TraeAudioManager traeAudioManager2 = TraeAudioManager.this;
                    traeAudioManager2.InternalSetMode(TraeAudioManager.getCallAudioMode(traeAudioManager2._modePolicy));
                    a(TraeAudioManager.this._streamType);
                } else if (TraeAudioManager.this._deviceConfigManager.h().equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    TraeAudioManager.this.InternalSetMode(0);
                    a(3);
                } else {
                    TraeAudioManager.this.InternalSetMode(3);
                    a(0);
                }
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 0);
                AudioDeviceInterface.LogTraceExit();
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int d(HashMap<String, Object> hashMap) {
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalVoicecallPostprocess am==null!!");
                }
                return -1;
            } else if (TraeAudioManager.this._activeMode != 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_VOICECALL!!");
                }
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 3);
                return -1;
            } else {
                TraeAudioManager.this._activeMode = 0;
                h();
                AudioDeviceInterface.LogTraceExit();
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int i() {
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " am==null!!");
                }
                return -1;
            } else if (TraeAudioManager.this._activeMode != 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
                }
                return -1;
            } else {
                TraeAudioManager traeAudioManager = TraeAudioManager.this;
                traeAudioManager._activeMode = 0;
                if (traeAudioManager._prevMode != -1) {
                    TraeAudioManager traeAudioManager2 = TraeAudioManager.this;
                    traeAudioManager2.InternalSetMode(traeAudioManager2._prevMode);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.l));
                hashMap.put(TraeAudioManager.PARAM_OPERATION, this.m);
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 6);
                AudioDeviceInterface.LogTraceExit();
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public int e(HashMap<String, Object> hashMap) {
            HashMap<String, Object> hashMap2 = hashMap;
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalStartRing am==null!!");
                }
                return -1;
            }
            if (TraeAudioManager.this._activeMode == 2) {
                j();
            }
            try {
                this.f32446c = ((Long) hashMap2.get(TraeAudioManager.PARAM_SESSIONID)).longValue();
                this.f32447d = (String) hashMap2.get(TraeAudioManager.PARAM_OPERATION);
                this.f32448e = (String) hashMap2.get(TraeAudioManager.PARAM_RING_USERDATA_STRING);
                int intValue = ((Integer) hashMap2.get(TraeAudioManager.PARAM_RING_DATASOURCE)).intValue();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "  dataSource:" + intValue);
                }
                int intValue2 = ((Integer) hashMap2.get(TraeAudioManager.PARAM_RING_RSID)).intValue();
                Uri uri = (Uri) hashMap2.get(TraeAudioManager.PARAM_RING_URI);
                String str = (String) hashMap2.get(TraeAudioManager.PARAM_RING_FILEPATH);
                boolean booleanValue = ((Boolean) hashMap2.get(TraeAudioManager.PARAM_RING_LOOP)).booleanValue();
                int intValue3 = ((Integer) hashMap2.get(TraeAudioManager.PARAM_RING_LOOPCOUNT)).intValue();
                boolean booleanValue2 = ((Boolean) hashMap2.get(TraeAudioManager.PARAM_RING_MODE)).booleanValue();
                boolean z = true;
                if (TraeAudioManager.this._activeMode != 1) {
                    TraeAudioManager.this._activeMode = 2;
                }
                Intent intent = new Intent();
                intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.f32448e);
                TraeAudioManager.this.sendResBroadcast(intent, hashMap2, 0);
                this.k = TraeAudioManager.this._am.getMode();
                TraeMediaPlayer traeMediaPlayer = this.f32445b;
                if (TraeAudioManager.this._activeMode != 1) {
                    z = false;
                }
                traeMediaPlayer.playRing(intValue, intValue2, uri, str, booleanValue, intValue3, booleanValue2, z, TraeAudioManager.this._streamType);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " _ringUserdata:" + this.f32448e + " DurationMS:" + this.f32445b.getDuration());
                }
                if (!this.f32445b.hasCall()) {
                    a(this.f32445b.getStreamType());
                }
                b(this.f32445b.getStreamType());
                AudioDeviceInterface.LogTraceExit();
                return 0;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " startRing err params");
                }
                return -1;
            }
        }

        /* access modifiers changed from: package-private */
        public int f(HashMap<String, Object> hashMap) {
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this.k);
            if (TraeAudioManager.this._am != null) {
                TraeMediaPlayer traeMediaPlayer = this.f32445b;
                if (traeMediaPlayer != null) {
                    traeMediaPlayer.stopRing();
                    if (!this.f32445b.hasCall() && TraeAudioManager.this._activeMode == 2) {
                        h();
                        TraeAudioManager.this._activeMode = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.f32448e);
                    TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
                    AudioDeviceInterface.LogTraceExit();
                    return 0;
                }
            }
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("TRAE", 2, " InternalStopRing am==null!!");
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int g(HashMap<String, Object> hashMap) {
            int i2;
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this.k);
            if (TraeAudioManager.this._am != null) {
                if (TraeAudioManager.this._activeMode == 2) {
                    i2 = this.f32445b.getStreamType();
                } else {
                    i2 = TraeAudioManager.this._streamType;
                }
                Intent intent = new Intent();
                intent.putExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, i2);
                TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
                AudioDeviceInterface.LogTraceExit();
                return 0;
            } else if (!QLog.isColorLevel()) {
                return -1;
            } else {
                QLog.e("TRAE", 2, " InternalStopRing am==null!!");
                return -1;
            }
        }

        /* access modifiers changed from: package-private */
        public int b(final int i2) {
            if (TraeAudioManager.this._context == null) {
                return -1;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    Intent intent = new Intent();
                    intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                    intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_STREAMTYPE_UPDATE);
                    intent.putExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, i2);
                    if (TraeAudioManager.this._context != null) {
                        TraeAudioManager.this._context.sendBroadcast(intent);
                    }
                }
            });
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int j() {
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this.k);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " interruptRing am==null!!");
                }
                return -1;
            } else if (TraeAudioManager.this._activeMode != 2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
                }
                return -1;
            } else {
                this.f32445b.stopRing();
                h();
                TraeAudioManager.this._activeMode = 0;
                HashMap hashMap = new HashMap();
                hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.f32446c));
                hashMap.put(TraeAudioManager.PARAM_OPERATION, this.f32447d);
                Intent intent = new Intent();
                intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.f32448e);
                TraeAudioManager.this.sendResBroadcast(intent, hashMap, 4);
                AudioDeviceInterface.LogTraceExit();
                return 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            HashMap hashMap = new HashMap();
            hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.f32446c));
            hashMap.put(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_RING_COMPLETION);
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.f32448e);
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
        }
    }

    public static int SetSpeakerForTest(Context context, boolean z) {
        int i2;
        _glock.lock();
        TraeAudioManager traeAudioManager = _ginstance;
        if (traeAudioManager != null) {
            i2 = traeAudioManager.InternalSetSpeaker(context, z);
        } else {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "TraeAudioManager|static SetSpeakerForTest|null == _ginstance");
            }
            i2 = -1;
        }
        _glock.unlock();
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int InternalSetSpeaker(Context context, boolean z) {
        int i2 = -1;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no context");
            }
            return -1;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no audio manager");
            }
            return -1;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb = new StringBuilder();
            sb.append("InternalSetSpeaker entry:speaker:");
            String str = "Y";
            sb.append(audioManager.isSpeakerphoneOn() ? str : "N");
            sb.append("-->:");
            if (!z) {
                str = "N";
            }
            sb.append(str);
            QLog.w("TRAE", 2, sb.toString());
        }
        if (isCloseSystemAPM(this._modePolicy) && this._activeMode != 2) {
            return InternalSetSpeakerSpe(audioManager, z);
        }
        if (audioManager.isSpeakerphoneOn() != z) {
            audioManager.setSpeakerphoneOn(z);
        }
        if (audioManager.isSpeakerphoneOn() == z) {
            i2 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeaker exit:" + z + " res:" + i2 + " mode:" + audioManager.getMode());
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int InternalSetSpeakerSpe(AudioManager audioManager, boolean z) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
        }
        int i2 = 0;
        if (z) {
            InternalSetMode(0);
            audioManager.setSpeakerphoneOn(true);
            setForceUse(1, 1);
        } else {
            InternalSetMode(3);
            audioManager.setSpeakerphoneOn(false);
            setForceUse(1, 0);
        }
        if (audioManager.isSpeakerphoneOn() != z) {
            i2 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeakerSpe exit:" + z + " res:" + i2 + " mode:" + audioManager.getMode());
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void InternalSetMode(int i2) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "SetMode entry:" + i2);
        }
        AudioManager audioManager = this._am;
        if (audioManager != null) {
            audioManager.setMode(i2);
            if (QLog.isColorLevel()) {
                StringBuilder sb = new StringBuilder();
                sb.append("setMode:");
                sb.append(i2);
                sb.append(this._am.getMode() != i2 ? "fail" : GraphResponse.SUCCESS_KEY);
                QLog.w("TRAE", 2, sb.toString());
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setMode:" + i2 + " fail am=null");
        }
    }

    public static int registerAudioSession(TraeAudioSession traeAudioSession, boolean z, long j2, Context context) {
        int i2;
        _glock.lock();
        TraeAudioManager traeAudioManager = _ginstance;
        if (traeAudioManager != null) {
            if (z) {
                traeAudioManager._audioSessionHost.add(traeAudioSession, j2, context);
            } else {
                traeAudioManager._audioSessionHost.remove(j2);
            }
            i2 = 0;
        } else {
            i2 = -1;
        }
        _glock.unlock();
        return i2;
    }

    public static int sendMessage(int i2, HashMap<String, Object> hashMap) {
        _glock.lock();
        TraeAudioManager traeAudioManager = _ginstance;
        int internalSendMessage = traeAudioManager != null ? traeAudioManager.internalSendMessage(i2, hashMap) : -1;
        _glock.unlock();
        return internalSendMessage;
    }

    public static int init(Context context) {
        Log.w("TRAE", "TraeAudioManager init _ginstance:" + _ginstance);
        AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
        _glock.lock();
        if (_ginstance == null) {
            _ginstance = new TraeAudioManager(context);
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public static void uninit() {
        Log.w("TRAE", "TraeAudioManager uninit _ginstance:" + _ginstance);
        AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
        _glock.lock();
        TraeAudioManager traeAudioManager = _ginstance;
        if (traeAudioManager != null) {
            traeAudioManager.release();
            _ginstance = null;
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
    }

    TraeAudioManager(Context context) {
        AudioDeviceInterface.LogTraceEntry(" context:" + context);
        if (context != null) {
            this._context = context;
            this.mTraeAudioManagerLooper = new f(this);
            f fVar = this.mTraeAudioManagerLooper;
            AudioDeviceInterface.LogTraceExit();
        }
    }

    public void release() {
        AudioDeviceInterface.LogTraceEntry("");
        f fVar = this.mTraeAudioManagerLooper;
        if (fVar != null) {
            fVar.a();
            this.mTraeAudioManagerLooper = null;
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public void onReceive(Context context, Intent intent) {
        Context context2 = context;
        Intent intent2 = intent;
        if (intent2 != null && context2 != null) {
            try {
                String action = intent.getAction();
                String stringExtra = intent2.getStringExtra(PARAM_OPERATION);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "TraeAudioManager|onReceive::Action:" + intent.getAction());
                }
                if (this._deviceConfigManager != null) {
                    boolean c2 = this._deviceConfigManager.c(DEVICE_WIREDHEADSET);
                    boolean c3 = this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET);
                    if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                        onHeadsetPlug(context, intent);
                        if (!c2 && this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
                            checkDevicePlug(DEVICE_WIREDHEADSET, true);
                        }
                        if (c2 && !this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
                            checkDevicePlug(DEVICE_WIREDHEADSET, false);
                        }
                    } else if (!"android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                        if (ACTION_TRAEAUDIOMANAGER_REQUEST.equals(action)) {
                            if (QLog.isColorLevel()) {
                                QLog.w("TRAE", 2, "   OPERATION:" + stringExtra);
                            }
                            if (OPERATION_STARTSERVICE.equals(stringExtra)) {
                                startService(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent2.getStringExtra(EXTRA_DATA_DEVICECONFIG));
                            } else if (OPERATION_STOPSERVICE.equals(stringExtra)) {
                                stopService(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_GETDEVICELIST.equals(stringExtra)) {
                                getDeviceList(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_GETSTREAMTYPE.equals(stringExtra)) {
                                getStreamType(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_CONNECTDEVICE.equals(stringExtra)) {
                                connectDevice(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent2.getStringExtra(CONNECTDEVICE_DEVICENAME));
                            } else if (OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE.equals(stringExtra)) {
                                connectHighestPriorityDevice(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_EARACTION.equals(stringExtra)) {
                                earAction(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent2.getIntExtra(EXTRA_EARACTION, -1));
                            } else if (OPERATION_ISDEVICECHANGABLED.equals(stringExtra)) {
                                isDeviceChangabled(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_GETCONNECTEDDEVICE.equals(stringExtra)) {
                                getConnectedDevice(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_GETCONNECTINGDEVICE.equals(stringExtra)) {
                                getConnectingDevice(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                                voicecallPreprocess(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent2.getIntExtra(PARAM_MODEPOLICY, -1), intent2.getIntExtra(PARAM_STREAMTYPE, -1));
                            } else if (OPERATION_VOICECALL_POSTPROCESS.equals(stringExtra)) {
                                voicecallPostprocess(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            } else if (OPERATION_VOICECALL_AUDIOPARAM_CHANGED.equals(stringExtra)) {
                                voiceCallAudioParamChanged(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent2.getIntExtra(PARAM_MODEPOLICY, -1), intent2.getIntExtra(PARAM_STREAMTYPE, -1));
                            } else if (OPERATION_STARTRING.equals(stringExtra)) {
                                int intExtra = intent2.getIntExtra(PARAM_RING_DATASOURCE, -1);
                                String stringExtra2 = intent2.getStringExtra(PARAM_RING_FILEPATH);
                                boolean booleanExtra = intent2.getBooleanExtra(PARAM_RING_LOOP, false);
                                String stringExtra3 = intent2.getStringExtra(PARAM_RING_USERDATA_STRING);
                                int intExtra2 = intent2.getIntExtra(PARAM_RING_LOOPCOUNT, 1);
                                boolean booleanExtra2 = intent2.getBooleanExtra(PARAM_RING_MODE, false);
                                startRing(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intExtra, intent2.getIntExtra(PARAM_RING_RSID, -1), (Uri) intent2.getParcelableExtra(PARAM_RING_URI), stringExtra2, booleanExtra, intExtra2, stringExtra3, booleanExtra2);
                            } else if (OPERATION_STOPRING.equals(stringExtra)) {
                                stopRing(stringExtra, intent2.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                            }
                        } else if (this._deviceConfigManager != null) {
                            if (this._bluetoothCheck != null) {
                                this._bluetoothCheck.a(context2, intent2, this._deviceConfigManager);
                            }
                            if (!c3 && this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET)) {
                                checkDevicePlug(DEVICE_BLUETOOTHHEADSET, true);
                            }
                            if (c3 && !this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET)) {
                                checkDevicePlug(DEVICE_BLUETOOTHHEADSET, false);
                            }
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "_deviceConfigManager null!");
                }
            } catch (Exception unused) {
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "onReceive intent or context is null!");
        }
    }

    /* access modifiers changed from: package-private */
    public void onHeadsetPlug(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("name");
        if (stringExtra == null) {
            stringExtra = "unkonw";
        }
        String str = "" + " [" + stringExtra + "] ";
        int intExtra = intent.getIntExtra(ServerProtocol.DIALOG_PARAM_STATE, -1);
        if (intExtra != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(intExtra == 0 ? "unplugged" : "plugged");
            str = sb.toString();
        }
        String str2 = str + " mic:";
        int intExtra2 = intent.getIntExtra("microphone", -1);
        boolean z = true;
        if (intExtra2 != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(intExtra2 == 1 ? "Y" : "unkown");
            str2 = sb2.toString();
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "onHeadsetPlug:: " + str2);
        }
        e eVar = this._deviceConfigManager;
        if (1 != intExtra) {
            z = false;
        }
        eVar.a(DEVICE_WIREDHEADSET, z);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "onHeadsetPlug exit");
        }
    }

    /* access modifiers changed from: package-private */
    public int internalSendMessage(int i2, HashMap<String, Object> hashMap) {
        f fVar = this.mTraeAudioManagerLooper;
        if (fVar != null) {
            return fVar.a(i2, hashMap);
        }
        return -1;
    }

    static int getDeviceList(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32774, hashMap);
    }

    static int getStreamType(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32784, hashMap);
    }

    static int startService(String str, long j2, boolean z, String str2) {
        if (str2.length() <= 0) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(EXTRA_DATA_DEVICECONFIG, str2);
        return sendMessage(32772, hashMap);
    }

    static int stopService(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32773, hashMap);
    }

    static int disableDeviceSwitch() {
        enableDeviceSwitchFlag = false;
        return 0;
    }

    static int connectDevice(String str, long j2, boolean z, String str2) {
        if (str2 == null) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(CONNECTDEVICE_DEVICENAME, str2);
        hashMap.put(PARAM_DEVICE, str2);
        return sendMessage(32775, hashMap);
    }

    static int connectHighestPriorityDevice(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32789, hashMap);
    }

    static int earAction(String str, long j2, boolean z, int i2) {
        if (i2 != 0 && i2 != 1) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(EXTRA_EARACTION, Integer.valueOf(i2));
        return sendMessage(32776, hashMap);
    }

    static int isDeviceChangabled(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32777, hashMap);
    }

    static int getConnectedDevice(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32778, hashMap);
    }

    static int getConnectingDevice(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32779, hashMap);
    }

    static int voicecallPreprocess(String str, long j2, boolean z, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_MODEPOLICY, Integer.valueOf(i2));
        hashMap.put(PARAM_STREAMTYPE, Integer.valueOf(i3));
        return sendMessage(32780, hashMap);
    }

    static int voicecallPostprocess(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32781, hashMap);
    }

    static int voiceCallAudioParamChanged(String str, long j2, boolean z, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_MODEPOLICY, Integer.valueOf(i2));
        hashMap.put(PARAM_STREAMTYPE, Integer.valueOf(i3));
        return sendMessage(32788, hashMap);
    }

    static int startRing(String str, long j2, boolean z, int i2, int i3, Uri uri, String str2, boolean z2, int i4, String str3, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_RING_DATASOURCE, Integer.valueOf(i2));
        hashMap.put(PARAM_RING_RSID, Integer.valueOf(i3));
        hashMap.put(PARAM_RING_URI, uri);
        hashMap.put(PARAM_RING_FILEPATH, str2);
        hashMap.put(PARAM_RING_LOOP, Boolean.valueOf(z2));
        hashMap.put(PARAM_RING_LOOPCOUNT, Integer.valueOf(i4));
        hashMap.put(PARAM_RING_MODE, Boolean.valueOf(z3));
        hashMap.put(PARAM_RING_USERDATA_STRING, str3);
        return sendMessage(32782, hashMap);
    }

    static int stopRing(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32783, hashMap);
    }

    static int requestReleaseAudioFocus(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32790, hashMap);
    }

    static int recoverAudioFocus(String str, long j2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j2));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        return sendMessage(32791, hashMap);
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionConnectDevice(HashMap<String, Object> hashMap) {
        int i2;
        AudioDeviceInterface.LogTraceEntry("");
        if (hashMap == null || this._context == null) {
            return -1;
        }
        if (IsMusicScene) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "MusicScene: InternalSessionConnectDevice failed");
            }
            return -1;
        }
        String str = (String) hashMap.get(PARAM_DEVICE);
        Log.w("TRAE", "ConnectDevice: " + str);
        if (IsEarPhoneSupported || !str.equals(DEVICE_EARPHONE)) {
            boolean InternalIsDeviceChangeable = InternalIsDeviceChangeable();
            if (!checkDevName(str)) {
                i2 = 7;
            } else {
                i2 = !this._deviceConfigManager.c(str) ? 8 : !InternalIsDeviceChangeable ? 9 : 0;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb = new StringBuilder();
                sb.append("sessonID:");
                sb.append((Long) hashMap.get(PARAM_SESSIONID));
                sb.append(" devName:");
                sb.append(str);
                sb.append(" bChangabled:");
                sb.append(InternalIsDeviceChangeable ? "Y" : "N");
                sb.append(" err:");
                sb.append(i2);
                QLog.w("TRAE", 2, sb.toString());
            }
            if (i2 != 0) {
                Intent intent = new Intent();
                intent.putExtra(CONNECTDEVICE_RESULT_DEVICENAME, (String) hashMap.get(PARAM_DEVICE));
                sendResBroadcast(intent, hashMap, i2);
                return -1;
            } else if (str.equals(this._deviceConfigManager.h())) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " --has connected!");
                }
                Intent intent2 = new Intent();
                intent2.putExtra(CONNECTDEVICE_RESULT_DEVICENAME, (String) hashMap.get(PARAM_DEVICE));
                sendResBroadcast(intent2, hashMap, i2);
                return 0;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " --connecting...");
                }
                InternalConnectDevice(str, hashMap, false);
                AudioDeviceInterface.LogTraceExit();
                return 0;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "InternalSessionConnectDevice IsEarPhoneSupported = false, Connect device:" + str + " failed");
            }
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public int InternalConnectDevice(String str, HashMap<String, Object> hashMap, boolean z) {
        AudioDeviceInterface.LogTraceEntry(" devName:" + str);
        if (str == null) {
            return -1;
        }
        if (IsMusicScene && str.equals(DEVICE_EARPHONE)) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "MusicScene, Connect device:" + str + " failed");
            }
            return -1;
        } else if (!IsEarPhoneSupported && str.equals(DEVICE_EARPHONE)) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "IsEarPhoneSupported = false, Connect device:" + str + " failed");
            }
            return -1;
        } else if (!z && !this._deviceConfigManager.h().equals(DEVICE_NONE) && str.equals(this._deviceConfigManager.h())) {
            return 0;
        } else {
            if (!checkDevName(str) || !this._deviceConfigManager.c(str)) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " checkDevName fail");
                }
                return -1;
            } else if (!InternalIsDeviceChangeable()) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalIsDeviceChangeable fail");
                }
                return -1;
            } else {
                if (this._switchThread != null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "_switchThread:" + this._switchThread.b());
                    }
                    this._switchThread.g();
                    this._switchThread = null;
                }
                if (str.equals(DEVICE_EARPHONE)) {
                    this._switchThread = new h();
                } else if (str.equals(DEVICE_SPEAKERPHONE)) {
                    this._switchThread = new j();
                } else if (str.equals(DEVICE_WIREDHEADSET)) {
                    this._switchThread = new i();
                } else if (str.equals(DEVICE_BLUETOOTHHEADSET)) {
                    this._switchThread = new g();
                }
                k kVar = this._switchThread;
                if (kVar != null) {
                    kVar.a(hashMap);
                    this._switchThread.start();
                }
                AudioDeviceInterface.LogTraceExit();
                return 0;
            }
        }
    }

    abstract class k extends Thread {

        /* renamed from: b  reason: collision with root package name */
        boolean f32460b = true;

        /* renamed from: c  reason: collision with root package name */
        boolean[] f32461c = {false};

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Object> f32462d = null;

        /* renamed from: e  reason: collision with root package name */
        long f32463e = 0;

        public abstract void a();

        public abstract String b();

        public abstract void c();

        k() {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " ++switchThread:" + b());
            }
        }

        public void a(HashMap<String, Object> hashMap) {
            this.f32462d = hashMap;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            TraeAudioManager.this._deviceConfigManager.g(b());
            a(0);
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
            AudioDeviceInterface.LogTraceEntry(b() + " err:" + i);
            if (this.f32462d == null) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                return;
            }
            TraeAudioManager traeAudioManager = TraeAudioManager.this;
            traeAudioManager.sessionConnectedDev = traeAudioManager._deviceConfigManager.h();
            Long l = (Long) this.f32462d.get(TraeAudioManager.PARAM_SESSIONID);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " sessonID:" + l);
            }
            if (l == null || l.longValue() == Long.MIN_VALUE) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "processDeviceConnectRes sid null,don't send res");
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.CONNECTDEVICE_RESULT_DEVICENAME, (String) this.f32462d.get(TraeAudioManager.PARAM_DEVICE));
            if (TraeAudioManager.this.sendResBroadcast(intent, this.f32462d, i) == 0) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
            }
            AudioDeviceInterface.LogTraceExit();
        }

        public void run() {
            AudioDeviceInterface.LogTraceEntry(b());
            TraeAudioManager.this._deviceConfigManager.f(b());
            TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
            a();
            synchronized (this.f32461c) {
                this.f32461c[0] = true;
                this.f32461c.notifyAll();
            }
            AudioDeviceInterface.LogTraceExit();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|(2:8|9)|10|11) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x004b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r4 = this;
                java.lang.String r0 = r4.b()
                com.tencent.rtmp.sharp.jni.AudioDeviceInterface.LogTraceEntry(r0)
                r0 = 0
                r4.f32460b = r0
                boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()
                if (r1 == 0) goto L_0x0035
                r1 = 2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = " quit:"
                r2.append(r3)
                java.lang.String r3 = r4.b()
                r2.append(r3)
                java.lang.String r3 = " _running:"
                r2.append(r3)
                boolean r3 = r4.f32460b
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                java.lang.String r3 = "TRAE"
                com.tencent.qphone.base.util.QLog.w(r3, r1, r2)
            L_0x0035:
                r4.interrupt()
                r4.c()
                boolean[] r1 = r4.f32461c
                monitor-enter(r1)
                boolean[] r2 = r4.f32461c     // Catch:{ all -> 0x0050 }
                boolean r0 = r2[r0]     // Catch:{ all -> 0x0050 }
                if (r0 != 0) goto L_0x004b
                boolean[] r0 = r4.f32461c     // Catch:{ InterruptedException -> 0x004b }
                r2 = 10000(0x2710, double:4.9407E-320)
                r0.wait(r2)     // Catch:{ InterruptedException -> 0x004b }
            L_0x004b:
                monitor-exit(r1)     // Catch:{ all -> 0x0050 }
                com.tencent.rtmp.sharp.jni.AudioDeviceInterface.LogTraceExit()
                return
            L_0x0050:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0050 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.TraeAudioManager.k.g():void");
        }
    }

    class h extends k {
        public String b() {
            return TraeAudioManager.DEVICE_EARPHONE;
        }

        public void c() {
        }

        h() {
            super();
        }

        public void a() {
            if (TraeAudioManager.IsUpdateSceneFlag && TraeAudioManager.enableDeviceSwitchFlag) {
                TraeAudioManager traeAudioManager = TraeAudioManager.this;
                traeAudioManager.InternalSetSpeaker(traeAudioManager._context, false);
            }
            f();
            if (!TraeAudioManager.IsUpdateSceneFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect earphone: do nothing");
                }
            } else if (TraeAudioManager.enableDeviceSwitchFlag) {
                int i = 0;
                while (this.f32460b) {
                    if (TraeAudioManager.this._am.isSpeakerphoneOn()) {
                        TraeAudioManager traeAudioManager2 = TraeAudioManager.this;
                        traeAudioManager2.InternalSetSpeaker(traeAudioManager2._context, false);
                    }
                    try {
                        Thread.sleep(i < 5 ? 1000 : 4000);
                    } catch (InterruptedException unused) {
                    }
                    i++;
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "connect earphone: disableDeviceSwitchFlag");
            }
        }
    }

    class j extends k {
        public String b() {
            return TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        public void c() {
        }

        j() {
            super();
        }

        public void a() {
            if (!TraeAudioManager.IsMusicScene && TraeAudioManager.IsUpdateSceneFlag && TraeAudioManager.enableDeviceSwitchFlag) {
                TraeAudioManager traeAudioManager = TraeAudioManager.this;
                traeAudioManager.InternalSetSpeaker(traeAudioManager._context, true);
            }
            f();
            if (TraeAudioManager.IsMusicScene || !TraeAudioManager.IsUpdateSceneFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect speakerPhone: do nothing");
                }
            } else if (TraeAudioManager.enableDeviceSwitchFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " _run:" + b() + " _running:" + this.f32460b);
                }
                int i = 0;
                while (this.f32460b) {
                    if (!TraeAudioManager.this._am.isSpeakerphoneOn()) {
                        TraeAudioManager traeAudioManager2 = TraeAudioManager.this;
                        traeAudioManager2.InternalSetSpeaker(traeAudioManager2._context, true);
                    }
                    try {
                        Thread.sleep(i < 5 ? 1000 : 4000);
                    } catch (InterruptedException unused) {
                    }
                    i++;
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "connect speakerPhone: disableDeviceSwitchFlag");
            }
        }
    }

    class i extends k {
        public String b() {
            return TraeAudioManager.DEVICE_WIREDHEADSET;
        }

        public void c() {
        }

        i() {
            super();
        }

        public void a() {
            if (!TraeAudioManager.IsMusicScene && TraeAudioManager.IsUpdateSceneFlag && TraeAudioManager.enableDeviceSwitchFlag) {
                TraeAudioManager traeAudioManager = TraeAudioManager.this;
                traeAudioManager.InternalSetSpeaker(traeAudioManager._context, false);
                TraeAudioManager.this._am.setWiredHeadsetOn(true);
            }
            f();
            if (TraeAudioManager.IsMusicScene || !TraeAudioManager.IsUpdateSceneFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect headset: do nothing");
                }
            } else if (TraeAudioManager.enableDeviceSwitchFlag) {
                int i = 0;
                while (this.f32460b) {
                    if (TraeAudioManager.this._am.isSpeakerphoneOn()) {
                        TraeAudioManager traeAudioManager2 = TraeAudioManager.this;
                        traeAudioManager2.InternalSetSpeaker(traeAudioManager2._context, false);
                    }
                    try {
                        Thread.sleep(i < 5 ? 1000 : 4000);
                    } catch (InterruptedException unused) {
                    }
                    i++;
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "connect headset: disableDeviceSwitchFlag");
            }
        }
    }

    class g extends k {
        public String b() {
            return TraeAudioManager.DEVICE_BLUETOOTHHEADSET;
        }

        g() {
            super();
        }

        public void a() {
            if (TraeAudioManager.IsMusicScene || !TraeAudioManager.IsUpdateSceneFlag) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "connect bluetoothHeadset: do nothing, IsMusicScene:" + TraeAudioManager.IsMusicScene + " ,IsUpdateSceneFlag:" + TraeAudioManager.IsUpdateSceneFlag);
                }
                f();
            } else if (TraeAudioManager.enableDeviceSwitchFlag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException unused) {
                }
                d();
                int i = 0;
                while (true) {
                    if (!this.f32460b) {
                        break;
                    }
                    int i2 = i + 1;
                    if (i >= 10) {
                        break;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("bluetoothHeadsetSwitchThread i:");
                        sb.append(i2);
                        sb.append(" sco:");
                        sb.append(TraeAudioManager.this._am.isBluetoothScoOn() ? "Y" : "N");
                        sb.append(" :");
                        sb.append(TraeAudioManager.this._deviceConfigManager.d());
                        QLog.w("TRAE", 2, sb.toString());
                    }
                    if (TraeAudioManager.this._am.isBluetoothScoOn()) {
                        f();
                        break;
                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException unused2) {
                        }
                        i = i2;
                    }
                }
                if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
                    }
                    TraeAudioManager.this._deviceConfigManager.a(b(), false);
                    a(10);
                    TraeAudioManager.this.checkAutoDeviceListUpdate();
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "connect bluetoothHeadset: disableDeviceSwitchFlag");
            }
        }

        @TargetApi(8)
        public void c() {
            if (TraeAudioManager.this._am != null) {
                e();
            }
        }

        /* access modifiers changed from: package-private */
        @TargetApi(8)
        public void d() {
            TraeAudioManager.this._am.setBluetoothScoOn(true);
            if (Build.VERSION.SDK_INT > 8) {
                TraeAudioManager.this._am.startBluetoothSco();
            }
        }

        /* access modifiers changed from: package-private */
        @TargetApi(8)
        public void e() {
            if (Build.VERSION.SDK_INT > 8) {
                TraeAudioManager.this._am.stopBluetoothSco();
            }
            TraeAudioManager.this._am.setBluetoothScoOn(false);
        }
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionIsDeviceChangabled(HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra(ISDEVICECHANGABLED_RESULT_ISCHANGABLED, InternalIsDeviceChangeable());
        sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean InternalIsDeviceChangeable() {
        String g2 = this._deviceConfigManager.g();
        return g2 == null || g2.equals(DEVICE_NONE) || g2.equals("");
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionGetConnectedDevice(HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra(GETCONNECTEDDEVICE_RESULT_LIST, this._deviceConfigManager.h());
        sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int InternalSessionGetConnectingDevice(HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra(GETCONNECTINGDEVICE_RESULT_LIST, this._deviceConfigManager.g());
        sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int sendResBroadcast(Intent intent, HashMap<String, Object> hashMap, int i2) {
        Intent intent2 = intent;
        HashMap<String, Object> hashMap2 = hashMap;
        if (this._context == null) {
            return -1;
        }
        Long l = (Long) hashMap.get(PARAM_SESSIONID);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " sessonID:" + l + SQLBuilder.BLANK + ((String) hashMap.get(PARAM_OPERATION)));
        }
        if (l == null || l.longValue() == Long.MIN_VALUE) {
            InternalNotifyDeviceListUpdate();
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "sendResBroadcast sid null,don't send res");
            }
            return -1;
        }
        final Long l2 = (Long) hashMap.get(PARAM_SESSIONID);
        final String str = (String) hashMap.get(PARAM_OPERATION);
        if (OPERATION_VOICECALL_PREPROCESS.equals(str)) {
            intent.setAction(ACTION_TRAEAUDIOMANAGER_RES);
            intent.putExtra(PARAM_SESSIONID, l2);
            intent.putExtra(PARAM_OPERATION, str);
            intent.putExtra(PARAM_RES_ERRCODE, i2);
            TraeAudioSessionHost traeAudioSessionHost = this._audioSessionHost;
            if (traeAudioSessionHost == null) {
                return 0;
            }
            traeAudioSessionHost.sendToAudioSessionMessage(intent);
            return 0;
        }
        final int i3 = i2;
        final Intent intent3 = intent;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                intent3.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES);
                intent3.putExtra(TraeAudioManager.PARAM_SESSIONID, l2);
                intent3.putExtra(TraeAudioManager.PARAM_OPERATION, str);
                intent3.putExtra(TraeAudioManager.PARAM_RES_ERRCODE, i3);
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.sendBroadcast(intent3);
                }
            }
        });
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int InternalNotifyDeviceListUpdate() {
        AudioDeviceInterface.LogTraceEntry("");
        if (this._context == null) {
            return -1;
        }
        HashMap<String, Object> j2 = this._deviceConfigManager.j();
        final ArrayList arrayList = (ArrayList) j2.get(EXTRA_DATA_AVAILABLEDEVICE_LIST);
        final String str = (String) j2.get(EXTRA_DATA_CONNECTEDDEVICE);
        final String str2 = (String) j2.get(EXTRA_DATA_PREV_CONNECTEDDEVICE);
        final String d2 = this._deviceConfigManager.d();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_DEVICELIST_UPDATE);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, (String[]) arrayList.toArray(new String[0]));
                intent.putExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, str);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, str2);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME, d2);
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.sendBroadcast(intent);
                }
            }
        });
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int InternalNotifyDeviceChangableUpdate() {
        if (this._context == null) {
            return -1;
        }
        final boolean InternalIsDeviceChangeable = InternalIsDeviceChangeable();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE);
                intent.putExtra(TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE_DATE, InternalIsDeviceChangeable);
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.sendBroadcast(intent);
                }
            }
        });
        return 0;
    }

    abstract class d {
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void a(Context context, Intent intent);

        /* access modifiers changed from: package-private */
        public abstract void a(IntentFilter intentFilter);

        public abstract boolean a(Context context, e eVar);

        public abstract boolean b();

        public abstract String c();

        d() {
        }

        public void b(IntentFilter intentFilter) {
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            a(intentFilter);
        }

        public void a(Context context, Intent intent, e eVar) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + a(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + a(intExtra2));
                }
                if (intExtra == 10) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "    BT off");
                    }
                    eVar.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                } else if (intExtra == 12 && QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT OFF-->ON,Visiable it...");
                }
            } else if ("android.bluetooth.device.action.ACL_CONNECTED".equals(intent.getAction()) && Build.VERSION.SDK_INT < 11) {
            } else {
                if (!"android.bluetooth.device.action.ACL_DISCONNECTED".equals(intent.getAction()) || Build.VERSION.SDK_INT >= 11) {
                    a(context, intent);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public String a(int i) {
            String str;
            switch (i) {
                case 10:
                    str = "STATE_OFF";
                    break;
                case 11:
                    str = "STATE_TURNING_ON";
                    break;
                case 12:
                    str = "STATE_ON";
                    break;
                case 13:
                    str = "STATE_TURNING_OFF";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return str + ":" + i;
        }

        /* access modifiers changed from: package-private */
        public String b(int i) {
            String str = i != -1 ? i != 0 ? i != 1 ? i != 2 ? "unknow" : "SCO_AUDIO_STATE_CONNECTING" : "SCO_AUDIO_STATE_CONNECTED" : "SCO_AUDIO_STATE_DISCONNECTED" : "SCO_AUDIO_STATE_ERROR";
            return str + ":" + i;
        }

        /* access modifiers changed from: package-private */
        public String c(int i) {
            String str = i != 0 ? i != 1 ? i != 2 ? i != 3 ? "unknow" : "STATE_DISCONNECTING" : "STATE_CONNECTED" : "STATE_CONNECTING" : "STATE_DISCONNECTED";
            return str + ":" + i;
        }
    }

    class b extends d {
        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, Intent intent) {
        }

        /* access modifiers changed from: package-private */
        public void a(IntentFilter intentFilter) {
        }

        public boolean a(Context context, e eVar) {
            return true;
        }

        public boolean b() {
            return false;
        }

        public String c() {
            return "BluetoohHeadsetCheckFake";
        }

        b() {
            super();
        }
    }

    public d CreateBluetoothCheck(Context context, e eVar) {
        d dVar;
        if (Build.VERSION.SDK_INT >= 11) {
            dVar = new a();
        } else if (Build.VERSION.SDK_INT != 18) {
            dVar = new c();
        } else {
            dVar = new b();
        }
        if (!dVar.a(context, eVar)) {
            dVar = new b();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb = new StringBuilder();
            sb.append("CreateBluetoothCheck:");
            sb.append(dVar.c());
            sb.append(" skip android4.3:");
            sb.append(Build.VERSION.SDK_INT == 18 ? "Y" : "N");
            QLog.w("TRAE", 2, sb.toString());
        }
        return dVar;
    }

    @TargetApi(11)
    class a extends d implements BluetoothProfile.ServiceListener {

        /* renamed from: a  reason: collision with root package name */
        Context f32419a = null;

        /* renamed from: b  reason: collision with root package name */
        e f32420b = null;

        /* renamed from: c  reason: collision with root package name */
        BluetoothAdapter f32421c = null;

        /* renamed from: d  reason: collision with root package name */
        BluetoothProfile f32422d = null;

        /* renamed from: f  reason: collision with root package name */
        private final ReentrantLock f32424f = new ReentrantLock();

        public String c() {
            return "BluetoohHeadsetCheck";
        }

        a() {
            super();
        }

        @TargetApi(11)
        public boolean a(Context context, e eVar) {
            AudioDeviceInterface.LogTraceEntry("");
            if (context == null || eVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
                }
                return false;
            }
            this.f32419a = context;
            this.f32420b = eVar;
            this.f32421c = BluetoothAdapter.getDefaultAdapter();
            if (this.f32421c == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
                }
                return false;
            }
            this.f32424f.lock();
            try {
                if (!this.f32421c.isEnabled() || this.f32422d != null || this.f32421c.getProfileProxy(this.f32419a, this, 1)) {
                    this.f32424f.unlock();
                    AudioDeviceInterface.LogTraceExit();
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
                }
                return false;
            } finally {
                this.f32424f.unlock();
            }
        }

        public void a() {
            AudioDeviceInterface.LogTraceEntry("_profile:" + this.f32422d);
            this.f32424f.lock();
            try {
                if (this.f32421c != null) {
                    if (this.f32422d != null) {
                        this.f32421c.closeProfileProxy(1, this.f32422d);
                    }
                    this.f32422d = null;
                }
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " closeProfileProxy:e:" + e2.getMessage());
                }
            } catch (Throwable th) {
                this.f32424f.unlock();
                throw th;
            }
            this.f32424f.unlock();
            AudioDeviceInterface.LogTraceExit();
        }

        public boolean b() {
            this.f32424f.lock();
            try {
                boolean z = false;
                if (this.f32422d != null) {
                    List<BluetoothDevice> connectedDevices = this.f32422d.getConnectedDevices();
                    if (connectedDevices == null) {
                        return false;
                    }
                    if (connectedDevices.size() > 0) {
                        z = true;
                    }
                }
                this.f32424f.unlock();
                return z;
            } finally {
                this.f32424f.unlock();
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00bd A[SYNTHETIC, Splitter:B:36:0x00bd] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00cc A[Catch:{ all -> 0x0133 }] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00f4 A[SYNTHETIC] */
        @android.annotation.TargetApi(11)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onServiceConnected(int r10, android.bluetooth.BluetoothProfile r11) {
            /*
                r9 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "_profile:"
                r0.append(r1)
                android.bluetooth.BluetoothProfile r1 = r9.f32422d
                r0.append(r1)
                java.lang.String r1 = " profile:"
                r0.append(r1)
                r0.append(r10)
                java.lang.String r1 = " proxy:"
                r0.append(r1)
                r0.append(r11)
                java.lang.String r0 = r0.toString()
                com.tencent.rtmp.sharp.jni.AudioDeviceInterface.LogTraceEntry(r0)
                r0 = 1
                if (r10 != r0) goto L_0x013a
                java.util.concurrent.locks.ReentrantLock r10 = r9.f32424f
                r10.lock()
                android.bluetooth.BluetoothProfile r10 = r9.f32422d     // Catch:{ all -> 0x0133 }
                java.lang.String r1 = " _profile:"
                java.lang.String r2 = "TRAE"
                r3 = 0
                r4 = 2
                if (r10 == 0) goto L_0x0067
                android.bluetooth.BluetoothProfile r10 = r9.f32422d     // Catch:{ all -> 0x0133 }
                if (r10 == r11) goto L_0x0067
                boolean r10 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ all -> 0x0133 }
                if (r10 == 0) goto L_0x005e
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
                r10.<init>()     // Catch:{ all -> 0x0133 }
                java.lang.String r5 = "BluetoohHeadsetCheck: HEADSET Connected proxy:"
                r10.append(r5)     // Catch:{ all -> 0x0133 }
                r10.append(r11)     // Catch:{ all -> 0x0133 }
                r10.append(r1)     // Catch:{ all -> 0x0133 }
                android.bluetooth.BluetoothProfile r5 = r9.f32422d     // Catch:{ all -> 0x0133 }
                r10.append(r5)     // Catch:{ all -> 0x0133 }
                java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0133 }
                com.tencent.qphone.base.util.QLog.w(r2, r4, r10)     // Catch:{ all -> 0x0133 }
            L_0x005e:
                android.bluetooth.BluetoothAdapter r10 = r9.f32421c     // Catch:{ all -> 0x0133 }
                android.bluetooth.BluetoothProfile r5 = r9.f32422d     // Catch:{ all -> 0x0133 }
                r10.closeProfileProxy(r0, r5)     // Catch:{ all -> 0x0133 }
                r9.f32422d = r3     // Catch:{ all -> 0x0133 }
            L_0x0067:
                r9.f32422d = r11     // Catch:{ all -> 0x0133 }
                android.bluetooth.BluetoothProfile r10 = r9.f32422d     // Catch:{ all -> 0x0133 }
                if (r10 == 0) goto L_0x0074
                android.bluetooth.BluetoothProfile r10 = r9.f32422d     // Catch:{ all -> 0x0133 }
                java.util.List r10 = r10.getConnectedDevices()     // Catch:{ all -> 0x0133 }
                goto L_0x0075
            L_0x0074:
                r10 = r3
            L_0x0075:
                r11 = 0
                if (r10 == 0) goto L_0x00f7
                android.bluetooth.BluetoothProfile r5 = r9.f32422d     // Catch:{ all -> 0x0133 }
                if (r5 == 0) goto L_0x00f7
                boolean r5 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ all -> 0x0133 }
                if (r5 == 0) goto L_0x00a2
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
                r5.<init>()     // Catch:{ all -> 0x0133 }
                java.lang.String r6 = "TRAEBluetoohProxy: HEADSET Connected devs:"
                r5.append(r6)     // Catch:{ all -> 0x0133 }
                int r6 = r10.size()     // Catch:{ all -> 0x0133 }
                r5.append(r6)     // Catch:{ all -> 0x0133 }
                r5.append(r1)     // Catch:{ all -> 0x0133 }
                android.bluetooth.BluetoothProfile r1 = r9.f32422d     // Catch:{ all -> 0x0133 }
                r5.append(r1)     // Catch:{ all -> 0x0133 }
                java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0133 }
                com.tencent.qphone.base.util.QLog.w(r2, r4, r1)     // Catch:{ all -> 0x0133 }
            L_0x00a2:
                r1 = 0
            L_0x00a3:
                int r5 = r10.size()     // Catch:{ all -> 0x0133 }
                if (r1 >= r5) goto L_0x00f7
                java.lang.Object r5 = r10.get(r1)     // Catch:{ all -> 0x0133 }
                android.bluetooth.BluetoothDevice r5 = (android.bluetooth.BluetoothDevice) r5     // Catch:{ all -> 0x0133 }
                android.bluetooth.BluetoothProfile r6 = r9.f32422d     // Catch:{ Exception -> 0x00ba }
                if (r6 == 0) goto L_0x00ba
                android.bluetooth.BluetoothProfile r6 = r9.f32422d     // Catch:{ Exception -> 0x00ba }
                int r6 = r6.getConnectionState(r5)     // Catch:{ Exception -> 0x00ba }
                goto L_0x00bb
            L_0x00ba:
                r6 = 0
            L_0x00bb:
                if (r6 != r4) goto L_0x00c6
                com.tencent.rtmp.sharp.jni.TraeAudioManager$e r7 = r9.f32420b     // Catch:{ all -> 0x0133 }
                java.lang.String r8 = r5.getName()     // Catch:{ all -> 0x0133 }
                r7.b(r8)     // Catch:{ all -> 0x0133 }
            L_0x00c6:
                boolean r7 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ all -> 0x0133 }
                if (r7 == 0) goto L_0x00f4
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
                r7.<init>()     // Catch:{ all -> 0x0133 }
                java.lang.String r8 = "   "
                r7.append(r8)     // Catch:{ all -> 0x0133 }
                r7.append(r1)     // Catch:{ all -> 0x0133 }
                java.lang.String r8 = " "
                r7.append(r8)     // Catch:{ all -> 0x0133 }
                java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0133 }
                r7.append(r5)     // Catch:{ all -> 0x0133 }
                java.lang.String r5 = " ConnectionState:"
                r7.append(r5)     // Catch:{ all -> 0x0133 }
                r7.append(r6)     // Catch:{ all -> 0x0133 }
                java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0133 }
                com.tencent.qphone.base.util.QLog.w(r2, r4, r5)     // Catch:{ all -> 0x0133 }
            L_0x00f4:
                int r1 = r1 + 1
                goto L_0x00a3
            L_0x00f7:
                java.util.concurrent.locks.ReentrantLock r10 = r9.f32424f
                r10.unlock()
                com.tencent.rtmp.sharp.jni.TraeAudioManager$e r10 = r9.f32420b
                if (r10 == 0) goto L_0x013a
                com.tencent.rtmp.sharp.jni.TraeAudioManager r10 = com.tencent.rtmp.sharp.jni.TraeAudioManager.this
                com.tencent.rtmp.sharp.jni.TraeAudioManager$e r10 = r10._deviceConfigManager
                if (r10 == 0) goto L_0x010e
                com.tencent.rtmp.sharp.jni.TraeAudioManager r10 = com.tencent.rtmp.sharp.jni.TraeAudioManager.this
                com.tencent.rtmp.sharp.jni.TraeAudioManager$e r10 = r10._deviceConfigManager
                java.lang.String r3 = r10.d()
            L_0x010e:
                boolean r10 = android.text.TextUtils.isEmpty(r3)
                java.lang.String r1 = "DEVICE_BLUETOOTHHEADSET"
                if (r10 == 0) goto L_0x011c
                com.tencent.rtmp.sharp.jni.TraeAudioManager$e r10 = r9.f32420b
                r10.a((java.lang.String) r1, (boolean) r11)
                goto L_0x013a
            L_0x011c:
                boolean r10 = r9.b()
                if (r10 == 0) goto L_0x012d
                com.tencent.rtmp.sharp.jni.TraeAudioManager$e r10 = r9.f32420b
                r10.a((java.lang.String) r1, (boolean) r0)
                com.tencent.rtmp.sharp.jni.TraeAudioManager r10 = com.tencent.rtmp.sharp.jni.TraeAudioManager.this
                r10.checkDevicePlug(r1, r0)
                goto L_0x013a
            L_0x012d:
                com.tencent.rtmp.sharp.jni.TraeAudioManager$e r10 = r9.f32420b
                r10.a((java.lang.String) r1, (boolean) r11)
                goto L_0x013a
            L_0x0133:
                r10 = move-exception
                java.util.concurrent.locks.ReentrantLock r11 = r9.f32424f
                r11.unlock()
                throw r10
            L_0x013a:
                com.tencent.rtmp.sharp.jni.AudioDeviceInterface.LogTraceExit()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.TraeAudioManager.a.onServiceConnected(int, android.bluetooth.BluetoothProfile):void");
        }

        @TargetApi(11)
        public void onServiceDisconnected(int i) {
            AudioDeviceInterface.LogTraceEntry("_profile:" + this.f32422d + " profile:" + i);
            if (i == 1) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
                }
                if (b()) {
                    TraeAudioManager.this.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
                this.f32424f.lock();
                try {
                    if (this.f32422d != null) {
                        this.f32421c.closeProfileProxy(1, this.f32422d);
                        this.f32422d = null;
                    }
                } finally {
                    this.f32424f.unlock();
                }
            }
            AudioDeviceInterface.LogTraceExit();
        }

        /* access modifiers changed from: package-private */
        public void a(IntentFilter intentFilter) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, SQLBuilder.BLANK + c() + " _addAction");
            }
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + c(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + c(intExtra2));
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("    EXTRA_DEVICE ");
                    sb.append(bluetoothDevice);
                    String str = SQLBuilder.BLANK;
                    sb.append(str);
                    if (bluetoothDevice != null) {
                        str = bluetoothDevice.getName();
                    }
                    sb.append(str);
                    QLog.w("TRAE", 2, sb.toString());
                }
                if (intExtra == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "   dev:" + bluetoothDevice.getName() + " connected,start sco...");
                    }
                    this.f32420b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                    this.f32420b.b(bluetoothDevice != null ? bluetoothDevice.getName() : "unkown");
                } else if (intExtra == 0) {
                    this.f32420b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
            } else if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
                int intExtra3 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                int intExtra4 = intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + bluetoothDevice2);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + b(intExtra3));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(intExtra4));
                }
            } else if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                int profileConnectionState = defaultAdapter.getProfileConnectionState(2);
                if (profileConnectionState == 0) {
                    QLog.w("TRAE", 2, "BluetoothA2dp STATE_DISCONNECTED");
                    TraeAudioManager.this.IsBluetoothA2dpExisted = false;
                } else if (profileConnectionState != 2) {
                    QLog.w("TRAE", 2, "BluetoothA2dp" + defaultAdapter.getProfileConnectionState(2));
                } else {
                    QLog.w("TRAE", 2, "BluetoothA2dp STATE_CONNECTED");
                    TraeAudioManager.this.IsBluetoothA2dpExisted = true;
                }
            }
        }
    }

    class c extends d {

        /* renamed from: a  reason: collision with root package name */
        Class<?> f32426a = null;

        /* renamed from: b  reason: collision with root package name */
        Class<?> f32427b = null;

        /* renamed from: c  reason: collision with root package name */
        Object f32428c = null;

        /* renamed from: d  reason: collision with root package name */
        Method f32429d = null;

        /* renamed from: e  reason: collision with root package name */
        Context f32430e = null;

        /* renamed from: f  reason: collision with root package name */
        e f32431f = null;

        public String c() {
            return "BluetoohHeadsetCheckFor2x";
        }

        c() {
            super();
        }

        public boolean a(Context context, e eVar) {
            AudioDeviceInterface.LogTraceEntry("");
            this.f32430e = context;
            this.f32431f = eVar;
            if (this.f32430e == null || this.f32431f == null) {
                return false;
            }
            try {
                this.f32426a = Class.forName("android.bluetooth.BluetoothHeadset");
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset class not found");
                }
            }
            if (this.f32426a == null) {
                return false;
            }
            try {
                this.f32427b = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:" + e2);
                }
            }
            Class<?> cls = this.f32427b;
            try {
                this.f32429d = this.f32426a.getDeclaredMethod("getCurrentHeadset", new Class[0]);
            } catch (NoSuchMethodException unused2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
                }
            }
            if (this.f32429d == null) {
                return false;
            }
            try {
                this.f32428c = this.f32426a.getConstructor(new Class[]{Context.class, this.f32427b}).newInstance(new Object[]{context, null});
            } catch (IllegalArgumentException unused3) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                }
            } catch (InstantiationException unused4) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                }
            } catch (IllegalAccessException unused5) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                }
            } catch (InvocationTargetException unused6) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                }
            } catch (NoSuchMethodException unused7) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                }
            }
            if (this.f32428c == null) {
                return false;
            }
            this.f32431f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, b());
            if (b()) {
                this.f32431f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                TraeAudioManager.this.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
            } else {
                this.f32431f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
            }
            AudioDeviceInterface.LogTraceExit();
            return true;
        }

        public void a() {
            Method method;
            AudioDeviceInterface.LogTraceEntry("");
            if (this.f32428c != null) {
                try {
                    method = this.f32426a.getDeclaredMethod("close", new Class[0]);
                } catch (NoSuchMethodException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
                    }
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(this.f32428c, new Object[0]);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    }
                    this.f32426a = null;
                    this.f32427b = null;
                    this.f32428c = null;
                    this.f32429d = null;
                    AudioDeviceInterface.LogTraceExit();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005e A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b() {
            /*
                r6 = this;
                java.lang.String r0 = "TRAE"
                java.lang.reflect.Method r1 = r6.f32429d
                r2 = 0
                if (r1 == 0) goto L_0x005f
                if (r1 != 0) goto L_0x000a
                goto L_0x005f
            L_0x000a:
                r3 = 2
                java.lang.Object r4 = r6.f32428c     // Catch:{ IllegalArgumentException -> 0x002e, IllegalAccessException -> 0x0021, InvocationTargetException -> 0x0014 }
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalArgumentException -> 0x002e, IllegalAccessException -> 0x0021, InvocationTargetException -> 0x0014 }
                java.lang.Object r1 = r1.invoke(r4, r5)     // Catch:{ IllegalArgumentException -> 0x002e, IllegalAccessException -> 0x0021, InvocationTargetException -> 0x0014 }
                goto L_0x003b
            L_0x0014:
                boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()
                if (r1 == 0) goto L_0x003a
                java.lang.String r1 = "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException"
                com.tencent.qphone.base.util.QLog.w(r0, r3, r1)
                goto L_0x003a
            L_0x0021:
                boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()
                if (r1 == 0) goto L_0x003a
                java.lang.String r1 = "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException"
                com.tencent.qphone.base.util.QLog.w(r0, r3, r1)
                goto L_0x003a
            L_0x002e:
                boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()
                if (r1 == 0) goto L_0x003a
                java.lang.String r1 = "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException"
                com.tencent.qphone.base.util.QLog.w(r0, r3, r1)
            L_0x003a:
                r1 = 0
            L_0x003b:
                boolean r4 = com.tencent.qphone.base.util.QLog.isColorLevel()
                if (r4 == 0) goto L_0x005c
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "BTLooperThread BluetoothHeadset method getCurrentHeadset res:"
                r4.append(r5)
                if (r1 == 0) goto L_0x0050
                java.lang.String r5 = " Y"
                goto L_0x0052
            L_0x0050:
                java.lang.String r5 = "N"
            L_0x0052:
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                com.tencent.qphone.base.util.QLog.w(r0, r3, r4)
            L_0x005c:
                if (r1 == 0) goto L_0x005f
                r2 = 1
            L_0x005f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.TraeAudioManager.c.b():boolean");
        }

        /* access modifiers changed from: package-private */
        public void a(IntentFilter intentFilter) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, SQLBuilder.BLANK + c() + " _addAction");
            }
            intentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, Intent intent) {
            if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
                int intExtra2 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
                int intExtra3 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "++ AUDIO_STATE_CHANGED|  STATE " + intExtra);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       PREVIOUS_STATE " + intExtra2);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       AUDIO_STATE " + intExtra3);
                }
                if (intExtra3 == 2) {
                    this.f32431f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                } else if (intExtra3 == 0) {
                    this.f32431f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
            } else if ("android.bluetooth.headset.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra4 = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
                int intExtra5 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
                int intExtra6 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "++ STATE_CHANGED|  STATE " + intExtra4);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       PREVIOUS_STATE " + intExtra5);
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       AUDIO_STATE " + intExtra6);
                }
                if (intExtra6 == 2) {
                    this.f32431f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                } else if (intExtra6 == 0) {
                    this.f32431f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
            }
        }
    }

    static String getForceConfigName(int i2) {
        if (i2 < 0) {
            return "unknow";
        }
        String[] strArr = forceName;
        return i2 < strArr.length ? strArr[i2] : "unknow";
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        try {
            return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "invokeMethod Exception:" + e2.getMessage());
            }
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object[] objArr, Class[] clsArr) {
        try {
            return Class.forName(str).getMethod(str2, clsArr).invoke((Object) null, objArr);
        } catch (ClassNotFoundException unused) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("TRAE", 2, "ClassNotFound:" + str);
            return null;
        } catch (NoSuchMethodException unused2) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("TRAE", 2, "NoSuchMethod:" + str2);
            return null;
        } catch (IllegalArgumentException unused3) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("TRAE", 2, "IllegalArgument:" + str2);
            return null;
        } catch (IllegalAccessException unused4) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("TRAE", 2, "IllegalAccess:" + str2);
            return null;
        } catch (InvocationTargetException unused5) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("TRAE", 2, "InvocationTarget:" + str2);
            return null;
        } catch (Exception e2) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("TRAE", 2, "invokeStaticMethod Exception:" + e2.getMessage());
            return null;
        }
    }

    static void setParameters(String str) {
        Object[] objArr = {str};
        Class[] clsArr = new Class[objArr.length];
        clsArr[0] = String.class;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setParameters  :" + str);
        }
        invokeStaticMethod("android.media.AudioSystem", "setParameters", objArr, clsArr);
    }

    static void setPhoneState(int i2) {
        Object[] objArr = {Integer.valueOf(i2)};
        Class[] clsArr = new Class[objArr.length];
        clsArr[0] = Integer.TYPE;
        invokeStaticMethod("android.media.AudioSystem", "setPhoneState", objArr, clsArr);
    }

    static void setForceUse(int i2, int i3) {
        Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
        Class[] clsArr = new Class[objArr.length];
        clsArr[0] = Integer.TYPE;
        clsArr[1] = Integer.TYPE;
        Object invokeStaticMethod = invokeStaticMethod("android.media.AudioSystem", "setForceUse", objArr, clsArr);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setForceUse  usage:" + i2 + " config:" + i3 + " ->" + getForceConfigName(i3) + " res:" + invokeStaticMethod);
        }
    }

    static int getForceUse(int i2) {
        Integer num = 0;
        Object[] objArr = {Integer.valueOf(i2)};
        Class[] clsArr = new Class[objArr.length];
        clsArr[0] = Integer.TYPE;
        Object invokeStaticMethod = invokeStaticMethod("android.media.AudioSystem", "getForceUse", objArr, clsArr);
        if (invokeStaticMethod != null) {
            num = (Integer) invokeStaticMethod;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "getForceUse  usage:" + i2 + " config:" + num + " ->" + getForceConfigName(num.intValue()));
        }
        return num.intValue();
    }

    static void forceVolumeControlStream(AudioManager audioManager, int i2) {
        if (!Build.MANUFACTURER.equals("Google")) {
            Object[] objArr = {Integer.valueOf(i2)};
            Class[] clsArr = new Class[objArr.length];
            clsArr[0] = Integer.TYPE;
            Object invokeMethod = invokeMethod(audioManager, "forceVolumeControlStream", objArr, clsArr);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "forceVolumeControlStream  streamType:" + i2 + " res:" + invokeMethod);
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "forceVolumeControlStream, Google phone nothing to do");
        }
    }
}
