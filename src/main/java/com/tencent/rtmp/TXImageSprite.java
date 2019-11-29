package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.rtmp.a.a;
import com.tencent.rtmp.a.b;
import java.util.List;

public class TXImageSprite implements a {
    private Context mContext;
    private a mImageSprite;

    public TXImageSprite(Context context) {
        this.mContext = context.getApplicationContext();
        TXCDRApi.initCrashReport(context);
    }

    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        if (this.mImageSprite != null) {
            release();
        }
        if (str != null && list != null && list.size() != 0) {
            TXCDRApi.txReportDAU(this.mContext, com.tencent.liteav.basic.datareport.a.bz);
            this.mImageSprite = new b();
            this.mImageSprite.setVTTUrlAndImageUrls(str, list);
        }
    }

    public Bitmap getThumbnail(float f2) {
        a aVar = this.mImageSprite;
        if (aVar != null) {
            return aVar.getThumbnail(f2);
        }
        return null;
    }

    public void release() {
        a aVar = this.mImageSprite;
        if (aVar != null) {
            aVar.release();
            this.mImageSprite = null;
        }
    }
}
