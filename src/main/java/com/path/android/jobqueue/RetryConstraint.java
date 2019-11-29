package com.path.android.jobqueue;

public class RetryConstraint {
    public static final RetryConstraint CANCEL = new ImmutableRetryConstraint(false);
    public static final RetryConstraint RETRY = new ImmutableRetryConstraint(true);
    private boolean applyNewDelayToGroup = false;
    private Long newDelayInMs;
    private Integer newPriority;
    private boolean retry;

    public RetryConstraint(boolean z) {
        this.retry = z;
    }

    public boolean shouldRetry() {
        return this.retry;
    }

    public void setRetry(boolean z) {
        this.retry = z;
    }

    public Long getNewDelayInMs() {
        return this.newDelayInMs;
    }

    public void setNewDelayInMs(Long l) {
        this.newDelayInMs = l;
    }

    public Integer getNewPriority() {
        return this.newPriority;
    }

    public void setNewPriority(Integer num) {
        this.newPriority = num;
    }

    public static RetryConstraint createExponentialBackoff(int i, long j) {
        RetryConstraint retryConstraint = new RetryConstraint(true);
        retryConstraint.setNewDelayInMs(Long.valueOf(j * ((long) Math.pow(2.0d, (double) Math.max(0, i - 1)))));
        return retryConstraint;
    }

    public void setApplyNewDelayToGroup(boolean z) {
        this.applyNewDelayToGroup = z;
    }

    public boolean willApplyNewDelayToGroup() {
        return this.applyNewDelayToGroup;
    }

    private static class ImmutableRetryConstraint extends RetryConstraint {
        private static final String MESSAGE = "This object is immutable. Create a new one using the constructor.";

        public ImmutableRetryConstraint(boolean z) {
            super(z);
        }

        public void setRetry(boolean z) {
            throw new IllegalStateException(MESSAGE);
        }

        public void setNewDelayInMs(Long l) {
            throw new IllegalStateException(MESSAGE);
        }

        public void setNewPriority(Integer num) {
            throw new IllegalStateException(MESSAGE);
        }
    }
}
