package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForwardingRequestListener implements RequestListener {
    private static final String TAG = "ForwardingRequestListener";
    private final List<RequestListener> mRequestListeners;

    public ForwardingRequestListener(Set<RequestListener> set) {
        this.mRequestListeners = new ArrayList(set.size());
        for (RequestListener next : set) {
            if (next != null) {
                this.mRequestListeners.add(next);
            }
        }
    }

    public ForwardingRequestListener(RequestListener... requestListenerArr) {
        this.mRequestListeners = new ArrayList(requestListenerArr.length);
        for (RequestListener requestListener : requestListenerArr) {
            if (requestListener != null) {
                this.mRequestListeners.add(requestListener);
            }
        }
    }

    public void addRequestListener(RequestListener requestListener) {
        this.mRequestListeners.add(requestListener);
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onRequestStart(imageRequest, obj, str, z);
            } catch (Exception e2) {
                onException("InternalListener exception in onRequestStart", e2);
            }
        }
    }

    public void onProducerStart(String str, String str2) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerStart(str, str2);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerStart", e2);
            }
        }
    }

    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerFinishWithSuccess(str, str2, map);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerFinishWithFailure(str, str2, th, map);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerFinishWithFailure", e2);
            }
        }
    }

    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerFinishWithCancellation(str, str2, map);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerFinishWithCancellation", e2);
            }
        }
    }

    public void onProducerEvent(String str, String str2, String str3) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerEvent(str, str2, str3);
            } catch (Exception e2) {
                onException("InternalListener exception in onIntermediateChunkStart", e2);
            }
        }
    }

    public void onUltimateProducerReached(String str, String str2, boolean z) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onUltimateProducerReached(str, str2, z);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onRequestSuccess(imageRequest, str, z);
            } catch (Exception e2) {
                onException("InternalListener exception in onRequestSuccess", e2);
            }
        }
    }

    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onRequestFailure(imageRequest, str, th, z);
            } catch (Exception e2) {
                onException("InternalListener exception in onRequestFailure", e2);
            }
        }
    }

    public void onRequestCancellation(String str) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onRequestCancellation(str);
            } catch (Exception e2) {
                onException("InternalListener exception in onRequestCancellation", e2);
            }
        }
    }

    public boolean requiresExtraMap(String str) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            if (this.mRequestListeners.get(i).requiresExtraMap(str)) {
                return true;
            }
        }
        return false;
    }

    private void onException(String str, Throwable th) {
        FLog.e(TAG, str, th);
    }
}
