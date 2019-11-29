package com.google.android.gms.search;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.icing.zzap;
import com.google.android.gms.internal.icing.zzas;

public class SearchAuth {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("SearchAuth.API", zzbm, CLIENT_KEY);
    private static final Api.ClientKey<zzap> CLIENT_KEY = new Api.ClientKey<>();
    public static final SearchAuthApi SearchAuthApi = new zzas();
    private static final Api.AbstractClientBuilder<zzap, Api.ApiOptions.NoOptions> zzbm = new zzb();

    public static class StatusCodes {
        public static final int AUTH_DISABLED = 10000;
        public static final int AUTH_THROTTLED = 10001;
        public static final int DEVELOPER_ERROR = 10;
        public static final int INTERNAL_ERROR = 8;
        public static final int SUCCESS = 0;
    }

    private SearchAuth() {
    }
}
