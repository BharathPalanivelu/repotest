package com.shopee.app.network.http.a;

import com.shopee.app.network.http.data.reddot.TabRedDotStatusResponse;
import com.shopee.app.network.http.data.reddot.TabReddotStatusRequest;
import f.b;
import f.c.a;
import f.c.i;
import f.c.o;

public interface j {
    @o(a = "/api/v2/content/tab_reddot_status")
    b<TabRedDotStatusResponse> a(@i(a = "X-CSRFToken") String str, @i(a = "Referer") String str2, @a TabReddotStatusRequest tabReddotStatusRequest);
}
