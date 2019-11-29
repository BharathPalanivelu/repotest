package com.shopee.live.livestreaming.network.service;

import com.shopee.live.livestreaming.data.entity.CommendBanStatusEntity;
import com.shopee.live.livestreaming.data.entity.FollowStatusEntity;
import com.shopee.live.livestreaming.data.entity.LiveAdDataEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.NotifyLiveEntity;
import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.data.entity.PlayUrlEntity;
import com.shopee.live.livestreaming.data.entity.ReplayRecordEntity;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.VoucherListEntity;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import f.b;
import f.c.a;
import f.c.f;
import f.c.k;
import f.c.o;
import f.c.s;
import f.c.t;
import okhttp3.RequestBody;

public interface LiveStreamingService {
    @k(a = {"Content-Type: application/json"})
    @o(a = "api/v1/session/{session_id}/ban")
    b<ServerResult<NullEntity>> banToComment(@s(a = "session_id") int i, @a RequestBody requestBody);

    @f(a = "api/v1/session/{session_id}/check_ban")
    b<ServerResult<CommendBanStatusEntity>> checkDanmakuBanStatus(@s(a = "session_id") int i);

    @f(a = "api/v1/host/{shop_id}/follow")
    b<ServerResult<FollowStatusEntity>> checkFollowing(@s(a = "shop_id") int i);

    @o(a = "api/v1/voucher/claim")
    b<ServerResult<NullEntity>> claimVoucher(@a RequestBody requestBody);

    @o(a = "api/v1/session/{session_id}/end")
    b<ServerResult<NullEntity>> endLiveStreaming(@s(a = "session_id") int i);

    @f(a = "api/v1/adspot/most_recent")
    b<ServerResult<LiveAdDataEntity>> getAdInfo(@t(a = "room_id") int i, @t(a = "session_id") int i2);

    @f(a = "api/v1/session/{session_id}/play_url")
    b<ServerResult<PlayUrlEntity>> getPlayUrl(@s(a = "session_id") int i);

    @f(a = "api/v1/replay/{record_id}")
    b<ServerResult<ReplayRecordEntity>> getReplayRecord(@s(a = "record_id") int i);

    @f(a = "api/v1/session/{session_id}")
    b<ServerResult<LiveStreamingSessionEntity>> getSessionInfo(@s(a = "session_id") int i);

    @f(a = "api/v1/session/{session_id}/items")
    b<ServerResult<SessionProductEntity>> getSessionProduct(@s(a = "session_id") int i, @t(a = "offset") int i2, @t(a = "limit") int i3);

    @f(a = "api/v1/voucher/list")
    b<ServerResult<VoucherListEntity>> getVoucherListData(@t(a = "include_fsv") boolean z);

    @k(a = {"Content-type:application/json;charset=UTF-8"})
    @o(a = "api/v1/session/{session_id}/live")
    b<ServerResult<NotifyLiveEntity>> notifyLive(@s(a = "session_id") int i, @a RequestBody requestBody);

    @o(a = "api/v1/session/{session_id}/exit")
    b<ServerResult<NullEntity>> postExitLiveRoom(@s(a = "session_id") int i, @a RequestBody requestBody);

    @o(a = "api/v1/host/{shop_id}/follow")
    b<ServerResult<NullEntity>> postFollowing(@s(a = "shop_id") int i);

    @o(a = "api/v1/session/{session_id}/join")
    b<ServerResult<LiveStreamingSessionEntity>> postJoinLiveRoom(@s(a = "session_id") int i, @a RequestBody requestBody);

    @o(a = "api/v1/session/{session_id}/like")
    b<ServerResult<NullEntity>> postLike(@s(a = "session_id") int i, @a RequestBody requestBody);

    @o(a = "api/v1/homepage/replay")
    b<ServerResult<NullEntity>> postReplayCount(@a RequestBody requestBody);

    @o(a = "api/v1/session/{session_id}/report")
    b<ServerResult<NullEntity>> postReport(@s(a = "session_id") int i);

    @o(a = "api/v1/session/{session_id}/message")
    b<ServerResult<NullEntity>> postSendMessage(@s(a = "session_id") int i, @a RequestBody requestBody);

    @o(a = "api/v1/voucher/show")
    b<ServerResult<NullEntity>> showVoucher(@a RequestBody requestBody);

    @k(a = {"Content-Type: application/json", "Accept: application/json"})
    @o(a = "api/v1/session/{session_id}/show")
    b<ServerResult<NullEntity>> upLoadShowProduct(@s(a = "session_id") int i, @a RequestBody requestBody);
}
