package com.shopee.live.livestreaming.sztracking.base.net;

import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.network.executor.ServerResult2;
import f.b;
import f.c.a;
import f.c.o;
import okhttp3.RequestBody;

public interface SZTrackingReportService {
    @o(a = "dataapi/dataweb/event/reportPB")
    b<ServerResult2<NullEntity>> post(@a RequestBody requestBody);
}
