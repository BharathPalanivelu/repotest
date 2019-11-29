package com.shopee.live.livestreaming.network.task;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.require.ClaimVoucherParams;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import f.b;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ClaimVoucherTask extends AbstractInteractor<Data, Callback> {
    public static final int ERR_RATE_LIMIT = 10020;
    b<ServerResult<NullEntity>> mCall;
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void claimSuccess();

        void onError(int i, String str);
    }

    public ClaimVoucherTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        this.mCall = this.mLiveStreamingService.claimVoucher(data.requestBody);
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mCall);
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    callback.claimSuccess();
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
        b<ServerResult<NullEntity>> bVar = this.mCall;
        if (bVar != null && !bVar.c()) {
            this.mCall.b();
        }
    }

    public static class Data {
        RequestBody requestBody;

        public Data(VoucherEntity voucherEntity) {
            f fVar = new f();
            ClaimVoucherParams claimVoucherParams = new ClaimVoucherParams();
            claimVoucherParams.setSession_id(com.shopee.live.livestreaming.util.f.a().f());
            claimVoucherParams.setPromotion_id(voucherEntity.getPromotion_id());
            claimVoucherParams.setSignature(voucherEntity.getSignature());
            claimVoucherParams.setVoucher_code(voucherEntity.getVoucher_code());
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), fVar.b((Object) claimVoucherParams));
        }
    }
}
