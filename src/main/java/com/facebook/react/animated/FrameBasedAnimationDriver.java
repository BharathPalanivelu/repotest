package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.path.android.jobqueue.JobManager;

class FrameBasedAnimationDriver extends AnimationDriver {
    private static final double FRAME_TIME_MILLIS = 16.666666666666668d;
    private int mCurrentLoop;
    private double[] mFrames;
    private double mFromValue;
    private int mIterations;
    private long mStartFrameTimeNanos;
    private double mToValue;

    FrameBasedAnimationDriver(ReadableMap readableMap) {
        resetConfig(readableMap);
    }

    public void resetConfig(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray("frames");
        int size = array.size();
        double[] dArr = this.mFrames;
        if (dArr == null || dArr.length != size) {
            this.mFrames = new double[size];
        }
        boolean z = false;
        for (int i = 0; i < size; i++) {
            this.mFrames[i] = array.getDouble(i);
        }
        double d2 = 0.0d;
        if (readableMap.hasKey("toValue")) {
            if (readableMap.getType("toValue") == ReadableType.Number) {
                d2 = readableMap.getDouble("toValue");
            }
            this.mToValue = d2;
        } else {
            this.mToValue = 0.0d;
        }
        if (readableMap.hasKey("iterations")) {
            this.mIterations = readableMap.getType("iterations") == ReadableType.Number ? readableMap.getInt("iterations") : 1;
        } else {
            this.mIterations = 1;
        }
        this.mCurrentLoop = 1;
        if (this.mIterations == 0) {
            z = true;
        }
        this.mHasFinished = z;
        this.mStartFrameTimeNanos = -1;
    }

    public void runAnimationStep(long j) {
        double d2;
        if (this.mStartFrameTimeNanos < 0) {
            this.mStartFrameTimeNanos = j;
            if (this.mCurrentLoop == 1) {
                this.mFromValue = this.mAnimatedValue.mValue;
            }
        }
        double d3 = (double) ((j - this.mStartFrameTimeNanos) / JobManager.NS_PER_MS);
        Double.isNaN(d3);
        int round = (int) Math.round(d3 / FRAME_TIME_MILLIS);
        if (round < 0) {
            throw new IllegalStateException("Calculated frame index should never be lower than 0");
        } else if (!this.mHasFinished) {
            double[] dArr = this.mFrames;
            if (round >= dArr.length - 1) {
                d2 = this.mToValue;
                int i = this.mIterations;
                if (i == -1 || this.mCurrentLoop < i) {
                    this.mStartFrameTimeNanos = -1;
                    this.mCurrentLoop++;
                } else {
                    this.mHasFinished = true;
                }
            } else {
                double d4 = this.mFromValue;
                d2 = d4 + (dArr[round] * (this.mToValue - d4));
            }
            this.mAnimatedValue.mValue = d2;
        }
    }
}
