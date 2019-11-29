package com.android.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.b.b;
import com.android.b.n;
import com.android.b.t;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

public abstract class l<T> implements Comparable<l<T>> {
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private static final long SLOW_REQUEST_THRESHOLD_MS = 3000;
    private b.a mCacheEntry;
    private boolean mCanceled;
    private final int mDefaultTrafficStatsTag;
    private final n.a mErrorListener;
    /* access modifiers changed from: private */
    public final t.a mEventLog;
    private final int mMethod;
    private long mRequestBirthTime;
    private m mRequestQueue;
    private boolean mResponseDelivered;
    private p mRetryPolicy;
    private Integer mSequence;
    private boolean mShouldCache;
    private Object mTag;
    private final String mUrl;

    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* access modifiers changed from: protected */
    public abstract void deliverResponse(T t);

    /* access modifiers changed from: protected */
    public Map<String, String> getParams() throws a {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getParamsEncoding() {
        return DEFAULT_PARAMS_ENCODING;
    }

    /* access modifiers changed from: protected */
    public s parseNetworkError(s sVar) {
        return sVar;
    }

    /* access modifiers changed from: protected */
    public abstract n<T> parseNetworkResponse(i iVar);

    @Deprecated
    public l(String str, n.a aVar) {
        this(-1, str, aVar);
    }

    public l(int i, String str, n.a aVar) {
        this.mEventLog = t.a.f4632a ? new t.a() : null;
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mRequestBirthTime = 0;
        this.mCacheEntry = null;
        this.mMethod = i;
        this.mUrl = str;
        this.mErrorListener = aVar;
        setRetryPolicy(new d());
        this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(str);
    }

    public int getMethod() {
        return this.mMethod;
    }

    public l<?> setTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public Object getTag() {
        return this.mTag;
    }

    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    private static int findDefaultTrafficStatsTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return 0;
        }
        String host = parse.getHost();
        if (host != null) {
            return host.hashCode();
        }
        return 0;
    }

    public l<?> setRetryPolicy(p pVar) {
        this.mRetryPolicy = pVar;
        return this;
    }

    public void addMarker(String str) {
        if (t.a.f4632a) {
            this.mEventLog.a(str, Thread.currentThread().getId());
        } else if (this.mRequestBirthTime == 0) {
            this.mRequestBirthTime = SystemClock.elapsedRealtime();
        }
    }

    /* access modifiers changed from: package-private */
    public void finish(final String str) {
        m mVar = this.mRequestQueue;
        if (mVar != null) {
            mVar.b(this);
        }
        if (t.a.f4632a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        l.this.mEventLog.a(str, id);
                        l.this.mEventLog.a(toString());
                    }
                });
                return;
            }
            this.mEventLog.a(str, id);
            this.mEventLog.a(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mRequestBirthTime;
        if (elapsedRealtime >= SLOW_REQUEST_THRESHOLD_MS) {
            t.b("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    public l<?> setRequestQueue(m mVar) {
        this.mRequestQueue = mVar;
        return this;
    }

    public final l<?> setSequence(int i) {
        this.mSequence = Integer.valueOf(i);
        return this;
    }

    public final int getSequence() {
        Integer num = this.mSequence;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getCacheKey() {
        return getUrl();
    }

    public l<?> setCacheEntry(b.a aVar) {
        this.mCacheEntry = aVar;
        return this;
    }

    public b.a getCacheEntry() {
        return this.mCacheEntry;
    }

    public void cancel() {
        this.mCanceled = true;
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public Map<String, String> getHeaders() throws a {
        return Collections.emptyMap();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Map<String, String> getPostParams() throws a {
        return getParams();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Deprecated
    public byte[] getPostBody() throws a {
        Map<String, String> postParams = getPostParams();
        if (postParams == null || postParams.size() <= 0) {
            return null;
        }
        return encodeParameters(postParams, getPostParamsEncoding());
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    public byte[] getBody() throws a {
        Map<String, String> params = getParams();
        if (params == null || params.size() <= 0) {
            return null;
        }
        return encodeParameters(params, getParamsEncoding());
    }

    private byte[] encodeParameters(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    public final l<?> setShouldCache(boolean z) {
        this.mShouldCache = z;
        return this;
    }

    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    public a getPriority() {
        return a.NORMAL;
    }

    public final int getTimeoutMs() {
        return this.mRetryPolicy.a();
    }

    public p getRetryPolicy() {
        return this.mRetryPolicy;
    }

    public void markDelivered() {
        this.mResponseDelivered = true;
    }

    public boolean hasHadResponseDelivered() {
        return this.mResponseDelivered;
    }

    public void deliverError(s sVar) {
        n.a aVar = this.mErrorListener;
        if (aVar != null) {
            aVar.onErrorResponse(sVar);
        }
    }

    public int compareTo(l<T> lVar) {
        a priority = getPriority();
        a priority2 = lVar.getPriority();
        return priority == priority2 ? this.mSequence.intValue() - lVar.mSequence.intValue() : priority2.ordinal() - priority.ordinal();
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(getTrafficStatsTag());
        StringBuilder sb = new StringBuilder();
        sb.append(this.mCanceled ? "[X] " : "[ ] ");
        sb.append(getUrl());
        sb.append(SQLBuilder.BLANK);
        sb.append(str);
        sb.append(SQLBuilder.BLANK);
        sb.append(getPriority());
        sb.append(SQLBuilder.BLANK);
        sb.append(this.mSequence);
        return sb.toString();
    }
}
