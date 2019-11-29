package com.shopee.app.network.http.a;

import com.shopee.app.network.http.data.kredit.CreditStatusResponse;
import f.c.f;
import io.b.j;

public interface b {
    @f(a = "/api/v2/credit/account/get_user_credit_status")
    j<CreditStatusResponse> a();
}
