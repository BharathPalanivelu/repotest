package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Environment;
import android.view.Surface;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaCodecEncoder {
    private static final String TAG = "MediaCodecEncoder";
    private static boolean mDumpEnable = false;
    private MediaCodec.BufferInfo mAACEncBufferInfo = null;
    private MediaCodec mAudioAACEncoder = null;
    private MediaFormat mAudioFormat = null;
    private int mBitrate = TXRecordCommon.AUDIO_SAMPLERATE_32000;
    private int mChannels = 1;
    private ByteBuffer mEncInBuffer = ByteBuffer.allocateDirect(7680);
    private ByteBuffer mEncOutBuffer = ByteBuffer.allocateDirect((((this.nMaxBitRate * 2) / 8) / 50) + 100);
    private boolean mFormatChangeFlag = false;
    private ByteBuffer mInputBuffer = null;
    private ByteBuffer[] mMediaInputBuffers;
    private ByteBuffer[] mMediaOutputBuffers;
    private ByteBuffer mOutputBuffer = null;
    private File mRecFileDump = null;
    private FileOutputStream mRecFileOut = null;
    private int mSampleRate = 48000;
    private byte[] mTempBufEncIn = new byte[7680];
    private byte[] mTempBufEncOut = new byte[((((this.nMaxBitRate * 2) / 8) / 50) + 100)];
    private int nMaxBitRate = 256000;

    private String getDumpFilePath(String str) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
        }
        String str2 = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-" + str;
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump:" + str2);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump replace:" + str2.replace(SQLBuilder.BLANK, "_"));
        }
        return str2.replace(SQLBuilder.BLANK, "_");
    }

    private void addADTStoPacket(byte[] bArr, int i) {
        int i2;
        int i3 = this.mSampleRate;
        if (i3 != 48000) {
            if (i3 == 44100) {
                i2 = 4;
            } else if (i3 == 32000) {
                i2 = 5;
            } else if (i3 == 24000) {
                i2 = 6;
            } else if (i3 == 16000) {
                i2 = 8;
            }
            int i4 = this.mChannels;
            bArr[0] = -1;
            bArr[1] = -7;
            bArr[2] = (byte) (64 + (i2 << 2) + (i4 >> 2));
            bArr[3] = (byte) (((i4 & 3) << 6) + (i >> 11));
            bArr[4] = (byte) ((i & 2047) >> 3);
            bArr[5] = (byte) (((i & 7) << 5) + 31);
            bArr[6] = -4;
        }
        i2 = 3;
        int i42 = this.mChannels;
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) (64 + (i2 << 2) + (i42 >> 2));
        bArr[3] = (byte) (((i42 & 3) << 6) + (i >> 11));
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    @SuppressLint({"NewApi"})
    public int createAACEncoder(int i, int i2, int i3) {
        try {
            this.mAudioAACEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.mAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
            this.mAudioFormat.setInteger("aac-profile", 2);
            this.mAudioFormat.setInteger("sample-rate", i);
            this.mAudioFormat.setInteger("channel-count", i2);
            this.mAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i3);
            this.mAudioAACEncoder.configure(this.mAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            if (this.mAudioAACEncoder != null) {
                this.mAudioAACEncoder.start();
                this.mAACEncBufferInfo = new MediaCodec.BufferInfo();
                this.mSampleRate = i;
                this.mChannels = i2;
                this.mBitrate = i3;
            }
            if (mDumpEnable) {
                this.mRecFileDump = new File(getDumpFilePath("jnirecord.aac"));
                try {
                    this.mRecFileOut = new FileOutputStream(this.mRecFileDump);
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.w(TAG, 2, "createAACEncoder succeed!!! : (" + i + ", " + i2 + ", " + i3 + SQLBuilder.PARENTHESES_RIGHT);
            return 0;
        } catch (Exception e3) {
            e3.printStackTrace();
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e(TAG, 2, "[ERROR] creating aac encode stream failed!!! : (" + i + ", " + i2 + ", " + i3 + SQLBuilder.PARENTHESES_RIGHT);
            return -1;
        }
    }

    @SuppressLint({"NewApi"})
    public int encodeAACFrame(int i) {
        if (this.mFormatChangeFlag) {
            this.mFormatChangeFlag = false;
            this.mAudioAACEncoder.stop();
            this.mAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.mBitrate);
            this.mAudioAACEncoder.configure(this.mAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mAudioAACEncoder.start();
        }
        this.mEncInBuffer.get(this.mTempBufEncIn, 0, i);
        int encodeInternalAACFrame = encodeInternalAACFrame(i);
        this.mEncOutBuffer.rewind();
        if (encodeInternalAACFrame <= 0) {
            return 0;
        }
        this.mEncOutBuffer.put(this.mTempBufEncOut, 0, encodeInternalAACFrame);
        if (!mDumpEnable || this.mRecFileOut == null) {
            return encodeInternalAACFrame;
        }
        int i2 = encodeInternalAACFrame + 7;
        try {
            byte[] bArr = new byte[i2];
            addADTStoPacket(bArr, i2);
            System.arraycopy(this.mTempBufEncOut, 0, bArr, 7, encodeInternalAACFrame);
            this.mRecFileOut.write(bArr, 0, i2);
            return encodeInternalAACFrame;
        } catch (IOException e2) {
            e2.printStackTrace();
            return encodeInternalAACFrame;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|24|(1:26)|27|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a7, code lost:
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a9, code lost:
        com.tencent.qphone.base.util.QLog.e(TAG, 2, "[ERROR] encoding aac stream failed!!!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00a3 */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int encodeInternalAACFrame(int r12) {
        /*
            r11 = this;
            r0 = 0
            android.media.MediaCodec r1 = r11.mAudioAACEncoder     // Catch:{ Exception -> 0x00b2 }
            r2 = 2000(0x7d0, double:9.88E-321)
            int r5 = r1.dequeueInputBuffer(r2)     // Catch:{ Exception -> 0x00b2 }
            r1 = -1
            r2 = 21
            if (r5 == r1) goto L_0x0044
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00b2 }
            if (r1 < r2) goto L_0x001b
            android.media.MediaCodec r1 = r11.mAudioAACEncoder     // Catch:{ Exception -> 0x00b2 }
            java.nio.ByteBuffer r1 = r1.getInputBuffer(r5)     // Catch:{ Exception -> 0x00b2 }
            r11.mInputBuffer = r1     // Catch:{ Exception -> 0x00b2 }
            goto L_0x0029
        L_0x001b:
            android.media.MediaCodec r1 = r11.mAudioAACEncoder     // Catch:{ Exception -> 0x00b2 }
            java.nio.ByteBuffer[] r1 = r1.getInputBuffers()     // Catch:{ Exception -> 0x00b2 }
            r11.mMediaInputBuffers = r1     // Catch:{ Exception -> 0x00b2 }
            java.nio.ByteBuffer[] r1 = r11.mMediaInputBuffers     // Catch:{ Exception -> 0x00b2 }
            r1 = r1[r5]     // Catch:{ Exception -> 0x00b2 }
            r11.mInputBuffer = r1     // Catch:{ Exception -> 0x00b2 }
        L_0x0029:
            java.nio.ByteBuffer r1 = r11.mInputBuffer     // Catch:{ Exception -> 0x00b2 }
            r1.clear()     // Catch:{ Exception -> 0x00b2 }
            java.nio.ByteBuffer r1 = r11.mInputBuffer     // Catch:{ Exception -> 0x00b2 }
            byte[] r3 = r11.mTempBufEncIn     // Catch:{ Exception -> 0x00b2 }
            r1.put(r3, r0, r12)     // Catch:{ Exception -> 0x00b2 }
            android.media.MediaCodec r4 = r11.mAudioAACEncoder     // Catch:{ Exception -> 0x00b2 }
            r6 = 0
            r8 = 0
            r10 = 0
            r7 = r12
            r4.queueInputBuffer(r5, r6, r7, r8, r10)     // Catch:{ Exception -> 0x00b2 }
            java.nio.ByteBuffer r12 = r11.mEncInBuffer     // Catch:{ Exception -> 0x00b2 }
            r12.rewind()     // Catch:{ Exception -> 0x00b2 }
        L_0x0044:
            android.media.MediaCodec r12 = r11.mAudioAACEncoder     // Catch:{ Exception -> 0x00b2 }
            android.media.MediaCodec$BufferInfo r1 = r11.mAACEncBufferInfo     // Catch:{ Exception -> 0x00b2 }
            r3 = 0
            int r12 = r12.dequeueOutputBuffer(r1, r3)     // Catch:{ Exception -> 0x00b2 }
            if (r12 >= 0) goto L_0x0051
            return r0
        L_0x0051:
            android.media.MediaCodec$BufferInfo r1 = r11.mAACEncBufferInfo     // Catch:{ Exception -> 0x00b2 }
            int r1 = r1.size     // Catch:{ Exception -> 0x00b2 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00b2 }
            if (r3 < r2) goto L_0x0062
            android.media.MediaCodec r2 = r11.mAudioAACEncoder     // Catch:{ Exception -> 0x00b2 }
            java.nio.ByteBuffer r2 = r2.getOutputBuffer(r12)     // Catch:{ Exception -> 0x00b2 }
            r11.mOutputBuffer = r2     // Catch:{ Exception -> 0x00b2 }
            goto L_0x0070
        L_0x0062:
            android.media.MediaCodec r2 = r11.mAudioAACEncoder     // Catch:{ Exception -> 0x00b2 }
            java.nio.ByteBuffer[] r2 = r2.getOutputBuffers()     // Catch:{ Exception -> 0x00b2 }
            r11.mMediaOutputBuffers = r2     // Catch:{ Exception -> 0x00b2 }
            java.nio.ByteBuffer[] r2 = r11.mMediaOutputBuffers     // Catch:{ Exception -> 0x00b2 }
            r2 = r2[r12]     // Catch:{ Exception -> 0x00b2 }
            r11.mOutputBuffer = r2     // Catch:{ Exception -> 0x00b2 }
        L_0x0070:
            android.media.MediaCodec$BufferInfo r2 = r11.mAACEncBufferInfo     // Catch:{ Exception -> 0x00b2 }
            int r2 = r2.flags     // Catch:{ Exception -> 0x00b2 }
            r3 = 2
            r2 = r2 & r3
            if (r2 != r3) goto L_0x007a
            r2 = 0
            goto L_0x007e
        L_0x007a:
            android.media.MediaCodec$BufferInfo r2 = r11.mAACEncBufferInfo     // Catch:{ Exception -> 0x00b2 }
            int r2 = r2.size     // Catch:{ Exception -> 0x00b2 }
        L_0x007e:
            java.nio.ByteBuffer r4 = r11.mOutputBuffer     // Catch:{ Exception -> 0x00a3 }
            android.media.MediaCodec$BufferInfo r5 = r11.mAACEncBufferInfo     // Catch:{ Exception -> 0x00a3 }
            int r5 = r5.offset     // Catch:{ Exception -> 0x00a3 }
            r4.position(r5)     // Catch:{ Exception -> 0x00a3 }
            java.nio.ByteBuffer r4 = r11.mOutputBuffer     // Catch:{ Exception -> 0x00a3 }
            android.media.MediaCodec$BufferInfo r5 = r11.mAACEncBufferInfo     // Catch:{ Exception -> 0x00a3 }
            int r5 = r5.offset     // Catch:{ Exception -> 0x00a3 }
            int r5 = r5 + r1
            r4.limit(r5)     // Catch:{ Exception -> 0x00a3 }
            java.nio.ByteBuffer r1 = r11.mOutputBuffer     // Catch:{ Exception -> 0x00a3 }
            byte[] r4 = r11.mTempBufEncOut     // Catch:{ Exception -> 0x00a3 }
            r1.get(r4, r0, r2)     // Catch:{ Exception -> 0x00a3 }
            java.nio.ByteBuffer r1 = r11.mOutputBuffer     // Catch:{ Exception -> 0x00a3 }
            r1.position(r0)     // Catch:{ Exception -> 0x00a3 }
            android.media.MediaCodec r1 = r11.mAudioAACEncoder     // Catch:{ Exception -> 0x00a3 }
            r1.releaseOutputBuffer(r12, r0)     // Catch:{ Exception -> 0x00a3 }
            return r2
        L_0x00a3:
            boolean r12 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x00b2 }
            if (r12 == 0) goto L_0x00b0
            java.lang.String r12 = "MediaCodecEncoder"
            java.lang.String r1 = "[ERROR] encoding aac stream failed!!!"
            com.tencent.qphone.base.util.QLog.e(r12, r3, r1)     // Catch:{ Exception -> 0x00b2 }
        L_0x00b0:
            r0 = r2
            goto L_0x00b6
        L_0x00b2:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.MediaCodecEncoder.encodeInternalAACFrame(int):int");
    }

    @SuppressLint({"NewApi"})
    public int releaseAACEncoder() {
        try {
            if (this.mAudioAACEncoder != null) {
                this.mAudioAACEncoder.stop();
                this.mAudioAACEncoder.release();
                this.mAudioAACEncoder = null;
                if (!QLog.isColorLevel()) {
                    return 0;
                }
                QLog.w(TAG, 2, "releaseAACEncoder, release aac encode stream succeed!!");
                return 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
            return -1;
        }
        QLog.e(TAG, 2, "[ERROR] releaseAACEncoder, release aac encode stream failed!!!");
        return -1;
    }

    @SuppressLint({"NewApi"})
    public int setAACEncodeBitrate(int i) {
        if (this.mAudioAACEncoder == null || this.mBitrate == i) {
            return 0;
        }
        this.mFormatChangeFlag = true;
        this.mBitrate = i;
        if (!QLog.isColorLevel()) {
            return 0;
        }
        QLog.w(TAG, 2, "Set AAC bitrate = " + i);
        return 0;
    }
}
