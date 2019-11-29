package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
    public static final int TRAE_MEDIAPLAER_STOP = 100;
    private Context _context;
    private int _durationMS = -1;
    private boolean _hasCall = false;
    private boolean _loop = false;
    int _loopCount = 0;
    private int _prevVolume = -1;
    boolean _ringMode = false;
    private int _streamType = 0;
    private Timer _watchTimer = null;
    private TimerTask _watchTimertask = null;
    /* access modifiers changed from: private */
    public a mCallback;
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlay = null;

    public interface a {
        void a();
    }

    public TraeMediaPlayer(Context context, a aVar) {
        this._context = context;
        this.mCallback = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0299, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x029a, code lost:
        r2 = r0;
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x029f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02a0, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02a1, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02a5, code lost:
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L_0x02a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02a7, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append("TraeMediaPlay | SecurityException: ");
        r3.append(r2.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02b8, code lost:
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02ba, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r3.append(r4);
        r3.append(r2.getMessage());
        com.tencent.qphone.base.util.QLog.d("TRAE", 2, r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02ce, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02cf, code lost:
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02d4, code lost:
        r4 = r18;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02dd, code lost:
        com.tencent.qphone.base.util.QLog.d("TRAE", 2, "TraeMediaPlay | IllegalArgumentException: " + r2.getLocalizedMessage() + r4 + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0302, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0303, code lost:
        r4 = r18;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x030c, code lost:
        com.tencent.qphone.base.util.QLog.d("TRAE", 2, "TraeMediaPlay | IOException: " + r2.getLocalizedMessage() + r4 + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0330, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0331, code lost:
        r4 = r18;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x033a, code lost:
        com.tencent.qphone.base.util.QLog.d("TRAE", 2, "TraeMediaPlay | IllegalStateException: " + r2.getLocalizedMessage() + r4 + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x035e, code lost:
        r0 = e;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x035f, code lost:
        r2 = r0;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0364, code lost:
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0366, code lost:
        com.tencent.qphone.base.util.QLog.d("TRAE", 2, "TraeMediaPlay | Except: " + r2.getLocalizedMessage() + r4 + r2.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00d2 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0299 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:23:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x029f A[ExcHandler: SecurityException (r0v5 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:23:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02dd A[Catch:{ Exception -> 0x035e }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x030c A[Catch:{ Exception -> 0x035e }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x033a A[Catch:{ Exception -> 0x035e }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0366  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean playRing(int r26, int r27, android.net.Uri r28, java.lang.String r29, boolean r30, int r31, boolean r32, boolean r33, int r34) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r30
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            java.lang.String r11 = " "
            boolean r12 = com.tencent.qphone.base.util.QLog.isColorLevel()
            java.lang.String r13 = " :loopCount"
            java.lang.String r14 = "Y"
            java.lang.String r15 = "N"
            r16 = r14
            java.lang.String r14 = " loop:"
            r17 = r15
            java.lang.String r15 = "TRAE"
            r18 = r11
            if (r12 == 0) goto L_0x008b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r11 = "TraeMediaPlay | playRing datasource:"
            r12.append(r11)
            r12.append(r2)
            java.lang.String r11 = " rsid:"
            r12.append(r11)
            r12.append(r3)
            java.lang.String r11 = " uri:"
            r12.append(r11)
            r12.append(r4)
            java.lang.String r11 = " filepath:"
            r12.append(r11)
            r12.append(r5)
            r12.append(r14)
            if (r6 == 0) goto L_0x0059
            r11 = r16
            goto L_0x005b
        L_0x0059:
            r11 = r17
        L_0x005b:
            r12.append(r11)
            r12.append(r13)
            r12.append(r7)
            java.lang.String r11 = " ringMode:"
            r12.append(r11)
            if (r8 == 0) goto L_0x006e
            r11 = r16
            goto L_0x0070
        L_0x006e:
            r11 = r17
        L_0x0070:
            r12.append(r11)
            java.lang.String r11 = " hasCall:"
            r12.append(r11)
            r12.append(r9)
            java.lang.String r11 = " cst:"
            r12.append(r11)
            r12.append(r10)
            java.lang.String r11 = r12.toString()
            r12 = 2
            com.tencent.qphone.base.util.QLog.e(r15, r12, r11)
        L_0x008b:
            r11 = 0
            if (r6 != 0) goto L_0x00bf
            if (r7 > 0) goto L_0x00bf
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r3 == 0) goto L_0x00be
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "TraeMediaPlay | playRing err datasource:"
            r3.append(r4)
            r3.append(r2)
            r3.append(r14)
            if (r6 == 0) goto L_0x00ab
            r2 = r16
            goto L_0x00ad
        L_0x00ab:
            r2 = r17
        L_0x00ad:
            r3.append(r2)
            r3.append(r13)
            r3.append(r7)
            java.lang.String r2 = r3.toString()
            r3 = 2
            com.tencent.qphone.base.util.QLog.e(r15, r3, r2)
        L_0x00be:
            return r11
        L_0x00bf:
            r12 = 0
            android.media.MediaPlayer r13 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0330, IOException -> 0x0302, IllegalArgumentException -> 0x02d3, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r13 == 0) goto L_0x00da
            android.media.MediaPlayer r13 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            boolean r13 = r13.isPlaying()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r13 == 0) goto L_0x00cd
            return r11
        L_0x00cd:
            android.media.MediaPlayer r13 = r1.mMediaPlay     // Catch:{ Exception -> 0x00d2, all -> 0x00d5 }
            r13.release()     // Catch:{ Exception -> 0x00d2, all -> 0x00d5 }
        L_0x00d2:
            r1.mMediaPlay = r12     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            goto L_0x00da
        L_0x00d5:
            r0 = move-exception
            r2 = r0
            r1.mMediaPlay = r12     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            throw r2     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x00da:
            java.util.Timer r13 = r1._watchTimer     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r13 == 0) goto L_0x00e7
            java.util.Timer r13 = r1._watchTimer     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r13.cancel()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1._watchTimer = r12     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1._watchTimertask = r12     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x00e7:
            android.content.Context r13 = r1._context     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r11 = "audio"
            java.lang.Object r11 = r13.getSystemService(r11)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.AudioManager r11 = (android.media.AudioManager) r11     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.MediaPlayer r13 = new android.media.MediaPlayer     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r13.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1.mMediaPlay = r13     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.MediaPlayer r13 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r13 != 0) goto L_0x0105
            android.media.MediaPlayer r2 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.release()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1.mMediaPlay = r12     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2 = 0
            return r2
        L_0x0105:
            android.media.MediaPlayer r13 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r13.setOnCompletionListener(r1)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.MediaPlayer r13 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r13.setOnErrorListener(r1)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r13 = 1
            if (r2 == 0) goto L_0x0180
            if (r2 == r13) goto L_0x015d
            r3 = 2
            if (r2 == r3) goto L_0x013b
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r3 == 0) goto L_0x0132
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r4 = "TraeMediaPlay | err datasource:"
            r3.append(r4)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3.append(r2)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r2 = r3.toString()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3 = 2
            com.tencent.qphone.base.util.QLog.e(r15, r3, r2)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x0132:
            android.media.MediaPlayer r2 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.release()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1.mMediaPlay = r12     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            goto L_0x01e1
        L_0x013b:
            boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 == 0) goto L_0x0156
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r3 = "TraeMediaPlay | FilePath:"
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.append(r5)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3 = 2
            com.tencent.qphone.base.util.QLog.e(r15, r3, r2)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x0156:
            android.media.MediaPlayer r2 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.setDataSource(r5)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            goto L_0x01e1
        L_0x015d:
            boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 == 0) goto L_0x0178
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r3 = "TraeMediaPlay | uri:"
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.append(r4)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3 = 2
            com.tencent.qphone.base.util.QLog.e(r15, r3, r2)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x0178:
            android.media.MediaPlayer r2 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.content.Context r3 = r1._context     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.setDataSource(r3, r4)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            goto L_0x01e1
        L_0x0180:
            boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 == 0) goto L_0x019b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r4 = "TraeMediaPlay | rsid:"
            r2.append(r4)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r4 = 2
            com.tencent.qphone.base.util.QLog.e(r15, r4, r2)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x019b:
            android.content.Context r2 = r1._context     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.content.res.AssetFileDescriptor r2 = r2.openRawResourceFd(r3)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 != 0) goto L_0x01cb
            boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 == 0) goto L_0x01c2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r4 = "TraeMediaPlay | afd == null rsid:"
            r2.append(r4)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3 = 2
            com.tencent.qphone.base.util.QLog.e(r15, r3, r2)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x01c2:
            android.media.MediaPlayer r2 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.release()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1.mMediaPlay = r12     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2 = 0
            return r2
        L_0x01cb:
            android.media.MediaPlayer r3 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.io.FileDescriptor r20 = r2.getFileDescriptor()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            long r21 = r2.getStartOffset()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            long r23 = r2.getLength()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r19 = r3
            r19.setDataSource(r20, r21, r23)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.close()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x01e1:
            android.media.MediaPlayer r2 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 != 0) goto L_0x01e7
            r2 = 0
            return r2
        L_0x01e7:
            r1._ringMode = r8     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            boolean r2 = r1._ringMode     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 == 0) goto L_0x01f2
            r2 = 2
            r1._streamType = r2     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2 = 1
            goto L_0x01fe
        L_0x01f2:
            r2 = 0
            r1._streamType = r2     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3 = 11
            if (r2 < r3) goto L_0x01fd
            r2 = 3
            goto L_0x01fe
        L_0x01fd:
            r2 = 0
        L_0x01fe:
            r1._hasCall = r9     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            boolean r3 = r1._hasCall     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r3 == 0) goto L_0x0206
            r1._streamType = r10     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x0206:
            android.media.MediaPlayer r3 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r4 = r1._streamType     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3.setAudioStreamType(r4)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.MediaPlayer r3 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3.prepare()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.MediaPlayer r3 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3.setLooping(r6)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.MediaPlayer r3 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3.start()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1._loop = r6     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            boolean r3 = r1._loop     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r3 != r13) goto L_0x0228
            r1._loopCount = r13     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3 = -1
            r1._durationMS = r3     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            goto L_0x0236
        L_0x0228:
            r1._loopCount = r7     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r3 = r1._loopCount     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.MediaPlayer r4 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r4 = r4.getDuration()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r3 = r3 * r4
            r1._durationMS = r3     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x0236:
            int r3 = r1._loopCount     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r3 = r3 - r13
            r1._loopCount = r3     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            boolean r3 = r1._hasCall     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r3 != 0) goto L_0x0242
            r11.setMode(r2)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x0242:
            int r2 = r1._durationMS     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 <= 0) goto L_0x0260
            java.util.Timer r2 = new java.util.Timer     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1._watchTimer = r2     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            com.tencent.rtmp.sharp.jni.TraeMediaPlayer$1 r2 = new com.tencent.rtmp.sharp.jni.TraeMediaPlayer$1     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r1._watchTimertask = r2     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.util.Timer r2 = r1._watchTimer     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.util.TimerTask r3 = r1._watchTimertask     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r4 = r1._durationMS     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r4 = r4 + 1000
            long r4 = (long) r4     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.schedule(r3, r4)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x0260:
            boolean r2 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            if (r2 == 0) goto L_0x0287
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r3 = "TraeMediaPlay | DurationMS:"
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            android.media.MediaPlayer r3 = r1.mMediaPlay     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            int r3 = r3.getDuration()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.append(r14)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r2.append(r6)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
            r3 = 2
            com.tencent.qphone.base.util.QLog.e(r15, r3, r2)     // Catch:{ IllegalStateException -> 0x0293, IOException -> 0x028d, IllegalArgumentException -> 0x0288, SecurityException -> 0x029f, Exception -> 0x0299 }
        L_0x0287:
            return r13
        L_0x0288:
            r0 = move-exception
            r2 = r0
            r4 = r18
            goto L_0x02d7
        L_0x028d:
            r0 = move-exception
            r2 = r0
            r4 = r18
            goto L_0x0306
        L_0x0293:
            r0 = move-exception
            r2 = r0
            r4 = r18
            goto L_0x0334
        L_0x0299:
            r0 = move-exception
            r2 = r0
            r4 = r18
            goto L_0x0360
        L_0x029f:
            r0 = move-exception
            r2 = r0
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x02ce }
            if (r3 == 0) goto L_0x0389
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ce }
            r3.<init>()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r4 = "TraeMediaPlay | SecurityException: "
            r3.append(r4)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r4 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x02ce }
            r3.append(r4)     // Catch:{ Exception -> 0x02ce }
            r4 = r18
            r3.append(r4)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x035e }
            r3.append(r2)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x035e }
            r3 = 2
            com.tencent.qphone.base.util.QLog.d(r15, r3, r2)     // Catch:{ Exception -> 0x035e }
            goto L_0x0389
        L_0x02ce:
            r0 = move-exception
            r4 = r18
            goto L_0x035f
        L_0x02d3:
            r0 = move-exception
            r4 = r18
            r2 = r0
        L_0x02d7:
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x035e }
            if (r3 == 0) goto L_0x0389
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x035e }
            r3.<init>()     // Catch:{ Exception -> 0x035e }
            java.lang.String r5 = "TraeMediaPlay | IllegalArgumentException: "
            r3.append(r5)     // Catch:{ Exception -> 0x035e }
            java.lang.String r5 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x035e }
            r3.append(r5)     // Catch:{ Exception -> 0x035e }
            r3.append(r4)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x035e }
            r3.append(r2)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x035e }
            r3 = 2
            com.tencent.qphone.base.util.QLog.d(r15, r3, r2)     // Catch:{ Exception -> 0x035e }
            goto L_0x0389
        L_0x0302:
            r0 = move-exception
            r4 = r18
            r2 = r0
        L_0x0306:
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x035e }
            if (r3 == 0) goto L_0x0389
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x035e }
            r3.<init>()     // Catch:{ Exception -> 0x035e }
            java.lang.String r5 = "TraeMediaPlay | IOException: "
            r3.append(r5)     // Catch:{ Exception -> 0x035e }
            java.lang.String r5 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x035e }
            r3.append(r5)     // Catch:{ Exception -> 0x035e }
            r3.append(r4)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x035e }
            r3.append(r2)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x035e }
            r3 = 2
            com.tencent.qphone.base.util.QLog.d(r15, r3, r2)     // Catch:{ Exception -> 0x035e }
            goto L_0x0389
        L_0x0330:
            r0 = move-exception
            r4 = r18
            r2 = r0
        L_0x0334:
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x035e }
            if (r3 == 0) goto L_0x0389
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x035e }
            r3.<init>()     // Catch:{ Exception -> 0x035e }
            java.lang.String r5 = "TraeMediaPlay | IllegalStateException: "
            r3.append(r5)     // Catch:{ Exception -> 0x035e }
            java.lang.String r5 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x035e }
            r3.append(r5)     // Catch:{ Exception -> 0x035e }
            r3.append(r4)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x035e }
            r3.append(r2)     // Catch:{ Exception -> 0x035e }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x035e }
            r3 = 2
            com.tencent.qphone.base.util.QLog.d(r15, r3, r2)     // Catch:{ Exception -> 0x035e }
            goto L_0x0389
        L_0x035e:
            r0 = move-exception
        L_0x035f:
            r2 = r0
        L_0x0360:
            boolean r3 = com.tencent.qphone.base.util.QLog.isColorLevel()
            if (r3 == 0) goto L_0x0389
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "TraeMediaPlay | Except: "
            r3.append(r5)
            java.lang.String r5 = r2.getLocalizedMessage()
            r3.append(r5)
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r3 = 2
            com.tencent.qphone.base.util.QLog.d(r15, r3, r2)
        L_0x0389:
            android.media.MediaPlayer r2 = r1.mMediaPlay     // Catch:{ Exception -> 0x038e }
            r2.release()     // Catch:{ Exception -> 0x038e }
        L_0x038e:
            r1.mMediaPlay = r12
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.TraeMediaPlayer.playRing(int, int, android.net.Uri, java.lang.String, boolean, int, boolean, boolean, int):boolean");
    }

    public void stopRing() {
        if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "TraeMediaPlay stopRing ");
        }
        MediaPlayer mediaPlayer = this.mMediaPlay;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlay.stop();
            }
            this.mMediaPlay.reset();
            try {
                if (this._watchTimer != null) {
                    this._watchTimer.cancel();
                    this._watchTimer = null;
                    this._watchTimertask = null;
                }
                this.mMediaPlay.release();
            } catch (Exception unused) {
            }
            this.mMediaPlay = null;
            this._durationMS = -1;
        }
    }

    public int getStreamType() {
        return this._streamType;
    }

    public int getDuration() {
        return this._durationMS;
    }

    public boolean hasCall() {
        return this._hasCall;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
        if (!this._loop) {
            try {
                if (this._loopCount <= 0) {
                    volumeUndo();
                    if (this.mMediaPlay.isPlaying()) {
                        this.mMediaPlay.stop();
                    }
                    this.mMediaPlay.reset();
                    this.mMediaPlay.release();
                    this.mMediaPlay = null;
                    if (this.mCallback != null) {
                        this.mCallback.a();
                    }
                } else {
                    this.mMediaPlay.start();
                    this._loopCount--;
                }
            } catch (Exception unused) {
            }
            AudioDeviceInterface.LogTraceExit();
        } else if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "loop play,continue...");
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + i + " arg2:" + i2);
        try {
            this.mMediaPlay.release();
        } catch (Exception unused) {
        }
        this.mMediaPlay = null;
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.a();
        }
        AudioDeviceInterface.LogTraceExit();
        return false;
    }

    private void volumeDo() {
        if (this.mMediaPlay != null && this._ringMode && this._streamType != 2) {
            try {
                AudioManager audioManager = (AudioManager) this._context.getSystemService("audio");
                int streamVolume = audioManager.getStreamVolume(this._streamType);
                int streamMaxVolume = audioManager.getStreamMaxVolume(this._streamType);
                int streamVolume2 = audioManager.getStreamVolume(2);
                int streamMaxVolume2 = audioManager.getStreamMaxVolume(2);
                double d2 = (double) streamVolume2;
                Double.isNaN(d2);
                double d3 = (double) streamMaxVolume2;
                Double.isNaN(d3);
                double d4 = (d2 * 1.0d) / d3;
                double d5 = (double) streamMaxVolume;
                Double.isNaN(d5);
                int i = (int) (d4 * d5);
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "TraeMediaPlay volumeDo currV:" + streamVolume + " maxV:" + streamMaxVolume + " currRV:" + streamVolume2 + " maxRV:" + streamMaxVolume2 + " setV:" + i);
                }
                int i2 = i + 1;
                if (i2 >= streamMaxVolume) {
                    i2 = streamMaxVolume;
                }
                audioManager.setStreamVolume(this._streamType, i2, 0);
                this._prevVolume = streamVolume;
            } catch (Exception unused) {
            }
        }
    }

    private void volumeUndo() {
        if (this.mMediaPlay != null && this._ringMode && this._streamType != 2 && this._prevVolume != -1) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this._prevVolume);
                }
                ((AudioManager) this._context.getSystemService("audio")).setStreamVolume(this._streamType, this._prevVolume, 0);
            } catch (Exception unused) {
            }
        }
    }
}
