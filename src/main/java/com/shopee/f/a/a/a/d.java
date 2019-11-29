package com.shopee.f.a.a.a;

import com.tencent.qcloud.core.auth.BasicLifecycleCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudLifecycleCredentials;
import com.tencent.qcloud.core.auth.SessionQCloudCredentials;
import com.tencent.qcloud.core.common.QCloudClientException;

public class d extends BasicLifecycleCredentialProvider {

    /* renamed from: a  reason: collision with root package name */
    private String f27200a;

    /* renamed from: b  reason: collision with root package name */
    private String f27201b;

    /* renamed from: c  reason: collision with root package name */
    private String f27202c;

    /* renamed from: d  reason: collision with root package name */
    private long f27203d;

    /* renamed from: e  reason: collision with root package name */
    private long f27204e;

    public d(String str, String str2, String str3, long j, long j2) {
        this.f27200a = str;
        this.f27201b = str2;
        this.f27202c = str3;
        this.f27204e = j;
        this.f27203d = j2;
    }

    /* access modifiers changed from: protected */
    public QCloudLifecycleCredentials fetchNewCredentials() throws QCloudClientException {
        return new SessionQCloudCredentials(this.f27200a, this.f27201b, this.f27202c, this.f27204e, this.f27203d);
    }
}
