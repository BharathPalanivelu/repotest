package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.internal.Objects;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class ImagePerfData {
    public static final int UNSET = -1;
    private final Object mCallerContext;
    private final String mComponentTag;
    private final long mControllerCancelTimeMs;
    private final long mControllerFailureTimeMs;
    private final long mControllerFinalImageSetTimeMs;
    private final String mControllerId;
    private final long mControllerIntermediateImageSetTimeMs;
    private final long mControllerSubmitTimeMs;
    private final ImageInfo mImageInfo;
    private final int mImageOrigin;
    private final ImageRequest mImageRequest;
    private final long mImageRequestEndTimeMs;
    private final long mImageRequestStartTimeMs;
    private final long mInvisibilityEventTimeMs;
    private final boolean mIsPrefetch;
    private final int mOnScreenHeightPx;
    private final int mOnScreenWidthPx;
    private final String mRequestId;
    private final String mUltimateProducerName;
    private final long mVisibilityEventTimeMs;
    private final int mVisibilityState;

    public ImagePerfData(String str, String str2, ImageRequest imageRequest, Object obj, ImageInfo imageInfo, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i, String str3, boolean z, int i2, int i3, int i4, long j8, long j9, String str4) {
        this.mControllerId = str;
        this.mRequestId = str2;
        this.mImageRequest = imageRequest;
        this.mCallerContext = obj;
        this.mImageInfo = imageInfo;
        this.mControllerSubmitTimeMs = j;
        this.mControllerIntermediateImageSetTimeMs = j2;
        this.mControllerFinalImageSetTimeMs = j3;
        this.mControllerFailureTimeMs = j4;
        this.mControllerCancelTimeMs = j5;
        this.mImageRequestStartTimeMs = j6;
        this.mImageRequestEndTimeMs = j7;
        this.mImageOrigin = i;
        this.mUltimateProducerName = str3;
        this.mIsPrefetch = z;
        this.mOnScreenWidthPx = i2;
        this.mOnScreenHeightPx = i3;
        this.mVisibilityState = i4;
        this.mVisibilityEventTimeMs = j8;
        this.mInvisibilityEventTimeMs = j9;
        this.mComponentTag = str4;
    }

    public String getControllerId() {
        return this.mControllerId;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public long getControllerSubmitTimeMs() {
        return this.mControllerSubmitTimeMs;
    }

    public long getControllerIntermediateImageSetTimeMs() {
        return this.mControllerIntermediateImageSetTimeMs;
    }

    public long getControllerFinalImageSetTimeMs() {
        return this.mControllerFinalImageSetTimeMs;
    }

    public long getControllerFailureTimeMs() {
        return this.mControllerFailureTimeMs;
    }

    public long getImageRequestStartTimeMs() {
        return this.mImageRequestStartTimeMs;
    }

    public long getImageRequestEndTimeMs() {
        return this.mImageRequestEndTimeMs;
    }

    public int getImageOrigin() {
        return this.mImageOrigin;
    }

    public String getUltimateProducerName() {
        return this.mUltimateProducerName;
    }

    public boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    public int getOnScreenWidthPx() {
        return this.mOnScreenWidthPx;
    }

    public int getOnScreenHeightPx() {
        return this.mOnScreenHeightPx;
    }

    public long getFinalImageLoadTimeMs() {
        if (getImageRequestEndTimeMs() == -1 || getImageRequestStartTimeMs() == -1) {
            return -1;
        }
        return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
    }

    public long getIntermediateImageLoadTimeMs() {
        if (getControllerIntermediateImageSetTimeMs() == -1 || getControllerSubmitTimeMs() == -1) {
            return -1;
        }
        return getControllerIntermediateImageSetTimeMs() - getControllerSubmitTimeMs();
    }

    public int getVisibilityState() {
        return this.mVisibilityState;
    }

    public long getVisibilityEventTimeMs() {
        return this.mVisibilityEventTimeMs;
    }

    public long getInvisibilityEventTimeMs() {
        return this.mInvisibilityEventTimeMs;
    }

    public String getComponentTag() {
        return this.mComponentTag;
    }

    public String createDebugString() {
        return Objects.toStringHelper((Object) this).add("controller ID", (Object) this.mControllerId).add("request ID", (Object) this.mRequestId).add("controller submit", this.mControllerSubmitTimeMs).add("controller final image", this.mControllerFinalImageSetTimeMs).add("controller failure", this.mControllerFailureTimeMs).add("controller cancel", this.mControllerCancelTimeMs).add("start time", this.mImageRequestStartTimeMs).add("end time", this.mImageRequestEndTimeMs).add(AppMeasurementSdk.ConditionalUserProperty.ORIGIN, (Object) ImageOriginUtils.toString(this.mImageOrigin)).add("ultimateProducerName", (Object) this.mUltimateProducerName).add("prefetch", this.mIsPrefetch).add("caller context", this.mCallerContext).add("image request", (Object) this.mImageRequest).add("image info", (Object) this.mImageInfo).add("on-screen width", this.mOnScreenWidthPx).add("on-screen height", this.mOnScreenHeightPx).add("visibility state", this.mVisibilityState).add("component tag", (Object) this.mComponentTag).toString();
    }
}
