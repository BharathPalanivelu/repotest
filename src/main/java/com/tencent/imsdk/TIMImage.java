package com.tencent.imsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.QrEventType;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.Collections;

public class TIMImage {
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final String tag = "TIMImage";
    private long height;
    private String identifier = "";
    private long size;
    private TIMImageType type;
    private String url;
    private String uuid;
    private long width;

    public long getHeight() {
        return this.height;
    }

    public void getImage(String str, TIMCallBack tIMCallBack) {
        if (tIMCallBack != null) {
            QualityReportHelper qualityReportHelper = new QualityReportHelper(QrEventType.kEventRecvPic.swigValue());
            QLog.d(tag, 1, "getImage from url: " + this.url);
            IMMsfCoreProxy.get().downloadToFile(Collections.singletonList(this.url), str, tIMCallBack, qualityReportHelper, this.size);
        }
    }

    public long getSize() {
        return this.size;
    }

    public TIMImageType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUuid() {
        int i = di.f30871a[this.type.ordinal()];
        int i2 = 3;
        if (i == 1) {
            i2 = 1;
        } else if (i == 2) {
            i2 = 2;
        } else if (i != 3) {
            i2 = 0;
        }
        return String.format("%x_%s", new Object[]{Integer.valueOf(i2), this.uuid});
    }

    public long getWidth() {
        return this.width;
    }

    /* access modifiers changed from: package-private */
    public void setHeight(long j) {
        this.height = j;
    }

    /* access modifiers changed from: protected */
    public void setIdentifier(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.identifier = str;
        }
    }

    /* access modifiers changed from: package-private */
    public void setSize(long j) {
        this.size = j;
    }

    /* access modifiers changed from: package-private */
    public void setType(TIMImageType tIMImageType) {
        this.type = tIMImageType;
    }

    /* access modifiers changed from: package-private */
    public void setUrl(String str) {
        this.url = str;
    }

    /* access modifiers changed from: package-private */
    public void setUuid(String str) {
        this.uuid = str;
    }

    /* access modifiers changed from: package-private */
    public void setWidth(long j) {
        this.width = j;
    }
}
