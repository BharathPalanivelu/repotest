package com.shopee.app.network.http.a;

import com.shopee.app.network.http.data.FeatureToggleResponse;
import f.c.f;
import f.c.t;
import io.b.j;

public interface e {
    @f(a = "api/v2/get_feature_toggles")
    j<FeatureToggleResponse> a(@t(a = "userid") Integer num);
}
