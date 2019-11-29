package com.shopee.live.livestreaming.ui.audience;

import com.shopee.live.livestreaming.a.g;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.EtoeMessageItem;
import com.shopee.live.livestreaming.data.entity.LiveAdDataEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.ui.audience.view.AudienceBottomView;

public interface interfaceD extends g {
//public interface d extends g {
    int B_();

    void a(int i, long j);

    void a(DanmaKuContentEntity danmaKuContentEntity);

    void a(DanmaKuEntity danmaKuEntity);

    void a(EtoeMessageItem etoeMessageItem);

    void a(LiveAdDataEntity liveAdDataEntity);

    void a(LiveStreamingSessionEntity liveStreamingSessionEntity);

    void a(PollingRoomInfoEntity pollingRoomInfoEntity, SessionProductEntity.ProductItem productItem);

    void a(VoucherEntity voucherEntity, long j, int i);

    void a(boolean z);

    void b(int i, long j);

    void b(LiveStreamingSessionEntity liveStreamingSessionEntity);

    void c();

    void d();

    String g();

    AudienceBottomView h();
}
