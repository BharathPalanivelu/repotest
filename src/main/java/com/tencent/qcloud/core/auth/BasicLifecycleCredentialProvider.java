package com.tencent.qcloud.core.auth;

import android.text.TextUtils;
import com.tencent.qcloud.core.common.QCloudClientException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BasicLifecycleCredentialProvider implements QCloudCredentialProvider {
    private QCloudLifecycleCredentials credentials;
    private ReentrantLock lock = new ReentrantLock();

    /* access modifiers changed from: protected */
    public abstract QCloudLifecycleCredentials fetchNewCredentials() throws QCloudClientException;

    public final QCloudCredentials getCredentials() throws QCloudClientException {
        if (needUpdateSignaturePair()) {
            refresh();
        }
        return this.credentials;
    }

    public final void refresh() throws QCloudClientException {
        try {
            if (this.lock.tryLock(20, TimeUnit.SECONDS)) {
                this.credentials = fetchNewCredentials();
                this.lock.unlock();
                return;
            }
            throw new QCloudClientException("lock timeout, no credential for sign");
        } catch (InterruptedException e2) {
            throw new QCloudClientException("interrupt when try to get credential", e2);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    private boolean needUpdateSignaturePair() {
        QCloudLifecycleCredentials qCloudLifecycleCredentials = this.credentials;
        if (qCloudLifecycleCredentials == null) {
            return true;
        }
        String keyTime = qCloudLifecycleCredentials.getKeyTime();
        if (TextUtils.isEmpty(keyTime)) {
            return true;
        }
        String[] split = keyTime.split(";");
        if (split.length != 2) {
            return true;
        }
        if (System.currentTimeMillis() / 1000 > Long.valueOf(split[1]).longValue() - 60) {
            return true;
        }
        return false;
    }
}
