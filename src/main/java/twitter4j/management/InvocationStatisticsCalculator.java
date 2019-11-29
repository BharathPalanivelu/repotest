package twitter4j.management;

public class InvocationStatisticsCalculator implements InvocationStatistics {
    private long callCount;
    private long errorCount;
    private int index;
    private final String name;
    private long[] times;
    private long totalTime;

    public InvocationStatisticsCalculator(String str, int i) {
        this.name = str;
        this.times = new long[i];
    }

    /* access modifiers changed from: package-private */
    public void increment(long j, boolean z) {
        long j2 = 1;
        this.callCount++;
        long j3 = this.errorCount;
        if (z) {
            j2 = 0;
        }
        this.errorCount = j3 + j2;
        this.totalTime += j;
        long[] jArr = this.times;
        int i = this.index;
        jArr[i] = j;
        int i2 = i + 1;
        this.index = i2;
        if (i2 >= jArr.length) {
            this.index = 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public long getCallCount() {
        return this.callCount;
    }

    public long getErrorCount() {
        return this.errorCount;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public synchronized long getAverageTime() {
        int min = Math.min(Math.abs((int) this.callCount), this.times.length);
        long j = 0;
        if (min == 0) {
            return 0;
        }
        for (int i = 0; i < min; i++) {
            j += this.times[i];
        }
        return j / ((long) min);
    }

    public synchronized void reset() {
        this.callCount = 0;
        this.errorCount = 0;
        this.totalTime = 0;
        this.times = new long[this.times.length];
        this.index = 0;
    }

    public String toString() {
        return "calls=" + getCallCount() + "," + "errors=" + getErrorCount() + "," + "totalTime=" + getTotalTime() + "," + "avgTime=" + getAverageTime();
    }
}
