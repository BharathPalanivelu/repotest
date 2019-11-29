package com.shopee.live.livestreaming.sztracking.base.net;

import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult2;
import com.tencent.qcloud.core.http.HttpConstants;
import e.f;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SZTrackingReportTask extends AbstractInteractor<Data, Callback> {
    SZTrackingReportService reportService = ((SZTrackingReportService) SZTrackingNetwork.provideRetrofit().a(SZTrackingReportService.class));

    public interface Callback {
        void onReject();

        void onResolve();
    }

    public SZTrackingReportTask(Executor executor) {
        super(executor);
    }

    /* access modifiers changed from: protected */
    public void run(Data data, Callback callback) {
        f access$000 = data.byteString;
        if (access$000 != null) {
            NetworkData<ServerResult2<NullEntity>> r2 = Network.get2(this.reportService.post(RequestBody.create(MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA), access$000)));
            if (callback != null) {
                if (!r2.hasError()) {
                    callback.onResolve();
                } else {
                    callback.onReject();
                }
            }
        }
    }

    public static class Data {
        /* access modifiers changed from: private */
        public f byteString;

        public Data(f fVar) {
            this.byteString = fVar;
        }
    }
}
