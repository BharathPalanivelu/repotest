package com.shopee.app.network.http.a;

import com.shopee.app.network.http.data.BaseResponse;
import com.shopee.app.network.http.data.datapoint.ReportUserInfoRequest;
import f.b;
import f.c.a;
import f.c.i;
import f.c.o;

public interface c {
    @o(a = "api/v2/user_info/report_user_info")
    b<BaseResponse> a(@i(a = "X-CSRFToken") String str, @i(a = "Referer") String str2, @a ReportUserInfoRequest reportUserInfoRequest);
}
