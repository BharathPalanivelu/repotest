package com.shopee.app.data.viewmodel.camera;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.web.OpenICCameraMessage1;
import com.shopee.app.web.protocol.OpenICCameraMessage;
import d.d.b.j;

public final class PhotoFrameInfo implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private final float frameRatio;
    private final int horizontalMargin;

    public PhotoFrameInfo() {
        this(BitmapDescriptorFactory.HUE_RED, 0, 3, (g) null);
    }

    public int describeContents() {
        return 0;
    }

    public PhotoFrameInfo(float f2, int i) {
        this.frameRatio = f2;
        this.horizontalMargin = i;
    }

    public final float getFrameRatio() {
        return this.frameRatio;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoFrameInfo(float f2, int i, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0.6f : f2, (i2 & 2) != 0 ? 30 : i);
    }

    public final int getHorizontalMargin() {
        return this.horizontalMargin;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PhotoFrameInfo(Parcel parcel) {
        this(parcel.readFloat(), parcel.readInt());
        j.b(parcel, "parcel");
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.b(parcel, "parcel");
        parcel.writeFloat(this.frameRatio);
        parcel.writeInt(this.horizontalMargin);
    }

    public static final class CREATOR implements Parcelable.Creator<PhotoFrameInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public PhotoFrameInfo createFromParcel(Parcel parcel) {
            j.b(parcel, "parcel");
            return new PhotoFrameInfo(parcel);
        }

        public PhotoFrameInfo[] newArray(int i) {
            return new PhotoFrameInfo[i];
        }
    }

    public static final class Util {
        public static final Util INSTANCE = new Util();

        private Util() {
        }

        public final PhotoFrameInfo from(OpenICCameraMessage openICCameraMessage) {
            j.b(openICCameraMessage, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            if (openICCameraMessage.hasFrame()) {
                return new PhotoFrameInfo(openICCameraMessage.getFrameRatio(), openICCameraMessage.getFrameHorizontalMargin());
            }
            return null;
        }

        public final PhotoFrameInfo from(OpenICCameraMessage1 openICCameraMessage1) {
            j.b(openICCameraMessage1, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return new PhotoFrameInfo(openICCameraMessage1.getCropRatio(), 0);
        }
    }
}
