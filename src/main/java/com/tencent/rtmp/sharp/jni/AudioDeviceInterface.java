package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Environment;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioCodecList;
import com.tencent.rtmp.sharp.jni.TraeAudioSession;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    };
    public static final int OUTPUT_MODE_HEADSET = 0;
    public static final int OUTPUT_MODE_SPEAKER = 1;
    private static boolean _dumpEnable = false;
    private static boolean _logEnable = true;
    private static boolean isSupportVivoKTVHelper = false;
    /* access modifiers changed from: private */
    public static String[] mDeviceList;
    private static VivoKTVHelper mVivoKTVHelper;
    private TraeAudioSession _as = null;
    private TraeAudioSession _asAudioManager = null;
    private AudioManager _audioManager = null;
    private AudioRecord _audioRecord = null;
    private boolean _audioRouteChanged = false;
    private int _audioSource = 0;
    private int _audioSourcePolicy = -1;
    private int _audioStreamTypePolicy = -1;
    private AudioTrack _audioTrack = null;
    private int _bufferedPlaySamples = 0;
    private int _bufferedRecSamples = 0;
    private int _channelOutType = 4;
    private String _connectedDev = TraeAudioManager.DEVICE_NONE;
    private Context _context = null;
    private ByteBuffer _decBuffer0;
    private ByteBuffer _decBuffer1;
    private ByteBuffer _decBuffer10;
    private ByteBuffer _decBuffer2;
    private ByteBuffer _decBuffer3;
    private ByteBuffer _decBuffer4;
    private ByteBuffer _decBuffer5;
    private ByteBuffer _decBuffer6;
    private ByteBuffer _decBuffer7;
    private ByteBuffer _decBuffer8;
    private ByteBuffer _decBuffer9;
    private int _deviceStat = 0;
    private boolean _doPlayInit = true;
    private boolean _doRecInit = true;
    private boolean _isPlaying = false;
    private boolean _isRecording = false;
    private int _modePolicy = -1;
    private ByteBuffer _playBuffer;
    private int _playPosition = 0;
    private int _playSamplerate = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    private File _play_dump = null;
    private FileOutputStream _play_out = null;
    /* access modifiers changed from: private */
    public boolean _preDone = false;
    /* access modifiers changed from: private */
    public Condition _precon = this._prelock.newCondition();
    /* access modifiers changed from: private */
    public ReentrantLock _prelock = new ReentrantLock();
    private ByteBuffer _recBuffer;
    private File _rec_dump = null;
    private FileOutputStream _rec_out = null;
    private int _sceneMode = 0;
    private int _sessionId = 0;
    private int _streamType = 0;
    private byte[] _tempBufPlay;
    private byte[] _tempBufRec;
    private TraeAudioCodecList _traeAudioCodecList = null;
    private int nPlayLengthMs = 0;
    private int nRecordLengthMs = 0;
    private int switchState = 0;
    /* access modifiers changed from: private */
    public boolean usingJava = true;

    @TargetApi(16)
    private int getAudioSessionId(AudioRecord audioRecord) {
        return 0;
    }

    public AudioDeviceInterface() {
        try {
            this._playBuffer = ByteBuffer.allocateDirect(1920);
            this._recBuffer = ByteBuffer.allocateDirect(1920);
            this._decBuffer0 = ByteBuffer.allocateDirect(3840);
            this._decBuffer1 = ByteBuffer.allocateDirect(3840);
            this._decBuffer2 = ByteBuffer.allocateDirect(3840);
            this._decBuffer3 = ByteBuffer.allocateDirect(3840);
            this._decBuffer4 = ByteBuffer.allocateDirect(3840);
            this._decBuffer5 = ByteBuffer.allocateDirect(3840);
            this._decBuffer6 = ByteBuffer.allocateDirect(3840);
            this._decBuffer7 = ByteBuffer.allocateDirect(3840);
            this._decBuffer8 = ByteBuffer.allocateDirect(3840);
            this._decBuffer9 = ByteBuffer.allocateDirect(3840);
            this._decBuffer10 = ByteBuffer.allocateDirect(3840);
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, e2.getMessage());
            }
        }
        this._tempBufPlay = new byte[1920];
        this._tempBufRec = new byte[1920];
        this._traeAudioCodecList = new TraeAudioCodecList();
        int i = Build.VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:" + i);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
        }
    }

    public void setContext(Context context) {
        this._context = context;
    }

    private int getLowlatencySamplerate() {
        if (this._context == null || Build.VERSION.SDK_INT < 9) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
            }
            return 0;
        }
        boolean hasSystemFeature = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
        if (QLog.isColorLevel()) {
            StringBuilder sb = new StringBuilder();
            sb.append("LOW_LATENCY:");
            sb.append(hasSystemFeature ? "Y" : "N");
            QLog.w("TRAE", 2, sb.toString());
        }
        if (Build.VERSION.SDK_INT < 17) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
            }
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
        }
        return 0;
    }

    private int getLowlatencyFramesPerBuffer() {
        if (this._context == null || Build.VERSION.SDK_INT < 9) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
            }
            return 0;
        }
        boolean hasSystemFeature = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
        if (QLog.isColorLevel()) {
            StringBuilder sb = new StringBuilder();
            sb.append("LOW_LATENCY:");
            sb.append(hasSystemFeature ? "Y" : "N");
            QLog.w("TRAE", 2, sb.toString());
        }
        if (Build.VERSION.SDK_INT < 17 && QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        }
        return 0;
    }

    private int InitSetting(int i, int i2, int i3, int i4, int i5) {
        this._audioSourcePolicy = i;
        this._audioStreamTypePolicy = i2;
        this._modePolicy = i3;
        this._deviceStat = i4;
        this._sceneMode = i5;
        int i6 = this._deviceStat;
        if (i6 == 1 || i6 == 5 || i6 == 2 || i6 == 3) {
            TraeAudioManager.IsMusicScene = true;
        } else {
            TraeAudioManager.IsMusicScene = false;
        }
        int i7 = this._sceneMode;
        if (i7 == 0 || i7 == 4) {
            TraeAudioManager.IsEarPhoneSupported = true;
        } else {
            TraeAudioManager.IsEarPhoneSupported = false;
        }
        TraeAudioManager.IsUpdateSceneFlag = true;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy + " DeviceStat:" + i4 + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper);
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int InitRecording(int r23, int r24) {
        /*
            r22 = this;
            r1 = r22
            r8 = r23
            r9 = r24
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            java.lang.String r10 = "TRAE"
            r11 = 2
            if (r0 == 0) goto L_0x0023
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "InitRecording entry:"
            r0.append(r2)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.tencent.qphone.base.util.QLog.w(r10, r11, r0)
        L_0x0023:
            boolean r0 = r1._isRecording
            if (r0 != 0) goto L_0x0216
            android.media.AudioRecord r0 = r1._audioRecord
            if (r0 != 0) goto L_0x0216
            if (r9 <= r11) goto L_0x002f
            goto L_0x0216
        L_0x002f:
            r0 = 16
            if (r9 != r11) goto L_0x0038
            r0 = 12
            r13 = 12
            goto L_0x003a
        L_0x0038:
            r13 = 16
        L_0x003a:
            int r14 = android.media.AudioRecord.getMinBufferSize(r8, r13, r11)
            int r0 = r8 * 20
            int r0 = r0 * r9
            int r0 = r0 * 2
            int r15 = r0 / 1000
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            java.lang.String r7 = " sr:"
            if (r0 == 0) goto L_0x0080
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "InitRecording: min rec buf size is "
            r0.append(r2)
            r0.append(r14)
            r0.append(r7)
            int r2 = r22.getLowlatencySamplerate()
            r0.append(r2)
            java.lang.String r2 = " fp"
            r0.append(r2)
            int r2 = r22.getLowlatencyFramesPerBuffer()
            r0.append(r2)
            java.lang.String r2 = " 20msFZ:"
            r0.append(r2)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            com.tencent.qphone.base.util.QLog.w(r10, r11, r0)
        L_0x0080:
            int r0 = r8 * 5
            int r0 = r0 / 200
            r1._bufferedRecSamples = r0
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x00a2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "  rough rec delay set to "
            r0.append(r2)
            int r2 = r1._bufferedRecSamples
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.tencent.qphone.base.util.QLog.w(r10, r11, r0)
        L_0x00a2:
            android.media.AudioRecord r0 = r1._audioRecord
            r6 = 0
            if (r0 == 0) goto L_0x00ac
            r0.release()
            r1._audioRecord = r6
        L_0x00ac:
            r5 = 4
            int[] r4 = new int[r5]
            r4 = {0, 1, 5, 0} // fill-array
            int r0 = r1._audioSourcePolicy
            int r0 = com.tencent.rtmp.sharp.jni.TraeAudioManager.getAudioSource(r0)
            r2 = 0
            r4[r2] = r0
            r0 = r14
            r3 = 0
        L_0x00bd:
            int r2 = r4.length
            if (r3 >= r2) goto L_0x01b3
            android.media.AudioRecord r2 = r1._audioRecord
            if (r2 != 0) goto L_0x01b3
            r2 = r4[r3]
            r1._audioSource = r2
            r2 = 1
            r12 = 1
        L_0x00ca:
            if (r12 > r11) goto L_0x01a0
            int r6 = r14 * r12
            int r0 = r15 * 4
            if (r6 >= r0) goto L_0x00e0
            if (r12 >= r11) goto L_0x00e0
            r18 = r3
            r19 = r4
            r2 = r6
            r3 = r7
            r4 = 0
            r11 = 1
            r16 = 4
            goto L_0x0192
        L_0x00e0:
            int r0 = r6 * 500
            int r16 = r8 * r9
            int r0 = r0 / r16
            r1.nRecordLengthMs = r0     // Catch:{ Exception -> 0x015a }
            android.media.AudioRecord r0 = new android.media.AudioRecord     // Catch:{ Exception -> 0x015a }
            int r5 = r1._audioSource     // Catch:{ Exception -> 0x015a }
            r17 = 2
            r11 = 1
            r2 = r0
            r18 = r3
            r3 = r5
            r19 = r4
            r4 = r23
            r16 = 4
            r5 = r13
            r20 = r6
            r6 = r17
            r21 = r7
            r7 = r20
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0153 }
            r1._audioRecord = r0     // Catch:{ Exception -> 0x0153 }
            android.media.AudioRecord r0 = r1._audioRecord
            int r0 = r0.getState()
            if (r0 == r11) goto L_0x014c
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x013f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "InitRecording:  rec not initialized,try agine,  minbufsize:"
            r0.append(r2)
            r2 = r20
            r0.append(r2)
            r3 = r21
            r0.append(r3)
            r0.append(r8)
            java.lang.String r4 = " as:"
            r0.append(r4)
            int r4 = r1._audioSource
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r4 = 2
            com.tencent.qphone.base.util.QLog.w(r10, r4, r0)
            goto L_0x0143
        L_0x013f:
            r2 = r20
            r3 = r21
        L_0x0143:
            android.media.AudioRecord r0 = r1._audioRecord
            r0.release()
            r4 = 0
            r1._audioRecord = r4
            goto L_0x0192
        L_0x014c:
            r2 = r20
            r3 = r21
            r4 = 0
            r0 = r2
            goto L_0x01a8
        L_0x0153:
            r0 = move-exception
            r2 = r20
            r3 = r21
            r4 = 0
            goto L_0x0165
        L_0x015a:
            r0 = move-exception
            r18 = r3
            r19 = r4
            r2 = r6
            r3 = r7
            r4 = 0
            r11 = 1
            r16 = 4
        L_0x0165:
            boolean r5 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r5 == 0) goto L_0x0189
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = " _audioRecord:"
            r5.append(r0)
            android.media.AudioRecord r0 = r1._audioRecord
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r5 = 2
            com.tencent.qphone.base.util.QLog.w(r10, r5, r0)
        L_0x0189:
            android.media.AudioRecord r0 = r1._audioRecord
            if (r0 == 0) goto L_0x0190
            r0.release()
        L_0x0190:
            r1._audioRecord = r4
        L_0x0192:
            int r12 = r12 + 1
            r0 = r2
            r7 = r3
            r6 = r4
            r3 = r18
            r4 = r19
            r2 = 1
            r5 = 4
            r11 = 2
            goto L_0x00ca
        L_0x01a0:
            r18 = r3
            r19 = r4
            r4 = r6
            r3 = r7
            r16 = 4
        L_0x01a8:
            int r2 = r18 + 1
            r7 = r3
            r6 = r4
            r4 = r19
            r5 = 4
            r11 = 2
            r3 = r2
            goto L_0x00bd
        L_0x01b3:
            android.media.AudioRecord r2 = r1._audioRecord
            if (r2 != 0) goto L_0x01c5
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x01c3
            java.lang.String r0 = "InitRecording fail!!!"
            r2 = 2
            com.tencent.qphone.base.util.QLog.w(r10, r2, r0)
        L_0x01c3:
            r2 = -1
            return r2
        L_0x01c5:
            boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r2 == 0) goto L_0x0207
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = " [Config] InitRecording: audioSession:"
            r2.append(r3)
            int r3 = r1._sessionId
            r2.append(r3)
            java.lang.String r3 = " audioSource:"
            r2.append(r3)
            int r3 = r1._audioSource
            r2.append(r3)
            java.lang.String r3 = " rec sample rate set to "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = " recBufSize:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " nRecordLengthMs:"
            r2.append(r0)
            int r0 = r1.nRecordLengthMs
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = 2
            com.tencent.qphone.base.util.QLog.w(r10, r2, r0)
            goto L_0x0208
        L_0x0207:
            r2 = 2
        L_0x0208:
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x0213
            java.lang.String r0 = "InitRecording exit"
            com.tencent.qphone.base.util.QLog.w(r10, r2, r0)
        L_0x0213:
            int r0 = r1._bufferedRecSamples
            return r0
        L_0x0216:
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x0233
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "InitRecording _isRecording:"
            r0.append(r2)
            boolean r2 = r1._isRecording
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 2
            com.tencent.qphone.base.util.QLog.e(r10, r2, r0)
        L_0x0233:
            r2 = -1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.AudioDeviceInterface.InitRecording(int, int):int");
    }

    private int InitPlayback(int i, int i2) {
        Object obj;
        Object obj2;
        int i3 = i;
        int i4 = i2;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback entry: sampleRate " + i3);
        }
        if (!this._isPlaying && this._audioTrack == null && i4 <= 2) {
            if (this._audioManager == null) {
                try {
                    this._audioManager = (AudioManager) this._context.getSystemService("audio");
                } catch (Exception e2) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, e2.getMessage());
                    }
                    return -1;
                }
            }
            if (i4 == 2) {
                this._channelOutType = 12;
            } else {
                this._channelOutType = 4;
            }
            this._playSamplerate = i3;
            int minBufferSize = AudioTrack.getMinBufferSize(i3, this._channelOutType, 2);
            if (this._channelOutType == 12) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "InitPlayback, _channelOutType stero");
                } else if (this._channelOutType == 4 && QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "InitPlayback, _channelOutType Mono");
                }
            }
            int i5 = (((i3 * 20) * 1) * 2) / 1000;
            if (this._channelOutType == 12) {
                i5 *= 2;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InitPlayback: minPlayBufSize:" + minBufferSize + " 20msFz:" + i5);
            }
            this._bufferedPlaySamples = 0;
            AudioTrack audioTrack = this._audioTrack;
            Object obj3 = null;
            if (audioTrack != null) {
                audioTrack.release();
                this._audioTrack = null;
            }
            int[] iArr = {0, 0, 3, 1};
            this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
            if (this._audioRouteChanged) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
                }
                if (this._audioManager.getMode() != 0 || !this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    this._streamType = 0;
                } else {
                    this._streamType = 3;
                }
                this._audioRouteChanged = false;
            }
            iArr[0] = this._streamType;
            int i6 = minBufferSize;
            int i7 = 0;
            while (i7 < iArr.length && this._audioTrack == null) {
                this._streamType = iArr[i7];
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + minBufferSize + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
                }
                int i8 = 1;
                while (true) {
                    if (i8 > 2) {
                        obj = obj3;
                        break;
                    }
                    int i9 = minBufferSize * i8;
                    if (i9 >= i5 * 4 || i8 >= 2) {
                        try {
                            this.nPlayLengthMs = (i9 * 500) / (i3 * i4);
                            this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, i9, 1);
                            if (this._audioTrack.getState() == 1) {
                                i6 = i9;
                                obj = null;
                                break;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + i9 + " sr:" + this._playSamplerate);
                            }
                            this._audioTrack.release();
                            obj2 = null;
                            this._audioTrack = null;
                        } catch (Exception e3) {
                            if (QLog.isColorLevel()) {
                                QLog.w("TRAE", 2, e3.getMessage() + " _audioTrack:" + this._audioTrack);
                            }
                            AudioTrack audioTrack2 = this._audioTrack;
                            if (audioTrack2 != null) {
                                audioTrack2.release();
                            }
                            obj2 = null;
                            this._audioTrack = null;
                        }
                    } else {
                        obj2 = obj3;
                    }
                    i8++;
                    obj3 = obj2;
                    i6 = i9;
                }
                i7++;
                obj3 = obj;
            }
            if (this._audioTrack != null) {
                TraeAudioSession traeAudioSession = this._as;
                if (traeAudioSession != null) {
                    AudioManager audioManager = this._audioManager;
                    if (audioManager != null) {
                        traeAudioSession.voiceCallAudioParamChanged(audioManager.getMode(), this._streamType);
                    }
                }
                this._playPosition = this._audioTrack.getPlaybackHeadPosition();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + i6 + " nPlayLengthMs:" + this.nPlayLengthMs);
                }
                TraeAudioManager.forceVolumeControlStream(this._audioManager, this._connectedDev.equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET) ? 6 : this._audioTrack.getStreamType());
                return 0;
            } else if (!QLog.isColorLevel()) {
                return -1;
            } else {
                QLog.w("TRAE", 2, "InitPlayback fail!!!");
                return -1;
            }
        } else if (!QLog.isColorLevel()) {
            return -1;
        } else {
            QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
            return -1;
        }
    }

    private int getPlayRecordSysBufferMs() {
        return (this.nRecordLengthMs + this.nPlayLengthMs) * 2;
    }

    private String getDumpFilePath(String str, int i) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
        }
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + i + "-" + str;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump:" + str2);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump replace:" + str2.replace(SQLBuilder.BLANK, "_"));
        }
        return str2.replace(SQLBuilder.BLANK, "_");
    }

    private int StartRecording() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StartRecording entry");
        }
        int i = -1;
        if (this._isRecording) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartRecording _isRecording:" + this._isRecording);
            }
            return -1;
        }
        AudioRecord audioRecord = this._audioRecord;
        if (audioRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartRecording _audioRecord:" + this._audioRecord);
            }
            return -1;
        }
        try {
            audioRecord.startRecording();
            if (_dumpEnable) {
                AudioManager audioManager = this._audioManager;
                if (audioManager != null) {
                    i = audioManager.getMode();
                }
                this._rec_dump = new File(getDumpFilePath("jnirecord.pcm", i));
                try {
                    this._rec_out = new FileOutputStream(this._rec_dump);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            this._isRecording = true;
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.w("TRAE", 2, "StartRecording ok");
            return 0;
        } catch (IllegalStateException e3) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartRecording fail");
            }
            e3.printStackTrace();
            return -1;
        }
    }

    private int StartPlayback() {
        int i = -1;
        if (this._isPlaying) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartPlayback _isPlaying");
            }
            return -1;
        }
        AudioTrack audioTrack = this._audioTrack;
        if (audioTrack == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartPlayback _audioTrack:" + this._audioTrack);
            }
            return -1;
        }
        try {
            audioTrack.play();
            if (_dumpEnable) {
                AudioManager audioManager = this._audioManager;
                if (audioManager != null) {
                    i = audioManager.getMode();
                }
                this._play_dump = new File(getDumpFilePath("jniplay.pcm", i));
                try {
                    this._play_out = new FileOutputStream(this._play_dump);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            this._isPlaying = true;
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.w("TRAE", 2, "StartPlayback ok");
            return 0;
        } catch (IllegalStateException e3) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StartPlayback fail");
            }
            e3.printStackTrace();
            return -1;
        }
    }

    private int StopRecording() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording entry");
        }
        AudioRecord audioRecord = this._audioRecord;
        if (audioRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "UnintRecord:" + this._audioRecord);
            }
            return -1;
        }
        if (audioRecord.getRecordingState() == 3) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopRecording stop... state:" + this._audioRecord.getRecordingState());
                }
                this._audioRecord.stop();
            } catch (IllegalStateException e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "StopRecording  err");
                }
                e2.printStackTrace();
                return -1;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording releaseing... state:" + this._audioRecord.getRecordingState());
        }
        this._audioRecord.release();
        this._audioRecord = null;
        this._isRecording = false;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording exit ok");
        }
        return 0;
    }

    private int StopPlayback() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopPlayback entry _isPlaying:" + this._isPlaying);
        }
        AudioTrack audioTrack = this._audioTrack;
        if (audioTrack == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "StopPlayback _isPlaying:" + this._isPlaying + SQLBuilder.BLANK + this._audioTrack);
            }
            return -1;
        }
        if (audioTrack.getPlayState() == 3) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopPlayback stoping...");
                }
                this._audioTrack.stop();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "StopPlayback flushing... state:" + this._audioTrack.getPlayState());
                }
                this._audioTrack.flush();
            } catch (IllegalStateException e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "StopPlayback err");
                }
                e2.printStackTrace();
                return -1;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopPlayback releaseing... state:" + this._audioTrack.getPlayState());
        }
        this._audioTrack.release();
        this._audioTrack = null;
        this._isPlaying = false;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopPlayback exit ok");
        }
        return 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:75|76|(1:78)) */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0179, code lost:
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x017b, code lost:
        com.tencent.qphone.base.util.QLog.e("TRAE", 2, "StopPlayback err");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:128:0x02cb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0175 */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02d1 A[Catch:{ Exception -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int PlayAudio(int r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = " _audioTrack:"
            boolean r0 = r1._isPlaying
            r4 = 1
            r0 = r0 ^ r4
            android.media.AudioTrack r5 = r1._audioTrack
            r6 = 0
            if (r5 != 0) goto L_0x0011
            r5 = 1
            goto L_0x0012
        L_0x0011:
            r5 = 0
        L_0x0012:
            r0 = r0 | r5
            r5 = -1
            java.lang.String r7 = "TRAE"
            r8 = 2
            if (r0 == 0) goto L_0x0040
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x003f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "PlayAudio: _isPlaying "
            r0.append(r2)
            boolean r2 = r1._isPlaying
            r0.append(r2)
            java.lang.String r2 = " "
            r0.append(r2)
            android.media.AudioTrack r2 = r1._audioTrack
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.tencent.qphone.base.util.QLog.e(r7, r8, r0)
        L_0x003f:
            return r5
        L_0x0040:
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x037e }
            if (r0 != 0) goto L_0x0046
            r0 = -2
            return r0
        L_0x0046:
            boolean r0 = r1._doPlayInit     // Catch:{ Exception -> 0x037e }
            if (r0 != r4) goto L_0x007a
            r0 = -19
            android.os.Process.setThreadPriority(r0)     // Catch:{ Exception -> 0x0059 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r9 = "TRAEAudioPlay"
            r0.setName(r9)     // Catch:{ Exception -> 0x0059 }
            goto L_0x0078
        L_0x0059:
            r0 = move-exception
            boolean r9 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x037e }
            if (r9 == 0) goto L_0x0078
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x037e }
            r9.<init>()     // Catch:{ Exception -> 0x037e }
            java.lang.String r10 = "Set play thread priority failed: "
            r9.append(r10)     // Catch:{ Exception -> 0x037e }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x037e }
            r9.append(r0)     // Catch:{ Exception -> 0x037e }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x037e }
            com.tencent.qphone.base.util.QLog.w(r7, r8, r0)     // Catch:{ Exception -> 0x037e }
        L_0x0078:
            r1._doPlayInit = r6     // Catch:{ Exception -> 0x037e }
        L_0x007a:
            boolean r0 = _dumpEnable     // Catch:{ Exception -> 0x037e }
            if (r0 == 0) goto L_0x008e
            java.io.FileOutputStream r0 = r1._play_out     // Catch:{ Exception -> 0x037e }
            if (r0 == 0) goto L_0x008e
            java.io.FileOutputStream r0 = r1._play_out     // Catch:{ IOException -> 0x008a }
            byte[] r9 = r1._tempBufPlay     // Catch:{ IOException -> 0x008a }
            r0.write(r9, r6, r6)     // Catch:{ IOException -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x037e }
        L_0x008e:
            boolean r0 = r1._audioRouteChanged     // Catch:{ Exception -> 0x037e }
            r9 = 3
            if (r0 != 0) goto L_0x0095
            r0 = 0
            goto L_0x00d3
        L_0x0095:
            android.media.AudioManager r0 = r1._audioManager     // Catch:{ Exception -> 0x037e }
            if (r0 != 0) goto L_0x00a9
            android.content.Context r0 = r1._context     // Catch:{ Exception -> 0x037e }
            if (r0 == 0) goto L_0x00a9
            android.content.Context r0 = r1._context     // Catch:{ Exception -> 0x037e }
            java.lang.String r10 = "audio"
            java.lang.Object r0 = r0.getSystemService(r10)     // Catch:{ Exception -> 0x037e }
            android.media.AudioManager r0 = (android.media.AudioManager) r0     // Catch:{ Exception -> 0x037e }
            r1._audioManager = r0     // Catch:{ Exception -> 0x037e }
        L_0x00a9:
            android.media.AudioManager r0 = r1._audioManager     // Catch:{ Exception -> 0x037e }
            if (r0 == 0) goto L_0x00c2
            android.media.AudioManager r0 = r1._audioManager     // Catch:{ Exception -> 0x037e }
            int r0 = r0.getMode()     // Catch:{ Exception -> 0x037e }
            if (r0 != 0) goto L_0x00c2
            java.lang.String r0 = r1._connectedDev     // Catch:{ Exception -> 0x037e }
            java.lang.String r10 = "DEVICE_SPEAKERPHONE"
            boolean r0 = r0.equals(r10)     // Catch:{ Exception -> 0x037e }
            if (r0 == 0) goto L_0x00c2
            r1._streamType = r9     // Catch:{ Exception -> 0x037e }
            goto L_0x00c4
        L_0x00c2:
            r1._streamType = r6     // Catch:{ Exception -> 0x037e }
        L_0x00c4:
            int r0 = r1._streamType     // Catch:{ Exception -> 0x037e }
            android.media.AudioTrack r10 = r1._audioTrack     // Catch:{ Exception -> 0x037e }
            int r10 = r10.getStreamType()     // Catch:{ Exception -> 0x037e }
            if (r0 != r10) goto L_0x00d0
            r0 = 0
            goto L_0x00d1
        L_0x00d0:
            r0 = 1
        L_0x00d1:
            r1._audioRouteChanged = r6     // Catch:{ Exception -> 0x037e }
        L_0x00d3:
            java.nio.ByteBuffer r10 = r1._playBuffer     // Catch:{ Exception -> 0x037e }
            byte[] r11 = r1._tempBufPlay     // Catch:{ Exception -> 0x037e }
            r10.get(r11)     // Catch:{ Exception -> 0x037e }
            if (r0 == 0) goto L_0x02f5
            java.nio.ByteBuffer r0 = r1._playBuffer     // Catch:{ Exception -> 0x02f2 }
            r0.rewind()     // Catch:{ Exception -> 0x02f2 }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x02f2 }
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02f2 }
            if (r0 == 0) goto L_0x010f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f2 }
            r0.<init>()     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r5 = " track resting: _streamType:"
            r0.append(r5)     // Catch:{ Exception -> 0x02f2 }
            int r5 = r1._streamType     // Catch:{ Exception -> 0x02f2 }
            r0.append(r5)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r5 = " at.st:"
            r0.append(r5)     // Catch:{ Exception -> 0x02f2 }
            android.media.AudioTrack r5 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            int r5 = r5.getStreamType()     // Catch:{ Exception -> 0x02f2 }
            r0.append(r5)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02f2 }
            com.tencent.qphone.base.util.QLog.w(r7, r8, r0)     // Catch:{ Exception -> 0x02f2 }
        L_0x010f:
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            int r0 = r0.getPlayState()     // Catch:{ Exception -> 0x02f2 }
            r5 = 0
            if (r0 != r9) goto L_0x0180
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0175 }
            if (r0 == 0) goto L_0x0123
            java.lang.String r0 = "StopPlayback stoping..."
            com.tencent.qphone.base.util.QLog.w(r7, r8, r0)     // Catch:{ IllegalStateException -> 0x0175 }
        L_0x0123:
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ IllegalStateException -> 0x0175 }
            r0.stop()     // Catch:{ IllegalStateException -> 0x0175 }
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ IllegalStateException -> 0x0175 }
            r0.flush()     // Catch:{ IllegalStateException -> 0x0175 }
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0175 }
            if (r0 == 0) goto L_0x014d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0175 }
            r0.<init>()     // Catch:{ IllegalStateException -> 0x0175 }
            java.lang.String r12 = "StopPlayback flushing... state:"
            r0.append(r12)     // Catch:{ IllegalStateException -> 0x0175 }
            android.media.AudioTrack r12 = r1._audioTrack     // Catch:{ IllegalStateException -> 0x0175 }
            int r12 = r12.getPlayState()     // Catch:{ IllegalStateException -> 0x0175 }
            r0.append(r12)     // Catch:{ IllegalStateException -> 0x0175 }
            java.lang.String r0 = r0.toString()     // Catch:{ IllegalStateException -> 0x0175 }
            com.tencent.qphone.base.util.QLog.w(r7, r8, r0)     // Catch:{ IllegalStateException -> 0x0175 }
        L_0x014d:
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ IllegalStateException -> 0x0175 }
            r0.release()     // Catch:{ IllegalStateException -> 0x0175 }
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0175 }
            if (r0 == 0) goto L_0x0172
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0175 }
            r0.<init>()     // Catch:{ IllegalStateException -> 0x0175 }
            java.lang.String r12 = "StopPlayback releaseing... state:"
            r0.append(r12)     // Catch:{ IllegalStateException -> 0x0175 }
            android.media.AudioTrack r12 = r1._audioTrack     // Catch:{ IllegalStateException -> 0x0175 }
            int r12 = r12.getPlayState()     // Catch:{ IllegalStateException -> 0x0175 }
            r0.append(r12)     // Catch:{ IllegalStateException -> 0x0175 }
            java.lang.String r0 = r0.toString()     // Catch:{ IllegalStateException -> 0x0175 }
            com.tencent.qphone.base.util.QLog.w(r7, r8, r0)     // Catch:{ IllegalStateException -> 0x0175 }
        L_0x0172:
            r1._audioTrack = r5     // Catch:{ IllegalStateException -> 0x0175 }
            goto L_0x0180
        L_0x0175:
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02f2 }
            if (r0 == 0) goto L_0x0180
            java.lang.String r0 = "StopPlayback err"
            com.tencent.qphone.base.util.QLog.e(r7, r8, r0)     // Catch:{ Exception -> 0x02f2 }
        L_0x0180:
            int r0 = r1._playSamplerate     // Catch:{ Exception -> 0x02f2 }
            int r12 = r1._channelOutType     // Catch:{ Exception -> 0x02f2 }
            int r12 = android.media.AudioTrack.getMinBufferSize(r0, r12, r8)     // Catch:{ Exception -> 0x02f2 }
            r13 = 4
            int[] r14 = new int[r13]     // Catch:{ Exception -> 0x02f2 }
            r14[r6] = r6     // Catch:{ Exception -> 0x02f2 }
            r14[r4] = r6     // Catch:{ Exception -> 0x02f2 }
            r14[r8] = r9     // Catch:{ Exception -> 0x02f2 }
            r14[r9] = r4     // Catch:{ Exception -> 0x02f2 }
            int r0 = r1._streamType     // Catch:{ Exception -> 0x02f2 }
            r14[r6] = r0     // Catch:{ Exception -> 0x02f2 }
            int r0 = r1._playSamplerate     // Catch:{ Exception -> 0x02f2 }
            int r0 = r0 * 20
            int r0 = r0 * 1
            int r0 = r0 * 2
            int r0 = r0 / 1000
            int r9 = r1._channelOutType     // Catch:{ Exception -> 0x02f2 }
            r15 = 12
            if (r9 != r15) goto L_0x01a9
            int r0 = r0 * 2
        L_0x01a9:
            r9 = r0
        L_0x01aa:
            int r0 = r14.length     // Catch:{ Exception -> 0x02f2 }
            if (r6 >= r0) goto L_0x029e
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            if (r0 != 0) goto L_0x029e
            r0 = r14[r6]     // Catch:{ Exception -> 0x02f2 }
            r1._streamType = r0     // Catch:{ Exception -> 0x02f2 }
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02f2 }
            if (r0 == 0) goto L_0x01dd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f2 }
            r0.<init>()     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r15 = "InitPlayback: min play buf size is "
            r0.append(r15)     // Catch:{ Exception -> 0x02f2 }
            r0.append(r12)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r15 = " hw_sr:"
            r0.append(r15)     // Catch:{ Exception -> 0x02f2 }
            int r15 = r1._streamType     // Catch:{ Exception -> 0x02f2 }
            int r15 = android.media.AudioTrack.getNativeOutputSampleRate(r15)     // Catch:{ Exception -> 0x02f2 }
            r0.append(r15)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02f2 }
            com.tencent.qphone.base.util.QLog.w(r7, r8, r0)     // Catch:{ Exception -> 0x02f2 }
        L_0x01dd:
            r15 = 1
        L_0x01de:
            if (r15 > r8) goto L_0x0294
            int r0 = r12 * r15
            int r5 = r9 * 4
            if (r0 >= r5) goto L_0x01ec
            if (r15 >= r8) goto L_0x01ec
            r4 = 0
            r5 = 1
            goto L_0x028c
        L_0x01ec:
            android.media.AudioTrack r5 = new android.media.AudioTrack     // Catch:{ Exception -> 0x025c }
            int r13 = r1._streamType     // Catch:{ Exception -> 0x025c }
            int r4 = r1._playSamplerate     // Catch:{ Exception -> 0x025c }
            int r8 = r1._channelOutType     // Catch:{ Exception -> 0x025c }
            r20 = 2
            r22 = 1
            r16 = r5
            r17 = r13
            r18 = r4
            r19 = r8
            r21 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x025c }
            r1._audioTrack = r5     // Catch:{ Exception -> 0x025c }
            boolean r4 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02f2 }
            if (r4 == 0) goto L_0x0222
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f2 }
            r4.<init>()     // Catch:{ Exception -> 0x02f2 }
            r4.append(r3)     // Catch:{ Exception -> 0x02f2 }
            android.media.AudioTrack r5 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            r4.append(r5)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x02f2 }
            r5 = 2
            com.tencent.qphone.base.util.QLog.w(r7, r5, r4)     // Catch:{ Exception -> 0x02f2 }
        L_0x0222:
            android.media.AudioTrack r4 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            int r4 = r4.getState()     // Catch:{ Exception -> 0x02f2 }
            r5 = 1
            if (r4 == r5) goto L_0x025a
            boolean r4 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02f2 }
            if (r4 == 0) goto L_0x0250
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f2 }
            r4.<init>()     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r8 = "InitPlayback: play not initialized playBufSize:"
            r4.append(r8)     // Catch:{ Exception -> 0x02f2 }
            r4.append(r0)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r0 = " sr:"
            r4.append(r0)     // Catch:{ Exception -> 0x02f2 }
            int r0 = r1._playSamplerate     // Catch:{ Exception -> 0x02f2 }
            r4.append(r0)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x02f2 }
            r4 = 2
            com.tencent.qphone.base.util.QLog.w(r7, r4, r0)     // Catch:{ Exception -> 0x02f2 }
        L_0x0250:
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            r0.release()     // Catch:{ Exception -> 0x02f2 }
            r4 = 0
            r1._audioTrack = r4     // Catch:{ Exception -> 0x02f2 }
            r4 = 0
            goto L_0x028c
        L_0x025a:
            r4 = 0
            goto L_0x0296
        L_0x025c:
            r0 = move-exception
            r5 = 1
            boolean r4 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02f2 }
            if (r4 == 0) goto L_0x0280
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f2 }
            r4.<init>()     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x02f2 }
            r4.append(r0)     // Catch:{ Exception -> 0x02f2 }
            r4.append(r3)     // Catch:{ Exception -> 0x02f2 }
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            r4.append(r0)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x02f2 }
            r4 = 2
            com.tencent.qphone.base.util.QLog.w(r7, r4, r0)     // Catch:{ Exception -> 0x02f2 }
        L_0x0280:
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            if (r0 == 0) goto L_0x0289
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            r0.release()     // Catch:{ Exception -> 0x02f2 }
        L_0x0289:
            r4 = 0
            r1._audioTrack = r4     // Catch:{ Exception -> 0x02f2 }
        L_0x028c:
            int r15 = r15 + 1
            r5 = r4
            r4 = 1
            r8 = 2
            r13 = 4
            goto L_0x01de
        L_0x0294:
            r4 = r5
            r5 = 1
        L_0x0296:
            int r6 = r6 + 1
            r5 = r4
            r4 = 1
            r8 = 2
            r13 = 4
            goto L_0x01aa
        L_0x029e:
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x02f2 }
            if (r0 == 0) goto L_0x02cb
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x02cb }
            r0.play()     // Catch:{ Exception -> 0x02cb }
            com.tencent.rtmp.sharp.jni.TraeAudioSession r0 = r1._as     // Catch:{ Exception -> 0x02cb }
            android.media.AudioManager r3 = r1._audioManager     // Catch:{ Exception -> 0x02cb }
            int r3 = r3.getMode()     // Catch:{ Exception -> 0x02cb }
            int r4 = r1._streamType     // Catch:{ Exception -> 0x02cb }
            r0.voiceCallAudioParamChanged(r3, r4)     // Catch:{ Exception -> 0x02cb }
            android.media.AudioManager r0 = r1._audioManager     // Catch:{ Exception -> 0x02cb }
            java.lang.String r3 = r1._connectedDev     // Catch:{ Exception -> 0x02cb }
            java.lang.String r4 = "DEVICE_BLUETOOTHHEADSET"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x02cb }
            if (r3 == 0) goto L_0x02c2
            r3 = 6
            goto L_0x02c8
        L_0x02c2:
            android.media.AudioTrack r3 = r1._audioTrack     // Catch:{ Exception -> 0x02cb }
            int r3 = r3.getStreamType()     // Catch:{ Exception -> 0x02cb }
        L_0x02c8:
            com.tencent.rtmp.sharp.jni.TraeAudioManager.forceVolumeControlStream(r0, r3)     // Catch:{ Exception -> 0x02cb }
        L_0x02cb:
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02f2 }
            if (r0 == 0) goto L_0x039f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f2 }
            r0.<init>()     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r3 = "  track reset used:"
            r0.append(r3)     // Catch:{ Exception -> 0x02f2 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x02f2 }
            long r3 = r3 - r10
            r0.append(r3)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r3 = "ms"
            r0.append(r3)     // Catch:{ Exception -> 0x02f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02f2 }
            r3 = 2
            com.tencent.qphone.base.util.QLog.e(r7, r3, r0)     // Catch:{ Exception -> 0x02f2 }
            goto L_0x039f
        L_0x02f2:
            r0 = move-exception
            goto L_0x0380
        L_0x02f5:
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x037e }
            byte[] r3 = r1._tempBufPlay     // Catch:{ Exception -> 0x037e }
            int r3 = r0.write(r3, r6, r2)     // Catch:{ Exception -> 0x037e }
            java.nio.ByteBuffer r0 = r1._playBuffer     // Catch:{ Exception -> 0x0379 }
            r0.rewind()     // Catch:{ Exception -> 0x0379 }
            java.lang.String r0 = ")"
            java.lang.String r4 = ", length = "
            if (r3 >= 0) goto L_0x032d
            boolean r6 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x0379 }
            if (r6 == 0) goto L_0x032c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0379 }
            r6.<init>()     // Catch:{ Exception -> 0x0379 }
            java.lang.String r8 = "Could not write data from sc (write = "
            r6.append(r8)     // Catch:{ Exception -> 0x0379 }
            r6.append(r3)     // Catch:{ Exception -> 0x0379 }
            r6.append(r4)     // Catch:{ Exception -> 0x0379 }
            r6.append(r2)     // Catch:{ Exception -> 0x0379 }
            r6.append(r0)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x0379 }
            r2 = 2
            com.tencent.qphone.base.util.QLog.e(r7, r2, r0)     // Catch:{ Exception -> 0x0379 }
        L_0x032c:
            return r5
        L_0x032d:
            if (r3 == r2) goto L_0x0353
            boolean r5 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x0379 }
            if (r5 == 0) goto L_0x0353
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0379 }
            r5.<init>()     // Catch:{ Exception -> 0x0379 }
            java.lang.String r8 = "Could not write all data from sc (write = "
            r5.append(r8)     // Catch:{ Exception -> 0x0379 }
            r5.append(r3)     // Catch:{ Exception -> 0x0379 }
            r5.append(r4)     // Catch:{ Exception -> 0x0379 }
            r5.append(r2)     // Catch:{ Exception -> 0x0379 }
            r5.append(r0)     // Catch:{ Exception -> 0x0379 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0379 }
            r2 = 2
            com.tencent.qphone.base.util.QLog.e(r7, r2, r0)     // Catch:{ Exception -> 0x0379 }
        L_0x0353:
            int r0 = r1._bufferedPlaySamples     // Catch:{ Exception -> 0x0379 }
            int r2 = r3 >> 1
            int r0 = r0 + r2
            r1._bufferedPlaySamples = r0     // Catch:{ Exception -> 0x0379 }
            android.media.AudioTrack r0 = r1._audioTrack     // Catch:{ Exception -> 0x0379 }
            int r0 = r0.getPlaybackHeadPosition()     // Catch:{ Exception -> 0x0379 }
            int r2 = r1._playPosition     // Catch:{ Exception -> 0x0379 }
            if (r0 >= r2) goto L_0x0366
            r1._playPosition = r6     // Catch:{ Exception -> 0x0379 }
        L_0x0366:
            int r2 = r1._bufferedPlaySamples     // Catch:{ Exception -> 0x0379 }
            int r4 = r1._playPosition     // Catch:{ Exception -> 0x0379 }
            int r4 = r0 - r4
            int r2 = r2 - r4
            r1._bufferedPlaySamples = r2     // Catch:{ Exception -> 0x0379 }
            r1._playPosition = r0     // Catch:{ Exception -> 0x0379 }
            boolean r0 = r1._isRecording     // Catch:{ Exception -> 0x0379 }
            if (r0 != 0) goto L_0x0377
            int r0 = r1._bufferedPlaySamples     // Catch:{ Exception -> 0x0379 }
        L_0x0377:
            r2 = r3
            goto L_0x039f
        L_0x0379:
            r0 = move-exception
            r2 = r3
            goto L_0x0380
        L_0x037c:
            r0 = move-exception
            goto L_0x03a0
        L_0x037e:
            r0 = move-exception
            r2 = 0
        L_0x0380:
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ all -> 0x037c }
            if (r3 == 0) goto L_0x039f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x037c }
            r3.<init>()     // Catch:{ all -> 0x037c }
            java.lang.String r4 = "PlayAudio Exception: "
            r3.append(r4)     // Catch:{ all -> 0x037c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x037c }
            r3.append(r0)     // Catch:{ all -> 0x037c }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x037c }
            r3 = 2
            com.tencent.qphone.base.util.QLog.e(r7, r3, r0)     // Catch:{ all -> 0x037c }
        L_0x039f:
            return r2
        L_0x03a0:
            goto L_0x03a2
        L_0x03a1:
            throw r0
        L_0x03a2:
            goto L_0x03a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.AudioDeviceInterface.PlayAudio(int):int");
    }

    private int OpenslesNeedResetAudioTrack(boolean z) {
        try {
            if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
                return -1;
            }
            if (this._audioRouteChanged || z) {
                if (this._audioManager == null && this._context != null) {
                    this._audioManager = (AudioManager) this._context.getSystemService("audio");
                }
                if (this._audioManager == null) {
                    return 0;
                }
                if (this._audioManager.getMode() != 0 || !this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    this._audioStreamTypePolicy = 0;
                } else {
                    this._audioStreamTypePolicy = 3;
                }
                this._audioRouteChanged = false;
            }
            return this._audioStreamTypePolicy;
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "PlayAudio Exception: " + e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int RecordAudio(int r10) {
        /*
            r9 = this;
            boolean r0 = r9._isRecording
            r1 = -1
            r2 = 2
            java.lang.String r3 = "TRAE"
            if (r0 != 0) goto L_0x0025
            boolean r10 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r10 == 0) goto L_0x0024
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "RecordAudio: _isRecording "
            r10.append(r0)
            boolean r0 = r9._isRecording
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            com.tencent.qphone.base.util.QLog.e(r3, r2, r10)
        L_0x0024:
            return r1
        L_0x0025:
            r0 = 0
            android.media.AudioRecord r4 = r9._audioRecord     // Catch:{ Exception -> 0x00dd }
            if (r4 != 0) goto L_0x002c
            r10 = -2
            return r10
        L_0x002c:
            boolean r4 = r9._doRecInit     // Catch:{ Exception -> 0x00dd }
            r5 = 1
            if (r4 != r5) goto L_0x0061
            r4 = -19
            android.os.Process.setThreadPriority(r4)     // Catch:{ Exception -> 0x0040 }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r5 = "TRAEAudioRecord"
            r4.setName(r5)     // Catch:{ Exception -> 0x0040 }
            goto L_0x005f
        L_0x0040:
            r4 = move-exception
            boolean r5 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x00dd }
            if (r5 == 0) goto L_0x005f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd }
            r5.<init>()     // Catch:{ Exception -> 0x00dd }
            java.lang.String r6 = "Set rec thread priority failed: "
            r5.append(r6)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r4 = r4.getMessage()     // Catch:{ Exception -> 0x00dd }
            r5.append(r4)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00dd }
            com.tencent.qphone.base.util.QLog.w(r3, r2, r4)     // Catch:{ Exception -> 0x00dd }
        L_0x005f:
            r9._doRecInit = r0     // Catch:{ Exception -> 0x00dd }
        L_0x0061:
            java.nio.ByteBuffer r4 = r9._recBuffer     // Catch:{ Exception -> 0x00dd }
            r4.rewind()     // Catch:{ Exception -> 0x00dd }
            android.media.AudioRecord r4 = r9._audioRecord     // Catch:{ Exception -> 0x00dd }
            byte[] r5 = r9._tempBufRec     // Catch:{ Exception -> 0x00dd }
            int r4 = r4.read(r5, r0, r10)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r5 = ")"
            java.lang.String r6 = ", length = "
            if (r4 >= 0) goto L_0x0098
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x0097
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
            r0.<init>()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r7 = "Could not read data from sc (read = "
            r0.append(r7)     // Catch:{ Exception -> 0x00d9 }
            r0.append(r4)     // Catch:{ Exception -> 0x00d9 }
            r0.append(r6)     // Catch:{ Exception -> 0x00d9 }
            r0.append(r10)     // Catch:{ Exception -> 0x00d9 }
            r0.append(r5)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00d9 }
            com.tencent.qphone.base.util.QLog.e(r3, r2, r10)     // Catch:{ Exception -> 0x00d9 }
        L_0x0097:
            return r1
        L_0x0098:
            java.nio.ByteBuffer r7 = r9._recBuffer     // Catch:{ Exception -> 0x00d9 }
            byte[] r8 = r9._tempBufRec     // Catch:{ Exception -> 0x00d9 }
            r7.put(r8, r0, r4)     // Catch:{ Exception -> 0x00d9 }
            boolean r7 = _dumpEnable     // Catch:{ Exception -> 0x00d9 }
            if (r7 == 0) goto L_0x00b3
            java.io.FileOutputStream r7 = r9._rec_out     // Catch:{ Exception -> 0x00d9 }
            if (r7 == 0) goto L_0x00b3
            java.io.FileOutputStream r7 = r9._rec_out     // Catch:{ IOException -> 0x00af }
            byte[] r8 = r9._tempBufRec     // Catch:{ IOException -> 0x00af }
            r7.write(r8, r0, r4)     // Catch:{ IOException -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x00d9 }
        L_0x00b3:
            if (r4 == r10) goto L_0x00fd
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x00d8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
            r0.<init>()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r7 = "Could not read all data from sc (read = "
            r0.append(r7)     // Catch:{ Exception -> 0x00d9 }
            r0.append(r4)     // Catch:{ Exception -> 0x00d9 }
            r0.append(r6)     // Catch:{ Exception -> 0x00d9 }
            r0.append(r10)     // Catch:{ Exception -> 0x00d9 }
            r0.append(r5)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00d9 }
            com.tencent.qphone.base.util.QLog.e(r3, r2, r10)     // Catch:{ Exception -> 0x00d9 }
        L_0x00d8:
            return r1
        L_0x00d9:
            r10 = move-exception
            goto L_0x00df
        L_0x00db:
            r10 = move-exception
            goto L_0x00fe
        L_0x00dd:
            r10 = move-exception
            r4 = 0
        L_0x00df:
            boolean r0 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ all -> 0x00db }
            if (r0 == 0) goto L_0x00fd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r0.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r1 = "RecordAudio Exception: "
            r0.append(r1)     // Catch:{ all -> 0x00db }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00db }
            r0.append(r10)     // Catch:{ all -> 0x00db }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x00db }
            com.tencent.qphone.base.util.QLog.e(r3, r2, r10)     // Catch:{ all -> 0x00db }
        L_0x00fd:
            return r4
        L_0x00fe:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.AudioDeviceInterface.RecordAudio(int):int");
    }

    private int SetPlayoutVolume(int i) {
        if (this._audioManager == null) {
            Context context = this._context;
            if (context != null) {
                this._audioManager = (AudioManager) context.getSystemService("audio");
            }
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            return -1;
        }
        audioManager.setStreamVolume(0, i, 0);
        return 0;
    }

    private int GetPlayoutVolume() {
        if (this._audioManager == null) {
            Context context = this._context;
            if (context != null) {
                this._audioManager = (AudioManager) context.getSystemService("audio");
            }
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager != null) {
            return audioManager.getStreamVolume(0);
        }
        return -1;
    }

    public static String getTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        stringBuffer.append("");
        stringBuffer.append(stackTrace[2].getClassName());
        stringBuffer.append(".");
        stringBuffer.append(stackTrace[2].getMethodName());
        stringBuffer.append(": ");
        stringBuffer.append(stackTrace[2].getLineNumber());
        return stringBuffer.toString();
    }

    public static final void LogTraceEntry(String str) {
        if (_logEnable) {
            String str2 = getTraceInfo() + " entry:" + str;
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, str2);
            }
        }
    }

    public static final void LogTraceExit() {
        if (_logEnable) {
            String str = getTraceInfo() + " exit";
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onOutputChanage(String str) {
        String str2;
        String str3;
        String str4;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " onOutputChanage:" + str);
        }
        setAudioRouteSwitchState(str);
        if (TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
            int i = this._deviceStat;
            if (i != 1 && i != 5 && i != 2 && i != 3) {
                this._connectedDev = str;
                if (QLog.isColorLevel()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" onOutputChanage:");
                    sb.append(str);
                    if (this._audioManager == null) {
                        str3 = " am==null";
                    } else {
                        str3 = " mode:" + this._audioManager.getMode();
                    }
                    sb.append(str3);
                    sb.append(" st:");
                    sb.append(this._streamType);
                    if (this._audioTrack == null) {
                        str4 = "_audioTrack==null";
                    } else {
                        str4 = " at.st:" + this._audioTrack.getStreamType();
                    }
                    sb.append(str4);
                    QLog.w("TRAE", 2, sb.toString());
                }
                try {
                    if (this._audioManager == null) {
                        this._audioManager = (AudioManager) this._context.getSystemService("audio");
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" curr mode:");
                        sb2.append(str);
                        if (this._audioManager == null) {
                            str2 = "am==null";
                        } else {
                            str2 = " mode:" + this._audioManager.getMode();
                        }
                        sb2.append(str2);
                        QLog.w("TRAE", 2, sb2.toString());
                    }
                    if (this._audioManager != null && this._connectedDev.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                        this._audioManager.setMode(0);
                    }
                } catch (Exception e2) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, e2.getMessage());
                    }
                }
                this._audioRouteChanged = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e8, code lost:
        r8._prelock.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ed, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00e1 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e7 A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:6:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int call_preprocess() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            LogTraceEntry(r0)
            r0 = 0
            r8.switchState = r0
            int r1 = r8._audioStreamTypePolicy
            int r1 = com.tencent.rtmp.sharp.jni.TraeAudioManager.getAudioStreamType(r1)
            r8._streamType = r1
            com.tencent.rtmp.sharp.jni.TraeAudioSession r1 = r8._as
            if (r1 != 0) goto L_0x0022
            com.tencent.rtmp.sharp.jni.TraeAudioSession r1 = new com.tencent.rtmp.sharp.jni.TraeAudioSession
            android.content.Context r2 = r8._context
            com.tencent.rtmp.sharp.jni.AudioDeviceInterface$1 r3 = new com.tencent.rtmp.sharp.jni.AudioDeviceInterface$1
            r3.<init>()
            r1.<init>(r2, r3)
            r8._as = r1
        L_0x0022:
            r8._preDone = r0
            com.tencent.rtmp.sharp.jni.TraeAudioSession r1 = r8._as
            if (r1 == 0) goto L_0x00f3
            java.util.concurrent.locks.ReentrantLock r1 = r8._prelock
            r1.lock()
            android.media.AudioManager r1 = r8._audioManager     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            if (r1 != 0) goto L_0x003d
            android.content.Context r1 = r8._context     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            java.lang.String r2 = "audio"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            android.media.AudioManager r1 = (android.media.AudioManager) r1     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r8._audioManager = r1     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
        L_0x003d:
            android.media.AudioManager r1 = r8._audioManager     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            java.lang.String r2 = "TRAE"
            r3 = 2
            if (r1 == 0) goto L_0x0098
            android.media.AudioManager r1 = r8._audioManager     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            int r1 = r1.getMode()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            if (r1 != r3) goto L_0x0080
            r1 = 5
        L_0x004d:
            int r4 = r1 + -1
            if (r1 <= 0) goto L_0x0080
            android.media.AudioManager r1 = r8._audioManager     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            int r1 = r1.getMode()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            if (r1 != r3) goto L_0x0080
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            if (r1 == 0) goto L_0x0079
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r1.<init>()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            java.lang.String r5 = "call_preprocess waiting...  mode:"
            r1.append(r5)     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            android.media.AudioManager r5 = r8._audioManager     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            int r5 = r5.getMode()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r1.append(r5)     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            java.lang.String r1 = r1.toString()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            com.tencent.qphone.base.util.QLog.e(r2, r3, r1)     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
        L_0x0079:
            r5 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r5)     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r1 = r4
            goto L_0x004d
        L_0x0080:
            android.media.AudioManager r1 = r8._audioManager     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            boolean r1 = r1.isMicrophoneMute()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            if (r1 == 0) goto L_0x0098
            android.media.AudioManager r1 = r8._audioManager     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r1.setMicrophoneMute(r0)     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = "media call_preprocess setMicrophoneMute false"
            com.tencent.qphone.base.util.QLog.e(r2, r3, r1)     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
        L_0x0098:
            com.tencent.rtmp.sharp.jni.TraeAudioSession r1 = r8._as     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            int r4 = r8._modePolicy     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            int r5 = r8._streamType     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r1.voiceCallPreprocess(r4, r5)     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            com.tencent.rtmp.sharp.jni.TraeAudioSession r1 = r8._as     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r1.connectHighestPriorityDevice()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r1 = 7
        L_0x00a7:
            int r4 = r1 + -1
            if (r1 <= 0) goto L_0x00d6
            boolean r1 = r8._preDone     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            if (r1 != 0) goto L_0x00d6
            java.util.concurrent.locks.Condition r1 = r8._precon     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            r5 = 1
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            r1.await(r5, r7)     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            if (r1 == 0) goto L_0x00d4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            r1.<init>()     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            java.lang.String r5 = "call_preprocess waiting...  as:"
            r1.append(r5)     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            com.tencent.rtmp.sharp.jni.TraeAudioSession r5 = r8._as     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            r1.append(r5)     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            java.lang.String r1 = r1.toString()     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            com.tencent.qphone.base.util.QLog.e(r2, r3, r1)     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
        L_0x00d4:
            r1 = r4
            goto L_0x00a7
        L_0x00d6:
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
            if (r1 == 0) goto L_0x00e1
            java.lang.String r1 = "call_preprocess done!"
            com.tencent.qphone.base.util.QLog.e(r2, r3, r1)     // Catch:{ InterruptedException -> 0x00e1, all -> 0x00e7 }
        L_0x00e1:
            com.tencent.rtmp.sharp.jni.TraeAudioSession r1 = r8._as     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            r1.getConnectedDevice()     // Catch:{ InterruptedException -> 0x00ee, all -> 0x00e7 }
            goto L_0x00ee
        L_0x00e7:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r8._prelock
            r1.unlock()
            throw r0
        L_0x00ee:
            java.util.concurrent.locks.ReentrantLock r1 = r8._prelock
            r1.unlock()
        L_0x00f3:
            LogTraceExit()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.AudioDeviceInterface.call_preprocess():int");
    }

    public int call_postprocess() {
        LogTraceEntry("");
        this.switchState = 0;
        TraeAudioSession traeAudioSession = this._as;
        if (traeAudioSession != null) {
            traeAudioSession.voiceCallPostprocess();
            this._as.release();
            this._as = null;
        }
        TraeAudioManager.IsUpdateSceneFlag = false;
        LogTraceExit();
        return 0;
    }

    public int call_preprocess_media() {
        LogTraceEntry("");
        this.switchState = 0;
        VivoKTVHelper vivoKTVHelper = mVivoKTVHelper;
        if (vivoKTVHelper != null && isSupportVivoKTVHelper) {
            vivoKTVHelper.openKTVDevice();
            mVivoKTVHelper.setPreModeParam(1);
            mVivoKTVHelper.setPlayFeedbackParam(1);
            mVivoKTVHelper.setPlayFeedbackParam(0);
        }
        if (this._as == null) {
            this._as = new TraeAudioSession(this._context, new TraeAudioSession.a() {
                public void a(int i) {
                }

                public void a(int i, int i2) {
                }

                public void a(int i, String str, boolean z) {
                }

                public void a(int i, boolean z) {
                }

                public void a(String str, long j) {
                }

                public void a(String str, String str2) {
                }

                public void a(boolean z) {
                }

                public void b(int i) {
                }

                public void b(int i, String str) {
                }

                public void b(boolean z) {
                }

                public void c(int i, String str) {
                }

                public void a(String[] strArr, String str, String str2, String str3) {
                    String[] unused = AudioDeviceInterface.mDeviceList = strArr;
                    if (AudioDeviceInterface.this.usingJava) {
                        AudioDeviceInterface.this.onOutputChanage(str);
                    }
                }

                public void a(int i, String[] strArr, String str, String str2, String str3) {
                    String[] unused = AudioDeviceInterface.mDeviceList = strArr;
                }

                public void a(int i, String str) {
                    if (i == 0) {
                        AudioDeviceInterface.this.onOutputChanage(str);
                    }
                }
            });
        }
        if (this._as != null) {
            try {
                if (this._audioManager == null) {
                    this._audioManager = (AudioManager) this._context.getSystemService("audio");
                }
                if (this._audioManager != null) {
                    if (this._audioManager.getMode() == 2) {
                        int i = 5;
                        while (true) {
                            int i2 = i - 1;
                            if (i <= 0 || this._audioManager.getMode() != 2) {
                                break;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.e("TRAE", 2, "media call_preprocess_media waiting...  mode:" + this._audioManager.getMode());
                            }
                            Thread.sleep(500);
                            i = i2;
                        }
                    }
                    if (this._audioManager.getMode() != 0) {
                        this._audioManager.setMode(0);
                    }
                    if (this._audioManager.isMicrophoneMute()) {
                        this._audioManager.setMicrophoneMute(false);
                        if (QLog.isColorLevel()) {
                            QLog.e("TRAE", 2, "media call_preprocess_media setMicrophoneMute false");
                        }
                    }
                }
                this._as.connectHighestPriorityDevice();
                this._as.getConnectedDevice();
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "call_preprocess_media done!");
                }
            } catch (InterruptedException unused) {
            }
        }
        LogTraceExit();
        return 0;
    }

    public int call_postprocess_media() {
        LogTraceEntry("");
        this.switchState = 0;
        TraeAudioSession traeAudioSession = this._as;
        if (traeAudioSession != null) {
            traeAudioSession.release();
            this._as = null;
        }
        TraeAudioManager.IsUpdateSceneFlag = false;
        VivoKTVHelper vivoKTVHelper = mVivoKTVHelper;
        if (vivoKTVHelper != null && isSupportVivoKTVHelper) {
            vivoKTVHelper.closeKTVDevice();
        }
        LogTraceExit();
        return 0;
    }

    public void setJavaInterface(int i) {
        if (i == 0) {
            this.usingJava = false;
        } else {
            this.usingJava = true;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setJavaInterface flg:" + i);
        }
    }

    private void setAudioRouteSwitchState(String str) {
        if (str.equals(TraeAudioManager.DEVICE_EARPHONE)) {
            this.switchState = 1;
        } else if (str.equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
            this.switchState = 2;
        } else if (str.equals(TraeAudioManager.DEVICE_WIREDHEADSET)) {
            this.switchState = 3;
        } else if (str.equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
            this.switchState = 4;
        } else {
            this.switchState = 0;
        }
    }

    public int getAudioRouteSwitchState() {
        return this.switchState;
    }

    private void initTRAEAudioManager() {
        Context context = this._context;
        if (context != null) {
            TraeAudioManager.init(context);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession create");
            }
            if (this._asAudioManager == null) {
                this._asAudioManager = new TraeAudioSession(this._context, new TraeAudioSession.a() {
                    public void a(int i) {
                    }

                    public void a(int i, int i2) {
                    }

                    public void a(int i, String str, boolean z) {
                    }

                    public void a(int i, boolean z) {
                    }

                    public void a(String str, long j) {
                    }

                    public void a(String str, String str2) {
                    }

                    public void a(boolean z) {
                    }

                    public void b(int i) {
                    }

                    public void b(int i, String str) {
                    }

                    public void b(boolean z) {
                    }

                    public void c(int i, String str) {
                    }

                    public void a(String[] strArr, String str, String str2, String str3) {
                        String[] unused = AudioDeviceInterface.mDeviceList = strArr;
                        if (AudioDeviceInterface.this.usingJava) {
                            AudioDeviceInterface.this.onOutputChanage(str);
                        }
                    }

                    public void a(int i, String[] strArr, String str, String str2, String str3) {
                        String[] unused = AudioDeviceInterface.mDeviceList = strArr;
                    }

                    public void a(int i, String str) {
                        if (i == 0) {
                            AudioDeviceInterface.this.onOutputChanage(str);
                        }
                    }
                });
            }
            this._asAudioManager.startService(TraeAudioManager.VIDEO_CONFIG);
        }
    }

    private int startService(String str) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService: " + this._asAudioManager + " deviceConfig:" + str);
        }
        TraeAudioSession traeAudioSession = this._asAudioManager;
        if (traeAudioSession != null) {
            return traeAudioSession.startService(str);
        }
        return -1;
    }

    private int stopService() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession stopService: " + this._asAudioManager);
        }
        TraeAudioSession traeAudioSession = this._asAudioManager;
        if (traeAudioSession != null) {
            return traeAudioSession.stopService();
        }
        return -1;
    }

    private int SetAudioOutputMode(int i) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioSession SetAudioOutputMode: " + i);
        }
        if (i == 0) {
            if (mDeviceList == null || this._asAudioManager == null) {
                return -1;
            }
            boolean z = false;
            do {
                int i2 = 0;
                while (true) {
                    String[] strArr = mDeviceList;
                    if (i2 >= strArr.length || z) {
                        break;
                    } else if (TraeAudioManager.DEVICE_WIREDHEADSET.equals(strArr[i2])) {
                        this._asAudioManager.connectDevice(TraeAudioManager.DEVICE_WIREDHEADSET);
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                int i3 = 0;
                while (true) {
                    String[] strArr2 = mDeviceList;
                    if (i3 >= strArr2.length || z) {
                        break;
                    } else if (TraeAudioManager.DEVICE_BLUETOOTHHEADSET.equals(strArr2[i3])) {
                        this._asAudioManager.connectDevice(TraeAudioManager.DEVICE_BLUETOOTHHEADSET);
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                int i4 = 0;
                while (true) {
                    String[] strArr3 = mDeviceList;
                    if (i4 >= strArr3.length || z) {
                        break;
                    } else if (TraeAudioManager.DEVICE_EARPHONE.equals(strArr3[i4])) {
                        this._asAudioManager.connectDevice(TraeAudioManager.DEVICE_EARPHONE);
                        z = true;
                        continue;
                        break;
                    } else {
                        i4++;
                    }
                }
            } while (!z);
            return 0;
        } else if (1 != i) {
            return -1;
        } else {
            TraeAudioSession traeAudioSession = this._asAudioManager;
            if (traeAudioSession == null) {
                return -1;
            }
            traeAudioSession.connectDevice(TraeAudioManager.DEVICE_SPEAKERPHONE);
            return 0;
        }
    }

    private int getAndroidSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public int hasLightSensorManager() {
        Context context = this._context;
        if (context == null) {
            return 1;
        }
        try {
            if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "hasLightSensorManager");
                }
                return 1;
            } else if (!QLog.isColorLevel()) {
                return 0;
            } else {
                QLog.w("TRAE", 2, "not hasLightSensorManager null == sensor8");
                return 0;
            }
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, e2.getMessage());
            }
            return 1;
        }
    }

    static boolean isHardcodeOpenSles() {
        if (Build.MANUFACTURER.equals("Xiaomi")) {
            if (!Build.MODEL.equals("MI 5") && !Build.MODEL.equals("MI 5s") && !Build.MODEL.equals("MI 5s Plus")) {
                return false;
            }
            return true;
        } else if (!Build.MANUFACTURER.equals("samsung") || !Build.MODEL.equals("SM-G9350")) {
            return false;
        } else {
            return true;
        }
    }

    public int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    private int isSupportLowLatency() {
        if (!isHardcodeOpenSles()) {
            return 0;
        }
        if (!QLog.isColorLevel()) {
            return 1;
        }
        QLog.w("TRAE", 2, "hardcode FEATURE_AUDIO_LOW_LATENCY: " + Build.MANUFACTURER + "_" + Build.MODEL);
        return 1;
    }

    private int isSupportVivoKTVHelper() {
        Context context = this._context;
        if (context != null) {
            mVivoKTVHelper = VivoKTVHelper.getInstance(context);
            VivoKTVHelper vivoKTVHelper = mVivoKTVHelper;
            if (vivoKTVHelper != null) {
                isSupportVivoKTVHelper = vivoKTVHelper.isDeviceSupportKaraoke();
            }
        }
        return isSupportVivoKTVHelper ? 1 : 0;
    }

    private int EnableVivoKTVLoopback(int i) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "EnableVivoKTVLoopback: " + i + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper + " mVivoKTVHelper:" + mVivoKTVHelper);
        }
        VivoKTVHelper vivoKTVHelper = mVivoKTVHelper;
        if (vivoKTVHelper == null || !isSupportVivoKTVHelper) {
            return -1;
        }
        vivoKTVHelper.setPlayFeedbackParam(i);
        return 0;
    }

    private int isVivoKTVLoopback() {
        VivoKTVHelper vivoKTVHelper = mVivoKTVHelper;
        if (vivoKTVHelper == null || !isSupportVivoKTVHelper) {
            return 0;
        }
        return vivoKTVHelper.getPlayFeedbackParam();
    }

    private void uninitTRAEAudioManager() {
        if (this._context != null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
            }
            TraeAudioSession traeAudioSession = this._asAudioManager;
            if (traeAudioSession != null) {
                traeAudioSession.stopService();
                this._asAudioManager.release();
                this._asAudioManager = null;
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
        }
    }

    private int OpenMp3File(String str, int i, int i2) {
        long j = (long) i;
        if (this._traeAudioCodecList.find(j) != null) {
            return -1;
        }
        TraeAudioCodecList.a add = this._traeAudioCodecList.add(j);
        add.f32404b.setIOPath(str);
        add.f32404b.setIndex(i);
        int prepare = add.f32404b.prepare(i2);
        if (prepare == 0) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "openFile mp3 Failed!!!");
        }
        add.f32404b.release();
        add.f32404b = null;
        this._traeAudioCodecList.remove(j);
        return prepare;
    }

    private ByteBuffer getDecBuffer(int i) {
        switch (i) {
            case 0:
                return this._decBuffer0;
            case 1:
                return this._decBuffer1;
            case 2:
                return this._decBuffer2;
            case 3:
                return this._decBuffer3;
            case 4:
                return this._decBuffer4;
            case 5:
                return this._decBuffer5;
            case 6:
                return this._decBuffer6;
            case 7:
                return this._decBuffer7;
            case 8:
                return this._decBuffer8;
            case 9:
                return this._decBuffer9;
            case 10:
                return this._decBuffer10;
            default:
                QLog.w("TRAE", 2, "getDecBuffer failed!! index:" + i);
                return null;
        }
    }

    private int ReadMp3File(int i) {
        TraeAudioCodecList.a find = this._traeAudioCodecList.find((long) i);
        if (find == null) {
            return -1;
        }
        ByteBuffer decBuffer = getDecBuffer(i);
        if (decBuffer == null) {
            return -1;
        }
        decBuffer.rewind();
        int frameSize = find.f32404b.getFrameSize();
        int ReadOneFrame = find.f32404b.ReadOneFrame(find.f32405c, frameSize);
        decBuffer.put(find.f32405c, 0, frameSize);
        return ReadOneFrame;
    }

    private int CloseMp3File(int i) {
        long j = (long) i;
        TraeAudioCodecList.a find = this._traeAudioCodecList.find(j);
        if (find == null) {
            return -1;
        }
        find.f32404b.release();
        find.f32404b = null;
        this._traeAudioCodecList.remove(j);
        return 0;
    }

    private int SeekMp3To(int i, int i2) {
        TraeAudioCodecList.a find = this._traeAudioCodecList.find((long) i);
        if (find != null) {
            return find.f32404b.SeekTo(i2);
        }
        return 0;
    }

    private int getMp3SampleRate(int i) {
        TraeAudioCodecList.a find = this._traeAudioCodecList.find((long) i);
        if (find != null) {
            return find.f32404b.getSampleRate();
        }
        return -1;
    }

    private int getMp3Channels(int i) {
        TraeAudioCodecList.a find = this._traeAudioCodecList.find((long) i);
        if (find != null) {
            return find.f32404b.getChannels();
        }
        return -1;
    }

    private long getMp3FileTotalMs(int i) {
        TraeAudioCodecList.a find = this._traeAudioCodecList.find((long) i);
        if (find != null) {
            return find.f32404b.getFileTotalMs();
        }
        return -1;
    }

    public int checkAACSupported() {
        int checkAACMediaCodecSupported = checkAACMediaCodecSupported(false);
        int checkAACMediaCodecSupported2 = checkAACMediaCodecSupported(true);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "checkAACSupported isSupportEncoder: " + checkAACMediaCodecSupported + ", isSupportDecoder:" + checkAACMediaCodecSupported2);
        }
        return (checkAACMediaCodecSupported == 1 && checkAACMediaCodecSupported2 == 1) ? 1 : 0;
    }

    @SuppressLint({"NewApi"})
    public int checkAACMediaCodecSupported(boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                    if (mediaCodecInfo.isEncoder() != z) {
                        if (mediaCodecInfo.getName().toLowerCase().contains("nvidia")) {
                            return 0;
                        }
                        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                        for (String equalsIgnoreCase : supportedTypes) {
                            if (equalsIgnoreCase.equalsIgnoreCase("audio/mp4a-latm")) {
                                if (QLog.isColorLevel()) {
                                    QLog.w("TRAE", 2, "checkAACSupported support!, " + mediaCodecInfo.getName());
                                }
                                return 1;
                            }
                        }
                        continue;
                    }
                }
            } else {
                int codecCount = MediaCodecList.getCodecCount();
                for (int i = 0; i < codecCount; i++) {
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                    if (codecInfoAt.isEncoder() != z) {
                        if (codecInfoAt.getName().toLowerCase().contains("nvidia")) {
                            return 0;
                        }
                        String[] supportedTypes2 = codecInfoAt.getSupportedTypes();
                        for (String equalsIgnoreCase2 : supportedTypes2) {
                            if (equalsIgnoreCase2.equalsIgnoreCase("audio/mp4a-latm")) {
                                if (QLog.isColorLevel()) {
                                    QLog.w("TRAE", 2, "checkAACSupported support!, " + codecInfoAt.getName());
                                }
                                return 1;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "Error when checking aac codec availability");
        }
        return 0;
    }
}
