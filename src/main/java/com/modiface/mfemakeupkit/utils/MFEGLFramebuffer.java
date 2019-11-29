package com.modiface.mfemakeupkit.utils;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.imsdk.TIMGroupManager;
import java.util.ArrayList;

public class MFEGLFramebuffer {
    protected ArrayList<Throwable> errors;
    protected int framebufferId;
    protected int height;
    protected final String name;
    protected Integer status;
    protected int textureId;
    protected int width;

    static {
        q.a("MFEMakeupKit");
        registerNatives();
    }

    public MFEGLFramebuffer() {
        this((String) null);
    }

    private boolean bindTextureToFramebuffer() {
        if (this.textureId == 0 || this.framebufferId == 0) {
            return true;
        }
        GLES20.glActiveTexture(33985);
        if (checkGLError()) {
            return false;
        }
        GLES20.glBindFramebuffer(36160, this.framebufferId);
        if (checkGLError()) {
            return false;
        }
        GLES20.glBindTexture(3553, this.textureId);
        if (checkGLError()) {
            return false;
        }
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureId, 0);
        if (checkGLError()) {
            return false;
        }
        return true;
    }

    private boolean checkAndSetGLFramebufferStatus() {
        this.status = Integer.valueOf(GLES20.glCheckFramebufferStatus(36160));
        return !checkGLError();
    }

    private boolean checkGLError(int i) {
        Throwable errorForGLCode = MFEGLUtil.getErrorForGLCode(i);
        if (errorForGLCode == null) {
            return false;
        }
        this.errors.add(generateError(errorForGLCode));
        return true;
    }

    private boolean checkNativeError(MFENativeError mFENativeError) {
        Throwable nativeError = mFENativeError.getNativeError();
        if (nativeError == null) {
            return false;
        }
        this.errors.add(generateError(nativeError));
        return true;
    }

    private Throwable generateError(Throwable th) {
        return new Throwable("error on framebuffer \"" + this.name + "\":\n\twidth: " + this.width + "\n\theight: " + this.height + "\n\ttextureId: " + this.textureId + "\n\tframebufferId: " + this.framebufferId + "\n\tstatus: " + this.status, th);
    }

    private boolean generateFramebuffer() {
        this.framebufferId = 0;
        int[] iArr = {0};
        GLES20.glBindFramebuffer(36160, 0);
        if (checkGLError()) {
            return false;
        }
        GLES20.glGenFramebuffers(1, iArr, 0);
        if (checkGLError()) {
            return false;
        }
        this.framebufferId = iArr[0];
        return true;
    }

    private boolean generateTexture() {
        this.textureId = 0;
        int[] iArr = {0};
        GLES20.glActiveTexture(33985);
        if (checkGLError()) {
            return false;
        }
        GLES20.glBindTexture(3553, 0);
        if (checkGLError()) {
            return false;
        }
        GLES20.glGenTextures(1, iArr, 0);
        if (checkGLError()) {
            return false;
        }
        GLES20.glBindTexture(3553, iArr[0]);
        if (checkGLError()) {
            return false;
        }
        GLES20.glTexParameteri(3553, 10241, 9729);
        if (checkGLError()) {
            return false;
        }
        GLES20.glTexParameteri(3553, 10240, 9729);
        if (checkGLError()) {
            return false;
        }
        GLES20.glTexParameteri(3553, 10242, 33071);
        if (checkGLError()) {
            return false;
        }
        GLES20.glTexParameteri(3553, 10243, 33071);
        if (checkGLError()) {
            return false;
        }
        this.textureId = iArr[0];
        return true;
    }

    private boolean generateTextureAndFramebuffer() {
        if (!generateTexture() || !generateFramebuffer()) {
            return false;
        }
        return bindTextureToFramebuffer();
    }

    private native void jniTexImage2DEmpty(int i, int i2, long j);

    private native void jniToBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, long j);

    private native void jniToByteArray(byte[] bArr, int i, int i2, int i3, int i4, long j);

    private static native void registerNatives();

    public void attachTexture(int i, int i2, int i3) {
        int i4 = this.width;
        int i5 = this.height;
        this.width = i2;
        this.height = i3;
        if (this.framebufferId != 0 || generateFramebuffer()) {
            int i6 = this.textureId;
            this.textureId = i;
            if (!bindTextureToFramebuffer()) {
                this.textureId = i6;
                this.width = i4;
                this.height = i5;
                return;
            }
            GLES20.glBindFramebuffer(36160, this.framebufferId);
            if (!checkGLError() && checkAndSetGLFramebufferStatus()) {
                GLES20.glBindFramebuffer(36160, 0);
                if (!checkGLError() && i6 != 0) {
                    GLES20.glDeleteTextures(1, new int[]{i6}, 0);
                    if (checkGLError()) {
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.width = i4;
        this.height = i5;
    }

    public Bitmap captureToBitmap() {
        return captureToBitmap((Bitmap) null);
    }

    public byte[] captureToByteArray() {
        return captureToByteArray((byte[]) null);
    }

    public void close() {
        int i = this.textureId;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            checkGLError();
        }
        int i2 = this.framebufferId;
        if (i2 != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
            checkGLError();
        }
        this.width = 0;
        this.height = 0;
        this.textureId = 0;
        this.framebufferId = 0;
        this.status = null;
    }

    public int detachTexture() {
        int i = this.textureId;
        this.textureId = 0;
        if (!bindTextureToFramebuffer()) {
            this.textureId = i;
            return 0;
        }
        this.status = null;
        this.textureId = 0;
        return i;
    }

    public void generateEmptyWithSize(int i, int i2) {
        if (!isValid() || i != this.width || i2 != this.height) {
            close();
            if (i > 0 && i2 > 0) {
                this.width = i;
                this.height = i2;
                if (generateTextureAndFramebuffer()) {
                    GLES20.glActiveTexture(33985);
                    if (!checkGLError()) {
                        GLES20.glBindFramebuffer(36160, this.framebufferId);
                        if (!checkGLError()) {
                            GLES20.glBindTexture(3553, this.textureId);
                            if (!checkGLError()) {
                                MFENativeError mFENativeError = new MFENativeError();
                                jniTexImage2DEmpty(this.width, this.height, mFENativeError.getNativeState());
                                if (!checkNativeError(mFENativeError) && checkAndSetGLFramebufferStatus()) {
                                    GLES20.glActiveTexture(33985);
                                    if (!checkGLError()) {
                                        GLES20.glBindFramebuffer(36160, 0);
                                        if (!checkGLError()) {
                                            GLES20.glBindTexture(3553, 0);
                                            if (!checkGLError()) {
                                                GLES20.glBindFramebuffer(36160, this.framebufferId);
                                                if (!checkGLError()) {
                                                    GLES20.glClear(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
                                                    if (!checkGLError()) {
                                                        GLES20.glBindFramebuffer(36160, 0);
                                                        if (checkGLError()) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<Throwable> getAndClearErrors() {
        ArrayList<Throwable> arrayList = new ArrayList<>(this.errors);
        this.errors.clear();
        return arrayList;
    }

    public int getFramebufferId() {
        return this.framebufferId;
    }

    public int getHeight() {
        return this.height;
    }

    public Integer getStatus() {
        return this.status;
    }

    public int getTextureId() {
        return this.textureId;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasError() {
        return !this.errors.isEmpty();
    }

    public boolean isValid() {
        if (this.width > 0 && this.height > 0 && this.textureId != 0 && this.framebufferId != 0) {
            Integer num = this.status;
            return num != null && num.intValue() == 36053;
        }
    }

    public void loadBitmap(Bitmap bitmap) {
        if (!isValid() || bitmap == null || bitmap.isRecycled() || bitmap.getWidth() != this.width || bitmap.getHeight() != this.height || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            close();
            if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                this.width = bitmap.getWidth();
                this.height = bitmap.getHeight();
                if (generateTextureAndFramebuffer()) {
                    GLES20.glActiveTexture(33985);
                    if (!checkGLError()) {
                        GLES20.glBindFramebuffer(36160, this.framebufferId);
                        if (!checkGLError()) {
                            GLES20.glBindTexture(3553, this.textureId);
                            if (!checkGLError()) {
                                GLUtils.texImage2D(3553, 0, bitmap, 0);
                                if (!checkGLError() && checkAndSetGLFramebufferStatus()) {
                                    GLES20.glActiveTexture(33985);
                                    if (!checkGLError()) {
                                        GLES20.glBindFramebuffer(36160, 0);
                                        if (!checkGLError()) {
                                            GLES20.glBindTexture(3553, 0);
                                            if (checkGLError()) {
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        GLES20.glBindTexture(3553, this.textureId);
        if (!checkGLError()) {
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            if (checkGLError() || checkAndSetGLFramebufferStatus()) {
            }
        }
    }

    public MFEGLFramebuffer(String str) {
        this.width = 0;
        this.height = 0;
        this.textureId = 0;
        this.framebufferId = 0;
        this.status = null;
        this.errors = new ArrayList<>();
        this.name = str;
    }

    public Bitmap captureToBitmap(Bitmap bitmap) {
        return captureToBitmap(bitmap, 0, 0, this.width, this.height);
    }

    public byte[] captureToByteArray(byte[] bArr) {
        return captureToByteArray(bArr, 0, 0, this.width, this.height);
    }

    private boolean checkGLError() {
        Throwable gLError = MFEGLUtil.getGLError();
        if (gLError == null) {
            return false;
        }
        this.errors.add(generateError(gLError));
        return true;
    }

    public Bitmap captureToBitmap(int i, int i2, int i3, int i4) {
        return captureToBitmap((Bitmap) null, i, i2, i3, i4);
    }

    public byte[] captureToByteArray(int i, int i2, int i3, int i4) {
        return captureToByteArray((byte[]) null, i, i2, i3, i4);
    }

    public Bitmap captureToBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) {
        if (!isValid() || i < 0 || i2 < 0 || i + i3 > this.width || i2 + i4 > this.height) {
            return null;
        }
        if (!(bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() == i3 && bitmap.getHeight() == i4 && bitmap.getConfig() == Bitmap.Config.ARGB_8888)) {
            bitmap = n.a(i3, i4, Bitmap.Config.ARGB_8888);
        }
        MFENativeError mFENativeError = new MFENativeError();
        jniToBitmap(bitmap, i, i2, i3, i4, mFENativeError.getNativeState());
        if (checkNativeError(mFENativeError)) {
            return null;
        }
        return bitmap;
    }

    public byte[] captureToByteArray(byte[] bArr, int i, int i2, int i3, int i4) {
        if (!isValid() || i < 0 || i2 < 0 || i + i3 > this.width || i2 + i4 > this.height) {
            return null;
        }
        if (bArr == null || bArr.length != i3 * i4 * 4) {
            bArr = new byte[(i3 * i4 * 4)];
        }
        MFENativeError mFENativeError = new MFENativeError();
        jniToByteArray(bArr, i, i2, i3, i4, mFENativeError.getNativeState());
        if (checkNativeError(mFENativeError)) {
            return null;
        }
        return bArr;
    }
}
