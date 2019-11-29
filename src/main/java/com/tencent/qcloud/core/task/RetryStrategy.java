package com.tencent.qcloud.core.task;

public class RetryStrategy {
    private static final int BACKOFF_MULTIPLIER = 2;
    public static RetryStrategy DEFAULT = new RetryStrategy(1000, DEFAULT_MAX_BACKOFF, 3);
    private static final int DEFAULT_ATTEMPTS = 3;
    private static final int DEFAULT_INIT_BACKOFF = 1000;
    private static final int DEFAULT_MAX_BACKOFF = 2000;
    public static RetryStrategy FAIL_FAST = new RetryStrategy(0, 0, 0);
    private final int initBackoff;
    private final int maxAttempts;
    private final int maxBackoff;

    public RetryStrategy(int i, int i2, int i3) {
        this.initBackoff = i;
        this.maxBackoff = i2;
        this.maxAttempts = i3;
    }

    public int getNextDelay(int i) {
        return Math.min(this.maxBackoff, this.initBackoff * ((int) Math.pow(2.0d, (double) (i - 1))));
    }

    public boolean shouldRetry(int i, long j) {
        return i < this.maxAttempts;
    }
}
