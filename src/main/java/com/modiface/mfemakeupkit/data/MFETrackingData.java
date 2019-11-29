package com.modiface.mfemakeupkit.data;

import android.graphics.Bitmap;
import com.modiface.mfemakeupkit.utils.MFEFaceRotation;
import com.modiface.mfemakeupkit.utils.MFEImage;
import com.modiface.mfemakeupkit.utils.MFEPoint;
import com.modiface.mfemakeupkit.utils.q;
import java.util.EnumMap;

public class MFETrackingData {
    private static final String TAG = "MFETrackingData";
    private final int mFrameID;
    private boolean mHasFacePoints;
    private final MFEImage mImage;
    private final boolean mIsRestorableToFramebuffer;
    private boolean mIsTrackedAfterReset;
    private long mNativeState;

    public enum PointGroup {
        Undefined(0, 0),
        LeftEye(1, 4),
        RightEye(2, 4),
        Cheek(3, 4),
        Nose(4, 11),
        OuterMouth(5, 10),
        InnerMouth(6, 8),
        LeftBrow(7, 3),
        RightBrow(8, 3),
        Face(9, 9),
        Forehead(10, 3);
        
        public final int internalCode;
        public final int pointsNum;

        private PointGroup(int i, int i2) {
            this.internalCode = i;
            this.pointsNum = i2;
        }
    }

    static {
        q.a("MFEMakeupKit");
        registerNatives();
    }

    public MFETrackingData(MFEImage mFEImage, int i, boolean z) {
        this.mIsTrackedAfterReset = false;
        this.mNativeState = 0;
        this.mImage = mFEImage;
        this.mFrameID = i;
        this.mIsRestorableToFramebuffer = z;
        this.mHasFacePoints = false;
        this.mNativeState = jniInit();
    }

    private boolean isRestorableToFramebuffer() {
        return this.mIsRestorableToFramebuffer;
    }

    private native void jniCopyFrom(long j);

    private native void jniDestroy();

    private native void jniGetFacePointsForGroup(int i, float[] fArr);

    private native void jniGetFaceRotation(float[] fArr);

    private native long jniInit();

    private native boolean jniIsMouthOpen();

    private native void jniSetFacePointsForGroup(int i, float[] fArr);

    private native void jniSetFaceRotation(float[] fArr);

    private native void jniSetIsMouthOpen(boolean z);

    private static native void registerNatives();

    public void close() {
        if (this.mNativeState != 0) {
            jniDestroy();
            this.mNativeState = 0;
        }
    }

    public void copyFacePointsFrom(MFETrackingData mFETrackingData) {
        if (mFETrackingData != null) {
            long nativeState = mFETrackingData.getNativeState();
            if (nativeState != 0) {
                jniCopyFrom(nativeState);
            }
            setHasFacePoints(mFETrackingData.hasFacePoints());
        }
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public EnumMap<PointGroup, MFEPoint[]> getFacePoints() {
        EnumMap<PointGroup, MFEPoint[]> enumMap = new EnumMap<>(PointGroup.class);
        for (PointGroup pointGroup : PointGroup.values()) {
            enumMap.put(pointGroup, getFacePointsForGroup(pointGroup));
        }
        return enumMap;
    }

    public MFEPoint[] getFacePointsForGroup(PointGroup pointGroup) {
        if (pointGroup != null) {
            float[] fArr = new float[(pointGroup.pointsNum * 2)];
            if (hasFacePoints()) {
                jniGetFacePointsForGroup(pointGroup.internalCode, fArr);
            }
            MFEPoint[] mFEPointArr = new MFEPoint[pointGroup.pointsNum];
            for (int i = 0; i < mFEPointArr.length; i++) {
                int i2 = i * 2;
                mFEPointArr[i] = new MFEPoint(fArr[i2], fArr[i2 + 1]);
            }
            return mFEPointArr;
        }
        throw new IllegalArgumentException("PointGroup cannot be null for getting face points");
    }

    public MFEFaceRotation getFaceRotation() {
        float[] fArr = new float[3];
        if (hasFacePoints()) {
            jniGetFaceRotation(fArr);
        }
        return new MFEFaceRotation(fArr[0], fArr[1], fArr[2]);
    }

    public int getFrameID() {
        return this.mFrameID;
    }

    public MFEImage getImage() {
        return this.mImage;
    }

    public Bitmap getImageBitmap() {
        MFEImage mFEImage = this.mImage;
        if (mFEImage == null) {
            return null;
        }
        return mFEImage.bitmap;
    }

    /* access modifiers changed from: protected */
    public long getNativeState() {
        return this.mNativeState;
    }

    public boolean hasFacePoints() {
        return this.mHasFacePoints;
    }

    public boolean isMouthOpen() {
        if (hasFacePoints()) {
            return jniIsMouthOpen();
        }
        return false;
    }

    public void setFacePoints(EnumMap<PointGroup, MFEPoint[]> enumMap) {
        if (enumMap != null) {
            for (PointGroup next : enumMap.keySet()) {
                if (next != null) {
                    MFEPoint[] mFEPointArr = enumMap.get(next);
                    if (mFEPointArr != null && mFEPointArr.length == next.pointsNum) {
                        setFacePointsForGroup(next, mFEPointArr);
                    }
                }
            }
        }
    }

    public void setFacePointsForGroup(PointGroup pointGroup, MFEPoint[] mFEPointArr) {
        if (pointGroup == null) {
            throw new IllegalArgumentException("PointGroup cannot be null for setting face points");
        } else if (mFEPointArr == null || mFEPointArr.length != pointGroup.pointsNum) {
            throw new IllegalArgumentException("points null or does not have the same length as specified in PointGroup.pointsNum for setting face points");
        } else if (hasFacePoints()) {
            float[] fArr = new float[(pointGroup.pointsNum * 2)];
            for (int i = 0; i < mFEPointArr.length; i++) {
                int i2 = i * 2;
                fArr[i2] = mFEPointArr[i].x;
                fArr[i2 + 1] = mFEPointArr[i].y;
            }
            jniSetFacePointsForGroup(pointGroup.internalCode, fArr);
        }
    }

    public void setFaceRotation(MFEFaceRotation mFEFaceRotation) {
        if (hasFacePoints()) {
            jniSetFaceRotation(new float[]{mFEFaceRotation.pitch, mFEFaceRotation.yaw, mFEFaceRotation.roll});
        }
    }

    public void setHasFacePoints(boolean z) {
        this.mHasFacePoints = z;
    }

    public void setIsMouthOpen(boolean z) {
        if (hasFacePoints()) {
            jniSetIsMouthOpen(z);
        }
    }

    public MFETrackingData(MFEImage mFEImage, int i) {
        this(mFEImage, i, false);
    }
}
