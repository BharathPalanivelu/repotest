package com.salesforce.android.service.common.liveagentclient.integrity;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.R;
import com.salesforce.android.service.common.liveagentclient.integrity.EnqueuedRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.BackoffTimer;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Collections;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class LiveAgentQueue implements HandlerManager.OnTimerElapsedListener {
    protected static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentQueue.class);
    private final EnqueuedRequest.Factory mEnqueuedRequestFactory;
    private AtomicBoolean mIsCurrentlySending = new AtomicBoolean();
    protected Set<RequestFailedListener> mRequestFailedListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private LiveAgentQueueRequestListener mRequestListener;
    protected Queue<EnqueuedRequest> mRequestQueue = new LinkedBlockingQueue();
    private final HandlerManager mTimer;

    public interface RequestFailedListener {
        void onRequestFailed(LiveAgentRequest liveAgentRequest, int i);
    }

    LiveAgentQueue(Builder builder) {
        this.mTimer = builder.mHandlerManagerBuilder.onTimerElapsedListener(this).build();
        this.mEnqueuedRequestFactory = builder.mEnqueuedRequestFactory;
        this.mRequestListener = builder.mLiveAgentQueueRequestListener;
    }

    public void setQueueRequestListener(LiveAgentQueueRequestListener liveAgentQueueRequestListener) {
        this.mRequestListener = liveAgentQueueRequestListener;
        attemptToSend();
    }

    public LiveAgentQueue addRequestFailedListener(RequestFailedListener requestFailedListener) {
        this.mRequestFailedListeners.add(requestFailedListener);
        return this;
    }

    public LiveAgentQueue removeRequestStatusListener(RequestFailedListener requestFailedListener) {
        this.mRequestFailedListeners.remove(requestFailedListener);
        return this;
    }

    public void teardown() {
        log.info("Clearing LiveAgentQueue and cancelling {} queued requests.", Integer.valueOf(this.mRequestQueue.size()));
        this.mRequestFailedListeners.clear();
        this.mTimer.cancel();
        for (EnqueuedRequest abort : this.mRequestQueue) {
            abort.abort();
        }
        this.mRequestQueue.clear();
    }

    public <T> Async<T> add(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        log.debug("Queuing: {}", liveAgentRequest.getClass().getSimpleName());
        EnqueuedRequest<T> create = this.mEnqueuedRequestFactory.create(liveAgentRequest, cls);
        this.mRequestQueue.add(create);
        attemptToSend();
        return create.getCallback();
    }

    public boolean isCurrentlySending() {
        return this.mIsCurrentlySending.get();
    }

    /* access modifiers changed from: package-private */
    public void attemptToSend() {
        if (this.mRequestListener != null && this.mRequestQueue.size() != 0 && !isCurrentlySending()) {
            this.mIsCurrentlySending.set(true);
            final EnqueuedRequest element = this.mRequestQueue.element();
            this.mRequestListener.onRequestPending(element.getRequest(), element.getResponseType()).onComplete(new Async.CompletionHandler() {
                public void handleComplete(Async<?> async) {
                    LiveAgentQueue.this.markAsComplete(element);
                }
            }).onError(new Async.ErrorHandler() {
                public void handleError(Async<?> async, Throwable th) {
                    LiveAgentQueue.this.scheduleRetryAttempt(element);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void next() {
        this.mIsCurrentlySending.set(false);
        attemptToSend();
    }

    /* access modifiers changed from: package-private */
    public void markAsComplete(EnqueuedRequest enqueuedRequest) {
        this.mRequestQueue.remove(enqueuedRequest);
        enqueuedRequest.getCallback().complete();
        log.trace("Success in sending {}", enqueuedRequest);
        next();
    }

    /* access modifiers changed from: package-private */
    public void scheduleRetryAttempt(EnqueuedRequest enqueuedRequest) {
        for (RequestFailedListener onRequestFailed : this.mRequestFailedListeners) {
            onRequestFailed.onRequestFailed(enqueuedRequest.getRequest(), enqueuedRequest.getCurrentAttempt());
        }
        enqueuedRequest.retry();
        log.warn("Error occurred while sending {}. Scheduling another attempt.", enqueuedRequest);
        this.mTimer.schedule();
    }

    public void onTimerElapsed() {
        next();
    }

    public static class Builder {
        private Context mContext;
        protected EnqueuedRequest.Factory mEnqueuedRequestFactory;
        protected HandlerManager.Builder mHandlerManagerBuilder;
        protected LiveAgentQueueRequestListener mLiveAgentQueueRequestListener;
        private int mMaxBackoffIterations = 5;
        private boolean mUseExponentialBackoff;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder queueRequestListener(LiveAgentQueueRequestListener liveAgentQueueRequestListener) {
            this.mLiveAgentQueueRequestListener = liveAgentQueueRequestListener;
            return this;
        }

        public Builder useExponentialBackoff(boolean z) {
            this.mUseExponentialBackoff = z;
            return this;
        }

        public Builder maxBackoffIterations(int i) {
            this.mMaxBackoffIterations = i;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder handlerManagerBuilder(HandlerManager.Builder builder) {
            this.mHandlerManagerBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder enqueuedRequestFactory(EnqueuedRequest.Factory factory) {
            this.mEnqueuedRequestFactory = factory;
            return this;
        }

        public LiveAgentQueue build() {
            Arguments.checkNotNull(this.mContext);
            if (this.mUseExponentialBackoff && this.mHandlerManagerBuilder == null) {
                this.mHandlerManagerBuilder = new BackoffTimer.Builder().maxIterations(this.mMaxBackoffIterations);
            } else if (this.mHandlerManagerBuilder == null) {
                this.mHandlerManagerBuilder = new Timer.Builder().timerDelayMs((long) this.mContext.getResources().getInteger(R.integer.salesforce_live_agent_message_retry_timeout_ms));
            }
            if (this.mEnqueuedRequestFactory == null) {
                this.mEnqueuedRequestFactory = new EnqueuedRequest.Factory();
            }
            return new LiveAgentQueue(this);
        }
    }
}
