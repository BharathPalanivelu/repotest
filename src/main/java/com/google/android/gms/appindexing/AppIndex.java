package com.google.android.gms.appindexing;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.icing.zzaj;
import com.google.android.gms.internal.icing.zzf;

@Deprecated
@VisibleForTesting
public final class AppIndex {
    public static final Api<Api.ApiOptions.NoOptions> API = zzf.zzg;
    public static final Api<Api.ApiOptions.NoOptions> APP_INDEX_API = zzf.zzg;
    public static final AppIndexApi AppIndexApi = new zzaj();

    private AppIndex() {
    }
}
