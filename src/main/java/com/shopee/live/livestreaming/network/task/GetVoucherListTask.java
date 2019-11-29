package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.VoucherListEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import f.b;

public class GetVoucherListTask extends AbstractInteractor<Data, Callback> {
    b<ServerResult<VoucherListEntity>> mCall;
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void onError(int i, String str);

        void returnVoucherList(VoucherListEntity voucherListEntity);
    }

    public static class Data {
    }

    public GetVoucherListTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        this.mCall = this.mLiveStreamingService.getVoucherListData(true);
        final NetworkData<ServerResult<VoucherListEntity>> networkData = Network.get(this.mCall);
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    callback.returnVoucherList((VoucherListEntity) networkData.data);
                }
            });
        } else {
            notify(new Runnable() {
                public void run() {
                    callback.onError(networkData.err_code, networkData.err_msg);
                }
            });
        }
    }

    public void shutTask() {
        b<ServerResult<VoucherListEntity>> bVar = this.mCall;
        if (bVar != null && !bVar.c()) {
            this.mCall.b();
        }
    }
}
