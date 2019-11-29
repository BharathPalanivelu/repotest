package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.ServerProtocol;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.util.b;
import java.util.ArrayList;
import java.util.List;

public class a implements e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f31181a;

    /* renamed from: b  reason: collision with root package name */
    private int f31182b;

    /* renamed from: c  reason: collision with root package name */
    private Context f31183c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31184d;

    /* renamed from: e  reason: collision with root package name */
    private BroadcastReceiver f31185e;

    /* renamed from: f  reason: collision with root package name */
    private BluetoothProfile.ServiceListener f31186f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public BluetoothHeadset f31187g;
    private List<d> h;
    private Handler i;
    private boolean j;
    /* access modifiers changed from: private */
    public int k;
    private boolean l;
    private com.tencent.liteav.basic.module.a m;
    private boolean n;
    private String o;
    private int p;
    private boolean q;
    private List<String> r;
    private List<String> s;
    /* access modifiers changed from: private */
    public AudioManager t;

    /* renamed from: com.tencent.liteav.audio.impl.a$a  reason: collision with other inner class name */
    private static class C0485a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f31192a = new a();
    }

    public static void a(String str) {
        TXCTraeJNI.nativeSetTraeConfig(str);
    }

    static {
        b.f();
    }

    public static a a() {
        return C0485a.f31192a;
    }

    private a() {
        this.f31181a = "AudioCenter:" + a.class.getSimpleName();
        this.f31182b = 1;
        this.k = 0;
        this.m = null;
        this.n = false;
        this.p = 0;
        this.o = "18446744073709551615";
        this.m = new com.tencent.liteav.basic.module.a();
        this.m.setID(this.o);
        this.h = new ArrayList();
        b();
    }

    private void b() {
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.r.add("HUAWEI");
        this.s.add("EVA-AL00");
    }

    private boolean c() {
        String str = "";
        String str2 = Build.MANUFACTURER == null ? str : Build.MANUFACTURER;
        if (Build.MODEL != null) {
            str = Build.MODEL;
        }
        if (!this.r.contains(str2) || !this.s.contains(str)) {
            return false;
        }
        String str3 = this.f31181a;
        TXCLog.i(str3, "manufacturer = " + str2 + ", model = " + str + " need MODE_NORMAL for BT Mic");
        return true;
    }

    public void a(Context context) {
        if (this.f31184d) {
            TXCLog.e(this.f31181a, "init, but has inited, ignore!");
            return;
        }
        TXCLog.i(this.f31181a, "init");
        if (this.f31183c == null) {
            this.f31183c = context.getApplicationContext();
        }
        if (this.t == null) {
            this.t = (AudioManager) context.getSystemService("audio");
        }
        if (this.i == null) {
            this.i = new Handler(Looper.getMainLooper());
        }
        this.t = (AudioManager) context.getSystemService("audio");
        this.i = new Handler(Looper.getMainLooper());
        c.a().a(this.f31183c);
        c.a().a((e) this);
        if (this.f31185e == null) {
            this.f31185e = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    String a2 = a.this.f31181a;
                    TXCLog.i(a2, "onReceive, action = " + action);
                    if (action.equals("android.intent.action.HEADSET_PLUG")) {
                        a.this.b(intent);
                    } else if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                        a.this.d(intExtra);
                    } else if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                        a.this.a(intent);
                    }
                }
            };
        }
        if (this.f31186f == null) {
            this.f31186f = new BluetoothProfile.ServiceListener() {
                public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                    String a2 = a.this.f31181a;
                    TXCLog.i(a2, "onServiceConnected, profile = " + i);
                    if (i != 1) {
                        TXCLog.e(a.this.f31181a, "profile not HEADSET, ignore");
                        return;
                    }
                    BluetoothHeadset unused = a.this.f31187g = (BluetoothHeadset) bluetoothProfile;
                    a.this.d();
                }

                public void onServiceDisconnected(int i) {
                    String a2 = a.this.f31181a;
                    TXCLog.i(a2, "onServiceDisconnected, profile = " + i);
                    if (i != 1) {
                        TXCLog.e(a.this.f31181a, "profile not HEADSET, ignore");
                        return;
                    }
                    BluetoothHeadset unused = a.this.f31187g = null;
                    a aVar = a.this;
                    aVar.b(aVar.k);
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        this.f31183c.registerReceiver(this.f31185e, intentFilter);
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                defaultAdapter.getProfileProxy(this.f31183c, this.f31186f, 1);
            }
        } catch (Exception e2) {
            String str = this.f31181a;
            TXCLog.e(str, "BluetoothAdapter getProfileProxy: " + e2);
        }
        this.f31184d = true;
    }

    /* access modifiers changed from: private */
    public synchronized void d() {
        int i2;
        if (this.f31187g != null) {
            List<BluetoothDevice> list = null;
            try {
                list = this.f31187g.getConnectedDevices();
            } catch (Exception e2) {
                String str = this.f31181a;
                TXCLog.e(str, "getConnectedDevices exception = " + e2);
                this.f31187g = null;
            }
            if (list != null) {
                if (list.size() != 0) {
                    try {
                        i2 = this.f31187g.getConnectionState(list.get(0));
                    } catch (Exception e3) {
                        String str2 = this.f31181a;
                        TXCLog.e(str2, "checkBTHeadsetState, getConnectionState exception: " + e3);
                        i2 = -1;
                    }
                    if (i2 != -1) {
                        d(i2);
                        return;
                    }
                    return;
                }
            }
            TXCLog.e(this.f31181a, "checkBTHeadsetState, btDevices is empty!");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            if (r4 == 0) goto L_0x0053
            r1 = 2
            if (r4 == r1) goto L_0x0008
            goto L_0x006f
        L_0x0008:
            boolean r4 = r3.l     // Catch:{ all -> 0x0071 }
            if (r4 != 0) goto L_0x0015
            java.lang.String r4 = r3.f31181a     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = "processBTHeadsetState connected, record is not running"
            com.tencent.liteav.basic.log.TXCLog.w(r4, r0)     // Catch:{ all -> 0x0071 }
            monitor-exit(r3)
            return
        L_0x0015:
            int r4 = r3.f31182b     // Catch:{ all -> 0x0071 }
            if (r4 != r1) goto L_0x0022
            java.lang.String r4 = r3.f31181a     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = "processBTHeadsetState connected, sco is connecting, ignore"
            com.tencent.liteav.basic.log.TXCLog.w(r4, r0)     // Catch:{ all -> 0x0071 }
            monitor-exit(r3)
            return
        L_0x0022:
            android.media.AudioManager r4 = r3.t     // Catch:{ all -> 0x0071 }
            r4.stopBluetoothSco()     // Catch:{ all -> 0x0071 }
            android.media.AudioManager r4 = r3.t     // Catch:{ all -> 0x0071 }
            r4.setBluetoothScoOn(r0)     // Catch:{ all -> 0x0071 }
            android.media.AudioManager r4 = r3.t     // Catch:{ all -> 0x0071 }
            boolean r4 = r4.isBluetoothScoAvailableOffCall()     // Catch:{ all -> 0x0071 }
            if (r4 != 0) goto L_0x003d
            java.lang.String r4 = r3.f31181a     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = "checkBTHeadsetState connected, not support BTHeadset sco"
            com.tencent.liteav.basic.log.TXCLog.e(r4, r0)     // Catch:{ all -> 0x0071 }
            monitor-exit(r3)
            return
        L_0x003d:
            java.lang.String r4 = r3.f31181a     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = "processBTHeadsetState connected, delay to startBluetoothSco"
            com.tencent.liteav.basic.log.TXCLog.i(r4, r0)     // Catch:{ all -> 0x0071 }
            r3.f31182b = r1     // Catch:{ all -> 0x0071 }
            android.os.Handler r4 = r3.i     // Catch:{ all -> 0x0071 }
            com.tencent.liteav.audio.impl.a$3 r0 = new com.tencent.liteav.audio.impl.a$3     // Catch:{ all -> 0x0071 }
            r0.<init>()     // Catch:{ all -> 0x0071 }
            r1 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r0, r1)     // Catch:{ all -> 0x0071 }
            goto L_0x006f
        L_0x0053:
            android.media.AudioManager r4 = r3.t     // Catch:{ all -> 0x0071 }
            r4.stopBluetoothSco()     // Catch:{ all -> 0x0071 }
            android.media.AudioManager r4 = r3.t     // Catch:{ all -> 0x0071 }
            r4.setBluetoothScoOn(r0)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = r3.f31181a     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = "processBTHeadsetState, disconnected"
            com.tencent.liteav.basic.log.TXCLog.i(r4, r0)     // Catch:{ all -> 0x0071 }
            int r4 = r3.k     // Catch:{ all -> 0x0071 }
            r3.b((int) r4)     // Catch:{ all -> 0x0071 }
            android.os.Handler r4 = r3.i     // Catch:{ all -> 0x0071 }
            r0 = 0
            r4.removeCallbacksAndMessages(r0)     // Catch:{ all -> 0x0071 }
        L_0x006f:
            monitor-exit(r3)
            return
        L_0x0071:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.a.d(int):void");
    }

    /* access modifiers changed from: private */
    public void a(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
        String str = this.f31181a;
        TXCLog.i(str, "processAudioState state " + intExtra + " (ps: 10--DISCONNECTED; 11--CONNECTING; 12--CONNECTED), thread id = " + Thread.currentThread().getId());
        if (intExtra == 12) {
            TXCLog.i(this.f31181a, "SCO connected, yeah!");
            this.f31182b = 3;
            a(true, true);
            this.i.removeCallbacksAndMessages((Object) null);
            this.t.setBluetoothScoOn(true);
            b(this.k);
        } else if (intExtra != 11 && intExtra == 10) {
            this.f31182b = 1;
            b(this.k);
            a(false, false);
            if (this.q) {
                TXCLog.i(this.f31181a, "processAudioState, mNeedRestartScoWithHangUp");
                this.q = false;
                d();
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(Intent intent) {
        if (intent.hasExtra(ServerProtocol.DIALOG_PARAM_STATE)) {
            int intExtra = intent.getIntExtra(ServerProtocol.DIALOG_PARAM_STATE, 0);
            if (intExtra == 0) {
                this.j = false;
                a(false, false);
                b(this.k);
                TXCLog.i(this.f31181a, "pull out wired headset");
            } else if (1 == intExtra) {
                this.j = true;
                a(true, false);
                b(this.k);
                TXCLog.i(this.f31181a, "insert wired headset");
            }
        }
    }

    public synchronized void a(int i2) {
        if (this.t != null) {
            if (this.f31182b != 2) {
                if (com.tencent.liteav.basic.e.b.a().g()) {
                    TXCLog.i(this.f31181a, "【TXSDK-TRAE-LOG】 sys Aec Enable~");
                    try {
                        if (this.j) {
                            if (this.t.getMode() == 0) {
                                TXCLog.w(this.f31181a, "setMode, mIsWiredHeadsetOn, audioMode is MODE_NORMAL, ignore");
                                return;
                            }
                            this.t.setMode(0);
                            TXCLog.i(this.f31181a, "setMode, is wiredHeadsetOn, set MODE_NORMA");
                        } else if (this.f31187g == null || this.f31182b != 3 || c()) {
                            if (this.t.getMode() == 0) {
                                TXCLog.w(this.f31181a, "setMode, audioMode is MODE_NORMAL, ignore");
                                return;
                            }
                            String str = this.f31181a;
                            TXCLog.i(str, "【TXSDK-TRAE-LOG】 michael setMode = " + i2);
                            TXCLog.i(this.f31181a, "【TXSDK-TRAE-LOG】 michael info don't change trae mode");
                            this.t.setMode(i2);
                        } else if (this.t.getMode() == 3) {
                            TXCLog.w(this.f31181a, "setMode, bluetoothHeadset on, audioMode is MODE_IN_COMMUNICATION, ignore");
                        } else {
                            this.t.setMode(3);
                            TXCLog.i(this.f31181a, "setMode, bluetoothHeadset on, set mode MODE_IN_COMMUNICATION");
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    TXCLog.i(this.f31181a, "【TXSDK-TRAE-LOG】 TRAE don't setMode here~");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.tencent.liteav.basic.e.b r0 = com.tencent.liteav.basic.e.b.a()     // Catch:{ all -> 0x007b }
            boolean r0 = r0.g()     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = r3.f31181a     // Catch:{ all -> 0x007b }
            java.lang.String r1 = "【TXSDK-TRAE-LOG】 sys AecEnable~"
            com.tencent.liteav.basic.log.TXCLog.i(r0, r1)     // Catch:{ all -> 0x007b }
            r3.k = r4     // Catch:{ all -> 0x007b }
            r4 = 0
            r3.a((int) r4)     // Catch:{ all -> 0x007b }
            boolean r0 = r3.j     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x002a
            android.media.AudioManager r0 = r3.t     // Catch:{ all -> 0x007b }
            r0.setSpeakerphoneOn(r4)     // Catch:{ all -> 0x007b }
            java.lang.String r4 = r3.f31181a     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "setAudioRoute, is wiredHeadsetOn, set speakerphoneOn false"
            com.tencent.liteav.basic.log.TXCLog.i(r4, r0)     // Catch:{ all -> 0x007b }
            monitor-exit(r3)
            return
        L_0x002a:
            android.bluetooth.BluetoothHeadset r0 = r3.f31187g     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x0041
            int r0 = r3.f31182b     // Catch:{ all -> 0x007b }
            r1 = 3
            if (r0 != r1) goto L_0x0041
            android.media.AudioManager r0 = r3.t     // Catch:{ all -> 0x007b }
            r0.setSpeakerphoneOn(r4)     // Catch:{ all -> 0x007b }
            java.lang.String r4 = r3.f31181a     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "setAudioRoute, is bluetoothHeadset connect and isBluetoothScoOn true, set speakerphoneOn false"
            com.tencent.liteav.basic.log.TXCLog.i(r4, r0)     // Catch:{ all -> 0x007b }
            monitor-exit(r3)
            return
        L_0x0041:
            java.lang.String r0 = r3.f31181a     // Catch:{ all -> 0x007b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r1.<init>()     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "setAudioRoute, only phone, mSpeakerOn = "
            r1.append(r2)     // Catch:{ all -> 0x007b }
            int r2 = r3.k     // Catch:{ all -> 0x007b }
            if (r2 != 0) goto L_0x0054
            java.lang.String r2 = "true"
            goto L_0x0056
        L_0x0054:
            java.lang.String r2 = "false"
        L_0x0056:
            r1.append(r2)     // Catch:{ all -> 0x007b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007b }
            com.tencent.liteav.basic.log.TXCLog.i(r0, r1)     // Catch:{ all -> 0x007b }
            int r0 = r3.k     // Catch:{ all -> 0x007b }
            if (r0 != 0) goto L_0x006b
            android.media.AudioManager r4 = r3.t     // Catch:{ all -> 0x007b }
            r0 = 1
            r4.setSpeakerphoneOn(r0)     // Catch:{ all -> 0x007b }
            goto L_0x0070
        L_0x006b:
            android.media.AudioManager r0 = r3.t     // Catch:{ all -> 0x007b }
            r0.setSpeakerphoneOn(r4)     // Catch:{ all -> 0x007b }
        L_0x0070:
            monitor-exit(r3)
            return
        L_0x0072:
            java.lang.String r4 = r3.f31181a     // Catch:{ all -> 0x007b }
            java.lang.String r0 = "【TXSDK-TRAE-LOG】 TRAE don't set Route here~"
            com.tencent.liteav.basic.log.TXCLog.i(r4, r0)     // Catch:{ all -> 0x007b }
            monitor-exit(r3)
            return
        L_0x007b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.a.b(int):void");
    }

    public void a(boolean z) {
        String str = this.f31181a;
        TXCLog.i(str, "setRecordRunning = " + z);
        this.l = z;
        if (!this.l) {
            TXCLog.w(this.f31181a, "processBTHeadsetState, record is not running");
            int i2 = this.f31182b;
            if (i2 == 3 || i2 == 2) {
                this.i.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            a.this.t.stopBluetoothSco();
                            a.this.t.setBluetoothScoOn(false);
                        } catch (NullPointerException e2) {
                            String a2 = a.this.f31181a;
                            TXCLog.i(a2, "checkBTHeadsetState, startBluetoothSco exception = " + e2);
                            e2.printStackTrace();
                        }
                    }
                }, 1000);
                return;
            }
            return;
        }
        d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.tencent.liteav.audio.impl.d r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.util.List<com.tencent.liteav.audio.impl.d> r0 = r3.h     // Catch:{ all -> 0x0028 }
            r0.add(r4)     // Catch:{ all -> 0x0028 }
            boolean r0 = r3.j     // Catch:{ all -> 0x0028 }
            r1 = 1
            if (r0 == 0) goto L_0x0014
            r4.OnHeadsetState(r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return
        L_0x0014:
            android.bluetooth.BluetoothHeadset r0 = r3.f31187g     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0026
            android.media.AudioManager r0 = r3.t     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0026
            int r0 = r3.f31182b     // Catch:{ all -> 0x0028 }
            r2 = 3
            if (r0 != r2) goto L_0x0026
            r4.OnHeadsetState(r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return
        L_0x0026:
            monitor-exit(r3)
            return
        L_0x0028:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.a.a(com.tencent.liteav.audio.impl.d):void");
    }

    public synchronized void b(d dVar) {
        if (dVar != null) {
            this.h.remove(dVar);
        }
    }

    private synchronized void a(boolean z, boolean z2) {
        int i2 = z ? !z2 ? 1 : 2 : 0;
        this.m.setStatusValue(11005, Integer.valueOf(i2));
        TXCEventRecorderProxy.a("18446744073709551615", 1001, i2, -1, "", 0);
        for (d OnHeadsetState : this.h) {
            OnHeadsetState.OnHeadsetState(z);
        }
    }

    public void c(int i2) {
        String str = this.f31181a;
        TXCLog.i(str, "onCallStateChanged, state = " + i2);
        if (!this.t.isBluetoothScoAvailableOffCall()) {
            TXCLog.e(this.f31181a, "not support BTHeadset sco");
        } else if (i2 == 0) {
            if (this.f31182b != 1 || this.f31187g == null) {
                if (this.p == 2) {
                    this.q = true;
                }
                this.p = 0;
                return;
            }
            this.p = 0;
            TXCLog.i(this.f31181a, "to restartBluetoothSco");
            d();
        } else if (i2 == 1) {
            this.p = 1;
        } else if (i2 == 2) {
            this.p = i2;
        }
    }
}
