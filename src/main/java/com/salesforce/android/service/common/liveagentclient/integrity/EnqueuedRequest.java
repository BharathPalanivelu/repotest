package com.salesforce.android.service.common.liveagentclient.integrity;

import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import java.io.IOException;

class EnqueuedRequest<T> {
    private final BasicAsync<T> mCallback;
    private int mCurrentAttempt;
    private final LiveAgentRequest mRequest;
    private final Class<T> mResponseType;

    public EnqueuedRequest(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        this(liveAgentRequest, cls, new BasicAsync(), 1);
    }

    EnqueuedRequest(LiveAgentRequest liveAgentRequest, Class<T> cls, BasicAsync<T> basicAsync, int i) {
        this.mRequest = liveAgentRequest;
        this.mResponseType = cls;
        this.mCallback = basicAsync;
        this.mCurrentAttempt = i;
    }

    public LiveAgentRequest getRequest() {
        return this.mRequest;
    }

    public Class<T> getResponseType() {
        return this.mResponseType;
    }

    public BasicAsync<T> getCallback() {
        return this.mCallback;
    }

    public int getCurrentAttempt() {
        return this.mCurrentAttempt;
    }

    public void retry() {
        this.mCurrentAttempt++;
    }

    public void abort() {
        BasicAsync<T> basicAsync = this.mCallback;
        basicAsync.setError((Throwable) new IOException("Unable to send " + this));
    }

    public String toString() {
        return String.format("%s on attempt #%s", new Object[]{this.mRequest.getClass().getSimpleName(), Integer.valueOf(this.mCurrentAttempt)});
    }

    static class Factory {
        Factory() {
        }

        /* access modifiers changed from: package-private */
        public <T> EnqueuedRequest<T> create(LiveAgentRequest liveAgentRequest, Class<T> cls) {
            return new EnqueuedRequest<>(liveAgentRequest, cls);
        }
    }
}
