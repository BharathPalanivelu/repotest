package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;

public class MediaCodecDecoder {
    private static final String TAG = "MediaCodecDecoder";
    private MediaCodec.BufferInfo mAACDecBufferInfo = null;
    private MediaCodec mAudioAACDecoder = null;
    private int mChannels = 2;
    private ByteBuffer mDecInBuffer = ByteBuffer.allocateDirect(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
    private ByteBuffer mDecOutBuffer = ByteBuffer.allocateDirect(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
    ByteBuffer mInputBuffer = null;
    ByteBuffer mOutputBuffer = null;
    private int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
    private byte[] mTempBufDec = new byte[TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE];

    @SuppressLint({"NewApi"})
    public int createAACDecoder(int i, int i2) {
        try {
            this.mAudioAACDecoder = MediaCodec.createDecoderByType("audio/mp4a-latm");
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
            createAudioFormat.setInteger("sample-rate", i);
            createAudioFormat.setInteger("channel-count", i2);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{17, -112}));
            this.mAudioAACDecoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
            if (this.mAudioAACDecoder != null) {
                this.mAudioAACDecoder.start();
                this.mAACDecBufferInfo = new MediaCodec.BufferInfo();
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "createAACDecoder succeed!!! : (" + i + ", " + i2 + SQLBuilder.PARENTHESES_RIGHT);
                }
            }
            return 0;
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "Error when creating aac decode stream");
            }
            e2.printStackTrace();
            return -1;
        }
    }

    public int decodeAACFrame(int i) {
        this.mDecInBuffer.get(this.mTempBufDec, 0, i);
        int decodeInternalAACFrame = decodeInternalAACFrame(i);
        this.mDecOutBuffer.rewind();
        if (decodeInternalAACFrame <= 0) {
            return 0;
        }
        this.mDecOutBuffer.put(this.mTempBufDec, 0, decodeInternalAACFrame);
        return decodeInternalAACFrame;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:12|(1:14)(1:15)|16|17|18|20|21|(2:23|31)(1:30)|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007d, code lost:
        return r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x007e */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084 A[Catch:{ Exception -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0000 A[SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int decodeInternalAACFrame(int r12) {
        /*
            r11 = this;
        L_0x0000:
            r0 = 0
            android.media.MediaCodec r1 = r11.mAudioAACDecoder     // Catch:{ Exception -> 0x008e }
            r2 = 200(0xc8, double:9.9E-322)
            int r5 = r1.dequeueInputBuffer(r2)     // Catch:{ Exception -> 0x008e }
            r1 = 21
            if (r5 < 0) goto L_0x003f
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x008e }
            if (r2 < r1) goto L_0x001a
            android.media.MediaCodec r2 = r11.mAudioAACDecoder     // Catch:{ Exception -> 0x008e }
            java.nio.ByteBuffer r2 = r2.getInputBuffer(r5)     // Catch:{ Exception -> 0x008e }
            r11.mInputBuffer = r2     // Catch:{ Exception -> 0x008e }
            goto L_0x0024
        L_0x001a:
            android.media.MediaCodec r2 = r11.mAudioAACDecoder     // Catch:{ Exception -> 0x008e }
            java.nio.ByteBuffer[] r2 = r2.getInputBuffers()     // Catch:{ Exception -> 0x008e }
            r2 = r2[r5]     // Catch:{ Exception -> 0x008e }
            r11.mInputBuffer = r2     // Catch:{ Exception -> 0x008e }
        L_0x0024:
            java.nio.ByteBuffer r2 = r11.mInputBuffer     // Catch:{ Exception -> 0x008e }
            r2.clear()     // Catch:{ Exception -> 0x008e }
            java.nio.ByteBuffer r2 = r11.mInputBuffer     // Catch:{ Exception -> 0x008e }
            byte[] r3 = r11.mTempBufDec     // Catch:{ Exception -> 0x008e }
            r2.put(r3, r0, r12)     // Catch:{ Exception -> 0x008e }
            java.nio.ByteBuffer r2 = r11.mDecInBuffer     // Catch:{ Exception -> 0x008e }
            r2.rewind()     // Catch:{ Exception -> 0x008e }
            android.media.MediaCodec r4 = r11.mAudioAACDecoder     // Catch:{ Exception -> 0x008e }
            r6 = 0
            r8 = 0
            r10 = 0
            r7 = r12
            r4.queueInputBuffer(r5, r6, r7, r8, r10)     // Catch:{ Exception -> 0x008e }
        L_0x003f:
            android.media.MediaCodec r2 = r11.mAudioAACDecoder     // Catch:{ Exception -> 0x008e }
            android.media.MediaCodec$BufferInfo r3 = r11.mAACDecBufferInfo     // Catch:{ Exception -> 0x008e }
            r4 = 10000(0x2710, double:4.9407E-320)
            int r2 = r2.dequeueOutputBuffer(r3, r4)     // Catch:{ Exception -> 0x008e }
            if (r2 >= 0) goto L_0x004c
            return r0
        L_0x004c:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x008e }
            if (r3 < r1) goto L_0x0059
            android.media.MediaCodec r1 = r11.mAudioAACDecoder     // Catch:{ Exception -> 0x008e }
            java.nio.ByteBuffer r1 = r1.getOutputBuffer(r2)     // Catch:{ Exception -> 0x008e }
            r11.mOutputBuffer = r1     // Catch:{ Exception -> 0x008e }
            goto L_0x0063
        L_0x0059:
            android.media.MediaCodec r1 = r11.mAudioAACDecoder     // Catch:{ Exception -> 0x008e }
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()     // Catch:{ Exception -> 0x008e }
            r1 = r1[r2]     // Catch:{ Exception -> 0x008e }
            r11.mOutputBuffer = r1     // Catch:{ Exception -> 0x008e }
        L_0x0063:
            android.media.MediaCodec$BufferInfo r1 = r11.mAACDecBufferInfo     // Catch:{ Exception -> 0x008e }
            int r1 = r1.size     // Catch:{ Exception -> 0x008e }
            java.nio.ByteBuffer r3 = r11.mOutputBuffer     // Catch:{ Exception -> 0x007e }
            r3.limit(r1)     // Catch:{ Exception -> 0x007e }
            java.nio.ByteBuffer r3 = r11.mOutputBuffer     // Catch:{ Exception -> 0x007e }
            byte[] r4 = r11.mTempBufDec     // Catch:{ Exception -> 0x007e }
            r3.get(r4, r0, r1)     // Catch:{ Exception -> 0x007e }
            java.nio.ByteBuffer r3 = r11.mOutputBuffer     // Catch:{ Exception -> 0x007e }
            r3.position(r0)     // Catch:{ Exception -> 0x007e }
            android.media.MediaCodec r3 = r11.mAudioAACDecoder     // Catch:{ Exception -> 0x007e }
            r3.releaseOutputBuffer(r2, r0)     // Catch:{ Exception -> 0x007e }
            return r1
        L_0x007e:
            boolean r1 = com.tencent.qphone.base.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x008e }
            if (r1 == 0) goto L_0x0000
            java.lang.String r1 = "TRAE"
            r2 = 2
            java.lang.String r3 = "Error when decoding aac stream"
            com.tencent.qphone.base.util.QLog.e(r1, r2, r3)     // Catch:{ Exception -> 0x008e }
            goto L_0x0000
        L_0x008e:
            r12 = move-exception
            r12.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.sharp.jni.MediaCodecDecoder.decodeInternalAACFrame(int):int");
    }

    @SuppressLint({"NewApi"})
    public int releaseAACDecoder() {
        try {
            if (this.mAudioAACDecoder != null) {
                this.mAudioAACDecoder.stop();
                this.mAudioAACDecoder.release();
                this.mAudioAACDecoder = null;
                if (!QLog.isColorLevel()) {
                    return 0;
                }
                QLog.w(TAG, 2, "releaseAACDecoder, release aac decode stream succeed!!");
                return 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
            return -1;
        }
        QLog.e("TRAE", 2, "releaseAACDecoder, Error when releasing aac decode stream");
        return -1;
    }
}
