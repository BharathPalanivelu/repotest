package com.shopee.live.livestreaming.network.service;

import com.shopee.live.livestreaming.data.entity.AnchorCoinEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingClaimEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingRoomConfigEntity;
import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import f.b;
import f.c.a;
import f.c.f;
import f.c.o;
import f.c.s;
import f.c.t;
import okhttp3.RequestBody;

public interface CheckInCoinService {
    @f(a = "api/v1/session/{sid}/coin/giveout")
    b<ServerResult<AnchorCoinEntity>> getCoinGiveOut(@s(a = "sid") int i);

    @f(a = "api/v1/session/{sid}/coin/user_config")
    b<ServerResult<LiveStreamingRoomConfigEntity>> getUserConfig(@s(a = "sid") int i, @t(a = "uid") int i2);

    @o(a = "api/v1/session/{sid}/coin/can_claim")
    b<ServerResult<NullEntity>> postCoinCanClaim(@s(a = "sid") int i, @a RequestBody requestBody);

    @o(a = "api/v1/session/{sid}/coin/claim")
    b<ServerResult<LiveStreamingClaimEntity>> postCoinClaim(@s(a = "sid") int i, @a RequestBody requestBody);

    @o(a = "api/v1/session/{sid}/coin/lock")
    b<ServerResult<NullEntity>> postCoinLock(@s(a = "sid") int i, @a RequestBody requestBody);

    @o(a = "api/v1/session/{sid}/coin/release")
    b<ServerResult<NullEntity>> postCoinRelease(@s(a = "sid") int i, @a RequestBody requestBody);
}
